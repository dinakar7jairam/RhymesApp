package com.anicha.rhymesapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GetInputActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_input);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_get_input, menu);
        return true;
    }
}
