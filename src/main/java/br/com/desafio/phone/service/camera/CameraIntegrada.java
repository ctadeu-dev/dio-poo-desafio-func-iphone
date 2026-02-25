package br.com.desafio.phone.service.camera;

import br.com.desafio.phone.interfaces.IntfcCameraIntegrada;
import br.com.desafio.phone.service.controle.Bateria;
import br.com.desafio.phone.service.galeria.Galeria;
import br.com.desafio.phone.VO.galeria.MediaVO;
import br.com.desafio.phone.utils.Utils;

import javax.swing.*;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class CameraIntegrada implements IntfcCameraIntegrada {

    // | ICameraIntegrada | Controle  | -estadoCamera          | Atributo (int) | Estado da câmera: 0-Desligada ou 1-Ligada.   |
    // | ICameraIntegrada | Controle  | -modoCamera            | Atributo (int) | Modo da câmera: 0-Foto (default) ou 1-Video. |

    // | ICameraIntegrada | Imagem    | +iniciarCamera()       | Método         | Ligar a câmera e colocar em modo de uso.     |
    // | ICameraIntegrada | Imagem    | +fecharCamera()        | Método         | Desligar a câmera do modo de uso.            |
    // | ICameraIntegrada | Imagem    | +selecionarModoFoto()  | Método         | Seleciona o modo para tirar foto.            |
    // | ICameraIntegrada | Imagem    | +selecionarModoVideo() | Método         | Seleciona o modo para gravar video.          |
    // | ICameraIntegrada | Segurança | +capturarFacial()      | Método         | Captura facial do usuário para autenticação  |
    // | ICameraIntegrada | Imagem    | +tirarFoto()           | Método         | Registra a foto e coloca na galeria.         |
    // | ICameraIntegrada | Imagem    | +gravarVideo()         | Método         | Grava o vídeo e coloca na galeria.           |


    // Estado da câmera: 0-Desligada ou 1-Ligada.
    private static int estadoCamera = CameraIntegrada.CAMERA_DESLIGADA;

    // Modo da câmera: 0-Foto (default) ou 1-Video.
    private static int modoCamera = CameraIntegrada.MODO_CAMERA_FOTO;

    // Estado do video: 0-Video Parado/Finalizado ou 1-video gravando.
    private static int estadoVideo = CameraIntegrada.ESTADO_VIDEO_PARAR;

    private static final int CAMERA_DESLIGADA        = 0; // Estado da câmera: 0-Desligada.
    private static final int CAMERA_TRASEIRA_LIGADA  = 1; // Estado da câmera: 1-Ligada.
    private static final int CAMERA_DIANTEIRA_LIGADA = 2; // Estado da câmera: 1-Ligada.

    // Modo da câmera: 0-Foto (default) ou 1-Video.
    private static final int MODO_CAMERA_FOTO  = 0;  // Modo da câmera: 0-Foto (default).
    private static final int MODO_CAMERA_VIDEO = 1;  // Modo da câmera: 1-Video.

    private static final int ESTADO_VIDEO_PARAR  = 0; // Modo Video Parado/Finalizado
    private static final int ESTADO_VIDEO_GRAVAR = 1; // Modo video gravando


    public static String getEstadoCamera() {

        if (estadoCamera == CAMERA_DESLIGADA) {
            return "Off";
        } else if (estadoCamera == CAMERA_TRASEIRA_LIGADA) {
            return "Traseira";
        } else if (estadoCamera == CAMERA_DIANTEIRA_LIGADA) {
            return "Dianteira";
        } else {
            return "NoDef";
        }

    }

    public static String getModoCamera() {

        if (modoCamera == MODO_CAMERA_FOTO) {
            return "Foto";
        } else if (modoCamera == MODO_CAMERA_VIDEO) {
            return "Vídeo";
        } else {
            return "NoDef";
        }

    }

    // Ligar a câmera e colocar em modo de uso.
    public boolean iniciarCamera() {

        try {
            if(estadoCamera == CAMERA_DIANTEIRA_LIGADA) {
                System.out.println("Iniciando Camera dianteira do celular!");

            } else if(estadoCamera == CAMERA_DIANTEIRA_LIGADA) {
                System.out.println("Iniciando Camera traseira do celular!");
            } else {
                System.out.println("Iniciando Camera traseira do celular!");
                estadoCamera = CAMERA_DIANTEIRA_LIGADA;
            }
            modoCamera = MODO_CAMERA_FOTO;

            Scanner scanner = new Scanner(System.in);
            int acaoMainBoard = 0;

            StringBuilder sb = new StringBuilder();
            // Send all output to the Appendable object sb
            Formatter formatter = new Formatter(sb, Locale.US);

            do {
                Bateria.consumirBateria();

                try {
                    System.out.println(formatter.format("""
                        ***** CAMERA *****
                        | Câmera: %s | Modo: %s |
                        
                        Opções:
                            | 1 - Modo Foto | 2 - Modo Vídeo  | 3 - Mudar Camera | 4 - Foto-Disparar / Video-Gravar e Parar | 99 - Fechar Camera |
                        
                        Informe a opção:
                        """, getEstadoCamera(), getModoCamera()));

                    acaoMainBoard = scanner.nextInt();

                    switch(acaoMainBoard) {
                        case 1:
                            selecionarModoFoto();
                            break;
                        case 2:
                            selecionarModoVideo();
                            break;
                        case 3:
                            mudarCamera();
                            break;
                        case 4:
                            gravarFotoOuVideo();
                            break;
                        case 99: /* Fechar Camera */
                            fecharCamera();
                            break;
                        default:
                            System.out.println("Opção inválida. Informe corretamente!");
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } while(acaoMainBoard != 99);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            fecharCamera();
            System.out.println("Camera fechada...");

        }

        return true;
    }

    // Desligar a câmera do modo de uso.
    private boolean fecharCamera() {
        System.out.println("Desligando Câmera...");
        estadoCamera = CAMERA_DESLIGADA;
        modoCamera = MODO_CAMERA_FOTO;
        System.out.println("Câmera desligada...");
        return true;
    }

    // Seleciona o modo para tirar foto.
    private void selecionarModoFoto() {
        System.out.println("Selecionando modo foto...");
        // Modo da câmera: 0-Foto (default) ou 1-Video.
        modoCamera = MODO_CAMERA_FOTO;
        System.out.println("Modo foto selecionado...");
    }

    // Seleciona o modo para gravar video.
    private void selecionarModoVideo() {
        System.out.println("Selecionando modo video...");
        modoCamera = MODO_CAMERA_VIDEO;
        System.out.println("Modo vídeo selecionado...");
    }

    private void mudarCamera() {
        System.out.println("Mudando câmera em foco...");
        if (estadoCamera == CAMERA_DIANTEIRA_LIGADA) {
            estadoCamera = CAMERA_TRASEIRA_LIGADA;
            System.out.println("Mudando para câmera traseira...");
            System.out.println("Câmera traseira agora está selecionada...");

        } else { // if (estadoCamera == CAMERA_TRASEIRA_LIGADA)
            estadoCamera = CAMERA_DIANTEIRA_LIGADA;
            System.out.println("Mudando para câmera dianteira...");
            System.out.println("Câmera dianteira agora está selecionada...");
        }
    }

    // Captura facial do usuário para autenticação
    public ImageIcon capturarFacial() {
        ImageIcon  retorneImagem = new ImageIcon();

        System.out.println("Captando foto facial do usuário.");
        Utils.aguardar(1000);

        System.out.println("facial capturada com sucesso.");
        return retorneImagem;
    }

    private void gravarFotoOuVideo() {
        if (modoCamera == MODO_CAMERA_FOTO) {

            System.out.println("Iniciando captura foto.");
            Utils.aguardar(1000);
            tirarFoto();

        } else { // (modoCamera == MODO_CAMERA_VIDEO)

            // Se o estado ca camera estiver paradas (sem gravação de vídeo)
            if(estadoVideo == CameraIntegrada.ESTADO_VIDEO_PARAR) {
                // Iniciar a gravação do vídeo
                System.out.println("Iniciando gravação vídeo.");
                Utils.aguardar(1000);
                gravarVideo(CameraIntegrada.ESTADO_VIDEO_GRAVAR);

            } else { // if(estadoVideo == CameraIntegrada.ESTADO_VIDEO_PARAR)
                // Finalizar a gravação do vídeo
                System.out.println("Finalizando gravação vídeo.");
                Utils.aguardar(1000);
                gravarVideo(CameraIntegrada.ESTADO_VIDEO_PARAR);

            }

        }
    }

    // Registra a foto e coloca na galeria.
    private void tirarFoto() {
        if (estadoCamera == CAMERA_DIANTEIRA_LIGADA) {
            System.out.println("Capturando self pela câmera dianteira.");
        } else { // if (estadoCamera == CAMERA_TRASEIRA_LIGADA)
            System.out.println("Capturando foto pela câmera traseira.");
        }
        Utils.aguardar(1000);

        System.out.println("Imagem capturada com sucesso.");
        ImageIcon  imagem = new ImageIcon();
        Utils.aguardar(1000);

        System.out.println("Inserindo imagem na Galeria.");
        Utils.aguardar(1000);

        MediaVO fotoVo = new MediaVO(MediaVO.TIPO_MEDIA_FOTO, 1096L, 1096L, 0, 0, MediaVO.PADRAO_VIDEO_NTSC_FOTO, imagem);
        (new Galeria()).inserirGaleria(fotoVo);
        Utils.aguardar(1000);

        System.out.println("Imagem inserida na Galeria com sucesso.");
        Utils.aguardar(1000);
    }

    // Grava o vídeo e coloca na galeria.
    private void gravarVideo(int estado) {

        if (estado == CameraIntegrada.ESTADO_VIDEO_GRAVAR) {  // Iniciar Gravação
            estadoVideo = estado;
            System.out.println("Gravando vídeo pela câmera " + (estadoCamera == CAMERA_DIANTEIRA_LIGADA? "dianteira": "traseira") + ".");
            Utils.aguardar(1000);
        } else { // Parar Gravação
            estadoVideo = estado;
            System.out.println("vídeo gravado com sucesso.");
            byte[] videoBytes = "videoExemplo.mp4".getBytes();
            Utils.aguardar(1000);

            System.out.println("Inserindo vídeo na Galeria.");
            MediaVO videoVo = new MediaVO(MediaVO.TIPO_MEDIA_VIDEO, 1024L, 768L, 20, 30, MediaVO.PADRAO_VIDEO_NTSC_FOTO, videoBytes);
            (new Galeria()).inserirGaleria(videoVo);
            Utils.aguardar(1000);

            System.out.println("Vídeo inserido na Galeria com sucesso.");
            Utils.aguardar(1000);
        }

    }

}
