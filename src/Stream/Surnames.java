package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Surnames {
    public List<String> surname (ArrayList<String> surname){
        return surname.stream().filter(x -> Pattern.compile("J.+").matcher(x).matches()).collect(Collectors.toList());
    }
}
