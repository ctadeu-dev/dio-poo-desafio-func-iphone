package br.com.desafio.phone.service.telefone;

import br.com.desafio.phone.service.conexao.PhoneConexao;
import br.com.desafio.phone.service.controle.Bateria;
import br.com.desafio.phone.utils.Utils;

import java.util.Scanner;

public class Telefone {

    // | Classe   | Função   | Elemento                          | Tipo   | Descrição                                                   |
    // |----------|----------|-----------------------------------|--------|-------------------------------------------------------------|
    // | Telefone | Chamada  | -verificarSinalRede()             | Método | Verifica o estado da rede de telefonia ao realizar chamada. |
    // | Telefone | Chamada  | +atenderChamada()                 | Método | Executa uma ação de atendimento de chamada telafônica.      |
    // | Telefone | Chamada  | +fazerChamada(numeroTelefDestino) | Método | Executa uma ação de realizar chamada.                       |
    // | Telefone | Chamada  | +desligarChamada()                | Método | Finaliza a chamada telefônica ativa.                        |


    Scanner scanner = new Scanner(System.in);

    private static boolean telefoneEmUso = false; // Estado de uso da linha telefônica (false-Sem uso ou true-em uso (recebendo ou realizando chamada)

    public void open() {

        System.out.println("Listando contatos da agenda.");

        int acaoTelefone = 0;

        do {
            Bateria.consumirBateria();

            try {
                System.out.println("""
                    ***** TELEFONE *****
                    
                    Opções:
                    |  1 - Fazer Chamada    |
                    |  2 - Receber Chamada  |
                    |  3 - Encerrar Chamada |
                    | 99 - Fechar Telefone  |
                    
                    Informe a opção:
                    """);
                acaoTelefone = scanner.nextInt();

                switch(acaoTelefone) {
                    case 1:
                        fazerChamada(""); // Realizar uma chamada telefônica
                        break;
                    case 2:
                        atenderChamada();         // Atender uma ligação recebida
                        break;
                    case 3:
                        encerrarChamada();        // Encerra uma chamada
                        break;
                    case 99: /* Fechar Telefone */
                        break;
                    default:
                        System.out.println("Opção inválida. Informe corretamente!");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } while(acaoTelefone != 99);

    }

    private void atenderChamada() {

        System.out.println("Atendendo chamada!");
        telefoneEmUso = true;

        System.out.println("Falando ao telefone!");

    }

    public void fazerChamada(String numeroTelefDestino) {
        if (telefoneEmUso) {
            System.out.println("Telefone em uso. Não é possível realizar ou receber outra chamada!");

        } else {

            if (numeroTelefDestino.trim().isEmpty()) {
                System.out.println("Informe o número de telefone: ");
                numeroTelefDestino = scanner.next();
            }

            if (isConexaoOk()) {
                System.out.println("chamando o número informado!");
                telefoneEmUso = true;

                System.out.println("Falando ao telefone!");
            }

        }

    }

    public Boolean isConexaoOk() {

        return ((new PhoneConexao()).conexaoTelefoniaOk());

    }

    public void encerrarChamada() {
        System.out.println("Encerrando chamada!");
        telefoneEmUso = false;
    }

}
