/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

import java.util.HashMap;

/**
 * Authentication Proxy for App Controller
 */
public class Device implements IApp, IPinAuthObserver {

    private static Device theDevice = null;
    private boolean fourPin = true ;
    private boolean sixPin = false ;
    private String pin = "" ;
    private HashMap<String, String> props = new HashMap<String, String>() ;

    private IApp app ;
    private KeyPad kp ;
    private Passcode pc ;
    private Passcode6 pc6 ;
    private PinScreen ps ;
    private Spacer sp ;
    private boolean authenticated = false ;
    private PinEntryMachine pm ;

    public static final int three = 3 ;
    public static final int four = 4 ;
    public static final int six = 6 ;
    public static final int seven = 7 ;

    public static final int screen_frame_header = 3 ;
    public static final int portrait_screen_width = 15 ;
    public static final int portrait_screen_length = 10 ;
    public static final int landscape_screen_width = 32 ;
    public static final int landscape_screen_length = 6 ;

    public enum ORIENTATION_MODE {
        PORTRAIT, LANDSCAPE
    }

    private ORIENTATION_MODE device_orientation_state ;

    public ORIENTATION_MODE getDeviceOrientation() {
        return this.device_orientation_state ;
    }

    public void setPortraitOrientation() {
        this.device_orientation_state = ORIENTATION_MODE.PORTRAIT ;

    }

    public void setLandscapeOrientation() {
        this.device_orientation_state = ORIENTATION_MODE.LANDSCAPE ;

    }



    private Device() { }

    /** Debug Device State */
    public static void debug()
    {
        Device d = Device.getInstance() ;
        System.err.println( "============================================" ) ;
        System.err.println( "--------- D E V I C E  S T A T E  ----------" ) ;
        System.err.println( "============================================" ) ;
        System.err.println( "Pin Option    = " + d.getPinOption() ) ;
        System.err.println( "Stored Pin    = " + d.getPin() ) ;
        System.err.println( "Authenticated = " + d.isAuthenticated() ) ;
        System.err.println( "Orientation   = " + d.getDeviceOrientation() ) ;
        System.err.println( "============================================" ) ;
    }

    /** Get/Set Device Secured Enclave for Apps **/
    public String getProps(String key) {
        System.err.println("ERR:GET PROPS KEY");
        return props.get(key) ;
    }

    public void setProps(String key, String value) {
        System.err.println("ERR:SET PROPS");
        props.put(key, value) ;
    }

    /**
     * Get Current Auth State
     * @return Auth T/F
     */
    public String isAuthenticated() {
        return Boolean.toString( authenticated ) ;
    }

    /**
     * Return the current Pin Option:
     *  0 = User Chosed No Pin
     *  4 = User Chosed 4-digit Pin
     *  6 = User Chosed 6-digit Pin
     * @return Pin Option
     */
    public int getPinOption() {
        if ( fourPin )
            return four ;
        else if ( sixPin )
            return six ;
        else
            return 0 ;
    }

    /**
     * Get Current Pin
     * @return Pin
     */
    public String getPin() {
        return pin ;
    }


    /**
     * Set Pin
     * @param p New Pin
     */
    private void setPin( String p ) {
      System.err.println("ER: pin selected- "+p);
        pin = p ;
        int len = p.length() ;
        switch ( len ) {
            case 0:
                fourPin = false ;
                sixPin = false ;
                break;
            case four:
                fourPin = true ;
                sixPin = false ;
                break ;
            case six:
                fourPin = false ;
                sixPin = true ;
                break ;
            default:
                fourPin = false ;
                sixPin = false ;
                System.err.println("ER: pin added<- "+p);
                System.err.println("Default pin added<- "+p);
                this.pin="";
                break ;

        }
    }

    /**
     * Device Reset Pin
     */
    private void clearPin()
    {
        this.pin = "" ;
    }

    /**
     * Get Singleton Instance
     * @return Reference to Current Device Config (Create if none exists)
     */
    public synchronized static Device getInstance() {
        if (theDevice == null) {
              System.err.println("INIT:Device");
            return getNewInstance( "1234" ) ;
        }
        else
            return theDevice;
    }

    /**
     * Get New Instance
     * @return Reference to Device (Create New Singleton)
     */
    public synchronized static Device getNewInstance() {
        System.err.println("INIT:Device");
        return getNewInstance( "1234" ) ;
    }

    public synchronized static Device getNewInstance( String pin ) {
        System.err.println("INIT:Device");
        theDevice = new Device() ;

        theDevice.setPin( pin ) ;
        theDevice.setProps( "apiurl", "http://localhost:3000" ) ;
        theDevice.setProps( "apikey", "2742a237475c4703841a2bf906531eb0" ) ;
        theDevice.setProps( "register", "5012349" ) ;
        theDevice.startUp() ;

        return theDevice ;
    }

    public synchronized static Device getNewInstance( String pin, String url ) {
        if (theDevice == null) {
            theDevice = getNewInstance( "1234" ) ;
            theDevice.setProps( "apiurl", url ) ;
        }
        debug() ;
        return theDevice ;
    }

