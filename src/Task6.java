import java.io.*;
import java.util.*;

public class Task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(new File("Input.txt")));
        BufferedWriter write = new BufferedWriter(new FileWriter(new File("Output.txt")));
        ArrayList<Integer> data = new ArrayList();
        String r = read.readLine();
        while(r != null) {
            data.add(Integer.parseInt(r));
            r = read.readLine();
        }
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i) > 0)
                data.add(0, data.get(i));
                data.remove(i + 1);
        }
        for (Integer temp:
             data) {
            write.write(temp + '\n');
        }
    }
}