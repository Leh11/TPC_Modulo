package com.example.scrivi;

public class Pessoa {

    private String nome;
    private String apelido;
    private String phone;
    private String email;
    private String descritor;

    private int dia;
    private int mes;
    private int ano;

    public Pessoa() {
    }

    public Pessoa(String nome, String apelido, String phone, String email, String descritor) {
        this.nome = nome;
        this.apelido = apelido;
        this.phone = phone;
        this.email = email;
        this.descritor = descritor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescritor() {
        return descritor;
    }

    public void setDescritor(String descritor) {
        this.descritor = descritor;
    }

    public String getNascimento(){
        return getDia()+"/"+getMes()+"/"+getAno();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
