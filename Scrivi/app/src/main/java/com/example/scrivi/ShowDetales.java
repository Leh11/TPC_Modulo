package com.example.scrivi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDetales extends AppCompatActivity {

    String nome;
    String nascimento;
    String phone;
    String email;
    String descricaoPhone;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detales);

        Intent destinoPessoa = getIntent();
        Bundle dadosPessoa    = destinoPessoa.getExtras();

        nome           = dadosPessoa.getString(getResources().getString(R.string.labelNome));
        nascimento     = dadosPessoa.getString(getResources().getString(R.string.labelNascimento));
        phone          = dadosPessoa.getString(getResources().getString(R.string.labelPhone));
        email          = dadosPessoa.getString(getResources().getString(R.string.labelEmail));
        descricaoPhone = dadosPessoa.getString(getResources().getString(R.string.labelDescritor));

        TextView showNome      = findViewById(R.id.idTxvNome);
        TextView shownascimento   = findViewById(R.id.idTxvNascimento);
        TextView showPhone     = findViewById(R.id.idTxvPhone);
        TextView showEmail     = findViewById(R.id.idTxvEmail);
        TextView showDescritor = findViewById(R.id.idTxvDescritor);

        showNome.setText("Nome: "+nome);
        shownascimento.setText("Nascimento: "+nascimento);
        showPhone.setText("Phone: "+phone);
        showEmail.setText("Email: "+email);
        showDescritor.setText("Descriçao: "+descricaoPhone);

    }

    public void editar(View view) {
        Intent intentPessoa = new Intent(ShowDetales.this, MainActivity.class);
        Bundle dadosPessoa = new Bundle();

        dadosPessoa.putString(getResources().getString(R.string.labelNome), nome);
        dadosPessoa.putString(getResources().getString(R.string.labelNascimento), nascimento);
        dadosPessoa.putString(getResources().getString(R.string.labelPhone), phone);
        dadosPessoa.putString(getResources().getString(R.string.labelEmail), email);
        dadosPessoa.putString(getResources().getString(R.string.labelDescritor), descricaoPhone);

        intentPessoa.putExtras(dadosPessoa);
        startActivity(intentPessoa);
    }
}