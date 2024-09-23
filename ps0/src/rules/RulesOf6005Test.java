import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
   
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
       
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
       
        assertFalse("Expected false: coursework not cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, false, false));
       
        assertTrue("Expected true: publicly available code, not implementation required and cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
       
        assertFalse("Expected false: publicly available code with implementation required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
       
        assertFalse("Expected false: code not available to others and not self-written",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
       
        assertTrue("Expected true: self-written code even if not required",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, false, false));
    }

    
    @Test
    public void testPubliclyAvailableButNotCited() {
        assertFalse("Expected false: publicly available code but not cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
    }

    @Test
    public void testPubliclyAvailableCitedButCoursework() {
        assertFalse("Expected false: publicly available code, cited, but written as coursework",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }
}
