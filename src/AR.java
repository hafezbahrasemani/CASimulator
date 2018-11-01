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
        super(12);
    }


    /**
     * clear
     */
    public void clear(){
        for(int i = 0; i < 12; i++){
            super.register[i] = 0;
        }
    }
}
