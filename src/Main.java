import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int myScore = 0;
	static int computerScore = 0;
	public static void main(String[] args) {
		boolean finished = false;
		while(!finished) {
			myScore = 0;
			computerScore = 0;
			Moves myMove1 = enterMove();
			Moves computerMove1 = createMove();
			updateScore(myMove1, computerMove1);
			Moves myMove2 = enterMove();
			Moves computerMove2 = createMove();
			updateScore(myMove2, computerMove2);
			Moves myMove3 = enterMove();
			Moves computerMove3 = createMove();
			updateScore(myMove3, computerMove3);
			System.out.println("My Score: "+myScore);
			System.out.println("Computer Score: "+computerScore);
			if(myScore > computerScore)
				System.out.println("Congrats. You have won");
			else
				System.out.println("The computer has defeated you");
			System.out.println("Repeat? (Y/N)");
			if(scan.nextLine().equals("N"))
				finished = true;
		}
	}
	public static void updateScore(Moves movePlayer1, Moves movePlayer2) {
		if(movePlayer1 == movePlayer2)
			;//Do nothing
		else if(movePlayer1 == Moves.Paper && movePlayer2 == Moves.Rock
				|| movePlayer1 == Moves.Rock && movePlayer2 == Moves.Scissors
				|| movePlayer1 == Moves.Scissors && movePlayer2 == Moves.Paper)
			myScore++;
		else
			computerScore++;
	}
	public static Moves enterMove() {
		try {
			System.out.println("Enter your move (Rock/Paper/Scissors)");
			return Moves.valueOf(scan.nextLine());
		}catch(IllegalArgumentException e) {
			System.out.println("ERROR: The value you entered is typed wrong.");
			return enterMove();
		}
	}
	public static Moves createMove() {
		int randomMoveInt = (int)Math.round(Math.random()*3);
		switch(randomMoveInt) {
        case 0:
        	System.out.println("The computer chose Rock");
            return Moves.Rock;
        case 1:
        	System.out.println("The computer chose Paper");
            return Moves.Paper;
        case 2:
        	System.out.println("The computer chose Scissors");
        	return Moves.Scissors;
    	default:
    		System.out.println("This should never happen");
    		return Moves.Rock;
        }
	}
}
