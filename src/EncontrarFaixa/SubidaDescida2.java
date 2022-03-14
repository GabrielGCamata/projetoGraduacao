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
public class SubidaDescida2 {
    
    /**
     *
     * @param histograma
     * @param posicaoInicio
     * @return
     */
    public static int Subida(float[] histograma)
    {
        float primeiraSubida = Float.MIN_VALUE;
        int posicaoPrimeiraSubida = 0;
        
        for(int i= 0; i < histograma.length; i++)
        {
            if(primeiraSubida < histograma[i])
            {
                primeiraSubida = histograma[i];
                posicaoPrimeiraSubida = i;
            }
        }
        System.out.println("PrimeiraSubida: " + primeiraSubida + " --- Posicao primeira SUbida: " + posicaoPrimeiraSubida);
        
        return posicaoPrimeiraSubida;
    }
    
    public static int Subida(float[] histograma, int posicaoInicio)
    {
        float primeiraSubida = Float.MIN_VALUE;
        int posicaoPrimeiraSubida = 0;
        int teste =0;
        for(int i= posicaoInicio+ 10; i < histograma.length; i++)
        {
            
            if(primeiraSubida < histograma[i])
            {
                primeiraSubida = histograma[i];
                posicaoPrimeiraSubida = i;
            }
            if(primeiraSubida > histograma[i])
            {
                teste++;
                if(teste == 5){
                    i = histograma.length + 1;
                }
            }
        }
             
        System.out.println("PrimeiraSubida: " + primeiraSubida + " --- Posicao primeira SUbida: " + posicaoPrimeiraSubida);

        return posicaoPrimeiraSubida;
    }
    
    public static int Descida(float[] histograma)
    {
        float primeiraDescida = Float.MAX_VALUE;
        int posicaoPrimeiraDescida = 0;
        int teste = 0;
        for(int i= 0; i < histograma.length; i++)
        {
            
//            System.out.println("valor: "+ histograma[i]);
            if(primeiraDescida > histograma[i])
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
    public static int Descida(float[] histograma, int posicaoInicial)
    {
        float primeiraDescida = Float.MAX_VALUE;
        int posicaoPrimeiraDescida = 0;
        int teste = 0;
        for(int i= posicaoInicial + 10; i < histograma.length; i++)
        {
            
            System.out.println("valor: "+ histograma[i]);
            if(primeiraDescida > histograma[i])
            {
                primeiraDescida = histograma[i];
                posicaoPrimeiraDescida = i;
            }
            if(primeiraDescida < histograma[i])
            {
                teste++;
                if(teste == 5){
                    i = histograma.length + 1;
                }
            }
        }
             
        System.out.println("Primeira Descida: " + primeiraDescida + " --- Posicao primeira Descida: " + posicaoPrimeiraDescida);

        return posicaoPrimeiraDescida;
    }


    
}
