public class SorteadorViaDoisParesConsecutivos<T> implements Sorteador {

    private DadoGenerico<T> Dado;

    public SorteadorViaDoisParesConsecutivos(DadoGenerico<T> Dados) {
        Dado = Dados;
    }

    @Override
    public Object sortear() {
        T A = Dado.sortear();
        T B = Dado.sortear();
        T C = Dado.sortear();
        T D = Dado.sortear();

        if (A == B && C == D) {
            return 1;
        }
        return 0;
    }
}
