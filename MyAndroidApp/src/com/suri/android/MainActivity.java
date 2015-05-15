package com.suri.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * A Simple MainActivity class loads list dialog on click of button.
 * 
 * @author Suri
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
				showAlertDialog();
			}
		});

	}

	/*
	 * To display List dialog
	 */
	private void showAlertDialog() {
		// you can define your own array here 
		// for String[] array = {"1", "2", "3", "4", "5"}
		// or you can get it from resource file string.xml
		String[] array = getResources().getStringArray(R.array.number_array);

		LayoutInflater inflater = getLayoutInflater();
		View convertView = (View) inflater.inflate(R.layout.dialog, null);
		
		// displaying alert dialog with list of numbers
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
		alertDialog.setView(convertView);

		alertDialog.setTitle(getResources().getString(R.string.choose));
		
		ListView lv = (ListView) convertView.findViewById(R.id.listView);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
		lv.setAdapter(adapter);

		alertDialog.show();
	}

}