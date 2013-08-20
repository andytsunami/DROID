package com.example.olamundo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class OlaMundoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        Button botao = (Button) findViewById(R.id.botao);
        
        botao.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.i("Ola mundo", "Botão clicado");
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ola_mundo, menu);
        return true;
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.i("Ciclo de vida", "onResume");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.i("Ciclo de vida", "onDestroy");
    }
    
}
