package br.com.desafio.phone.interfaces;

import br.com.desafio.phone.excessao.PhoneInitializeException;

import javax.swing.*;
import java.awt.*;

public interface IntfcCameraIntegrada {

    // | ICameraIntegrada | Controle  | -listaImagem           | Atributo (List) | Galeria de media.                                                                                             |
    // | ICameraIntegrada | Controle  | -estadoCamera          | Atributo (int)  | Estado da câmera: 0-Desligada ou 1-Ligada.                                                                    |
    // | ICameraIntegrada | Controle  | -modoCamera            | Atributo (int)  | Modo da câmera: 0-Foto (default) ou 1-Video.                                                                  |
    // | ICameraIntegrada | Imagem    | +iniciarCamera()       | Método          | Ligar a câmera e colocar em modo de uso.                                                                      |
    // | ICameraIntegrada | Imagem    | +fecharCamera()        | Método          | Desligar a câmera do modo de uso.                                                                             |
    // | ICameraIntegrada | Imagem    | +selecionarModoFoto()  | Método          | Seleciona o modo para tirar foto.                                                                             |
    // | ICameraIntegrada | Imagem    | +selecionarModoVideo() | Método          | Seleciona o modo para gravar video.                                                                           |
    // | ICameraIntegrada | Segurança | +capturarFacial()      | Método          | Registra a foto e coloca na galeria.                                                                          |
    // | ICameraIntegrada | Imagem    | +tirarFoto()           | Método          | Registra a foto e coloca na galeria.                                                                          |
    // | ICameraIntegrada | Imagem    | +gravarVideo()         | Método          | Grava o vídeo e coloca na galeria.                                                                            |

    public boolean iniciarCamera();       // Ligar a câmera e colocar em modo de uso.
    public ImageIcon capturarFacial();    // Captura facial do usuário para autenticação

}
