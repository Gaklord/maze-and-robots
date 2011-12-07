        /*
        * Assignment #2 - COMP285
        * Zane Kuchera
        *
        * Write a program that generates a sequence of 20 random die tosses
        * and that prints the die values, marking only the longest run, like this:
        * 1 2 5 5 3 1 2 4 3 (2 2 2 2) 3 6 5 5 6 3 1
        *
        * If there is more than one run of maximum length, mark the first one.
        */

        import java.util.Random;


        /* Omg this code is horrible @_@ but oo well.
        * Somehow managed to crumble together this code using an obsessive amount of for and if loops.
        * No doubt there's a better way, but I'm bad at this and literally spent 18 hours in a row working on it :D
        *
        * Sunrise is a cool guy.
        */

        public class zanetest
        {

        public static void main(String[] args)
        {


        int[] roll = new int[20]; //20 dice roll array
        int[] counterHolder = new int[20]; //holds the amount of consecutive numbers for each pair of 2 or more
        int[] indexHolder = new int[20]; //holds the first number's position in each pair of 2 or more
        int i = 0; //preparation for all the for loops
        int q = 0; //used as the constant changer for the indexHolder and counterHolder array
        int z = 0; //used as a constant +1 counter to move through the indexHolder and counterHolder arrays
        int counter = 1; //used as a temporary variable to count the amount of consecutive numbers in a row
        int maxRun = 1; //the highest consecutive amount of numbers in a row
        int temp = 0; //used as a temporary variable to put into the indexHolder array
        boolean p = false; //are the parenthesis brackets currently opened or closed
        Random randomGenerator = new Random(); //sets the randomGenerator

        /* -------------------------------------------------------------------------------------------------------------------
        * -------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------*/

        for (i = 0; i < roll.length; i++)
        {
        roll[i] = randomGenerator.nextInt(6) + 1; //Rolls a random number from 1-6 and sets the roll[] array equal to it.
        }

        /* -------------------------------------------------------------------------------------------------------------------
        * -------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------*/

        for ( i = 1; i < roll.length; i++)
        {
        if (roll[i] == roll[i-1])
        {
        counter = 1;
        temp = i-1;

        while ( roll[i-1] == roll[i] ) //adds 1 to counter and 1 to i for each consecutive number in the sequence
        {
        counter++;
        i++;

        if ( i == 20 ) //prevents overflooding of the array
        break;
        }

        if ( counter > maxRun ) //sets permanent variables if a new largest combo was found
        {
        maxRun = counter;
        q=0; //will reset q to zero if bigger combo is found to restart variable getting from 0 properly
        indexHolder[q] = temp;
        counterHolder[q] = maxRun;
        q++;
        }

        else if ( maxRun == counter) //sets permanent variables to other parts of the array
        { //if several of the same amount of consecutive numbers
        indexHolder[q] = temp;
        counterHolder[q] = maxRun;
        q++;
        }

        //Below is code that outputs each variable in here everytime the
        //start of a consecutive number pattern is found
        /*System.out.println();
        System.out.println("indexHolder = " +indexHolder[q-1]);
        System.out.println("counterHolder = " +counterHolder[q-1]);
        System.out.println("q = " +(q-1));
        System.out.println("counter = " +counter);
        System.out.println("maxRun = " +maxRun);
        System.out.println();*/

        }
        }

        /* -------------------------------------------------------------------------------------------------------------------
        * -------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------*/

        System.out.println("The following is all 20 numbers lined up in their generated order: ");

        for (i = 0; i < roll.length; i++)
        {
        System.out.print(roll[i] +" ");
        }

        /* -------------------------------------------------------------------------------------------------------------------
        * -------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------*/

        System.out.println();
        System.out.println();

        System.out.println("The following is an example of all 20 numbers with parenthesis around EACH group");

        //This section is un-needed, however I'm stupid and this took a lot of time so I'll add this in

        for (i = 0; i < roll.length; i++)
        {

        while ( i > 0 ) //Prevents i from jumping out of the array parameter
        {
        if (p == false) //Will enter this statement if Parenthesis are CLOSED
        {

        if (roll[i-1] == roll[i]) //The current number IS equal to the previous one
        {
        System.out.print("(" +roll[i-1] +" ");
        p = true; //Parenthesis are now open

        break;
        }

        else if (roll[i-1] != roll[i]) //The current number IS NOT equal to the previous one
        {
        System.out.print(roll[i-1] +" ");
        p = false; //Parenthesis are now closed

        break;
        }
        }

        else if (p == true) //Will enter this statement if Parenthesis are OPEN
        {

        if (roll[i-1] == roll[i]) //The current number IS equal to the previous one
        {
        System.out.print(roll[i-1] +" ");
        p = true; //Parenthesis are now open

        break;
        }

        else if (roll[i-1] != roll[i]) //The current number IS NOT equal to the previous one
        {
        System.out.print(roll[i-1] +") ");
        p = false; //Parenthesis are now closed

        break;
        }
        }
        break;
        }
        }

        if (p == false) //Takes care of the 20th number if there is no current open parenthesis
        System.out.print(roll[19]);

        else if (p == true) //Takes care of the 20th number is there is a current open parenthesis
        {
        System.out.print(roll[19] +")");
        }

        System.out.println();
        System.out.println();

        /* -------------------------------------------------------------------------------------------------------------------
        * -------------------------------------------------------------------------------------------------------------------
        -------------------------------------------------------------------------------------------------------------------*/

        System.out.println("Finally, here is the final product of my code, with parenthesis around the largest(s) group of numbers");

        for ( i = 0; i < roll.length; i++)
        {
        if ( counterHolder[z] == maxRun )
        {
        if ( i == indexHolder[z] )
        {
        System.out.print("(" +roll[i] + " ");
        i++;
        }

        if ( i == (indexHolder[z] + maxRun-1) )
        {
        System.out.print(roll[i] +") ");
        z++;
        }

        else
        System.out.print(roll[i] +" ");
        }
        else
        System.out.print(roll[i] +" ");
        }
        }
        }

