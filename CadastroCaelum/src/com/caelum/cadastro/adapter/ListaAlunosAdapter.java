package com.caelum.cadastro.adapter;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		View view = activity.getLayoutInflater().inflate(R.layout.item, null);
		return view;
	}

}
