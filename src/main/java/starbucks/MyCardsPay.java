/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card Pay Screen */
public class MyCardsPay extends Screen
{
    private final static boolean lan=true;
    Card card ;
    private final static int two=2 ;
    private final static int three=3 ;
    Store store=Store.getNewInstance();
    public MyCardsPay()
    {
        card = Card.getInstance() ;
    }

    /**
     * Get Screen Display Contents
     * @return Screen Contents
     */
    public String display() {
        String result = "[" + card.getCardId() + "]\n" + "\n\n" + "Scan Now" ;
        return result ;
    }

    /**
     * Touch (X,Y) Event
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        AppController app = AppController.getInstance() ;
        if ( x == three && y == three ) {
            app.setScreen( AppController.SCREENS.MY_CARDS_MAIN ) ;
        }
        if (( x == two && y == two )||(x == three && y == two)) {
            if(store.getId() != null) {
        	System.err.println("Store: "+store.getId());
        	String regid = store.getId();
        	StarbucksAPI api = new StarbucksAPI();
        	api.newOrder(regid);
          card.pay(regid) ;
        	}

        }
    }

    public String name() {
        return "My Cards" ;
    }
    public boolean supportsLandscape()
   {
       return lan;
   }


}
