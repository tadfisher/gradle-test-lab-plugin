package com.simple.gradle.testlab.internal

import com.google.api.services.testing.model.AndroidInstrumentationTest
import com.google.api.services.testing.model.FileReference
import com.google.api.services.testing.model.TestSpecification
import com.simple.gradle.testlab.model.InstrumentationTest
import com.simple.gradle.testlab.model.TestTargets
import org.gradle.api.Action
import javax.inject.Inject

open class DefaultInstrumentationTest @Inject constructor(name: String = "instrumentation")
    : AbstractTestConfig(name, TestType.INSTRUMENTATION), InstrumentationTest {

    override var testRunnerClass: String? = null
    override var useOrchestrator: Boolean? = null
    override val testTargets: TestTargets = DefaultTestTargets()

    override val requiresTestApk: Boolean = true

    override fun targets(configure: Action<in TestTargets>) {
        testTargets.apply { configure.execute(this) }
    }

    override fun buildTestSpecification(appApk: FileReference, testApk: FileReference?): TestSpecification =
            TestSpecification().setAndroidInstrumentationTest(
                    AndroidInstrumentationTest()
                            .setAppApk(appApk)
                            .setTestApk(testApk)
                            .setTestRunnerClass(testRunnerClass)
                            .setTestTargets(testTargets.targets.toList())
                            .setOrchestratorOption(useOrchestrator.toOrchestratorOption()))

    private fun Boolean?.toOrchestratorOption(): String = when (this) {
        null -> "ORCHESTRATOR_OPTION_UNSPECIFIED"
        false -> "DO_NOT_USE_ORCHESTRATOR"
        true -> "USE_ORCHESTRATOR"
    }
}
