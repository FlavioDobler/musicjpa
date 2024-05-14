package br.com.flavio.screensoundmusicas.repository;

import br.com.flavio.screensoundmusicas.model.Artista;
import br.com.flavio.screensoundmusicas.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistaRepository extends JpaRepository <Artista,Long> {
    @Query("SELECT a FROM Artista a WHERE a.nome = :nome")
    Artista AcharArtista(String nome);
}
