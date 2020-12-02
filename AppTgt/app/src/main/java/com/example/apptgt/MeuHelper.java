package com.example.apptgt;

import android.widget.TextView;

public class MeuHelper {
    TextView txtNome, txtEmail, txtSenha, txtTelefone, txtCpf, txtData, txtId;
    DtoUsuario dtoUsuario;
    int id;
    public MeuHelper(SocioInfoActivity socioInfoActivity) {
        dtoUsuario = new DtoUsuario();
        txtNome = (TextView) socioInfoActivity.findViewById(R.id.txtNome);
        txtEmail = (TextView) socioInfoActivity.findViewById(R.id.txtEmail);
        txtSenha = (TextView) socioInfoActivity.findViewById(R.id.txtSenha);
        txtTelefone = (TextView) socioInfoActivity.findViewById(R.id.txtTelefone);
        txtCpf = (TextView) socioInfoActivity.findViewById(R.id.txtCpf);
        txtData = (TextView) socioInfoActivity.findViewById(R.id.txtData);
        txtId = (TextView) socioInfoActivity.findViewById(R.id.txtId);

    }

    public void preencheCampos(DtoUsuario dtoUsuario) {

        txtId.setText(String.valueOf(dtoUsuario.getId()));
        txtNome.setText(dtoUsuario.getNome());
        txtEmail.setText(dtoUsuario.getEmail());
        txtSenha.setText(dtoUsuario.getSenha());
        txtTelefone.setText(dtoUsuario.getTelefone());
        txtCpf.setText(dtoUsuario.getCpf());
        txtData.setText(dtoUsuario.getDataNasc());
        this.dtoUsuario = dtoUsuario;
    }
}
