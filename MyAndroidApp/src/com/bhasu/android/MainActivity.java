package com.bhasu.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * A Simple MainActivity class loads list dialog on click of button.
 * 
 * @author Bhasu
 *
 */
public class MainActivity extends Activity {

	final Context context = this;;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// choose the button
		Button button = (Button) findViewById(R.id.buttonShowAlertDialog);

		// add button listener
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog ad = showAlertDialog();
				ad.show();
			}
		});
	}

	/*
	 * To display List dialog
	 */
	public AlertDialog showAlertDialog() {
		int start = 5, end = 10;
		int size = end - start + 1;
		final String[] array = new String[size];

		for (int i = 0; i < size; i++) {
			array[i] = String.valueOf(start++);
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle(R.string.choose).setItems(array,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// The 'which' argument contains the index position
						// of the selected item
						EditText et = (EditText) findViewById(R.id.resultText);
						et.setText(array[which]);
					}
				});
		return builder.create();
	}
}