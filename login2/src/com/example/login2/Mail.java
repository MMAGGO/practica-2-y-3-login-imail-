package com.example.login2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Mail extends Activity {
	
	
	private Button boton;
	private EditText destinatario,asunto,texto;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail);
	boton=(Button)findViewById(R.id.enviar);
	destinatario= (EditText)findViewById(R.id.quien);
	asunto= (EditText)findViewById(R.id.que);
	texto= (EditText)findViewById(R.id.como);
	
	boton.setOnClickListener(new OnClickListener(){
		
		
		public void onClick(View v){
		if(destinatario.getText().toString().equals("")){	
		
		enviarMail();
		}
		}
	});
	}

	
	public void enviarMail(){
		Intent intent = new Intent (android.content.Intent.ACTION_SEND);
	    intent.setType("text/plain");
	    intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[]{destinatario.getText().toString()});
	     intent.putExtra(android.content.Intent.EXTRA_SUBJECT, asunto.getText().toString());
	     intent.putExtra(android.content.Intent.EXTRA_TEXT, texto.getText().toString());
	     try{
	    	 startActivity(Intent.createChooser(intent, "enviando correo"));
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	    	 
	     }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
