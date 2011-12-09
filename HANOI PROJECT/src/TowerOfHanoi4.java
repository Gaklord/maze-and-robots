import java.util.*;

public class TowerOfHanoi4 {

    // stacks[0], stacks[1] and stacks[2] are the three stacks.
    static Stack<Integer>[] towers;
    private static int disks;

    public static void main (String[] argv)
    {
    	disks = 5;
    	disks -= 1;
        // ask user for number of disks and solve the puzzle
        System.out.println ((disks+1) + "-Disk solution: ");
        prepare(disks , 0, 2);
    }


    static void prepare (int disk, int starTower, int endTower)
    {
    // Create the three stacks.
	towers = new Stack [3];
	for (int n=0; n<3; n++) 
	{
		towers[n] = new Stack<Integer>();
	}

    // Put disks 0,...,n on stack 0.
	for (int k=disk; k>=0; k--) {
	    towers[0].add (k);
	}

	solve (disk, starTower, endTower);
    }
    

    static void solve (int disk, int fromTower, int toTower)
    {
	// Bottom-out.
	if (disk == 0) {
	    move (0, fromTower, toTower);
	    return;
	}
	int spareTower = other (fromTower, toTower);
        
	solve (disk-1, fromTower, spareTower);   // Step 1.
	move (disk, fromTower, toTower);                    // Step 2.
	solve (disk-1, spareTower, toTower);   // Step 3.
    }


    static void move (int disk, int sourceTower, int desTower)
    {
        // Pull out the top disk from source tower.
	int topDisk = towers[sourceTower].pop();
        // Put it on stack destination tower.
	towers[desTower].push (topDisk);
        // Print status.
        System.out.println ("Towers after moving " + (disk+1) + " from tower " + sourceTower + " to tower " + desTower);
	printTowers();

        // Pause for effect.
        try {
            Thread.sleep (300);
        }
        catch (InterruptedException e) {
        }
    }


    static int other (int i, int j)
    {
        // Given two towers, return the third.
        if ( (i == 0) && (j == 1) ) {
            return 2;
        }
        else if ( (i == 1) && (j == 0) ) {
            return 2;
        }
        else if ( (i == 1) && (j == 2) ) {
            return 0;
        }
        else if ( (i == 2) && (j == 1) ) {
            return 0;
        }
        else if ( (i == 0) && (j == 2) ) {
            return 1;
        }
        else if ( (i == 2) && (j == 0) ) {
            return 1;
        }

        // HERE BE DRAGONS
        return -1;
    }


    public static void printTowers ()
    {
    	for (int i=0; i<towers.length; i++) 
    	{
    		System.out.print ("Tower " + (i+1) + ": ");
    		if ( ! towers[i].isEmpty() ) 
    			{
    			for (Integer I: towers[i]) 
    				{
    				System.out.print (" " + (I+1));
    				}
    			}	
    		System.out.println ();
    	}
    }

}
