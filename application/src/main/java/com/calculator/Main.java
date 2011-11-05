package com.calculator;

import com.calculator.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;

public class Main extends Activity {
	EditText FirstValue;
	EditText SecondValue;
	TextView Result;
	Button Calculate;
	float num1 , num2;	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FirstValue = (EditText) findViewById(R.id.EditText01);
        
        SecondValue = (EditText) findViewById(R.id.EditText02);
        
        Result = (TextView) findViewById(R.id.TextView01);
        Result.setText("0.00");
        
        Calculate = (Button) findViewById(R.id.Button01);

        //Adding listener to button
        Calculate.setOnClickListener(new View.OnClickListener() {

    	public void onClick(View v) {
    		//Getting first & second values and passing to show result
    		showResult(FirstValue.getText(), SecondValue.getText());
    	}
   	});
 }

 //Showing multiply results
 protected void showResult(Editable first, Editable second) 
 {
	 float num1 = Float.parseFloat(first.toString());
	 float num2 = Float.parseFloat(second.toString());
	 float result = num1 * num2;
	 Result.setText(String.valueOf(result));
 }
 
}
