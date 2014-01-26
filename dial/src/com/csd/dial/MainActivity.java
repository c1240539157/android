package com.csd.dial;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button) this.findViewById(R.id.button);
		btn.setOnClickListener(new BtnClickListener());
	}

	private final class BtnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText text = (EditText) findViewById(R.id.mobile);
			String number = text.getText().toString();
			Intent intent=new Intent();
			intent.setAction("android.intent.action.CALL");
			//intent.addCategory("android.intent.category.DEFAULT");
			intent.setData(Uri.parse("tel:"+number));
			//把意图传给操作系统
			startActivity(intent);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
