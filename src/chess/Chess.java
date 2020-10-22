package chess;

import java.util.Scanner;

import chess.pieces.Bishop;
import chess.pieces.Empty;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */

public class Chess {
	
	public static Chess[][] chess_board = new Chess[8][8];
	
	//this method initializes the board
	public static void initBoard() {
		chess_board[0][0] = new Rook("bR", "black");
		chess_board[0][1] = new Knight("bN", "black");
		chess_board[0][2] = new Bishop("bB", "black");
		chess_board[0][3] = new Queen("bQ", "black");
		chess_board[0][4] = new King("bK", "black");
		chess_board[0][5] = new Bishop("bB", "black");
		chess_board[0][6] = new Knight("bN", "black");
		chess_board[0][7] = new Rook("bR", "black");
		chess_board[1][0] = new Pawn("bp", "black");
		chess_board[1][1] = new Pawn("bp", "black");
		chess_board[1][2] = new Pawn("bp", "black");
		chess_board[1][3] = new Pawn("bp", "black");
		chess_board[1][4] = new Pawn("bp", "black");
		chess_board[1][5] = new Pawn("bp", "black");
		chess_board[1][6] = new Pawn("bp", "black");
		chess_board[1][7] = new Pawn("bp", "black");
		
		for(int i=2; i<6; i++) {
			for(int j=0; j<chess_board[0].length; j++) {
				if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)) {
					chess_board[i][j] = new Empty("  ", "white");
				}
				if((i%2==0 && j%2!=0) || (i%2!=0 && j%2==0)) {
					chess_board[i][j] = new Empty("##", "black");
				}
			}
		}
		
		chess_board[7][0] = new Rook("wR", "white");
		chess_board[7][1] = new Knight("wN", "white");
		chess_board[7][2] = new Bishop("wB", "white");
		chess_board[7][3] = new Queen("wQ", "white");
		chess_board[7][4] = new King("wK", "white");
		chess_board[7][5] = new Bishop("wB", "white");
		chess_board[7][6] = new Knight("wN", "white");
		chess_board[7][7] = new Rook("wR", "white");
		chess_board[6][0] = new Pawn("wp", "white");
		chess_board[6][1] = new Pawn("wp", "white");
		chess_board[6][2] = new Pawn("wp", "white");
		chess_board[6][3] = new Pawn("wp", "white");
		chess_board[6][4] = new Pawn("wp", "white");
		chess_board[6][5] = new Pawn("wp", "white");
		chess_board[6][6] = new Pawn("wp", "white");
		chess_board[6][7] = new Pawn("wp", "white");
		
	}
	//this method returns the id of the piece
	public String getId() {
		return "";
	}
	//this method return the color of the piece
	public String getColor() {
		return "";
	}
	//this method checks to see if the move is valid for that piece
	public boolean isValid(int[] start, int[] destination) {
		return false;
	}
	//this method checks to see if it is a pawn's first move
	public boolean isfirstMove() {
		return true;
	}
	//this method sets the pawn boolean field of first move
	public void setPawnFirst(boolean boo) {
	}
	//this method sets the pawn's boolean two-step field to true to indicate it made a 2-step move
	public void setTwoStep(boolean b) {	
	}
	//this method gets the pawn's boolean to see if it made a 2-step move
	public boolean getTwoStep() {
		return false;
	}
	//this method returns the count of the pawn that is out of original place
	public int getCount() {
		return 0;
	}
	//this method set's the count of the pawn out of original position
	public void setCount(int i) {
	}
	//only used in king class
	public boolean isCheck(int x, int y) {
		return false;
	}
	
	//this method prints the board
	public static void printBoard() {
		int[] arr = {8,7,6,5,4,3,2,1};
		char[] arr2 = {'a','b','c','d','e','f','g','h'};
		for(int i=0; i<chess_board.length; i++) {
			for(int j=0; j<chess_board[0].length; j++) {
				System.out.print(chess_board[i][j].getId() + " ");
			}
			System.out.print(arr[i]);
			System.out.println();
		}
		System.out.print(" "+ arr2[0]);
		for(int i=1; i<arr.length; i++) {
			System.out.print("  " + arr2[i]);
		}
		System.out.println();
		System.out.println();
		
	}
	
	//this method updates the board
	public static void updateBoard(int[] start_indexes, int[] destination_indexes, String move) {
		//check to see if a promotion is occurring
		//check to see if pawn reaches the end index
		//if the pawn reaches the end index automatically set pawn to queen if promotion type is not specified
		if(move.length() == 5 && chess_board[start_indexes[0]][start_indexes[1]].getId().equals("wp") && destination_indexes[0] == 0) {
			//set pawn destination to queen
			chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("wQ", "white");
			//set original spot to empty
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//pawn reaches end and promotion type is specified
		if(move.length() == 7 && chess_board[start_indexes[0]][start_indexes[1]].getId().equals("wp") && destination_indexes[0] == 0) {
			switch(move.charAt((6))) {
				case 'R':
					//set pawn destination to rook
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Rook("wR", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'N':
					//set pawn destination to knight
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Knight("wN", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'B':
					//set pawn destination to bishop
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Bishop("wB", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'Q':
					//set pawn destination to queen
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("wQ", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				default:
					//set pawn destination to queen
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("wQ", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
			}
			return;
		}
		
		//regular updating the board (non-promotion)
		chess_board[destination_indexes[0]][destination_indexes[1]] = chess_board[start_indexes[0]][start_indexes[1]];
		//every time we update the board we must increase the count of the pawn to indicate the time out of it's original place
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(chess_board[i][j].getId().equals("wp") && (i != 6)) {
					chess_board[i][j].setCount(chess_board[i][j].getCount()+1);
				}
				if(chess_board[i][j].getId().equals("bp") && (i != 1)) {
					chess_board[i][j].setCount(chess_board[i][j].getCount()+1);
				}
			}
		}
		//check to see if we are performing an en passant
		int start_i = start_indexes[0];
		int start_j = start_indexes[1];
		int dest_i = destination_indexes[0];
		int dest_j = destination_indexes[1];
		//white is moving up left
		if(chess_board[start_i][start_j].getId().equals("wp") && (dest_i == start_i-1 && dest_j == start_j-1) 
				&& (chess_board[start_i][start_j-1].getId().equals("bp"))) {
			//remove the black piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j-1%2==0) || (start_i%2!=0 && start_j-1%2!=0)) {
				chess_board[start_i][start_j-1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j-1%2!=0) || (start_i%2!=0 && start_j-1%2==0)) {
				chess_board[start_i][start_j-1] = new Empty("  ", "white");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//white is moving up right
		if(chess_board[start_i][start_j].getId().equals("wp") && (dest_i == start_i-1 && dest_j == start_j+1) 
				&& (chess_board[start_i][start_j+1].getId().equals("bp"))) {
			//remove the black piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j+1%2==0) || (start_i%2!=0 && start_j+1%2!=0)) {
				chess_board[start_i][start_j+1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j+1%2!=0) || (start_i%2!=0 && start_j+1%2==0)) {
				chess_board[start_i][start_j+1] = new Empty("##", "black");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//black is moving down right
		if(chess_board[start_i][start_j].getId().equals("bp") && (dest_i == start_i+1 && dest_j == start_j+1) 
				&& (chess_board[start_i][start_j+1].getId().equals("wp"))) {
			//remove the white piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j+1%2==0) || (start_i%2!=0 && start_j+1%2!=0)) {
				chess_board[start_i][start_j+1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j+1%2!=0) || (start_i%2!=0 && start_j+1%2==0)) {
				chess_board[start_i][start_j+1] = new Empty("##", "black");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//black is moving down left
		if(chess_board[start_i][start_j].getId().equals("bp") && (dest_i == start_i+1 && dest_j == start_j-1) 
				&& (chess_board[start_i][start_j-1].getId().equals("wp"))) {
			System.out.println("Hello");
			//remove the white piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j-1%2==0) || (start_i%2!=0 && start_j-1%2!=0)) {
				chess_board[start_i][start_j-1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j-1%2!=0) || (start_i%2!=0 && start_j-1%2==0)) {
				chess_board[start_i][start_j-1] = new Empty("##", "black");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
			chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
		}
		if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
			chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
		}
	}

	//traverses the board to check if the board is in a check state
	private static boolean check() {
		//first find the king
		Chess temp;
		Chess black_king = chess_board[0][4];
		int[] bpos = new int[]{0,4};
		Chess white_king = chess_board[7][4];
		int[] wpos = new int[]{7,4};
		for(int i = 0; i < chess_board.length; i++){
			for(int j = 0; j < chess_board[0].length; j++){
				temp = chess_board[i][j];
				if(temp.getId().equals("bK")){
					black_king = temp;
					bpos = new int[]{i,j};
				}
				if(temp.getId().equals("wK")){
					white_king = temp;
					wpos = new int[]{i,j};
				}
			}
		}
		//check if either of the kings are currently in check
		if(black_king.isCheck(bpos[0], bpos[1])){
			System.out.println("Check");
			int[][] options = {new int[]{-1,1}, new int[]{0,1}, new int[]{1,1}, new int[]{-1,0}, new int[]{1,0}, new int[]{-1,-1}, new int[]{0,-1}, new int[]{1,-1}};
			//try to make all possible moves
			for (int[] i : options){
				if(black_king.isValid(bpos, new int[]{bpos[0]+i[0], bpos[1]+i[1]}) && !black_king.occupy(bpos, new int[]{bpos[0]+i[0], bpos[1]+i[1]})){
					return false;
				}
			}
			System.out.println("Checkmate");
			System.out.println("White wins");
			return true;

		} else if(white_king.isCheck(wpos[0], wpos[1])){
			System.out.println("Check");
			int[][] options = {new int[]{-1,1}, new int[]{0,1}, new int[]{1,1}, new int[]{-1,0}, new int[]{1,0}, new int[]{-1,-1}, new int[]{0,-1}, new int[]{1,-1}};
			//try to make all possible moves
			for (int[] i : options){
				if(black_king.isValid(bpos, new int[]{bpos[0]+i[0], bpos[1]+i[1]}) && !black_king.occupy(bpos, new int[]{bpos[0]+i[0], bpos[1]+i[1]})){
					return false;
				}
			}
			System.out.println("Checkmate");
			System.out.println("Black wins");
			return true;
		}
		return false;
	}

	//this method returns the indexes of the inputed position in the 2d array
	public static int[] find_indexes(String str) {
		int[] arr = new int[2];
		switch(Character.getNumericValue(str.charAt(1))) {
		case 1:
			arr[0] = 7;
			break;
		case 2:
			arr[0] = 6;
			break;
		case 3:
			arr[0] = 5;
			break;
		case 4:
			arr[0] = 4;
			break;
		case 5:
			arr[0] = 3;
			break;
		case 6:
			arr[0] = 2;
			break;
		case 7:
			arr[0] = 1;
			break;
		case 8:
			arr[0] = 0;
			break;
		default:
			arr[0] = 8;
		}
		switch(str.charAt(0)) {
		case 'a':
			arr[1] = 0;
			break;
		case 'b':
			arr[1] = 1;
			break;
		case 'c':
			arr[1] = 2;
			break;
		case 'd':
			arr[1] = 3;
			break;
		case 'e':
			arr[1] = 4;
			break;
		case 'f':
			arr[1] = 5;
			break;
		case 'g':
			arr[1] = 6;
			break;
		case 'h':
			arr[1] = 7;
			break;
		default:
			arr[1] = 8;
		}
		return arr;
	}
	
	//this method checks to see if the spot is occupied by its own team piece
	public static boolean occupy(int[] start, int[] destination) {
		//check to see if destination is occupied by team chess piece
		if(chess_board[start[0]][start[1]].getId().charAt(0) == chess_board[destination[0]][destination[1]].getId().charAt(0)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initBoard();
		printBoard();
		
		boolean check = true;
		int[] start_indexes = new int[2];
		int[] destination_indexes = new int[2];
		boolean draw = false;
		while(true) {
			//white's turn
			if(check == true) {
				System.out.print("White's move: ");
				Scanner scan = new Scanner(System.in);
				String move = scan.nextLine();
				//checking to see if player resigned
				if(move.equals("resign")) {
					System.out.println("Black wins");
					return;
				}
				//check to see if game ends in draw
				if(draw == true && move.equals("draw")) {
					return;
				}
				//reset the draw boolean
				draw = false;
				String start = move.substring(0,2);
				String destination = move.substring(3,5);
				start_indexes = find_indexes(start);
				destination_indexes = find_indexes(destination);
				//checking to see if player is making a move on a white piece
				if(chess_board[start_indexes[0]][start_indexes[1]].getId().charAt(0) != 'w') {
					System.out.println("Illegal move, try again");
					continue;
				}
				//checking if indexes are out of bounds
				if(start_indexes[0] == 8 || start_indexes[1] == 8 || destination_indexes[0] == 8 || destination_indexes[1] == 8) {
					System.out.println("Illegal move, try again");
					continue;
				}
				boolean occupy = occupy(start_indexes,destination_indexes);
				//checks if the move is valid for the piece
				if(!chess_board[start_indexes[0]][start_indexes[1]].isValid(start_indexes,destination_indexes) || occupy == true) {
					System.out.println("Illegal move, try again");
				}
				//if valid move, update board and set to black's move
				else{
					if(move.length() > 5) {
						//checking to see if user wants to request a draw
						if(draw == false && move.substring(6).equals("draw?")) {
							draw = true;
						}
					}
					//update the board
					updateBoard(start_indexes, destination_indexes,move);
					//print the board
					System.out.println();
					printBoard();
					//setting to black's turn
					check = false;
				}
			}
			//black's turn
			if(check == false) {
				System.out.print("Black's move: ");
				Scanner scan = new Scanner(System.in);
				String move = scan.nextLine();
				//checking to see if player resigned
				if(move.equals("resign")) {
					System.out.println("White wins");
					return;
				}
				//check to see if game ends in draw
				if(draw == true && move.equals("draw")) {
					return;
				}
				//reset the draw boolean
				draw = false;
				String start = move.substring(0,2);
				String destination = move.substring(3);
				start_indexes = find_indexes(start);
				destination_indexes = find_indexes(destination);
				//checking to see if player is making a move on a white piece
				if(chess_board[start_indexes[0]][start_indexes[1]].getId().charAt(0) != 'b') {
					System.out.println("Illegal move, try again");
					continue;
				}
				//checking if indexes are out of bounds
				if(start_indexes[0] == 8 || start_indexes[1] == 8 || destination_indexes[0] == 8 || destination_indexes[1] == 8) {
					System.out.println("Illegal move, try again");
					continue;
				}
				boolean occupy = occupy(start_indexes,destination_indexes);
				//checks if the move is valid for the piece
				if(!chess_board[start_indexes[0]][start_indexes[1]].isValid(start_indexes,destination_indexes) || occupy == true) {
					System.out.println("Illegal move, try again");
				}
				//if valid move, update board and set to white's move
				else{
					//check to see if user wants to request a draw
					if(move.length()> 5) {
						if(draw == false && move.substring(6).equals("draw?") ) {
							draw = true;
						}
					}
					//update the board
					updateBoard(start_indexes, destination_indexes, move);
					//print board
					System.out.println();
					printBoard();
					//setting to white's turn
					check = true;
				}
			}
			if(check()){
				//this is a checkmate
				break;
			}

		}

	}

}
