public class ArrayUtil {

    public static <T> int count(T[] vetor, T elemento) {
        int contador = 0;

        for (T item : vetor) {
            if (item.equals(elemento)) {
                contador++;
            }
        }

        return contador;
    }

    public static <T extends Comparable<T>> T max(T[] vetor) {

        if (vetor == null || vetor.length == 0) {
            throw new IllegalArgumentException("Array vazio ou null");
        }

        T maior = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(maior) > 0) {
                maior = vetor[i];
            }
        }

        return maior;
    }

    public static <T extends Comparable<T>> T min(T[] vetor) {

        if (vetor == null || vetor.length == 0) {
            throw new IllegalArgumentException("Array vazio ou null");
        }

        T menor = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(menor) < 0) {
                menor = vetor[i];
            }
        }

        return menor;
    }
}