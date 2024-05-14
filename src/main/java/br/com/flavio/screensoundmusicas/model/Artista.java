package br.com.flavio.screensoundmusicas.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    private String generoMusical;
    private String nacionalidade;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
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

    public Artista(long id, String nome, String generoMusical, String nacionalidade ) {
        this.id = id;
        this.nome = nome;
        this.generoMusical = generoMusical;
        this.nacionalidade = nacionalidade;
    }

    public Artista(){

    }
}
