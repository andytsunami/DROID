package br.com.caelum.cadastro;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import br.com.caelum.cadastro.modelo.Prova;
import br.com.caelum.fragment.DetalhesProvaFragment;
import br.com.caelum.fragment.ListaProvasFragment;

import com.caelum.cadastro.R;

public class ProvasActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.provas);
		
		FragmentTransaction transaction;
		
		if (bundle == null) {
			transaction = getSupportFragmentManager()
					.beginTransaction();
			
			if (isTablet()) {
				transaction.replace(R.id.provas_lista, new ListaProvasFragment(),
						ListaProvasFragment.class.getCanonicalName())
						.replace(R.id.provas_detalhe, new DetalhesProvaFragment(),
						DetalhesProvaFragment.class.getCanonicalName());

			} else {
				transaction.replace(R.id.provas_view,
						new ListaProvasFragment(),
						ListaProvasFragment.class.getCanonicalName());

			}
			transaction.commit();
		}
	}

	public boolean isTablet() {
		return getResources().getBoolean(R.bool.isTablet);
	}

	public void selecionaProva(Prova prova) {
		Bundle argumentos = new Bundle();
		argumentos.putSerializable("prova", prova);
		DetalhesProvaFragment detalhesProva = new DetalhesProvaFragment();
		detalhesProva.setArguments(argumentos);

		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		
		if(!isTablet()){
		transaction.replace(R.id.provas_view, detalhesProva,
				DetalhesProvaFragment.class.getCanonicalName());
		} else {
			transaction.replace(R.id.provas_detalhe, detalhesProva,DetalhesProvaFragment.class.getCanonicalName());
		}
		Toast.makeText(this, "Tablet? " + isTablet(), Toast.LENGTH_LONG).show();

		if (!isTablet()) {
			transaction.addToBackStack(null);
		}

		transaction.commit();
	}

}
