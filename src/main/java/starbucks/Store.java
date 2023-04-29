/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Store Screen */
public class Store extends Screen
{
    private static Store atStore = null ;
    private static Store store =null;
    private final static boolean lan=false;
    private String regId;
    private static final int one=1;
    private static final int two=2;
    private static final int three=3;
    private static final int four=4;
    private static final int five=5;
    private static final int six=6;
    private static final int seven=7;
   /**
     * Constructor
     */
    public Store() {

    }

    public synchronized static Store getNewInstance() {
    	atStore = new Store();
    	atStore.regId = "5012349"; //at Dub-c
    	return atStore;
    }

    public synchronized static Store getInstance() {
    	if (atStore==null){
        atStore = new Store();
    	atStore.setRegId("5012349"); //at Dub-c
    	return atStore;}
    	else
    	{ return store;}

    }

    public void setRegId(String id)
    {
        this.regId=id;
    }

    public void setId(String id)
    {  if(atStore!=null)
        {
        atStore.regId=id;}
    }

     public String getId()
    {
        return atStore.regId;
    }

    /**
     * Return Screen Contents
     * @return Map Screen Sample Content
     */
    public String display() {
        return "         X\n   X\n       X\n      X\n  X\n           X\n  X" ;


    }

    /**
     * Handle Touch Event -- Not Used.
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y)
    {
       AppController app=AppController.getInstance();
       System.err.println( "X: " + x + " Y: " + y ) ;


       if(x==three && y==two)
       {
           atStore.setId("5012349");
            System.err.println("Store ID selected"+getId());
           app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;

        }

       else if(x==three && y==seven)
       {
           atStore.setId("1287612");
           System.err.println("Store ID selected"+getId());
           app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;

        }
        else if(x==one && y==three)
       {
           atStore.setId("6498234");
           System.err.println("Store ID selected"+getId());
           app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;

        }

     else if(x==two && y==four)
       {
           atStore.setId("7812386");
           System.err.println("Store ID selected"+getId());
           app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;

        }
    else if(x==two && y==five)
       {
           atStore.setId("8723098");
           System.err.println("Store ID selected"+getId());
           app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;

        }
    else if(x==one && y==six)
       {
           atStore.setId("9621043");
           System.err.println("Store ID selected"+getId());
           app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;

        }
    else if(x==one && y==seven)
       {
           atStore.setId("1393478");
           System.err.println("Store ID selected"+getId());
           app.setScreen( AppController.SCREENS.MY_CARDS_PAY ) ;

        }
    else {
           app.setScreen( AppController.SCREENS.STORE ) ;
       }


    }

    public String name() {
        return "Find Store" ;
    }

    public boolean supportsLandscape()
    {
        return lan;
    }

}
