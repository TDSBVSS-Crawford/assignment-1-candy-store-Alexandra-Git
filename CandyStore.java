
import java.text.DecimalFormat;
import java.util.Scanner;

public class CandyStore {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
   
        //Variable initializing
        //They all have default values assigned to them to prevent VSCode from getting mad
        String candy_chosen = "a";
        int quantity_chosen = 0;

        String current_candy_chosen = "Reeses"; 
        int current_quantity_chosen = 0;

        boolean quit = false;

        double calculated_price = 0.00;

        System.out.println("Welcome to the candy store!\n");

        while (quit == false) { //This loop loops until the user exits the order

            System.out.println("----------------------------------------------\n");

            candy_chosen = candyChoices(); //Calls the candyChoices function and stores the returned variable
            quantity_chosen = quantityPrompt(); //Calls the quantityPrompt function and stores the returned variable

            if (candy_chosen.equals("a")) { //Checks if the input is equal to a certain letter

                current_candy_chosen = "Reeses"; //Sets the current candy chosen as it's name for use later on
                current_quantity_chosen = quantity_chosen; //Sets the current quantity chosen for use later on
                calculated_price += calculateCost(candy_chosen, quantity_chosen); //Calculates the price of the candy and adds it to the total

            } else if (candy_chosen.equals("b")) {

                current_candy_chosen = "Skittles";
                current_quantity_chosen = quantity_chosen;
                calculated_price += calculateCost(candy_chosen, quantity_chosen);

            } else if (candy_chosen.equals("c")) {

                current_candy_chosen = "Jubjubes";
                current_quantity_chosen = quantity_chosen;
                calculated_price += calculateCost(candy_chosen, quantity_chosen);

            } else if (candy_chosen.equals("d")) {

                current_candy_chosen = "Lollipops";
                current_quantity_chosen = quantity_chosen;
                calculated_price += calculateCost(candy_chosen, quantity_chosen);

            } else if (candy_chosen.equals("e")) {

                current_candy_chosen = "Smarties";
                current_quantity_chosen = quantity_chosen;
                calculated_price += calculateCost(candy_chosen, quantity_chosen);

            } else if (candy_chosen.equals("exit")) { //Checks if the user wants to exit the order

                input.close(); //Closes the input
                quit = true; //Stops the loop

            } else { //If all the checks above fail, it will say that the input isn't valid 

                System.out.println(candy_chosen + " is not a valid option");

            }

            double current_price = calculateCost(candy_chosen, current_quantity_chosen); //Calculates the price of the chosen candy and quantity

            System.out.println("\nYou bought " + current_quantity_chosen + " " + current_candy_chosen); //Prints the currenty candy chosen and the quantity
            System.out.println("Cost of " + current_candy_chosen + ": $" + current_price); //Prints the calculated price from the current_price double
            

        } //end of loop

        DecimalFormat round = new DecimalFormat("#.##"); //Creates a DecimalFormat used for rounding.

        double tax = calculated_price * 0.13; //Calculates the tax to be added to the total price later on
        double total_price = calculated_price + tax; //Calculates the total price with taxes

        System.out.println("\nHere's your receipt"); //Prints the receipt
        System.out.println("----------------------------------------------");
        System.out.println("Before HST: $" + round.format(calculated_price)); //Prints out the rounded prices
        System.out.println("HST: $" + round.format(tax));
        System.out.println("\nTotal: $" + round.format(total_price));

    } //end main


    public static String candyChoices() { //This method prints out the options and prompts the user to pick a candy

        System.out.println("a) Reese's Pieces: $2.50/0.5 kg");
        System.out.println("b) Skittles: $1.75/1 kg");
        System.out.println("c) Jubjubes: $0.50/1 kg");
        System.out.println("d) Lollipops: 1 for $0.50 or 5 for $2.00");
        System.out.println("e) Smarties: $1.50/1 kg");

        System.out.print("\nChoose the candy by typing its character: ");

        String candy = input.nextLine(); //Takes the inputted character and stores it in a variable

        return candy; //Returns the character stored
       
    }

    
    public static int quantityPrompt() { //This method prompts the user to enter the quantity of the candy they'd like to buy

        System.out.print("Enter the quantity: ");
        int quantity = input.nextInt(); //Takes the inputted integer and stores it in a variable
        input.nextLine(); //Takes the new line character away

        return quantity; //Returns the quantity chosen

    }


    public static double calculateCost(String choice, int qty) { //Calculates the price of the candy
        
        double calculated_cost = 0.0; 

        DecimalFormat round = new DecimalFormat("#.##"); //Creates a DecimalFormat used for rounding.

        if (choice.equals("a")) { //Checks which candy was chosen

            calculated_cost = 2.50 * qty; //Multiplies the candy's price with the quantity and stores it in a double

        } else if (choice.equals("b")) {

            calculated_cost = 1.75 * qty;

        } else if (choice.equals("c")) {
            
            calculated_cost = 0.50 * qty;

        } else if (choice.equals("d")) {

            calculated_cost = 0.50 * qty;

            if (qty >= 5){ //Checks if the user bought more than 5 lollipops for a discount

                int number_of_fives = Math.floorDiv(qty, 5); //Stores the number of lollipops in a group of 5
                int remainders = qty % 5; //Stores the remainder of lollipops
                calculated_cost = 2.00 * number_of_fives + (remainders * 0.5); //Sets the calculated price to the discounted price

            }

        } else if (choice.equals("e")) {

            calculated_cost = 1.50 * qty;

        }

        return Double.parseDouble(round.format(calculated_cost)); //Returns the rounded calculated cost of the candy as a double
    }

} // end class
