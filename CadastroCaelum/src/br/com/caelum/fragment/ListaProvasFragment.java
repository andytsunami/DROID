package br.com.caelum.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.caelum.cadastro.modelo.Prova;

import com.caelum.cadastro.R;

public class ListaProvasFragment extends Fragment {
	
	private ListView listViewProvas;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layoutProvas = inflater.inflate(R.layout.provas_lista, container,
				false);
		
		
		this.listViewProvas = (ListView) layoutProvas.findViewById(R.layout.provas_lista);
		
		Prova prova1 = new Prova("18/04/2014", "Matematica");
		prova1.setTopicos(Arrays.asList("Calculo diferencial","Algebra","Integral"));
		
		Prova prova2 = new Prova("04/02/2014", "Video game");
		prova2.setTopicos(Arrays.asList("Platinar infamous","Ganhar 15 trofeus do mesmo jogo no mesmo dia","Platinar 3 jogo diferentes no mesmo dia"));
		
		List<Prova> provas = Arrays.asList(prova1,prova2);
		
		this.listViewProvas.setAdapter(new ArrayAdapter<Prova>(getActivity(), android.R.layout.simple_list_item_1, provas));

		return layoutProvas;
	}

}
