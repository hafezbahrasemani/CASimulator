/**
 * DR class represents a Data Register that is a 16bits register
 * which holds some data
 *
 * @author hafez
 */
public class DR extends Register{

    /**
     * Constructor
     */
    public DR() {
        super();
    }

    /**
     * increment
     */
    public void increment(){

        int i = Integer.parseInt(String.valueOf(content), 2);

        i++;


        content.replace(0,16, Integer.toBinaryString(i));
    }


    public boolean isZero(){
        boolean b = true;

        for(int i = 0; i < content.length(); i++){
            if(content.charAt(i) == '1') b = false;
        }

        return b;
    }

}
