import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {CONSOLE_ID, FILE_IO, DB_IO, REST_IO}
	private List<EmployeePayrollData> employeePayrollList;
	
	public EmployeePayrollService() {}
	
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}
	
	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_ID);
	}

	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter Employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee Salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}
	
	public void writeEmployeePayrollData(IOService ioService) {
		if(ioService.equals(EmployeePayrollService.IOService.CONSOLE_ID)) {
			System.out.println("Writing Employee Payroll Data to Console\n" + employeePayrollList);
		}
		else if(ioService.equals(EmployeePayrollService.IOService.FILE_IO)) {
			new EmployeePayRollFileIOService().writeData(employeePayrollList);
		}
	}
	
	public void printData(IOService ioService) {
		if(ioService.equals(EmployeePayrollService.IOService.FILE_IO)) {
			new EmployeePayRollFileIOService().printData();
		}
	}

	public long countEntries(IOService ioService) {
		if(ioService.equals(EmployeePayrollService.IOService.FILE_IO)) {
			return new EmployeePayRollFileIOService().countEntries();
		}	
		return 0;
	}
}
