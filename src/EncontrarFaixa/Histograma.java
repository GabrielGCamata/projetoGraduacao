/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarFaixa;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Histograma {
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
                
            }
            histogramaRed[y] /= altura;
            histogramaGreen[y] /= altura;
            histogramaBlue[y] /= altura;
                
        }
        histogramaRed = filtroMedia(histogramaRed);
        histogramaGreen = filtroMedia(histogramaGreen);
        histogramaBlue = filtroMedia(histogramaBlue);
       
        ArrayList retorno = new ArrayList();
        retorno.add(histogramaRed);
        retorno.add(histogramaGreen);
        retorno.add(histogramaBlue);
        return retorno;
    }
    
    public static float[] filtroMedia(float[] histograma)
    {
        float media = (float) 0.0;
        float[] histogramaRetorno = new float[histograma.length];
        int count2,count;
        int qntPixelMedia = 4;
        
        for(int i = qntPixelMedia; i < histograma.length - qntPixelMedia; i ++)
        {   
            media = 0;
            for(count = 0, count2 = i - qntPixelMedia; count < qntPixelMedia; count++, count2++){
                media = histograma[count] + histograma[count2] + media;
            }
            histogramaRetorno[i] = media/(2*qntPixelMedia);
            //System.out.println(histogramaRetorno[i]);
        }
        return histogramaRetorno;
    }
    
//    if(i == 0)
//            {
//                for(int j = i; j < i + 3; j++){
//                    media += histograma[j];
//                }
//                media /= 3;
//            }
//            if(i == 1)
//            {
//                for(int j = i-1; j < i + 3; j++){
//                    media += histograma[j];
//                }
//                media /= 4;
//            }
//            if(i == histograma.length -1)
//            {
//                for(int j = i-1; j < i - 4; j++){
//                    media += histograma[j];
//                }
//                media /= 3;
//            }
//            if(i == histograma.length -2)
//            {
//                for(int j = i-1; j < i - 4; j++){
//                    media += histograma[j];
//                }
//                media /= 4;
//            }
//            else
//            {
//                for(int j = i-2; j < i + 3; j++)
//                {
//                    media += histograma[j];
//                }
//                media /=5;
//            }
}
