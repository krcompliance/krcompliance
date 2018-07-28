package com.example.servicecharge;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {

	// constants used when saving/restoring state
	   private static final String BILL_TOTAL = "BILL_TOTAL";
	   
	   private double currentBillTotal;   // bill amount entered by the user
	   private EditText tip10EditText;    // displays 10% tip
	   private EditText total10EditText;  // displays total with 10% tip
	   private EditText tip15EditText;    // displays 15% tip
	   private EditText total15EditText;  // displays total with 15% tip
	   private EditText billEditText;     // accepts user input for bill total
	   private EditText tip20EditText;    // displays 20% tip
	   private EditText total20EditText;  // displays total with 20% tip

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        // check if app just started or is being restored from memory
	        if ( savedInstanceState == null ) // the app just started running
	        {
	           currentBillTotal = 0.0; // initialize the bill amount to zero
	        } // end if
	        else // app is being restored from memory, not executed from scratch
	        {
	           // initialize the bill amount to saved amount
	          // currentBillTotal = savedInstanceState.getDouble(BILL_TOTAL); 
	        } // end else
	             
	        // get references to the 10%, 15% and 20% tip and total EditTexts
	        tip10EditText = (EditText) findViewById(R.id.tip10EditText);
	        total10EditText = (EditText) findViewById(R.id.total10EditText);
	        tip15EditText = (EditText) findViewById(R.id.tip15EditText);
	        total15EditText = (EditText) findViewById(R.id.total15EditText);
	        tip20EditText = (EditText) findViewById(R.id.tip20EditText);
	        total20EditText = (EditText) findViewById(R.id.total20EditText);
	        
	        // get the billEditText 
	        billEditText = (EditText) findViewById(R.id.billEditText);
	        
	        // billEditTextWatcher handles billEditText's onTextChanged event
	        billEditText.addTextChangedListener(billEditTextWatcher);
	               
	    } // onCreate

	    // updates 10, 15 and 20 percent tip EditTexts
	    private void updateStandard() 
	    {
	       // calculate bill total with a ten percent tip
	       double tenPercentTip = currentBillTotal * .1;
	       double tenPercentTotal = currentBillTotal + tenPercentTip;

	       // set tipTenEditText's text to tenPercentTip
	       tip10EditText.setText(String.format("%.02f", tenPercentTip));

	       // set totalTenEditText's text to tenPercentTotal
	       total10EditText.setText(String.format("%.02f", tenPercentTotal));

	       // calculate bill total with a fifteen percent tip
	       double fifteenPercentTip = currentBillTotal * .15;
	       double fifteenPercentTotal = currentBillTotal + fifteenPercentTip;

	       // set tipFifteenEditText's text to fifteenPercentTip
	       tip15EditText.setText(String.format("%.02f", fifteenPercentTip));

	       // set totalFifteenEditText's text to fifteenPercentTotal
	       total15EditText.setText(String.format("%.02f", fifteenPercentTotal));

	       // calculate bill total with a twenty percent tip
	       double twentyPercentTip = currentBillTotal * .20;
	       double twentyPercentTotal = currentBillTotal + twentyPercentTip;

	       // set tipTwentyEditText's text to twentyPercentTip
	       tip20EditText.setText(String.format("%.02f", twentyPercentTip));

	       // set totalTwentyEditText's text to twentyPercentTotal
	       total20EditText.setText(String.format("%.02f", twentyPercentTotal));
	    } // end method updateStandard
	    
	    private TextWatcher billEditTextWatcher = new TextWatcher() 
	    {
	       // called when the user enters a number
	       @Override
	       public void onTextChanged(CharSequence s, int start, int before, int count) 
	       {         
	          // convert billEditText's text to a double
	          try
	          {
	             currentBillTotal = Double.parseDouble(s.toString());
	          } // end try
	          catch (NumberFormatException e)
	          {
	             currentBillTotal = 0.0; // default if an exception occurs
	          } // end catch 

	          // update the standard and custom tip EditTexts
	          updateStandard(); // update the 10, 15 and 20% EditTexts
	       } // end method onTextChanged

	     
	       @Override
	       public void beforeTextChanged(CharSequence s, int start, int count, int after) 
	       {
	       } // end method beforeTextChanged

	     	@Override
		   public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		   }
	    }; // end billEditTextWatcher
	    
	    
	    // save values of billEditText and customSeekBar
	    @Override
	    protected void onSaveInstanceState(Bundle outState)
	    {
	       super.onSaveInstanceState(outState);
	       
	     //  outState.putDouble(BILL_TOTAL, currentBillTotal);
	    } // end method onSaveInstanceState

}
