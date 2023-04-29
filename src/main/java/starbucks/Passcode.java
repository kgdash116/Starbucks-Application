/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Passcode Screen Component */
public class Passcode implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver
{
    ITouchEventHandler nextHandler ;
    private int count = 0;
    private static final int zero=0;
    private static final int one=1;
    private static final int two=2;
    private static final int three=3;
    private static final int four=4;

    /**
     * Touch Event Ignored by Passcode
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y)
    {
        if ( y==two )
        {
            System.err.println( "Passcode Touched at (" + x + ", " + y + ")" ) ;
        }
        else
        {
            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
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
        String value = "" ;
        switch ( count )
        {
            case zero: value = "  [_][_][_][_]" ; break ;
            case one: value = "  [*][_][_][_]" ; break ;
            case two: value = "  [*][*][_][_]" ; break ;
            case three: value = "  [*][*][*][_]" ; break ;
            case four: value = "  [*][*][*][*]" ; break ;
            default:value = "  [_][_][_][_]";
        }
         return value  ;
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
        System.err.println( "Passcode Key: " + key ) ;
        if(c!=four)
        {
        count = c ;
        }
        else {count=zero;}
    }
}
