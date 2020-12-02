package com.example.apptgt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CdActivity extends AppCompatActivity {

    @Override
    public void onBackPressed()
    {
    }

    EditText editNome, editEmail, editSenha, editTelefone, editCpf, editDataNasc;
    CardView cardLogin;

    public void confereCampos()
    {
        String nome = editNome.getText().toString();
        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        String telefone = editTelefone.getText().toString();
        String cpf = editCpf.getText().toString();
        String dataNasc = editDataNasc.getText().toString();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty() || cpf.isEmpty() || dataNasc.isEmpty())
        {
            Toast.makeText(CdActivity.this, "PREENCHA OS CAMPOS", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(CdActivity.this, MenuReservaActivity.class);
            startActivity(intent);
        }
    }

    public void cadastraUsuario()
    {
        String email = editEmail.getText().toString();
        String nome = editNome.getText().toString();
        String senha = editSenha.getText().toString();
        String telefone = editTelefone.getText().toString();
        String cpf = editCpf.getText().toString();
        String dataNasc = editDataNasc.getText().toString();

        DtoUsuario contatos = new DtoUsuario(nome, email, senha, telefone, cpf, dataNasc);
        DaoUsuario dao = new DaoUsuario(CdActivity.this);

        try
        {
            long linhasInseridas = dao.onInsert(nome, email, senha, telefone, cpf, dataNasc);

            if (linhasInseridas > 0)
            {
                Toast.makeText(CdActivity.this, "INSERIDO COM SUCESSO!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CdActivity.this, MenuReservaActivity.class);
                startActivity(intent);
            }
        }
        catch (Exception exception)
        {
            Toast.makeText(CdActivity.this, "ERRO " + exception.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void mascaras()
    {
        SimpleMaskFormatter simpleMaskTel = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher maskTel = new MaskTextWatcher(editTelefone, simpleMaskTel);
        editTelefone.addTextChangedListener(maskTel);

        SimpleMaskFormatter simpleMaskCpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher maskCpf = new MaskTextWatcher(editCpf, simpleMaskCpf);
        editCpf.addTextChangedListener(maskCpf);

        SimpleMaskFormatter simpleMaskData = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskData = new MaskTextWatcher(editDataNasc, simpleMaskData);
        editDataNasc.addTextChangedListener(maskData);

    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        cardLogin = findViewById(R.id.cardLogin);
        editTelefone = findViewById(R.id.editTelefone);
        editCpf = findViewById(R.id.editCpf);
        editDataNasc = findViewById(R.id.editDataNasc);
        mascaras();

        cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                confereCampos();
                cadastraUsuario();
            }
        });
    }
}
