package br.com.desafio.phone.service.galeria;

import br.com.desafio.phone.VO.galeria.MediaVO;
import br.com.desafio.phone.service.controle.Bateria;
import br.com.desafio.phone.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Galeria {

    //| Galeria | Controle | -galeriaMedia       | Atributo (List) | Galeria de media.                                    |

    //| Galeria | Media    | -inserirNaGaleria() | Método          | Insere media (foto ou vídeo) na galeria.             |
    //| Galeria | Media    | -deletarDaGaleria() | Método          | Remove media (foto ou vídeo) da galeria.             |
    //| Galeria | Media    | +listarGaleria()    | Método          | Lista as medias que estão na galeria.                |
    //| Galeria | Media    | +exibirMedia()      | Método          | Orquestrador para exibição de media (Foto ou Video). |
    //| Galeria | Media    | -mostrarFoto()      | Método          | Exibe a media (foto) para o usuário.                 |
    //| Galeria | Media    | -exibirVideo()      | Método          | Exibe a media (vídeo) para o usuário.                |

    // Galeria de media.
    private static HashMap<Long, MediaVO> galeriaMedia = new HashMap<>();

    public void showGaleria() {

        try {
            listarGaleria();

            Scanner scanner = new Scanner(System.in);
            int acaoGaleria = 0;

            do {
                Bateria.consumirBateria();

                try {
                    System.out.println("""
                        ***** Galeria *****
                        
                        Opções:
                            Funções:
                            | 1 - Apagar todos Itens da Galeria |
                            | 2 - Exibir Media                  |
                            
                            Funções de Liga/Desliga:
                            | 99 - Sair da Galeria              |
                             
                        Informe a opção: 
                        """);
                    acaoGaleria = scanner.nextInt();

                    switch(acaoGaleria) {
                        case 1:
                            deletarGaleria();
                            break;
                        case 2:
                            exibirMedia();
                            break;
                        case 99: /* Sair da Galeria */
                            break;
                        default:
                            System.out.println("Opção inválida. Informe corretamente!");
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } while(acaoGaleria != 99);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    // Captura facial do usuário para autenticação
    public Boolean inserirGaleria(MediaVO videoImagem) {
        Long ultimoElemento = 0L;

        try {

            System.out.println("Identificando o último elemento da galeria.");
            if (galeriaMedia.isEmpty()) {

                ultimoElemento = 1L;

            } else {

                Map.Entry<Long, MediaVO> lastEntry = galeriaMedia.entrySet()
                        .stream()
                        .reduce((first, second) -> second) // Reduz até sobrar apenas o último
                        .orElse(null); // Trata mapa vazio
                if(lastEntry != null) {
                    System.out.println("Último: " + lastEntry.getKey() + " = " + lastEntry.getValue());
                    System.out.println("Próximo: " + lastEntry.getKey() + 1);
                    ultimoElemento = lastEntry.getKey() + 1;
                }

            }

            System.out.println("Inserindo objeto na lista da galeria.");
            videoImagem.setIdMedia(ultimoElemento);
            galeriaMedia.put(videoImagem.getIdMedia(), videoImagem);
            Utils.aguardar(1000);

            System.out.println("facial capturada com sucesso.");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

    // Remove media (foto ou vídeo) da galeria.
    private void deletarGaleria() {

        galeriaMedia = new HashMap<>();
        listarGaleria();

    }

    // Lista as medias que estão na galeria.
    public void listarGaleria() {

        System.out.println("Listando elementos da galeria.");
        galeriaMedia.forEach((key, value) -> System.out.println(value.toString()));

    }

    // Orquestrador para exibição de media (Foto ou Video).
    public void exibirMedia() {

        System.out.println("Exibindo media. Musica, Video ou Foto!");
        Utils.aguardar(2000L);

    }

    // Exibe a media (foto) para o usuário.
    private void mostrarFoto() {}

    // Exibe a media (vídeo) para o usuário.
    private void exibirVideo() {}

    // Exibe a media (Musica) para o usuário.
    private void tocarMusica() {}



}
