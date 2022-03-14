/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarResistor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Projecao {
    
    public static int FundoPretoOuBranco(BufferedImage imagem){
        int flag =0;
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        int preto =0;
        int branco = 0;
        
        for(int y=0; y < altura; y++){
            for(int x =0; x < largura; x++){
                Color cor = new Color(imagem.getRGB(x, y));
                int azul = cor.getBlue();
                if(azul == 0)
                    preto +=1;
                else
                    branco +=1;
            }
        }
        if(preto >= branco)
            flag = 1;
        else flag =0;
        System.out.println(flag);
        return flag;
    }
    
    public static ArrayList HistogramaHorizontal(BufferedImage imagem, int flag){
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        
        int[] histogramaHorizontal = new int[altura];
        
        for(int z= 0; z< altura; z++) histogramaHorizontal[z] =0;
        
        for(int y=0; y < altura; y++){
            for(int x =0; x < largura; x++){
                Color cor = new Color(imagem.getRGB(x, y));
                int azul = cor.getBlue();
                if(flag == 0){
                    if(azul == 0)
                        histogramaHorizontal[y] +=1;
                }
                else{
                    if(azul > 0)
                        histogramaHorizontal[y] +=1;
                }
            }
        }
        int primeiro = 0;
        int segundo = 0;
        int aux = 0;
        int count = 0;
        for(int i=0; i<altura; i++){
            if(histogramaHorizontal[i] >= 1){
                aux += histogramaHorizontal[i];
                count++;
            }
//            System.out.println(histogramaHorizontal[i]);
        }
//      System.out.println(aux);
        aux /= count;
        aux *= 1.1;
        System.out.println("media "+aux);
        for(int i=0; i<altura; i++){
            if(histogramaHorizontal[i] >= aux){
                if(primeiro == 0)
                    primeiro = i;
                else i = altura+1;
            }
        }
       
        System.out.println("primeiro "+ primeiro);
        
        for(int i=altura-1; i > 0; i--){
            if(histogramaHorizontal[i] >= aux){
                if(segundo == 0)
                    segundo = i;
                else i = 0;
            }
        }
        System.out.println("segundo "+ segundo);
        ArrayList retorno = new ArrayList();
        retorno.add(histogramaHorizontal);
        retorno.add(primeiro);
        retorno.add(segundo);
        
//        System.out.println("tamanho"+histogramaHorizontal.length);
//        return histogramaHorizontal;
        return retorno;
    }
    
    
    public static ArrayList HistogramaVertical(BufferedImage imagem, int flag){
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        
        int[] histogramaVertical = new int[largura];
        
        for(int z= 0; z< largura; z++) histogramaVertical[z] =0;
        
        for(int y=0; y < largura; y++){
            for(int x =0; x < altura; x++){
                Color cor = new Color(imagem.getRGB(y, x));
                int azul = cor.getBlue();
                if(flag == 0){
                    if(azul == 0)
                        histogramaVertical[y] +=1;
                }
                else{
                    if(azul > 0)
                        histogramaVertical[y] +=1;
                }
            }
        }
        
        int primeiro = 0;
        int segundo = 0;
        int aux = 0;
        int count = 0;
        for(int i=0; i<largura; i++){
            if(histogramaVertical[i] >= 1){
                aux += histogramaVertical[i];
                count++;
            }
//            System.out.println(histogramaVertical[i]);
        }
//      System.out.println(aux);
        aux /= count;
        aux *= 1.1;
        System.out.println("media "+aux);
        
        for(int i=0; i<largura; i++){
            if(histogramaVertical[i] >= aux){
                if(primeiro == 0)
                    primeiro = i;
                else i = largura+1;
            }
        }
        System.out.println("primeiro "+ primeiro);
        
        for(int i=largura-1; i > 0; i--){
            if(histogramaVertical[i] >= aux){
                if(segundo == 0)
                    segundo = i;
                else i = 0;
            }
        }
        System.out.println("segundo "+ segundo);
//        System.out.println("tamanho"+histogramaVertical.length);
        ArrayList retorno = new ArrayList();
        retorno.add(histogramaVertical);
        retorno.add(primeiro);
        retorno.add(segundo);
//        return histogramaVertical;
        return retorno;
    }
    
    
    
    
    public static ArrayList HistogramaRGB(BufferedImage imagem){
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        
        float[] histogramaRed = new float[largura];
        float[] histogramaGreen = new float[largura];
        float[] histogramaBlue = new float[largura];
        
        for(int z= 0; z< largura; z++)
        {
            histogramaRed[z] = 0;
            histogramaGreen[z] = 0;
            histogramaBlue[z] = 0;
        }
        
        for(int y=0; y < largura; y++){
            for(int x =0; x < altura; x++){
                
                Color cor = new Color(imagem.getRGB(y, x));
                
                int Red = cor.getRed();
                int Green = cor.getGreen();
                int Blue = cor.getBlue();
                
                histogramaRed[y] += Red;
                histogramaGreen[y] += Green;
                histogramaBlue[y] += Blue;
                
                //System.out.println("Vermelho:"+ Red + " - Verde:" + Green + " - Blue:" + Blue );
            }
            histogramaRed[y] /= altura;
            histogramaGreen[y] /= altura;
            histogramaBlue[y] /= altura;
                
        }
       
        ArrayList retorno = new ArrayList();
        retorno.add(histogramaRed);
        retorno.add(histogramaGreen);
        retorno.add(histogramaBlue);
//        return histogramaVertical;
        return retorno;
    }
}