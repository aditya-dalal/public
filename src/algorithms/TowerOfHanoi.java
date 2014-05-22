package algorithms;

public class TowerOfHanoi
{
    public static void main(String[] args)
    {
        String source = "A";
        String destination = "B";
        String temp = "C";
        towerOfHanoi(3, source, temp, destination);
    }

    private static void towerOfHanoi(int i, String source, String temp, String destination)
    {
        if(i == 0)
            return;
        towerOfHanoi(i-1, source, destination, temp);
        System.out.println("Move ring from " + source + " to " + destination + ".");
        towerOfHanoi(i-1, temp, source, destination);
    }

}
