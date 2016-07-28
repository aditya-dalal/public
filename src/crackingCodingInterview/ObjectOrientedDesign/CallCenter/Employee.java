package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

public class Employee
{
	private String name;
	private int empId;
	private static int id = 0;
	private Designation designation;
    private boolean isFree;

	public Employee(String name, Designation des)
	{
		this.name = name;
		designation = des;
		empId = ++id;
	}

	public Designation designation()
	{
		return designation;
	}

	public String name()
	{
		return name;
	}

	public int empId()
	{
		return empId;
	}

    public void setFree(boolean status)
    {
        isFree = status;
    }

    public boolean isFree()
    {
        return isFree;
    }

	public void receiveCall(Call call)
	{
        System.out.println(name + " receiving call " + call.id());
        call.receive();
//        try {
//            Thread.sleep((new Random().nextInt(3) + 1) * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        call.end();
        System.out.println(name + " finished call " + call.id());
    }

}

