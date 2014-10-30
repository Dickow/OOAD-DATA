package domain;

public class EmployeeDTO {
	
	public enum JOB{PARTNER, RESEARCHER}
	
	private int employeeId; 
	private String name, password;
	private enum job{}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	};
	
	
 
	
	
}
