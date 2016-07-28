package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

public class Run
{
	public static void main(String[] args)
	{
		CallCenter cc = new CallCenter();
		Employee pm = new Employee("PM", Designation.PM);
		Employee tl = new Employee("TL", Designation.TL);
		Employee e1 = new Employee("e1", Designation.FRESHER);
		Employee e2 = new Employee("e2", Designation.FRESHER);

		cc.addEmployee(pm);
		cc.addEmployee(tl);
		cc.addEmployee(e1);
		cc.addEmployee(e2);

		for(int i = 0; i < 200; i++)
		{
			cc.call(new Call());
		}

	}
}

