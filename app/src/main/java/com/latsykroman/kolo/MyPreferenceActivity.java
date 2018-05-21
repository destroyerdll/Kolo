package com.latsykroman.kolo;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.widget.Toast;

/**
 * Created by Latsyk Roman on 18.04.2018.
 */

public class MyPreferenceActivity extends PreferenceActivity {
    Intent close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }


    @Override
    protected void onResume() {
        super.onResume();
        PreferenceScreen exit = (PreferenceScreen) findPreference("exit");
        PreferenceScreen about = (PreferenceScreen) findPreference("about");

        exit.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                close = new Intent(MyPreferenceActivity.this, MainActivity.class);
                close.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                close.putExtra("EXIT", true);
                startActivity(close);
                return false;
            }
        });

        about.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(MyPreferenceActivity.this, "База даних друкарні Коло " +
                        "Розробник: Лацик Роман", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
