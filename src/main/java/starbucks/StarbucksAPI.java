package starbucks ;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

class StarbucksAPI{

	private String apiurl = "";
	private String apikey = "";
	private String register = "";
	private static final int okStatus=200;

	public StarbucksAPI() {
		Device theDevice = Device.getInstance();
		apiurl = theDevice.getProps(apiurl);
		apikey = theDevice.getProps(apikey);
		register = theDevice.getProps(register);

	}

    /**
     * Ping API call
     */
//	public void ping() {
	//	try {
	//		String body =
	//				Unirest.get(apiurl + "/ping")
	//					   .header("apikey", apikey)
	//					   .asString()
	//					   .getBody();
//			System.err.println(body);
//		} catch(Exception e) {
//			System.err.println(e);
//		}
//	}





	static class Card{
		public double balance = 0.00f;
		public String cardId = "000000000";
		public String cardCode = "000";


	    /**
	     * To String
	     * @return Card details String
	     */
		public String toString() {
			return "Card Id:[" + cardId + "] Code: [" +cardCode + "] Balance: [" + balance + "]" ;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public String getCardId() {
			return cardId;
		}
		public void setCardId(String cardId) {
			this.cardId = cardId;
		}
		public String getCardCode() {
			return cardCode;
		}
		public void setCardCode(String cardCode) {
			this.cardCode = cardCode;
		}


	}


	/**
	 * Set card
	 * @param cardnum Card Number String
	 * @return Card object Card
	 */
 //-----------------------------------------------------------------------------------------------------------------

	 public Card setCard() throws Exception
	 {
		 Device theDevice = Device.getInstance() ;
		 String apiurl = theDevice.getProps("apiurl") ;
		 String apikey = theDevice.getProps("apikey") ;

		 try {

				 HttpResponse<JsonNode> response = Unirest.post( apiurl + "/cards")
						 .header( "apikey", apikey )
						 .asJson() ;
					int status_code = response.getStatus();
			 		String status_text = response.getStatusText();
				 JSONObject json = response.getBody().getObject() ;
				 System.err.println( json.toString() ) ;
				 System.err.println("IN API->setCard");
				 System.err.println("SET CARD STATUS :" +String.valueOf(status_code) + " " + status_text);
				 Card card = new Card();
				 if(status_code!=okStatus)
	 				throw new Exception("Card Activation Failed!");
					card.cardId = json.getString("CardNumber");
					card.cardCode = json.getString("CardCode");
					card.balance = json.getDouble("Balance");


				 System.err.println( "New Card: " + card.cardId + "[" + card.cardCode + "] Balance: " + card.balance ) ;

				 return card;

		 } catch (Exception e) {

				 //System.err.println( e ) ;
				 throw new Exception(e);
		 }
 }













    /**
     * Activate Card
     * @param num Card number
     * @param code Card code
     * @return Card object Card
     */
	public Card activateCard(String num, String code) throws Exception{

		 Device theDevice = Device.getInstance() ;
	        String apiurl = theDevice.getProps("apiurl") ;

		try {
			String uri = apiurl + "/card/activate/" +num + "/" + code;
			HttpResponse<JsonNode> response = Unirest.post(uri).asJson();
			int status_code = response.getStatus();
			String status_text = response.getStatusText();
			System.err.println("CARD ACTIVATION STATUS :" +String.valueOf(status_code) + " " + status_text);
			JSONObject json = response.getBody().getObject();
			System.err.println( json.toString() );
			if(status_code!=okStatus)
				throw new Exception("Card Activation Failed!");
			Card card = new Card();
			card.cardId = json.getString("CardNumber");
			card.cardCode = json.getString("CardCode");
			card.balance = json.getDouble("Balance");


			return card;
		} catch(Exception e) {
			throw new Exception(e);
		}
	}


    /**
     * New Order
     * @param regid Register Id of store
     */
	public void newOrder(String regid) {
		Device theDevice = Device.getInstance() ;
        String apiurl = theDevice.getProps("apiurl") ;
        String apikey = theDevice.getProps("apikey") ;
		try {
			String drink = "Latte";
			String milk = "Whole";
			String size = "Grande";
			String payload = "{\"Drink\":\""+drink+"\", \"Milk\":\""+milk+"\",\"Size\": \""+size+"\"}";
			System.err.println("payload: "+payload);
			HttpResponse<JsonNode> response = Unirest.post( apiurl + "/order/register/" + regid)
					.header("apikey", apikey)
					.body(payload)
					.asJson();
			int status_code = response.getStatus();
			String status_text = response.getStatusText();
			System.err.println("NEW ORDER STATUS:" +String.valueOf(status_code) + " " + status_text);
			JSONObject json = response.getBody().getObject();
			System.err.println( json.toString() );
		} catch(Exception e) {
			System.err.println(e);
		}
	}

