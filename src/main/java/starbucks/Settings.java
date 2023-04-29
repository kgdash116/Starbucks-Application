/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** Settings Screen */
public class Settings extends Screen
{
  private final static int one=1 ;
  private final static int two=2 ;
  private final static int three=3 ;
  private final static boolean lan=false;

    public Settings()
    {

    }

    public String display() {
        String result = "Add Card\nDelete Card\nBilling\nPasscode\n\nAbout|Terms\nHelp" ;
        return result ;
    }

    public String name() {
        return "Settings" ;
    }

    public void touch(int x, int y) {
       AppController app = AppController.getInstance() ;
       if ( x == one && y == one ) {
            app.setScreen( AppController.SCREENS.ADD_CARD ) ;
        }
        if( x == two && y == one ){
            app.setScreen( AppController.SCREENS.ADD_CARD ) ;
        }
        if( x == three && y == one ){
            app.setScreen( AppController.SCREENS.ADD_CARD ) ;
        }

   }

   public boolean supportsLandscape()
    {
        return lan;
    }


}
