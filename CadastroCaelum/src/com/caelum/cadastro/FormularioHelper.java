package com.caelum.cadastro;

import android.widget.EditText;
import android.widget.RatingBar;

import com.caelum.cadastro.modelo.Aluno;

public class FormularioHelper {

	private EditText nome;
	private EditText telefone;
	private EditText site;
	private EditText endereco;
	private EditText foto;
	private RatingBar nota;
	private Aluno aluno;

	public FormularioHelper(FormularioActivity formulario) {
		this.nome = (EditText) formulario.findViewById(R.id.nome);
		this.telefone = (EditText) formulario.findViewById(R.id.telefone);
		this.site = (EditText) formulario.findViewById(R.id.site);
		this.endereco = (EditText) formulario.findViewById(R.id.endereco);
		this.nota = (RatingBar) formulario.findViewById(R.id.nota);
		this.foto = (EditText) formulario.findViewById(R.id.imagem);
		this.aluno = new Aluno();

	}
	
	public Aluno pegaAlunoDoformulario(){
		this.aluno.setNome(nome.getEditableText().toString());
		this.aluno.setTelefone(telefone.getEditableText().toString());
		this.aluno.setSite(site.getEditableText().toString());
		this.aluno.setEndereco(endereco.getEditableText().toString());
		this.aluno.setFoto(foto.getEditableText().toString());
		this.aluno.setNota(Double.valueOf(nota.getRating()));
		
		return this.aluno;
		
	}

}
