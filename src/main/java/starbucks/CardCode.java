package starbucks;


/** Cardcode Screen Component */
public class CardCode implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver,Iinput
{
    ITouchEventHandler nextHandler ;
    private int count = 0;
    private KeyPad kp; //42 addition
    protected static String cardNumber="";
    private static final int three=3;


    public CardCode(){
    kp=new KeyPad();//43 addition
      kp.attach(this);
    }
    /**
     * Touch Event Ignored by Passcode
     * @param x Touch X
     * @param y Touch Y
     */
    //touch(1,2),(2,2),(3,2) should shift focus
    public void touch(int x, int y)
    {

        kp.touch(x,y);//44 addition
        // if ( (x==1 && y==2)||(x==2 && y==2)||(x==3 && y==2) )
        //{
         //   System.err.println( "CardCode Touched at (" + x + ", " + y + ")" ) ;
        //}
        //else
       // {
         //   if ( nextHandler != null )
           //     nextHandler.touch(x,y) ;
        //}
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

         return "["+cardNumber+"]";
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
        {   if(cardNumber.length()>0)
            {cardNumber=removeLastCharacter(cardNumber);
            count--;}
            else{}

        }
        else
       {if(cardNumber.length()<three)
            {cardNumber+=key;
        count = c ;}}
    }
    public int getCount(){//a2 addition
    return count;
    }
    public void reset(){ //a3 addition
    count = 0;
    cardNumber="";
    }
    public String getNumber(){//a5 addition
    return cardNumber;
    }

    public static String removeLastCharacter(String str) {
   String result = null;
   if ((str != null) && (str.length() > 0)) {
      result = str.substring(0, str.length() - 1);
   }
   return result;
}
}
