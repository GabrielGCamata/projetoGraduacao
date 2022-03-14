/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarResistor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author gabri
 */
public class Resistencia {
    public static void Resistencia(String nome_imagem, String nome, String pasta_saida){
        BufferedImage imagem_entrada = null;
        BufferedImage imagem_cinza = null;
        BufferedImage imagem_binaria = null;
        BufferedImage imagem_cortada = null;
//        String nome_imagem = "D:/Documentos/NetBeansProjects/resistor/imagem2.jpg";
        int[] histograma; 
        File inputFile = new File(nome_imagem);
        File pastaSalvar = (new File(pasta_saida+"\\"+nome+" Resultado"));
        pastaSalvar.mkdir();
        
        try {
            imagem_entrada = ImageIO.read(inputFile);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        imagem_cinza = EscalaCinza.rgbToGray(imagem_entrada);
        File saida_cinza = new File(pastaSalvar+"\\"+nome+"cinza.jpg");
        try {
            ImageIO.write(imagem_cinza, "jpg", saida_cinza);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        } // cria imagem cinza // cria imagem cinza
        
        
        histograma = Limiarizacao.Histograma(imagem_cinza);
        imagem_binaria = Limiarizacao.Limiarizacao(imagem_cinza, histograma);
        File saida_binario = new File(pastaSalvar+"\\"+nome+"binario.jpg");
        try {
            ImageIO.write(imagem_binaria, "jpg", saida_binario);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList horizontal,vertical;
        int flag = Projecao.FundoPretoOuBranco(imagem_binaria);
        horizontal = Projecao.HistogramaHorizontal(imagem_binaria,flag);
        vertical = Projecao.HistogramaVertical(imagem_binaria,flag);
        GeraGrafico.GeraGrafico(histograma,"histograma",pastaSalvar);
        GeraGrafico.GeraGrafico((int[]) vertical.get(0),"histograma vertical",pastaSalvar);
        GeraGrafico.GeraGrafico((int[]) horizontal.get(0),"histograma horizontal",pastaSalvar);
        imagem_cortada = RecortaImagem.recortar(imagem_entrada,(int) vertical.get(1),(int) vertical.get(2),(int) horizontal.get(1),(int) horizontal.get(2));
        File imagemRecortada = new File(pastaSalvar+"\\"+nome+"imagemRecortada.jpg");
        try {
            ImageIO.write(imagem_cortada, "jpg",imagemRecortada);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            imagem_entrada = ImageIO.read(imagemRecortada);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        imagem_cinza = EscalaCinza.rgbToGray(imagem_entrada);
        File saida_cinza2 = new File(pastaSalvar+"\\"+nome+"cinza2.jpg");
        try {
            ImageIO.write(imagem_cinza, "jpg", saida_cinza2);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        } // cria imagem cinza // cria imagem cinza
        
        
        histograma = Limiarizacao.Histograma(imagem_cinza);
        
        imagem_binaria = Limiarizacao.Limiarizacao(imagem_cinza, histograma);
        
        File saida_binario2 = new File(pastaSalvar+"\\"+nome+"binario2.jpg");
        try {
            ImageIO.write(imagem_binaria, "jpg", saida_binario2);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        flag = Projecao.FundoPretoOuBranco(imagem_binaria);
        horizontal = Projecao.HistogramaHorizontal(imagem_binaria,flag);
        vertical = Projecao.HistogramaVertical(imagem_binaria,flag);
        if((int) horizontal.get(2) - (int) horizontal.get(1) > 140){
            imagem_cortada = RecortaImagem.recortar(imagem_entrada,(int) vertical.get(1),(int) vertical.get(2),(int) horizontal.get(1),(int) horizontal.get(2));
            imagemRecortada = new File(pastaSalvar+"\\"+nome+"imagemRecortada2.jpg");
            try {
                ImageIO.write(imagem_cortada, "jpg",imagemRecortada);
            } catch (IOException ex) {
                Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            imagemRecortada = new File(pastaSalvar+"\\"+nome+"imagemRecortada2.jpg");
            try {
                ImageIO.write(imagem_cortada, "jpg",imagemRecortada);
            } catch (IOException ex) {
                Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        
        try {
            imagem_entrada = ImageIO.read(imagemRecortada);
        } catch (IOException ex) {
            Logger.getLogger(Resistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        
        ArrayList histogramaRGB = Projecao.HistogramaRGB(imagem_entrada);
        GeraGrafico.GeraGrafico((float[]) histogramaRGB.get(0),(float[]) histogramaRGB.get(1),(float[]) histogramaRGB.get(2),"histograma RGB",pastaSalvar);
        GeraGrafico.GeraGraficoSomaRGB((float[]) histogramaRGB.get(0),(float[]) histogramaRGB.get(1),(float[]) histogramaRGB.get(2),"histograma Soma Canais RGB",pastaSalvar);
    }
 
    
}
