package br.com.caelum.cadastro.util;

import android.content.Context;
import android.location.Geocoder;

public class Localizador {

	Geocoder geocoder;

	public Localizador(Context context) {
		geocoder = new Geocoder(context);
	}

}