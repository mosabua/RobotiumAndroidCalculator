package com.calculator.test;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.calculator.Main;
import com.calculator.R;
import com.jayway.android.robotium.solo.Solo;

public class TestMain extends ActivityInstrumentationTestCase2<Main> {
	private Solo solo;
	
	public TestMain() {
		super("com.calculator", Main.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@Override
	protected void tearDown() throws Exception{
		try {
			this.solo.finalize();
			} catch (Throwable e) {
			e.printStackTrace();
			}
			getActivity().finish();
			super.tearDown();
			}
	/**
	* @throws Exception Exception
	*/
	public void testDisplayBlackBox() {

		//Enter 10 in first editfield
		solo.enterText(0, "10");

		//Enter 20 in first editfield
		solo.enterText(1, "20");

		//Click on Multiply button
		solo.clickOnButton("Multiply");

		//Verify that resultant of 10 x 20 
		assertTrue(solo.searchText("200"));

		}
	
	public void testDisplayWhiteBox() {

		//Defining our own values to multiply
		float firstNumber = 10;
		float secondNumber = 20;
		float resutl = firstNumber * secondNumber ;
		
		//Access First value (editfiled) and putting firstNumber value in it
		EditText FirsteditText = (EditText) solo.getView(R.id.EditText01);
		this.solo.enterText(FirsteditText, String.valueOf(firstNumber));
		
		//Access Second value (editfiled) and putting SecondNumber value in it
		EditText SecondeditText = (EditText) solo.getView(R.id.EditText02);
		this.solo.enterText(SecondeditText, String.valueOf(secondNumber));
		
		//Click on Multiply button
		this.solo.clickOnButton("Multiply");
		
		
		assertTrue(this.solo.searchText(String.valueOf(resutl)));
				
		TextView outputField = (TextView) solo.getView(R.id.TextView01);
		
		ArrayList currentTextViews = this.solo.getCurrentTextViews(outputField);
		assertFalse(currentTextViews.isEmpty());
		
		TextView output = (TextView) currentTextViews.get(0);
		
		//Assert to verify result with visible value
		assertEquals(String.valueOf(resutl), output.getText().toString());
	}
}