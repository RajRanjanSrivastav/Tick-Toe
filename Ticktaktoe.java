import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Ticktaktoe implements ActionListener{

    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;


    //constructor
    Ticktaktoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //color of text field
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setVerticalAlignment(JLabel.CENTER);
        textfield.setText("TIC-TAC-TOE");
        textfield.setOpaque(true);
        
        //title panel

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);
        
        //for buttons
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        //crating buttons
        for(int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        title.add(textfield);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button_panel);

        //call the firstTurn method

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        for(int i=0;i<9;i++)
        {
           if(e.getSource()==buttons[i])
           {
            if(player1_turn)
            {
                if(buttons[i].getText()=="")
                {
                    buttons[i].setForeground(new Color(255,0,0));
                    buttons[i].setText("X");
                    player1_turn=false;
                    textfield.setText("Shaurya's Turn");
                    checkWin();
                }
            }
            else{
                if(buttons[i].getText()=="")
                {
                    buttons[i].setForeground(new Color(0,0,255));
                    buttons[i].setText("O");
                    player1_turn=true;
                    textfield.setText("Raj's Turn");
                    checkWin();
                }
            }
           }  
        }
    }

    //whoes term is first
    public void firstTurn()
    {
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
           e.printStackTrace();
        }

       if(rand.nextInt(2)==0)
       {
        player1_turn=true;
        textfield.setText("Raj's Turn");
       }
       else{
        player1_turn=false;
        textfield.setText("Punit's Turn");
       }
    }

    //check for any wining condition
    public void checkWin()
    {
        //if x have wining combination

        if(
            (buttons[0].getText()=="X") && buttons[1].getText()=="X" && buttons[2].getText()=="X")
          {
            firstWin(0, 1, 2); 
          }


        if(
            (buttons[0].getText()=="X") && buttons[3].getText()=="X" && buttons[6].getText()=="X")
        {
            firstWin(0, 3, 6); 
        }
        
        if(
            (buttons[0].getText()=="X") && buttons[4].getText()=="X" && buttons[8].getText()=="X")
        {
            firstWin(0, 4, 8); 
        }
        
        if(
            (buttons[1].getText()=="X") && buttons[4].getText()=="X" && buttons[7].getText()=="X")
        {
            firstWin(1, 4, 7); 
        }
        if(
            (buttons[2].getText()=="X") && buttons[5].getText()=="X" && buttons[8].getText()=="X")
        {
            firstWin(2, 5, 8); 
        }
        if(
            (buttons[2].getText()=="X") && buttons[4].getText()=="X" && buttons[6].getText()=="X")
        {
            firstWin(2, 4, 6); 
        }
        if(
            (buttons[3].getText()=="X") && buttons[4].getText()=="X" && buttons[5].getText()=="X")
        {
            firstWin(3, 4, 5); 
        }
        if(
            (buttons[6].getText()=="X") && buttons[7].getText()=="X" && buttons[8].getText()=="X")
        {
            firstWin(6, 7, 8); 
        }

        // -----------for second player (O)
    
        if(
            (buttons[0].getText()=="O") && buttons[1].getText()=="O" && buttons[2].getText()=="O")
          {
            firstWin(0, 1, 2); 
          }


        if(
            (buttons[0].getText()=="O") && buttons[3].getText()=="O" && buttons[6].getText()=="O")
        {
            secWin(0, 3, 6); 
        }
        
        if(
            (buttons[0].getText()=="O") && buttons[4].getText()=="O" && buttons[8].getText()=="O")
        {
            secWin(0, 4, 8); 
        }
        
        if(
            (buttons[1].getText()=="O") && buttons[4].getText()=="O" && buttons[7].getText()=="O")
        {
            secWin(1, 4, 7); 
        }
        if(
            (buttons[2].getText()=="O") && buttons[5].getText()=="O" && buttons[8].getText()=="O")
        {
            secWin(2, 5, 8); 
        }
        if(
            (buttons[2].getText()=="O") && buttons[4].getText()=="O" && buttons[6].getText()=="O")
        {
            secWin(2, 4, 6); 
        }
        if(
            (buttons[3].getText()=="O") && buttons[4].getText()=="O" && buttons[5].getText()=="O")
        {
            secWin(3, 4, 5); 
        }
        if(
            (buttons[6].getText()=="O") && buttons[7].getText()=="O" && buttons[8].getText()=="O")
        {
            secWin(6, 7, 8); 
        }
        
       
    }

    //if first is win the game

    public void firstWin(int a,int b,int c)
    {
     
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);buttons[c].setBackground(Color.RED);

        for(int i=0;i<9;i++)
        {
           buttons[i].setEnabled(false);
        }
        textfield.setText("X win");

    }

    //if second is win the game
    public void secWin(int a,int b,int c)
    {
        buttons[a].setBackground(Color.BLUE);
        buttons[b].setBackground(Color.BLUE);buttons[c].setBackground(Color.BLUE);

        for(int i=0;i<9;i++)
        {
           buttons[i].setEnabled(false);
        }
        textfield.setText("O win");
    }

}
