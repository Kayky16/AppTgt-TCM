package com.example.apptgt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavAction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MenuReservaActivity extends AppCompatActivity {
    CardView cardSocios, cardClientes, cardAtividades, cardContratos, cardServicos, cardPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_reserva);

        cardSocios = findViewById(R.id.cardSocios);
        cardClientes = findViewById(R.id.cardClientes);
        cardAtividades = findViewById(R.id.cardAtividades);
        cardContratos = findViewById(R.id.cardContratos);
        cardServicos = findViewById(R.id.cardServicos);
        cardPerfil = findViewById(R.id.cardPerfil);


        cardSocios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuReservaActivity.this, SociosActivity.class);
                startActivity(intent);
            }
        });

        cardClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuReservaActivity.this, ClientActivity.class);
                startActivity(intent);
            }
        });

        cardAtividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuReservaActivity.this, AtividadesActivity.class);
                startActivity(intent);
            }
        });

        cardContratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuReservaActivity.this, ContratosActivity.class);
                startActivity(intent);
            }
        });

        cardServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuReservaActivity.this, ServicosActivity.class);
                startActivity(intent);
            }
        });

        cardPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuReservaActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed()
    {
    }
}