package starbucks;


/**
 * Write a description of class CardId here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

   public class CardId implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver,Iinput
{
    ITouchEventHandler nextHandler ;
    private static int count = 0;
    private KeyPad kp;
    protected static String cardId="";
    private static final int nine=9;

    public CardId(){
    kp=new KeyPad();
    kp.attach(this);}

    /**
     * Touch
     * @param x Touch X
     * @param y Touch Y
     */

    public void touch(int x, int y)
    {
        kp.touch(x,y);
        System.err.println( "CardCode Touched at (" + x + ", " + y + ")" ) ;
        }

    /**
     * Set Next Touch Handler
     * @param next Touch Event Handler
     */
    public void setNext( ITouchEventHandler next)
    {
        nextHandler = next ;
    }


    /**
     * Display "Echo Feedback" on Pins enterred so far
     * @return Passcode String for Display
     */
    public String display()
    {

         return "["+cardId+"]";
    }

    /**
     * Add Sub Component (Not used)
     * @param c Sub Component to Add
     */
    public void addSubComponent( IDisplayComponent c )
    {

    }



    /**
     * Key Event Update
     * @param c   Count of Keys So Far
     * @param key Last key Pressed
     */
    public void keyEventUpdate( int c, String key )
    {
        System.err.println( "Key: " + key ) ;
        if ( key.equals(" ") )
        /* nothing */ ;
        else if ( key.equals("X") )
        {


          if(cardId.length()>0)
            {cardId=removeLastCharacter(cardId,c);
            count=c;}
            else{
              this.kp.setCount(0);
              count=0;
            }

        }
        else
        {if(cardId.length()<nine)
            {cardId+=key;
        count = c ;}}
    }
    public int getCount(){//a1 addition
    return count;
    }

    public static void reset(){ //a4 addiotion
    count = 0;
    cardId="";
    }
    public String getId(){//a5 addition
    return cardId;
    }

    public static String removeLastCharacter(String str, int x) {
   String result = null;
   if ((str != null) && (str.length() > 0)) {
      result = str.substring(0, str.length() - 1);

   }
   return result;
}

}
