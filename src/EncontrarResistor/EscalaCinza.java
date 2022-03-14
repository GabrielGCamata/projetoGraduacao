/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarResistor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;


/**
 *
 * @author Gabriel Gomes Camata
 */
public class EscalaCinza {
    
    public static BufferedImage rgbToGray(BufferedImage imagem_entrada){
        BufferedImage imagem_saida = null;
        int qntCol = imagem_entrada.getWidth();
        int qntLin = imagem_entrada.getHeight();
        int tipo = imagem_entrada.getType();
        Color cor;
        int azul,vermelho, verde;
        int media;
        int teste;
        imagem_saida = new BufferedImage(qntCol, qntLin, BufferedImage.TYPE_INT_RGB);
        
        int x, y;
        for(y=0; y < imagem_entrada.getHeight(); y++){
            
            for(x =0; x < imagem_entrada.getWidth(); x++){
                cor = new Color(imagem_entrada.getRGB(x, y));
                azul = cor.getBlue();
                vermelho = cor.getRed();
                verde = cor.getGreen();
                
                media = (vermelho+azul+verde)/3;
                //media =  (int) ((0.33*vermelho) + (0.56*verde) + (0.11*azul));
                
                cor = new Color(media,media,media);
                //cor = new Color((float)(0.33*vermelho/255),(float)(0.59*verde/255),(float)(0.11*azul/255));
                imagem_saida.setRGB(x, y, cor.getRGB());
                
            }
        }
        
        
        return imagem_saida;
    }
    
}