package com.example.huang.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Huang on 2/11/2016.
 */
public class Game extends Activity {

    private static final String TAG = "Sudoku";

    public static final String KEY_DIFFICULTY = "com.example.huang.sudoku.difficulty";
    public static final int DIFFICULTY_EASY = 0;
    public static final int DIFFICULTY_MEDIUM = 1;
    public static final int DIFFICULTY_HARD = 2;

    private int puzzle[] = new int [ 9 * 9 ];
    private PuzzleView puzzleView;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        Log.d(TAG, "onCreate");
        int diff = getIntent().getIntExtra(KEY_DIFFICULTY,DIFFICULTY_EASY);
        puzzle = getPuzzle(diff);
        calculateUsedTiles();

        puzzleView = new PuzzleView(this);
        setContentView(puzzleView);
        puzzleView.requestFocus();
    }
    // ....
}
