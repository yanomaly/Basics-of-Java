import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(new File("Input.txt")));
        BufferedWriter write = new BufferedWriter(new FileWriter(new File("Output.txt")));
        List<String> poem = new ArrayList();
        String r = read.readLine();
        while(r != null) {
            poem.add(r);
            r = read.readLine();
        }
//        poem.sort(new CompareLength());
//        poem.sort((o1, o2) -> o1.length() - o2.length());
        poem.sort(Comparator.comparingInt(String::length));
//        for (String temp:
//             poem) {
//            write.write(temp + '\n');
//        }
        poem.forEach(o -> {
            try {
                write.write(o + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        write.close();
        read.close();
    }
}

 class CompareLength implements Comparator<String> {

     @Override
     public int compare(String o1, String o2) {
         return o1.length() - o2.length();
     }
 }
