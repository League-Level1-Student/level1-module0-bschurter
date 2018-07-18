import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {
	public static void main(String[] args) throws Exception {
		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This will make sure the program exits when you
																	// close the window
		// 1. find an image on the internet, and put its URL in a String variable (from
		// your browser, right click on the image, and select â€œCopy Image Addressâ€�)
		String imageUrl = "https://www.bing.com/th?id=OIP.DRDBZtl7gqTwJUgBFY91mAHaE8&w=250&h=167&c=7&o=5&pid=1.7";
		// 2. create a variable of type "Component" that will hold your image
		Component image = null;
		// 3. use the "createImage()" method below to initialize your Component
		image = createImage(imageUrl);
		// 4. add the image to the quiz window
		quizWindow.add(image);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		// 6. ask a question that relates to the image
		String answer = JOptionPane.showInputDialog(quizWindow, "What is this a picure of?");
		// 7. print "CORRECT" if the user gave the right answer
		if (answer.trim().toLowerCase().equals("code")) {
			JOptionPane.showMessageDialog(quizWindow, "Correct!");
		}
		// 8. print "INCORRECT" if the answer is wrong
		else {
			JOptionPane.showMessageDialog(quizWindow, "Wrong!");
		}
		// 9. remove the component from the quiz window (you may not see the effect of
		// this until step 12)
		quizWindow.remove(image);
		// 10. find another image and create it (might take more than one line of code)
		imageUrl = "https://img.buzzfeed.com/buzzfeed-static/static/enhanced/webdr03/2013/7/25/5/enhanced-buzz-17903-1374744218-23.jpg";
		Component image2 = createImage(imageUrl);

		// 11. add the second image to the quiz window
		quizWindow.add(image2);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		answer = JOptionPane.showInputDialog(quizWindow, "Is this funny?");

		// 14+ check answer, say if correct or incorrect, etc.
		if (answer.trim().toLowerCase().equals("yes")) {
			JOptionPane.showMessageDialog(quizWindow, "Correct!");
		}
		// 8. print "INCORRECT" if the answer is wrong
		else {
			JOptionPane.showMessageDialog(quizWindow, "Wrong!");
		}
	}

	private static Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}