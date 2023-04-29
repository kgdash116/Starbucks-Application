# Starbucks Mobile App (Text UI) Project Journal

This journal illustrates a walkthrough of designing the Starbucks Mobile app, it also contains explanation of  different aspects of the mobile app, how the functionality is combined, what design patterns are employed and an overall methodology of the entire app. This journal also contains screenshots of the actual app and UML Diagrams for better understanding.


## Screens
The app contains seven screens, which are given below:
* PinScreen

*4 pin mode Fig.1*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197367849-7353a94e-e1c9-4f01-8561-014f205ae9e6.png)

*4 Pin Mode Digits entered Fig.2* <br><br>
![image](https://user-images.githubusercontent.com/78277453/197368289-cb67c8f6-2015-47f0-991b-1ce9e196a8a1.png)

*6 Pin Mode pin Fig.3*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369899-90744a35-e4ce-4da8-9a99-51684c9a8169.png)


*6 Pin Mode invalid pin Fig.4*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369906-4d99263e-dfc9-4e42-8cff-9f5eab7e7d8a.png)


The Pin screen is for the app Authentication, the PinScreen supports 4 Pin and 6 Pin entry. The pin Screen also has the Keypad attached to it through which digits are entered and they show up as asterisks. Figure 1 given above shows the four pin screen. If an invalid Pin is entered the app prompts the user that an invalid pin has been entered, by displaying an invalid pin message and erasing the entered digits as shown in figure 2. Figure 3 shows the Pinscreen if a 6 pin Authentication has selected.

------
* My Cards

*MyCards Portrait Fig.5*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197368424-91bc520e-3d97-4dae-97c5-88db834b69ec.png)

*MyCards landscape Fig.6*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369914-9108fd8d-ca73-41ce-99ed-d8abf64aeabc.png)


When the pin has been authenticated, My Card screen opens up, this screen displays the current balance of the app, this balance can be augmented by adding a Card. Through the Add card menu. When purchases are conducted at stores the balance gets deducted and gets updated on the My Card screen. The app only support one card at a time. My Card Screen supports two orientation modes: Portrait and Landscape as shown in Figure. We can also navigate to other screens by pressing giving command A,B,C,D or E.

-   A: Navigates to My Cards Screen itself.
-   B: Navigates to Payments screen.
-   C: Navigates to rewards screen.
-   D: Navigates to Find Store Screen.
-   E: Navigates to Settings screen.

Navigation to these screens is only possible when the screen is in portrait mode.
Additionally if the user wants, they can navigate to the **My Cards Pay** screen by touching (3,3), or My Cards Options by touching (2,4) if the current screen is My Cards.

-----

* My Card Pay

*My Cards Pay Portrait Fig.7*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197368690-0564da24-a74f-4a43-b263-67acbd8e3b25.png)

*My Cards Pay Landscape Fig.8*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369924-b29a001e-fd0f-4198-9b98-9cdf01f0a9ef.png)


The user can navigate to the My Cards Pay Screen by pressing (3,3) on the My Card Screen. This screen displays the current registered card and a **scan now** option which the user can press to pay for their order. This screen also supports portrait mode and landscape mode as shown in figure. The command navigation options are the same for this screen as well. But the navigation is only possible in portrait mode, the commands are ineffective in Landscape mode just like the My Card screen. For Payment the user can touch (2,2) or (3,2), after which an API call for a new order is made and subsequently payment is authorized for the order.

-   A: Navigates to My Cards Screen itself.
-   B: Navigates to Payments screen.
-   C: Navigates to rewards screen.
-   D: Navigates to Find Store Screen.
-   E: Navigates to Settings screen.

--------------------
* My Cards Options

*My Cards Options Fig.9*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197368604-a5d34008-fe48-490d-b9c7-02322f903819.png)


This screen can be accessed through My Cards screen only, it shows various options for the app, the screen is shown in Figure. A touch command of (1,7) or (2,7) or (3,7) navigates to the My Cards More Options screen. This screen does not support Landscape mode.

-   A: Navigates to My Cards Screen itself.
-   B: Navigates to Payments screen.
-   C: Navigates to rewards screen.
-   D: Navigates to Find Store Screen.
-   E: Navigates to Settings screen.

----------------------------------

* My Cards More Options

*My Cards More Options Screen Fig.10*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369573-803b0521-8b34-43f6-a3d3-0ea7622fea76.png)


My Cards More Options is accessed through My Cards Options screen only by touching (1,7) , (2,7) or (3,7). This screen also displays various options for the application.

-------------------------
* Payments

*Payments screen - Option B - Fig.11*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197368784-d05d49fb-87e3-4d7e-9e91-029d314b2962.png)

Payments screen displays options for the app, as shown in fig. It can be accessed by pressing B from any screen (provided they are in portrait mode).

----------------------------
* Rewards

*Rewards Screen - Option C - Fig.12*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197368899-28016240-af21-40a8-bc0a-0f7c4cb2623d.png)

