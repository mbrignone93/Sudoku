package com.maximilianobrignone.sudoku;

import android.content.Context;

import com.maximilianobrignone.sudoku.view.sudokugrid.GameGrid;

public class GameEngine {
	private static GameEngine instance;
	
	private GameGrid grid = null;
	
	private int selectedPosX = -1;
	private int selectedPosY = -1;
	
	private GameEngine(){}
	
	public static GameEngine getInstance(){
		if (instance == null){
			instance = new GameEngine();
		}
		
		return instance;
	}
	
	public void createGrid(Context context){
		int [][] Sudoku = SudokuGenerator.getInstance().generateGrid();
		Sudoku = SudokuGenerator.getInstance().removeElements(Sudoku);
		grid = new GameGrid(context);
		grid.setGrid(Sudoku);
	}
	
	public GameGrid getGrid(){
		return grid;
	}
	
	public void setSelectedPosition(int x, int y){
		selectedPosX = x;
		selectedPosY = y;
	}
	
	public void setNumber(int number){
		if (selectedPosX != 1 && selectedPosY != -1){
			grid.setItem(selectedPosX, selectedPosY, number);
		}
		grid.checkSolved();
	}
}
