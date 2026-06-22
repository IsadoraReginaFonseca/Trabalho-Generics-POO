public class TesteLista {

    public static void main(String[] args) {

        Lista<String>  lista = new ListaEncadeada<>();

        lista.add("Isadora");
        lista.add("Pedro");
        lista.add("Isadora");
        lista.add("Carlos");
        lista.add("Bruna");

        System.out.println("Tamanho: " + lista.size());

        System.out.println("Posição 2: " + lista.get(2));

        lista.remove("Pedro");

        System.out.println("\nLista após remover Pedro:");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

        System.out.println("\nMaior: " + ListaUtil.max(lista));
        System.out.println("Menor: " + ListaUtil.min(lista));
        System.out.println("Quantidade de Isadora: "
                + ListaUtil.count(lista, "Isadora"));
    }
}
