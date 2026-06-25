package bo;

import dao.ArvoreBinariaDAO;
import model.Node;

public class ArvoreBinariaBO {
    private ArvoreBinariaDAO dao;

    public ArvoreBinariaBO(ArvoreBinariaDAO dao) {
        this.dao = dao;
    }

    public Node getRaiz() {
        return dao.getRaiz();
    }

    public boolean adicionarValor(int valor) {
        if (dao.contemNo(valor)) {
            System.out.println("  [ERRO] Valor " + valor + " ja existe na arvore");
            return false;
        }
        boolean resultado = dao.adicionarNo(valor);
        if (resultado) {
            System.out.println("  [OK] Valor " + valor + " inserido com sucesso");
        }
        return resultado;
    }

    public boolean deletarValor(int valor) {
        if (dao.getRaiz() == null) {
            System.out.println("  [ERRO] Arvore vazia");
            return false;
        }
        if (!dao.contemNo(valor)) {
            System.out.println("  [ERRO] Valor " + valor + " nao encontrado");
            return false;
        }
        boolean resultado = dao.deletarNo(valor);
        if (resultado) {
            System.out.println("  [OK] Valor " + valor + " excluido com sucesso");
        }
        return resultado;
    }

    public boolean pesquisarValor(int valor) {
        boolean encontrado = dao.contemNo(valor);
        if (encontrado) {
            System.out.println("  [OK] Valor " + valor + " encontrado na arvore");
        } else {
            System.out.println("  [ERRO] Valor " + valor + " nao encontrado");
        }
        return encontrado;
    }

    public boolean valorExiste(int valor) {
        return dao.contemNo(valor);
    }

    public int obterAltura() {
        return obterAltura(dao.getRaiz());
    }

    private int obterAltura(Node no) {
        if (no == null) return 0;
        return 1 + Math.max(obterAltura(no.getEsquerda()), obterAltura(no.getDireita()));
    }

    public int obterQuantidadeDeNos() {
        return obterQuantidadeDeNos(dao.getRaiz());
    }

    private int obterQuantidadeDeNos(Node no) {
        if (no == null) return 0;
        return 1 + obterQuantidadeDeNos(no.getEsquerda()) + obterQuantidadeDeNos(no.getDireita());
    }

    public int obterQuantidadeDeFolhas() {
        return obterQuantidadeDeFolhas(dao.getRaiz());
    }

    private int obterQuantidadeDeFolhas(Node no) {
        if (no == null) return 0;
        if (no.getEsquerda() == null && no.getDireita() == null) return 1;
        return obterQuantidadeDeFolhas(no.getEsquerda()) + obterQuantidadeDeFolhas(no.getDireita());
    }
}
