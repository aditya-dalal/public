package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

public class Enqueue implements Runnable
{
    Call call;
    CallQueue queue;

    public Enqueue(Call call, CallQueue handler)
    {
        this.call = call;
        this.queue = handler;
    }

    public void run()
    {
        queue.enqueueCall(call);
    }
}
