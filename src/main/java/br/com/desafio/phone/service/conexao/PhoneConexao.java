package br.com.desafio.phone.service.conexao;

import br.com.desafio.phone.service.controle.Bateria;
import br.com.desafio.phone.service.controle.PhoneControle;
import br.com.desafio.phone.utils.Utils;

import java.util.Scanner;

public class PhoneConexao extends PhoneControle {

    // | Classe  | Função   | Elemento                    | Tipo              | Descrição           |
    // |---------|----------|-----------------------------|-------------------|---------------------|
    // | Conexao | Controle | -modoAviao                  | Atributo (int)    | O estado da conexão: 0-Modo Normal (default) ou 1-Modo Avião.                                                 |
    // | Conexao | Controle | -modoWifi                   | Atributo (int)    | O estado do Wifi: 0-Modo Desligado (default) ou 1-Modo Ligado.                                                |
    // | Conexao | Controle | -chipTelefonia              | Atributo (int)    | O estado do Chip de telefonia: 0-Chip Ausente (default) ou 1-Chip Presente.                                   |
    // | Conexao | Controle | -redeTelefonia              | Atributo (int)    | Controla o estado da rede de telefonia: 0-sem sinal (default) ou 1-rede operante.                             |
    // | Conexao | Controle | -redeWifiSelecionada        | Atributo (String) | Controla a rede Wifi selecionada pelo usuário e que está operante.                                            |

    // | Conexao | Controle | +MODO_AVIAO_LIGADO          | Constante (int)   | (1) Constante indicativa de Modo Avião ligado.                                                                |
    // | Conexao | Controle | +MODO_AVIAO_DESLIGADO       | Constante (int)   | (0) Constante indicativa de Modo Avião desligado.                                                             |
    // | Conexao | Controle | +MODO_Wifi_LIGADO           | Constante (int)   | (1) Constante indicativa de Wifi ligado.                                                                      |
    // | Conexao | Controle | +MODO_Wifi_DESLIGADO        | Constante (int)   | (0) Constante indicativa de Wifi desligado.                                                                   |

    // | Conexao | Controle | +conectarRedeTelefonia()    | Método            | Conectar com a rede telefônica                                                                                |
    // | Conexao | Controle | +desconectarRedeTelefonia() | Método            | Desconectar da rede telefônica.                                                                               |
    // | Conexao | Controle | +getEstadoChipTelefonia()   | Método            | Consulta o estado do Chip de telefonia.                                                                       |
    // | Conexao | Controle | +getEstadoRedeTelefonia()   | Método            | Consulta o estado da rede de telefonia.                                                                       |
    // | Conexao | Controle | +colocarModoAviao()         | Método            | Coloca o aparelho em modo avião, desligando todas as conecões, mas mantem o estado atual delas para retorno.  |
    // | Conexao | Controle | +retirarModoAviao()         | Método            | Retira o aparelho do modo avião, retornando as conexões no estado em que estavam.                             |
    // | Conexao | Controle | +ligarModoWifi()            | Método            | Ligar as conexões do modo Wifi.                                                                               |
    // | Conexao | Controle | +desligarModoWifi()         | Método            | Desligar as conexões do modo Wifi.                                                                            |
    // | Conexao | Controle | +selecionarConexaoWifi()    | Método            | Verificar a rede e selecionar a conexão Wifi a ser conectada.                                                 |
    // | Conexao | Controle | +getEstadoModoAviao()       | Método            | Consulta o estado do modo Avião.                                                                              |
    // | Conexao | Controle | +getEstadoWifi()            | Método            | Consulta o estado da conexão Wifi.                                                                            |

    private static int modoAviao       = PhoneConexao.MODO_AVIAO_DESLIGADO; // Estado da conexão: 0-Modo Normal (default) ou 1-Modo Avião.
    private static int modoWifi        = PhoneConexao.MODO_Wifi_DESLIGADO; // Estado do Wifi: 0-Modo Desligado (default) ou 1-Modo Ligado.
    private static int chipTelefonia   = PhoneConexao.CHIP_TELEFONIA_AUSENTE; // Estado do Chip de telefonia: 0-Chip Ausente (default) ou 1-Chip Presente.
    private static int redeTelefonia   = PhoneConexao.REDE_TELEFONIA_SEM_SINAL; // Controla o estado da rede de telefonia: 0-sem sinal (default) ou 1-rede operante.

