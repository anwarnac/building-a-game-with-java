package my_game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.applet.*;
import java.awt.*;

public class MainClass implements ActionListener, KeyListener {
    private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
    private JFrame f = new JFrame("Rocket Race");
    private JPanel mainPanel;
    private JButton startGame;
    private static PlayGameScreen pgs;

    public MainClass() {	
    }
   

    public static void main(String[] args) {
        // TODO Auto-generated method stub
	MainClass mc = new MainClass();
	mc.buildFrame();	
	}
	
    
    public void buildFrame() {
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("img/rocket_icon.png"));
	
	f.setContentPane(buildPanel());
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setAlwaysOnTop(false);
        f.setVisible(true);
        f.setMinimumSize(new Dimension(SCREEN_WIDTH*1/4, SCREEN_HEIGHT*1/4));
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setIconImage(icon);
        f.addKeyListener(this);
    }
	
	
    public JPanel buildPanel() {
        mainPanel = new JPanel(); //top-most JPanel in layout hierarchy
	mainPanel.setBackground(Color.BLACK);
	//allow us to layer the panels
	LayoutManager overlay = new OverlayLayout(mainPanel);
	mainPanel.setLayout(overlay);
		
	//Start Game JButton
	startGame = new JButton("Start Playing!");
	startGame.setBackground(Color.BLUE);
	startGame.setForeground(Color.WHITE);
	startGame.setFocusable(false); //rather than just setFocusabled(false)
	startGame.setFont(new Font("Calibri", Font.BOLD, 42));
	startGame.setAlignmentX(0.5f); //center horizontally on-screen
	startGame.setAlignmentY(0.5f); //center vertically on-screen
	startGame.addActionListener(this);
	mainPanel.add(startGame);
	pgs = new PlayGameScreen(SCREEN_WIDTH, SCREEN_HEIGHT, true); //true --> we want pgs to be the splash screen
		
	mainPanel.add(pgs);
		
	return mainPanel;
    }
	
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startGame) {
	    System.out.print("hi"); // istructions after startgame button is pressed
			
	}
    }
	
    public void keyPressed(KeyEvent e) {
    }
	
    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }
}
