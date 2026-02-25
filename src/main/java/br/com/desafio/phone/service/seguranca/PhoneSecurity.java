package br.com.desafio.phone.service.seguranca;

import br.com.desafio.phone.service.controle.PhoneControle;
import br.com.desafio.phone.utils.Utils;

import java.util.Scanner;

public class PhoneSecurity {

    // | Classe     | Função   | Elemento               | Tipo           | Descrição           |
    // |------------|----------|------------------------|----------------|---------------------|
    // | Seguranca  | Controle | -acessoAutorizado      | Atributo (int) | Estado da autorização de acesso: 0-Não autorizado (default) ou 1-Acesso autorizado. |
    // | Seguranca  | Acesso   | +solicitarCredencial() | Método         | Solicitar ao usuário as credenciais de acesso.                                      |
    // | Seguranca  | Acesso   | -validarBiometria()    | Método         | Validar credencial por biometria.                                                   |
    // | Seguranca  | Acesso   | -validarFacial()       | Método         | Validar credencial por reconhecimento facial.                                       |
    // | Seguranca  | Acesso   | -validarSenha()        | Método         | Validar credencial por usuário e senha.                                             |
    // | Seguranca  | Acesso   | -validarGeometria()    | Método         | Validar credencial por desenho geométrico.                                          |

    public static final int ACESSO_NEGADO = 0;
    public static final int ACESSO_AUTORIZADO = 1;

    private static int acessoAutorizado = PhoneSecurity.ACESSO_NEGADO;   // -acessoAutorizado             | Atributo (int)    | Estado da autorização de acesso: 0-Não autorizado (default) ou 1-Acesso autorizado.

    PhoneControle phoneControle = new PhoneControle();

    public PhoneSecurity() {
        this.acessoAutorizado = PhoneSecurity.ACESSO_NEGADO;
    }

    public void solicitarCredencial() {
        int qtdTentativas = 0;
        int ctrlTimeWait = 2;

        System.out.println("Autenticando usuário...");

        try {

            Scanner scanner = new Scanner(System.in);
            int acaoAutentic = 0;

            do {

                try {
                    System.out.println("Autenticar Por: \n 1 - Usuário e senha \n 2 - Desenho Geométrico \n 3 - Biometria \n 4 - Reconhecimento Facial \n 9 - Encerrar Autenticação \n Informe a opção: ");
                    acaoAutentic = scanner.nextInt();

                    switch (acaoAutentic) {
                        case 1:
                            qtdTentativas = 0;

                            while (qtdTentativas < 4) {
                                this.validarUsuarioSenha();
                                if (this.acessoAutorizado == PhoneSecurity.ACESSO_NEGADO) {
                                    qtdTentativas++;
                                } else {
                                    break;
                                }
                            }
                            if (this.acessoAutorizado == PhoneSecurity.ACESSO_NEGADO) {
                                ctrlTimeWait += 2;
                                System.out.println((new StringBuilder("Credenciais inválidas após 3 tentativas. Novas tentativas após ")).append(ctrlTimeWait).append(" minutos!").toString());
                                Utils.aguardar((long) ctrlTimeWait * 1000);
                            }
                            break;
                        case 2:
                            this.validarGeometria();
                            ;

                            qtdTentativas = 0;
                            while (qtdTentativas < 4) {
                                this.validarUsuarioSenha();
                                if (this.acessoAutorizado == PhoneSecurity.ACESSO_NEGADO) {
                                    qtdTentativas++;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case 3:
                            this.validarBiometria();
                            ;

                            qtdTentativas = 0;
                            while (qtdTentativas < 4) {
                                this.validarUsuarioSenha();
                                if (this.acessoAutorizado == PhoneSecurity.ACESSO_NEGADO) {
                                    qtdTentativas++;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case 4:
                            this.validarFacial();
                            ;

                            qtdTentativas = 0;
                            while (qtdTentativas < 4) {
                                this.validarUsuarioSenha();
                                if (this.acessoAutorizado == PhoneSecurity.ACESSO_NEGADO) {
                                    qtdTentativas++;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Opção inválida. Informe novamente!");
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (this.acessoAutorizado == PhoneSecurity.ACESSO_AUTORIZADO) {
                    break;
                }

            } while (acaoAutentic != 9);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Erro na autenticando do usuário. Usuário não autenticado. Acesso negado!");
            this.acessoAutorizado = PhoneSecurity.ACESSO_NEGADO;

        }

    }

    // Validar credencial por usuário e senha.
    private void validarUsuarioSenha() {
        System.out.println("Autenticando usuário...");

        Scanner scanner = new Scanner(System.in);
        String lgnAuth = "";
        String pwdAuth = "";

        try {
            System.out.println("Autenticação do Usuário. Informe as credenciais de acesso: ");
            System.out.println("Informe o usuário: ");
            lgnAuth = scanner.next();
            System.out.println("Informe a senha: ");
            pwdAuth = scanner.next();

            if (lgnAuth.equalsIgnoreCase("12345") && pwdAuth.equalsIgnoreCase("12345")) {
                System.out.println("Usuário autenticado. Acesso permitido! ");
                this.acessoAutorizado = PhoneSecurity.ACESSO_AUTORIZADO;
            } else {
                this.acessoAutorizado = PhoneSecurity.ACESSO_NEGADO;
                System.out.println("Usuário ou senha inválidos. Acesso negado! ");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Erro na autenticando do usuário. Usuário não autenticado. Acesso negado!");
            this.acessoAutorizado = PhoneSecurity.ACESSO_NEGADO;
        }

    }

    // Validar credencial por desenho geométrico.
    private void validarGeometria() {
        System.out.println("Autenticando usuário por Geometria...");

        System.out.println("Captando padrão geométrico.");
        System.out.println("Validando com o padrão geométrico definido pelo usuário.");

        this.acessoAutorizado = PhoneSecurity.ACESSO_AUTORIZADO;

        System.out.println("Padrão geométrico validado. Acesso permitido! ");

    }


    // Validar credencial por biometria.
    private void validarBiometria() {
        System.out.println("Autenticando usuário por Biometria...");

        System.out.println("Captando biometria do usuário.");
        System.out.println("Validando com a biometria definida pelo usuário.");

        this.acessoAutorizado = PhoneSecurity.ACESSO_AUTORIZADO;

        System.out.println("Biometria validada. Acesso permitido! ");

    }


    // Validar credencial por reconhecimento facial.
    private void validarFacial() {
        System.out.println("Autenticando usuário por Reconhecimento Facial...");

        // Ativar a câmera

        System.out.println("Captando foto de autenticação facial do usuário.");
        // Captar facial do usuário


        System.out.println("Validando com o padrão geométrico definido pelo usuário.");

        this.acessoAutorizado = PhoneSecurity.ACESSO_AUTORIZADO;

        System.out.println("Padrão geométrico validado. Acesso permitido! ");

    }

    public static int getAcessoAutorizado() {
        return acessoAutorizado;
    }

}
