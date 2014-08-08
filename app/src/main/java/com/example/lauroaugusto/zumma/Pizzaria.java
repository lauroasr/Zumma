package com.example.lauroaugusto.zumma;

/**
 * Created by Jefferson on 04/08/2014.
 */
public class Pizzaria {
    int id;
    String nome;
    int idImg;
    String telefone;

    public Pizzaria() {

    }

    public Pizzaria(String nome, int idImg, int id) {
        super();
        this.id = id;
        this.nome = nome;
        this.idImg = idImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
