import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends Game implements ActionListener{

  JFrame frame = new JFrame();
  JPanel title = new JPanel();
  JPanel restartPannel = new JPanel();
  JPanel buttonPannel = new JPanel();
  JButton[][] buttons = new JButton[6][7]; 
  JLabel text = new JLabel();
  JLabel endText = new JLabel();
  JButton restartButton = new JButton();
  
  //GUI setup
  public GUI() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 800);
    frame.getContentPane().setBackground(Color.gray);
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);
    
    title.setLayout(new BorderLayout());
    title.setBounds(0, 0, 800, 800);

    text.setHorizontalAlignment(JLabel.CENTER);
    text.setText("CONNECT FOUR, RED GOES FIRST");
    text.setFont(new Font("Ink Free", Font.BOLD, 30));
    text.setOpaque(true);
    text.setBackground(Color.white);
    text.setForeground(Color.black);
    
    buttonPannel.setLayout(new GridLayout(6,9));
    buttonPannel.setBackground(Color.cyan);

    restartPannel.setBackground(Color.gray);

    restartPannel.add(restartButton);
    restartButton.setPreferredSize(new Dimension(600, 50));
    restartButton.setBackground(Color.red);
    restartButton.setFont(new Font("Dialog", Font.BOLD, 40));
    restartButton.setText("RESTART GAME");
   

      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 7; j++) {
        buttons[i][j] = new JButton();
        buttonPannel.add(buttons[i][j]);
        buttons[i][j].setFocusable(false);
        buttons[i][j].addActionListener(this);
        buttons[i][j].setBackground(Color.lightGray);
        }
      }

    restartButton.setFocusable(false);
    restartButton.addActionListener(this);

    title.add(text);
    frame.add(title,BorderLayout.NORTH);
    frame.add(buttonPannel, BorderLayout.CENTER);
    frame.add(restartPannel,BorderLayout.SOUTH);
  }

  //detects clicked square
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == restartButton) {
      text.setText("red's turn");
      for (int i = 0; i < 6; i ++) {
        for (int j = 0; j < 7; j ++) {
         buttons[i][j].setBackground(Color.lightGray);
        }
      }
      restartGame();
    } 
      
    else {
      
    for (int i = 0; i < 6; i ++) {
      for (int j = 0; j < 7; j ++) {
        if (e.getSource() == buttons[i][j]) {
         // checks if game is still and if the square is available
         if (checkAvailability(i, j) && game) {
          text.setText(getColor() + "'s turn");
            turnNum++;
          //changes square color
          if (getColor() == "red") {
            buttons[i][j].setBackground(Color.red);
          } else {
            buttons[i][j].setBackground(Color.blue);
            }
           if (checkWin(i, j)) {
              text.setText(getColor().toUpperCase() + " WON! Press restart to play again.");
              game = false;
             
              }
            }
          }
        }  
      }
      
    }
  }



  
}