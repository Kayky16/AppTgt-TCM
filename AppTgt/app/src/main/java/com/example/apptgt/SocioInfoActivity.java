package com.example.apptgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SocioInfoActivity extends AppCompatActivity {
    EditText txtNome, txtEmail, txtSenha, txtTelefone, txtCpf, txtData;
    Button btnEdita, btnHabilita;
    DaoUsuario daoUsuario = new DaoUsuario(SocioInfoActivity.this);
    DtoUsuario dtoUsuario = new DtoUsuario();
    private MeuHelper helper;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio_info);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtCpf = findViewById(R.id.txtCpf);
        txtData = findViewById(R.id.txtData);
        btnEdita = findViewById(R.id.btnEdita);
        btnHabilita = findViewById(R.id.btnHabilita);


        btnHabilita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                habilitaCampos();
            }
        });

        btnEdita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DtoUsuario dtoUsuario = new DtoUsuario();
                dtoUsuario.setId(id);
                dtoUsuario.setNome(txtNome.getText().toString());
                dtoUsuario.setEmail(txtEmail.getText().toString());
                dtoUsuario.setSenha(txtSenha.getText().toString());
                dtoUsuario.setTelefone(txtTelefone.getText().toString());
                dtoUsuario.setCpf(txtCpf.getText().toString());
                dtoUsuario.setDataNasc(txtData.getText().toString());

                DaoUsuario dao = new DaoUsuario(SocioInfoActivity.this);
                try
                {
                    long linhasInseridas = dao.alterar(dtoUsuario);

                    if (linhasInseridas > 0)
                    {
                        Toast.makeText(SocioInfoActivity.this, "INSERIDO COM SUCESSO!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SocioInfoActivity.this, MenuReservaActivity.class);
                        startActivity(intent);
                    }
                }
                catch (Exception exception)
                {
                    Toast.makeText(SocioInfoActivity.this, "ERRO " + exception.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        desabilitaCampos();

        helper = new MeuHelper(this);

        Intent intent = getIntent();

        DtoUsuario usuario = (DtoUsuario) intent.getSerializableExtra("usuario");

        helper.preencheCampos(usuario);
    }
    private void desabilitaCampos(){
        txtNome.setEnabled(false);
        txtEmail.setEnabled(false);
        txtSenha.setEnabled(false);
        txtTelefone.setEnabled(false);
        txtCpf.setEnabled(false);
        txtData.setEnabled(false);
    }
    private void habilitaCampos(){
        txtNome.setEnabled(true);
        txtEmail.setEnabled(true);
        txtSenha.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtCpf.setEnabled(true);
        txtData.setEnabled(true);
    }
}