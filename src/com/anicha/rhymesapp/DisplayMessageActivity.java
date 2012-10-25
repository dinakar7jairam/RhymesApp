package com.anicha.rhymesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	private static final String TAG = "DisplayMessageActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "onCreate" );
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(GetInputActivity.EXTRA_MESSAGE);
        
        EditText outputBox = (EditText) findViewById(R.id.outputBox);
        Log.v(TAG, "outputBox"+outputBox );
        outputBox.setText(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_message, menu);
        Log.v(TAG, "onCreateOptionsMenu" );
        return true;
    }
}
