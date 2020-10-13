package chess.pieces;

import chess.Chess;

public class Rook extends Chess{
	String id = "";
	String color = "";
	
	public Rook(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
	//method to check if move is valid
	public boolean isValid(int[] start, int[] dest) {
		/*rook can only move up/down or left/right any number of spaces */
		
		//start_i represents current row, start_j represents current column
		int start_i = start[0];
		int start_j = start[1];
		//dest_i represents destination row, dest_j represents destination col
		int dest_i = dest[0];
		int dest_j = dest[1];
		//check if move goes out of bounds
		if(dest_i > 7 || dest_i < 0) {
			return false;
		}
		if(dest_j > 7 || dest_j < 0) {
			return false;
		}
		//movement up/down
		if(start_j == dest_j && start_i != dest_i) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_i < dest_i) {
				for(int i=start_i+1; i<dest_i; i++) {
					if((chess_board[i][start_j].getId() != "  ") && (chess_board[i][start_j].getId() != "##")) {
						return false;
					}
				}
			}
			else {
				for(int i=start_i-1; i>dest_i; i--) {
					if((chess_board[i][start_j].getId() != "  ") && (chess_board[i][start_j].getId() != "##")) {
						return false;
					}
				}
			}
			return true;
		}
		//movement left/right
		if(start_i == dest_i && start_j != dest_j) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_j < dest_j) {
				for(int j=start_j+1; j<dest_j; j++) {
					if((chess_board[start_i][j].getId() != "  ") && (chess_board[start_i][j].getId() != "##")) {
						return false;
					}
				}
			}
			else {
				for(int j=start_j-1; j>dest_j; j--) {
					if((chess_board[start_i][j].getId() != "  ") && (chess_board[start_i][j].getId() != "##")) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
}
