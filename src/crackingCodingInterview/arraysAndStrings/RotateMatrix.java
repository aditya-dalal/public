package crackingCodingInterview.arraysAndStrings;

public class RotateMatrix
{
    public static void main(String[] args)
    {
        int[][] image = {{0,1,1,1,1},
                {0,0,1,1,0},
                {0,0,1,0,1},
                {0,1,0,0,0},
                {0,1,0,1,1}};
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

    public static void rotate(int[][] arr){
        int length = arr[0].length-1;
        for(int layer = 0; layer <= length/2; layer++){
            int counter = 0;
            int n = length-layer;
            for(int j = layer; j < n; j++){
                int temp = arr[layer][layer+counter];
                arr[layer][layer+counter] = arr[layer+counter][n];
                arr[layer+counter][n] = arr[n][n-counter];
                arr[n][n-counter] = arr[n-counter][layer];
                arr[n-counter][layer] = temp;
                counter++;
            }
            System.out.println();
        }
    }

    public static void printImage(int[][] image)
    {
        for(int i = 0; i < image.length; i++)
        {
            for(int j = 0; j< image.length; j++)
            {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
