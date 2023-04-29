/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** My Cards Screen */
public class MyCards extends Screen
{
  private final static int four=4 ;
  private final static int two=2 ;
  private final static int three=3 ;
  private final static boolean lan=true;
    Card card ;


    public MyCards()
    {
        System.err.println("ERR:IN MYCARDS");
        card = Card.getNewInstance() ;

    }

    /**
     * Get Screen Display Contents
     * @return Screen Contents
     */
    public String display() {
        return card.getBalance() ;
    }

    /**
     * Touch (X,Y) Event
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
      System.err.println("Keypad touched at : ("+x+","+y+")");

        AppController app = AppController.getInstance() ;
        if ( x == three && y == three ) {

            app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;
        }
        if ( x == two && y == four ) {

            app.setScreen( AppController.SCREENS.MY_CARDS_OPTIONS ) ;}

    }

    public String name() {
        return "My Cards" ;
    }

    public boolean supportsLandscape()
    {
        return lan;
    }

}
