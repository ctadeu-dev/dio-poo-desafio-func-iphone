# dio-poo-desafio-func-iphone
Desafio de Projeto - Avaliação do conteúdo técnico.
Explorando POO - Simulando funções do iPhone.

# Diagrama de Classe UML: iPhone
O diagrama abaixo ilustra como estruturaramos as classes.

| Classe    | Função   | Elemento | Tipo | Descrição |
|-----------|----------|--------------------|-----------|---------------------|
| PhoneControle | Controle | -modelo | Atributo (String) | O nome do aparelho (ex: "iPhone 15"). |
| PhoneControle | Controle | -estadoAparelho | Atributo (int) | O estado interno o aparelho: 0-inativo (default) ou 1-ativo. |
| PhoneControle | Controle | +ligarAparelho() | Método | Altera o estado do aparelho para ativo. |
| PhoneControle | Controle | +desligarAparelho() | Método | Altera o estado do aparelho para inativo. |
| PhoneControle | Controle | +autenticarUsuario() | Método | Solicitar validação de permissão de acesso do usuário ao telefone. |
| PhoneControle | Controle | -showEstadoAparelho() | Método | Apresentar ao usuário o estado de todos os controles do aparelho (bateria, conexão, rede de telefonia, etc.). |
| PhoneControle | Controle | +solicitarAcaoUsuario() | Método | Disponibiliza opções para usuário tomar ação do que quer fazer. |
| PhoneControle | Controle | +aumentarVolume() | Método | Aumentar o volume de saida de som do aparelho. |
| PhoneControle | Controle | +diminuirVolume() | Método | diminuir o volume de saida de som do aparelho. |
| - | - | - | - | - |
| Bateria | Controle | -nivelBateria | Atributo (int) | O estado interno da carga (0 a 100). |
| Bateria | Energia | +carregarBateria() | Método | Controlar o carregamento de energia da bateria. |
| Bateria | Energia | +consultarNivelBateria() | Método | Verificar o nível de energia da bateria. |
| - | - | - | - | - |
| Seguranca | Controle | -acessoAutorizado | Atributo (int) | O estado interno o aparelho: 0-Não autorizado (default) ou 1-Acesso autorizado. |
| Seguranca | Acesso | +solicitarCredencial() | Método | Solicitar ao usuário as credenciais de acesso. |
| Seguranca | Acesso | -validarBiometria() | Método | Altera o estado do aparelho para inativo. |
| Seguranca | Acesso | -validarFacial() | Método | Altera o estado do aparelho para inativo. |
| Seguranca | Acesso | -validarSenha() | Método | Altera o estado do aparelho para inativo. |
| Seguranca | Acesso | -validarGeometria() | Método | Altera o estado do aparelho para inativo. |
| - | - | - | - | - |
| Conexao | Controle | -modoAviao | Atributo (int) | O estado da conexão: 0-Modo Normal (default) ou 1-Modo Avião. |
| Conexao | Controle | -modoWifi | Atributo (int) | O estado do Wifi: 0-Modo Desligado (default) ou 1-Modo Ligado. |
| Conexao | Controle | -chipTelefonia | Atributo (int) | O estado do Chip de telefonia: 0-Chip Ausente (default) ou 1-Chip Presente. |
| Conexao | Controle | -redeTelefonia | Atributo (int) | Controla o estado da rede de telefonia: 0-sem sinal (default) ou 1-rede operante. |
| Conexao | Controle | +MODO_AVIAO_LIGADO | Constante (int) | (1) Constante indicativa de Modo Avião ligado. |
| Conexao | Controle | +MODO_AVIAO_DESLIGADO | Constante (int) | (0) Constante indicativa de Modo Avião desligado. |
| Conexao | Controle | +MODO_Wifi_LIGADO | Constante (int) | (1) Constante indicativa de Wifi ligado. |
| Conexao | Controle | +MODO_Wifi_DESLIGADO | Constante (int) | (0) Constante indicativa de Wifi desligado. |
| Conexao | Controle | +conectarRedeTelefonia() | Método | Conectar com a rede telefônica |
| Conexao | Controle | +desconectarRedeTelefonia() | Método | Desconectar da rede telefônica. |
| Conexao | Controle | +consultarEstadoChipTelefonia() | Método | Consulta o estado do Chip de telefonia. |
| Conexao | Controle | +consultarEstadoRedeTelefonia() | Método | Consulta o estado da rede de telefonia. |
| Conexao | Controle | +colocarModoAviao() | Método | Coloca o aparelho em modo avião, desligando todas as conecões, mas mantem o estado atual delas para retorno. |
| Conexao | Controle | +retirarModoAviao() | Método | Retira o aparelho do modo avião, retornando as conexões no estado em que estavam. |
| Conexao | Controle | +ligarModoWifi() | Método | Ligar as conexões do modo Wifi. |
| Conexao | Controle | +desligarModoWifi() | Método | Desligar as conexões do modo Wifi. |
| Conexao | Controle | +selecionarConexaoWifi() | Método | Verificar a rede e selecionar a conexão Wifi a ser conectada. |
| Conexao | Controle | +consultarModoAviao() | Método | Consulta o estado do modo Avião. |
| Conexao | Controle | +consultarEstadoWifi() | Método | Consulta o estado da conexão Wifi. |
| - | - | - | - | - |
| Agenda | Controle | -listaContato | Atributo (List) | Musica selecionada. |
| Agenda | Contato | +adicionarContato() | Método | Seleciona o número destino na agenda. |
| Agenda | Contato | +removerContato() | Método | Seleciona o número destino na agenda. |
| Agenda | Contato | +consultarContato() | Método | Seleciona o número destino na agenda. |
| Agenda | Contato | +consultarListaContato() | Método | Seleciona o número destino na agenda. |
| Agenda | Contato | +selecionarContatoDestino() -> numeroTelefDestino | Método | Seleciona o número destino na agenda. |
| - | - | - | - | - |
| Telefone | Chamada | -verificarSinalChamada() | Método | Verifica o estado da rede de telefonia ao realizar chamada. |
| Telefone | Chamada | +atenderChamada() | Método | Executa uma ação de atendimento de chamada telafônica. |
| Telefone | Chamada | +fazerChamada(numeroTelefDestino) | Método | Executa uma ação baseada em um parâmetro. |
| Telefone | Chamada | +desligarChamada() | Método | Finaliza a ação de chamada telafônica ativa. |
| - | - | - | - | - |
| Musica | Controle | -musicaSelecionada | Atributo (String) |Musica selecionada. |
| Musica | Media | +escolherNusica() | Método | Selecionar uma música para tocar e retorna o id da musica |
| Musica | Media | +tocarMusica() | Método | Interage com a interface de mídia executando a musica selecionada. |
| Musica | Media | +pausarMusica() | Método | Interage com a interface de mídia executando a musica selecionada. |
| Musica | Media | +pararMusica() | Método | Interage com a interface de mídia executando a musica selecionada. |
| - | - | - | - | - |
| Internet | Controle | -urlSite | Atributo (String) | Site informado pelo usuário. |
| Internet | Controle | -abaAtiva | Atributo (int) | Controle da aba ativa. |
| Internet | Controle | -abaLista | Atributo (List) | Controle da aba ativa. |
| Internet | Digitação | +solicitarSiteUsuario() -> String url | Método | Solicitar para o usuário informar o site da internet |
| Internet | Conexão | -verificarConexaoInternet() | Método | Acessar o site informado pelo usuário. |
| Internet | Navegação | +adicionarNovaAba() | Método | Adicionar nova aba no navegador. |
| Internet | Navegação | +fecharAba() | Método | Fechar uma aba. |
| Internet | Navegação | +selecionarAba() | Método | Seleciona uma aba da lista. |
| Internet | Navegação | +mostrarAbas() | Método | mostra as abas existentes na lista. |
| Internet | Navegação | +exibirPagina(String url) | Método | Acessar a url informada pelo usuário na aba ativa. |
| Internet | Navegação | +atualizarPagina() | Método | Acessar a url informada pelo usuário na aba ativa. |
| Internet | Navegação | +encerrarNavegacao() | Método | Encerrar navegação e fechar o navegador. |

## O uso dos sinais "+" para público e "-" para privado.

# Aqui está o diagrama consolidado com as Interfaces, a Classe Principal e a Herança:

```mermaid

classDiagram
    class DataProcessor {
        -data: DataFrame
        -config: Dict
        +load_data(path: str)
        +clean_data()
        +transform_data()
        +save_results(path: str)
    }
    
    class Visualizer {
        -processor: DataProcessor
        +create_plot(type: str)
        +save_figure(path: str)
        +show_dashboard()
    }
    
    class Model {
        <<abstract>>
        -parameters: Dict
        +train(data: DataFrame)
        +predict(data: DataFrame)
        +evaluate()
    }
    
    class RandomForest {
        -n_trees: int
        -max_depth: int
        +feature_importance()
    }
    
    DataProcessor <|-- Visualizer : usa
    Model <|-- RandomForest : herda
    DataProcessor <|-- Model : processa dados para
```

```mermaid
classDiagram
    class IPhone {
        -String modelo
        -int nivelBateria
        +IPhone(String modelo)
        +getNivelBateria() int
    }

```


