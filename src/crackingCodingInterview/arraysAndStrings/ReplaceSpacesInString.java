package crackingCodingInterview.arraysAndStrings;

public class ReplaceSpacesInString
{
    public static void main(String[] args)
    {
        String str = " ab c";
        String replace = "%20";

        System.out.println(replaceSpacesUsingInbuiltFunction(str, replace));
        System.out.println(replaceSpacesWith(str, replace));
    }

    public static String replaceSpacesUsingInbuiltFunction(String str, String replace)
    {
        return str.replace(" ", replace);
    }

    public static String replaceSpacesWith(String str, String replace)
    {
        StringBuilder result = new StringBuilder();
        for(char val : str.toCharArray())
        {
            if(val == ' ')
                result.append(replace);
            else
                result.append(val);
        }
        return result.toString();
    }
}
