package br.com.flavio.screensoundmusicas;

import br.com.flavio.screensoundmusicas.controller.MusicaController;
import br.com.flavio.screensoundmusicas.service.ArtistaService;
import br.com.flavio.screensoundmusicas.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundMusicasApplication implements CommandLineRunner {

	@Autowired
	private ArtistaService artistaService;

	@Autowired
	private MusicaService musicaService;

	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundMusicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MusicaController main = new MusicaController(artistaService,musicaService);
		main.executarMenuPrincipal();
	}
}
