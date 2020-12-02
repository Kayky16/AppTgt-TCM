package com.example.apptgt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DaoUsuario extends SQLiteOpenHelper {
    public DaoUsuario(@Nullable Context context) {
        super(context, "db_usuario", null, 1);
    }

    List<DtoUsuario> socios = new ArrayList<>();

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tb_usuario(" +
                "id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(50)NOT NULL," +
                "email VARCHAR(50)NOT NULL," +
                "senha VARCHAR(50)NOT NULL," +
                "telefone VARCHAR(14)NOT NULL," +
                "cpf VARCHAR(14)NOT NULL," +
                "data DATE(8)NOT NULL)");

        db.execSQL("CREATE TABLE tb_servs(" +
                "id_serv INTEGER PRIMARY KEY," +
                "vl_serv DECIMAL(6,2)NOT NULL," +
                "disp_serv VARCHAR(20)NOT NULL)");

        db.execSQL("CREATE TABLE tb_clientes(" +
                "id_cli INTEGER PRIMARY KEY," +
                "nm_emp VARCHAR(50)NOT NULL," +
                "cnpj_cli VARCHAR(50)NOT NULL)");

        db.execSQL("CREATE TABLE tb_contratos(" +
                "id_cont INTEGER PRIMARY KEY," +
                "dt_cont DATE(8)NOT NULL," +
                "nm_cliente VARCHAR(50)NOT NULL," +
                "fn_cont VARCHAR(200)NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long onInsert(String nome, String email, String senha, String telefone, String cpf, String dataNasc) {
        ContentValues valores = new ContentValues();

        valores.put("nome", nome);
        valores.put("email", email);
        valores.put("senha", senha);
        valores.put("telefone", telefone);
        valores.put("cpf", cpf);
        valores.put("data", dataNasc);

        return getWritableDatabase().insert("tb_usuario", null, valores);
    }

    public boolean onLogin(String email, String senha) {
        String comando = "SELECT * FROM tb_usuario WHERE email=? and senha=?";
        String[] colunas = {email, senha};
        Cursor cursor = getReadableDatabase().rawQuery(comando, colunas);

        return cursor.moveToNext();
    }

    public List<DtoUsuario> obterTodos() {
        String comando = "SELECT * FROM tb_usuario";
        List<DtoUsuario> socios = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(comando, null);

        while (cursor.moveToNext()) {
            DtoUsuario dtoUsuario = new DtoUsuario();
            dtoUsuario.setId(cursor.getInt(0));
            dtoUsuario.setNome(cursor.getString(1));
            dtoUsuario.setEmail(cursor.getString(2));
            dtoUsuario.setSenha(cursor.getString(3));
            dtoUsuario.setTelefone(cursor.getString(4));
            dtoUsuario.setCpf(cursor.getString(5));
            dtoUsuario.setDataNasc(cursor.getString(6));

            socios.add(dtoUsuario);
        }
        return socios;
    }

    public long alterar(DtoUsuario dtoUsuario) {
        ContentValues valores = new ContentValues();
        valores.put("nome", dtoUsuario.getNome());
        valores.put("email", dtoUsuario.getEmail());
        valores.put("senha", dtoUsuario.getSenha());
        valores.put("telefone", dtoUsuario.getTelefone());
        valores.put("cpf", dtoUsuario.getCpf());
        valores.put("data", dtoUsuario.getDataNasc());
        String id = "id=?";
        String[] args = {dtoUsuario.getId()+""};
        return getWritableDatabase().update("tb_usuario", valores, id, args);
    }
}
