package com.caelum.cadastro;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.caelum.cadastro.dao.AlunoDAO;
import com.caelum.cadastro.modelo.Aluno;

public class FormularioActivity extends Activity {
	
	private FormularioHelper helper;
	private String caminhoFoto;
	private static int CODIGO_FOTO = 123;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		
		
		
		
		Button botao = (Button) findViewById(R.id.botao);
		
		this.helper = new FormularioHelper(this);
		Intent intent = this.getIntent();
		final Aluno alunoParaSerAlterado = (Aluno) intent.getSerializableExtra(Extras.ALUNO_SELECIONADO);
		
		if(alunoParaSerAlterado != null){
			botao.setText("Alterar");
			helper.colocaAlunoNoFormulario(alunoParaSerAlterado);
			
			if(alunoParaSerAlterado.getFoto() != null){
				helper.carregaImagem(alunoParaSerAlterado.getFoto());
			}
		}
		
	
		
		
		botao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				
				Aluno aluno = helper.pegaAlunoDoformulario();
				aluno.setFoto(caminhoFoto);
				AlunoDAO alunoDAO = new AlunoDAO(FormularioActivity.this);
				
				if(alunoParaSerAlterado == null){
					
					alunoDAO.insere(aluno);
				} else {
					aluno.setId(alunoParaSerAlterado.getId());
					alunoDAO.alterar(aluno);
				}
				
				alunoDAO.fecha();
				
				finish();
				
			}
		});
		
		ImageView foto = helper.getBotaoImagem();
		
		
		foto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				caminhoFoto = Environment.getExternalStorageDirectory()+"/"+System.currentTimeMillis()+".jpg";
				Intent irParaCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				irParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(caminhoFoto)));
				
				startActivityForResult(irParaCamera,CODIGO_FOTO);
				
			}
		});
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if(requestCode == CODIGO_FOTO){
			if(resultCode == Activity.RESULT_OK){
				helper.carregaImagem(this.caminhoFoto);
				
			} else {
				this.caminhoFoto =  null;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.formulario, menu);
		return true;
	}
	
	
	
	

}
