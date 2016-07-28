package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

public class Dequeue implements Runnable
{
    private CallQueue queue;
    private Handler handler;

    public Dequeue(CallQueue callQueue, Handler handler)
    {
        this.handler = handler;
        queue = callQueue;
    }

    public void run()
    {
        while (true)
        {
            Call call = queue.getCallFromQueue();
            if(call != null)
            {
                Employee emp;
                while ((emp = handler.getFreeEmployee()) == null)
                {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                new Thread(new Receive(emp, call, handler)).start();
            }
        }
    }

}
