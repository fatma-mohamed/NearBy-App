package com.example.nearby.data.local;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.nearby.R;

import static com.example.nearby.data.local.Constants.KEY_ACTION_MODE;
import static com.example.nearby.data.local.Constants.VALUE_ACTION_MODE_REALTIME;

public class SharedPreferencesManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public SharedPreferencesManager(Activity activity) {
        pref = activity.getSharedPreferences(activity.getString(R.string.app_name)+"Pref", 0); // 0 - for private mode
        editor = pref.edit();
        if(getValue(KEY_ACTION_MODE).equals("")) {
            save(KEY_ACTION_MODE, VALUE_ACTION_MODE_REALTIME);
        }
    }

    public void save(String key, String value) {
        editor.putString(key,value);
        editor.apply();
    }

    public String getValue(String key) {
        return pref.getString(key, "");
    }
}
