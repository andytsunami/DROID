package br.com.caelum.cadastro.util;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

public class Localizador {

	Geocoder geocoder;
	Context context;

	public Localizador(Context context) {
		this.context = context;
		geocoder = new Geocoder(context);
	}

	public LatLng getCoordenada(String endereco) {
		try {
			List<Address> listaEnderecos = geocoder.getFromLocationName(
					endereco, 1);

			if (!listaEnderecos.isEmpty()) {
				Address address = listaEnderecos.get(0);
				return new LatLng(address.getLatitude(), address.getLongitude());
			} else {
				return null;
			}
		} catch (IOException e) {
			return null;
		}

	}

}