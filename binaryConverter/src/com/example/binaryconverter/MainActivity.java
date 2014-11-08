package com.example.binaryconverter;

import java.math.BigInteger;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Number Base Converter
 * 
 * @author Felipe Matias
 * 
 */
public class MainActivity extends Activity {
	
	private Button decimalB;
	private Button binaryB;
	private Button hexB, hexToDec;
	private CheckBox check;
	private EditText decimal;
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);   
	     getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		decimalB=(Button)findViewById(R.id.decimalB);
		decimal=(EditText)findViewById(R.id.decimal);
		binaryB=(Button)findViewById(R.id.binaryB);
		hexB=(Button)findViewById(R.id.hexB);
		hexToDec=(Button)findViewById(R.id.hexTodec);
		text=(TextView)findViewById(R.id.textView1);
		check=(CheckBox)findViewById(R.id.checkBox1);
		
		text.setMovementMethod(new ScrollingMovementMethod());
		
		if(check.isChecked()) {
			decimal.setRawInputType(InputType.TYPE_CLASS_NUMBER);
		}
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {

	        @Override
	        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	        	if(check.isChecked()) {
	    			decimal.setInputType(InputType.TYPE_CLASS_NUMBER);
	    		}else{
	    			decimal.setInputType(InputType.TYPE_CLASS_TEXT);
	    		}

	        }
	    });
		
		binaryB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            		try {
						String texto=decimal.getText().toString();
						BigInteger i= new BigInteger(texto);
						String s=i.toString(2);
						text.setText(s);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Toast.makeText(getApplicationContext(), "Not a valid number!!", Toast.LENGTH_SHORT).show();
					}
            	}
        }); 
		decimalB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    
            		try {
						BigInteger decimalValue = new BigInteger(decimal.getText().toString(), 2);
						text.setText(""+decimalValue);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Toast.makeText(getApplicationContext(), ""+decimal.getText().toString()+" is not a binary number!!!", Toast.LENGTH_SHORT).show();
					}
            	}       
        }); 
		
		hexB.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
         	try {
				String texto=decimal.getText().toString();
				BigInteger i= new BigInteger(texto);
				String s=i.toString(16);
				text.setText(s);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "Not a valid number!!!!", Toast.LENGTH_SHORT).show();
			}
        }
     }); 
	hexToDec.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
	         try {
	        	 BigInteger decimalValue =new BigInteger(decimal.getText().toString(), 16);
	        	 text.setText(""+decimalValue);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "Not a valid number!!!!", Toast.LENGTH_SHORT).show();
			}
	       }
	}); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
