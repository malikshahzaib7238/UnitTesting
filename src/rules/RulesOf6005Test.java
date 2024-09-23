package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method for various scenarios.
     */
    @Test
    public void testMayUseCodeInAssignment_CitedCode() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }
    
    @Test
    public void testMayUseCodeInAssignment_SelfWrittenCode() {
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        assertTrue("Expected true: self-written optional code",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, true, false));
    }

    @Test
    public void testMayUseCodeInAssignment_Coursework() {
        assertFalse("Expected false: course-work written code not cited",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, false, false));
        assertFalse("Expected false: un-cited code from a teammate",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, false, true));
    }
}
