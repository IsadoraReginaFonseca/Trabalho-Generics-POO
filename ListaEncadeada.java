public class ListaEncadeada<T> implements Lista<T> {

    private No<T> primeiro;
    private int tamanho;

    @Override
    public void add(T valor) {
        add(valor, tamanho);
    }

    @Override
    public void add(T valor, int pos) {

        if (pos < 0 || pos > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        No<T> novo = new No<>(valor);

        if (pos == 0) {
            novo.setProx(primeiro);
            primeiro = novo;
        } else {

            No<T> atual = primeiro;

            for (int i = 0; i < pos - 1; i++) {
                atual = atual.getProx();
            }

            novo.setProx(atual.getProx());
            atual.setProx(novo);
        }

        tamanho++;
    }

    @Override
    public T get(int pos) {

        if (pos < 0 || pos >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        No<T> atual = primeiro;

        for (int i = 0; i < pos; i++) {
            atual = atual.getProx();
        }

        return atual.getValor();
    }

    @Override
    public T remove(int pos) {

        if (pos < 0 || pos >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        T removido;

        if (pos == 0) {
            removido = primeiro.getValor();
            primeiro = primeiro.getProx();
        } else {

            No<T> anterior = primeiro;

            for (int i = 0; i < pos - 1; i++) {
                anterior = anterior.getProx();
            }

            removido = anterior.getProx().getValor();
            anterior.setProx(anterior.getProx().getProx());
        }

        tamanho--;

        return removido;
    }

    @Override
    public boolean remove(T valor) {

        if (primeiro == null) {
            return false;
        }

        if (primeiro.getValor().equals(valor)) {
            primeiro = primeiro.getProx();
            tamanho--;
            return true;
        }

        No<T> atual = primeiro;

        while (atual.getProx() != null) {

            if (atual.getProx().getValor().equals(valor)) {
                atual.setProx(atual.getProx().getProx());
                tamanho--;
                return true;
            }

            atual = atual.getProx();
        }

        return false;
    }

    @Override
    public int size() {
        return tamanho;
    }
}