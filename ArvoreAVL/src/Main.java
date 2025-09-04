public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore1 = new ArvoreAVL();
        int[] valores1 = {40, 20, 60, 10, 30, 25};

        ArvoreAVL arvore2 = new ArvoreAVL();
        int[] valores2 = {60, 40, 80, 35, 50, 90, 20, 38, 37};

        ArvoreAVL arvore3 = new ArvoreAVL();
        int[] valores3 = {30, 20, 10, 25, 40, 50, 5, 35, 45};

        for (int v : valores1) arvore1.inserir(v);
        for (int v : valores2) arvore2.inserir(v);
        for (int v : valores3) arvore3.inserir(v);

        System.out.println("arvore 1 pre-ordem:");
        arvore1.mostrarPreOrdem();
        System.out.println("arvore 1 em ordem:");
        arvore1.mostrarEmOrdem();
        System.out.println("\n---------------------");

        System.out.println("arvore 2 pre-ordem:");
        arvore2.mostrarPreOrdem();
        System.out.println("arvore 2 em ordem:");
        arvore2.mostrarEmOrdem();
        System.out.println("\n---------------------");

        System.out.println("arvore 3 pre-ordem:");
        arvore3.mostrarPreOrdem();
        System.out.println("arvore 3 em ordem:");
        arvore3.mostrarEmOrdem();
        System.out.println();
    }
}