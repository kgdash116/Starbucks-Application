/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card More Options Screen */
public class MyCardsMoreOptions extends Screen
{
    private final static boolean lan=false;
    public MyCardsMoreOptions()
    {
    }

    public String display() {
        String result = "Refresh\nReload\nAuto Reload\nTransactions" ;
        return result ;
    }

    public void touch(int x, int y) {

      System.err.println("Keypad touched at : ("+x+","+y+")");
    }

    public String name() {
        return "My Cards" ;
    }

    public boolean supportsLandscape()
   {
       return lan;
   }


}
