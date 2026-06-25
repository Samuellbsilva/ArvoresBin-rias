package menu;

import dao.ArvoreBinariaDAO;
import bo.ArvoreBinariaBO;
import model.Node;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("  +----------------------------------------------+");
        System.out.println("  |       ARVORE BINARIA DE BUSCA - v3.0         |");
        System.out.println("  +----------------------------------------------+");
        System.out.println();

        System.out.print("  Digite o valor da raiz: ");
        int valorRaiz = scanner.nextInt();

        Node raiz = new Node(valorRaiz);
        ArvoreBinariaDAO dao = new ArvoreBinariaDAO(raiz);
        ArvoreBinariaBO bo = new ArvoreBinariaBO(dao);
        Visualizador visualizador = new Visualizador(bo);

        System.out.println("  [OK] Arvore criada com raiz " + valorRaiz);
        System.out.println();
        visualizador.desenharArvore();
        System.out.println();

        Menu menu = new Menu(scanner, bo, visualizador);
        menu.executar();

        scanner.close();
    }
}
