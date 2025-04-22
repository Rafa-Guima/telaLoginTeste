package com.example.telateste;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {

    EditText editLogin, editSenha;
    MaterialButton btnEntrar;

    String emailRecebido = null;
    String senhaRecebida = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            emailRecebido = bundle.getString("email");
            senhaRecebida = bundle.getString("senha");
        }

        btnEntrar.setOnClickListener(v -> {
            String login = editLogin.getText().toString().trim();
            String senha = editSenha.getText().toString().trim();

            if (login.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else if (emailRecebido != null && senhaRecebida != null) {
                // Lógica de "validação" temporária (simula o banco)
                if (login.equals(emailRecebido) && senha.equals(senhaRecebida)) {
                    Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    // Aqui você pode redirecionar para outra Activity
                } else {
                    Toast.makeText(this, "E-mail ou senha incorretos!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Nenhum usuário cadastrado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
