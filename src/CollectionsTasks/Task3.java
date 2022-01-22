package CollectionsTasks;

import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(new File("Input.txt")));
        BufferedWriter write = new BufferedWriter(new FileWriter(new File("Output.txt")));
        Deque<String> temp = new LinkedList();
        String r = read.readLine();
        while(r != null) {
            temp.push(r);
            r = read.readLine();
        }
        while (!temp.isEmpty())
            write.write(temp.pop() + '\n');
        write.close();
        read.close();
    }
}