    private static String redeWifiSelecionada = ""; // Controla a rede Wifi selecionada pelo usuário e que está operante.

    public static final int MODO_AVIAO_LIGADO    = 1; // (1) Constante indicativa de Modo Avião ligado.
    public static final int MODO_AVIAO_DESLIGADO = 0; // (0) Constante indicativa de Modo Avião desligado.

    public static final int MODO_Wifi_LIGADO = 1;     // (1) Constante indicativa de Wifi ligado.
    public static final int MODO_Wifi_DESLIGADO = 0;  // (0) Constante indicativa de Wifi desligado.
    public static final int MODO_Wifi_SEM_SINAL = 2;  // (0) Constante indicativa de Wifi sem sinal.

    public static final int CHIP_TELEFONIA_AUSENTE  = 0; // Estado do Chip de telefonia: 0-Chip Ausente (default)
    public static final int CHIP_TELEFONIA_PRESENTE = 1; // Estado do Chip de telefonia: 1-Chip Presente.

    public static final int REDE_TELEFONIA_SEM_SINAL = 0; // Estado da rede de telefonia: 0-sem sinal (default)
    public static final int REDE_TELEFONIA_OPERANTE  = 1; // Estado da rede de telefonia: 1-rede operante.
    public static final int REDE_TELEFONIA_DESCONEC  = 2; // Estado da rede de telefonia: 2-desconectada


    // Consulta o estado do modo Avião.
    public static String getEstadoModoAviao() {

        if (modoAviao == MODO_AVIAO_DESLIGADO) {
            return "Off";
        } else if (modoAviao == MODO_AVIAO_LIGADO) {
            return "On";
        } else {
            return "NoDef";
        }

    }

    // Consulta o estado da conexão Wifi.
    public static String getEstadoWifi() {

        if (modoWifi == MODO_Wifi_DESLIGADO) {
            return "Off";
        } else if (modoWifi == MODO_Wifi_LIGADO) {
            return "On";
        } else if (modoWifi == MODO_Wifi_SEM_SINAL) {
            return "Sem Sinal";
        } else {
            return "NoDef";
        }

    }

    // Consulta o estado do Chip de telefonia.
    public static String getEstadoChipTelefonia() {

        if (chipTelefonia == CHIP_TELEFONIA_AUSENTE) {
            return "Ausente";
        } else if (chipTelefonia == CHIP_TELEFONIA_PRESENTE) {
            return "Presente";
        } else {
            return "NoDef";
        }

    }

    // Consulta o estado da rede de telefonia.
    public static String getEstadoRedeTelefonia() {

        if (redeTelefonia == REDE_TELEFONIA_SEM_SINAL) {
            return "Sem Sinal";
        } else if (redeTelefonia == REDE_TELEFONIA_OPERANTE) {
            return "Rede OK";
        } else {
            return "Sem Rede";
        }

    }

    public static String getRedeWifiSelecionada() {
        return redeWifiSelecionada;
    }

    public Boolean inserirChipTelefonia() {
        if (chipTelefonia == CHIP_TELEFONIA_PRESENTE) {
            System.out.println("Já há um chip de telefonia presente no aparelho. \nRemova o chip existente antes de inserir outro!");
            return false;
        } else {
            System.out.println("Abrindo o compartimento de alojamento de chip...");
            Utils.aguardar(2000);
            System.out.println("Inserindo chip novo...");
            Utils.aguardar(1000);
            System.out.println("Fechando o compartimento de alojamento de chip...");
            chipTelefonia = PhoneConexao.CHIP_TELEFONIA_PRESENTE;
            redeTelefonia = PhoneConexao.REDE_TELEFONIA_DESCONEC;
            return true;
        }
    }

    public Boolean removerChipTelefonia() {
        if (chipTelefonia == CHIP_TELEFONIA_AUSENTE) {
            System.out.println("Compartimento de alojamento de chip vazio.\nNão há chip para remover!");
            return false;
        } else if(this.estadoAparelho == ESTADO_APARELHO_LIGADO) {
            System.out.println("Aparelho está ligado.\nNecessário desligar antes de abrir o compartimento de alojamento de chip!");
            return false;
        } else {
            this.desconectarRedeTelefonia();
            System.out.println("Abrindo o compartimento de alojamento de chip...");
            Utils.aguardar(2000);
            System.out.println("Removendo chip anterior...");
            Utils.aguardar(1000);
            chipTelefonia = CHIP_TELEFONIA_AUSENTE;
            return true;
        }
    }

