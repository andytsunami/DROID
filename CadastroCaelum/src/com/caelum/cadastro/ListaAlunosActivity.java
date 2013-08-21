package com.caelum.cadastro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlunosActivity extends Activity {

	private ListView listaAlunos;
	String[] alunos = { "Mimi", "Cocó", "Ranheta", "Lambari", "Havaiana jones",
			"Feitoza", "Palhaço do satanás", "Fetinho do mal" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem_alunos);

		listaAlunos = (ListView) findViewById(R.id.lista_alunos);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, alunos);

		listaAlunos.setAdapter(adapter);

	}

}
