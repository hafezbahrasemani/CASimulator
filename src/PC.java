/**
 * the PC class represents the Program Counter register of a mano computer
 *
 * This is a 12bits register
 *
 * @author hafez
 */
public class PC {
    int[] pcRegister;

    /**
     * Constructor of the AR class
     */
    public PC() {
        pcRegister = new int[12];
    }


    /**
     * read
     *
     * This method reads the address stored in PC
     * @return the array containing address
     */
    public int[] read(){
        int[] content = new int[12];

        for(int i = 0; i < 12; i++){
            content[i] = pcRegister[i];
        }

        return content;
    }


    /**
     * write
     * @param data the array to be write in PC
     */
    public void write(int[] data){
        for(int i = 0; i < 12;i++){
            pcRegister[i] = data[i];
        }
    }

    @Override
    public String toString() {
        String str = null;

        for (int i = 0; i < 12; i++){
            str += pcRegister[11 - i];
        }

        return "PC: " + str;
    }
}
