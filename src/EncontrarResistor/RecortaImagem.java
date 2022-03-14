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
public class RecortaImagem {
    public static BufferedImage recortar(BufferedImage imagem_entrada,int x_inicio, int x_final,int y_inicio,int y_final){
        BufferedImage imagem_saida = null;
        int qntCol = imagem_entrada.getWidth();
        int qntLin = imagem_entrada.getHeight();
        int tipo = imagem_entrada.getType();
        Color cor;
        imagem_saida = new BufferedImage(qntCol,qntLin, BufferedImage.TYPE_INT_RGB);
        
//        int x, y;
//        for(y=y_inicio; y < y_final; y++){ // 1309 1858 imagem 7   1889 2207 imagem2
//            
//            for(x =x_inicio; x < x_final; x++){ // 1792 3077 imagem7  2143 3291 imagem2
//                cor = new Color(imagem_entrada.getRGB(x, y));
//                imagem_saida.setRGB(x, y, cor.getRGB());
//                
//            }
//        }
//        int aux_x = x_inicio-x_final;
//        int aux_y = y_inicio-y_final;
//        int i;
//        int x;
//        int z;
//        int y;
//        for(i = 0,y = y_inicio; i < (aux_y); i++,y++){
//            for(z = 0,x = x_inicio; z < (aux_x); z++,x++){
//                cor = new Color(imagem_entrada.getRGB(x,y));
//                System.out.println("cor "+cor.getRGB());
//                imagem_saida.setRGB(i, z, cor.getRGB());                
//            }
//        }
        imagem_saida = imagem_entrada.getSubimage(x_inicio, y_inicio,x_final - x_inicio,y_final - y_inicio);
        
        return imagem_saida;
    }
}