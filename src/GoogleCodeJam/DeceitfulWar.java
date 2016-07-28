package GoogleCodeJam;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeceitfulWar
{
    public static void main(String[] args)
    {
        BufferedWriter writer = null;
        try {
            Scanner scanner = new Scanner(new File("/tmp/input.in"));
            writer = new BufferedWriter(new FileWriter("/tmp/output.txt"));

            int testCases = scanner.nextInt();

            for(int i = 1; i <= testCases; i++)
            {
                int n = scanner.nextInt();
                List<Double> naomiBlocks = new ArrayList<Double>();
                List<Double> kenBlocks = new ArrayList<Double>();

                for(int index = 0; index < n; index++)
                    naomiBlocks.add(scanner.nextDouble());
                for(int index = 0; index < n; index++)
                    kenBlocks.add(scanner.nextDouble());
                Collections.sort(naomiBlocks);
                Collections.sort(kenBlocks);

                List<Double> warNaomiBlocks = new ArrayList<Double>(naomiBlocks);
                List<Double> warKenBlocks = new ArrayList<Double>(kenBlocks);

                int deceitfulCount = deceitfulWar(naomiBlocks, kenBlocks);
                int warCount = war(warNaomiBlocks, warKenBlocks);

                writer.write("Case #" + i + ": "+ deceitfulCount + " " + warCount + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int war(List<Double> naomiBlocks, List<Double> kenBlocks)
    {
        int naomiCount = 0;
        for (double naomiBlock : naomiBlocks)
        {
            if(naomiBlock > getKenBlockFor(naomiBlock, kenBlocks))
                naomiCount++;
        }
        return naomiCount;
    }

    private static double getKenBlockFor(double naomiBlock, List<Double> kenBlocks)
    {
        double selectedBlock = kenBlocks.get(0), kenBlock;
        for(int i = 0; i < kenBlocks.size(); i++)
        {
            kenBlock = kenBlocks.get(i);
            if(kenBlock > naomiBlock)
            {
                selectedBlock = kenBlock;
                kenBlocks.remove(i);
                break;
            }
        }
        return selectedBlock;
    }

    private static int deceitfulWar(List<Double> naomiBlocks, List<Double> kenBlocks)
    {
        int naomiCount = 0;
        for (int i = 0; i < naomiBlocks.size(); i++)
        {
            double naomiBlock = naomiBlocks.get(i);
            double kenBlock = kenBlocks.get(kenBlocks.size()-1);

            if(naomiBlock < kenBlocks.get(0))
            {
                if(naomiBlock > kenBlock)
                    naomiCount++;
                kenBlocks.remove(kenBlocks.size()-1);
            }
            else
            {
                naomiCount++;
                kenBlocks.remove(kenBlocks.get(0));
            }
        }
        return naomiCount;
    }

}
