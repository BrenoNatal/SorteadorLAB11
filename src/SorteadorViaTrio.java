public class SorteadorViaTrio<T> implements Sorteador {

    private DadoGenerico<T> Dado;

    public SorteadorViaTrio(DadoGenerico<T> Dados) {
        Dado = Dados;
    }



    @Override
    public Object sortear() {
        T A = Dado.sortear();
        T B = Dado.sortear();
        T C = Dado.sortear();

        if (A == B && B == C) {
            return 1;
        }
        return 0;
    }
}
