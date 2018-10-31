/**
 * This is a class that represents the memory of a simple computer that
 * stores some data
 *
 * @author hafez
 */
public class MainMemory {
    int[][] memory;


    /**
     * Constructor
     *
     * initialize the memory and cell
     */
    public MainMemory() {
        memory = new int[4096][16];
    }


    /**
     * write
     * @param newCell the 16bits cell to be written in memory
     * @param select the address of new written bits
     */
    public void write(int[] newCell, int select){

        for(int i = 0; i < 16; i++){
            memory[select][i] = newCell[i];
        }
    }

    /**
     * read
     *
     * @param select the address to be read
     * @return the 16bits cell of the desired address
     */
    public int[] read(int select){
        int[] readData = new int[16];

        for (int i = 0; i < 16; i++){
            readData[i] = memory[select][i];
        }

        return readData;
    }

    /**
     * select
     * @param selectPlace the 12bits address to be selected
     * @return the decimal beginning place of the address
     */
    public int select(int[] selectPlace){
        int sum = 0;

        for(int i = 11; i >= 0; i--){
            sum += selectPlace[11 - i] * Math.pow(2,i);
        }

        return sum;
    }

    /**
     * getMemory
     * @return the whole memory bits
     */
    public int[][] getMemory() {
        return memory;
    }
}
