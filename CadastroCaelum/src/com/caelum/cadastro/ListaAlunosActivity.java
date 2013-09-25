package com.caelum.cadastro;

import java.util.List;

import com.caelum.cadastro.dao.AlunoDAO;
import com.caelum.cadastro.modelo.Aluno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends Activity {

	private ListView listaAlunos;

	@Override
	protected void onStart() {
		this.carregaLista();
		super.onStart();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem_alunos);

		carregaLista();

		registerForContextMenu(listaAlunos);

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

				Aluno alunoSelecionado = (Aluno) adapter
						.getItemAtPosition(posicao);
				Toast.makeText(ListaAlunosActivity.this, "Aluno: "
						+ alunoSelecionado.getNome(), Toast.LENGTH_SHORT).show();

				return false;
			}
		});

	}

	private void carregaLista() {
		AlunoDAO alunoDAO = new AlunoDAO(this);
		List<Aluno> alunos = alunoDAO.getLista();
		alunoDAO.fecha();

		int layout = android.R.layout.simple_list_item_1;

		listaAlunos = (ListView) findViewById(R.id.lista_alunos);
		ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, layout,
				alunos);

		listaAlunos.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.menu_novo) {
			Intent intent = new Intent(ListaAlunosActivity.this,
					FormularioActivity.class);
			startActivity(intent);
			return false;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add("Ligar");
		menu.add("Enviar SMS");
		menu.add("Achar no mapa");
		menu.add("Navegar no site");
		menu.add("Deletar");
		menu.add("Enviar E-mail");

		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onResume() {
		carregaLista();
		super.onResume();
	}

}
