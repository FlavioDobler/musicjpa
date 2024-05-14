package br.com.flavio.screensoundmusicas.service;

import br.com.flavio.screensoundmusicas.model.Artista;
import br.com.flavio.screensoundmusicas.model.Musica;
import br.com.flavio.screensoundmusicas.repository.ArtistaRepository;
import br.com.flavio.screensoundmusicas.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MusicaService {



    private final MusicaRepository musicaRepository;
    private final ArtistaRepository artistaRepository;
    private final ArtistaService artistaService;
    @Autowired
    public MusicaService(MusicaRepository musicaRepository, ArtistaRepository artistaRepository, ArtistaService artistaService) {
        this.musicaRepository = musicaRepository;
        this.artistaRepository = artistaRepository;
        this.artistaService = artistaService;
    }
    public void cadastarMusica(){
        Scanner leitura = new Scanner(System.in);
        try {
            System.out.println("Qual o nome da musica?");
            var nomeMusica = leitura.nextLine();

            System.out.println("Qual a duração da musica?");
            double musDuracao = 0.0;
            try {
                musDuracao = leitura.nextDouble();
            } catch (IllegalArgumentException e) {
                System.out.println("Somente números!");
                return;
            } finally {
                leitura.nextLine();
            }

            System.out.println("Qual o nome do artista da musica?");
            String artistaNome = leitura.nextLine().trim().toLowerCase();


            if (artistaNome == null || artistaNome.trim().isEmpty()) {
                System.out.println("Nome do artista inválido.");
                return;
            }
            System.out.println("Artista Digitado: " + artistaNome);
            Artista artista = artistaRepository.AcharArtista(artistaNome);
            System.out.println("Nome do artista: " + artista);
            if (artista == null) {
                System.out.println("Artista não encontrado na base de dados.");
                System.out.println("Deseja cadastrar um novo artista? (S/N)");

                String resposta = leitura.nextLine();
                if (resposta.equalsIgnoreCase("S")) {
                    artistaService.cadastrarArtista();
                    artista = artistaRepository.AcharArtista(artistaNome.toLowerCase());
                    if (artista == null) {
                        System.out.println("Erro ao cadastrar o artista. Operação cancelada.");
                        return;
                    }
                } else {
                    System.out.println("Operação cancelada.");
                    return;
                }
            }


            Musica musica = new Musica(nomeMusica, musDuracao, artista);
            musicaRepository.save(musica);

            System.out.println("Música cadastrada com sucesso!");
        }finally {
            leitura.close();
        }
    }




}
