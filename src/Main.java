import java.io.*;

public class Main {
    public static void main(String[] args){

        //Creating the empty registers
        Memory memory = new Memory();
        AR ar = new AR();
        PC pc = new PC();
        DR dr = new DR();
        AC ac = new AC();
        IR ir = new IR();
        TR tr = new TR();

        //Reading the instruction file

        try {
            File file = new File("/hafez/Downloads");

            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(file));

            String str;

            while ((str = bufferedReader.readLine()) != null){
                memory.write();
            }
        }catch (IOException io){
            System.out.println(io.getMessage());
        }
    }
}
