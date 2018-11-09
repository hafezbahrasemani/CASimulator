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




        //Reading the instruction file
        try {
            File file = new File("input.txt");

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

        //Number of memory instructions
        int size = memory.memory.size();

        for(int s = 0; s < size; s++) {
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
            String opCode = String.valueOf(ir.getOp());

            String hexContent = String.valueOf(ir.getHexadecimal());


            if ((I == 0) && (opCode.equals("111"))) {

                //T3
                switch (hexContent) {
                    //Clear AC
                    case "7800":{
                        ac.clear();
                        counter++;
                        break;
                    }

                    //Clear E
                    case "7400": {
                        ac.setE(0);
                        counter++;
                        break;
                    }

                    //Complement AC
                    case "7200":{
                        ac.complement();
                        counter++;
                        break;
                    }

                    //Complement E
                    case "7100":{
                        ac.complementE();
                        counter++;
                        break;
                    }

                    //Circulate right
                    case "7080":
                        ac.circulateRight();
                        break;

                    //Circulate left
                    case "7040": {
                        ac.circulateLeft();
                        counter++;
                        break;
                    }

                    //Increment AC
                    case "7020": {
                        ac.increment();
                        counter++;
                        break;
                    }

                    //Skip if positive
                    case "7010": {
                        if (ac.read().substring(0, 1) == "0") {
                            pc.increment();
                            counter++;
                        }
                        break;
                    }


                    //Skip if negative
                    case "7008": {
                        if (ac.read().substring(0, 1) == "1") {
                            pc.increment();
                            counter++;
                        }
                        break;
                    }


                    //Skip if AC is zero
                    case "7004": {
                        if (ac.isZero()) {
                            pc.increment();
                            counter++;
                        }
                        break;
                    }

                    //Skip if E is Zero
                    case "7002": {
                        if (ac.getE() == 0) {
                            pc.increment();
                            counter++;
                        }
                        break;
                    }

                    //Halt Computer -> exit with code 3
                    case "7001": {
                        counter++;
                        System.exit(3);
                    }
                }
            } else if (!opCode.equals("111")) {


                switch (opCode) {

                    //And memory word to AC
                    case "000": {
                        //T4
                        dr.write(memory.read(ar.getDecimalAddress()));
                        counter++;

                        int i = Integer.parseInt(String.valueOf(ac.read()), 2);
                        int j = Integer.parseInt(String.valueOf(dr.read()), 2);

                        //T5
                        ac.write(new StringBuilder(Integer.toBinaryString(i & j)));
                        counter++;
                    }
                    break;


                    //Add memory word to AC
                    case "001": {
                        //T4
                        dr.write(memory.read(ar.getDecimalAddress()));
                        counter++;

                        int i = Integer.parseInt(String.valueOf(ac.read()), 2);
                        int j = Integer.parseInt(String.valueOf(dr.read()), 2);

                        //T5
                        if (ac.content.length() == 16) {
                            ac.write(new StringBuilder(Integer.toBinaryString(i + j)));
                            counter++;
                        } else {
                            String str = Integer.toBinaryString(i + j);
                            ac.write(new StringBuilder(str.substring(1)));

                            ac.setE(Integer.parseInt(str.substring(0, 1)));
                            counter++;
                        }

                    }
                    break;

                    //Load memory word to AC
                    case "010": {
                        //T4
                        dr.write(memory.read(ar.getDecimalAddress()));
                        counter++;

                        //T5
                        ac.write(dr.read());
                        counter++;
                    }
                    break;

                    //Store content of AC in memory
                    case "011": {
                        //T4
                        memory.write(ac.read(), ar.getDecimalAddress());
                        counter++;
                    }
                    break;

                    //Branch unconditionally
                    case "100": {
                        //T4
                        pc.write(ar.read());
                        counter++;
                    }
                    break;

                    //Branch and save return address
                    case "101": {
                        //T4
                        memory.write(pc.read(), ar.getDecimalAddress());
                        ar.increment();
                        counter++;

                        //T5
                        pc.write(ar.read());
                        counter ++;
                    }
                    break;

                    //Increment and skip if zero
                    case "110": {
                        //T4
                        dr.write(memory.read(ar.getDecimalAddress()));
                        counter++;

                        //T5
                        dr.increment();
                        counter++;

                        //T6
                        memory.write(dr.read(), ar.getDecimalAddress());
                        if (dr.isZero()) {
                            pc.increment();

                        }
                        counter++;
                    }
                    break;
                }

            }

            System.out.println("Instruction number " + s);
            System.out.println("Number of clocks:" + counter);
            System.out.println("AC:" + ac.read());
            System.out.println("AR:" + ar.read());
            System.out.println("DR: " + dr.read());
            System.out.println("IR:" + ir.read());
            System.out.println("PC: " + pc.read());
        }
    }
}
