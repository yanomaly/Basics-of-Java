import java.io.*;
import java.util.*;

public class Task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(new File("Input.txt")));
        BufferedWriter write = new BufferedWriter(new FileWriter(new File("Output.txt")));
        String text = "", res = "", tmp = read.readLine();
        while(tmp != null) {
            text += tmp;
            tmp = read.readLine();
        }
        ArrayList<String> sep = new ArrayList(Arrays.asList(text.toLowerCase(Locale.ROOT).split("[\\ \\,\\.\\!\\?\\:\\;-]")));
        HashMap<String, Integer> result = new HashMap();
        for (String temp:sep) {
            if(!result.keySet().contains(temp))
                result.put(temp, 1);
            else
                result.put(temp, result.get(temp) + 1);
        }
        for (String temp:result.keySet())
            if(result.get(temp) > 1)
            res += temp + " " + result.get(temp) + '\n';
        write.write(res);
        write.close();
        read.close();
    }
}
