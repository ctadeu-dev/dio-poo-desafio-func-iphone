package br.com.desafio.phone.service.telefone;

import br.com.desafio.phone.VO.telefone.ContatoVO;
import br.com.desafio.phone.service.controle.Bateria;
import br.com.desafio.phone.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agenda {

    // | Agenda | Controle | -agenda             | Atributo (List)    | Lista de nomes e telefones.                                         |

    // | Agenda | Contato  | +adicionarContato() | Método             | Adiciona um contato na agenda.                                      |
    // | Agenda | Contato  | +removerContato()   | Método             | Remove um contato da agenda.                                        |
    // | Agenda | Contato  | +ligarParaContato   | Método             | Efetua a ligação telefônica para o contato selecionado na agenda.   |

    Scanner scanner = new Scanner(System.in);

    // Agenda de nomes e telefones
    private static HashMap<Long, ContatoVO> agenda = new HashMap<>();

    public void open() {

       System.out.println("Listando contatos da agenda.");

        int acaoAgenda = 0;

        do {
            Bateria.consumirBateria();
            listarAgenda();             // lista os contatos da agenda.

            try {
                System.out.println("""
                    ***** AGENDA *****
                    
                    Opções:
                    |  1 - Adicionar Contato   |
                    |  2 - Remover Contato     |
                    |  3 - Ligar Para Contato  |
                    | 99 - Fechar Agenda       |
                    
                    Informe a opção:
                    """);
                acaoAgenda = scanner.nextInt();

                switch(acaoAgenda) {
                    case 1:
                        adicionarContato();         // Adiciona um contato na agenda.
                        break;
                    case 2:
                        removerContato();           // Remove um contato da agenda.
                        break;
                    case 3:
                        ligarParaContato();        // Seleciona o número do destino na agenda.
                        break;
                    case 99: /* Sair da Agenda */
                        break;
                    default:
                        System.out.println("Opção inválida. Informe corretamente!");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } while(acaoAgenda != 99);

    }

    // Captura facial do usuário para autenticação
    private void adicionarContato() {
        Long ultimoElemento = 0L;

        String nomeContato   = ""; // Nome do contato.
        String paisTelefone  = ""; // País onde o nÚmero de telefone está (ex.: +55 Brasil).
        String dddTelefone   = ""; // DDD referente à região onde a operadora está.
        String numTelefone   = ""; // Numero do telefone.
        Long   tipoTelefone  = 0L; // Tipo do telefone (1-Celular, 2-Residencial, 3-Comercial, 4-Whatsapp, 5-Outro).
        String descTipoOutro = ""; // Descrição de outro tipo de telefone

        try {
            System.out.println("Adicionando contato na agenda.");

            System.out.println("Nome: ");
            nomeContato = scanner.next();

            System.out.println("Número do País: ");
            paisTelefone = scanner.next();

            System.out.println("DDD: ");
            dddTelefone   = scanner.next();     // DDD referente à região onde a operadora está.

            System.out.println("Número do telefone: ");
            numTelefone   = scanner.next();     // Numero do telefone.

            System.out.println("Tipo do telefone (1-Celular, 2-Residencial, 3-Comercial, 4-Whatsapp, 5-Outro): ");
            tipoTelefone  = scanner.nextLong(); // Tipo do telefone (1-Celular, 2-Residencial, 3-Comercial, 4-Whatsapp, 5-Outro).

            if (tipoTelefone.equals(ContatoVO.TIPO_TELEF_OUTRO)) {
                System.out.println("Descrição (outro): ");
                descTipoOutro = scanner.next();     // Descrição de outro tipo de telefone
            }

            System.out.println("Identificando o último contato da agenda.");
            if (agenda.isEmpty()) {

                System.out.println("Último: none");
                System.out.println("Próximo: 1");
                ultimoElemento = 1L;

            } else {

                ultimoElemento = getLastElementKey() + 1;

            }

            System.out.println("Inserindo contato na agenda.");
            ContatoVO novoContato = new ContatoVO(
                    nomeContato
                    , paisTelefone
                    , dddTelefone
                    , numTelefone
                    , tipoTelefone
                    , descTipoOutro);

            novoContato.setIdContato(ultimoElemento);
            agenda.put(novoContato.getIdContato(), novoContato);
            Utils.aguardar(1000);

            System.out.println("Contato inserido na agenda com sucesso.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    // Remove um contato da agenda.
    private void removerContato() {

        Long ultimoElemento = 0L;
        Long idContato = 0L; // Id do item na Agenda.

        try {
            System.out.println("Remover contato da agenda.");
            if (agenda.isEmpty()) {

                System.out.println("Operação não realizada. Não há nenhum contato na agenda!");
                return;

            } else {

                System.out.println("Identificando o último contato da agenda para controle.");
                ultimoElemento = getLastElementKey();

                do {
                    listarAgenda();

                    System.out.println("Para cancelar a exclusão, digite 0 (zero).");
                    System.out.println("Informe o ID do contato a ser removido: ");
                    idContato = scanner.nextLong(); // ID do contato a remover da agenda.

                    if ((idContato < 0) || (idContato > ultimoElemento)) {
                        System.out.println("Operação não realizada. ID informado para exclusão não existe na agenda!");
                        Utils.aguardar(2000L);
                    } else {
                        System.out.println("Removendo contato da agenda.");
                        agenda.remove(idContato);
                        System.out.println("Contato removido da agenda com sucesso.");
                    }

                } while(idContato != 0L);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    private void listarAgenda() {

        System.out.println("Listando elementos da agenda.");
        agenda.forEach((key, value) -> System.out.println(value.toString()));

    }

    private Long getLastElementKey() {

        if (agenda.isEmpty()) {

            return 0L;

        } else {

            Map.Entry<Long, ContatoVO> lastEntry = agenda.entrySet()
                    .stream()
                    .reduce((first, second) -> second) // Reduz até sobrar apenas o último
                    .orElse(null); // Trata mapa vazio
            return lastEntry.getKey();

        }

    }

    private void ligarParaContato() {

        Long ultimoElemento = 0L;
        Long idContato = 0L; // Id do item na Agenda.

        try {

            System.out.println("Ligar para um contato da agenda.");
            if (agenda.isEmpty()) {

                System.out.println("Ligação não realizada. Não há nenhum contato na agenda!");
                Utils.aguardar(5000L);
                return;

            } else {

                System.out.println("Identificando o último contato da agenda para controle.");
                ultimoElemento = getLastElementKey();

                do {
                    listarAgenda();

                    System.out.println("Para cancelar a operação, digite 0 (zero).");
                    System.out.println("Informe o ID do contato para ligação: ");
                    idContato = scanner.nextLong(); // ID do contato a remover da agenda.

                    if ((idContato < 0) || (idContato > ultimoElemento)) {
                        System.out.println("Operação não realizada. ID informado para ligação não existe na agenda!");
                        Utils.aguardar(2000L);
                    } else {
                        ContatoVO contatoLigar = agenda.get(idContato);

                        System.out.println("Realizando a chamada telefônica para o contato: ");
                        System.out.println("Nome: " + contatoLigar.getNomeContato());
                        System.out.println("Número de telefone: " + contatoLigar.getNumeroTelefone());

                        Telefone telefone = new Telefone();
                        telefone.fazerChamada(contatoLigar.getNumeroTelefone().trim());

                        System.out.println("Pressione qualquer tecla para encerrar a chamada!");
                        String tecla = scanner.next();

                        System.out.println("Encerrando a chamada telefônica!");
                        telefone.encerrarChamada();

                        System.out.println("Chamada telefônica finalizada com sucesso!");
                        return;
                    }

                } while(idContato != 0L);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

}
