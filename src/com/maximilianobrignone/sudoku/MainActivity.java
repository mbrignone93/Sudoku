package com.maximilianobrignone.sudoku;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        GameEngine.getInstance().createGrid(this);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu){
    	getMenuInflater().inflate(R.menu.activity_main, menu);
    	return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item){
    	int id = item.getItemId();
    	if (id == R.id.nuevoJuego){
    		reload();
    	}
    	else
    	{
    		if (id == R.id.acercaDe){
    			Toast.makeText(this, "© 2020 Prog. Maximiliano Brignone", Toast.LENGTH_LONG).show();
    		}
    		else
    		{
    			if (id == R.id.salir){
    				finish();
    			}
    		}
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
