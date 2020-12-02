package com.example.apptgt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SociosActivity extends AppCompatActivity {

    ListView listSocios;
    Button btnAddSocio;
    DaoUsuario daoUsuario = new DaoUsuario(SociosActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socios);
        listSocios = findViewById(R.id.listSocios);

        listSocios.setAdapter(new ArrayAdapter<>(SociosActivity.this,
                android.R.layout.simple_list_item_1,
                daoUsuario.obterTodos()));

        socioInfos();

        btnAddSocio = findViewById(R.id.btnAddSocio);
        btnAddSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SociosActivity.this, CdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void socioInfos() {
        listSocios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DtoUsuario usuario = (DtoUsuario) listSocios.getItemAtPosition(position);

                Intent intentUsuario = new Intent(SociosActivity.this, SocioInfoActivity.class);
                intentUsuario.putExtra("id", usuario.getId());
                intentUsuario.putExtra("usuario", usuario);
                startActivity(intentUsuario);
            }
        });
    }
}
