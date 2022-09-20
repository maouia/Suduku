import java.util.Scanner;

public class main {

   public static int[][] mat = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,0,0,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
    };
    public static boolean check (int x,int y,int n,int [][]mat){
        for (int i = 0 ; i<8;i++){
            if(mat[i][y]==n) return false;
        }

        for (int i = 0 ; i<8;i++){
            if(mat[x][i]==n) return false;
        }


        int xx = x - (x % 3);
        int yy = y - (y % 3);
        for (int i = xx; i < xx + 3; i++) {
            for (int j = yy; j < yy + 3; j++) {
                if(mat[i][j] == n){
                    return  false;
                }

            }
        }

        return true ;
    }

    public static void affiche(int[][] mat){
        System.out.println();
        for (int i = 0 ; i<9;i++){
            for (int j = 0 ; j<9;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }



    public static void solve (int [][] mat){

        Scanner keyboard = new Scanner(System.in);


        for(int i = 0 ; i<9 ; i++){
            for (int  j = 0 ; j < 9 ; j++ ){
                if(mat[i][j]==0) {

                    for (int n = 1; n < 10; n++) {

                        if (check(i, j, n, mat)) {
                            mat[i][j] = n;


                            solve(mat);
                            mat[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }

                affiche(mat);
                System.out.println("more solution");
                String s = keyboard.nextLine();


    }


    public static void main (String [] args){


solve(mat);
     //System.out.println( check(3,1,4,mat));

    }

}
