import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static Scanner in = new Scanner(System.in);
    public static char tkns[][] = new char[3][3]; // Data Array
    
    // Making Play Ground Ready
    public static void wipe(){
        // Initialising The Data Array
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                tkns[i][j] = ' ';
            }
        }
        System.out.println("Tic-Tac-Toe\n-made by Ishant");
        // Printing Cheat Sheet
        int count = 1;
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                System.out.print(" " + count + " ");
                if (j != 2) System.out.print("|");
                count++;
            }
            if (i != 2) System.out.println("\n---+---+---");
            else System.out.print("\n");
        }
        System.out.println("===========\n\n");
        
        return;
    }
    
    // The function checks whether there's a possible move to end the game cum win the game.
    public static int checkCompProf(){
        // Cloning the  Data Array
        char compPers[][] = new char [3][3];
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                compPers[i][j] = tkns[i][j];
            }
        }
        int NS, WE, NW, NE, TOP, BOTTOM, LEFT, RIGHT;
        int count=1;
        for (int i =0; i<compPers[0].length; i++){
            for (int j=0; j<compPers[1].length; j++){
                if (compPers[i][j] == ' ' ){
                    compPers[i][j] = 'O';
                    NS =        compPers[0][1] + compPers[1][1] + compPers[2][1];
                    WE =        compPers[1][0] + compPers[1][1] + compPers[1][2];
                    NW =        compPers[0][0] + compPers[1][1] + compPers[2][2];
                    NE =        compPers[0][2] + compPers[1][1] + compPers[2][0];
                    TOP =       compPers[0][0] + compPers[0][1] + compPers[0][2];
                    BOTTOM =    compPers[2][0] + compPers[2][1] + compPers[2][2];
                    LEFT =      compPers[0][0] + compPers[1][0] + compPers[2][0];
                    RIGHT =     compPers[0][2] + compPers[1][2] + compPers[2][2];
                    
                    if(NS == 237 || WE == 237 || NW == 237 || NE == 237 || TOP == 237 || BOTTOM == 237 || LEFT == 237 || RIGHT == 237) {
                        return count;
                    }
                    compPers[i][j] = ' ';
                }
                count++;
            }
        }
        
        return 0;
    }
    
    // This function checks whether there's a possibility to lose the game or player to win
    public static int checkCompLoss(){
        // cloning the data array
        char compPers[][] = new char [3][3];
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                compPers[i][j] = tkns[i][j];
            }
        }
        int NS, WE, NW, NE, TOP, BOTTOM, LEFT, RIGHT;
        int count=1;
        for (int i =0; i<compPers[0].length; i++){
            for (int j=0; j<compPers[1].length; j++){
                if (compPers[i][j] == ' ' ){
                    compPers[i][j] = 'X';
                    NS =        compPers[0][1] + compPers[1][1] + compPers[2][1];
                    WE =        compPers[1][0] + compPers[1][1] + compPers[1][2];
                    NW =        compPers[0][0] + compPers[1][1] + compPers[2][2];
                    NE =        compPers[0][2] + compPers[1][1] + compPers[2][0];
                    TOP =       compPers[0][0] + compPers[0][1] + compPers[0][2];
                    BOTTOM =    compPers[2][0] + compPers[2][1] + compPers[2][2];
                    LEFT =      compPers[0][0] + compPers[1][0] + compPers[2][0];
                    RIGHT =     compPers[0][2] + compPers[1][2] + compPers[2][2];
                    
                    if(NS == 264 || WE == 264 || NW == 264 || NE == 264 || TOP == 264 || BOTTOM == 264 || LEFT == 264 || RIGHT == 264) {
                        return count;
                    }
                    compPers[i][j] = ' ';
                }
                count++;
            }
        }
        
        return 0;        
    }
    
    // This functions returns the neghbouring elements/cells of the previous move taken by the player.
    public static ArrayList<Integer> neighbors(int n){
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        
        switch(n){
            case 1:
                neighbors.add(2);
                neighbors.add(4);
                neighbors.add(5);
                return neighbors;
            case 2:
                neighbors.add(1);
                neighbors.add(3);
                neighbors.add(4);
                neighbors.add(5);
                neighbors.add(6);
                return neighbors;
            case 3:
                neighbors.add(2);
                neighbors.add(5);
                neighbors.add(6);
                return neighbors;
            case 4:
                neighbors.add(1);
                neighbors.add(2);
                neighbors.add(5);
                neighbors.add(7);
                neighbors.add(8);
                return neighbors;
            case 5:
                neighbors.add(1);
                neighbors.add(2);
                neighbors.add(3);
                neighbors.add(4);
                neighbors.add(6);
                neighbors.add(7);
                neighbors.add(8);
                neighbors.add(9);
                return neighbors;
            case 6:
                neighbors.add(2);
                neighbors.add(3);
                neighbors.add(5);
                neighbors.add(8);
                neighbors.add(9);
                return neighbors;
            case 7:
                neighbors.add(4);
                neighbors.add(5);
                neighbors.add(8);
                return neighbors;
            case 8:
                neighbors.add(4);
                neighbors.add(5);
                neighbors.add(6);
                neighbors.add(7);
                neighbors.add(9);
                return neighbors;
            case 9:
                neighbors.add(5);
                neighbors.add(6);
                neighbors.add(8);
                return neighbors;
            default:
                break;
        }
        return neighbors;
    }
    
    // A very small functions which checks whether it is possible to choose a neighbouring position
    public static boolean avl(ArrayList<Integer> arr, int n){
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) == n){
                return true;
            }
        }
        return false;
    }
    
    // This function resets/ updates the data array according to the players choice.
    public static int reset(int inp){
        if (full()) return 0;
        int count = 0;
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                count++;
                if (count == inp){
                    if (tkns[i][j] != ' '){
                        System.out.println("Invalid Move!");
                        return 0;
                    }
                    else{
                        tkns[i][j] = 'X';
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    
    // AI of computer that updates the data array according to the computers choice
    public static int compMove(ArrayList<Integer> neighbors){
        // 1st Condition: If there's any possible move to win the game.
        int CompProfAt = checkCompProf();
        if (CompProfAt != 0){
            int count = 1;
            for (int i=0; i<tkns[0].length; i++){
                for (int j=0; j<tkns[1].length; j++){
                    if (count == CompProfAt){
                        tkns[i][j] = 'O';
                        return 1;
                    }
                    count ++;
                }
            }
        }
        
        // 2nd Condition: If there's any possible move to block the player from winning. (Future Task) TODO
        int CompLossAt = checkCompLoss();
        if (CompLossAt != 0){
            int count = 1;
            for (int i=0; i<tkns[0].length; i++){
                for (int j=0; j<tkns[1].length; j++){
                    if (count == CompLossAt){
                        tkns[i][j] = 'O';
                        return 1;
                    }
                    count ++;
                }
            }
        }
        
        // 3rd Condition: If above conditions are not possible the just surround the last move of the player. (become a neighbour)
        int count = 1;
        for (int i =0; i<tkns[0].length; i++){
            for (int j=0; j<tkns[1].length; j++){
                boolean avl = avl(neighbors, count);
                if (avl){
                    if (tkns[i][j] == ' '){
                        tkns[i][j] = 'O';
                        return 1;
                    }
                }
                count++;
            }
        }   
        
        // 4th Condition: If all of the above conditions are not possible then make any random move possible.
        int ranPos = (int) (Math.random()*9);
        count = 0;
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                if (tkns[i][j] == ' '){
                    if (count == ranPos && tkns[i][j] == ' '){
                        tkns[i][j] = 'O';
                        return 1;
                    }
                    if (count == ranPos && tkns[i][j] != ' ') return 0;
                    count ++;
                }
            }
        }
        return 0;
    }
    
    // Updates The arena (ie: Display the arena on shell)
    public static void updArena(char tkn){
        if (tkn == 'O') System.out.println("Computer: ");
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[0].length; j++){
                System.out.print(" " + tkns[i][j] + " ");
                if (j != 2) System.out.print("|");
            }
            if (i != 2) System.out.println("\n---+---+---");
            else System.out.print("\n");
        }
        System.out.println("###########\n");
        return;
    }
    
    // Checks if the playground is full.
    public static boolean full(){
        int count = 0;
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                if (tkns[i][j] == ' '){
                    return false;
                }else{
                    count++;
                }
                if (count == 9){
                    return true;
                }
            }
        }
        return false;
    }
    
    // Calculates if Player or Computer won
    public static void score(){
        int NS, WE, NW, NE, TOP, BOTTOM, LEFT, RIGHT;
        NS = tkns[0][1] + tkns[1][1] + tkns[2][1];
        WE = tkns[1][0] + tkns[1][1] + tkns[1][2];
        NW = tkns[0][0] + tkns[1][1] + tkns[2][2];
        NE = tkns[0][2] + tkns[1][1] + tkns[2][0];
        TOP = tkns[0][0] + tkns[0][1] + tkns[0][2];
        BOTTOM = tkns[2][0] + tkns[2][1] + tkns[2][2];
        LEFT = tkns[0][0] + tkns[1][0] + tkns[2][0];
        RIGHT = tkns[0][2] + tkns[1][2] + tkns[2][2];
        
        // If player wins; If Comuter wins; If there's a draw.
        if (NS == 264 || WE == 264 || NW == 264 || NE == 264 || TOP == 264 || BOTTOM == 264 || LEFT == 264 || RIGHT == 264){
            System.out.println("\n\n==================\n| You Win !!! :) |\n==================");
            System.exit(0);
        }else if(NS == 237 || WE == 237 || NW == 237 || NE == 237 || TOP == 237 || BOTTOM == 237 || LEFT == 237 || RIGHT == 237) {
            System.out.println("\n\n=================\n| You Lose ! :( |\n=================");
            System.exit(0);
        }else if (full()){
            System.out.println("\n\n===========\n| Draw :| |\n===========");
            System.exit(0);
        }
    }
    
    public static void main(){
        wipe();
        int playerChoice=5; char tkn='X'; int st = 1; int i = 0; ArrayList<Integer> neighbors;
        while (!full()){
            st =0;
            tkn = ((i%2) == 0)?'X':'O';
            score();
            if (tkn == 'X'){
                System.out.print("Player X: " );
                playerChoice = in.nextInt();
                st = reset(playerChoice);
            }else{
                neighbors = neighbors(playerChoice);
                st = compMove(neighbors);
                while (st != 1){
                    st = compMove(neighbors);
                }
            }
            updArena(tkn);
            
           if (st == 1) i++;
        }
        score();
        System.out.println("Game Over");
    } 
}