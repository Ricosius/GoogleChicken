package com.example.googlechicken;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	Button width,height,calc,save;
	TextView area;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		width = (Button)findViewById(R.id.button1);
		height = (Button)findViewById(R.id.button2);
		calc = (Button)findViewById(R.id.button3);
		save = (Button)findViewById(R.id.button4);
		
		
		
		area = (TextView)findViewById(R.id.textView1);
		
		width.setOnClickListener(this);
		height.setOnClickListener(this);
		calc.setOnClickListener(this);
		save.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, Numbers.class);
		switch(v.getId()) {
		case R.id.button1:
			//width
			i.putExtra("numbers", "width");
			startActivityForResult(i, 1);
			break;
		case R.id.button2:
			//height
			i.putExtra("numbers", "height");
			startActivityForResult(i, 1);
			break;
		case R.id.button3:
			//calc
			int a = Integer.valueOf(width.getText().toString());
			int b = Integer.valueOf(height.getText().toString());
			area.setText(a*b+" uitkomst x");
			break;
		case R.id.button4:
			startActivity(new Intent("com.example.googlechicken.SETTINGS"));
			
			break;
		
		}
		
	}
	
	
	
	 

	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(data.getExtras().containsKey("widthInfo")){
			width.setText(data.getStringExtra("widthInfo"));
		}
		if(data.getExtras().containsKey("heightInfo")){
			height.setText(data.getStringExtra("heightInfo"));
		}
	}
}
