package com.maximilianobrignone.sudoku.view.sudokugrid;

import com.maximilianobrignone.sudoku.GameEngine;
import com.maximilianobrignone.sudoku.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class SudokuGridView extends GridView{

	private final Context context;
	
	public SudokuGridView(final Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this.context = context;
		
		SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);
		
		setAdapter(gridViewAdapter);
		
		setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				
				int x = position % 9;
				int y = position / 9;
				
				GameEngine.getInstance().setSelectedPosition(x,  y);
			}
			
		});
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}

class SudokuGridViewAdapter extends BaseAdapter{

	private Context context;
	
	public SudokuGridViewAdapter(Context context){
		
		this.context = context;
	}
	
	@Override
	public int getCount() {
		
		return 81;
	}

	@Override
	public Object getItem(int arg0) {
		
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		return GameEngine.getInstance().getGrid().getItem(position);
	}

}
