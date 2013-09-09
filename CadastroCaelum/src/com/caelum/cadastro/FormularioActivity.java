package com.caelum.cadastro;

import com.caelum.cadastro.dao.AlunoDAO;
import com.caelum.cadastro.modelo.Aluno;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormularioActivity extends Activity {
	
	private FormularioHelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		
		
		Button botao = (Button) findViewById(R.id.botao);
		
		this.helper = new FormularioHelper(this);
		
		botao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				
				Aluno aluno = helper.pegaAlunoDoformulario();
				AlunoDAO alunoDAO = new AlunoDAO(FormularioActivity.this);
				alunoDAO.insere(aluno);
				alunoDAO.fecha();
				
				finish();
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.formulario, menu);
		return true;
	}
	
	
	
	

}
