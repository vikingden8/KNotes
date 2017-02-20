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
package com.viking.knotes;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.viking.knotes.utils.Constants;

import java.util.Locale;

/**
 * description
 * author : Viking Den <vikingden@live.com>
 * time   : 2017/2/20 23:55
 */
public class KNotesApplication extends Application {

    private static Context mContext;

    private final static String PREF_LANG = "settings_language";

    static SharedPreferences prefs;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        prefs = getSharedPreferences(Constants.PREFS_NAME, MODE_MULTI_PROCESS);

        if (isDebugBuild()) {
            StrictMode.enableDefaults();
        }

        // Checks selected locale or default one
        updateLanguage(this, null);
    }

    @NonNull
    public static boolean isDebugBuild() {
        return BuildConfig.BUILD_TYPE.equals("debug");
    }

    @Override
    // Used to restore user selected locale when configuration changes
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String language = prefs.getString(PREF_LANG, "");
        super.onConfigurationChanged(newConfig);
        updateLanguage(this, language);
    }

    public static Context getAppContext() {
        return KNotesApplication.mContext;
    }

    /**
     * Updates default language with forced one
     */
    public static void updateLanguage(Context ctx, String lang) {
        Configuration cfg = new Configuration();
        String language = prefs.getString(PREF_LANG, "");

        if (TextUtils.isEmpty(language) && lang == null) {
            cfg.locale = Locale.getDefault();
            Log.i(Constants.TAG , "cfg.locale : " + cfg.locale.toString()) ;
            prefs.edit().putString(PREF_LANG, cfg.locale.toString()).apply();
        } else if (lang != null) {
            cfg.locale = getLocale(lang);
            prefs.edit().putString(PREF_LANG, lang).apply();
        } else if (!TextUtils.isEmpty(language)) {
            cfg.locale = getLocale(language);
        }
        ctx.getResources().updateConfiguration(cfg, null);
    }

    /**
     * Checks country AND region
     */
    private static Locale getLocale(String lang) {
        if (lang.contains("_")) {
            return new Locale(lang.split("_")[0], lang.split("_")[1]);
        } else {
            return new Locale(lang);
        }
    }


    /**
     * Statically returns app's default SharedPreferences instance
     * @return SharedPreferences object instance
     */
    public static SharedPreferences getSharedPreferences(){
        return getAppContext().getSharedPreferences(Constants.PREFS_NAME, MODE_MULTI_PROCESS);
    }
}
