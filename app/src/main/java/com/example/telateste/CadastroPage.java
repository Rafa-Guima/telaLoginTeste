package com.example.telateste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroPage extends AppCompatActivity {

    LinearLayout layoutPassageiro, layoutMotorista;
    Button btnPassageiro, btnMotorista;
    MaterialButton btnCadastrar;

    // Passageiro
    EditText editNomePassageiro, editSobrenomePassageiro, editTelefonePassageiro, editEmailPassageiro, editSenhaPassageiro, editConfirmarSenhaPassageiro;

    // Motorista
    EditText editNomeMotorista, editSobrenomeMotorista, editTelefoneMotorista, editEmailMotorista, editModeloVeiculoMotorista, editPlacaMotorista, editSenhaMotorista, editConfirmarSenhaMotorista;

    boolean tipoPassageiroSelecionado = false;
    boolean tipoMotoristaSelecionado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_page);

        layoutPassageiro = findViewById(R.id.layoutPassageiro);
        layoutMotorista = findViewById(R.id.layoutMotorista);

        btnPassageiro = findViewById(R.id.btnPassageiro);
        btnMotorista = findViewById(R.id.btnMotorista);
        btnCadastrar = findViewById(R.id.btnCadastrar);


        editNomePassageiro = findViewById(R.id.editNomePassageiro);
        editSobrenomePassageiro = findViewById(R.id.editSobrenomePassageiro);
        editTelefonePassageiro = findViewById(R.id.editTelefonePassageiro);
        editEmailPassageiro = findViewById(R.id.editEmailPassageiro);
        editSenhaPassageiro = findViewById(R.id.editSenhaPassageiro);
        editConfirmarSenhaPassageiro = findViewById(R.id.editConfirmarSenhaPassageiro);


        editNomeMotorista = findViewById(R.id.editNomeMotorista);
        editSobrenomeMotorista = findViewById(R.id.editSobrenomeMotorista);
        editTelefoneMotorista = findViewById(R.id.editTelefoneMotorista);
        editEmailMotorista = findViewById(R.id.editEmailMotorista);
        editModeloVeiculoMotorista = findViewById(R.id.editModeloVeiculoMotorista);
        editPlacaMotorista = findViewById(R.id.editPlacaMotorista);
        editSenhaMotorista = findViewById(R.id.editSenhaMotorista);
        editConfirmarSenhaMotorista = findViewById(R.id.editConfirmarSenhaMotorista);


        btnPassageiro.setOnClickListener(v -> {
            layoutPassageiro.setVisibility(View.VISIBLE);
            layoutMotorista.setVisibility(View.GONE);
            tipoPassageiroSelecionado = true;
            tipoMotoristaSelecionado = false;
        });

        btnMotorista.setOnClickListener(v -> {
            layoutMotorista.setVisibility(View.VISIBLE);
            layoutPassageiro.setVisibility(View.GONE);
            tipoMotoristaSelecionado = true;
            tipoPassageiroSelecionado = false;
        });

        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(CadastroPage.this, LoginPage.class);
            Bundle bundle = new Bundle();

            if (tipoPassageiroSelecionado) {
                String nome = editNomePassageiro.getText().toString().trim();
                String sobrenome = editSobrenomePassageiro.getText().toString().trim();
                String telefone = editTelefonePassageiro.getText().toString().trim();
                String email = editEmailPassageiro.getText().toString().trim();
                String senha = editSenhaPassageiro.getText().toString().trim();
                String confirmarSenha = editConfirmarSenhaPassageiro.getText().toString().trim();

                if (nome.isEmpty() || sobrenome.isEmpty() || telefone.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                    Toast.makeText(this, "Preencha todos os campos do passageiro", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!senha.equals(confirmarSenha)) {
                    Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                    return;
                }

                bundle.putString("tipo", "Passageiro");
                bundle.putString("nome", nome);
                bundle.putString("sobrenome", sobrenome);
                bundle.putString("telefone", telefone);
                bundle.putString("email", email);
                bundle.putString("senha", senha);

                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

            } else if (tipoMotoristaSelecionado) {
                String nome = editNomeMotorista.getText().toString().trim();
                String sobrenome = editSobrenomeMotorista.getText().toString().trim();
                String telefone = editTelefoneMotorista.getText().toString().trim();
                String email = editEmailMotorista.getText().toString().trim();
                String modelo = editModeloVeiculoMotorista.getText().toString().trim();
                String placa = editPlacaMotorista.getText().toString().trim();
                String senha = editSenhaMotorista.getText().toString().trim();
                String confirmarSenha = editConfirmarSenhaMotorista.getText().toString().trim();

                if (nome.isEmpty() || sobrenome.isEmpty() || telefone.isEmpty() || email.isEmpty() || modelo.isEmpty() || placa.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                    Toast.makeText(this, "Preencha todos os campos do motorista", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!senha.equals(confirmarSenha)) {
                    Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                    return;
                }

                bundle.putString("tipo", "Motorista");
                bundle.putString("nome", nome);
                bundle.putString("sobrenome", sobrenome);
                bundle.putString("telefone", telefone);
                bundle.putString("email", email);
                bundle.putString("modeloVeiculo", modelo);
                bundle.putString("placa", placa);
                bundle.putString("senha", senha);

                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Selecione Passageiro ou Motorista", Toast.LENGTH_SHORT).show();
                return;
            }

            intent.putExtras(bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }



}
