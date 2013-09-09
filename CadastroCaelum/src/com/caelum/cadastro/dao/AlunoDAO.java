package com.caelum.cadastro.dao;

import com.caelum.cadastro.modelo.Aluno;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDAO extends SQLiteOpenHelper {

	private static final int VERSAO = 1;
	private static final String BANCO = "CadastroCaelum";
	private static final String TABELA = "FJ57";

	public AlunoDAO(Context context) {
		super(context, BANCO, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase sqlDb) {
		String create = "CREATE TABLE "
				+ TABELA
				+ " id INTEGER PRIMARY KEY, "
				+ "nome TEXT UNIQUE NOT NULL, telefone TEXT,endereco TEXT,site TEXT,"
				+ "nota REAL, foto TEXT);";
		sqlDb.execSQL(create);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {

		String sql = "DROP TABLE IF EXISTS " + TABELA;
		db.execSQL(sql);
		this.onCreate(db);

	}
	
	public void insere(Aluno aluno){
		
		ContentValues valores = toValues(aluno);
		
		getWritableDatabase().insert(TABELA, null, valores);
		
	}
	
	private ContentValues toValues(Aluno aluno){
		
		ContentValues valores = new ContentValues();
		
		valores.put("nome", aluno.getNome());
		valores.put("endereco", aluno.getEndereco());
		valores.put("site", aluno.getSite());
		valores.put("telefone", aluno.getTelefone());
		valores.put("nota",aluno.getNota());
		
		return valores;
	}

}
