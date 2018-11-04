import java.util.ArrayList;

/**
 * This is a class that represents the memory of a simple computer that
 * stores some data
 *
 * @author hafez
 */
public class Memory {
    int E;
    ArrayList<StringBuilder> memory;


    /**
     * Constructor
     *
     * initialize the memory and cell
     */
    public Memory() {
        memory = new ArrayList<>();
    }


    /**
     * write
     * @param newCell the 16bits cell to be written in memory
     * @param add the address of new written bits
     */
    public void write(StringBuilder newCell, int add){
        memory.add(add, newCell);
    }


    /**
     * read
     *
     * @param add the address to be read
     * @return the 16bits cell of the desired address
     */
    public StringBuilder read(int add){
        return memory.get(add);
    }

    /**
     * printData
     *
     * prints the data stored in memory
     */
    public void printData(){
        for(StringBuilder str: memory){
            System.out.println(str);
        }
    }

    /**
     * getE
     * @return the content of Flip-Flop E
     */
    public int getE() {
        return E;
    }

    /**
     * setE
     * @param e the new value to be written in E
     */
    public void setE(int e) {
        E = e;
    }
}
