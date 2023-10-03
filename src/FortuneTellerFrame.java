import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    static Random rnd = new Random();

    public static void main(String[] args)
    {

        JFrame fortuneTeller = new JFrame();
        JPanel mainPnl = new JPanel();
        JPanel topPnl = new JPanel();
        JPanel midPnl = new JPanel();
        JPanel bottomPnl = new JPanel();

        ImageIcon tellerImg = new ImageIcon("src/teller.png");
        JLabel fortuneTellerLbl = new JLabel("Fortune Teller",tellerImg,JLabel.CENTER);
        fortuneTellerLbl.setVerticalTextPosition(JLabel.BOTTOM);
        fortuneTellerLbl.setHorizontalTextPosition(JLabel.CENTER);
        fortuneTellerLbl.setFont(new Font("Serif",Font.BOLD, 48));

        topPnl.add(fortuneTellerLbl);

        JTextArea fortuneTA = new JTextArea(10,35);
        fortuneTA.setFont(new Font("Arial",Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(fortuneTA);
        midPnl.add(scrollPane);

        bottomPnl.setLayout(new GridLayout(1,2));

        JButton fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.setFont(new Font("Roboto",Font.PLAIN, 24));
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {

            fortuneTA.append(generateFortune() + "\n");

        }
        );

        JButton quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Roboto",Font.PLAIN, 24));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl,BorderLayout.NORTH);
        mainPnl.add(midPnl,BorderLayout.CENTER);
        mainPnl.add(bottomPnl,BorderLayout.SOUTH);

        fortuneTeller.add(mainPnl);

        fortuneTeller.setTitle("Fortune Teller");
        fortuneTeller.setSize(400,400);
        fortuneTeller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fortuneTeller.setVisible(true);

    }

    public static String generateFortune() {

        ArrayList possible = new ArrayList<String>(12);
        possible.add(0, "You will get another fortune");
        possible.add(1, "You won't get another fortune");
        possible.add(2, "You will find love... someday");
        possible.add(3, "Your efforts at work will result in a paycheck");
        possible.add(4, "Your time left on this world has decreased by reading this");
        possible.add(5, "You will soon become wealthy beyond by wildest dreams... but I dream very tame");
        possible.add(6, "You will gain the ability to fly... for a short time before you hit the ground");
        possible.add(7, "You have the ability to gain incredible strength... by going to the gym");
        possible.add(8, "You can control the flow of time just by existing, too bad you can't pause it");
        possible.add(9, "You can make everything disappear... by closing your eyes");
        possible.add(10, "You can travel through space, just take a step forward");
        possible.add(11, "You can move objects with your mind, just will your hand to pick them up");

        int currentGen = rnd.nextInt(12);

        int lastGen = 0;
        if (currentGen == lastGen)
        {

            currentGen = rnd.nextInt(12);

        }

        lastGen = currentGen;

        return (String) possible.get(currentGen);

    }
}
