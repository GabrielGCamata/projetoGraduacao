/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarFaixa;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author gabri
 */
public class IdentificarCoresTcc {
    //static String cores = "img10";
    /**
     * @param args the command line arguments
     */
    public static void main(String nome_imagem, String nome, String pasta_salvar) {
        
        File inputFile = new File(nome_imagem);
        File pastaSalvar = (new File(pasta_salvar+"\\"+nome+" Resultado"));
        pastaSalvar.mkdir();
        try {
            BufferedImage imagem_entrada = ImageIO.read(inputFile);
            ArrayList histogramaRGB = Histograma.HistogramaRGB(imagem_entrada);
            GeraGrafico.GeraGrafico((float[]) histogramaRGB.get(0),(float[]) histogramaRGB.get(1),(float[]) histogramaRGB.get(2),"histograma Vermelho",pastaSalvar);
//            GeraGrafico.GeraGrafico((float[]) histogramaRGB.get(1),"histograma Verde",pastaSalvar);
//            GeraGrafico.GeraGrafico((float[]) histogramaRGB.get(2),"histograma Azul",pastaSalvar);
            
        float histogramaSoma[] = GeraGrafico.GeraGraficoSomaRGB(
                    (float[]) histogramaRGB.get(0),
                    (float[]) histogramaRGB.get(1),
                    (float[]) histogramaRGB.get(2),
                    "histograma Soma Canais RGB",
                    pastaSalvar
            );

        
        float mediana = Mediana.media(histogramaSoma);
        GeraGrafico.GeraGraficoSomaRGB(
                    (float[]) histogramaRGB.get(0),
                    (float[]) histogramaRGB.get(1),
                    (float[]) histogramaRGB.get(2),
                    mediana,
                    "histograma Soma Canais RGB",
                    pastaSalvar
            );
        System.out.println("Mediana: " + mediana);
        
        ArrayList pontosInteresse = SubidaDescida.PontoDeInteresse(histogramaSoma, mediana);//Mediana.PontosAcimaMediana(histogramaSoma, mediana);
        
        
        for(int i = 0; i < pontosInteresse.size(); i++){
            BufferedImage imagemFaixa;
            File imagemRecortada;
            
            if((int)pontosInteresse.get(i) +(int) (0.08 * histogramaSoma.length) < histogramaSoma.length)
            {
                imagemFaixa = RecortaImagem.Recortar(imagem_entrada,(int)pontosInteresse.get(i),(int)pontosInteresse.get(i) +(int) (0.05 * histogramaSoma.length));
                imagemRecortada = new File(pastaSalvar+"\\faixa"+i +".jpg");
                ImageIO.write(imagemFaixa, "jpg",imagemRecortada);
                System.out.println(pontosInteresse.get(i)+ " -" + ((int)pontosInteresse.get(i)+(int) (0.08 * histogramaSoma.length)));
            }
        }
        SubidaDescida.PontoDeInteresse(histogramaSoma, mediana);
        
        
        
//            imprimirCanalRGB(imagem_entrada);
        } catch (IOException ex) {
            Logger.getLogger(IdentificarCoresTcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public static void testes(){
//        int descida = SubidaDescida.Descida(histogramaSoma, 0, media);
//        int subida = SubidaDescida.Subida(histogramaSoma, descida, media);
//        BufferedImage imagemFaixa;
//        File imagemRecortada;
//        
//        imagemFaixa = RecortaImagem.Recortar(imagem_entrada,descida,subida);
//        imagemRecortada = new File(pastaSalvar+"\\"+cores+"faixa1.jpg");
//        ImageIO.write(imagemFaixa, "jpg",imagemRecortada);
        
//        descida = SubidaDescida.Descida(histogramaSoma, subida, media);
//        subida = SubidaDescida.Subida(histogramaSoma, descida, media);
        
//        descida = SubidaDescida.Descida(histogramaSoma, (int) (1.5*subida), media);
//        subida = SubidaDescida.Subida(histogramaSoma, descida, media);
//        
//        imagemFaixa = RecortaImagem.Recortar(imagem_entrada,descida,subida);
//        imagemRecortada = new File(pastaSalvar+"\\"+cores+"faixa2.jpg");
//        ImageIO.write(imagemFaixa, "jpg",imagemRecortada);
//        
//        descida = SubidaDescida.Descida(histogramaSoma, (int) (1.0*subida), media);
//        subida = SubidaDescida.Subida(histogramaSoma, descida, media);
//        
//        imagemFaixa = RecortaImagem.Recortar(imagem_entrada,descida,subida-descida >= 18 ? subida-descida >= 30 ? (int)(subida*0.9) : (int)(subida*0.95) : subida);
//        imagemRecortada = new File(pastaSalvar+"\\"+cores+"faixa3.jpg");
//        ImageIO.write(imagemFaixa, "jpg",imagemRecortada);
//        
//        descida = SubidaDescida.Descida(histogramaSoma, (int) (subida), media);
//        subida = SubidaDescida.Subida(histogramaSoma, descida, media);
//        
//        imagemFaixa = RecortaImagem.Recortar(imagem_entrada, subida-descida ==0 ? (int)(descida *0.7) : descida,subida-descida == 0 ? (int)(subida*0.8) : subida);
//        imagemRecortada = new File(pastaSalvar+"\\"+cores+"faixa4.jpg");
//        ImageIO.write(imagemFaixa, "jpg",imagemRecortada);
    }
    
}
