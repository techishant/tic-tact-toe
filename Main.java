import java.util.Scanner;
public class Main{
    public static char tkns[][] = new char[3][3];
    public static Scanner in = new Scanner(System.in);
    
    public static void wipe(){
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[1].length; j++){
                tkns[i][j] = ' ';
            }
        }
        return;
    }
    
    public static int reset(int inp, char tkn){
        if (full()) return 0;
        if (tkn != 'O'){
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
                            tkns[i][j] = tkn;
                            return 1;
                        }
                    }
                }
            }
            return 1;
        }else{
            int ranPos = (int) (Math.random()*9);
            int count = 0;
            for (int i = 0; i<tkns[0].length; i++){
                for (int j = 0; j<tkns[1].length; j++){
                    if (tkns[i][j] == ' '){
                        if (count == ranPos && tkns[i][j] == ' '){
                            tkns[i][j] = 'O';
                            return 1;
                        }
                        if (count == ranPos && tkns[i][j] != ' ') return 8; // 8 : Not Possible
                        count ++;
                    }
                }
            }
        } 
        return 0;
    }
    
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
        return;
    }
    
    public static boolean full(){
        int count = 0;
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[0].length; j++){
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
        
        if (NS == 264 || WE == 264 || NW == 264 || NE == 264 || TOP == 264 || BOTTOM == 264 || LEFT == 264 || RIGHT == 264){
            System.out.println("You Win");
            System.exit(0);
        }else if(NS == 237 || WE == 237 || NW == 237 || NE == 237 || TOP == 237 || BOTTOM == 237 || LEFT == 237 || RIGHT == 237) {
            System.out.println("You Lose");
            System.exit(0);
        }else if (full()){
            System.out.println("Draw");
            System.exit(0);
        }
    }
    
    public static void main(){
        wipe();
        int playerChoice; char tkn='X'; int st = 1; int i = 0;
        while (!full()){
            st =0;
            tkn = ((i%2) == 0)?'X':'O';
            score();
            if (tkn == 'X'){
                System.out.print("Player X: " );
                playerChoice = in.nextInt();
                st = reset(playerChoice, tkn);
            }else{
                st = reset(0, tkn);
                while (st != 1){
                    st = reset(0, tkn);
                }
            }
            updArena(tkn);
            
           if (st == 1) i++;
        }
        updArena(tkn);
        score();
        System.out.println("Game Over");
    } 
}