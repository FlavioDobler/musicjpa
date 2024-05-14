package br.com.flavio.screensoundmusicas.controller;

import br.com.flavio.screensoundmusicas.repository.ArtistaRepository;
import br.com.flavio.screensoundmusicas.service.ArtistaService;
import br.com.flavio.screensoundmusicas.service.MusicaService;
import br.com.flavio.screensoundmusicas.view.MenuPrincipalView;

import java.util.Scanner;

public class MusicaController {

    private Scanner leitura = new Scanner(System.in);
    private final  MenuPrincipalView menu = new MenuPrincipalView();
    private final ArtistaService artistaService;
    private final MusicaService musicaService;

    public MusicaController(ArtistaService artistaService, MusicaService musicaService) {
        this.artistaService = artistaService;
        this.musicaService = musicaService;
    }

        public  void executarMenuPrincipal(){
            var opcao = -1;

            while (opcao != 9) {
                menu.exibeMenu();
                opcao = leitura.nextInt();

                    switch (opcao){
                            case 1 :
                            artistaService.cadastrarArtista();
                            break;
                            case 2:
                            musicaService.cadastarMusica();
                            break;
                    }
                }

        }
    }
