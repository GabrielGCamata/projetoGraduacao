/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarFaixa;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author gabri
 */
public class RecortaImagem {
    public static BufferedImage Recortar(BufferedImage imagemEntrada,int x_inicio, int x_final){
        BufferedImage imagem_saida = null;
        imagem_saida = new BufferedImage(imagemEntrada.getWidth(),imagemEntrada.getHeight(), BufferedImage.TYPE_INT_RGB);
        imagem_saida = imagemEntrada.getSubimage(x_inicio, 0 ,x_final - x_inicio ,imagemEntrada.getHeight());
        
        return imagem_saida;
    }
}
