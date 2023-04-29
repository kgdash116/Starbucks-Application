/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card Options Screen */
public class MyCardsOptions extends Screen
{
  private final static int seven=7 ;
  private final static int one=1 ;
  private final static int two=2 ;
  private final static int three=3 ;
  private final static boolean lan=false;
    public MyCardsOptions()
    {

    }

    public String display() {
        String result = "Reload\nRefresh\nMore Options\nCancel" ;
        return result ;
    }

    public void touch(int x, int y) {
        AppController app = AppController.getInstance() ;
        if ( x == one && y == seven )  {
            app.setScreen( AppController.SCREENS.MY_CARDS_MORE_OPTIONS ) ;
          }
        if ( x == two && y == seven ) {
            app.setScreen( AppController.SCREENS.MY_CARDS_MORE_OPTIONS ) ;
          }
        if ( x == three && y == seven ){
          app.setScreen( AppController.SCREENS.MY_CARDS_MORE_OPTIONS ) ;
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
