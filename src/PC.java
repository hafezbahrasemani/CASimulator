/**
 * the PC class represents the Program Counter register of a mano computer
 *
 * This is a 12bits register
 *
 * @author hafez
 */
public class PC extends Register{

    /**
     * Constructor of the PC class
     */
    public PC() {
        super();


        super.write(new StringBuilder("000000000000"));
    }

    /**
     * increment
     */
    public void increment(){

        int i = Integer.parseInt(String.valueOf(super.content), 2);

        i++;


        super.content.replace(0,12, Integer.toBinaryString(i));
    }

}
