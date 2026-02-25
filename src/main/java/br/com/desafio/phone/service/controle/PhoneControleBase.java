package br.com.desafio.phone.service.controle;

import br.com.desafio.phone.excessao.PhoneInitializeException;
import br.com.desafio.phone.interfaces.IntfcPhoneControle;
import br.com.desafio.phone.service.conexao.PhoneConexao;
import br.com.desafio.phone.service.seguranca.PhoneSecurity;
import br.com.desafio.phone.utils.Utils;

import javax.swing.*;

abstract class PhoneControleBase extends PhoneControleVolume implements IntfcPhoneControle {

    // | Classe        | Função   | Elemento                | Tipo              | Descrição           |
    // |---------------|----------|-------------------------|-------------------|---------------------|
    // | PhoneControle | Controle | -modelo                 | Atributo (String) | O nome do aparelho (ex: "iPhone 15"). |
    // | PhoneControle | Controle | -estadoAparelho         | Atributo (int)    | O estado interno o aparelho: 0-inativo (default) ou 1-ativo. |
    // | PhoneControle | Controle | -modoExibicao           | Atributo (int)    | Modo de exibição da tela para o usuário 0-Vertical (default) ou 1-Horizontal. |
    // | PhoneControle | Controle | +ligarAparelho()        | Método            | Altera o estado do aparelho para ativo. |
    // | PhoneControle | Controle | +desligarAparelho()     | Método            | Altera o estado do aparelho para inativo. |
    // | PhoneControle | Controle | -mudarPosicaoAparelho() | Método            | Detectar se o aparelho está na posição Vertical ou Horizontal. |

    private static String modelo = "iPhone 15"; // | PhoneControle | Controle | Atributo | Nome do aparelho (ex: "iPhone 15"). |
    protected static int estadoAparelho = PhoneControleBase.ESTADO_APARELHO_DESLIGADO ;   // | PhoneControle | Controle | Atributo | Estado interno o aparelho: 0-inativo (default) ou 1-ativo. |
    protected static int modoExibicao = PhoneControleBase.MODO_EXIBICAO_VERTICAL;     // | PhoneControle | Controle | Atributo | Modo de exibição da tela para o usuário 0-Vertical (default) ou 1-Horizontal. |

    public static final int ESTADO_APARELHO_DESLIGADO = 0;   // Estado interno o aparelho: 0-inativo (default)
    public static final int ESTADO_APARELHO_LIGADO = 1;      // Estado interno o aparelho: 1-ativo.

    public static final int MODO_EXIBICAO_VERTICAL = 0;   // Estado interno o aparelho: 0-inativo (default)
    public static final int MODO_EXIBICAO_HORIZONTAL = 1; // Estado interno o aparelho: 1-ativo.
    public static final int MODO_EXIBICAO_INVERTER = 2;   // Estado interno o aparelho: 2-inverter posição

    public static String getModeloPhone() {
        return modelo;
    }

    public PhoneControleBase() {}

    public boolean ligarAparelho() throws PhoneInitializeException {

        if(this.estadoAparelho == ESTADO_APARELHO_LIGADO) {
            int resposta = JOptionPane.showConfirmDialog(null,
                    "Aparelho já ligado. Desligar?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            // Verifica o resultado
            if (resposta == JOptionPane.YES_OPTION) {
                (new PhoneSecurity()).solicitarCredencial();
                if (PhoneSecurity.getAcessoAutorizado() == PhoneSecurity.ACESSO_AUTORIZADO) {
                    desligarAparelho();
                    return false;
                }
            } else {
                System.out.println("Usuário clicou em Não (1) / fechou ou cancelou (2), então não fazer nada");
                System.out.println("O aparelho não pode ser desligado sem as credenciais corretas.");
                return false;
            }
        }

        System.out.println("Ligando aparelho...");

        Bateria.consumirBateria();
        if (Bateria.getNivelBateria() < 10) {
            desligarAparelho();
            return false;
        }

        this.estadoAparelho = ESTADO_APARELHO_LIGADO;
        (new PhoneConexao()).conectarRedeTelefonia();
        mudarPosicaoAparelho(MODO_EXIBICAO_VERTICAL);

        (new PhoneSecurity()).solicitarCredencial();
        if (PhoneSecurity.getAcessoAutorizado() == PhoneSecurity.ACESSO_AUTORIZADO) {
            return true;
        }

        if (estadoAparelho == ESTADO_APARELHO_DESLIGADO) {
            throw new PhoneInitializeException("Ocorreu problema ao ligar o aparelho. Desligando o aparelho!");
        }
        return false;

    }

    public void desligarAparelho() {

        if(this.estadoAparelho == ESTADO_APARELHO_DESLIGADO) {
            int resposta = JOptionPane.showConfirmDialog(null,
                    "Aparelho já está desligado. Ligar?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            // Verifica o resultado
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    ligarAparelho();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Usuário clicou em Não (1) / fechou ou cancelou (2), então não fazer nada");
                System.out.println("O aparelho não pode ser desligado, pois já está desligado.");
            }
        } else {

            System.out.println("Desligando aparelho...");
            Utils.aguardar(2000);
            System.out.println("Phone desligado...");
            System.exit(0);

        }

    }

    public void mudarPosicaoAparelho(int parModoExibicao) {

        if(parModoExibicao == MODO_EXIBICAO_VERTICAL) {             // Fixar posição no que for passado (Vertical)
            this.modoExibicao = MODO_EXIBICAO_VERTICAL;
        } else if (parModoExibicao == MODO_EXIBICAO_HORIZONTAL) {   // Fixar posição no que for passado (horizontal)
            this.modoExibicao = MODO_EXIBICAO_HORIZONTAL;
        } else {  // Inverter posição
            if (this.modoExibicao == MODO_EXIBICAO_VERTICAL) {
                System.out.println("Aparelho em modo Vertical. Girando a tela para o modo Horizontal!");
                this.modoExibicao = MODO_EXIBICAO_HORIZONTAL;
            } else {
                System.out.println("Aparelho em modo Horizontal. Girando a tela para o modo Vertical!");
                this.modoExibicao = MODO_EXIBICAO_VERTICAL;
            }
        }
    }

}
