package string;

public class WordsFrom2DArray
{
    static String[][] stringArray = {{"a", "b", "c"}, {"d", "e"}, {"f", "g", "h"}};

    public static void main(String[] args)
    {
        getWords("", 0);
    }

    private static void getWords(String str, int row)
    {
        int col = stringArray[row].length;

        for(int i = 0; i < col; i++)
            if(row < stringArray.length - 1)
                getWords(str + stringArray[row][i], row+1);
            else
                System.out.println(str + stringArray[row][i]);

    }
}