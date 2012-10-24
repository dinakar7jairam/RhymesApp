package com.anicha.rhymesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class GetInputActivity extends Activity {

    public static final String EXTRA_MESSAGE =  "com.anicha.rhymesApp.MESSAGE";

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

    /** Called when the user clicks the Send button */
    public void getRhymingWords(View view) {
    	  Intent intent = new Intent(this, DisplayMessageActivity.class);
    	    EditText editText = (EditText) findViewById(R.id.edit_message);
    	    String message = editText.getText().toString();
    	    //getString(R.string.rhyme_cat);
    	    intent.putExtra(EXTRA_MESSAGE, getString(R.string.rhyme_at));
    	    startActivity(intent);
    }

}
