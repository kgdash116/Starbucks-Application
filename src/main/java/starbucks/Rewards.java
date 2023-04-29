/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Rewards Screen */
public class Rewards extends Screen
{
    private final static boolean lan=false;
    public Rewards()
    {

    }

    public void touch(int x, int y) {

      System.err.println("Keypad touched at : ("+x+","+y+")");
    }

    /**
     * Return Rewards Screen Contents
     * @return Rewards Screen Contents
     */
    public String display() {
        return "Make Every\nVisit Count" ;
    }

    public boolean supportsLandscape()
    {
        return lan;
    }


}
