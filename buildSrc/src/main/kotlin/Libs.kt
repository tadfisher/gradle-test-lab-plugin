import kotlin.String

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Update this file with
 *   `$ ./gradlew buildSrcVersions` */
object Libs {
    /**
     * https://developer.android.com/studio */
    const val com_android_tools_build_gradle: String = "com.android.tools.build:gradle:" +
            Versions.com_android_tools_build_gradle

    const val com_github_johnrengelman_shadow_gradle_plugin: String =
            "com.github.johnrengelman.shadow:com.github.johnrengelman.shadow.gradle.plugin:" +
            Versions.com_github_johnrengelman_shadow_gradle_plugin

    /**
     * https://github.com/google/google-api-java-client */
    const val google_api_client: String = "com.google.api-client:google-api-client:" +
            Versions.google_api_client

    const val google_api_services_storage: String = "com.google.apis:google-api-services-storage:" +
            Versions.google_api_services_storage

    const val google_api_services_testing: String = "com.google.apis:google-api-services-testing:" +
            Versions.google_api_services_testing

    const val google_api_services_toolresults: String =
            "com.google.apis:google-api-services-toolresults:" +
            Versions.google_api_services_toolresults

    const val com_gradle_plugin_publish_gradle_plugin: String =
            "com.gradle.plugin-publish:com.gradle.plugin-publish.gradle.plugin:" +
            Versions.com_gradle_plugin_publish_gradle_plugin

    /**
     * https://github.com/npryce/hamkrest */
    const val hamkrest: String = "com.natpryce:hamkrest:" + Versions.hamkrest

    /**
     * https://github.com/square/moshi */
    const val moshi_kotlin_codegen: String = "com.squareup.moshi:moshi-kotlin-codegen:" +
            Versions.com_squareup_moshi

    /**
     * https://github.com/square/moshi */
    const val moshi: String = "com.squareup.moshi:moshi:" + Versions.com_squareup_moshi

    const val de_fayard_buildsrcversions_gradle_plugin: String =
            "de.fayard.buildSrcVersions:de.fayard.buildSrcVersions.gradle.plugin:" +
            Versions.de_fayard_buildsrcversions_gradle_plugin

    /**
     * http://junit.org */
    const val junit: String = "junit:junit:" + Versions.junit

    const val org_gradle_kotlin_kotlin_dsl_gradle_plugin: String =
            "org.gradle.kotlin.kotlin-dsl:org.gradle.kotlin.kotlin-dsl.gradle.plugin:" +
            Versions.org_gradle_kotlin_kotlin_dsl_gradle_plugin

    const val org_jetbrains_dokka_gradle_plugin: String =
            "org.jetbrains.dokka:org.jetbrains.dokka.gradle.plugin:" +
            Versions.org_jetbrains_dokka_gradle_plugin

    const val org_jetbrains_kotlin_kapt_gradle_plugin: String =
            "org.jetbrains.kotlin.kapt:org.jetbrains.kotlin.kapt.gradle.plugin:" +
            Versions.org_jetbrains_kotlin_kapt_gradle_plugin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_annotation_processing_gradle: String =
            "org.jetbrains.kotlin:kotlin-annotation-processing-gradle:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_reflect: String = "org.jetbrains.kotlin:kotlin-reflect:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_sam_with_receiver: String = "org.jetbrains.kotlin:kotlin-sam-with-receiver:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_scripting_compiler_embeddable: String =
            "org.jetbrains.kotlin:kotlin-scripting-compiler-embeddable:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_stdlib_jdk8: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:" +
            Versions.org_jetbrains_kotlin

    const val org_jmailen_kotlinter_gradle_plugin: String =
            "org.jmailen.kotlinter:org.jmailen.kotlinter.gradle.plugin:" +
            Versions.org_jmailen_kotlinter_gradle_plugin
}
