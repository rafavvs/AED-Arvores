public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        //inserirRecursivo(novoNo, this.raiz);
        inserirIterativo(novoNo);
    }
    private void inserirRecursivo(No no, No atual) {
        if(estaVazia()) {
            this.raiz = no;
            return;
        }
        if(no.getConteudo() > atual.getConteudo()) {
            if(atual.getDireita() == null) {
                atual.setDireita(no);
                return;
            } else {
                inserirRecursivo(no, atual.getDireita());
            }
        } else {
            if(atual.getEsquerda() == null) {
                atual.setEsquerda(no);
                return;
            } else {
                inserirRecursivo(no, atual.getEsquerda());
            }
        }
    }

    private void inserirIterativo(No no) {
        if(estaVazia()) {
            this.raiz = no;
            return;
        } else {
            No aux = this.raiz;
            while(aux != null) {
                if(no.getConteudo() > aux.getConteudo()) {
                    if(aux.getDireita() == null) {
                        aux.setDireita(no);
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                } else {
                    if(aux.getEsquerda() == null) {
                        aux.setEsquerda(no);
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                }
            }
        }

    }

    public boolean estaVazia() {
        if(this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void exibir(String percurso) {
        switch(percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }

    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void remover(Integer valor) {
        if (estaVazia()) {
            System.out.println("A árvore está vazia. Nada a remover.");
            return;
        }
        this.raiz = removerRecursivo(this.raiz, valor);

        // Caso a raiz fique nula após a remoção
        if (this.raiz == null) {
            this.raiz = new No(null);
        }
    }

    private No removerRecursivo(No atual, Integer valor) {
        if (atual == null) {
            return null;
        }

        // Encontra o nó a ser removido
        if (valor < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), valor));
        } else if (valor > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), valor));
        } else {

            // Nó folha ou nó com apenas um filho
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            // Nó com dois filhos
            // Remover sucessor (menor dos maiores)
            Integer menorValorDireita = encontrarMenorValor(atual.getDireita());

            // Substitui o valor do nó atual pelo valor do sucessor
            atual.setConteudo(menorValorDireita);

            // Remove recursivamente o nó sucessor original que estava na subárvore direita
            atual.setDireita(removerRecursivo(atual.getDireita(), menorValorDireita));
        }

        // Retorna a raiz atualizada para ser religada ao nó "pai" na chamada recursiva
        return atual;
    }

    private Integer encontrarMenorValor(No noAtual) {
        // Desce sempre para a esquerda para encontrar o menor elemento
        if (noAtual.getEsquerda() == null) {
            return noAtual.getConteudo();
        } else {
            return encontrarMenorValor(noAtual.getEsquerda());
        }
    }
}