import java.util.HashMap;
import java.util.Map;

public class Principal {

    private static final int CONT_REPETICOES_POR_SIMULACAO = 2_000_000;


    private static final DadoComum Dado6Faces = new DadoComum();
    private static final DadoViciado Dado6FacesViciado = new DadoViciado();

    private static final SorteadorViaTrio<Integer> SorteadorTrio = new SorteadorViaTrio<>(Dado6Faces);
    private static final SorteadorViaDoisParesConsecutivos<Integer> SorteadorPares = new SorteadorViaDoisParesConsecutivos<>(Dado6FacesViciado);


    private static void obterPercentuaisEmpiricos(int numeroDeRodadasPorPartida, SorteadorViaTrio<Integer> Sorteador1 , SorteadorViaDoisParesConsecutivos<Integer> Sorteador2) {

        JogoMalucoComSorteadores<SorteadorViaTrio<Integer>, SorteadorViaDoisParesConsecutivos<Integer>> jogoMaluco;

        jogoMaluco = new JogoMalucoComSorteadores<>(
                "JogadorDosDadosDeGamao", "JogadorDosDadosTriplos",
                numeroDeRodadasPorPartida, Sorteador1, Sorteador2);

        for (int i = 0; i < CONT_REPETICOES_POR_SIMULACAO; i++) {
            jogoMaluco.jogar();
        }

        System.out.println(String.format("\n\n" +
                "      Para partidas com %d rodada(s):\n" +
                "      Vitórias do Jogador 1: %f%%\n" +
                "      Vitórias do Jogador 2: %f%%\n" +
                "      Empates: %f%%",
                numeroDeRodadasPorPartida,
                jogoMaluco.getPercentualVitoriasJogador1(),
                jogoMaluco.getPercentualVitoriasJogador2(),
                jogoMaluco.getPercentualEmpates()));
    }

    public static void main(String[] args) {

        Map<String, Integer> frequenciaByDiaDaSemana = new HashMap<>();
        frequenciaByDiaDaSemana.put("segunda", 1);
        frequenciaByDiaDaSemana.put("terça", 4);
        frequenciaByDiaDaSemana.put("quarta", 6);
        frequenciaByDiaDaSemana.put("quinta", 1);
        frequenciaByDiaDaSemana.put("sexta", 1);
        frequenciaByDiaDaSemana.put("sábado", 10);
        frequenciaByDiaDaSemana.put("domingo", 10);

        DadoGenerico<String> sorteadorDeDiasDaSemana = new DadoGenerico<>(frequenciaByDiaDaSemana);


        String diaSorteado = sorteadorDeDiasDaSemana.sortear();
        System.out.println(diaSorteado);


        for (int numeroDeRodadas = 1; numeroDeRodadas <= 1000000; numeroDeRodadas++) {
            obterPercentuaisEmpiricos(numeroDeRodadas,SorteadorTrio,SorteadorPares);
        }


    }
}
