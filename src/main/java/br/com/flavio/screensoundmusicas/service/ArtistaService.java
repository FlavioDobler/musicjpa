package br.com.flavio.screensoundmusicas.service;

import br.com.flavio.screensoundmusicas.controller.MusicaController;
import br.com.flavio.screensoundmusicas.model.Artista;
import br.com.flavio.screensoundmusicas.repository.ArtistaRepository;
import br.com.flavio.screensoundmusicas.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ArtistaService {


    @Autowired
    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository repositorio) {
        this.artistaRepository = repositorio;
    }

    public void cadastrarArtista(){
        Scanner leitura = new Scanner(System.in);
        try {
            System.out.println("Qual o nome do artista?");
            var nomeArtista = leitura.nextLine();

            Artista existingArtista = artistaRepository.AcharArtista(nomeArtista);
            if (existingArtista != null) {
                System.out.println("Artista com o mesmo nome já cadastrado na base de dados.");
                return;
            }

            System.out.println("Qual o gênero musical?");
            String generoMusical = leitura.nextLine();

            System.out.println("Qual a nacionalidade?");
            String nacionalidade = leitura.nextLine();


            Artista artista = new Artista();
            artista.setNome(nomeArtista.trim());
            artista.setGeneroMusical(generoMusical.trim());
            artista.setNacionalidade(nacionalidade.trim());

            artistaRepository.save(artista);

            System.out.println("Artista cadastrado com sucesso!");
        }
        finally {
            leitura.close();
        }
    }


}
