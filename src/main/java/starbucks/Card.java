/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;
import java.text.NumberFormat ;
import java.text.NumberFormat ;
import java.util.Locale;


/**
 * Card Class for Managing Card Balance & Transactions
 */
public class Card {

    private  double balance = 0.00f ;
    private  String cardId = "000000000" ;
    private  String cardCode = "000" ;
    StarbucksAPI api = new StarbucksAPI();
    private static final int successCode=200;

    private static Card theCard = null ;

    public synchronized static Card getNewInstance() {
        theCard = new Card();
        theCard.cardId="000000000" ;
          theCard.cardCode = "000" ;
          theCard.balance = 0.00f ;
        return theCard;
    }

    public synchronized static Card getInstance() {
        if (theCard == null) {
            theCard = new Card();
            theCard.setCard();
            return theCard;
        }
        else
            return theCard;
    }

    private Card() { }

    // << Change Me!  Hard Coded to Get a Random Card for Now >>
    public void setCard()
    {


      starbucks.StarbucksAPI.Card card = null;

      try {
        card = api.setCard();
        setCurrentCard(card.getCardId(), card.getCardCode(), card.getBalance());
        } catch (Exception e) {

          System.err.println("Card setting failed");}



    }



public void setCurrentCard(String cardNumber, String code, double balance) {
     if(theCard != null) {
       theCard.cardId = cardNumber ;
       theCard.cardCode = code ;
       theCard.balance = balance  ;
     }

   }
    public String getCardId() {
        return cardId ;
    }
    // personal addition
    public void setBalance(float num){
    this.balance=num;
    }
    public String getCardCode() {
        return cardCode ;
    }

    public String getBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(balance) ;
    }

    public void pay(String regId) {

      try
      {
            this.balance=api.payForOrder(regId,this.cardId);
            System.err.println("New balance after payment added");
      }
      catch(Exception e)
      {
        System.err.println(e);
        System.err.println("CARD:-> PAYMENT FAILED");
      }



    }

    public void display()
    {
        System.err.format( "Card ID: %s%n", cardId ) ;
        System.err.format( "Card Balance: $%4.2f%n", balance ) ;
    }
     public void resetCard() {
        this.cardId = "000000000";
        this.cardCode = "000";
        this.balance = 0.00f;
    }
}
