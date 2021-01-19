import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class SlotGame{
	private boolean game_started = true;
	private int money;
	private String result;
	ArrayList<String> history = new ArrayList<String>();;
	Scanner scan = new Scanner(System.in);

	public int start_game(){
		System.out.println("_____________\n Welcome to SlotGame\n_____________");

		while(true){
			System.out.println("\nPress 'Y' and hit Enter to spin" + "\nPress 'H' to look at history" + 
			"\nPress 'X' and hit enter to exit");
			String spin = scan.next().toLowerCase();
			if (spin.equals("y")){
				play();
				history.add(result);
			}
			else if(spin.equals("h")){
				for(String latest_spin : history) {
			    	System.out.println(latest_spin);
			   	}
			}
			else if(spin.equals("x")){
				System.out.println("Final result is " + money);
				System.exit(0);
			}
			else{
				continue;
			}
		}
	}

	public void enter_money(){
		Scanner scan = new Scanner(System.in);
		if(game_started){
			System.out.println("How much money are you playing for?");
			money = scan.nextInt();
			game_started = false;
		}
	}

	public void play(){
		enter_money();

		Random rand = new Random();
		int[] nums1 = new int[10];
		int[] nums2 = new int[10];
		int[] nums3 = new int[10];	

		for (int i = 0; i < nums1.length; i++){
		    nums1[i] = rand.nextInt(4-1)+1; 
		    int result1 = nums1[9];
		    nums2[i] = rand.nextInt(4-1)+1; 
		    int result2 = nums2[9];
		    nums3[i] = rand.nextInt(4-1)+1; 
		    int result3 = nums3[9];
		    result = nums1[i] + " " + nums2[i] + " " +  nums3[i] + "\r";
		    System.out.print(result);
		    try {
				    Thread.sleep(100);               
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
		    if (i == 9){
		    	System.out.print("_____________\n" + result1 + " " + result2 + " " + result3 + "\n_____________");
	    		if ((result1 == result2) && (result1 == result3)){
	    			money += 15;
					System.out.println("\nYou won \nCurreny money is " + money);
				}
				else {
					money -= 1;
					System.out.println("\nTry again \nCurrent money is " + money);
				}
		    }
		}
	}
}