    /**
     * Device Starup Process.
     * Starts Up with Default 4-Pin Option
     */
    public void startUp()
    {
        System.err.println("ER: In Device startup");
        System.err.println("ER: Pin Selected "+this.getPin());
        kp = new KeyPad() ;
        pc = new Passcode() ;
        pc6 = new Passcode6() ;
        sp = new Spacer() ;
        ps = new PinScreen() ;
        pm = new PinEntryMachine() ;
        if(getPin().equals(""))
       {
           this.authenticated=true;
           app = AppController.getNewInstance() ;
       }
        pm.setPin(this.getPin());

        // setup the composite pattern
        if(this.getPinOption()==six){
       ps.addSubComponent( pc6 ) ;
       }
       else if(this.getPinOption()==four){
       ps.addSubComponent( pc ) ;

       }
        ps.addSubComponent( sp ) ;
        ps.addSubComponent( kp ) ;

        // setup the observer pattern
        if(this.getPinOption()==six){
        ((IKeyPadSubject)kp).attach( pc6 ) ;
        }
        else if(this.getPinOption()==four){
        ((IKeyPadSubject)kp).attach( pc )  ;

        }

        ((IKeyPadSubject)kp).attach( pm ) ;
        ((IPinAuthSubject)pm).registerObserver(this) ;

        // get app controller reference
        app = AppController.getNewInstance() ;

        // startup in portrait
        this.device_orientation_state = ORIENTATION_MODE.PORTRAIT ;
    }

    //keypad resetting
    public void resetPin()
    {
        this.authenticated=false;
        ps.setMessage();

        kp.setCount(0);
    }

    public void revert()
    {
      if(ps.getMessageStatus())
      ps.invertMessage();
    }

    /**
    * Switch to Landscape View
    */
    public void landscape() {
        if ( authenticated )
            app.landscape() ;
    }

    /**
     * Switch to Portait View
     */
    public void portrait() {
        if ( authenticated )
            app.portrait() ;
    }

    /**
     * User Touch at X,Y Coordinates
     * @param x X Coordinate
     * @param y Y Coordinate
     */
    public void touch(int x, int y) {
      System.err.println("DEVICE:TOUCH");
        if ( authenticated )
            app.touch(x, y) ;
        else
            ps.touch(x, y) ;
    }

    /**
     * Display Screen Contents to Terminal
     */
    public void display() {
        System.out.println( screenContents() ) ;
    }

    /**
     * Get Class Name of Screen
     * @return Class Name of Current Screen
     */
    public String screen() {
        if ( authenticated )
            return app.screen() ;
        else
            return ps.name() ;
    }

    /**
     * Get Screen Contents as a String
     * @return Screen Contents of Current Screen
     */
    public String screenContents()  {
        if ( authenticated ) {
            return app.screenContents() ;
        } else {
            if(!ps.getMessageStatus())
            {String out = "" ;
            out = "----------------\n" ;
            out += "   " + ps.name() + "  \n" ;
            out += "----------------\n\n\n" ;        //invalid pin display change
            //out += ps.display() ;
            StringBuffer buff = new StringBuffer();
            String[] ans = ps.display().split("\n");
            for(int i=0; i<ans.length;i++)
            {
              if(i<=1)
              {
                //out+=ans[i]+"\n";<<<<<
                buff.append(ans[i]+"\n");
              }

              else if(i>1 && i<=seven){

                //out+="  "+ans[i]+"\n";<<<<<<<<
                buff.append("  "+ans[i]+"\n");
              }

              else
              {

                //out+=ans[i];<<<<<<<<
                buff.append(ans[i]);
              }


            }
            out+=buff.toString();
            out += "\n\n\n----------------\n" ;
            return out ;}

            else
            {String out = "" ;
            out = "----------------\n" ;
            out += "   " + ps.name() + "  \n" ;
            out += "----------------\n" ;        //invalid pin display change
            //out += ps.display() ;
            StringBuffer buff = new StringBuffer();
            String[] ans = ps.display().split("\n");
            for(int i=0; i<ans.length;i++)
            {
              if(i<=three)
              {
                //out+=ans[i]+"\n";<<<<
                buff.append(ans[i]+"\n");
              }

              else if(i>three && i<=seven){
 //System.out.println(ans[i]);
                //out+="  "+ans[i]+"\n";
                buff.append("  "+ans[i]+"\n");
              }

              else
              {
                //out+=ans[i];<<<<<<<
                buff.append(ans[i]);
              }


            }
            out+=buff.toString();
            out += "\n\n\n----------------\n" ;
            return out ;}

        }
    }


    /**
     * Select a Menu Command
     * @param c Menu Option (A, B, C, E, or E)
     */
    public void execute( String c ) {
        if ( authenticated )
            app.execute( c ) ;
    }

    /**
     * Navigate to Previous Screen
     */
    public void prev() {
        if ( authenticated )
            app.prev() ;
    }

    /**
     * Navigate to Next Screen
     */
    public void next() {
        if ( authenticated )
            app.next() ;
    }

    /**
     * Receive Authenticated Event from Authenticator
     */
    public void authEvent() {
      System.err.println("DEVICE:AUTHORISED");
        this.authenticated = true ;
    }



}
