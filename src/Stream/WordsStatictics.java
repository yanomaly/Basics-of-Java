package Stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordsStatictics {
    Map<String, Integer> words(){
        String input = new Scanner(System.in).nextLine();
         ArrayList<String> data = new ArrayList<>();
         Matcher m = Pattern.compile("[a-zA-zа-яА-Я0-9]+").matcher(input);
         while(m.find())
             data.add(input.toLowerCase().substring(m.start(), m.end()));
         return data.stream().collect(Collectors.toMap(x -> x, x -> 1, (x, y) -> x + y)).entrySet().stream().sorted((x, y) -> -x.getValue().compareTo(y.getValue())).limit(10).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }
}
