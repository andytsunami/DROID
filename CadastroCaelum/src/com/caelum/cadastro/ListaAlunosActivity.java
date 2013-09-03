package com.caelum.cadastro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends Activity {

	private ListView listaAlunos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem_alunos);

		String[] alunos = { "Mimi", "Cocó", "Ranheta", "Tizil", "Lambari",
				"Havaiana jones", "Feitoza", "Palhaço do satanás",
				"Fetinho do mal","Zé graça", "Palhaço hamburgueiro" };
		int layout = android.R.layout.simple_list_item_1;

		listaAlunos = (ListView) findViewById(R.id.lista_alunos);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout,
				alunos);

		listaAlunos.setAdapter(adapter);

		listaAlunos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int posicao, long id) {

				Toast.makeText(ListaAlunosActivity.this,
						"Posição do elemento " + (posicao + 1),
						Toast.LENGTH_SHORT).show();

			}

		});
		
		listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				
				Toast.makeText(ListaAlunosActivity.this, "Conteudo: " + adapter.getItemAtPosition(posicao), Toast.LENGTH_SHORT).show();
				
				return true;
			}
		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);
		return super.onCreateOptionsMenu(menu);
	}

	
	
	
	
	
	
	
}
