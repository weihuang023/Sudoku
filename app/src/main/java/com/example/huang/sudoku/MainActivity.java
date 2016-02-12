package com.example.huang.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Up Click listener for all the Buttons
        View continueButton = findViewById(R.id.button);
        continueButton.setOnClickListener(this);
        View newButton = findViewById(R.id.button2);
        newButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.button3);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.button4);
        exitButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Log.d(TAG,"DOES NOT WORK");
                break;
            case R.id.button2:
                openNewGameDialog();
                break;
            case R.id.button3:
                Intent i3 = new Intent(this,About.class);
                startActivity(i3);
                break;
            case R.id.button4:
                finish();
                break;
        }
    }

    private static final String TAG = "Sudoku";

    private void openNewGameDialog(){
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                        startGame(i);
                    }
                }).show();
    }

    private void startGame(int i){
        Log.d(TAG," Click on " + i);
        //Start Game here ...
        Intent intent = new Intent(MainActivity.this,Game.class);
        intent.putExtra(Game.KEY_DIFFICULTY,i);
        startActivity(intent);
    }

    // Setting Menu and MenuInflater
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Setting Item
    // Intent in Prefs.Class
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Prefs.class));
                return true;
        }
        return false;
    }
}
