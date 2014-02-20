package br.com.caelum.cadastro;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
import br.com.caelum.cadastro.adapter.ListaAlunosAdapter;
import br.com.caelum.cadastro.dao.AlunoDAO;
import br.com.caelum.cadastro.modelo.Aluno;
import br.com.caelum.task.EnviaContatosTask;

import com.caelum.cadastro.R;

public class ListaAlunosActivity extends Activity {

	private ListView listaAlunos;
	private Aluno alunoSelecionado;

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

				Intent edicao = new Intent(ListaAlunosActivity.this,
						FormularioActivity.class);

				edicao.putExtra(Extras.ALUNO_SELECIONADO,
						(Aluno) listaAlunos.getItemAtPosition(posicao));
				startActivity(edicao);

				Toast.makeText(ListaAlunosActivity.this,
						"Caminho da imagem:  ", Toast.LENGTH_SHORT).show();

			}

		});

		listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {

				alunoSelecionado = (Aluno) adapter.getItemAtPosition(posicao);
				Toast.makeText(ListaAlunosActivity.this,
						"Aluno: " + alunoSelecionado.getNome(),
						Toast.LENGTH_SHORT).show();

				return false;
			}
		});

	}

	private void carregaLista() {
		AlunoDAO alunoDAO = new AlunoDAO(this);
		List<Aluno> alunos = alunoDAO.getLista();
		alunoDAO.fecha();

		listaAlunos = (ListView) findViewById(R.id.lista_alunos);
		ListaAlunosAdapter adapter = new ListaAlunosAdapter(alunos, this);

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
		} else if (item.getItemId() == R.id.menu_enviar_alunos) {
			new EnviaContatosTask(this).execute();
			return false;

		} else if (item.getItemId() == R.id.menu_receber_provas) {
			Intent provas = new Intent(this, ProvasActivity.class);
			startActivity(provas);
			return false;
		} else if (item.getItemId() == R.id.menu_mapa) {
			Intent mapa = new Intent(this, MostraAlunosProximosActivity.class);
			startActivity(mapa);
			return false;
		} else {
			return super.onOptionsItemSelected(item);
		}

		// return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuItem deletar = menu.add("Deletar");

		deletar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {

				new AlertDialog.Builder(ListaAlunosActivity.this)
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setTitle("Deletar?")
						.setMessage(
								"Deseja mesmo deletar o aluno "
										+ alunoSelecionado.getNome())
						.setPositiveButton("Manda Bala",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										AlunoDAO alunoDAO = new AlunoDAO(
												ListaAlunosActivity.this);

										alunoDAO.deletar(alunoSelecionado);
										alunoDAO.fecha();
										carregaLista();
									}
								}).setNegativeButton("Melhor não", null).show();

				return false;
			}
		});

		MenuItem ligar = menu.add("Ligar");

		ligar.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent intentLigar = new Intent(Intent.ACTION_CALL);
				Uri discarPara = Uri.parse("tel:"
						+ alunoSelecionado.getTelefone());
				intentLigar.setData(discarPara);
				startActivity(intentLigar);
				return false;
			}
		});

		MenuItem enviarSms = menu.add("Enviar SMS");
		enviarSms.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent intentSms = new Intent(Intent.ACTION_VIEW);
				Uri smsPara = Uri.parse("sms:" + alunoSelecionado.getTelefone());
				intentSms.setData(smsPara);
				intentSms.putExtra("sms_body",
						"Bom dia " + alunoSelecionado.getNome() + "! ");
				startActivity(intentSms);
				return false;
			}
		});

		MenuItem mapa = menu.add("Achar no mapa");
		mapa.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent intentMapa = new Intent(Intent.ACTION_VIEW);
				Uri mapaPara = Uri.parse("geo:0,0?q="
						+ alunoSelecionado.getEndereco());
				intentMapa.setData(mapaPara);
				startActivity(intentMapa);
				return false;
			}
		});

		MenuItem navegarSite = menu.add("Navegar no site");
		navegarSite.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent intentNavegador = new Intent(Intent.ACTION_VIEW);
				String prefix = "";
				if (!alunoSelecionado.getSite().startsWith("http://")) {
					prefix = "http://";
				}

				Uri siteAluno = Uri.parse(prefix + alunoSelecionado.getSite());
				intentNavegador.setData(siteAluno);
				startActivity(intentNavegador);

				return false;
			}
		});

		menu.add("Enviar E-mail");

		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onResume() {
		carregaLista();
		super.onResume();
	}

}
