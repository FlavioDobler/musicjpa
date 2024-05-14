package br.com.flavio.screensoundmusicas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private  double duracao;
    @ManyToOne
    private Artista artista;

    public long getId() {
        return id;
    }

    public Musica(String nome, double duracao, Artista artista) {
        this.nome = nome;
        this.duracao = duracao;
        this.artista = artista;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Musica(){

    }
}
