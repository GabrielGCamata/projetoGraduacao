/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarResistor;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author gabri
 */
public class Limiarizacao {
    public static int[] Histograma(BufferedImage imagem_entrada_cinza){
        BufferedImage imagem_saida = null;
        int qntCol = imagem_entrada_cinza.getWidth();
        int qntLin = imagem_entrada_cinza.getHeight();
        int tipo = imagem_entrada_cinza.getType();
        Color cor;
        int[] histograma = new int[256];
        
        imagem_saida = new BufferedImage(qntCol, qntLin, BufferedImage.TYPE_BYTE_GRAY);
        
        int x, y, k;
        for(k=0; k < 256; k++){
            histograma[k] = 0;
        }
        for(y=0; y < qntLin; y++){
            
            for(x =0; x < qntCol; x++){
                cor = new Color(imagem_entrada_cinza.getRGB(x, y));
                int azul = cor.getBlue();
                histograma[azul] +=1;
            }
        }
//        for(int i=0; i<256; i++){
//            System.out.println(histograma[i]);
//        }
        return histograma;
    }
    
    public static BufferedImage Limiarizacao(BufferedImage imagem_entrada_cinza, int[] histograma){
        int qntLin =imagem_entrada_cinza.getHeight(),
                qntCol =imagem_entrada_cinza.getWidth(),
                qntPixel = qntLin*qntCol;
        BufferedImage imagem_saida = null;
        
        int threshold = calculoThreshold(imagem_entrada_cinza,histograma);
        int x, y;
        imagem_saida = new BufferedImage(qntCol, qntLin, BufferedImage.TYPE_BYTE_GRAY);
        for(y=0; y < qntLin; y++){
            
            for(x =0; x < qntCol; x++){
                Color cor = new Color(imagem_entrada_cinza.getRGB(x, y));
                int azul = cor.getBlue();
                if(azul < threshold){
                    cor = new Color(0,0,0);
                    imagem_saida.setRGB(x,y,cor.getRGB());
                }
                else{
                    cor = new Color(255,255,255);
                    imagem_saida.setRGB(x,y,cor.getRGB());
                }
            }
        }
        
        
        return imagem_saida;
    }
    
    public static int calculoThreshold(BufferedImage imagem_entrada_cinza, int[] histograma){ //OTSU
        int threshold = 0;
        
        int qntLin =imagem_entrada_cinza.getHeight(),
                qntCol =imagem_entrada_cinza.getWidth(),
                total = qntLin*qntCol;
       
        float soma = 0;
        for (int t=0 ; t<256 ; t++) 
            soma += t * histograma[t];

	float somaB = 0;
	int pesoFundo = 0; // peso Fundo
	int pesoResistor = 0; // peso Resistor
        float mediaFundo = 0;
        float mediaResistor = 0;
        
        float varMax = 0;
        float varianciaIntraClasse = 0;

        for (int t=0 ; t<256 ; t++)	{
            pesoFundo += histograma[t];			
            if (pesoFundo == 0) continue;

            pesoResistor = total - pesoFundo;			
            if (pesoResistor == 0) break;

            somaB += (float) (t * histograma[t]);

            mediaFundo = somaB / pesoFundo;			//media Fundo	
            mediaResistor = (soma - somaB) / pesoResistor;		//media Resistor

            
            varianciaIntraClasse = (float)pesoFundo * (float)pesoResistor * (mediaFundo - mediaResistor) * (mediaFundo - mediaResistor);	//Variancia InterClasse

            
            if (varianciaIntraClasse > varMax) {
            	varMax = varianciaIntraClasse;
		threshold = t;
            }
	}
        System.out.println("O threshold foi de: "+ threshold);
        return threshold;
    }
   
}