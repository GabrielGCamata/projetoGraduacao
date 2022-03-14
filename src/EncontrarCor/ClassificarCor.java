/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarCor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.abs;
import javax.imageio.ImageIO;

/**
 *
 * @author gabri
 */
public class ClassificarCor {
    
    public static int ClassificarCor(String nome_imagem, String nome, String pasta_saida) throws IOException{
        BufferedImage imagem = null;
        
        File inputFile = new File(nome_imagem);
        
        int cores[] = new int[11];
        int classe = 10;
       
        String caminho = "base2.txt";
        imagem = ImageIO.read(inputFile);
        
        for(int y=0; y < imagem.getHeight(); y++){
            
            for(int x =0; x < imagem.getWidth(); x++){
                
                Color cor = new Color(imagem.getRGB(x, y));
                int azul = cor.getBlue();
                int vermelho = cor.getRed();
                int verde = cor.getGreen();
                
                //classe = leitor(caminho, vermelho, azul, verde);
                classe = KNN(caminho, vermelho, azul, verde);
                cores[classe] = cores[classe] + 1;
            }
        }
        
        /*for (int y=0; y < 11; y++){
            System.out.println(cores[y]);
        }*/
        //System.out.println(DefineCor(pasta_saida, cores));
        return RetornaValor(cores);
    }
    
    public static int RetornaValor(int cores[]){
        int quantidade = 0;
        
        for(int i = 0; i < 11; i++){
            if(quantidade < cores[i]){
                quantidade = cores[i];
            }
        }
        
        int index = indexOfIntArray(cores, quantidade);
        
        return index;
    }
    
    
    public static String DefineCor(String pasta_saida, int[] cores){
        
        int quantidade = 0;
        String cor = "";
        
        for(int i = 0; i < 11; i++){
            if(quantidade < cores[i]){
                quantidade = cores[i];
            }
        }
        
        int index = indexOfIntArray(cores, quantidade);
        
        if(index == 0)
        {
            return "preto";
        }
        if(index == 1)
        {
            return "marrom";
        }
        if(index == 2)
        {
            return "vermelho";
        }
        if(index == 3)
        {
            return "laranja";
        }
        if(index == 4)
        {
            return "amarelo";
        }
        if(index == 5)
        {
            return "verde";
        }
        if(index == 6)
        {
            return "azul";
        }
        if(index == 7)
        {
            return "violeta";
        }
        if(index == 8)
        {
            return "cinza";
        }
        
        return "branco";
    }
    
    public static int indexOfIntArray(int[] array, int key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }
    
    public static int leitor(String path, int red, int blue, int green) throws IOException {        
        float menorDistancia = 5000;
        int classe = 10;
        float distancia = 0;
        
        
        FileInputStream stream = new FileInputStream(path);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        while(linha != null) {
            String array[] = linha.split(",");
            
            if(!array[0].isEmpty() && !array[1].isEmpty() && !array[2].isEmpty() && !array[3].isEmpty()){
            
                distancia = DistanciaEuclidiana(red, Float.parseFloat(array[0].trim()), blue, Float.parseFloat(array[1].trim()), green, Float.parseFloat(array[2].trim()));

                if(menorDistancia > distancia){
                    menorDistancia = distancia;
                    classe = Integer.parseInt(array[3].trim());
                }
            }
            linha = br.readLine();
        }
        
        return classe;
    }
    
    public static float DistanciaManhattan(float x1, float x2, float x3, float y1, float y2, float y3)
    {   
        return (float) (Math.sqrt(Math.pow((x1 - y1), 2)) + Math.sqrt(Math.pow((x2 - y2), 2)) + Math.sqrt(Math.pow((x2 - y2), 2)));
        
    }
    
     public static float DistanciaEuclidiana(float x, float x1,float y, float y1, float z, float z1){
        float distancia = 0;
        
        float soma = (float) (Math.pow((x1 - x),2) + Math.pow((y1 - y),2) + Math.pow((z1 - z),2));
        distancia = (float) Math.sqrt(soma);
        
        return distancia;
    }
     
    public static int KNN(String path, int red, int blue, int green) throws IOException{
        float menorDistancia = 5000;
        int classe = 10;
        float distancia = 0;
        float distanciaAnterior = Float.MIN_VALUE;
        boolean flag = true;
        int classes[] = new int[7];
        int k = 7;
        
        for(int i =0; i < k; i++){
            FileInputStream stream = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);
            String linha = br.readLine();
            while(linha != null) {
                String array[] = linha.split(",");

                if(!array[0].isEmpty() && !array[1].isEmpty() && !array[2].isEmpty() && !array[3].isEmpty()){



                        distancia = DistanciaEuclidiana(red, Float.parseFloat(array[0].trim()), blue, Float.parseFloat(array[1].trim()), green, Float.parseFloat(array[2].trim()));

                        
                        if(menorDistancia > distancia && distanciaAnterior < menorDistancia){

                            menorDistancia = distancia;
                            classe = Integer.parseInt(array[3].trim());
                        }
                        
                        if(flag)
                        {
                            distanciaAnterior = menorDistancia;
                        }

                        flag = false;
                }
                linha = br.readLine();
            }
            classes[classe] += 1;
        }
        
        
        return MaisRepetido(classes);
    } 
    
    public static int MaisRepetido(int cores[]){
        int maior = Integer.MIN_VALUE;
        int indiceMaior = -1;
        for (int i = 0; i < cores.length; i++) {
            if (cores[i] > maior) {
                maior = cores[i];
                indiceMaior = i;
            }
        }
        return indiceMaior;
    }
  
    
}
