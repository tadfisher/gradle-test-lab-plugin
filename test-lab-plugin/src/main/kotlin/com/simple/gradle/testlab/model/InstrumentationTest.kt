package com.simple.gradle.testlab.model

import org.gradle.api.Action
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

/**
 * A test of an Android application that can control an Android component independently of its
 * normal lifecycle. Android instrumentation tests run an application APK and test APK inside the
 * same process on a virtual or physical AndroidDevice. They also specify a test runner class, such
 * as `AndroidJUnitTestRunner`, which can vary on the specific instrumentation framework chosen.
 */
@Suppress("UnstableApiUsage")
interface InstrumentationTest : TestConfig {
    /** Environment variables to set for the test (only applicable for instrumentation tests). */
    @get:Input val environmentVariables: MapProperty<String, String>

    /**
     * The `InstrumentationTestRunner` class. Optional; the default is determined by examining the
     * application's manifest.
     */
    @get:[Input Optional] val testRunnerClass: Property<String>

    /**
     * Test targets to execute. Optional; if empty, all targets in the module will
     * be ran.
     *
     * @see targetClass
     * @see targetMethod
     * @see targetPackage
     */
    @get:Input val testTargets: ListProperty<String>

    /**
     * Run each test within its own invocation with the
     * [Android Test Orchestrator](https://developer.android.com/training/testing/junit-runner.html#using-android-test-orchestrator).
     *
     * The orchestrator is only compatible with `AndroidJUnitRunner` 1.0 or higher.
     *
     * Using the orchestrator provides the following benefits:
     * - No shared state
     * - Crashes are isolated
     * - Logs are scoped per test
     *
     * Optional; if empty, the test will run without the orchestrator.
     */
    @get:[Input Optional] val useOrchestrator: Property<Boolean>

    /**
     * Configures [artifacts][InstrumentationArtifactsHandler] to fetch after completing the test.
     */
    fun artifacts(configure: Action<in InstrumentationArtifactsHandler>)

    /**
     * Adds a package target.
     *
     * @param packageName the fully-qualified package name
     */
    fun targetPackage(packageName: String)

    /**
     * Adds a class target.
     *
     * @param className the fully-qualified class name
     */
    fun targetClass(className: String)

    /**
     * Adds a method target.
     *
     * @param className the fully-qualified class name
     * @param methodName the method to execute
     */
    fun targetMethod(className: String, methodName: String)
}
