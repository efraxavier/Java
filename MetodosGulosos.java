package ep2;

/*********************************************************************/
/** ACH 2002 - Introdução a Analise de Algoritmos                   **/
/** EACH-USP - Segundo Semestre de 2018                             **/
/**                                                                 **/
/**  Turma 04 - Prof. Norton Trevisan Roman                         **/
/**                                                                 **/
/** Segundo Exercicio-Programa                                      **/
/**                                                                 **/
/** Efraim Belo Xavier 10816899                                     **/
/**                                                                 **/
/*********************************************************************/


/**
 COMENTARIOS GERAIS

 Seguindo os criterios de selecao, um objeto só poderá ser colocado na
 mochila caso ela suporte o total de peso.

 O total de peso ao se colocar um objeto (do tipo Objeto) é dado por
 mochila.getPesoUsado() + objeto.getPeso()

 Colocar um objeto na mochila significa alterar os seguintes campos da mochila:

 pesoUsado,

 valorDentroDaMochila, e

 numObjetosNaMochila.
 */
public abstract class MetodosGulosos {

    /**
     Este método deve implementar um algoritmo guloso que selecione objetos
     da listaDeObjetosDisponiveis a serem colocados na mochila, de acordo
     com o critério 'objetos de menor peso primeiro'. Caso dois objetos
     tenham o mesmo peso, o critério de desempate será 'objetos de maior
     valor primeiro' (apenas para os empates em peso).

     @param pesoMaximoDaMochila Peso máximo suportado pela mochila
     @param listaDeObjetosDisponiveis Arranjo de objetos considerados no problema

     @return Mochila carregada conforme essa estratégia
     */
    public static Mochila utilizaMenorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {

        Mochila mochila = new Mochila(pesoMaximoDaMochila);

        for (int i = listaDeObjetosDisponiveis.length; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if (listaDeObjetosDisponiveis[j - 1].getPeso() > listaDeObjetosDisponiveis[j].getPeso()) {
                    Objeto aux = listaDeObjetosDisponiveis[j];
                    listaDeObjetosDisponiveis[j] = listaDeObjetosDisponiveis[j - 1];
                    listaDeObjetosDisponiveis[j - 1] = aux;
                } else if (listaDeObjetosDisponiveis[j].getPeso() == listaDeObjetosDisponiveis[j - 1].getPeso() && listaDeObjetosDisponiveis[j].getValor() > listaDeObjetosDisponiveis[j - 1].getValor()) {
                    Objeto aux = listaDeObjetosDisponiveis[j];
                    listaDeObjetosDisponiveis[j] = listaDeObjetosDisponiveis[j - 1];
                    listaDeObjetosDisponiveis[j - 1] = aux;
                }
            }
        }

