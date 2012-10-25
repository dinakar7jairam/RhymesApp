package com.anicha.rhymesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class GetInputActivity extends Activity implements TextWatcher{

	private static final String TAG = "GetInputActivity";
    public static final String EXTRA_MESSAGE =  "com.anicha.rhymesApp.MESSAGE";
	/** The Constant LINE_SEPARATOR. */
	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	AutoCompleteTextView myAutoComplete;
	String item[]={
	  "an", "at", "un", "ound",
	  "May", "June", "July", "August",
	  "September", "October", "November", "December"
	};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_input);
        Log.v(TAG, "onCreate" );

        myAutoComplete = (AutoCompleteTextView)findViewById(R.id.inputWord);
       
        myAutoComplete.addTextChangedListener(this);
        myAutoComplete.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item));
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_get_input, menu);
        Log.v(TAG, "onCreateOptionsMenu" );
        return true;
    }

    /** Called when the user clicks the Send button */
    public void getRhymingWords(View view) {
    	   Log.v(TAG, "getRhymingWords" );
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	    EditText editText = (EditText) findViewById(R.id.inputWord);
    	    String input = editText.getText().toString();
    	    intent.putExtra(EXTRA_MESSAGE, getWords(input));
    	    startActivity(intent);
    }
    
    private String getWords(String input){
    	String message =  getString(R.string.rhyme_invalid);
	    if(input != null){
	    	input = input.trim();
	    	if(input.endsWith("ack")){
	    		message = getString(R.string.rhyme_ack);
	    	}else if(input.endsWith("ail")){
	    		message = getString(R.string.rhyme_ail);
	    	}else if(input.endsWith("air")){
	    		message = getString(R.string.rhyme_air);
	    	}else if(input.endsWith("ake")){
	    		message = getString(R.string.rhyme_ake);
	    	}else if(input.endsWith("all")){
	    		message = getString(R.string.rhyme_all);
	    	}else if(input.endsWith("an")){
	    		message = getString(R.string.rhyme_an);
	    	}else if(input.endsWith("and")){
	    		message = getString(R.string.rhyme_and);
	    	}else if(input.endsWith("ap")){
	    		message = getString(R.string.rhyme_ap);
	    	}else if(input.endsWith("ar")){
	    		message = getString(R.string.rhyme_ar);
	    	}else if(input.endsWith("at")){
	    		message = getString(R.string.rhyme_at);
	    	}else if(input.endsWith("ate")){
	    		message = getString(R.string.rhyme_ate);
	    	}else if(input.endsWith("ed")){
	    		message = getString(R.string.rhyme_ed);
	    	}else if(input.endsWith("ell")){
	    		message = getString(R.string.rhyme_ell);
	    	}else if(input.endsWith("en")){
	    		message = getString(R.string.rhyme_en);
	    	}else if(input.endsWith("et")){
	    		message = getString(R.string.rhyme_et);
	    	}else if(input.endsWith("in")){
	    		message = getString(R.string.rhyme_in);
	    	}else if(input.endsWith("ing")){
	    		message = getString(R.string.rhyme_ing);
	    	}else if(input.endsWith("it")){
	    		message = getString(R.string.rhyme_it);
	    	}else if(input.endsWith("ite")){
	    		message = getString(R.string.rhyme_ite);
	    	}else if(input.endsWith("oh")){
	    		message = getString(R.string.rhyme_oh);
	    	}else if(input.endsWith("op")){
	    		message = getString(R.string.rhyme_op);
	    	}else if(input.endsWith("ot")){
	    		message = getString(R.string.rhyme_ot);
	    	}else if(input.endsWith("ound")){
	    		message = getString(R.string.rhyme_ound);
	    	}else if(input.endsWith("oze")){
	    		message = getString(R.string.rhyme_oze);
	    	}else if(input.endsWith("ub")){
	    		message = getString(R.string.rhyme_ub);
	    	}else if(input.endsWith("un")){
	    		message = getString(R.string.rhyme_un);
	    	}else {
	    		message = getString(R.string.rhyme_invalid);
	    	}
	    }
		return splitWords(message);    	
    }

    private String splitWords(String input){
    	if(input.equals(getString(R.string.rhyme_invalid))){
    		return input;
    	}
    	StringBuilder sb = new StringBuilder();
    	String opArray [] = input.split(",");
    	for(String temp : opArray){
    		sb.append(temp.trim()).append(LINE_SEPARATOR);
    	}
		return sb.toString();
    }

	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
}
