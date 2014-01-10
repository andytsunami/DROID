package br.com.caelum.task;

import java.util.List;

import br.com.caelum.cadastro.dao.AlunoDAO;
import br.com.caelum.cadastro.modelo.Aluno;
import br.com.caelum.converter.AlunoConverter;
import br.com.caelum.support.WebClient;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class EnviaContatosTask extends AsyncTask<Object, Object, String>{

	
	private Context context;
	private final String endereco = "http://www.caelum.com.br/mobile";

	public EnviaContatosTask(Context context) {
		this.context = context;
	}
	
	@Override
	protected String doInBackground(Object... params) {
		
		AlunoDAO alunoDAO = new AlunoDAO(context);
		List<Aluno> lista = alunoDAO.getLista();
		alunoDAO.fecha();
		
		String json = new AlunoConverter().toJSON(lista);
		
		WebClient webClient = new WebClient(endereco);
		
		String resposta = webClient.post(json);
		
		
		
		return resposta;
	}
	
	@Override
	protected void onPostExecute(String result) {
		Toast.makeText(context, result, Toast.LENGTH_LONG).show();
	}
	

}
