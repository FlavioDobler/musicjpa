package br.com.flavio.screensoundmusicas.repository;

import br.com.flavio.screensoundmusicas.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository  extends JpaRepository<Musica, Long> {
}
