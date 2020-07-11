package com.maximilianobrignone.sudoku.view.sudokugrid;

import com.maximilianobrignone.sudoku.GameEngine;
import com.maximilianobrignone.sudoku.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SudokuCell extends BaseSudokuCell{
	
	private Paint mPaint;
	
	public SudokuCell(Context context){
		super(context);
		
		mPaint = new Paint();
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		
		drawNumber(canvas);
		drawLines(canvas);
	}
	
	private void drawLines(Canvas canvas) {
		mPaint.setColor(Color.BLACK);
		mPaint.setStrokeWidth(3);
		mPaint.setStyle(Style.STROKE);
		
		canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
	}

	private void drawNumber(Canvas canvas){
		//mPaint.setColor(Color.BLACK);
		mPaint.setColor(Color.rgb(0, 102, 254));
		mPaint.setTextSize(30);
		mPaint.setStyle(Style.FILL);
		
		Rect bounds = new Rect();
		mPaint.getTextBounds(String.valueOf(getNumber()), 0, String.valueOf(getNumber()).length(), bounds);
		
		if (getNumber() != 0){
			canvas.drawText(String.valueOf(getNumber()),(getWidth() - bounds.width()) / 2, (getHeight() + bounds.height()) / 2, mPaint);
			
		}
	}
}

