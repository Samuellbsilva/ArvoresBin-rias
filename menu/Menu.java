package menu;

import bo.ArvoreBinariaBO;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ArvoreBinariaBO bo;
    private Visualizador visualizador;

    public Menu(Scanner scanner, ArvoreBinariaBO bo, Visualizador visualizador) {
        this.scanner = scanner;
        this.bo = bo;
        this.visualizador = visualizador;
    }

    public void executar() {
        int opcao = -1;
        while (opcao != 0) {
            exibirMenuPrincipal();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    acaoInserir();
                    break;
                case 2:
                    acaoExcluir();
                    break;
                case 3:
                    acaoBuscar();
                    break;
                case 4:
                    abrirSubmenuVisualizacao();
                    break;
                case 5:
                    abrirSubmenuPercursos();
                    break;
                case 6:
                    visualizador.gerarRelatorio();
                    break;
                case 0:
                    System.out.println("\n  Programa encerrado.\n");
                    break;
                default:
                    System.out.println("  [ERRO] Opcao invalida\n");
            }
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("  +----------------------------------------------+");
        System.out.println("  |              MENU PRINCIPAL                  |");
        System.out.println("  +----------------------------------------------+");
        System.out.println("  |                                              |");
        System.out.println("  |   [1] Inserir Valor                          |");
        System.out.println("  |   [2] Excluir Valor                          |");
        System.out.println("  |   [3] Buscar Valor                           |");
        System.out.println("  |   [4] Visualizar Arvore                      |");
        System.out.println("  |   [5] Percursos                              |");
        System.out.println("  |   [6] Metricas e Relatorio                   |");
        System.out.println("  |   [0] Encerrar                               |");
        System.out.println("  |                                              |");
        System.out.println("  +----------------------------------------------+");
    }

    private void abrirSubmenuVisualizacao() {
        int sub = -1;
        while (sub != 0) {
            System.out.println();
            System.out.println("  +---------------------------------+");
            System.out.println("  |        VISUALIZACAO             |");
            System.out.println("  +---------------------------------+");
            System.out.println("  |  [1] Estrutura em Arvore        |");
            System.out.println("  |  [2] Exibir por Niveis          |");
            System.out.println("  |  [0] Voltar                     |");
            System.out.println("  +---------------------------------+");
            sub = lerOpcao();

            switch (sub) {
                case 1:
                    System.out.println();
                    visualizador.desenharArvore();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    visualizador.desenharPorNiveis();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("  [ERRO] Opcao invalida\n");
            }
        }
    }

    private void abrirSubmenuPercursos() {
        int sub = -1;
        while (sub != 0) {
            System.out.println();
            System.out.println("  +---------------------------------+");
            System.out.println("  |      PERCURSOS DA ARVORE        |");
            System.out.println("  +---------------------------------+");
            System.out.println("  |  [1] Em Ordem                   |");
            System.out.println("  |  [2] Pre-Ordem                  |");
            System.out.println("  |  [3] Pos-Ordem                  |");
            System.out.println("  |  [4] Todos os Percursos         |");
            System.out.println("  |  [0] Voltar                     |");
            System.out.println("  +---------------------------------+");
            sub = lerOpcao();

            switch (sub) {
                case 1:
                    System.out.println();
                    visualizador.percorrerEmOrdem();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    visualizador.percorrerPreOrdem();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    visualizador.percorrerPosOrdem();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    visualizador.todosPercursos();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("  [ERRO] Opcao invalida\n");
            }
        }
    }

    private void acaoInserir() {
        System.out.print("\n  Valor para inserir: ");
        int valor = scanner.nextInt();
        bo.adicionarValor(valor);
        System.out.println();
        visualizador.desenharArvore();
        System.out.println();
    }

    private void acaoExcluir() {
        System.out.print("\n  Valor para excluir: ");
        int valor = scanner.nextInt();
        bo.deletarValor(valor);
        System.out.println();
        visualizador.desenharArvore();
        System.out.println();
    }

    private void acaoBuscar() {
        System.out.print("\n  Valor para buscar: ");
        int valor = scanner.nextInt();
        bo.pesquisarValor(valor);
        System.out.println();
    }

    private int lerOpcao() {
        System.out.print("  >> Escolha: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("  >> Escolha: ");
        }
        return scanner.nextInt();
    }
}
