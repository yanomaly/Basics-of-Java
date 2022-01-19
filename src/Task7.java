import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        String str = "(())";
        Stack<String> st = new Stack();
        Stack<String> sth = new Stack();
        int count = 0;
        for (String t: str.split("")) {
           st.add(t);
           count++;
        }
        if(count % 2 != 0)
            System.out.println("No");
        else{
            for (int i = 0; i < count/2; i++)
                sth.push(st.pop());
            if(new CompareStack().compare(st, sth) == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}

 class CompareStack implements Comparator<Stack <String>>{

     @Override
     public int compare(Stack<String> o1, Stack<String> o2) {
         int res = 0, size;
         if(o1.size() != o2.size())
             return -1;
         else {
             size = o1.size();
             for (int i = 0; i < size; i++) {
                 String o1p = o1.pop(), o2p = o2.pop();
                 if(o1p.compareTo("(") == o2p.compareTo(")"))
                     continue;
                 if(o1p.compareTo("[") == o2p.compareTo("]"))
                     continue;
                 if(o1p.compareTo("{") == o2p.compareTo("}"))
                     continue;
                 res--;
             }
             return res;
         }
     }
 }