Rewards screen displays options for the app, as shown in fig. It can be accessed by pressing C from any screen (provided they are in portrait mode).

---------------------
* Settings

*Settings Screen - Option E - Fig.13*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197368890-8bf95c24-3ce3-4a0f-893a-ce347d35dcbe.png)


The Settings screen displays various options for the app and is accessed by pressing E from any screen, provided they are in portrait mode. From this screen we can navigate to the Add card screen. The users can access the Add Card screen by pressing either (1,1) or (2,1) or (3,1). The screen is shown in Figure.

------------------------------
* Add Card

*Add Card Screen - Fig.14*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369551-71e46d50-e851-42af-ad82-9f488cf5dc6e.png)


*Add Card Screen with digits entered - Fig.15*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369948-634e3587-6e7b-4865-8336-e99c10111fd2.png)


This screen displays 3 fields, first field is the CardId that is for a 9 digit card ID number, the second field is for a 3 digit card code and the third field is the keypad. On startup of this screen the first two fields are blank and they fill up as digits are pressed. By default the first field i.e the 9 digit card code field is selected. This fields capacity is 9 digits, the users can shift to the second field for digit entry or vice versa by pressing (2,3). The max capacity for the second field is 3 digits. This screen also supports next and previous commands. If previous is entered the screen navigates to the Settings screen. The next command works two ways, if valid card credentials have been added and next is pressed, the card activates and the screen switches to My Card screen, else if invalid credentials have been entered, the entered fields are erased which prompts the user that an invalid card number and card code were entered.

--------------------------------------
* Find Store

*Store Screen - Option D - Fig.16*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197369104-49d1f268-11b5-47cc-89ed-fe06bfb8213c.png)

The Find Store displays a map and coordinates of stores. The user, to place a new order has to select the coordinates of the store they are at, which selects the store registration ID and the app navigates to **My Cards Pay** screen.


-------------------------------

## Design Patterns and UML Diagrams

Following Patterns are used in the design process of the Starbucks Mobile App.

-   Singleton
-   Composite
-   Decorator
-   Proxy
-   Chain of Responsibility
-   Composite
-   Observer

The following passages illustrate UML Diagrams that give information about the processes within the App and the design methodology used:

###### PinScreen

*UML Diagram for PinScreen Fig.17*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197370170-9cf58e5c-ddeb-460f-a3aa-5181c189f900.png)

The Diagram given above illustrates the binding of three Design patterns which are used to make the Pin Entry Authentication system of the Mobile App.
-   Observer Pattern
-   State Pattern
-   Composite (not shown)

*Observer Pattern for Passcode*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197370686-016ac634-99c5-4230-89c2-395971e39eba.png)



The keypad used for entering the digits is displayed on the PinScreen via the **Composite pattern** where the keypad is displayed as a component. The Pin Entry System is supported by the **State Pattern**. Where the PinEntryMachine can be in 7 different states. They number of keys pressed are updated in the Passcode or Passcode6 **Observer Pattern** Fig.18 and the states are traversed through the state classes. The states are given below:

-   NoPinDigits
-   OnePinDigit
-   TwoPinDigits
-   ThreePinDigits
-   FourPinDigits
-   FIvePinDigits
-   SixPinDigits

If the pin is valid the device Authentication is achieved and the status of authentication is relayed to the Device Controller Class through the **Observer Pattern**
where Device behaves as a Observer and the PinEntryMachine behaves as a subject.


*UML State Diagram for Pin States Fig.19*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197370566-8d63d3e8-bae7-4460-800c-0a0c99f7bfd8.png)

Figure 18 illustrates the Pin State Machine Diagram, as stated earlier the Device can attain 6 states, if during the course f Pin entry backspace is pressed the state goes to the  previous state, in the event of an Invalid Pin entry the NoPinDigits state is set. Exit points are present at the FourPinDigits and SixPinDigits states.


*UML Sequence Diagram for PinEntry Fig.20*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197370745-2741b6d9-8914-4449-b9cb-90d5a129c2e1.png)

The above sequence Diagram ilustrates how digits are entered iin to the Application for authentication (4-Pin Mode)

*UML Observer Pattern Authentication Fig.21*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197370969-b6ee19c4-5dde-47c9-bdbe-3174015d45c0.png)


-------------------------------------


###### AppController

The AppController is made from the Singleton Design Pattern, its UML notation is given below.

*UML notation APPCONTROLLER Fig.22*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197370897-a7499a4d-4076-4a87-808b-4882c25bf92a.png)

--------------------------------

###### Commands for Shifting Screens

The Application features 5 options mapping to 5 different Screens, the options are given below:

-   A: Navigates to My Cards Screen itself.
-   B: Navigates to Payments screen.
-   C: Navigates to rewards screen.
-   D: Navigates to Find Store Screen.
-   E: Navigates to Settings screen.

This feature was made by the Command Pattern, diagram of which is given below:

*UML Command Pattern Fig.23*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197371078-ee5135e8-e849-4592-b08a-7d7eb960908a.png)

