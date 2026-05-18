public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(17);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(13);
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(78);
        arvoreBinaria.inserir(48);
        arvoreBinaria.inserir(42);
        arvoreBinaria.inserir(67);
        arvoreBinaria.inserir(122);
        arvoreBinaria.exibir("Pos");

        arvoreBinaria.remover(122);
        arvoreBinaria.remover(5);
        arvoreBinaria.remover(17);
        System.out.println();

        arvoreBinaria.exibir("Pos");
    }
}