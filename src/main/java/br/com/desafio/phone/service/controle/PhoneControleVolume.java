package br.com.desafio.phone.service.controle;

import br.com.desafio.phone.interfaces.IntfcPhoneControleVolume;

abstract class PhoneControleVolume implements IntfcPhoneControleVolume {

    // | Classe        | Função   | Elemento                      | Tipo              | Descrição           |
    // |---------------|----------|-------------------------------|-------------------|---------------------|
    // | PhoneControle | Controle | +aumentarVolume()             | Método            | Aumentar o volume de saida de som do aparelho. |
    // | PhoneControle | Controle | +diminuirVolume()             | Método            | diminuir o volume de saida de som do aparelho. |

    protected static Integer volumeSom = 20;       // | PhoneControle | Controle | Atributo | Controle do volume de som do aparelho (0-100). |

    public void aumentarVolume() {
        volumeSom += 2;
        System.out.println("Aumentando volume para: " + volumeSom.toString() + "%");
    }

    public void diminuirVolume() {
        volumeSom -= 2;
        System.out.println("Diminuindo volume para: " + volumeSom.toString() + "%");
    }

}
