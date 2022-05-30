import java.util.ArrayList;
import java.util.Scanner;
public class compMove{
    public static char tkns[][] = {{'O', 'X', ' '},{' ', 'O' , ' '},{' ', ' ', ' '}};
    
    public static boolean avl(ArrayList<Integer> arr, int n){
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) == n){
                return true;
            }
        }
        return false;
    }
    
    public static int checkCompProf(){
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
    
    // #new
    
    public static int checkCompLoss(){
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
    
    public static int compMove(ArrayList<Integer> neighbors){
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

    
    
    public static void main(){
        Scanner in = new Scanner(System.in);
        int playerChoice = in.nextInt();
        ArrayList<Integer> neighbors;
        
        neighbors = neighbors(playerChoice);
        System.out.println(neighbors);
        if (compMove(neighbors) < 1){
            compMove(neighbors);
        }
    
        
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[0].length; j++){
                System.out.print(" " + tkns[i][j] + " ");
                if (j != 2) System.out.print("|");
            }
            if (i != 2) System.out.println("\n---+---+---");
            else System.out.print("\n");
        }
    }
}