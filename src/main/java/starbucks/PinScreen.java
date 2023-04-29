/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Pin Screen */
public class PinScreen extends Screen
{
  private String message=null;
  private boolean invalidPin=false;

    public PinScreen()
    {
    }

      public void touch(int x, int y) {

        System.err.println("PINSCREEN:TOUCH");
        super.touch(x,y);
      }

    public String name() {
        return "" ;
    }

    public void setMessage()
   {
       message="  Invalid Pin";
       invalidPin=true;
   }

   public String display()
    {
        if (this.message==null)
        {return super.display();}

        else
        {
            return this.message+"\n\n"+super.display();
        }

    }

  public void invertMessage()
  {
    this.message="";
  }

    public boolean getMessageStatus()
    {
        if(invalidPin)
        {return true;}

        else
        return false;

    }

}
