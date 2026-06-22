public class ListaVetor<T> implements Lista<T> {

    private T[] itens;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public ListaVetor() {
        itens = (T[]) new Object[10];
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    private void aumentaCapacidade() {

        if (tamanho == itens.length) {

            T[] novo = (T[]) new Object[itens.length * 2];

            for (int i = 0; i < itens.length; i++) {
                novo[i] = itens[i];
            }

            itens = novo;
        }
    }

    @Override
    public void add(T valor) {
        add(valor, tamanho);
    }

    @Override
    public void add(T valor, int pos) {

        if (pos < 0 || pos > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        aumentaCapacidade();

        for (int i = tamanho; i > pos; i--) {
            itens[i] = itens[i - 1];
        }

        itens[pos] = valor;
        tamanho++;
    }

    @Override
    public T get(int pos) {

        if (pos < 0 || pos >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        return itens[pos];
    }

    @Override
    public T remove(int pos) {

        if (pos < 0 || pos >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        T removido = itens[pos];

        for (int i = pos; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }

        tamanho--;

        return removido;
    }

    @Override
    public boolean remove(T valor) {

        for (int i = 0; i < tamanho; i++) {

            if (itens[i].equals(valor)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return tamanho;
    }
}