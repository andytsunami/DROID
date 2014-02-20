package br.com.caelum.fragment;

import android.widget.Toast;
import br.com.caelum.cadastro.util.Localizador;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapaFragment extends SupportMapFragment{
	
	@Override
	public void onResume() {
		
		super.onResume();
		Localizador localizador = new Localizador(getActivity());
		
		LatLng coordenada = localizador.getCoordenada("Rua cesar Marengo 161 São Paulo");
		Toast.makeText(getActivity(), "Coordenadas de casa: " + coordenada, Toast.LENGTH_LONG).show();
	}

}