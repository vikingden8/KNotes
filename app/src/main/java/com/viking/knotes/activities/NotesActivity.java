/*
 * Copyright (C) 2017 Viking Den <vikingden@live.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