    // Conectar com a rede telefônica
    public Boolean conectarRedeTelefonia() {
        if (chipTelefonia == CHIP_TELEFONIA_AUSENTE) {
            System.out.println("Compartimento de alojamento de chip vazio.\nNão é possível realizar a conexão!");
            return false;
        } else {
            System.out.println("Enviando solicitação de conexão para a rede da operadora...");
            Utils.aguardar(3000);
            System.out.println("Obtendo respósta da solicitação de conexão...");
            System.out.println("Obtendo detalhes do plano e conexão...");
            System.out.println("Conectando com a rede da operadora...");
            Utils.aguardar(2000);
            System.out.println("Conexão realizada com sucesso...");
            redeTelefonia = REDE_TELEFONIA_OPERANTE;
            return true;
        }
    }

    // Desconectar da rede telefônica.
    public Boolean desconectarRedeTelefonia() {
        if (chipTelefonia == CHIP_TELEFONIA_AUSENTE) {
            System.out.println("Compartimento de alojamento de chip vazio.\nNão é possível realizar a desconexão!");
            return false;
        } else {
            System.out.println("Enviando solicitação de desconexão para a rede da operadora...");
            Utils.aguardar(3000);
            System.out.println("Obtendo respósta da solicitação de desconexão...");
            System.out.println("Desconectando da rede da operadora...");
            Utils.aguardar(2000);
            System.out.println("Desconexão realizada com sucesso...");
            redeTelefonia = REDE_TELEFONIA_DESCONEC;
            return true;
        }
    }

    public Boolean ligarDesligarModoAviao() {
        if (modoAviao == MODO_AVIAO_DESLIGADO) {
            this.colocarModoAviao();
        } else {
            this.retirarModoAviao();
        }
        return true;
    }

    // Coloca o aparelho em modo avião, desligando todas as conecões, mas mantem o estado atual delas para retorno.
    public Boolean colocarModoAviao() {
        if (modoAviao == MODO_AVIAO_DESLIGADO) {
            modoAviao = MODO_AVIAO_LIGADO;
            System.out.println("Colocando em modo avião...");
            Utils.aguardar(2000);
        }
        return true;
    }

    // Retira o aparelho do modo avião, retornando as conexões no estado em que estavam.
    public Boolean retirarModoAviao() {
        if (modoAviao == MODO_AVIAO_LIGADO) {
            modoAviao = MODO_AVIAO_DESLIGADO;
            System.out.println("Retirando do modo avião...");
            Utils.aguardar(2000);
        }
        return true;
    }

    public Boolean ligarDesligarWifi() {
        if (modoWifi == MODO_Wifi_DESLIGADO) {
            this.ligarModoWifi();
        } else {
            this.desligarModoWifi();
        }
        return true;
    }

    // Ligar as conexões do modo Wifi.
    public Boolean ligarModoWifi() {
        if (modoWifi == MODO_Wifi_DESLIGADO) {
            if(redeWifiSelecionada.trim().isEmpty()) {
                selecionarConexaoWifi();
            }
            modoWifi = MODO_Wifi_LIGADO;
            System.out.println("Ligando Wifi...");
            Utils.aguardar(2000);
            System.out.println("Wifi conectado!");
        }
        return true;
    }

    // Desligar as conexões do modo Wifi.
    public Boolean desligarModoWifi() {
        if (modoWifi == MODO_Wifi_LIGADO) {
            modoWifi = MODO_Wifi_DESLIGADO;
            System.out.println("Desligando Wifi...");
            Utils.aguardar(2000);
            System.out.println("Wifi desligado!");
        }
        return false;
    }

