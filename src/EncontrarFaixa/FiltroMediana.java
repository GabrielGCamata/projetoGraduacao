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
public class FiltroMediana {
    public static BufferedImage filtroMediana(BufferedImage imagem){
        Color cor = null;
        int media = 0;
        
        for(int x = 0; x < imagem.getHeight(); x++)
        {
            for(int y = 0; y < imagem.getWidth(); y++)
            {
                if(y == 0 || y == imagem.getWidth()-1)
                {
                    media = (imagem.getRGB(x, y) + imagem.getRGB(x, y + 1) + imagem.getRGB(x, y + 2))/3 ;
                    cor = new Color(media);
                }
                if(y == 1 || y == imagem.getWidth()-2)
                {
                    media = (imagem.getRGB(x, y - 1) + imagem.getRGB(x, y) + imagem.getRGB(x, y + 1) + imagem.getRGB(x, y + 2))/4 ;
                    cor = new Color(media);
                }
                else{
                    media = (imagem.getRGB(x, y - 2) + imagem.getRGB(x, y - 1) + imagem.getRGB(x, y) + imagem.getRGB(x, y + 1) + imagem.getRGB(x, y + 2))/5 ;
                    cor = new Color(media);
                }
                imagem.setRGB(x, y, cor.getRGB());
            }
        }
        return imagem;
    }
    
    
}
