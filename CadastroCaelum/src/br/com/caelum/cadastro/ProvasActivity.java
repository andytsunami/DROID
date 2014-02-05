package br.com.caelum.cadastro;

import br.com.caelum.fragment.DetalhesProvaFragment;
import br.com.caelum.fragment.ListaProvasFragment;

import com.caelum.cadastro.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class ProvasActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.provas);
		if (bundle == null) {

			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();
			if (isTablet()) {
				transaction.replace(R.id.provas_lista,
						new ListaProvasFragment(),
						ListaProvasFragment.class.getCanonicalName()).replace(
						R.id.provas_detalhe, new DetalhesProvaFragment(),
						DetalhesProvaFragment.class.getCanonicalName());

			} else {
				transaction.replace(R.id.provas_view,
						new ListaProvasFragment(), ListaProvasFragment.class.getCanonicalName());

			}
			transaction.commit();
		}
	}

	public boolean isTablet() {
		return getResources().getBoolean(R.bool.isTablet);
	}

}
