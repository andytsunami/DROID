package com.caelum.cadastro;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.caelum.cadastro.modelo.Aluno;

public class FormularioHelper {

	private EditText nome;
	private EditText telefone;
	private EditText site;
	private EditText endereco;
	private ImageView botaoImagem;

	private RatingBar nota;
	private Aluno aluno;

	public FormularioHelper(FormularioActivity formulario) {
		this.nome = (EditText) formulario.findViewById(R.id.nome);
		this.telefone = (EditText) formulario.findViewById(R.id.telefone);
		this.site = (EditText) formulario.findViewById(R.id.site);
		this.endereco = (EditText) formulario.findViewById(R.id.endereco);
		this.nota = (RatingBar) formulario.findViewById(R.id.nota);
		this.botaoImagem = (ImageView) formulario.findViewById(R.id.foto);
		//this.aluno = new Aluno();

	}

	public Aluno pegaAlunoDoformulario() {
		this.aluno.setNome(nome.getEditableText().toString());
		this.aluno.setTelefone(telefone.getEditableText().toString());
		this.aluno.setSite(site.getEditableText().toString());
		this.aluno.setEndereco(endereco.getEditableText().toString());
		this.aluno.setNota(Double.valueOf(nota.getRating()));

		return this.aluno;

	}

	public void colocaAlunoNoFormulario(Aluno aluno) {
		nome.setText(aluno.getNome());
		telefone.setText(aluno.getTelefone());
		site.setText(aluno.getSite());
		endereco.setText(aluno.getEndereco());
		nota.setProgress(aluno.getNota().intValue());

		if (aluno.getFoto() != null) {
			this.carregaImagem(aluno.getFoto());

		}
		this.aluno = aluno;
	}

	public ImageView getBotaoImagem() {
		return botaoImagem;
	}

	public void carregaImagem(String caminhoFoto) {
		Bitmap imagemFoto = BitmapFactory.decodeFile(caminhoFoto);
		Bitmap imagemRedimensionada = Bitmap.createScaledBitmap(imagemFoto,
				100, 100, true);
		this.botaoImagem.setImageBitmap(imagemRedimensionada);

	}

}
