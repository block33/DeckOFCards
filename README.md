# Getting Started

### How to run the project
1. Install IntelliJ
2. Clone the repo locally
3. Open the project in IntelliJ
4. Got to the **Edit Configurations** menu on the top
5. In the **Main class** section, select the main class which is called DeckofcardsApplication
6. Scroll down to **Profile** and add the follwing in the text box : *disableSecurity*
7. You should then be able to run the code in debug or normal mode.

### How to the test API
1. Open **postman** if you have it
2. Click on **Import**
3. Navigate to the projectRoot/postman/ 
4. Select both the **collection** and the **environment** files and import them.
5. Open the **collection** and select the **environment** 
6. Run the project locally. It should run on port **8080**
7. To test API correctly do the following steps:
   1. Run **/POST - Create game** to initialize a game session.
   2. Run **/POST - Create deck** to initialize a deck with 52 cards. This method can be called many times.
   3. Run **/POST - Add Player** to add a player that has my name constantly. You can run this method several times to add as many players as you like.
   4. Run **/POST - Deal cards** to deal cards to the last player added by default. If you want you can use the **/GET getPlayers** to retrieve all the players with their id and distribute card to your desired player.
   5. RUN **/POST - Shuffle cards** as many times as you like. It will shuffle the current game deck initialized.
   6. RUN **/GET - Remaining suits** to get the remaining suits in the current game deck.
   7. RUN **/GET - Players** to retrieve all the players in the current game session.
   8. RUN **/GET - Players Descending** to retrieve the players in desceding order by the total value in their hands.
   9. RUN **/GET - Player/playerId** to retrieve the information on a specific player including his hand.

### Incomplete
1. The API currently supports all endpoints except for one: *Get the count of each card (suit and value) remaining in the game deck sorted by suit ( hearts, spades, clubs, and diamonds) and face value from high value to low value (King, Queen, Jack, 10….2, Ace with value of 1)*
2. Tests are currently incomplete but the foundation is there. 
3. Error handling is implemented but some error testing might not return string, only the status code.

####**If you need my help in any way please do not hesitate to contact me at any time.
