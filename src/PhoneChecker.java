import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneChecker {
    public static String checkWithRegExp(String userPhoneString){
        Pattern p = Pattern.compile("(\\d)");
        Matcher m = p.matcher(userPhoneString);
        String resultPhone="+";
        String AllPhone="";
        String curPhone;
        while(m.find()) {
            AllPhone+=m.group();
        }
        String firstPhone=AllPhone.substring(0,1);
        if(AllPhone.length() != 11 || (!firstPhone.equals("7") && !firstPhone.equals("8")))
        {resultPhone="";}
        else {
            resultPhone+=firstPhone;
            curPhone=AllPhone.substring(1,4);
            resultPhone+=" ("+curPhone+") ";
            curPhone=AllPhone.substring(4,7);
            resultPhone+=curPhone;
            curPhone=AllPhone.substring(7,9);
            resultPhone+="-"+curPhone;
            curPhone=AllPhone.substring(9,11);
            resultPhone+="-"+curPhone;
        }

        return resultPhone;
    }
}
