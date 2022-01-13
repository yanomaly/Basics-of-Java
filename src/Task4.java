import java.util.Scanner;
import java.util.Stack;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        Stack<String> numb = new Stack();
        for (String temp: number.split("")) {
            numb.push(temp);
        }
        number = "";
        while(!numb.isEmpty())
            number += numb.pop();
        System.out.println(Integer.parseInt(number));
    }
}
