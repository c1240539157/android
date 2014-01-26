package com.csd.sns;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText numberText;
	private EditText contentText;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numberText = (EditText) this.findViewById(R.id.number);
		contentText = (EditText) this.findViewById(R.id.content);
		btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(new btnClickListener());

	}

	
	private final class btnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			String number=numberText.getText().toString();
			String content=contentText.getText().toString();
			SmsManager manager=SmsManager.getDefault();
			List<String> lists=manager.divideMessage(content);
			for(String con:lists){
				manager.sendTextMessage(number, null, con,null,null);
			}
			Toast.makeText(getApplicationContext(),R.string.success,Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
