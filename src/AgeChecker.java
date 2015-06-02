import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgeChecker {
    public static String checkWithRegExp(String userAgeString){
        Pattern p = Pattern.compile("(\\d)");
        Matcher m = p.matcher(userAgeString);
        String resultAge="";
        while(m.find()) {
            resultAge+=m.group();
        }
        if(resultAge.length() >2)
        {resultAge="";}
        return resultAge;
    }
}
