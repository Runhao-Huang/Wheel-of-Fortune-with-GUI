import javax.swing.*;
import java.awt.*;

public class WheelPanel extends JPanel{

    private JTextField choice1;
    private JTextField choice2;
    private JTextField choice3;
    private JTextField choice4;
    private JTextField choice5;
    private JTextField choice6;
    private JTextField choice7;
    private JTextField choice8;
    private JTextField currentChoice;

    private int[] wheel = {0, 1, 100, 200, 300, 400, 500, 600};

    //This is the constructor method of the wheelPanel which locates the location of different JTextFields in the panel to form a circle.
    public WheelPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints positionConst = new GridBagConstraints();
        setSize(200,150);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 5;
        positionConst.gridy = 2;
        choice1 = new JTextField("Bankrupt");
        choice1.setEditable(false);
        add(choice1, positionConst);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 5;
        positionConst.gridy = 3;
        choice2 = new JTextField("Lose a turn");
        choice2.setEditable(false);
        add(choice2, positionConst);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 8;
        positionConst.gridy = 2;
        choice3 = new JTextField("100");
        choice3.setEditable(false);
        add(choice3, positionConst);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 8;
        positionConst.gridy = 3;
        choice4 = new JTextField("200");
        choice4.setEditable(false);
        add(choice4, positionConst);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 6;
        positionConst.gridy = 1;
        choice5 = new JTextField("300");
        choice5.setEditable(false);
        add(choice5, positionConst);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 7;
        positionConst.gridy = 1;
        choice6 = new JTextField("400");
        choice6.setEditable(false);
        add(choice6, positionConst);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 6;
        positionConst.gridy = 4;
        choice7 = new JTextField("500");
        choice7.setEditable(false);
        add(choice7, positionConst);

        positionConst.insets = new Insets(0,0,0,0);
        positionConst.gridx = 7;
        positionConst.gridy = 4;
        choice8 = new JTextField("600");
        choice8.setEditable(false);
        add(choice8, positionConst);


    }

    //This method can be used to show the result of the spinning wheel according to the result in the parameter.
    public void spinTheWheel(int target) {
        JTextField[] choiceWheel = {choice1, choice2, choice3, choice4, choice5, choice6,choice7,choice8};
        int index = 0;

        for (int i = 0; i < wheel.length; i++) {
            if (target == wheel[i]) {
                index = i;
                break;
            }
        }


        int repeat = 0;
        int num = 0;
        while(repeat <= 3)
        {
            currentChoice = choiceWheel[num % 8];
            currentChoice.setBackground(Color.RED);
            this.setOpaque(true);
            if(repeat == 3)
            {
                break;
            }

            currentChoice.setBackground(new JTextField().getBackground());
            this.setOpaque(true);


            num += 1;
            if(num % 8 == index)
            {
                repeat += 1;
            }
        }

    }


}
