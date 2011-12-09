import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FrameViewer 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(200 * 2, 200 * 2); // a) double the frame size
		JLabel label = new JLabel("Hello, Michael!"); // b) change to hello name
		label.setOpaque(true);
		Color paleGreen = new Color(200, 255, 200);
		label.setBackground(paleGreen); // c) make the frame a pale green (i did it custom style)
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
