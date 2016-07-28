package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

import java.util.ArrayList;
import java.util.List;

public class CallCenter
{
    private List<Employee> employees;
    private CallQueue callQueue;
    private Handler handler;

    public CallCenter()
    {
        employees = new ArrayList<Employee>();
        callQueue = new CallQueue();
        handler = new Handler();
        startReceiver();
    }

    private void startReceiver()
    {
        new Thread(new Dequeue(callQueue, handler)).start();
    }

    public void addEmployee(Employee emp)
    {
        if(emp == null)
            return;
        employees.add(emp);
        handler.addToFreeList(emp);
    }

    public void call(Call call)
    {
        new Thread(new Enqueue(call, callQueue)).start();
    }
}

