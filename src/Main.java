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


       String hexContent = String.valueOf(ir.getHexadecimal());
       String opCode = String.valueOf(ir.getOp());


       if ((I == 0) && (opCode.equals("111")))
       {
           //T3
           switch (hexContent){
               //Clear AC
               case "7800": ac.clear();

               //Clear E
               case "7400": ac.setE(0);
                            break;

               //Complement AC
               case "7200": ac.complement();
                            break;

               //Complement E
               case "7100": ac.complementE();
                            break;

               //Circulate right
               case "7080": ac.circulateRight();
                            break;

               //Circulate left
               case "7040": ac.circulateLeft();
                            break;
               //Increment AC
               case "7020": ac.increment();
                            break;

               //Skip if positive
               case "7010":{
                   if(ac.read().substring(0,1) == "0") pc.increment();
               }
               break;

               //Skip if negative
               case "7008":{
                   if(ac.read().substring(0,1) == "1") pc.increment();
               }
               break;

               //Skip if AC is zero
               case "7004":{
                   if(ac.isZero()) pc.increment();
               }
               break;

               //Skip if E is Zero
               case "7002": {
                   if(ac.getE() == 0) pc.increment();
               }
               break;

               //Halt Computer -> exit with code 3
               case "7001": System.exit(3);
           }
           counter++;
       }else if(!opCode.equals("111")){

           //T4
           switch (opCode){

               //And memory word to AC
               case "000":{
                   int i = Integer.parseInt(String.valueOf(ac.read()), 2);
                   int j = Integer.parseInt(String.valueOf(
                           memory.read(ar.getDecimalAddress())), 2);
                   ac.write(new StringBuilder(Integer.toBinaryString(i&j)));
                   counter++;
               }break;

               //Add memory word to AC
               case "001":{
                    int i = Integer.parseInt(String.valueOf(ac.read()), 2);
                    int j = Integer.parseInt(String.valueOf(
                            memory.read(ar.getDecimalAddress())), 2);

                    if(ac.content.length() == 16){
                        ac.write(new StringBuilder(Integer.toBinaryString(i+j)));
                    }else {
                        String str = Integer.toBinaryString(i+j);
                        ac.write(new StringBuilder(str.substring(1)));

                        ac.setE(Integer.parseInt(str.substring(0,1)));
                    }
                    counter+=2;
               }break;

               //Load memory word to AC
               case "010":{
                    ac.write(new StringBuilder(memory.read(ar.getDecimalAddress())));
                    counter++;
               }break;

               //Store content of AC in memory
               case "011":{
                    memory.write(ac.read(), ar.getDecimalAddress());
                    counter++;
               }break;

               //Branch unconditionally
               case "100":{
                    pc.write(ar.read());
                    counter++;
               }break;

               //Branch and save return address
               case "101":{
                    memory.write(pc.read(), ar.getDecimalAddress());
                    int i = Integer.parseInt(String.valueOf(ar.read()), 2);
                    i++;

                    pc.write(new StringBuilder(Integer.toBinaryString(i)));
                    counter+=2;
               }break;

               //Increment and skip if zero
               case "110":{
                    dr.write(memory.read(ar.getDecimalAddress()));
                    dr.increment();
                    memory.write(dr.read(),ar.getDecimalAddress());

                   counter+=3;
                    if(dr.isZero()){
                        pc.increment();
                        counter++;
                    }
               }break;
           }

       }


        System.out.println("Number of clocks:" + counter);
        System.out.println("AC:" + ac.read());
        System.out.println("AR:" + ar.read());
        System.out.println("DR: " + dr.read());
        System.out.println("IR:" + ir.read());
        System.out.println("PC: " + pc.read());
    }
}
