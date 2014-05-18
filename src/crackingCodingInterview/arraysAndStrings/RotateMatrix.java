package crackingCodingInterview.arraysAndStrings;

public class RotateMatrix
{
    public static void main(String[] args)
    {
        int[][] image = {
                {21,22,23,24,25},
                {26,27,28,29,30},
                {31,32,33,34,35},
                {36,37,38,39,40},
                {41,42,43,44,45}
        };
        printImage(image);
        System.out.println();
        rotateImageBy90Degrees(image);
        printImage(image);
    }

    public static void rotateImageBy90Degrees(int[][] image)
    {
        int length = image.length;
        for(int layer = 0; layer < length / 2; layer++)
        {
            int last = length - 1 - layer;
            for(int i = layer; i < last; i++)
            {
                int offset = i - layer;
                int top = image[layer][i];
                image[layer][i] = image[last - offset][layer];
                image[last - offset][layer] = image[last][last - offset];
                image[last][last - offset] = image[layer + offset][last];
                image[layer + offset][last] = top;
            }
        }
    }

    public static void printImage(int[][] image)
    {
        for(int i = 0; i < image.length; i++)
        {
            for(int j = 0; j< image.length; j++)
            {
                System.out.print(image[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
