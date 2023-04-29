/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** For Pin Digits State */
public class FourPinDigits implements IPinState
{
    IPinStateMachine machine ;
    Device d= Device.getInstance();
    private final static int four=4;
    /**
     * Constructor
     * @param  m Reference to State Machine
     */
    public FourPinDigits( IPinStateMachine m )
    {
        this.machine = m ;
    }

    /**
     * Backspace Event
     */
    public void backspace() {
        machine.setStateThreePinDigits(null) ;
    }

    /**
     * Digit Entry Event
     * @param digit Digit Value
     */
    public void number( String digit ) {
        System.err.println( "Digit: " + digit ) ;
        if(d.getPinOption()!=four) {
        machine.setStateFivePinDigits( digit ) ;
        }
        return ;
    }

    /**
     * Valid Pin Event
     */
    public void validPin() {
        return ;
    }

    /**
     * Invalid Pin Event
     */
    public void invalidPin() {
        machine.setStateNoPinDigits() ;
    }

}
