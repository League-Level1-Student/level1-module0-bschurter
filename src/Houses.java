import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class Houses {
	static Robot robot = new Robot();

	public static void main(String[] args) {
		Robot.setWindowSize(800, 600);
		Robot.setWindowColor(Color.BLACK);
		robot.miniaturize();
		robot.setSpeed(50);
		robot.moveTo(10, 550);
		robot.penDown();

		Random rnd = new Random();

		for (int i = 0; i < 9; i++) {
			// Get random height
			int h = rnd.nextInt(3);
			String height = "small";
			if (h == 1) {
				height = "medium";
			}
			else if (h == 2) {
				height = "large";
			}
			// Get random color
			float red = rnd.nextFloat();
			float green = rnd.nextFloat();
			float blue = rnd.nextFloat();
			Color color = new Color(red, green, blue);

			drawHouse(height, color);	
		}
	}

	private static void drawHouse(String height, Color color) {
		int h = 60;
		if (height.equalsIgnoreCase("medium")) {
			h = 120;
		} else if (height.equalsIgnoreCase("large")) {
			h = 250;
		}
		robot.setPenColor(color);
		robot.setAngle(0);
		robot.move(h);
		
		if (height.equalsIgnoreCase("large")) {
			drawPointyRoof();
		}
		else {
			drawFlatRoof();
		}
		
		robot.move(h);
		robot.turn(-90);
		robot.setPenColor(Color.GREEN);
		robot.move(30);
	}
	
	private static void drawPointyRoof() {
		robot.turn(45);
		robot.move(30);
		robot.turn(90);
		robot.move(30);
		robot.turn(45);
	}
	
	private static void drawFlatRoof() {
		robot.turn(90);
		robot.move(50);
		robot.turn(90);
	}
}
