package br.com.caelum.cadastro.mapa;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

public class AtualizadorDeLocalizacao implements LocationListener {

	private LocationManager manager;

	public AtualizadorDeLocalizacao(Context context) {
		manager = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);
		String provider = LocationManager.GPS_PROVIDER;
		long minTime = 20000; // milisegundos
		long minDistance = 20; // metros
		manager.requestLocationUpdates(provider, minTime, minDistance, this);
	}

	public void cancela() {
		manager.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		LatLng latLng = new LatLng(location.getLongitude(),
				location.getLatitude());

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