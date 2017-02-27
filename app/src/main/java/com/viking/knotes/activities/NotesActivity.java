package com.viking.knotes.activities;

import android.os.Bundle;

import com.viking.knotes.R;

public class NotesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.KNotesTheme_ApiSpec);
        setContentView(R.layout.activity_notes);
    }
}
