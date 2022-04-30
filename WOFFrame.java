import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class WOFFrame extends JFrame implements ActionListener{

    private JLabel wofLabel;
    private JLabel puzzle;
    private JTextField hiddenPhrase;
    private JButton spinAndGuess;
    private JLabel spinResult;
    private JTextField spinResultText;
    private JButton buyVowel;
    private JButton solvePuzzle;
    private JTextField guessText1;
    private JLabel currentPlayerInfo;
    private JLabel player1Info;
    private JLabel player1MoneyGame;
    private JLabel player1MoneyMatch;
    private JLabel player2Info;
    private JLabel player2MoneyGame;
    private JLabel player2MoneyMatch;
    private JTextField player1MoneyGame1;
    private JTextField player1MoneyMatch1;
    private JTextField player2MoneyGame2;
    private JTextField player2MoneyMatch2;
    private JLabel numGame;
    private JLabel playerWin;
    private JButton reInitialize;
    private WheelPanel wheel;
    private JTable playerRecord;


    private String[] puzzles = {"gone with the wind", "avatar", "lassie come home", "wizard of oz", "last of the mohicans", "agony and the ecstasy", "ten commandants", "edward scissorhands"};
    private int[] spin = {0, 1, 100, 200, 300, 400, 500, 600};
    private Player player1 = new Player(1);
    private Player player2 = new Player(2);
    private Player currentPlayer;
    private int spinMoney;
    private int round = 1;
    private StringBuffer shownPhrase;
    private String hiddenSentence;
    private int guessDecision;
    private String currentGuess;
    private Player winPlayer;
    private String[] columnNames = {"Game","Winner"};
    private String[][] data = {{"Game","Winner"},
            {"Game 1", ""},
            {"Game 2", ""},
            {"Game 3", ""},
            {"Game 4", ""}};


    /*
    This is the constructor method of the JFrame WOFFrame.
     */
    public WOFFrame() {

        setTitle("Wheel Of Fortune Game");
        setLayout(new GridBagLayout());
        GridBagConstraints positionConst = new GridBagConstraints();

        /*The followings are the lay out your GUI objects in the frame.
        The column and row numbers are set by gridx and gridy*/
        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 0;
        positionConst.gridwidth = 2;
        wofLabel = new JLabel("WHEEL OF FORTUNE");
        wofLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        wofLabel.setBackground(Color.yellow);
        wofLabel.setOpaque(true);
        add(wofLabel, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 2;
        positionConst.gridwidth = 1;
        puzzle = new JLabel("The puzzle:");
        add(puzzle, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 3;
        positionConst.gridy = 2;
        hiddenPhrase = new JTextField(20);
        hiddenPhrase.setEditable(false);
        add(hiddenPhrase, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 4;
        positionConst.gridwidth = 1;
        spinResult = new JLabel("Spin Result:");
        add(spinResult, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 3;
        positionConst.gridy = 4;
        positionConst.gridwidth = 1;
        spinResultText = new JTextField(12);
        spinResultText.setEditable(false);
        add(spinResultText, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 3;
        positionConst.gridwidth = 2;
        spinAndGuess = new JButton("Spin the wheel and Guess a consonant");
        add(spinAndGuess, positionConst);
        spinAndGuess.setBackground(Color.GREEN);
        spinAndGuess.setOpaque(true);
        spinAndGuess.setEnabled(true);
        spinAndGuess.addActionListener(this);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 5;
        positionConst.gridwidth = 2;
        buyVowel = new JButton("Buy a vowel");
        add(buyVowel, positionConst);
        buyVowel.setEnabled(true);
        buyVowel.addActionListener(this);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 6;
        positionConst.gridwidth = 2;
        solvePuzzle = new JButton("Solve the puzzle");
        solvePuzzle.setEnabled(true);
        add(solvePuzzle, positionConst);
        solvePuzzle.addActionListener(this);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 7;
        positionConst.gridwidth = 2;
        guessText1 = new JTextField(26);
        guessText1.setText("Type in your guessed Consonant/Vowel/Puzzle.");
        guessText1.setEditable(false);
        add(guessText1, positionConst);
        guessText1.addActionListener(this);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 8;
        positionConst.gridwidth = 2;
        currentPlayerInfo = new JLabel();
        add(currentPlayerInfo, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 0;
        positionConst.gridy = 9;
        positionConst.gridwidth = 2;
        player1Info = new JLabel("Player 1");
        add(player1Info, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 4;
        positionConst.gridy = 9;
        positionConst.gridwidth = 2;
        player2Info = new JLabel("Player 2");
        add(player2Info, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 0;
        positionConst.gridy = 10;
        positionConst.gridwidth = 1;
        player1MoneyGame = new JLabel("Winnings in this game");
        add(player1MoneyGame, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 4;
        positionConst.gridy = 10;
        positionConst.gridwidth = 1;
        player2MoneyGame = new JLabel("Winnings in this game");
        add(player2MoneyGame, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 0;
        positionConst.gridy = 11;
        positionConst.gridwidth = 1;
        player1MoneyMatch = new JLabel("Winnings in this match");
        add(player1MoneyMatch, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 4;
        positionConst.gridy = 11;
        positionConst.gridwidth = 1;
        player2MoneyMatch = new JLabel("Winnings in this match");
        add(player2MoneyMatch, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 1;
        positionConst.gridy = 10;
        positionConst.gridwidth = 1;
        player1MoneyGame1 = new JTextField(7);
        player1MoneyGame1.setEditable(false);
        player1MoneyGame1.setText("$ "+ player1.getWinningsTemp());
        add(player1MoneyGame1, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 5;
        positionConst.gridy = 10;
        positionConst.gridwidth = 1;
        player2MoneyGame2 = new JTextField(7);
        player2MoneyGame2.setEditable(false);
        player2MoneyGame2.setText("$ "+ player2.getWinningsTemp());
        add(player2MoneyGame2, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 1;
        positionConst.gridy = 11;
        positionConst.gridwidth = 1;
        player1MoneyMatch1 = new JTextField(7);
        player1MoneyMatch1.setEditable(false);
        player1MoneyMatch1.setText("$ "+ player1.getWinningsTotal());
        add(player1MoneyMatch1, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 5;
        positionConst.gridy = 11;
        positionConst.gridwidth = 1;
        player2MoneyMatch2 = new JTextField(7);
        player2MoneyMatch2.setEditable(false);
        player2MoneyMatch2.setText("$ "+ player2.getWinningsTotal());
        add(player2MoneyMatch2, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 10;
        positionConst.gridwidth = 2;
        numGame = new JLabel("Game 1");
        add(numGame, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 11;
        positionConst.gridwidth = 2;
        playerWin = new JLabel();
        add(playerWin, positionConst);

        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 2;
        positionConst.gridy = 12;
        positionConst.gridwidth = 2;
        reInitialize = new JButton("Reinitialize");
        add(reInitialize, positionConst);
        reInitialize.setEnabled (false);
        reInitialize.addActionListener(this);

        //This is the GUI object of JTable, which is about the winning history.
        positionConst.insets = new Insets(10,10,10,10);
        positionConst.gridx = 0;
        positionConst.gridy = 4;
        playerRecord = new JTable(data,columnNames);
        add(playerRecord, positionConst);
        playerRecord.setEnabled (false);

        //This is the GUI object of a WheelPanel, which is extended from JPanel. This displays a wheel and can show the spun result.
        wheel = new WheelPanel();
        positionConst.gridx = 4;
        positionConst.gridy = 4;
        add(wheel, positionConst);


        //Here are the steps that I initialize the game for the first time.
        randomPlayer();
        hiddenSentence = puzzles[round - 1];
        initializeShownPhrase();
        turnStartPhase();


    }

    /*This ActionPerformed method can identify which object generated
    an event, and can thus operate accordingly by using multiple if-else statements*/
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());

        //This is the situation when Spin and guess a consonant button is clicked.
        if(e.getSource() == spinAndGuess)
        {
            int rslt = 0;
            rslt = doSpin();
            playerWin.setText("");

            //This is the situation when no bankrupt/lose a turn happen.
            if(rslt == 1)
            {
                hideButton(spinAndGuess);
                hideButton(buyVowel);
                hideButton(solvePuzzle);
                notification(guessText1);

                guessDecision = 1;
            }

        }
        //This is the situation when buy a vowel button is clicked.
        else if (e.getSource() == buyVowel)
        {
            playerWin.setText("");
            //This is determining whether the player has enough money for buying a vowel.
            if(currentPlayer.getWinningsTemp() >= 250) {
                hideButton(buyVowel);
                hideButton(spinAndGuess);
                hideButton(solvePuzzle);
                notification(guessText1);

                guessDecision = 2;
            }
            //If not, they will have to swap turns and restart the process.
            else
            {
                swapPlayer();
                turnStartPhase();
                JOptionPane.showMessageDialog(this,"You don't have enough money to buy a vowel.\nYour turn is over.");
            }
        }
        //This is the situation when solve a puzzle button is clicked.
        else if (e.getSource() == solvePuzzle)
        {
            playerWin.setText("");
            hideButton(buyVowel);
            hideButton(spinAndGuess);
            hideButton(solvePuzzle);
            notification(guessText1);

            guessDecision = 3;
        }
        //This is the situation when players enter their guessing into the guessText box.
        else if(e.getSource() == guessText1)
        {
            currentGuess = guessText1.getText();
            //Situation of guessing a consonant.
            if (guessDecision == 1)
            {
                guessAConsonant(currentGuess);
                notification(spinAndGuess);
                turnStartPhase();
            }
            //Situation of guessing a vowel.
            else if(guessDecision == 2)
            {
                guessAVowel(currentGuess);
                notification(spinAndGuess);
                turnStartPhase();
            }
            //Situation of guessing the puzzle.
            else if(guessDecision == 3)
            {
                int status = solveThePuzzle(currentGuess);
                //Wrong answer.
                if(status == 1)
                {
                    swapPlayer();
                    turnStartPhase();
                }
                //Correctly solved the puzzle.
                else
                {
                    round += 1;
                    playerRecord.setValueAt("Player" + currentPlayer.getPlayerNum(),round-1,1);
                    //When the puzzles run out and game should be over.
                    if(round > 4)
                    {
                        if(player1.getWinningsTotal() > player2.getWinningsTotal())
                        {
                            winPlayer = player1;
                        }
                        else
                        {
                            winPlayer = player2;
                        }
                        JOptionPane.showMessageDialog(this,"Match Summary:\nPlayer1 won in total of " + player1MoneyMatch1.getText() +"\n" +
                                "Player2 won in total of " + player2MoneyMatch2.getText()+"\nAs a result, Player" + winPlayer.getPlayerNum() + " won " +
                                " the match and got " + player1MoneyMatch1.getText());
                        hideJText(guessText1);
                        notification(reInitialize);
                        resetPlayerRecord();
                    }
                    //There are still puzzles left to be unsolved.
                    else
                    {
                        randomPlayer();
                        hiddenSentence = puzzles[round - 1];
                        initializeShownPhrase();
                        turnStartPhase();
                        player1MoneyGame1.setText("$ 0");
                        player2MoneyGame2.setText("$ 0");
                        numGame.setText("Game " + round);
                        player1.setWinningsTemp(0);
                        player2.setWinningsTemp(0);
                        updateWinningsTemp();
                        turnStartPhase();

                    }

                }
            }
        }
        //The situation when reInitialize button is clicked and the match should be restarted.
        else if(e.getSource() == reInitialize)
        {
            player1.resetPlayers();
            player2.resetPlayers();
            updateWinningsTemp();
            round = 1;
            numGame.setText("Game " + round);
            randomPlayer();
            hiddenSentence = puzzles[round - 1];
            initializeShownPhrase();
            turnStartPhase();

        }

    }


    //It randomly determine who goes first
    public void randomPlayer() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            currentPlayer = player1;
            notifyCurrentPlayer();
        }
        else {
            currentPlayer = player2;
            notifyCurrentPlayer();
        }
    }


    //It randomly decide the value of the spin result and call the wheel panel that displays the result graphically.
    public int doSpin() {
        Random rand = new Random();
        spinMoney = spin[rand.nextInt(8)];
        wheel.spinTheWheel(spinMoney);

        //Bankrupt will make the winningTemp to be 0 and lose a turn.
        if(spinMoney == 0)
        {
            spinResultText.setText("Bankrupt");
            currentPlayer.setWinningsTemp(0);
            updateWinningsTemp();
            swapPlayer();
            turnStartPhase();
            return -1;
        }
        //Lose a turn will swap the players.
        else if(spinMoney == 1)
        {
            spinResultText.setText("Lose a Turn");
            swapPlayer();
            turnStartPhase();
            return -1;
        }
        //It displays the result on the frame.
        else
        {
            spinResultText.setText(String.valueOf(spinMoney));
            hideButton(spinAndGuess);
            notification(buyVowel);
            notification(solvePuzzle);

            return 1;
        }

    }

    /*
    This is a method that forms a initial shown phrase using underline and space.
     */
    public void initializeShownPhrase() {
        shownPhrase = new StringBuffer();
        //The loop looks into every element of the sentence and change all letters into _.
        for (int i = 0; i < hiddenSentence.length(); ++i) {
            if (Character.isLetter(hiddenSentence.charAt(i))) {
                shownPhrase.append("_");
            } else {
                shownPhrase.append(" ");
            }
        }
        hiddenPhrase.setText(shownPhrase.toString());
    }

    //This method will make a JButton's background to be green and allows it to be clicked.
    public void notification(JButton bnt)
    {
        bnt.setBackground(Color.GREEN);
        bnt.setOpaque(true);
        bnt.setEnabled(true);
    }

    //This method will make a JButton's background to be default and doesn't allow it to be clicked.
    public void hideButton (JButton bnt)
    {
        bnt.setBackground(new JButton().getBackground());
        bnt.setOpaque(true);
        bnt.setEnabled(false);
    }

    //This method will make a JTextField's background to be green and allows it to be edited.
    public void notification(JTextField bnt)
    {
        bnt.setBackground(Color.GREEN);
        bnt.setOpaque(true);
        bnt.setEditable(true);
    }

    //This method will make a JTextField's background to be default and doesn't allow it to be edited.
    public void hideJText (JTextField bnt)
    {
        bnt.setBackground(new JTextField().getBackground());
        bnt.setOpaque(true);
        bnt.setEditable(false);
    }

    //This method will make the current player's background to be red and the other one to be default. And a sentence about the turn is set.
    public void notifyCurrentPlayer()
    {
        if (currentPlayer == player1) {
            player1Info.setBackground(Color.RED);
            player1Info.setOpaque(true);
            currentPlayerInfo.setText("Player 1's turn.");
            player2Info.setBackground(new JLabel().getBackground());
            player2Info.setOpaque(true);
        }
        else {
            player2Info.setBackground(Color.RED);
            player2Info.setOpaque(true);
            currentPlayerInfo.setText("Player 2's turn.");
            player1Info.setBackground(new JLabel().getBackground());
            player1Info.setOpaque(true);
        }
    }

    //This method can swap the turns of the current Player and notify the players.
    public void swapPlayer()
    {
        if (currentPlayer == player1) {
            currentPlayer = player2;
            notifyCurrentPlayer();
        } else {
            currentPlayer = player1;
            notifyCurrentPlayer();
        }
    }

    //This method can make the frame into the start format of each turn which only allows and notifies about the three guessing button to be used.
    public void turnStartPhase()
    {
        notification(buyVowel);
        notification(solvePuzzle);
        hideJText(guessText1);
        notification(spinAndGuess);
        hideButton(reInitialize);
    }

    //This method can determine whether the guessing consonant has been guessed, valid, in the sentence or not. Dialog boxes will pop out if needed.
    public void guessAConsonant(String target) {

        char cons = target.charAt(0);

        //Determine whether it is a consonant or not
        if (!isConsonant(cons)) {
            swapPlayer();
            turnStartPhase();
            JOptionPane.showMessageDialog(this,"This is a vowel.\nYour turn is over");

            return;
        }

        //Check whether it has been guessed or in the sentence.
        int num = checkChar(cons, "consonant");
        if(num == -1)
        {
            return;
        }

        currentPlayer.addMoneyForGameTemp(num * spinMoney);
        updateWinningsTemp();
        modifyShownPhrase(cons);

    }

    //Determine whether a char is a consonant.
    private boolean isConsonant(char c) {
        return (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u');
    }

    //Determine whether a char is in the hidden sentence, shown sentence or not.
    public int checkChar(char target, String type) {
        int tempCheck = 0;

        for (int i = 0; i < shownPhrase.length(); ++i) {
            //Already been guessed or not
            if (target == shownPhrase.charAt(i)) {
                JOptionPane.showMessageDialog(this,"That " + type + " was already guessed\nYour turn is over");
                swapPlayer();
                turnStartPhase();
                return -1;
            }
            //In the hidden sentence or not
            if (target == hiddenSentence.charAt(i)) {
                tempCheck += 1;
            }
        }

        //Notify players accordingly.
        if (tempCheck == 0) {
            JOptionPane.showMessageDialog(this,"That " + type + " is not in the phrase\nYour turn is over");
            swapPlayer();
            turnStartPhase();
            return -1;
        }

        return tempCheck;
    }

    //This method can update the game and match money at the same time to the frame.
    public void updateWinningsTemp()
    {
        player1MoneyGame1.setText("$ "+ player1.getWinningsTemp());
        player1MoneyMatch1.setText("$ "+ player1.getWinningsTotal());
        player2MoneyGame2.setText("$ "+ player2.getWinningsTemp());
        player2MoneyMatch2.setText("$ "+ player2.getWinningsTotal());
    }

    //This method can make the guessed letter replace the _ in its original location.
    public void modifyShownPhrase(char target) {
        int targetIndex = hiddenSentence.indexOf(target);
        while (targetIndex != -1) {
            shownPhrase.replace(targetIndex, targetIndex + 1, Character.toString(target));
            targetIndex = hiddenSentence.indexOf(target, targetIndex + 1);
        }
        hiddenPhrase.setText(String.valueOf(shownPhrase));
    }

    //This method determines whether the letter player is guessing is a vowel or not and whether it is in the puzzle or not.
    public void guessAVowel(String target) {

        currentPlayer.payForVowel();
        updateWinningsTemp();

        char vowel = target.charAt(0);
        //Determine whether it is a vowel or not.
        if (isConsonant(vowel)) {
            swapPlayer();
            turnStartPhase();
            JOptionPane.showMessageDialog(this,"This is a Consonant.\nYour turn is over");
            return;
        }

        //Determine whether this has been checked or in the puzzle.
        if (checkChar(vowel, "vowel") == -1) {
            return;
        }

        modifyShownPhrase(vowel);

    }

    /*This method can determine whether the player's solution is correct to the puzzle and give out messages to the player about the status.
    If the player guesses the puzzle correctly, the player gets all the money
    they accumulated so far in this game, and the others win nothing for this game.
    Then a 0 is returned to takeTurn(), meaning that the puzzle has been
    solved; otherwise 1 is returned, meaning that the player's turn is over.*/
    public int solveThePuzzle(String solution) {

        //Determine whether the solution matches the puzzle.
        if (!solution.equals(hiddenSentence)) {
            JOptionPane.showMessageDialog(this,"No, you're wrong. Your turn is over.");
            return 1;
        } else {
            JOptionPane.showMessageDialog(this,"That's right!!!\n"+"Player" + currentPlayer.getPlayerNum() +" won $" + currentPlayer.getWinningsTemp() + " in game" + round);
            currentPlayer.increaseMoneyForGameFinal(currentPlayer.getWinningsTemp());
            playerWin.setText("Player" + currentPlayer.getPlayerNum() +" just won $" + currentPlayer.getWinningsTemp());

            return 0;
        }

    }

    //This method can reset the JTable about the winning record for the reset of the whole match.
    public void resetPlayerRecord()
    {
        playerRecord.setValueAt("",1,1);
        playerRecord.setValueAt("",2,1);
        playerRecord.setValueAt("",3,1);
        playerRecord.setValueAt("",4,1);
    }

}

