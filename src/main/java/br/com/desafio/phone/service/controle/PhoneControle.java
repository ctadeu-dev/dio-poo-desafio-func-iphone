package br.com.desafio.phone.service.controle;

public class PhoneControle extends PhoneControleBase {

    // | Classe        | Função   | Elemento                      | Tipo              | Descrição           |
    // |---------------|----------|-------------------------------|-------------------|---------------------|
    // | PhoneControle | Controle | -modelo                       | Atributo (String) | O nome do aparelho (ex: "iPhone 15"). |
    // | PhoneControle | Controle | -estadoAparelho               | Atributo (int)    | O estado interno o aparelho: 0-inativo (default) ou 1-ativo. |
    // | PhoneControle | Controle | -modoExibicao                 | Atributo (int)    | Modo de exibição da tela para o usuário 0-Vertical (default) ou 1-Horizontal. |
    // | PhoneControle | Controle | +ligarAparelho()              | Método            | Altera o estado do aparelho para ativo. |
    // | PhoneControle | Controle | +desligarAparelho()           | Método            | Altera o estado do aparelho para inativo. |
    // | PhoneControle | Controle | +autenticarUsuario()          | Método            | Solicitar validação de permissão de acesso do usuário ao telefone. |
    // | PhoneControle | Controle | -showEstadoAparelho()         | Método            | Apresentar ao usuário o estado de todos os controles do aparelho (bateria, conexão, rede de telefonia, etc.). |
    // | PhoneControle | Controle | -mudarPosicaoAparelho()       | Método            | Mudar posição do aparelho (Vertical ou Horizontal.) |
    // | PhoneControle | Controle | +aumentarVolume()             | Método            | Aumentar o volume de saida de som do aparelho. |
    // | PhoneControle | Controle | +diminuirVolume()             | Método            | diminuir o volume de saida de som do aparelho. |

    public PhoneControle() {
        super();
    }

    public String getEstadoAparelho() {

        if (estadoAparelho == ESTADO_APARELHO_DESLIGADO) {
            return "Off";
        } else if (estadoAparelho == ESTADO_APARELHO_LIGADO) {
            return "On";
        } else {
            return "NoDef";
        }

    }

    public String getModoExibicao() {

        if (modoExibicao == MODO_EXIBICAO_VERTICAL) {
            return "Vertical";
        } else if (modoExibicao == MODO_EXIBICAO_HORIZONTAL) {
            return "Horizontal";
        } else {
            return "NoDef";
        }

    }



}
