package br.com.caelum.fragment;

import br.com.caelum.cadastro.util.Localizador;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapaFragment extends SupportMapFragment {

	@Override
	public void onResume() {

		super.onResume();
		Localizador localizador = new Localizador(getActivity());

		LatLng coordenada = localizador
				.getCoordenada("Rua cesar Marengo 161 São Paulo");
		this.localizaNo(coordenada);
	}

	private void localizaNo(LatLng coordenada) {
		GoogleMap map = getMap();
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenada,17));
	}

}