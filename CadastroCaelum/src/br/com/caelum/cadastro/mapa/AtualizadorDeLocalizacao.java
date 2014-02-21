package br.com.caelum.cadastro.mapa;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import br.com.caelum.fragment.MapaFragment;

import com.google.android.gms.maps.model.LatLng;

public class AtualizadorDeLocalizacao implements LocationListener {

	private LocationManager manager;
	private MapaFragment mapa;

	public AtualizadorDeLocalizacao(Context context, MapaFragment mapa) {
		this.mapa = mapa;
		manager = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);
		String provider = LocationManager.GPS_PROVIDER;
		long tempoMinimo = 20000; // milisegundos
		long distanciaMinima = 20; // metros
		manager.requestLocationUpdates(provider, tempoMinimo, distanciaMinima, this);
	}

	public void cancela() {
		manager.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		LatLng latLng = new LatLng(location.getLongitude(),
				location.getLatitude());
		this.mapa.localizaNo(latLng);
		

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}