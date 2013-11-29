package com.caelum.cadastro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Bundle bundle = intent.getExtras();
		
		Object mensagens[] = (Object[]) bundle.get("pdus");
		
		byte[] mensagem = (byte[]) mensagens[0];
		
		SmsMessage sms = SmsMessage.createFromPdu(mensagem);
		
		
		Toast.makeText(context, "Chegou um SMS de: " + sms.getDisplayOriginatingAddress(), Toast.LENGTH_LONG).show();
		
	}
	
	

}
