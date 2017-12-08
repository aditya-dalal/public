package crackingCodingInterview.arraysAndStrings;

public class RotateMatrix
{
    public static void main(String[] args)
    {
        int[][] image = {
                {10,11,12,13,14,15,16},
                {20,21,22,23,24,25,26},
                {30,31,32,33,34,35,36},
                {40,41,42,43,44,45,46},
                {50,51,52,53,54,55,56},
                {60,61,62,63,64,65,66},
                {70,71,72,73,74,75,76}
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

    public static void rotate1(int[][] image) {
        int layer = 0, size = image.length;
        for(;layer < size/2; layer++) {
            int len = size-1-layer;
            for (int i = 0; i < len-layer; i++) {
                int temp = image[layer][layer + i];
                image[layer][layer + i] = image[len - i][layer];
                image[len - i][layer] = image[len][len - i];
                image[len][len - i] = image[layer + i][len];
                image[layer + i][len] = temp;
            }
            printImage(image);
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
