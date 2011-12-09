import java.awt.*;
import javax.swing.*;
import java.util.*;


class HanoiPanel extends JPanel {

    Stack<Integer>[] towers;
    int maxDisks;
    
    public void paintComponent (Graphics g)
    {
        super.paintComponent (g);
        
        // Draw the towers first.
        g.setColor (Color.cyan);

        int topOffset = 30;
        int spacing = 50;
        int towerWidth = 10;
        int towerHeight = 150;

        g.fillRect (spacing, topOffset, towerWidth, towerHeight);
        g.fillRect (2*spacing+towerWidth, topOffset, towerWidth, towerHeight);
        g.fillRect (3*spacing+2*towerWidth, topOffset, towerWidth, towerHeight);

        // Draw the disks.

        // INSERT YOUR CODE HERE

    }

}



public class HanoiGUI extends JFrame
{

    public HanoiGUI(Stack astack[], int i)
    {
        setSize(200, 300);
        setTitle("Tower of Hanoi");
        panel = new HanoiPanel();
        panel.towers = astack;
        panel.maxDisks = i;
        Container container = getContentPane();
        container.add(panel);
        setVisible(true);
    }

    public void updateGUI()
    {
        panel.repaint();
    }

    HanoiPanel panel;
}

