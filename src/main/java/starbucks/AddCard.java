/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen
{
    private final static boolean lan=false;
    private boolean isNumeric=false;
    private boolean numberCheck=false;
    private KeyPad kp ;
    private CardCode cc ;

    private Spacer sp;
    private String strl="";
    private String strm="";
    private CardId ci ;
    private Iinput state;
    private boolean notZeros;
    private boolean checkmycall=false;

    private static final int two=2;
    private static final int three=3;
    private static final int nine=9;
    private static final float loadBalance=20.00f;
    StarbucksAPI api = new StarbucksAPI();
    public AddCard()
    {
      kp=new KeyPad();
       sp=new Spacer();
       cc=new CardCode();
       ci=new CardId();
       this.addSubComponent( ci ) ;
       this.addSubComponent( cc ) ;
      this.addSubComponent( sp ) ;
       this.addSubComponent( kp ) ;

       ((IKeyPadSubject)kp).attach( cc ) ;
       ((IKeyPadSubject)kp).attach( ci ) ;
       this.resetAttr();
       this.state = this.ci;
    }

    public void resetAttr(){
    cc.reset();
    ci.reset();
    this.kp.setCount(0);
    this.ci = new CardId();
    this.cc = new CardCode();
    this.state = this.ci;
    }

    public void touch(int x, int y) {

         if (y == two) {
            if (x == 1 || x == two || x == three)
                this.state = ci;
            else
                this.state.touch(x, y);
        } else if (x == two && y == three) {
            this.state = cc;
        } else {
            this.state.touch(x, y);
        }

    }

    public boolean checkAdditions(){
   boolean result1= ci.getId().matches("[0-9]+");
   boolean result2=cc.getNumber().matches("[0-9]+");
   if(result1==true && result2==true)
   {
       return true;
   }
   else
   return false;}

   public boolean totalNumbers(){
   int cardIddigits=ci.getCount();
   System.err.println("Value of cardIddigits: "+cardIddigits);
   int cardCodedigits=cc.getCount();
   System.err.println("Value of cardCodedigits: "+cardCodedigits);
   if((cc.getNumber().length()==three) &&  (ci.getId().length()==nine))
   {
     System.err.println("Returning True from totalNumbers()");
     return true;}
   else
   {
     System.err.println("Returning False from totalNumbers()");
     return false;}
   }

   public boolean zeroCheck(){
       //(cc.getNumber()=="000")||
   strl=ci.getId();
   int i=Integer.parseInt(strl);
   strm=cc.getNumber();
   int j=Integer.parseInt(strm);
   if(i==0 && j==0)
   return false;
   else if(i!=0 && j==0)
   return true;
   else if(i==0 && j!=0)
   return false;
   else
   return true;}

   public boolean otherCardsCheck()
   {
     String x=this.ci.getId();
     System.err.println("Value of X: "+x);
     String y=this.cc.getNumber();
     System.err.println("Value of Y: "+y);
     if ((x.equals("222222222")) && (y.equals("000")))
     {
       System.err.println("checking other cards");
       System.err.println("CARD NUMBER: "+ci.getId());
       System.err.println("CARD CODE: "+cc.getNumber());
       Card newcard = Card.getInstance();
       newcard.setCurrentCard(ci.getId(),cc.getNumber(),loadBalance);
       System.err.println("RETURNING TRUE FROM OTHERCARDSCHECK");
       return true;

      }

     else {
        System.err.println("RETURNING FALSE FROM OTHERCARDSCHECK");
       return false;}
   }

   /**
     * Frame Next Screen
     */
    public void next()
    {
        // << Change Me!  Hard Coded to Get a Random Card for Now >>

        AppController app = AppController.getInstance() ;

        if(ci.getCount()==0)
        {
          System.err.println("next pressed without entering digits");
          return;
                  }

        isNumeric=checkAdditions();
        numberCheck=totalNumbers();
        notZeros=zeroCheck();
        if((isNumeric==true && numberCheck==true) && notZeros==true )
        {


            starbucks.StarbucksAPI.Card card = null;
            try {
              System.err.println("Card ID: "+ci.getId());
              System.err.println("Card number: "+cc.getNumber());
 			card = api.activateCard(ci.getId(),cc.getNumber());
 		} catch (Exception e) {
      checkmycall=true;
 			System.err.println("Api call failed as this card doesn't exist");


 		}
    if(checkmycall){


    if(otherCardsCheck())
      {
      //AppController app = AppController.getInstance() ;
      this.cc.reset();
      this.ci.reset();
      this.kp.setCount(0);
      this.state=ci;
      System.err.println("Now it should go to main cards");
      app.setScreen( AppController.SCREENS.MY_CARDS_MAIN );

      }
      else {
    //otherCardsCheck(ci.getId(),cc.getNumber());
        resetAttr();
        System.err.println("CHECK OP FAILED RESETTING AND GOING TO ADD CARD");
        app.setScreen( AppController.SCREENS.ADD_CARD ) ;}
  }
 		if(card != null) {
	        Card newcard = Card.getInstance();
	        newcard.setCurrentCard(card.getCardId(), card.getCardCode(), card.getBalance());
	        this.cc.reset();
	        this.ci.reset();
	        this.kp.setCount(0);
	        this.state=ci;
	        app.setScreen( AppController.SCREENS.MY_CARDS_MAIN ) ;
	        }


        }
        else{
                    resetAttr();
                      this.state=ci;
                    }


    }

    public String name() {
        return "Add Card" ;
    }

    public String display() {
        return super.display();//32 addition
    }

    public void prev() {
       AppController app= AppController.getInstance();
       app.setScreen(AppController.SCREENS.SETTINGS);
   }
   public boolean supportsLandscape()
  {
      return lan;
  }


}
