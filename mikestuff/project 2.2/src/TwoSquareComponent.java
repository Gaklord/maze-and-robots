import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Color;

/*
   A component that draws two squares, then colors them
*/
public class TwoSquareComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;

      // Set the initial color for the first rectangle
      g2.setColor(Color.pink);
      // Set rectangle parameters
      Rectangle box = new Rectangle(50, 50, 90, 90);
      // Set the box to be filled with selected color
      g2.fill(box);
      // Moves box for second iteration
      box.translate(100, 0);
      // sets custom color (should be purple or very close
      Color teper = new Color(255,0,255);
      // sets box to custom color
      g2.setColor(teper);
      
      g2.fill(box);
      // draws the boxes
      g2.draw(box);
      
      
   }
}
