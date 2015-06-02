import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            inputStream=new FileInputStream("input.txt");
            outputStream=new FileOutputStream("output.txt");
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

        //Scanner scn=new Scanner(inputStream); «¿ ŒÃÃ≈Õ“‹ ≈√Œ <3
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(outputStream);
        try {
            while(reader.ready()) {
                StringTokenizer tokenizer=new StringTokenizer(reader.readLine(), "|");

                if (!tokenizer.hasMoreTokens()) continue;
                String str = tokenizer.nextToken();
                str=FIChecker.checkWithRegExp(str);
                out.print(str+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.print(AgeChecker.checkWithRegExp(str)+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.print(PhoneChecker.checkWithRegExp(str)+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.println(MailChecker.checkWithRegExp(str));

            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        out.close();
    }
}