    /**
     * Get Order
     * @param regid Register Id of store
     */
	public void getOrder(String regid) {
		Device theDevice = Device.getInstance() ;
        String apiurl = theDevice.getProps("apiurl") ;
        String apikey = theDevice.getProps("apikey") ;
		try {
			HttpResponse<JsonNode> response = Unirest.get( apiurl + "/orer/register" + regid)
					.header("apikey", apikey)
					.asJson();
			int status_code = response.getStatus();
			String status_text = response.getStatusText();
			System.err.println("GET ORDER STATUS :" +String.valueOf(status_code) + " " + status_text);
			JSONObject json = response.getBody().getObject();
			System.err.println( json.toString() );
		} catch(Exception e) {
			System.err.println(e);
		}
	}


    /**
     * Clear order
     * @param regid Register Id of store
     */
	public void clearOrder(String regid) {
		Device theDevice = Device.getInstance() ;
        String apiurl = theDevice.getProps("apiurl") ;
        String apikey = theDevice.getProps("apikey") ;
		try {
			System.err.println("In clear order api");
			HttpResponse<JsonNode> response = Unirest.delete( apiurl + "/order/register/" + regid)
					.header("apikey", apikey)
					.asJson();
			int status_code = response.getStatus();
			System.err.println("Response: "+response);
			if(status_code == okStatus) {
				System.err.println("Active Order Cleared");
			}
			String status_text = response.getStatusText();
			System.err.println("CLEAR ORDER STATUS:" +String.valueOf(status_code) + " " + status_text);
			JSONObject json = response.getBody().getObject();
			System.err.println( json.toString() );
		} catch(Exception e) {
			System.err.println(e);
		}
	}



//-----------------------------------------------------------------------------------------------------------------------------



    /**
     * Pay For Order
     * @param regid Register Id of Store
     * @param cardnum Card Number
     * @return Card object Card
     */
		 public double payForOrder(String regId,String cardId) {


	 			Device theDevice = Device.getInstance() ;
	 			String apiurl = theDevice.getProps("apiurl") ;
	 			String apikey = theDevice.getProps("apikey") ;

	 			try {

	 					HttpResponse<JsonNode> response =
	 							Unirest.post( apiurl + "/order/register/"+regId+"/pay/"+cardId)
	 									.header( "apikey", apikey )
	 									.asJson() ;
	 					System.err.println("PAY FOR ORDER STATUS: "+response.getStatus());
	 					if(response.getStatus()==okStatus) {
	 						System.err.println("Register id : "+regId);
	 						this.clearOrder(regId);
	 					}
	 					JSONObject json = response.getBody().getObject() ;
	 					System.err.println( json.toString() ) ;

	 					double remainingBalance = json.getDouble( "Balance" )  ;
	 					//this.balance = new_bal ;
	 				return remainingBalance;
	 			} catch (Exception e) {

	 					System.err.println( e ) ;
						return 0.00f;
					}

}





    /**
     * Clear Orders API call
     */
	public void clearOrders() {
		Device theDevice = Device.getInstance() ;
		String apiurl = theDevice.getProps("apiurl") ;
		String apikey = theDevice.getProps("apikey") ;
		try {
			HttpResponse<JsonNode> response = Unirest.delete( apiurl + "/orders")
					.header("apikey", apikey)
					.asJson();
			int status_code = response.getStatus();
			String status_text = response.getStatusText();
			System.err.println("CLEAR ORDERS STATUS:" +String.valueOf(status_code) + " " + status_text);
			JSONObject json = response.getBody().getObject();
			System.err.println( json.toString() );
		} catch(Exception e) {
			System.err.println(e);
		}
	}

    /**
     * Clear Cards API call
     */
	public void clearCards() {
		Device theDevice = Device.getInstance() ;
		String apiurl = theDevice.getProps("apiurl") ;
		String apikey = theDevice.getProps("apikey") ;
		try {
			HttpResponse<JsonNode> response = Unirest.delete( apiurl + "/cards")
					.header("apikey", apikey)
					.asJson();
			int status_code = response.getStatus();
			String status_text = response.getStatusText();
			System.err.println("CLEAR CARDS STATUS:" +String.valueOf(status_code) + " " + status_text);
			JSONObject json = response.getBody().getObject();
			System.err.println( json.toString() );
		} catch(Exception e) {
			System.err.println(e);
		}
	}




}
