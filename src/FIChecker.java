
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIChecker {
    public static String checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("^[Р-п][р-џ]{2,20}[ ][Р-п][р-џ]{2,20}$");
        Matcher m = p.matcher(userNameString);
        String resultName="";

        if(!m.matches()) {
            Pattern ppro = Pattern.compile("^[Р-пр-џ]{2,20}[ ][Р-пр-џ]{2,20}$");
            Matcher mpro = ppro.matcher(userNameString);
            if(!mpro.matches()) {
                String aName="", bName="";
                Pattern pa = Pattern.compile("^([Р-пр-џ][р-џ]{2,20})");
                Matcher ma = pa.matcher(userNameString);
                while (ma.find()) {
                    aName += ma.group();
                    aName = aName.toLowerCase();
                    aName = aName.substring(0, 1).toUpperCase() + aName.substring(1);
                }
                String cutName;
                cutName=userNameString.substring(aName.length());
                Pattern pb = Pattern.compile("^([Р-п][р-џ]{1,19}[Р-пр-џ])$");
                Matcher mb = pb.matcher(cutName);
                while (mb.find()) {
                    bName += mb.group();
                    bName = bName.toLowerCase();
                    bName = bName.substring(0, 1).toUpperCase() + bName.substring(1);
                }
                if(!bName.equals(""))
                {resultName=aName+" "+bName;}

            }
            else {
                Pattern p3 = Pattern.compile("([Р-пр-џ]{3,21})");
                Matcher m3 = p3.matcher(userNameString);
                while (m3.find()) {
                    String PartName = "";
                    PartName += m3.group();
                    PartName = PartName.toLowerCase();
                    PartName = PartName.substring(0, 1).toUpperCase() + PartName.substring(1);
                    resultName += PartName+" ";
                }
            }
        }
        else {
            resultName=userNameString;
        }

        return resultName;

    }

}
