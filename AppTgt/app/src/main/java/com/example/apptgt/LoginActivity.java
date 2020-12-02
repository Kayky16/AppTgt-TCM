package com.example.apptgt;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final CardView cardLogin = findViewById(R.id.cardLogin);
        final EditText editEmailLogin = findViewById(R.id.editEmailLogin);
        final EditText editSenhaLogin = findViewById(R.id.editSenhaLogin);
        TextView textView2 = findViewById(R.id.textView2);
        ImageView imageFace = findViewById(R.id.imageFace);
        ImageView imageInsta = findViewById(R.id.imageInsta);

        imageInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/tgtdevelopment/?hl=pt-br")));
            }
        });

        imageFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/The-Growth-Tree-Development-107126324355554/")));
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this, CdActivity.class);
                startActivity(intent);
            }
        });

        cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoUsuario daoUsuario = new DaoUsuario(LoginActivity.this);
                String email = editEmailLogin.getText().toString();
                String senha = editSenhaLogin.getText().toString();
                boolean sucesso = daoUsuario.onLogin(email, senha);

                if (sucesso) {
                    Intent intent = new Intent(LoginActivity.this, MenuReservaActivity.class);
                    startActivity(intent);
                } else
                    {
                    Toast.makeText(LoginActivity.this, "DADOS DE LOGIN INVÁLIDOS", Toast.LENGTH_SHORT).show();
                    editEmailLogin.setText("");
                    editSenhaLogin.setText(""); }
            }
        });
    }
}