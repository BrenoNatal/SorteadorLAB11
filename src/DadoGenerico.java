import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class DadoGenerico<T> implements Sorteador<T> {

    Map<T, Integer> frequenciaByResultado;

    public DadoGenerico(Map<T, Integer> frequenciaByResultado) {
        this.frequenciaByResultado = frequenciaByResultado;
    }

    @Override
    public T sortear() {
        ArrayList<T> chaves = new ArrayList<>(frequenciaByResultado.keySet());
        ArrayList<Integer> acumulados = new ArrayList<>();
        Random SortearValor = new Random();
        Integer acumulado = 0;
        T resultado;

        for (T Chaves : chaves) {
            acumulado += frequenciaByResultado.get(Chaves);
            acumulados.add(acumulado);
        }

        int valor = SortearValor.nextInt(acumulado);


        for (int i = 0; i < frequenciaByResultado.size(); i++ ) {
            if (valor < acumulados.get(i)) {
                resultado = chaves.get(i);
                return resultado;
            }
        }

        return null;
    }

}
