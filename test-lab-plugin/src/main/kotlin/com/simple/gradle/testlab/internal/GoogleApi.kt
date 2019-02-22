package com.simple.gradle.testlab.internal

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.storage.Storage
import com.google.api.services.testing.Testing
import com.google.api.services.testing.TestingScopes
import com.google.api.services.toolresults.ToolResults
import com.simple.gradle.testlab.model.GoogleApiConfig
import java.io.FileInputStream

internal class GoogleApi(val config: GoogleApiConfig) {
    companion object {
        private const val APPLICATION_NAME = "gradle-test-lab-plugin"
    }

    private val httpTransport by lazy { GoogleNetHttpTransport.newTrustedTransport() }
    val jsonFactory by lazy { JacksonFactory.getDefaultInstance() }

    val bucketName by lazy { config.bucketName ?: defaultBucketName() }

    val projectId by lazy {
        if (config.projectId != null) config.projectId else credential.serviceAccountProjectId
    }

    val credential by lazy {
        (config.serviceCredentials
            ?.let { GoogleCredential.fromStream(FileInputStream(it)) }
            ?: GoogleCredential.getApplicationDefault())
            .createScoped(listOf(TestingScopes.CLOUD_PLATFORM))
    }

    val storage by lazy {
        Storage.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(APPLICATION_NAME)
                .build()
    }

    val testing by lazy {
        Testing.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(APPLICATION_NAME)
                .build()
    }

    val toolResults by lazy {
        ToolResults.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(APPLICATION_NAME)
                .build()
    }
}

private fun GoogleApi.defaultBucketName(): String =
    toolResults.projects()
        .initializeSettings(config.projectId)
        .execute()
        .defaultBucket