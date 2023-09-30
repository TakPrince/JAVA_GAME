import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mission Briefing:\r\n" +
                "- You're facing a grid with 5 rows and 5 columns, making up a total of 25 boxes.\r\n" +
                "- Out of these, 3 boxes are harboring dangerous enemies.\r\n" +
                "- Your objective is to locate and eliminate the enemies in these 3 boxes.\r\n" +
                "- You have to eliminate enemies for 3 time(s) to move to the next level.\r\n" +
                "");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play this game? Enter (yes) to play, or (no) to exit.");
        String choice = scanner.nextLine();
        System.out.println("");
        
        int rep = 0;
        int ro = 0; // Move this line outside of the loop
        mainLoop: do {
            if (choice.equals("yes")) {
                int strikeCount = 0;

                for (int round = 0; round < 3; round++) {
                    int[][] gameGrid = new int[5][5];

                    switch (rep) {
                        case 0:
                            gameGrid[0][0] = 1;
                            gameGrid[1][3] = 1;
                            gameGrid[2][4] = 1;
                            break;
                        case 1:
                            gameGrid[1][0] = 1;
                            gameGrid[2][3] = 1;
                            gameGrid[3][1] = 1;
                            break;
                        case 2:
                            gameGrid[0][1] = 1;
                            gameGrid[1][2] = 1;
                            gameGrid[2][3] = 1;
                            break;
                    }
                    
                    System.out.print("Enter row number: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter column number: ");
                    int column = scanner.nextInt();

                    if (row >= 1 && row <= 5 && column >= 1 && column <= 5) {
                        if (gameGrid[row - 1][column - 1] == 1) {
                            System.out.println("Strike!");
                            System.out.println("");
                            strikeCount++;
                        } else {
                            System.out.println("Oops, you missed!");
                            System.out.println("");
                        }
                    } else {
                        System.out.println("Invalid input! Row and column must be between 1 and 5.");
                        continue;
                    }
                }

                if (strikeCount == 3) {
                    rep++;
                    ro++; // Increment ro here
                    System.out.println("Congratulations! You've defeated all enemies. You win! :)");
                    System.out.println("round " + ro + " completed"); // Display the correct round number
                } else {
                    System.out.println("You've managed to defeat " + strikeCount + " enemies. Try again later. :(");
                    break mainLoop;
                }
            } else {
                System.out.println("Goodbye! Have a great day.");
                break mainLoop;
            }
        } while (rep < 3);
        if(rep==3){
            System.out.println("Congratulations on clearing Level 1! We will notify you once Level 2 is completed");
        }
    }
}