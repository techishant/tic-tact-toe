public class tmp{
    public static void main(){
         // char tkns[][] = {{' ', ' ', ' '},{' ', 'X' , ' '},{' ', ' ', ' '}};
         
         for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[0].length; j++){
                System.out.print(" " + tkns[i][j] + " ");
                if (j != 2) System.out.print("|");
            }
            if (i != 2) System.out.println("\n---+---+---");
            else System.out.print("\n");
        }
        
        int pPos[] = new int [2];
        for (int i = 0; i<tkns[0].length; i++){
            for (int j = 0; j<tkns[0].length; j++){
                if(tkns[i][j] != ' '){
                    pPos[0] = i;
                    pPos[1] = j;
                }
            }
        }
        char op[] = {'+','-'};
        
        for (int i = 0; i<2; i++){
            for (int j = 0; j<2; j++){
                if(op[i] == '+' && op[j] == '+') tkns[pPos[0]+i][pPos[1]+j] = 'O';
                if(op[i] == '+' && op[j] == '-') tkns[pPos[0]+i][pPos[1]-j] = 'O';
                if(op[i] == '-' && op[j] == '+') tkns[pPos[0]-i][pPos[1]+j] = 'O';
                if(op[i] == '-' && op[j] == '-') tkns[pPos[0]-i][pPos[1]-j] = 'O';
            }
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