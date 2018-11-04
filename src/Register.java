/**
 * Register class is going to be the superclass of all registers
 * because of their common methods --> AR,IR,AC,PC,DR,TR
 *
 * @author hafez
 */
public class Register {

    StringBuilder content ;

    /**
     * Constructor
     */
    public Register(){
        content=new StringBuilder();
    }

    /**
     * read
     * @return the data that memory contains
     */
    public StringBuilder read (){
        return  content;

    }

    /**
     * write
     * @param data the data to be write on the contentister
     */
    public void write (StringBuilder data){

        content.replace(0,content.length(), String.valueOf(data));
    }

    /**
     * getMode
     * @return mode of the instruction(0 or 1)
     */
    public int getMode(){
        int mode;

        mode = Integer.parseInt(String.valueOf(content.subSequence(0,1)));

        return mode;
    }

    /**
     * getOp
     * @return the 3bits opcode that specifies the operation to be done
     */
    public StringBuilder getOp(){
        StringBuilder str = new StringBuilder();

        str.append(content.subSequence(1,4));

        return str;

    }

    /**
     * getAddress
     * @return the string that is the address part of the instruction
     */
    public StringBuilder getAddress(){
        StringBuilder add = new StringBuilder();

        add.append(content.subSequence(5,16));

        return add;
    }

    /**
     * getHexadecimal
     *
     * @return the equivalent hexadecimal of the register content
     */
    public StringBuilder getHexadecimal(){
        String hex;

        hex = Integer.toHexString(Integer.parseInt(
                String.valueOf(content.subSequence(0,16)),2));

        return new StringBuilder(hex);
    }
}
