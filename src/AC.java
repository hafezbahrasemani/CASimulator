/**
 * AC class represents the accumulator of our computer
 *
 */
public class AC extends Register{

    /**
     * Constructor of the PC class
     */
    public AC() {
        super();
        super.write(new StringBuilder("0000111100001111"));
    }

    /**
     * increment
     */
    public void increment(){

        int i = Integer.parseInt(String.valueOf(super.content), 2);

        i++;


        super.content.replace(0,12, Integer.toBinaryString(i));
    }



    /**
     * clear
     */
    public void clear(){
        super.write(new StringBuilder("0000000000000000"));
    }


    /**
     * complement
     */
    public void complement(){
        char[] convertedChar = new char[content.length()];
        char[] originChar;

        originChar = String.valueOf(content).toCharArray();

        for(int i = 0; i < originChar.length; i++){
            if(originChar[i] == 0) convertedChar[i] = 1;
            else convertedChar[i] = 0;
        }

        StringBuilder str = new StringBuilder(String.valueOf(convertedChar));

        super.write(str);
    }
}
