/**
 * Register class is going to be the superclass of all registers
 * because of their common methods --> AR,IR,AC,PC,DR,TR
 *
 * @author hafez
 */
public class Register {
    int[] register;

    /**
     * Constructor
     */
    public Register(int size){
        register = new int[size];
    }

    /**
     * read
     *
     * This method reads the data stored in register
     * @return the array containing data
     */
    public int[] read(){
        int[] content = new int[12];

        for(int i = 0; i < register.length; i++){
            content[i] = register[i];
        }

        return content;
    }


    /**
     * write
     * @param data the array to be write in register
     */
    public void write(int[] data){
        for(int i = 0; i < register.length;i++){
            register[i] = data[i];
        }
    }

    @Override
    public String toString() {
        String str = null;

        for (int i = 0; i < 12; i++){
            str += register[11 - i];
        }

        return str;
    }
}
