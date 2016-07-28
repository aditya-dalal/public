package crackingCodingInterview.ObjectOrientedDesign.CallCenter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CallQueue
{
    private BlockingQueue<Call> callQueue;

    public CallQueue()
    {
        callQueue = new LinkedBlockingDeque<Call>();
    }

    public void enqueueCall(Call call)
    {
        try {
            callQueue.put(call);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Call getCallFromQueue()
    {
        Call call = null;
        try {
            call = callQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return call;
    }

}
