/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarFaixa;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Mediana {
    
    
    public static ArrayList PontosAcimaMediana(float[] vetor, float mediana){
        ArrayList pontosAcimaMediana = new ArrayList();
        int i = 0;
        int count = 0;
        
        
        
        for(i = 0; i < vetor.length; i++)
        {
            float teste = abs(vetor[i] - mediana);
            if(teste <= 10 ){
                
                i+= 15;
                //System.out.println("posição: "+ i + " valor: " + vetor[i]);
                pontosAcimaMediana.add(i);
            }
        }
        return pontosAcimaMediana;
    }
    
    public static float media(float[] vetor) {
        float media = 0;
        
        for(int i = 0; i < vetor.length; i++){
            media += vetor[i];
        }
        return media/vetor.length;
    }
    
    public static float mediana(float[] vetor){
        float[] aux = new float[vetor.length];
        int verificarPar = 2;
        float mediana;
        int meio = aux.length/2;
        
        for(int i = 0; i < vetor.length ; i++)
        {
            aux[i] = vetor[i];
        }
        
        aux = quickSort(aux, 0, aux.length -1);
        
        if(aux.length % verificarPar == 0) 
        {    
            mediana = (aux[meio] + aux[meio - 1])/2;
            return (float) (mediana);
        }
        mediana = aux[meio];
        
        return (float) (mediana);
    }
    
    private static float[] quickSort(float[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
        
        return vetor;
    }
  
    private static int separar(float[] vetor, int inicio, int fim) {
        float pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else 
                if (pivo < vetor[f])
                    f--;
                else 
                {
                    float troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;
                }
             }
             vetor[inicio] = vetor[f];
             vetor[f] = pivo;
             return f;
       }
}
