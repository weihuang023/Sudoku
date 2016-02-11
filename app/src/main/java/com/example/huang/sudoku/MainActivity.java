package com.example.huang.sudoku;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

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
            case R.id.button3:
                Intent i = new Intent(this,About.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

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
