/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Payments Screen */
public class Payments extends Screen
{
    private final static boolean lan=false;
    public Payments()
    {

    }

    public void touch(int x, int y) {

      System.err.println("Keypad touched at : ("+x+","+y+")");
    }

    /**
     * Return Payments Screen
     * @return Contents from Payments Screen
     */
    public String display() {
        return "Find Store\nEnable Payments" ;
    }

    public String name() {
        return "Payments" ;
    }

    public boolean supportsLandscape()
    {
        return lan;
    }



}
