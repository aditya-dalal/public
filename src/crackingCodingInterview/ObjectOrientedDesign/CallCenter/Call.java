package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

public class Call
{
	private int callId;
	private static int id = 0;

	public Call()
	{
		callId = ++id;
	}

	public int id()
	{
		return callId;
	}

	public void receive() {}

    public void end() {}

}

