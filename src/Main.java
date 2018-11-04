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
            File file = new File("/home/hafez/Desktop/input.txt");

            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(file));

            String str;
            int i = 0;

            while ((str = bufferedReader.readLine()) != null){
                memory.write(new StringBuilder(str), i);
                i++;
            }
        }catch (IOException io){
            System.out.println(io.getMessage());
        }


        //The Cycle
        int counter = 0;

        //T0
        ar.write(pc.read());
        counter++;

        //T1
        ir.write(memory.read(ar.getDecimalAddress()));
        pc.increment();
        counter++;

        //T2
       int I = ir.getMode();


       String opcode =String.valueOf(ir.getOp());
       String hexContent = String.valueOf(ir.getHexadecimal());

       if (I == 0)
       {

           switch (hexContent){
               case "7800": ac.clear();

               case "7400":

               case "7200":

               case "7100":

               case "7080":

               case "7040":


               case "7020":

               case "7010":

               case "7008":

               case "7004":

               case "7002":

               case "7001":
           }
       }



        ar.write(memory.read(0));
        System.out.println(hexContent);
        System.out.println(ar.getMode());
        System.out.println(ar.getOp());

        System.out.println("AC:" + ac.read());
    }
}
