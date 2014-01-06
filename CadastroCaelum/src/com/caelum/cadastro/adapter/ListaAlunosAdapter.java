package com.caelum.cadastro.adapter;

import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.caelum.cadastro.R;
import com.caelum.cadastro.modelo.Aluno;

public class ListaAlunosAdapter extends BaseAdapter{
	
	private final List<Aluno> alunos;
	private final Activity activity;
	
	
	public ListaAlunosAdapter(List<Aluno> alunos, Activity activity) {
		
		this.activity = activity;
		this.alunos = alunos;
		
	}

	@Override
	public int getCount() {
		return alunos.size();
	}

	@Override
	public Object getItem(int posicao) {
		
		return alunos.get(posicao);
	}

	@Override
	public long getItemId(int posicao) {
		return alunos.get(posicao).getId();
	}

	@Override
	public View getView(int posicao, View arg1, ViewGroup arg2) {
		View view = activity.getLayoutInflater().inflate(R.layout.item, null);
		
		if(posicao % 2 == 0){
			view.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
		}
		
		
		Aluno aluno = alunos.get(posicao);

		TextView nome = (TextView) view.findViewById(R.id.nome);
		ImageView foto  = (ImageView) view.findViewById(R.id.foto);
		
		nome.setText(aluno.getNome());
		
		Bitmap imagem;
		
		if (aluno.getFoto() != null) {
			imagem = BitmapFactory.decodeFile(aluno.getFoto()); 
			imagem = Bitmap.createScaledBitmap(imagem, 100, 100, true);
			
			Matrix matrix = new Matrix();
			matrix.postRotate(90);
			
			imagem  = Bitmap.createBitmap(imagem,0,0,imagem.getWidth(),imagem.getHeight(),matrix,true);
			
		} else {
			imagem = BitmapFactory.decodeResource(activity.getResources(), R.drawable.batore);
			imagem = Bitmap.createScaledBitmap(imagem, 100, 100, true);
		}
		
		foto.setImageBitmap(imagem);
		
		return view;
	}

}
