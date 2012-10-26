/*
 * 
 */
package com.anicha.rhymesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * The Class RhymeActivity.
 * 
 * <p>The RhymeActivity receives input from the user and retrieves the ending words
 * and compares it with the possible rhyming words available in the resources,
 * rhymes.xml. The output is the list of rhyming words available. To add/modify
 * the rhyming words, edit the rhymes.xml.
 * 
 * @author Dinakaran Jayaraman
 */
public class RhymeActivity extends Activity {
	/** The Constant DISPLAY_MESSAGE. */
	private static final String DISPLAY_MESSAGE = "com.anicha.rhymesApp.MESSAGE";
	/** The Constant LINE_SEPARATOR. */
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	/**
	 * Called when the user clicks the rhyme button.
	 * 
	 * @param view
	 *            the view
	 * @return the rhyming words
	 */
	public void getRhymingWords(View view) {
		Intent intent = new Intent(this, RhymeActivity.class);
		EditText editText = (EditText) findViewById(R.id.inputWord);
		String input = editText.getText().toString();
		intent.putExtra(DISPLAY_MESSAGE, getWords(input));
		startActivity(intent);
	}
	/**
	 * Gets the possible rhyming words.
	 * 
	 * @param input
	 *            the user input string
	 * @return the words
	 */
	private String getWords(String input) {
		String message = getString(R.string.rhyme_invalid);
		if (input != null) {
			input = input.trim();
			if (input.endsWith("ack")) {
				message = getString(R.string.rhyme_ack);
			} else if (input.endsWith("ail")) {
				message = getString(R.string.rhyme_ail);
			} else if (input.endsWith("air")) {
				message = getString(R.string.rhyme_air);
			} else if (input.endsWith("ake")) {
				message = getString(R.string.rhyme_ake);
			} else if (input.endsWith("all")) {
				message = getString(R.string.rhyme_all);
			} else if (input.endsWith("an")) {
				message = getString(R.string.rhyme_an);
			} else if (input.endsWith("and")) {
				message = getString(R.string.rhyme_and);
			} else if (input.endsWith("ap")) {
				message = getString(R.string.rhyme_ap);
			} else if (input.endsWith("ar")) {
				message = getString(R.string.rhyme_ar);
			} else if (input.endsWith("at")) {
				message = getString(R.string.rhyme_at);
			} else if (input.endsWith("ate")) {
				message = getString(R.string.rhyme_ate);
			} else if (input.endsWith("ed")) {
				message = getString(R.string.rhyme_ed);
			} else if (input.endsWith("ell")) {
				message = getString(R.string.rhyme_ell);
			} else if (input.endsWith("en")) {
				message = getString(R.string.rhyme_en);
			} else if (input.endsWith("et")) {
				message = getString(R.string.rhyme_et);
			} else if (input.endsWith("in")) {
				message = getString(R.string.rhyme_in);
			} else if (input.endsWith("ing")) {
				message = getString(R.string.rhyme_ing);
			} else if (input.endsWith("it")) {
				message = getString(R.string.rhyme_it);
			} else if (input.endsWith("ite")) {
				message = getString(R.string.rhyme_ite);
			} else if (input.endsWith("oh")) {
				message = getString(R.string.rhyme_oh);
			} else if (input.endsWith("op")) {
				message = getString(R.string.rhyme_op);
			} else if (input.endsWith("ot")) {
				message = getString(R.string.rhyme_ot);
			} else if (input.endsWith("ound")) {
				message = getString(R.string.rhyme_ound);
			} else if (input.endsWith("oze")) {
				message = getString(R.string.rhyme_oze);
			} else if (input.endsWith("ub")) {
				message = getString(R.string.rhyme_ub);
			} else if (input.endsWith("un")) {
				message = getString(R.string.rhyme_un);
			} else {
				message = getString(R.string.rhyme_invalid);
			}
		}
		return splitWords(message);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rhyme);
		Intent intent = getIntent();
		String message = intent.getStringExtra(RhymeActivity.DISPLAY_MESSAGE);
		EditText outputBox = (EditText) findViewById(R.id.outputBox);
		outputBox.setText(message);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_rhyme, menu);
		return true;
	}
	/**
	 * Split the comma separated rhyming words into a multi-line string.
	 * 
	 * @param input
	 *            the input
	 * @return the string
	 */
	private String splitWords(String input) {
		if (input.equals(getString(R.string.rhyme_invalid))) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		String opArray[] = input.split(",");
		for (String temp : opArray) {
			sb.append(temp.trim()).append(LINE_SEPARATOR);
		}
		return sb.toString();
	}
}