/**
 * This class represents a AR register and all operations we can
 * do on it such as clear, load, read (:
 *
 * @author hafez
 */
public class AR extends Register{

    /**
     * Constructor
     */
    public AR() {
        super();
    }

    /**
     * getDecimalAddress
     *
     * @return the equivalent decimal address
     */
    public int getDecimalAddress(){
        return Integer.parseInt(String.valueOf(super.content),2);
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
