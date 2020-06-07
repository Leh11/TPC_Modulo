package com.example.scrivi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{
    Pessoa pessoa = new Pessoa();
    private String nome;
    private String phone;
    private String email;
    private String descritor;
    private EditText editNome;
    private EditText editNascimento;
    private EditText editPhone;
    private EditText editEmail;
    private EditText editDescricao;
    DatePickerDialog nascimento;
    Calendar calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome       = findViewById(R.id.idNome);
        editNascimento = findViewById(R.id.idNascimento);
        editPhone      = findViewById(R.id.idPhone);
        editEmail      = findViewById(R.id.idEmail);
        editDescricao  = findViewById(R.id.idDescritor);
        calendario     = Calendar.getInstance();

        nascimento = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar dataSelecionada = Calendar.getInstance();
                dataSelecionada.set(year, month, dayOfMonth);
                pessoa.setDia(dayOfMonth);
                pessoa.setMes(month);
                pessoa.setAno(year);
                @SuppressLint("SimpleDateFormat") SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
                editNascimento.setText(formatData.format(dataSelecionada.getTime()));
            }
        }, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH));

        editNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nascimento.show();
            }
        });

        Intent destinoPessoa = getIntent();
        Bundle dadosPessoa    = destinoPessoa.getExtras();
        if (dadosPessoa != null && pessoa != null){
            nome           = dadosPessoa.getString(getResources().getString(R.string.labelNome));
            String nas     = dadosPessoa.getString(getResources().getString(R.string.labelNascimento));
            phone          = dadosPessoa.getString(getResources().getString(R.string.labelPhone));
            email          = dadosPessoa.getString(getResources().getString(R.string.labelEmail));
            descritor      = dadosPessoa.getString(getResources().getString(R.string.labelDescritor));

            editNome.setText(nome);
            editNascimento.setText(nas);
            editPhone.setText(phone);
            editEmail.setText(email);
            editDescricao.setText(descritor);
        }
    }

    public void editarDadosPessoa(){
        nome      = editNome.getText().toString();
        phone     = editPhone.getText().toString();
        email     = editEmail.getText().toString();
        descritor = editDescricao.getText().toString();

        pessoa.setNome(nome);
        pessoa.setPhone(phone);
        pessoa.setEmail(email);
        pessoa.setDescritor(descritor);
    }

    public void onClick(View v) {

        editarDadosPessoa();
        Intent intentPessoa = new Intent(MainActivity.this, ShowDetales.class);
        Bundle dadosPessoa = new Bundle();

        dadosPessoa.putString(getResources().getString(R.string.labelNome), pessoa.getNome());
        dadosPessoa.putString(getResources().getString(R.string.labelNascimento), pessoa.getNascimento());
        dadosPessoa.putString(getResources().getString(R.string.labelPhone), pessoa.getPhone());
        dadosPessoa.putString(getResources().getString(R.string.labelEmail), pessoa.getEmail());
        dadosPessoa.putString(getResources().getString(R.string.labelDescritor), pessoa.getDescritor());

        intentPessoa.putExtras(dadosPessoa);
        startActivity(intentPessoa);
    }



}
