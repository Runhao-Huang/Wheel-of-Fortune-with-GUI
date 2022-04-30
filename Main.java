/*Runhao Huang
CSC112 Fall 2021
Programming Assignment 5
December 1, 2021
This program is a more proper version of the game Wheel of fortune. In this program, there are clear instructions of the moves
that a player can possibly do according to the rule by using the green color and red color, and there are clear demonstrations
on the current status of the wheel, money of the current game and match, winning history, and the pop up message box of all the possible mistakes
or summary of the game during the match. In the end, after playing a maximum of 4 puzzles, a summary will appear and players
will have the chance to decide playing the match again.
*/


import javax.swing.*;

public class Main {
    /*
    For this program, the rules and instructions for the players are easy to follow and understand. First, there will only be
    the three guessing options being able to click. And all of them are highlighted in green. Then if the player
    meet the situations of bankrupt/lose a turn and no money to buy vowel, the guessText box will be highlighted in green
    and all the other buttons will be back to default and not clickable, leaving the only option of entering in the box. And then
    if players are wrong, it will return to the start of instruction phase and swap the player. And if the player get it right,
    message box or money increase in their name below will show the current status. And if all 4 puzzles are played, the reinitialize button
    will be highlighted, allowing the player to choose whether to play again or nor.
     */

    /*
        The first special feature is the Front and design of the title “Wheel Of Fortune Game”. I set the front to be 30 and the style to be Times New Roman,
    in order to make the whole game more serious and clear for the players.
        My second special feature is the wheel I put in the right of the whole frame. I made this wheel to make the players to have more of a gaming experience
    and have a more direct graphical understanding of what they have randomly spined. This wheel is a wheelPanel object where I extended from JPanel myself.
    I could have do it like a JPanel in the WOFFrame, however, I want to have a tidier code and a better layout since it will really mess up the private fields
    of the WOFFrame by its own component of JTextFields. And if simply arrange these JTextFields into the frame will make the layout of the frame to be loosen.
    I highlighted the corresponded spin result in the wheel each time in red so that the player can see it directly.
        My third special feature is the JTable that is called playerRecord. It records the player who wins the game each time and show that in the main frame to players.
    I think it will be very great to have an overview of the winning status except from the winningsTemp and winningsMatch. And it will automatically be erased
    if the players decide to play this match again.
        My fourth special feature is the instructions I made for a great and easy experience for players playing my game. I have 2 notification methods that have different parameters,
    which can set the background color of the JButton or JTextField to be green, and allows it to be operated. There are also hideButton and hideJText methods that can make
    the background color to be default and not operatable. In the initialized phase all JButtons and JTextfields are set to be hidden. By carefully going through all the possible
    moves of players, I managed to notify the options players have and restrict their operation to these options efficiently through these methods. There is no way a player can cheat
    or misconduct the operation due to their misunderstanding of the game. What’s more, there are also notifyCurrentPlayer, updateWinningsTemp methods to make sure players know when to start
    and what’s there money all the time. In addition, numerous pop up message box instructs the players about their mistakes and follow up operations to the game. So that they will also
    have a better understanding of the game while playing. A summary of the whole match and the match winner is displayed at the end. Also after 4 puzzles run out and summary closed,
    players can only choose between play the match again by reinitializing it or exit.
        In conclusion, this is a very proper program considering about this designing features and considerate design of instructing the players during the play.

     */
    public static void main(String[] args) {
        WOFFrame wofFrame = new WOFFrame();
        wofFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wofFrame.pack();
        wofFrame.setVisible(true);


    }

}
