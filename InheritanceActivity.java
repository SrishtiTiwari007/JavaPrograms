package p2;

class Employee {
long emp_id,emp_phn;
String emp_name,emp_address;
double basicSalary,specialAllowance=250.80,hra=1000.50;
public Employee(long emp_id, long emp_phn, String emp_name, String emp_address) {
	super();
	this.emp_id = emp_id;
	this.emp_phn = emp_phn;
	this.emp_name = emp_name;
	this.emp_address = emp_address;
}
public void calculateSalary()
{
	double salary=(this.basicSalary + (this. basicSalary * this.specialAllowance/100) + ( this.basicSalary *this.hra/100));
	System.out.println("Salary :"+salary);
}
public void calculateTransportAllowance()
{
	double transportAllowance=(10/100)*this.basicSalary;
	System.out.println("Salary after transport allowance :"+(this.basicSalary-transportAllowance));
}
}
class manager extends Employee{

	public manager(long emp_id, long emp_phn, String emp_name, String emp_address,double basicSalary) {
		super(emp_id, emp_phn, emp_name, emp_address);
		this.basicSalary=basicSalary;
	}
	public void calculateTransportAllowance()
	{
		double transportAllowance=(15/100)*this.basicSalary;
		System.out.println("Salary after transport allowance :"+(this.basicSalary-transportAllowance));
	}
}
class trainee extends Employee{

	public trainee(long emp_id, long emp_phn, String emp_name, String emp_address,double basicSalary) {
		super(emp_id, emp_phn, emp_name, emp_address);
		this.basicSalary=basicSalary;
	}
	
}
class InheritanceActivity
{
	public static void main(String args[])
	{
		manager mg= new manager(126354,237844,"Peter","Chennai,India",65000);
		mg.calculateSalary();
		mg.calculateTransportAllowance();
		trainee tr=new trainee(29846,442085,"Jack","Mumbai,India",45000);
		tr.calculateSalary();
		tr.calculateTransportAllowance();
	}
}