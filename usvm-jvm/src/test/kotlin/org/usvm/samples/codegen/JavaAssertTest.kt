package org.usvm.samples.codegen

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.usvm.samples.JavaMethodTestRunner
import org.usvm.test.util.checkers.eq
import org.usvm.util.isException

class JavaAssertTest : JavaMethodTestRunner() {
    @Test
    @Disabled("Unexpected lvalue org.usvm.machine.JcStaticFieldRef@41ccb3b9")
    fun testAssertPositive() {
        checkDiscoveredPropertiesWithExceptions(
            JavaAssert::assertPositive,
            eq(2),
            { _, value, result -> value > 0 && result.isSuccess && result.getOrNull() == value },
            { _, value, result -> value <= 0 && result.isException<java.lang.AssertionError>() }
        )
    }
}