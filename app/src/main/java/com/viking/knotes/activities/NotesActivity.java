package com.viking.knotes.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.viking.knotes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NotesActivity extends BaseActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.KNotesTheme_ApiSpec);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
        initUI();

/*        if (IntroActivity.mustRun()) {
            startActivity(new Intent(this.getApplicationContext(), IntroActivity.class));
        }*/
    }

    private void initUI() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
