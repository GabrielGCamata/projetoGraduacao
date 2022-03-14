/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarFaixa;

import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class SubidaDescida {
    
    /**
     *
     * @param histograma
     * @param posicaoInicio
     * @return
     */
    public static int Subida(float[] histograma, int posicaoInicial, float media)
    {
        float primeiraSubida = Float.MIN_VALUE;
        int posicaoPrimeiraSubida = 0;
        int teste = 0;
        for(int i= posicaoInicial; i < histograma.length; i++)
        {
            if(primeiraSubida < media || primeiraSubida < histograma[i])
            {
                primeiraSubida = histograma[i];
                posicaoPrimeiraSubida = i;
            }
            if(primeiraSubida > histograma[i])
            {
                teste++;
                if(teste == 10){
                    i = histograma.length + 1;
                }
            }
            
        }
        System.out.println("PrimeiraSubida: " + primeiraSubida + " --- Posicao primeira SUbida: " + posicaoPrimeiraSubida);
        
        return posicaoPrimeiraSubida;
    }
    
    
    public static int Descida(float[] histograma, int posicaoInicial, float media)
    {
        float primeiraDescida = Float.MAX_VALUE;
        int posicaoPrimeiraDescida = 0;
        int teste = 0;
        for(int i= posicaoInicial; i < histograma.length; i++)
        {
            
//            System.out.println("valor: "+ histograma[i]);
            if(primeiraDescida > histograma[i] || primeiraDescida > media)
            {
                primeiraDescida = histograma[i];
                posicaoPrimeiraDescida = i;
            }
            if(primeiraDescida < histograma[i])
            {
                teste++;
                if(teste == 10){
                    i = histograma.length + 1;
                }
            }
        }
             
        System.out.println("Primeira Descida: " + primeiraDescida + " --- Posicao primeira Descida: " + posicaoPrimeiraDescida);

        return posicaoPrimeiraDescida;
    }
    
    public static ArrayList PontoDeInteresse(float[] histograma, float mediana)
    {
        ArrayList pontosAcimaMediana = new ArrayList();
        int count = 0;
        int teste = 0;
        //for para percorre o vetor
        for(count =4; count < histograma.length-4; count++)
        {
            // if para comparar o valor com o ponto de interesse
            /*if((histograma[count] - mediana) <= 0 || (mediana - histograma[count]) <= 0  ){
                //System.out.println("Posiçao de interesse: " + count);
                pontosAcimaMediana.add(count);
                count += 20;
            }*/
            if(mediana > histograma[count]){
                System.out.println(count);
                pontosAcimaMediana.add(count);
                count += histograma.length * 0.17;
                count = (int)count;
            }    
        
        }
        return pontosAcimaMediana;
    }
    


    
}
