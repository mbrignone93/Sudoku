package com.maximilianobrignone.sudoku.view.sudokugrid;

import android.content.Context;
import android.view.View;

public class BaseSudokuCell extends View{
	
	private int number;
	private boolean modifiable = true;

	public BaseSudokuCell(Context context) {
		super(context);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}
	
	public void setNotModifiable(){
		modifiable = false;
	}
	
	public void setInitNumber(int number){
		this.number = number;
		invalidate();
	}
	
	public void setNumber(int number){
		if (modifiable){
			this.number = number;
		}
		invalidate();
	}
	
	public int getNumber(){
		return number;
	}
}
