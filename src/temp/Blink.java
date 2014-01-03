package temp;

public class Blink
{
    public static void main(String[] args) throws InterruptedException
    {
        for(int i = 1; i <= 10; i++)
        {
            if(i%2 == 0)
                System.out.print("\u0008.");
            else
                System.out.print("\u0008*");
            Thread.sleep(500);
        }
    }
}
