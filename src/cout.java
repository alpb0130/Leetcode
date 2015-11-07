/**
 * Created by alpb0130 on 10/27/15.
 * <p>
 * Search Engine HW3: Experiment 2 query generator
 */

import java.io.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class cout {
    private static String[] weight;

    public static void main(String args[]) {

        String line = "";

        try {
            String parameterFileName = new String("/Users/alpb0130/Desktop/Search Engine/HW/HW3/test case/queries1.txt");
            File parameterFile = new File(parameterFileName);
            Scanner in = new Scanner(parameterFile);
            BufferedWriter output = new BufferedWriter(new FileWriter("/Users/alpb0130/Desktop/Search Engine/HW/HW3/test case/queries.txt"));
            line = in.nextLine();
            weight = line.split(" ");

            while (in.hasNext()) {
                line = in.nextLine();
                String[] part = line.split(":");
                String[] term = part[1].split(" ");
                System.out.print(part[0] + ": #AND ( ");
                output.write(part[0] + ": #AND ( ");
                for (int i = 0; i < term.length; i++) {
                    System.out.print("#WSUM ( " + DR(term[i]) + " ) ");
                    output.write("#WSUM ( " + DR(term[i]) + " ) ");
                }
                System.out.println(")");
                output.write(")\n");
            }
            in.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String DR(String term) {
        return weight[0] + " " + term + ".url " + weight[1] + " " + term + ".keywords " + weight[2] + " " + term + ".title " + weight[3] + " " + term + ".body " + weight[4] + " " + term + ".inlink";
    }
}