        for(int x = 0; x < listaDeObjetosDisponiveis.length; x++) {
            if (mochila.getPesoUsado() + listaDeObjetosDisponiveis[x].getPeso() <= pesoMaximoDaMochila) {
                mochila.setPesoUsado(listaDeObjetosDisponiveis[x].getPeso() + mochila.getPesoUsado());
                mochila.setValorDentroDaMochila(listaDeObjetosDisponiveis[x].getValor() + mochila.getValorDentroDaMochila());
                mochila.setNumObjetosNaMochila(mochila.getNumObjetosNaMochila() + 1);
            }
        }
        return mochila;
    }


    /**
     Este método deve implementar um algoritmo guloso que selecione objetos
     da listaDeObjetosDisponiveis a serem colocados na mochila, de acordo
     com o critério 'objetos de maior valor primeiro'. Caso dois objetos
     tenham o mesmo valor, o critério de desempate sera 'objetos de menor peso
     primeiro' (apenas para os empates em valor).

     @param pesoMaximoDaMochila Peso máximo suportado pela mochila
     @param listaDeObjetosDisponiveis Arranjo de objetos considerados no problema

     @return Mochila carregada conforme essa estratégia
     */
    public static Mochila utilizaMaiorValor(double pesoMaximoDaMochila,	Objeto[] listaDeObjetosDisponiveis) {
        Mochila mochila = new Mochila(pesoMaximoDaMochila);

        for (int i = listaDeObjetosDisponiveis.length; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if (listaDeObjetosDisponiveis[j - 1].getValor() < listaDeObjetosDisponiveis[j].getValor() || (listaDeObjetosDisponiveis[j - 1].getValor() == listaDeObjetosDisponiveis[j].getValor() && listaDeObjetosDisponiveis[j - 1].getPeso() > listaDeObjetosDisponiveis[j].getPeso())) {
                    Objeto aux = listaDeObjetosDisponiveis[j];
                    listaDeObjetosDisponiveis[j] = listaDeObjetosDisponiveis[j - 1];
                    listaDeObjetosDisponiveis[j - 1] = aux;
                }
            }
        }

        for(int x = 0; x < listaDeObjetosDisponiveis.length; x++) {
            if (mochila.getPesoUsado() + listaDeObjetosDisponiveis[x].getPeso() <= pesoMaximoDaMochila) {
                mochila.setPesoUsado(listaDeObjetosDisponiveis[x].getPeso() + mochila.getPesoUsado());
                mochila.setValorDentroDaMochila(listaDeObjetosDisponiveis[x].getValor() + mochila.getValorDentroDaMochila());
                mochila.setNumObjetosNaMochila(mochila.getNumObjetosNaMochila() + 1);
            }
        }
        return mochila;
    }


    /**
     Este método deve implementar um algoritmo guloso que selecione objetos
     da listaDeObjetosDisponiveis a serem colocados na mochila, de acordo
     com o critério 'objetos de maior valor/peso primeiro (valor dividido por
     peso primeiro)'. Caso dois objetos tenham o mesmo valor/peso, o critério
     de desempate sera 'objetos de maior peso primeiro' (apenas para os empates).

     @param pesoMaximoDaMochila Peso máximo suportado pela mochila
     @param listaDeObjetosDisponiveis Arranjo de objetos considerados no problema

     @return Mochila carregada conforme essa estratégia
     */
    public static Mochila utilizaMaiorValorDivididoPorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
        Mochila mochila = new Mochila(pesoMaximoDaMochila);

        for (int i = listaDeObjetosDisponiveis.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if ((listaDeObjetosDisponiveis[j - 1].getValor()/listaDeObjetosDisponiveis[j - 1].getPeso()) < (listaDeObjetosDisponiveis[j].getValor()/listaDeObjetosDisponiveis[j].getPeso())) {
                    Objeto aux = listaDeObjetosDisponiveis[j];
                    listaDeObjetosDisponiveis[j] = listaDeObjetosDisponiveis[j - 1];
                    listaDeObjetosDisponiveis[j - 1] = aux;
                } else if ((listaDeObjetosDisponiveis[j - 1].getValor()/listaDeObjetosDisponiveis[j - 1].getPeso()) == (listaDeObjetosDisponiveis[j].getValor()/listaDeObjetosDisponiveis[j].getPeso())
                && listaDeObjetosDisponiveis[j - 1].getPeso() < listaDeObjetosDisponiveis[j].getPeso()) {
                    Objeto aux = listaDeObjetosDisponiveis[j];
                    listaDeObjetosDisponiveis[j] = listaDeObjetosDisponiveis[j - 1];
                    listaDeObjetosDisponiveis[j - 1] = aux;
                }
            }
        }

        for(int x = 0; x < listaDeObjetosDisponiveis.length; x++) {
            if (mochila.getPesoUsado() + listaDeObjetosDisponiveis[x].getPeso() <= pesoMaximoDaMochila) {
                mochila.setPesoUsado(listaDeObjetosDisponiveis[x].getPeso() + mochila.getPesoUsado());
                mochila.setValorDentroDaMochila(listaDeObjetosDisponiveis[x].getValor() + mochila.getValorDentroDaMochila());
                mochila.setNumObjetosNaMochila(mochila.getNumObjetosNaMochila() + 1);
            }
        }
        return mochila;
    }
}
