/**
 * AC class represents the accumulator of our computer
 *
 */
public class AC extends Register{

    private int E;

    /**
     * Constructor of the PC class
     */
    public AC() {
        super();
        super.write(new StringBuilder("0000000000001011"));
    }

    /**
     * increment
     */
    public void increment(){

        int i = Integer.parseInt(String.valueOf(content), 2);

        i++;


        content.replace(0,16, Integer.toBinaryString(i));
    }



    /**
     * clear
     */
    public void clear(){
        super.write(new StringBuilder("0000000000000000"));
    }


    /**
     * complement
     * make the content of AC register complement
     */
    public void complement(){
        int i = (int) ((Math.pow(2, 16) - 1) - Integer.parseInt(
                        String.valueOf(content), 2));

        StringBuilder str = new StringBuilder(
                Integer.toBinaryString(i));

        super.write(str);
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

    /**
     * complementE
     *
     * complements the content of E
     */
    public void complementE(){
        if(E == 0) E = 1;
        else E = 0;
    }


    /**
     * circulateRight
     */
    public void circulateRight(){
        String str = content.substring(0,content.length() - 1);
        //System.out.println("ACREF:" + str);

        content.replace(0,content.length(),"");

        content.append(E);
        content.append(str);

        setE(Integer.parseInt(content.substring(14,15)));
    }

    /**
     * circulateLeft
     */
    public void circulateLeft(){
        String str = content.substring(1);
        System.out.println("ACLEF:" + str);

        content.replace(0,content.length(),"");


        content.append(str);
        content.append(E);

        setE(Integer.parseInt(content.substring(0,1)));
    }

    public boolean isZero(){
        boolean b = true;

        for(int i = 0; i < content.length(); i++){
            if(content.charAt(i) == '1') b = false;
        }

        return b;
    }


}
