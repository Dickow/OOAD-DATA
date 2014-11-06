package domain;
public class EmployeeDTO {
	
	public enum JOB{PARTNER, RESEARCHER}
	
	private int employeeId; 
	private String name, password;
	private JOB job;
	
	
	
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
	}
	public void setJob(JOB job){
		this.job = job;
	}
	public JOB getJob(){
		return job;
	}
 
	
	
}
