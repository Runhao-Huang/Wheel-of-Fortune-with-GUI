public class Player {
    private String name;
    private int playerNum;
    private int winningsTemp;
    private int winningsTotal;

    /*
    This is a constructor of a player that sets winningsTemp, winningsTotal, playerNum to be a default value.
     */
    public Player(int num) {
        winningsTemp = 0;
        winningsTotal = 0;
        playerNum = num;
    }

    /*
    This will set the name of a player.
     */
    public void setName(String n) {
        name = n;
    }

    /*
    This will set the Player's number.
     */
    public void setPlayerNum(int n) {
        playerNum = n;
    }

    /*
    This will set the winningsTemp to an amount.
     */
    public void setWinningsTemp(int wt) {
        winningsTemp = wt;
    }

    /*
    This will set the winningsTotal to an amount.
     */
    public void setWinningsTotal(int wt) {
        winningsTotal = wt;
    }

    /*
    This will return the Player's number.
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /*
    This will return the winningsTemp.
     */
    public int getWinningsTemp() {
        return winningsTemp;
    }

    /*
    This will return the name of the player.
     */
    public String getName() {
        return name;
    }

    /*
   This will return the winningsTotal.
    */
    public int getWinningsTotal() {
        return winningsTotal;
    }

    /*
    This will deduct the winningsTemp by 250 due to the vowel buying.
     */
    public void payForVowel() {winningsTemp -= 250;}

    /*
    This will add the winningsTemp by certain amount.
     */
    public void addMoneyForGameTemp(int val) {
        winningsTemp += val;
    }

    /*
    This will increase the moneyForGameFinal by certain amount.
     */
    public void increaseMoneyForGameFinal(int val)
    {
        winningsTotal += val;
    }

    /*
    This will reset the player's winningsTemp and winningsTotal to be 0.
     */
    public void resetPlayers()
    {
        winningsTemp = 0;
        winningsTotal = 0;
    }
}