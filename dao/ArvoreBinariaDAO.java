package dao;

import model.Node;

public class ArvoreBinariaDAO {
    private Node raiz;

    public ArvoreBinariaDAO(Node raiz) {
        this.raiz = raiz;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public boolean adicionarNo(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return true;
        }
        Node atual = raiz;
        while (true) {
            if (valor < atual.getValor()) {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new Node(valor));
                    return true;
                }
                atual = atual.getEsquerda();
            } else if (valor > atual.getValor()) {
                if (atual.getDireita() == null) {
                    atual.setDireita(new Node(valor));
                    return true;
                }
                atual = atual.getDireita();
            } else {
                return false;
            }
        }
    }

    public boolean deletarNo(int valor) {
        if (raiz == null) {
            return false;
        }

        Node alvo = localizarNo(valor);
        if (alvo == null) {
            return false;
        }

        if (alvo == raiz) {
            return removerRaiz();
        }

        Node pai = localizarNoPai(valor);
        int filhos = quantidadeDeFilhos(alvo);

        switch (filhos) {
            case 0:
                return removerFolha(pai, alvo);
            case 1:
                return removerNoComUmFilho(pai, alvo);
            case 2:
                return removerNoComDoisFilhos(alvo);
            default:
                return false;
        }
    }

    public Node localizarNo(int valor) {
        Node atual = raiz;
        while (atual != null) {
            if (valor == atual.getValor()) {
                return atual;
            } else if (valor < atual.getValor()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }
        return null;
    }

    public Node localizarNoPai(int valor) {
        if (raiz == null || raiz.getValor() == valor) {
            return null;
        }
        Node atual = raiz;
        while (atual != null) {
            if (atual.getEsquerda() != null && atual.getEsquerda().getValor() == valor) {
                return atual;
            }
            if (atual.getDireita() != null && atual.getDireita().getValor() == valor) {
                return atual;
            }
            if (valor < atual.getValor()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }
        return null;
    }

    public boolean contemNo(int valor) {
        return localizarNo(valor) != null;
    }

    private boolean removerRaiz() {
        int filhos = quantidadeDeFilhos(raiz);
        if (filhos == 0) {
            raiz = null;
            return true;
        } else if (filhos == 1) {
            raiz = (raiz.getEsquerda() != null) ? raiz.getEsquerda() : raiz.getDireita();
            return true;
        } else {
            return removerNoComDoisFilhos(raiz);
        }
    }

    private boolean removerFolha(Node pai, Node alvo) {
        if (pai.getEsquerda() == alvo) {
            pai.setEsquerda(null);
        } else {
            pai.setDireita(null);
        }
        return true;
    }

    private boolean removerNoComUmFilho(Node pai, Node alvo) {
        Node filho;
        if (alvo.getEsquerda() != null) {
            filho = alvo.getEsquerda();
        } else {
            filho = alvo.getDireita();
        }

        if (pai.getEsquerda() == alvo) {
            pai.setEsquerda(filho);
        } else {
            pai.setDireita(filho);
        }
        return true;
    }

    private boolean removerNoComDoisFilhos(Node alvo) {
        Node sucessor = obterSucessor(alvo);
        Node paiSucessor = obterPaiDoSucessor(alvo);

        if (sucessor == null) {
            return false;
        }

        alvo.setValor(sucessor.getValor());

        if (paiSucessor == alvo) {
            paiSucessor.setDireita(sucessor.getDireita());
        } else {
            paiSucessor.setEsquerda(sucessor.getDireita());
        }
        return true;
    }

    private Node obterSucessor(Node no) {
        if (no == null || no.getDireita() == null) {
            return null;
        }
        Node atual = no.getDireita();
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }

    private Node obterPaiDoSucessor(Node no) {
        if (no == null || no.getDireita() == null) {
            return null;
        }
        Node pai = no;
        Node atual = no.getDireita();
        while (atual.getEsquerda() != null) {
            pai = atual;
            atual = atual.getEsquerda();
        }
        return pai;
    }

    private int quantidadeDeFilhos(Node no) {
        if (no == null) {
            return -1;
        }
        int qtd = 0;
        if (no.getEsquerda() != null) qtd++;
        if (no.getDireita() != null) qtd++;
        return qtd;
    }
}
