package br.com.desafio.phone.principal;

import br.com.desafio.phone.service.camera.CameraIntegrada;
import br.com.desafio.phone.service.conexao.PhoneConexao;
import br.com.desafio.phone.service.controle.Bateria;
import br.com.desafio.phone.service.controle.PhoneControle;
import br.com.desafio.phone.service.galeria.Galeria;

import java.util.Scanner;

public class PhoneMainBoard {

    private PhoneControle phoneControle = new PhoneControle();
    private PhoneConexao  phoneConexao = new PhoneConexao();

    public void showMainBoard() {

        // TODO: Construct Maind Board here
        this.usuarioInteracaoMainBoard();

    }

    private void showGlobalStatusPhone() {
        final String SEPARADOR_INFO = " | ";

        StringBuffer sbStatusPhone = new StringBuffer();

        sbStatusPhone.append("Modelo: ").append(PhoneControle.getModeloPhone());

        sbStatusPhone.append(SEPARADOR_INFO);
        sbStatusPhone.append("Status: ").append(phoneControle.getEstadoAparelho() );

        sbStatusPhone.append(SEPARADOR_INFO);
        sbStatusPhone.append("Posição: ").append(phoneControle.getModoExibicao());

        sbStatusPhone.append(SEPARADOR_INFO);
        sbStatusPhone.append("Bateria: ").append(Bateria.getNivelBateria()).append(" %");

        sbStatusPhone.append(SEPARADOR_INFO);
        sbStatusPhone.append("Modo Avião: ").append(PhoneConexao.getEstadoModoAviao());

        sbStatusPhone.append(SEPARADOR_INFO);
        sbStatusPhone.append("WiFi: ").append(PhoneConexao.getEstadoWifi());
        sbStatusPhone.append(" Rede: ").append(PhoneConexao.getRedeWifiSelecionada());

        sbStatusPhone.append(SEPARADOR_INFO);
        sbStatusPhone.append("Telefonia: Chip: ").append(PhoneConexao.getEstadoChipTelefonia()).append(" Rede: ").append(PhoneConexao.getEstadoRedeTelefonia());

        System.out.println(sbStatusPhone.toString());

    }

    private void usuarioInteracaoMainBoard() {

        try {

            Scanner scanner = new Scanner(System.in);
            int acaoMainBoard = 0;

            do {
                Bateria.consumirBateria();

                this.showGlobalStatusPhone();

                try {
                    System.out.println("""
                        ***** Main Board *****
                        
                        Opções:
                            Funções Básicas:
                            | 1 - Carregar Bateria             | 2 - Inverter Posição Aparelho  |
                            
                            Funções de Rede e Internet:
                            | 11 - Modo Avião (liga / desliga) | 12 - Wifi (liga / desliga)     |
                            | 13 - Selecionar Rede Wifi        | 14 - Navegar Internet          |
                            
                            Funções de Som e Vídeo:
                            | 21 - Câmera                      | 22 - Galeria                   | 
                             
                            Funções de Agenda e Telefone:
                            | 31 - Telefone                    | 32 - Agenda                    | 
                             
                            Funções de Liga/Desliga:
                            | 99 - Desligar Aparelho           |                                |
                             
                        Informe a opção: 
                        """);
                    acaoMainBoard = scanner.nextInt();

                    switch(acaoMainBoard) {
                        case 1:
                            Bateria.carregarBateria();
                            break;
                        case 2:
                            phoneControle.mudarPosicaoAparelho(PhoneControle.MODO_EXIBICAO_INVERTER);
                            break;
                        case 11:
                            phoneConexao.ligarDesligarModoAviao();
                            break;
                        case 12:
                            phoneConexao.ligarDesligarWifi();
                            break;
                        case 13: /* Selecionar Rede Wifi */
                            phoneConexao.selecionarConexaoWifi();
                            break;
                        case 14: /* Navegar Internet */
                            System.out.println("Opção em desenvolvimento. Implementação Futura!");
                            break;
                        case 21: /* Câmera */
                            (new CameraIntegrada()).iniciarCamera();
                            break;
                        case 22: /* Galeria */
                            (new Galeria()).showGaleria();
                            break;
                        case 31: /* Telefone */
                            System.out.println("Opção em desenvolvimento. Implementação Futura!");
                            break;
                        case 32: /* Agenda */
                            System.out.println("Opção em desenvolvimento. Implementação Futura!");
                            break;
                        case 99: /* Desligar Aparelho */
                            phoneControle.desligarAparelho();
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
            phoneControle.desligarAparelho();
            System.out.println("Aparelho desligado...");

        }

    }

}
