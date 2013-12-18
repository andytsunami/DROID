package com.caelum.cadastro.receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import com.caelum.cadastro.R;
import com.caelum.cadastro.dao.AlunoDAO;
import com.caelum.cadastro.modelo.Aluno;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		AlunoDAO alunoDAO = new AlunoDAO(context);

		Bundle bundle = intent.getExtras();

		Object mensagens[] = (Object[]) bundle.get("pdus");

		byte[] mensagem = (byte[]) mensagens[0];

		SmsMessage sms = SmsMessage.createFromPdu(mensagem);

		if (alunoDAO.isAluno(sms.getDisplayOriginatingAddress())) {
			
			Aluno aluno = alunoDAO.buscaPorTelefone(sms.getDisplayOriginatingAddress());

			Toast.makeText(
					context,
					"Chegou um SMS do aluno: "
							+ sms.getDisplayOriginatingAddress() + " -- " + aluno.getNome(),
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(context,
					"Chegou um SMS de: " + sms.getDisplayOriginatingAddress(),
					Toast.LENGTH_LONG).show();
		}
		
		MediaPlayer player = MediaPlayer.create(context,R.raw.picapau);
		player.start();
	}

}
