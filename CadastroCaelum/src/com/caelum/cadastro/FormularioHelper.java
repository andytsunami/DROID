package com.caelum.cadastro;

import android.widget.EditText;
import android.widget.RatingBar;

import com.caelum.cadastro.modelo.Aluno;

public class FormularioHelper {

	private EditText editNome;
	private EditText editTelefone;
	private EditText editSite;
	private EditText editEndereco;
	private RatingBar ratingNota;
	private Aluno aluno;

	public FormularioHelper(FormularioActivity activity) {
		this.editNome = (EditText) activity.findViewById(R.id.nome);
		this.editTelefone = (EditText) activity.findViewById(R.id.telefone);
		this.editSite = (EditText) activity.findViewById(R.id.site);
		this.editEndereco = (EditText) activity.findViewById(R.id.endereco);
		this.ratingNota = (RatingBar) activity.findViewById(R.id.nota);
		this.aluno = new Aluno();

	}

}
