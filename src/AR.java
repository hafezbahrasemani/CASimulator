/**
 * This class represents a AR register and all operations we can
 * do on it such as clear, load, read (:
 *
 * @author hafez
 */
public class AR {
    int[] arRegister;


    /**
     * Constructor
     *
     */
    public AR() {
        arRegister = new int[12];
    }


    /**
     * getArRegister
     * @return the 12bits AR register
     */
    public int[] getArRegister() {
        return arRegister;
    }


    /**
     * load
     * @param arRegister the 12bits to be load in AR register
     */
    public void load(int[] arRegister) {
        this.arRegister = arRegister;
    }


    /**
     * readAddress
     * @return the decimal address of the binary content of arRegister
     */
    public int readAddress(){
        int address = 0;

        for(int i = 0; i < 12; i++){
            address += Math.pow(2,i) * arRegister[11 - i];
        }

        return address;
    }


    /**
     * clear
     */
    public void clear(){
        for(int i = 0; i < 12; i++){
            arRegister[i] = 0;
        }
    }

    /**
     * printContent
     * This method prints the content of the AR register
     */
    public void prinContent(){
        for (int i = 0; i < 12; i++){
            System.out.print(arRegister[11 - i]);
        }
    }
}
