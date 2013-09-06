package com.caelum.cadastro.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDAO extends SQLiteOpenHelper{

	private static final int VERSAO = 1;
	private static final String CADASTRO_CAELUM = "CadastroCaelum";

	public AlunoDAO(Context context) {
		super(context, CADASTRO_CAELUM, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase sqlDb) {
		String create = "CREATE TABLE FJ57 id INTEGER PRIMARY KEY, " +
				"nome TEXT UNIQUE NOT NULL, telefone TEXT,endereco TEXT,site TEXT," +
				"nota REAL, foto TEXT);";
		sqlDb.execSQL(create);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
