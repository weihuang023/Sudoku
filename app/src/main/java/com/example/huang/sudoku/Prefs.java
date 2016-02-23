package com.example.huang.sudoku;

import android.os.Bundle;
import android.content.Context;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

    // Setting Menu Preference add Preferences From Resource
    public class Prefs extends PreferenceActivity {
        // Option names and default values
        private static final String OPT_MUSIC = "music";
        private static final boolean OPT_MUSIC_DEF = true;
        private static final String OPT_HINTS = "hints";
        private static final boolean OPT_HINTS_DEF = true;

        @SuppressWarnings("deprecation")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }
        // get the current value of the option
        public static boolean getMusic(Context context){
            return PreferenceManager.getDefaultSharedPreferences(context)
                    .getBoolean(OPT_MUSIC,OPT_MUSIC_DEF);
        }

        // get the current value of the hint option
        public static boolean getHints(Context context){
            return PreferenceManager.getDefaultSharedPreferences(context)
                    .getBoolean(OPT_HINTS,OPT_HINTS_DEF);
        }
    }
