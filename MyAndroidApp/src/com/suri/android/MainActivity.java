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

public class MainActivity extends Activity {

	final Context context = this;
	private Button button1, button2;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// choose the button
		button2 = (Button) findViewById(R.id.buttonShowAlertDialog);

		// add button listener
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showAlertDialog();
			}
		});

	}
	
	private void showAlertDialog() {
		Integer names[] = { 1, 2, 3, 4, 5, 6 };
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
		LayoutInflater inflater = getLayoutInflater();
		View convertView = (View) inflater.inflate(R.layout.dialog, null);
		alertDialog.setView(convertView);
		alertDialog.setTitle("List");
		ListView lv = (ListView) convertView.findViewById(R.id.listView1);
		ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, names);
		lv.setAdapter(adapter);
		
		alertDialog.show();
	}
	
}