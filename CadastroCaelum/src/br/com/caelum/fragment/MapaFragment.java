package br.com.caelum.fragment;

import java.util.List;

import br.com.caelum.cadastro.dao.AlunoDAO;
import br.com.caelum.cadastro.modelo.Aluno;
import br.com.caelum.cadastro.util.Localizador;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends SupportMapFragment {

	@Override
	public void onResume() {
		super.onResume();
		Localizador coderUtil = new Localizador(getActivity());
		LatLng local = coderUtil
				.getCoordenada("Rua cesar marengo 161 São Paulo");
		this.localizaNo(local);

		AlunoDAO alunoDAO = new AlunoDAO(getActivity());
		List<Aluno> alunos = alunoDAO.getLista();
		alunoDAO.fecha();

		for (Aluno aluno : alunos) {
			Localizador localizador = new Localizador(getActivity());
			LatLng coordenada = localizador.getCoordenada(aluno.getEndereco());

			if (coordenada != null) {
				MarkerOptions markerOptions = new MarkerOptions();
				markerOptions.position(coordenada).title(aluno.getNome())
						.snippet(aluno.getEndereco());
				
				getMap().addMarker(markerOptions);

			}

		}

	}

	private void localizaNo(LatLng coordenada) {
		GoogleMap map = getMap();
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenada, 17));
	}

}