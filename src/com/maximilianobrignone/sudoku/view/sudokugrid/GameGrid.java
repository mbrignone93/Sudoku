package com.maximilianobrignone.sudoku.view.sudokugrid;

import com.maximilianobrignone.sudoku.SudokuChecker;

import android.content.Context;
import android.widget.Toast;

public class GameGrid {
	private SudokuCell[][] Sudoku = new SudokuCell[9][9];
	
	private Context context;
	
	public GameGrid(Context context){
		this.context = context;
		for (int x = 0; x < 9; x++){
			for (int y = 0; y < 9; y++){
				Sudoku[x][y] = new SudokuCell(context);
			}
		}
	}
	
	public void setGrid(int[][] grid){
		for (int x = 0; x < 9; x++){
			for (int y = 0; y < 9; y++){
				Sudoku[x][y].setInitNumber(grid[x][y]);
				if (grid[x][y] != 0){
					Sudoku[x][y].setNotModifiable();
				}
			}
		}
	}
	
	public SudokuCell[][] getGrid(){
		return Sudoku;
	}
	
	public SudokuCell getItem(int x, int y){
		return Sudoku[x][y];
	}
	
	public SudokuCell getItem(int position){
		int x = position % 9;
		int y = position / 9;
		
		return Sudoku[x][y];
	}
	
	public void setItem(int x, int y, int number){
		Sudoku[x][y].setNumber(number);
	}
	
	public void checkSolved(){
		int [][] sudGrid = new int[9][9];
		for (int x = 0; x < 9; x++){
			for (int y = 0; y < 9; y++){
				sudGrid[x][y] = getItem(x, y).getNumber();
			}
		}
		
		if (SudokuChecker.getInstance().checkSudoku(sudGrid)){
			Toast.makeText(context, "Sudoku Resuelto!!!", Toast.LENGTH_LONG).show();
		}
	}
}
