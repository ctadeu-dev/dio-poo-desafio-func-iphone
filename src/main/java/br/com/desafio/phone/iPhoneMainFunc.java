import excessao.ParametrosInvalidosException;
import java.util.Scanner;

public class iPhoneMainFunc {
    public static void main(String[] args) {
        
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();

        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {
            //chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);

        }catch (ParametrosInvalidosException exception) {
            //imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println(exception.getMessage());
        }
    }

    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if(parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro!");
        }

        int contagem = parametroDois - parametroUm;

        // Realizar o for para imprimir os números com base na variável contagem
        for (int idxContagem = 1; idxContagem <= contagem; idxContagem++) {
            System.out.println("Realizando a impressão do número " + String.valueOf(idxContagem));
        }
    }

/*


## Lista de classes, interfaces, atributos e métodos

| Classe    | Função   | Elemento | Tipo | Descrição |
|-----------|----------|--------------------|-----------|---------------------|
| PhoneControle | Controle | -modelo | Atributo (String) | O nome do aparelho (ex: "iPhone 15"). |
| PhoneControle | Controle | -estadoAparelho | Atributo (int) | O estado interno o aparelho: 0-inativo (default) ou 1-ativo. |
| PhoneControle | Controle | -modoExibicao | Atributo (int) | Modo de exibição da tela para o usuário 0-Vertical (default) ou 1-Horizontal. |
| PhoneControle | Controle | +ligarAparelho() | Método | Altera o estado do aparelho para ativo. |
| PhoneControle | Controle | +desligarAparelho() | Método | Altera o estado do aparelho para inativo. |
| PhoneControle | Controle | +autenticarUsuario() | Método | Solicitar validação de permissão de acesso do usuário ao telefone. |
| PhoneControle | Controle | -showEstadoAparelho() | Método | Apresentar ao usuário o estado de todos os controles do aparelho (bateria, conexão, rede de telefonia, etc.). |
| PhoneControle | Controle | -identificarPosicaoAparelho() | Método | Detectar se o aparelho está na posição Vertical ou Horizontal. |
| PhoneControle | Controle | +aumentarVolume() | Método | Aumentar o volume de saida de som do aparelho. |
| PhoneControle | Controle | +diminuirVolume() | Método | diminuir o volume de saida de som do aparelho. |
| - | - | - | - | - |
| IPhone | Interface | +solicitarAcaoUsuario() | Método | Disponibiliza opções para usuário tomar ação do que quer fazer. |
| - | - | - | - | - |
| Bateria | Controle | -nivelBateria | Atributo (int) | O estado interno da carga (0 a 100). |
| Bateria | Energia | +carregarBateria() | Método | Controlar o carregamento de energia da bateria. |
| Bateria | Energia | +getNivelBateria() | Método | Verificar o nível de energia da bateria. |
| - | - | - | - | - |
| Seguranca | Controle | -acessoAutorizado | Atributo (int) | Estado da autorização de acesso: 0-Não autorizado (default) ou 1-Acesso autorizado. |
| Seguranca | Acesso | +solicitarCredencial() | Método | Solicitar ao usuário as credenciais de acesso. |
| Seguranca | Acesso | -validarBiometria() | Método | Validar credencial por biometria. |
| Seguranca | Acesso | -validarFacial() | Método | Validar credencial por reconhecimento facial. |
| Seguranca | Acesso | -validarSenha() | Método | Validar credencial por usuário e senha. |
| Seguranca | Acesso | -validarGeometria() | Método | Validar credencial por desenho geométrico. |
| - | - | - | - | - |
| Conexao | Controle | -modoAviao | Atributo (int) | O estado da conexão: 0-Modo Normal (default) ou 1-Modo Avião. |
| Conexao | Controle | -modoWifi | Atributo (int) | O estado do Wifi: 0-Modo Desligado (default) ou 1-Modo Ligado. |
| Conexao | Controle | -chipTelefonia | Atributo (int) | O estado do Chip de telefonia: 0-Chip Ausente (default) ou 1-Chip Presente. |
| Conexao | Controle | -redeTelefonia | Atributo (int) | Controla o estado da rede de telefonia: 0-sem sinal (default) ou 1-rede operante. |
| Conexao | Controle | -redeWifiSelecionada | Atributo (String) | Controla a rede Wifi selecionada pelo usuário e que está operante. |
| Conexao | Controle | +MODO_AVIAO_LIGADO | Constante (int) | (1) Constante indicativa de Modo Avião ligado. |
| Conexao | Controle | +MODO_AVIAO_DESLIGADO | Constante (int) | (0) Constante indicativa de Modo Avião desligado. |
| Conexao | Controle | +MODO_Wifi_LIGADO | Constante (int) | (1) Constante indicativa de Wifi ligado. |
| Conexao | Controle | +MODO_Wifi_DESLIGADO | Constante (int) | (0) Constante indicativa de Wifi desligado. |
| Conexao | Controle | +conectarRedeTelefonia() | Método | Conectar com a rede telefônica |
| Conexao | Controle | +desconectarRedeTelefonia() | Método | Desconectar da rede telefônica. |
| Conexao | Controle | +getEstadoChipTelefonia() | Método | Consulta o estado do Chip de telefonia. |
| Conexao | Controle | +getEstadoRedeTelefonia() | Método | Consulta o estado da rede de telefonia. |
| Conexao | Controle | +colocarModoAviao() | Método | Coloca o aparelho em modo avião, desligando todas as conecões, mas mantem o estado atual delas para retorno. |
| Conexao | Controle | +retirarModoAviao() | Método | Retira o aparelho do modo avião, retornando as conexões no estado em que estavam. |
| Conexao | Controle | +ligarModoWifi() | Método | Ligar as conexões do modo Wifi. |
| Conexao | Controle | +desligarModoWifi() | Método | Desligar as conexões do modo Wifi. |
| Conexao | Controle | +selecionarConexaoWifi() | Método | Verificar a rede e selecionar a conexão Wifi a ser conectada. |
| Conexao | Controle | +getEstadoModoAviao() | Método | Consulta o estado do modo Avião. |
| Conexao | Controle | +getEstadoWifi() | Método | Consulta o estado da conexão Wifi. |
| - | - | - | - | - |
| Contato | Informação | -nomeContato | Atributo (String) | Nome do contato. |
| Contato | Informação | -tipoTelefone | Atributo (String) | Tipo do contato (Residencial, Comercial, Whatsapp, etc). |
| Contato | Informação | -paisTelefone | Atributo (String) | País onde o numero de telefone está (ex.: +55 Brasil). |
| Contato | Informação | -dddTelefone | Atributo (String) | DDD referente à região onde a operadora está. |
| Contato | Informação | -numTelefone | Atributo (String) | Numero do telafone. |
| - | - | - | - | - |
| Agenda | Controle | -listaContato | Atributo (List) | Lista de nomes e telefones. |
| Agenda | Controle | -contatoSelecionado | Atributo (Contato) | Contato que foi selecionado pelo usuário. |
| Agenda | Contato  | +adicionarContato() | Método | Adiciona um contato na agenda. |
| Agenda | Contato  | +removerContato() | Método | Remove um contato da agenda. |
| Agenda | Contato  | +selecionarContatoDestino() | Método | Seleciona o número do destino na agenda. |
| Agenda | Contato  | +getContato() | Método | retorna o contato selecionado pelo usuario. |
| Agenda | Contato  | +getListaContato() | Método | Seleciona o número destino na agenda. |
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

    class IPhone {
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
        +atenderChamada() | Método | Executa uma ação de atendimento de chamada telafônica. |
        +fazerChamada(numeroTelefDestino) | Método | Executa uma ação baseada em um parâmetro. |
        +desligarChamada() | Método | Finaliza a ação de chamada telafônica ativa. |
    }

    class IReprodutorMusical {
        -musicaSelecionada | Atributo (String) |Musica selecionada. |
        +escolherNusica() | Método | Selecionar uma música para tocar e retorna o id da musica |
        +tocarMusica() | Método | Interage com a interface de mídia executando a musica selecionada. |
        +pausarMusica() | Método | Interage com a interface de mídia executando a musica selecionada. |
        +pararMusica() | Método | Interage com a interface de mídia executando a musica selecionada. |
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