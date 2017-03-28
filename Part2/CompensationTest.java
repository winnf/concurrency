import junit.framework.TestCase;
import java.util.*;

public class CompensationTest extends TestCase {
    protected void setUp(){
        StaffDetails staff = new StaffDetails();
        LabManagerDetails lab_manager = new LabManagerDetails();
        Compensation compensation = new Compensation();
        staff.setName("Winnie");
    }
    
    //Branch Coverage to check the role before granting access
    //one for passing (lab manager), one for failed (staff)
    public void testAllowAccess() {
        Role role = lab_manager.hasRole();
        Boolean result = compensation.access(lab_manager); 
        assertEquals(true, result);
    }
    
    public void testDenyAccess() {
        Role role = staff.hasRole();
        Boolean result = compensation.access(staff);
        assertTrue(false, result);
    }

    //statement coverage
    public void testCalculateYearlySalary1(){
        staff.setMonthlySalary(8000);

        double salary = compensation.calculateYearlySalary(staff);
        assertEquals(96000, salary);
    }

    //Condition coverage for whether there is no wage specified
    public void testCalculateYearlySalary2(){
        assertEquals("No wage specified", compensation.calculateYearlySalary(staff));
    }
    
    //Branch coverage to check if wage is a positive or negative number
    //negative number
    public void testCalculateMonthlySalary1(){
        staff.setWage(-50);
        assertEquals("Cannot input negative values", compensation.calculateMonthlySalary(staff));
    }

    //other condition for branch coverage for a positive number
    public void testCalculateMonthlySalary2(){
        staff.setWage(50);
        assertEquals(8000, compensation.calculateMonthlySalary(staff));
    }
}
