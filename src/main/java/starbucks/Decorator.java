package starbucks;


/**
 * Write a description of class Decorator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Decorator implements IScreen
{
    private IScreen screen;

    Decorator(IScreen screen)
    {
        this.screen=screen;
    }

    public void touch(int x, int y)
    {
        screen.touch(x,y);
    }

    public String display()
    {
       return screen.display();
    }

    /**
     * Returns name of screen
     * @return Screen Name
     */
    public String name()
    {
        return screen.name();
    }

    /**
     * Navigate to next screen
     */
    public void next()
    {
        screen.next();
    }

    /**
     * Navigate to previous screen
     */
    public void prev()
    {
        screen.prev();

    }

    /**
     * Set next screen with action name
     * @param s Screen
     * @param n Action
     */
    public void setNext(IScreen s, String n )
    {
        screen.setNext(s,n);

    }

    /**
     * Set previous screen with action name
     * @param s Screen
     * @param n Action
     */
    public void setPrev(IScreen s, String n )
    {
        setPrev( s, n );

    }
    public boolean supportsLandscape()
    {
        return screen.supportsLandscape();
    }


}
