package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

public class Receive implements Runnable
{
    private Employee employee;
    private Call call;
    private Handler handler;

    public Receive(Employee emp, Call call, Handler handler)
    {
        employee = emp;
        this.call = call;
        this.handler = handler;
    }

    public void run()
    {
        employee.receiveCall(call);
        handler.addToFreeList(employee);
    }
}
