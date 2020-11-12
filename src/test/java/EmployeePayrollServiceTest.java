import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;

public class EmployeePayrollServiceTest {
	
	@Test
	public void givenEmployees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		EmployeePayrollData[] empArray = {
				new EmployeePayrollData(1, "Anik Chowdhury", 100000.0),
				new EmployeePayrollData(2, "Avijit Chowdhury", 200000.0),
				new EmployeePayrollData(3, "Arinjit Chowdhury", 300000.0),
		};
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(empArray));
		employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
	
	@Test
	public void givenFileOnPrintFromFile_ShouldMatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
	
	@Test
	public void givenFileReadingFromFile_ShouldMatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entries = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
}
