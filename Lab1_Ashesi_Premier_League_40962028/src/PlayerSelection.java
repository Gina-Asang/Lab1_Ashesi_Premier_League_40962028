/*
Author: Gina Asang Gana
Cohort : A
Lab 1
Date: 21st September 2025
Program Description:

  This program serves like a prototype of a Football Player Management System
  designed for the Ashesi Premier League. It integrates multiple core Java concepts
  into a single application, serving as a "Team Selection Simulator"
  for coaches.

  The program starts by collecting player details from the user:
   Name, Age,Height (in meters, converted to centimeters),
   Weight(in pounds, converted to kilograms), Jersey Number

 After gathering the details, the program performs several operations:
1. Player Categorization:
    - Players under 20 years are categorized as "Rising Star".
    - Players between 20 and 30 years are "Prime Player".
    - Players over 30 years are "Veteran".
2. Position Assignment:
   - Based on the jersey number, the program assigns a football
    position (e.g., 1 = Goalkeeper, 9 = Striker, etc.).
    - If the jersey number does not match any known position,
    "Player position not known" is displayed.
3. Attacker Identification:
  - Some jersey numbers (like 7, 9, 10, 11) are considered attacker
    numbers. The program checks whether the player’s jersey belongs
     to an attacker.
 4. Eligibility Check:
 - A player is eligible to play if: Age is at least 18 but not above 35
 and Weight is less than 90 kg.
 Logical operators (&&, ||, !) are used to evaluate this condition.
5. Lineup Decision (Nested If):
 - If a player is a "Prime Player" and has weight less than 80 kg,
they are placed in the "Starting Lineup" else "Bench"
6. Final Decision (Ternary Operator):
 - The program quickly decides whether the player will "Play"
 or "Rest" based on their eligibility status using the ternary operator.
7. Switch Demonstration:
 - The program demonstrates the effect of switch-case without
        breaks (fall-through).
 - It also shows how grouping cases together avoids repetition.

 Finally, the program prints a structured Player Report that
 summarizes all the decisions:

        Player: [Name]
        Age: [Age] ([Category])
        Height: [cm]
        Weight: [kg]
        Jersey: [number]
        Position: [Position]
        Attacker jersey: [Yes/No]
        Eligibility: [Eligible/Not Eligible]
        Lineup Decision: [Decision]
        Final Decision: [Play/Rest]

        In summary, this program simulates a real-world decision-making
        process for team selection, combining variables, type casting,
        operators, selection statements, switch cases, nested ifs, and
        the ternary operator into one big system.
        */

import java.util.Scanner;
public class PlayerSelection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //collecting Player Details
        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter age: ");
        int age = input.nextInt();

        System.out.print("Enter height (in meters): ");
        double height = input.nextDouble();

        System.out.print("Enter weight (in pounds): ");
        double weight = input.nextDouble();

        System.out.print("Enter jersey number: ");
        int jerseyNumber = input.nextInt();

        // Convert units of height and weight to standard units
        final double POUND = 0.45359237;
        final int METER = 100;

        double heightInCm = height * METER;
        int weightInKg = (int)(weight * POUND);

        // Eligibility check
        boolean eligibility  = (age >= 18 && age <= 35 && weightInKg < 90);

        // Categorization of player
        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }

        // Positioning  with grouping
        String position;
        switch (jerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2: case 5:
                position = "Defender";
                break;
            case 6: case 8:
                position = "Midfielder";
                break;
            case 7: case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Player position not known";
        }

        // checking if Attacker(From research attackers have jersey number 7,9,10,11
        String attacker;
        if (jerseyNumber == 7 || jerseyNumber == 9 || jerseyNumber == 10 ||
                jerseyNumber == 11){
            attacker = "Yes";
        }
        else{
            attacker = "No";
        }


        // using Nested If to determine Lineup decision
        String lineup;
        if (category.equals("Prime Player")) {
            if (weightInKg < 80) {
                lineup = "Starting Lineup";
            } else {
                lineup = "Bench";
            }
        } else {
            // If not Prime Player it will automatically bench
            lineup = "Bench";
        }

        // Determining Final decision
        String finalDecision = eligibility ? "Play" : "Rest";

        //  Player's Report
        System.out.println("\n\t\tPlayer's Report ");
        System.out.printf("\nPlayer: %s",name);
        System.out.printf("\nAge: %d\t (%s)",age,category);
        System.out.printf("\nHeight: %.2fcm",heightInCm);
        System.out.printf("\nWeight: %skg", weightInKg);
        System.out.printf("\nJersey: %d", jerseyNumber);
        System.out.printf("\nPosition: %s", position);
        System.out.printf("\nAttacker jersey: %s",attacker);
        System.out.printf("\nEligibility: %s", (eligibility ? "Eligible" : "Not Eligible"));
        System.out.printf("\nLineup Decision: %s",lineup);
        System.out.printf("\nFinal Decision: %s ",finalDecision);

        //Demo for Fall-through: switch without break
        System.out.println("\nSwitch Fall-Through Demo");
        switch (jerseyNumber) {
            case 2:
                System.out.println("Defender");
            case 6:
                System.out.println("Midfielder");
            case 7:
                System.out.println("Winger");
            default:
                System.out.println("Invalid");
        }

        input.close();
    }
}