    // Verificar a rede e selecionar a conexão Wifi a ser conectada.
    public Boolean selecionarConexaoWifi() {
        Boolean valorRetorno = false;

        try {

            Scanner scanner = new Scanner(System.in);
            int acaoSelWifi = 0;

            do {
                Bateria.consumirBateria();

                try {
                    System.out.println("""
                        ***** Selecionar Wifi *****
                        
                        Opções:
                            WIFI Próximas:
                            | 1 - WIFI Rede 1 |
                            | 2 - WIFI Rede 2 |
                            | 3 - WIFI Rede 3 |
                            | 4 - WIFI Rede 4 |
                            | 5 - WIFI Rede 5 |
                            | 6 - WIFI Rede 6 |
                            | 7 - WIFI Rede 7 |
                            | 8 - WIFI Rede 8 |
                            | 9 - WIFI Rede 9 |
                            | 99 - Cancelar a seleção |
                        
                        Informe a opção:
                        """);
                    acaoSelWifi = scanner.nextInt();

                    switch(acaoSelWifi) {
                        case 1:
                            redeWifiSelecionada = "WIFI Rede 1";
                            break;
                        case 2:
                            redeWifiSelecionada = "WIFI Rede 2";
                            break;
                        case 3:
                            redeWifiSelecionada = "WIFI Rede 3";
                            break;
                        case 4:
                            redeWifiSelecionada = "WIFI Rede 4";
                            break;
                        case 5:
                            redeWifiSelecionada = "WIFI Rede 5";
                            break;
                        case 6:
                            redeWifiSelecionada = "WIFI Rede 6";
                            break;
                        case 7:
                            redeWifiSelecionada = "WIFI Rede 7";
                            break;
                        case 8:
                            redeWifiSelecionada = "WIFI Rede 8";
                            break;
                        case 9:
                            redeWifiSelecionada = "WIFI Rede 9";
                            break;
                        case 99:
                            break;
                        default:
                            System.out.println("Opção inválida. Informe corretamente!");
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } while(acaoSelWifi != 99);


            if(!redeWifiSelecionada.trim().isEmpty()) {
                valorRetorno = true;
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            desligarAparelho();
            System.out.println("Aparelho desligado...");

        }

        return valorRetorno;
    }


    public Boolean conexaoTelefoniaOk() {
        Boolean valorRetorno = true;

        if (modoAviao      == MODO_AVIAO_LIGADO) {
            System.out.println("Modo avião ligado. Sem conexão.");
            valorRetorno = false;
        }

        if (chipTelefonia  == CHIP_TELEFONIA_AUSENTE) {
            System.out.println("Chip de telefonia ausente. Sem conexão.");
            valorRetorno = false;
        }

        if (redeTelefonia  == REDE_TELEFONIA_DESCONEC) {
            System.out.println("Rede de telefonia desconectada. Sem conexão.");
            valorRetorno = false;
        }

        if (redeTelefonia  == REDE_TELEFONIA_SEM_SINAL) {
            System.out.println("Rede de telefonia sem sinal.");
            valorRetorno = false;
        }

        if (estadoAparelho == ESTADO_APARELHO_DESLIGADO) {
            System.out.println("Aparelho desligado.");
            valorRetorno = false;
        }

        return valorRetorno;
    }

    public Boolean conexaoRedeOk() {
        Boolean valorRetorno = true;

        if (modoAviao      == MODO_AVIAO_LIGADO) {
            System.out.println("Modo avião ligado. Sem conexão.");
            valorRetorno = false;
        }

        if (chipTelefonia  == CHIP_TELEFONIA_AUSENTE) {
            System.out.println("Chip de telefonia ausente. Sem conexão.");
            valorRetorno = false;
        }

        if (redeTelefonia  == REDE_TELEFONIA_DESCONEC) {
            System.out.println("Rede de telefonia desconectada. Sem conexão.");
            valorRetorno = false;
        }

        if (redeTelefonia  == REDE_TELEFONIA_SEM_SINAL) {
            System.out.println("Rede de telefonia sem sinal.");
            valorRetorno = false;
        }

        if (estadoAparelho == ESTADO_APARELHO_DESLIGADO) {
            System.out.println("Aparelho desligado.");
            valorRetorno = false;
        }

        if(redeWifiSelecionada.trim().isEmpty()) {
            System.out.println("Rede Wifi inexistente ou não selecionada.");
            valorRetorno = false;
        }

        if (modoWifi == MODO_Wifi_DESLIGADO) {
            System.out.println("Rede Wifi desconectada.");
            valorRetorno = false;
        }

        if (modoWifi == MODO_Wifi_SEM_SINAL) {
            System.out.println("Rede Wifi sem sinal.");
            valorRetorno = false;
        }

        return valorRetorno;
    }

}
