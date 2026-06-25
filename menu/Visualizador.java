package menu;

import bo.ArvoreBinariaBO;
import model.Node;
import java.util.LinkedList;
import java.util.Queue;

public class Visualizador {
    private ArvoreBinariaBO bo;

    public Visualizador(ArvoreBinariaBO bo) {
        this.bo = bo;
    }

    public void percorrerEmOrdem() {
        Node raiz = bo.getRaiz();
        if (raiz == null) {
            System.out.println("  Arvore vazia");
            return;
        }
        StringBuilder sb = new StringBuilder();
        percorrerEmOrdem(raiz, sb);
        System.out.println("  Em Ordem:   " + sb.toString().trim());
    }

    private void percorrerEmOrdem(Node no, StringBuilder sb) {
        if (no == null) return;
        percorrerEmOrdem(no.getEsquerda(), sb);
        sb.append(no.getValor()).append(" ");
        percorrerEmOrdem(no.getDireita(), sb);
    }

    public void percorrerPreOrdem() {
        Node raiz = bo.getRaiz();
        if (raiz == null) {
            System.out.println("  Arvore vazia");
            return;
        }
        StringBuilder sb = new StringBuilder();
        percorrerPreOrdem(raiz, sb);
        System.out.println("  Pre-Ordem:  " + sb.toString().trim());
    }

    private void percorrerPreOrdem(Node no, StringBuilder sb) {
        if (no == null) return;
        sb.append(no.getValor()).append(" ");
        percorrerPreOrdem(no.getEsquerda(), sb);
        percorrerPreOrdem(no.getDireita(), sb);
    }

    public void percorrerPosOrdem() {
        Node raiz = bo.getRaiz();
        if (raiz == null) {
            System.out.println("  Arvore vazia");
            return;
        }
        StringBuilder sb = new StringBuilder();
        percorrerPosOrdem(raiz, sb);
        System.out.println("  Pos-Ordem:  " + sb.toString().trim());
    }

    private void percorrerPosOrdem(Node no, StringBuilder sb) {
        if (no == null) return;
        percorrerPosOrdem(no.getEsquerda(), sb);
        percorrerPosOrdem(no.getDireita(), sb);
        sb.append(no.getValor()).append(" ");
    }

    public void todosPercursos() {
        percorrerEmOrdem();
        percorrerPreOrdem();
        percorrerPosOrdem();
    }

    public void desenharArvore() {
        Node raiz = bo.getRaiz();
        if (raiz == null) {
            System.out.println("  Arvore vazia");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("  ").append(raiz.getValor()).append("\n");
        desenharArvore(raiz, sb, "  ");
        System.out.print(sb);
    }

    private void desenharArvore(Node no, StringBuilder sb, String prefixo) {
        if (no == null) return;

        boolean temEsquerda = no.getEsquerda() != null;
        boolean temDireita = no.getDireita() != null;

        if (temEsquerda) {
            String conector = temDireita ? "|-- " : "`-- ";
            sb.append(prefixo).append(conector).append(no.getEsquerda().getValor()).append("\n");
            String novoPrefixo = prefixo + (temDireita ? "|   " : "    ");
            desenharArvore(no.getEsquerda(), sb, novoPrefixo);
        }

        if (temDireita) {
            sb.append(prefixo).append("`-- ").append(no.getDireita().getValor()).append("\n");
            desenharArvore(no.getDireita(), sb, prefixo + "    ");
        }
    }

    public void desenharPorNiveis() {
        Node raiz = bo.getRaiz();
        if (raiz == null) {
            System.out.println("  Arvore vazia");
            return;
        }

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);
        int nivel = 0;

        while (!fila.isEmpty()) {
            int tamanho = fila.size();
            StringBuilder sb = new StringBuilder("  Nivel " + nivel + ": ");

            for (int i = 0; i < tamanho; i++) {
                Node atual = fila.poll();
                sb.append(atual.getValor());
                if (i < tamanho - 1) sb.append(", ");
                if (atual.getEsquerda() != null) fila.add(atual.getEsquerda());
                if (atual.getDireita() != null) fila.add(atual.getDireita());
            }

            System.out.println(sb);
            nivel++;
        }
    }

    public void gerarRelatorio() {
        System.out.println();
        System.out.println("  +---------------------------------------+");
        System.out.println("  |         RELATORIO COMPLETO            |");
        System.out.println("  +---------------------------------------+");
        System.out.println();

        System.out.println("  --- Estrutura ---");
        desenharArvore();
        System.out.println();

        System.out.println("  --- Niveis ---");
        desenharPorNiveis();
        System.out.println();

        System.out.println("  --- Percursos ---");
        todosPercursos();
        System.out.println();

        System.out.println("  --- Metricas ---");
        System.out.println("  Altura:          " + bo.obterAltura());
        System.out.println("  Total de nos:    " + bo.obterQuantidadeDeNos());
        System.out.println("  Total de folhas: " + bo.obterQuantidadeDeFolhas());
        System.out.println();
    }
}
