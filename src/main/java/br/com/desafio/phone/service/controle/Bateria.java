package br.com.desafio.phone.service.controle;

import br.com.desafio.phone.utils.Utils;
import lombok.Getter;
import lombok.Setter;

public class Bateria {

    // | Bateria | Controle | -nivelBateria     | Atributo (int) | O estado interno da carga (0 a 100). |
    // | Bateria | Energia  | +carregarBateria() | Método        | Controlar o carregamento de energia da bateria. |
    // | Bateria | Energia  | +getNivelBateria() | Método        | Verificar o nível de energia da bateria. |

    private static Double nivelBateria = 50D;

    public static void carregarBateria() {

        while (nivelBateria < 100) {
            nivelBateria += 5;
            if (nivelBateria > 100) {
                nivelBateria = 100D;
            }
            System.out.println("Carregamento da bateria está em: " + nivelBateria.toString() + "%");
            Utils.aguardar(1000);
        }

    }

    public static boolean consumirBateria() {

        if (getNivelBateria() > 10) {
            nivelBateria -= 0.5;
            return true;
        }
        else {
            System.out.println("Bateria com pouca Carga. Recarregue...");
            Utils.aguardar(1000);
            return false;
        }

    }

    public static int getNivelBateria() {

        return nivelBateria.intValue();

    }

}
