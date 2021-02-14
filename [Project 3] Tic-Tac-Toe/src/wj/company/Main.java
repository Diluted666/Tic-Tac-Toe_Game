package wj.company;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

		char[][] array= new char [3][3];

		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				array[i][j]=' ';

		//variable that changes add symbol ('X' and 'Y')
		int i = 2;
        while(true) {
			show(array);
			check(array);
			char XorO;
			while (true) {

				//add 'X' first, then 'O' and 'X' and so on.
				if (i % 2 == 0)
					XorO = 'X';
				else
					XorO = 'O';

				System.out.print("Enter coordinates: ");
				String a = scanner.next();
				String b = scanner.next();

				//check if the input is not a string or given integer is in bounds [1,3] or the place is not occupied.
				if (a.length() > 1 || b.length() > 1)
					System.out.println("You should enter numbers!");

				else if (Integer.parseInt(a) < 1 || Integer.parseInt(a) > 3 || Integer.parseInt(b) < 1 || Integer.parseInt(b) > 3)
					System.out.println("Coordinates should be from 1 to 3!");

				else if (array[Integer.parseInt(a) - 1][Integer.parseInt(b) - 1] == 'X' || array[Integer.parseInt(a) - 1][Integer.parseInt(b) - 1] == 'O')
					System.out.println("This cell is occupied! Choose another one!");

				else{

					array[Integer.parseInt(a) - 1][Integer.parseInt(b) - 1] = XorO;
					i++;
					break;
				}
			}
		}
    }

    //Display board
    static  public void show(char[][] array){
		System.out.println("---------");
		System.out.println("| " + array[0][0] + " " + array[0][1] +
				" " + array[0][2] + " |");
		System.out.println("| " + array[1][0] + " " + array[1][1] +
				" " + array[1][2] + " |");
		System.out.println("| " + array[2][0] + " " + array[2][1] +
				" " + array[2][2] + " |");
		System.out.println("---------");
	}

	static public void check(char[][] array){

    	boolean X_won=false;
    	boolean O_won=false;
    	boolean draw=false;

		//Checking rows
		for(int i=0; i<3; i++) {
				if (array[i][0] == 'X' && array[i][1] =='X' && array[i][2] == 'X')
					X_won=true;
				else if (array[i][0] == 'O' && array[i][1] =='O' && array[i][2] == 'O')
					O_won=true;
			}
		//Checking columns
		for(int i=0; i<3; i++) {
				if (array[0][i] == 'X' && array[1][i] =='X' && array[2][i] == 'X')
					X_won=true;
				else if (array[0][i] == 'O' && array[1][i] =='O' && array[2][i] == 'O')
					O_won=true;

		}
		//checking diagonals
		if(array[0][0]=='X' && array[1][1]=='X' && array[2][2]=='X')
			X_won=true;

		if(array[0][2]=='X' && array[1][1]=='X' && array[2][0]=='X')
			X_won=true;

		if(array[0][0]=='O' && array[1][1]=='O' && array[2][2]=='O')
			O_won=true;

		if(array[0][2]=='O' && array[1][1]=='O' && array[2][0]=='O')
			O_won=true;

        //Check if the game has to be stopped
		End(Check(X_won,O_won,draw));

		if(draw(array)){
			draw=true;
		}

		//Check if the game has to be stopped
		End(Check(X_won,O_won,draw));

	}
	//if array has at least one ' ' game is not finished
	public static boolean draw(char[][] array){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(array[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
	//method that checks if the game has ended
	public static boolean Check(boolean X_won, boolean O_won, boolean draw){
		if(X_won) {
			System.out.println("X wins");
			return true;
		}
		if(O_won) {
			System.out.println("O wins");
			return true;
		}
		if(draw) {
			System.out.println("Draw");
			return true;
		}
		return false;
	}
	//method ending game
	public static void End(boolean a){
    	if(a)
    		System.exit(0);
	}
}
