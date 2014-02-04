package br.com.caelum.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.caelum.cadastro.R;

public class ListaProvasFragment extends Fragment {
	
	private ListView listViewProvas;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layoutProvas = inflater.inflate(R.layout.provas_lista, container,
				false);
		
		this.listViewProvas = (ListView) layoutProvas.findViewById(R.layout.provas_lista);

		return layoutProvas;
	}

}
