package com.example.olamundo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class OlaMundoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        Log.i("Ciclo de vida", "onCreate");
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
