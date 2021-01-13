import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		while(true){
			System.out.println("_____________\n Welcome\n_____________\n Press 'S' for SlotGame\n Press 'X' to Exit");
			Scanner scan = new Scanner(System.in);
			SlotGame game = new SlotGame();
			String choose_game = scan.next().toLowerCase();
			if(choose_game.equals("s")){
				game.start_game();
			}
			else if(choose_game.equals("x")){
				System.exit(0);
			}
			else{
				continue;
			}
		}
	}
}