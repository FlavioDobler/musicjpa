package br.com.flavio.screensoundmusicas.view;

public class MenuPrincipalView {

    public void exibeMenu() {
        var menu = """
                1- Cadastrar artistas
                           
                2- Cadastrar músicas
                           
                3- Listar músicas
                           
                4- Buscar músicas por artistas
                           
                5- Pesquisar dados sobre um artista
                           
                9- Sair                                
                """;
        System.out.println(menu);
    }
}
