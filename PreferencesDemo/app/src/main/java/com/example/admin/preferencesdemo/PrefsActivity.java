package com.example.admin.preferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;

public class PrefsActivity extends PreferenceActivity implements  Preference.OnPreferenceChangeListener{
    //Preference.OnPreferenceClickListener,
    public static final String KEY_PREF_BASKET = "basketListpref";
    //FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
        //EditTextPreference editTextPreference= findViewById(R.xml.prefs.)
        Preference myPref = (Preference) findPreference("password");
        //myPref.setOnPreferenceClickListener(this);
        myPref.setOnPreferenceChangeListener(this);


    }

   /* @Override
    public boolean onPreferenceClick(Preference preference) {

        Intent intent = new Intent(PrefsActivity.this,Main2Activity.class);
        startActivity(intent);
        return true;

    }*/

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
       // return false;
        Intent intent = new Intent(PrefsActivity.this,Main2Activity.class);
        startActivity(intent);
        return true;
    }

    //@Override
    /*@Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        //IT NEVER GETS IN HERE!
        if (key.equals(KEY_PREF_BASKET))
        {
            // Set summary to be the user-description for the selected value
            //Preference exercisesPref = findPreference(key);
            //exercisesPref.setSummary(sharedPreferences.getString(key, ""));
            //DialogFragment dFragment = new DialogFragment();
            //dFragment.show()
            //dFragment.show(fm, "Basket Preference Successfully Changed");
            Intent intent = new Intent(PrefsActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        Intent intent = new Intent(PrefsActivity.this,Main2Activity.class);
        startActivity(intent);
    }*/
}
