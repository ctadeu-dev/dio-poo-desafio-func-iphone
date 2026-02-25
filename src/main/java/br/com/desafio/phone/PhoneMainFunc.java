package br.com.desafio.phone;

import br.com.desafio.phone.principal.PhoneMainBoard;
import br.com.desafio.phone.service.conexao.PhoneConexao;
import br.com.desafio.phone.service.controle.Bateria;
import br.com.desafio.phone.service.controle.PhoneControle;

import java.util.Scanner;

public class PhoneMainFunc extends PhoneControle {

    private PhoneControle phoneControle = new PhoneControle();
    private PhoneConexao  phoneConexao = new PhoneConexao();

    public void usuarioInteracaoInicial() {

        try {

            Scanner scanner = new Scanner(System.in);
            int acaoAparelho = 0;

            do {
                Bateria.consumirBateria();

                try {
                    System.out.println("""
                        ***** Ação para Aparelho *****
                        
                        Opções:
                            Energia:
                            | 1 - Carregar Bateria             |                             |
                            
                            Conexão:
                            | 11 - Inserir Chip Operadora      | 12 - Remover Chip Operadora |
                             
                            Ações do Usuário:
                            | 21 - Ligar Aparelho              | 22 - Desligar Aparelho      |
                            | 23 - Inverter Posiçaão Aparelho  |                             |
                            
                            | 99 - Encerrar execuçãoa          |                             |
                         
                        Informe a opção: 
                    """);

                    acaoAparelho = scanner.nextInt();

                    switch(acaoAparelho) {
                        case 1:
                            Bateria.carregarBateria();
                            break;
                        case 11:
                            phoneConexao.inserirChipTelefonia();
                            break;
                        case 12:
                            phoneConexao.removerChipTelefonia();
                            break;
                        case 21:
                            if(phoneControle.ligarAparelho()) {
                                //    // phoneConexao.selecionarConexaoWifi()
                                phoneConexao.conectarRedeTelefonia();
                                (new PhoneMainBoard()).showMainBoard();
                            }
                            break;
                        case 22:
                            phoneControle.desligarAparelho();
                            break;
                        case 23:
                            phoneControle.mudarPosicaoAparelho(PhoneControle.MODO_EXIBICAO_INVERTER);
                            break;
//                        case 5:
//                            break;
//                        case 6:
//                            break;
//                        case 7:
//                            break;
//                        case 8:
//                            break;
                        case 99:
                            break;
                        default:
                            System.out.println("Opção inválida. Informe novamente!");
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } while(acaoAparelho != 99);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            phoneControle.desligarAparelho();
            System.out.println("Aparelho desligado...");

        }

    }



    /*


    ## Lista de classes, interfaces, atributos e métodos

    | Classe    | Função   | Elemento | Tipo | Descrição |
    |-----------|----------|--------------------|-----------|---------------------|
    | - | - | - | - | - |
    | - | - | - | - | - |
    | - | - | - | - | - |
    | AparelhoTelefonico | Chamada | -verificarSinalRede() | Método | Verifica o estado da rede de telefonia ao realizar chamada. |
    | AparelhoTelefonico | Chamada | +atenderChamada() | Método | Executa uma ação de atendimento de chamada telafônica. |
    | AparelhoTelefonico | Chamada | +fazerChamada(numeroTelefDestino) | Método | Executa uma ação de realizar chamada. |
    | AparelhoTelefonico | Chamada | +desligarChamada() | Método | Finaliza a chamada telefônica ativa. |
    | - | - | - | - | - |
    | ReprodutorMusical | Controle | -musicaSelecionada | Atributo (String) |Musica selecionada. |
    | ReprodutorMusical | Media | +escolherNusica() | Método | Selecionar uma música para tocar e retorna o id da musica |
    | ReprodutorMusical | Media | +tocarMusica() | Método | Interage com a interface de mídia executando a musica selecionada. |
    | ReprodutorMusical | Media | +pausarMusica() | Método | Interage com a interface de mídia pauzando a musica. |
    | ReprodutorMusical | Media | +pararMusica() | Método | Interage com a interface de mídia parando a musica. |
    | - | - | - | - | - |
    | NavegadorInternet | Controle | -urlSite | Atributo (String) | Site informado pelo usuário. |
    | NavegadorInternet | Controle | -abaAtiva | Atributo (int) | Controle da aba ativa. |
    | NavegadorInternet | Controle | -abaLista | Atributo (List) | Controle da aba ativa. |
    | NavegadorInternet | Digitação | +solicitarSiteUsuario() -> String url | Método | Solicitar para o usuário informar o site da internet |
    | NavegadorInternet | Conexão | -verificarConexaoInternet() | Método | Acessar o site informado pelo usuário. |
    | NavegadorInternet | Navegação | +adicionarNovaAba() | Método | Adicionar nova aba no navegador. |
    | NavegadorInternet | Navegação | +fecharAba() | Método | Fechar uma aba. |
    | NavegadorInternet | Navegação | +selecionarAba() | Método | Seleciona uma aba da lista. |
    | NavegadorInternet | Navegação | +mostrarAbas() | Método | mostra as abas existentes na lista. |
    | NavegadorInternet | Navegação | +exibirPagina(String url) | Método | Acessar a url informada pelo usuário na aba ativa. |
    | NavegadorInternet | Navegação | +atualizarPagina() | Método | Acessar a url informada pelo usuário na aba ativa. |
    | NavegadorInternet | Navegação | +encerrarNavegacao() | Método | Encerrar navegação e fechar o navegador. |
    | - | - | - | - | - |
    | ICameraIntegrada | Controle | -listaImagem | Atributo (List) | Galeria de media. |
    | ICameraIntegrada | Controle | -estadoCamera | Atributo (int) | Estado da câmera: 0-Desligada ou 1-Ligada. |
    | ICameraIntegrada | Controle | -modoCamera | Atributo (int)   | Modo da câmera: 0-Foto (default) ou 1-Video. |
    | ICameraIntegrada | Imagem | +iniciarCamera() | Método | Ligar a câmera e colocar em modo de uso. |
    | ICameraIntegrada | Imagem | +fecharCamera() | Método | Desligar a câmera do modo de uso. |
    | ICameraIntegrada | Imagem | +selecionarModoFoto() | Método | Seleciona o modo para tirar foto. |
    | ICameraIntegrada | Imagem | +selecionarModoVideo() | Método | Seleciona o modo para gravar video. |
    | ICameraIntegrada | Imagem | +tirarFoto() | Método | Registra a foto e coloca na galeria. |
    | ICameraIntegrada | Imagem | +gravarVideo() | Método | Grava o vídeo e coloca na galeria. |
    | ICameraIntegrada | Imagem | -inserirNaGaleria() | Método | Seleciona o número destino na agenda. |
    | ICameraIntegrada | Imagem | -deletarDaGaleria() | Método | Seleciona o número destino na agenda. |
    | ICameraIntegrada | Imagem | +listarGaleria() -> numeroTelefDestino | Método | Seleciona o número destino na agenda. |
    | ICameraIntegrada | Imagem | +mostrarFoto() -> numeroTelefDestino | Método | Seleciona o número destino na agenda. |
    | ICameraIntegrada | Imagem | +exibirVideo() -> numeroTelefDestino | Método | Seleciona o número destino na agenda. |
    | - | - | - | - | - |
    | IGaleria | Controle | -galeriaMedia | Atributo (List) | Galeria de media. |
    | IGaleria | Media | -inserirNaGaleria() | Método | Insere media (foto ou vídeo) na galeria. |
    | IGaleria | Media | -deletarDaGaleria() | Método | Remove media (foto ou vídeo) da galeria. |
    | IGaleria | Media | +listarGaleria() | Método | Lista as medias que estão na galeria. |
    | IGaleria | Media | +exibirMedia() | Método | Orquestrador para exibição de media (Foto ou Video). |
    | IGaleria | Media | -mostrarFoto() | Método | Exibe a media (foto) para o usuário. |
    | IGaleria | Media | -exibirVideo() | Método | Exibe a media (vídeo) para o usuário. |
    | - | - | - | - | - |
    | Media | Controle | -idMedia | Atributo (long) | Id para indexação e localização do item na galeria. |
    | Media | Controle | -tipoMedia | Atributo (int ) | Tipo de Media: 0-Foto ou 1-Video. |
    | Media | Controle | -resolucaoX | Atributo (long) |  Largura da foto ou quadro se vídeo (em pixel). |
    | Media | Controle | -resolucaoY | Atributo (long) |  Altura da foto ou quadro se vídeo (em pixel). |
    | Media | Controle | -videoTempo | Atributo (Time) |  Tempo de gravação do vídeo (Horas:minutos:segundos). |
    | Media | Controle | -videoFPS   | Atributo (int ) |  Quantidade de frames por segundo (se vídeo). |
    | Media | Controle | -videoPalmNtsc | Atributo (int ) |  Padrão de imagem do Video (PAL-M ou NTSC). |
    | Media | Controle | -corpoFotoVideo | Atributo (Hash) |  Hash contendo a media propriamente dita. |

    * O uso dos sinais "+" para público e "-" para privado

    ---

    ## Diagrama de Classe UML

    O diagrama abaixo ilustra como estruturaramos as classes.

    ```mermaid

    classDiagram

        class PhoneMain {
            +IPhone(String modelo)
            +solicitarAcaoUsuario()
        }

        class Bateria {
            -int nivelBateria
            +carregarBateria()
            +getNivelBateria()
        }

        class ISeguranca {
            -int acessoAutorizado
            +solicitarCredencial()
            -validarBiometria()
            -validarFacial()
            -validarSenha()
            -validarGeometria()
        }

        class IConexao {
            -int modoAviao
            -int modoWifi
            -int chipTelefonia
            -int redeTelefonia
            -String redeWifiSelecionada
            +int MODO_AVIAO_LIGADO
            +int MODO_AVIAO_DESLIGADO
            +int MODO_Wifi_LIGADO
            +int MODO_Wifi_DESLIGADO
            +conectarRedeTelefonia()
            +desconectarRedeTelefonia()
            +int getEstadoChipTelefonia()
            +int getEstadoRedeTelefonia()
            +colocarModoAviao()
            +retirarModoAviao()
            +ligarModoWifi()
            +desligarModoWifi()
            +String selecionarConexaoWifi()
            +int getEstadoModoAviao()
            +int getEstadoWifi()
        }

        class Contato {
            -String nomeContato
            -String tipoTelefone
            -String paisTelefone
            -String dddTelefone
            -String numTelefone
        }

        class Agenda {
            -List<Contato> listaContato
            -Contato contatoSelecionado
            +adicionarContato(Contato)
            +removerContato(Contato)
            +Contato selecionarContatoDestino()
            +Contato getContato(String nome)
            +List<Contato> getListaContato()
        }

        class IAparelhoTelefonico {
            -Agenda agenda
            -verificarSinalRede()
            +atenderChamada()
            +fazerChamada(numeroTelefDestino)
            +desligarChamada()
        }

        class IReprodutorMusical {
            -musicaSelecionada
            +escolherNusica()
            +tocarMusica()
            +pausarMusica()
            +pararMusica()
        }

        class INavegadorInternet {
            -String urlSite
            -int abaAtiva
            -List abaLista
            +String solicitarSiteUsuario()
            -int verificarConexaoInternet()
            +int adicionarNovaAba()
            +fecharAba(int idAba)
            +int selecionarAba()
            +getAbas()
            +exibirPagina(String url, int idAba)
            +atualizarPagina(int idAba)
            +encerrarNavegacao()
        }

        class ICameraIntegrada {
            -int estadoCamera
            -int modoCamera
            +iniciarCamera()
            +fecharCamera()
            +selecionarModoFoto()
            +selecionarModoVideo()
            +tirarFoto()
            +gravarVideo()
        }

        class IGaleria {
            -List<Media> galeriaMedia
            +inserirNaGaleria(Media media)
            +deletarDaGaleria(long idMedia)
            +list<Media> listarGaleria()
            +exibirMedia(long idMedia)
            -mostrarFoto(long idMedia)
            -exibirVideo(long idMedia)
        }

        class Media {
            -long idMedia
            -int tipoMedia
            -long resolucaoX
            -long resolucaoY
            -Time videoTempo
            -int videoFPS
            -int videoPalmNtsc
            -Hash corpoFotoVideo
        }

        %% Relacionamentos
        IPhoneControle --> IPhone : herda de
        IPhone --|> ISeguranca
        IPhone --|> IAparelhoTelefonico : implementa
        IPhone --|> IReprodutorMusical : implementa
        IPhone --|> INavegadorInternet : implementa
        IPhone --|> ICameraIntegrada : implementa
        IPhone --|> IReprodutorMedia : implementa
        IPhoneControle --> Bateria: estende
        IAparelhoTelefonico --> Agenda : usa
        Agenda --> Contato : estende
        IReprodutorMusical --> IConexao : extende
        INavegadorInternet --> IConexao : extende
        ICameraIntegrada --> IGaleria : extende
        IGaleria --> Media : usa
        IReprodutorMedia --> IGaleria: implementa
    ```

    */

}