When a command A,B,C,D or E is invoked the AppController switches the screen via the Frame to the mapped screen.

------------------------------

###### Component Display

Various fields and components are displayed on other screens through the **Composite Design Pattern**.



The KeyPad, Spacer, Passcode/Passcode6 are displayed on the PinScreen as components. Similarly, CardCode, CardId and keypad are displayed on the AddCard screen through the **Composite** Design Pattern. A UML Diagram depicting this pattern is shown below.

*UML Composite Pattern Fig.24*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197371369-d930e4d6-b65a-4073-bf45-6462307208b0.png)

----------------------------------

###### Orientation

A few Application screens support two Orientations Landscape and Portrait. The default view is Portrait.
All screen support Portrait orientation but only two screens **My Cards** and **My Cards Pay** support both Landscape and Portrait orientation. The Commands are not visible in Landscape mode and the only way to transition into another screen is to revert back to portrait mode and then proceed to another screen. The following UML Diagram displays the **Strategy Pattern** employed for this functionality.

*UML Composite Pattern Fig.25*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197371494-a7fa7f26-1051-4662-9e6c-232081a0ef69.png)

----------
###### Display

Some screen contents are **Left Justified** and  some screen contents are **Center Justified**. This is made possible through the Decorator Pattern. Following are the screen names with their support for reference.

-   My Cards - Center
-   My Cards Pay - Center
-   Add Card - Center
-   Settings Screen - Center
-   My Cards More Options - Left
-   My Cards Options - Left
-   Payments - Left
-   Rewards - Left
-   Store - Left

*UML Decorator Pattern Fig.26*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197371662-87892d00-2740-4226-80f7-0e8cf18dc205.png)

The diagram given above illustrates the Decorator Pattern used for screen display.

----------
###### Device

The Device is made from the Singleton Design Pattern, its UML notation is given below.

*UML notation Device Fig.27*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197371724-7cbf5f79-3f4c-4db8-8c9b-368d3c143327.png)

*UML Device Startup Sequence Diagram*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197373075-2cac5996-6dc8-4437-9ddb-050abe86c849.png)

The Diagram above illustrates the startup of the Device class.

*UML Sequence Diagram After Authentication*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197373103-edf4d8e2-70d3-49c0-9169-037f1714217a.png)
The Diagram above illustrates the application after pin authentication.


-------------

###### Touch

The touch function is a main feature of the Application that enables the user to interact with the Application , this touch functionality is made possible with the help of the Chain of Responsibility Design Pattern. The UML Diagram is given below

*UML Chain of Responsibility Fig.28*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197371887-261c50ad-1c72-4520-9c37-f6cb7458af6f.png)


###### Add Card

The Add Card screen is responsible for adding a Card into the app, the card has three main attributes:
-   Card Code (3 Digits)
-   Card Id (9 Digits)
-   Balance

when the App starts all of these attributes by default are set to 0. A user can add cards to the Mobile app if they are valid through the Add Card screen, The Add card screen has two empty fields on startup i.e (Card Id, Card Code). A keypad is attached to the Add card screen, and the user can use this to add digits in the card code or card id fields. From this screen the user can navigate to next or go to the settings screen by typing previous. A user's **next** request is only entertained if the card information entered by the user is valid.

If the card information is valid and a next request is made, an API call is made through the **Starbucks API** to check if card is valid, if the card is valid the card gets activated and the user is routed to the My cards Main screen with the new balance. If the card info entered is invalid the Card code and Card Id fields are erased , prompting the  user that an invalid card has been entered. The addition of digits to their respective fields is made possible through the **Observer pattern**, a UML diagram of which is shown below.

*UML Card Code and Card ID Observer pattern Fig.29*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197372151-1c6c87ad-331c-465d-a182-0b9185ae0855.png)

*Navigation to Add Card  Fig.30*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197372247-96bdd53a-c0d6-44a8-9348-d4055b54b04b.png)


The diagram above is the sequence diagram, illustrating the navigation from device authentication startup to Add Card Screen.

*Sequence Diagram to Add a Card*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197374372-1501ad20-68bb-4042-b869-c8f2d34d8712.png)



###### Card

The card is based on a singleton pattern, diagram of which is shown below:
*Card UML Fig.31*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197372316-20d2e3b8-951e-41a0-9d7f-3304ac94bcfc.png)

The Card is added to the Mobile Application via The add card screen, and the request is processed through the **Starbucks API** which makes API calls to the Application on the Card class's behalf. The implementation of this feature is done with the help of the Proxy pattern, diagram given below:

*UML Proxy Pattern Fig.32*<br><br>
![image](https://user-images.githubusercontent.com/78277453/197372831-c11fd825-8947-4310-9d11-241535216d98.png)



----------

## Complete UML Class Diagram

The complete UML Diagram of the Starbucks Mobile App is given below

![image](https://user-images.githubusercontent.com/78277453/197373403-3849b2be-06ca-4f8f-b7e6-8786773dfba2.png)
