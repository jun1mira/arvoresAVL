class ArvoreAVL {

    static class No {
        int valor;
        int altura;
        No esquerda, direita;

        No(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    private No raiz;

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(No no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No temp = x.direita;

        x.direita = y;
        y.esquerda = temp;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No rotacaoEsquerda(No y) {
        No x = y.direita;
        No temp = x.esquerda;

        x.esquerda = y;
        y.direita = temp;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        } else {
            return atual;
        }

        atual.altura = 1 + Math.max(altura(atual.esquerda), altura(atual.direita));

        int balance = fatorBalanceamento(atual);

        //LL
        if (balance > 1 && valor < atual.esquerda.valor) {
            return rotacaoDireita(atual);
        }

        //RR
        if (balance < -1 && valor > atual.direita.valor) {
            return rotacaoEsquerda(atual);
        }

        //LR (dupla direita)
        if (balance > 1 && valor > atual.esquerda.valor) {
            atual.esquerda = rotacaoEsquerda(atual.esquerda);
            return rotacaoDireita(atual);
        }

        //RL (dupla esquerda)
        if (balance < -1 && valor < atual.direita.valor) {
            atual.direita = rotacaoDireita(atual.direita);
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    public void mostrarEmOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    public void mostrarPreOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.esquerda);
        System.out.print(no.valor + " ");
        emOrdem(no.direita);
    }

    private void preOrdem(No no) {
        if (no == null) return;
        System.out.print(no.valor + " ");
        preOrdem(no.esquerda);
        preOrdem(no.direita);
    }
}