import java.util.InputMismatchException;
import java.util.Scanner;

public class guessMyAge {

    public static void main (String [] args){

        int n = getNumber();

        n=((n*2)+5)*50;

        if (getChoce()=='y'){
            n++;
        }
        System.out.println((n=(n+1771)-getAnne())%100);
    }


    public static char getChoce(){

        char c = 'x';

        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("is this your birthday year or no : ");
            c= keyboard.next().charAt(0);
        }while (c != 'y' &&  c != 'n' );

        return c;
    }


    public static int getAnne(){
        int anne = 0;
        do {
            try {
                Scanner keyboard = new Scanner(System.in);
                System.out.print("type your Birthday date : ");
                anne= keyboard.nextInt();

                if(anne<1000  ){
                    System.out.println("the number choud be  > 1000");
                }
            }
            catch (InputMismatchException e){
                System.out.println("please type a number");
            }
        }while (anne<1000);
        return anne;
    }


    public static int getNumber(){
        int n=-1 ;
        do {
            try {
                Scanner keyboard = new Scanner(System.in);
                System.out.print("type a numbre : ");
                n = keyboard.nextInt();

                if(n<1 || n >10 ){
                    System.out.println("the number chould be between 1 and 10");
                }
            }
            catch (InputMismatchException e){
                System.out.println("please type a number");
            }
        } while (n<1 || n >10 );
        return n;
    }
}
