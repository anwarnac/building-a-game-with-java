package my_game;
import javax.swing.*;

import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Color;

public class PlayGameScreen extends JPanel {
    //default reference ID
    private static final long serialVersionUID = 1L;
	
    //global variables
    private int screenWidth, screenHeight;
    private boolean isBroom = true;
    private int successfulJumps = 0;
    private String message = "Rocket Race";
    private Font primaryFont = new Font("Goudy Stout", Font.BOLD, 56), failFont = new Font("Calibri", Font.BOLD, 56);
    private int messageWidth = 0, scoreWidth = 0;
    Image image;
    
    
    /**
    * Default constructor for the PlayGameScreen class
    */
    public PlayGameScreen(int screenWidth, int screenHeight, boolean isBroom) {
        this.screenWidth = screenWidth;
	this.screenHeight = screenHeight;
	this.isBroom = isBroom;
		
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("bgSpace.png"), "bgSpace.png"));
        }
        catch (Exception e) { /*handled in paintComponent()*/ }
    }    
	
    public void paintComponent(Graphics g) {
	super.paintComponent(g); 
	if (image != null) {
            g.drawImage(image, 0,0,screenWidth,screenHeight,this);
        }
	try {
	    g.setFont(primaryFont);
	    FontMetrics metric = g.getFontMetrics(primaryFont);
	    messageWidth = metric.stringWidth(message);
	    scoreWidth = metric.stringWidth(String.format("%d", successfulJumps));
	    g.setColor(Color.ORANGE);
	}
	catch(Exception e) {
	    g.setFont(failFont);
	    FontMetrics metric = g.getFontMetrics(failFont);
	    messageWidth = metric.stringWidth(message);
	    scoreWidth = metric.stringWidth(String.format("%d", successfulJumps));
	}
			
	g.drawString(message, screenWidth/2-messageWidth/2, screenHeight/4);
	if(!isBroom) {
	    g.drawString(String.format("%d", successfulJumps), screenWidth/2-scoreWidth/2, 50);
	}
    }
	

    public void incrementJump() {
        successfulJumps++;
    }
	
    /**
    * Method called to return the current jump score
    * @return
    */
    public int getScore() {
	return successfulJumps;
    }
	
    /**
    * Method called to parse a message onto the screen
    * @param message The message to parse
    */
    public void sendText(String message) {
	this.message = message;
    }
	
}
