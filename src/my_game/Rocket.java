package my_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Rocket {
	//global variables
		private Image rocket;
		private int xLoc = 0, yLoc = 0;
		
		/**
		 * Default constructor
		 */
		public Rocket(int initialWidth, int initialHeight) {
			rocket = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("img/rocket.jpg"));
			scaleRocket(initialWidth, initialHeight);
		}
		
		/**
		 * Method to scale the rocket sprite into the desired dimensions
		 * @param width The desired width of the rocket
		 * @param height The desired height of the rocket
		 */
		public void scaleRocket(int width, int height) {
			rocket = rocket.getScaledInstance(width, height, Image.SCALE_SMOOTH);		
		}
		
		/**
		 * Getter method for the Rocket object.
		 * @return Image
		 */
		public Image getRocket() {
			return rocket;
		}
		
		/**
		 * Method to obtain the width of the Rocket object
		 * @return int
		 */
		public int getWidth() {
			try {
				return rocket.getWidth(null);
			}
			catch(Exception e) {
				return -1;
			}
		}
		
		/**
		 * Method to obtain the height of the Rocket object
		 * @return int
		 */
		public int getHeight() {
			try {
				return rocket.getHeight(null);
			}
			catch(Exception e) {
				return -1;
			}
		}
		
		/**
		 * Method to set the x location of the Rocket object
		 * @param x
		 */
		public void setX(int x) {
			xLoc = x;
		}
		
		/**
		 * Method to get the x location of the Rocket object
		 * @return int
		 */
		public int getX() {
			return xLoc;
		}
		
		/**
		 * Method to set the y location of the Rocket object
		 * @param y
		 */
		public void setY(int y) {
			yLoc = y;
		}
		
		/**
		 * Method to get the y location of the Rocket object
		 * @return int
		 */
		public int getY() {
			return yLoc;
		}
		
		/**
		 * Method used to acquire a Rectangle that outlines the Rocket's image
		 * @return Rectangle outlining the Rocket's position on screen
		 */
		public Rectangle getRectangle() {
			return (new Rectangle(xLoc, yLoc, rocket.getWidth(null), rocket.getHeight(null)));
		}
		
		/**
		 * Method to acquire a BufferedImage that represents the Rocket's image object
		 * @return Rocket's BufferedImage object
		 */
		public BufferedImage getRO() {
			BufferedImage ro = new BufferedImage(rocket.getWidth(null), rocket.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = ro.getGraphics();
			g.drawImage(rocket, 0, 0, null);
			g.dispose();
			return ro;
		}
}
