public class AnalyzePerfReport
{
    public static void main(String[] args)
    {
        if(args.length != 2)
            System.out.println("Usage: java -jar analyzePerfReport.jar <comma sepaarated .jtl files as one parameter> <Request Name>");
    }
}
