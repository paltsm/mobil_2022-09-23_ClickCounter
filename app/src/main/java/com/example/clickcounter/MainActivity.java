package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private Button buttonPlusz;
	private Button buttonMinusz;
	private TextView textviewErtek;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();

		buttonPlusz.setOnClickListener(view -> {
			int ertek = Integer.parseInt(textviewErtek.getText().toString());
			ertek += 1;
			textviewErtek.setText(String.valueOf(ertek));
			szin(ertek);
		});

		buttonMinusz.setOnClickListener(view -> {
			int ertek = Integer.parseInt(textviewErtek.getText().toString());
			ertek -= 1;
			textviewErtek.setText(String.valueOf(ertek));
			szin(ertek);

		});

		textviewErtek.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				int ertek=0;
				textviewErtek.setText(String.valueOf(ertek));
				szin(ertek);
				return true;
			}
		});

	}

	private void init() {
		buttonPlusz = findViewById(R.id.buttonPlusz);
		buttonMinusz = findViewById(R.id.buttonMinusz);
		textviewErtek = findViewById(R.id.textviewErtek);
		textviewErtek.setTextColor(Color.BLUE);
		textviewErtek.setText("0");
	}
	private void szin(int ertek){
		if (ertek < 0) {
			textviewErtek.setTextColor(Color.parseColor("#ff0000"));
		}else if(ertek==0){
			textviewErtek.setTextColor(Color.BLUE);
		}else{
			textviewErtek.setTextColor(Color.GREEN);
		}
		if(prim(ertek) && ertek>1){
			textviewErtek.setTextColor(Color.rgb(255,255,255));
		}
	}
	private boolean prim(int ertek){
		for (int i = 2; i < ertek; i++) {
			if (ertek%i==0){
				return false;
			}
		}
		return true;
	}
}