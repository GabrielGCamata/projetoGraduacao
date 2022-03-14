/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncontrarResistor;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gabri
 */
public class GeraGrafico {
    

    public static void GeraGrafico(int[] histograma, String nome, File pasta) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i =0; i < histograma.length; i++){
            dataset.addValue(histograma[i], "teste", ""+i);       
        }
        JFreeChart criaGrafico = ChartFactory.createLineChart(nome,
                null, null, dataset, PlotOrientation.VERTICAL,true,true,false);
        try {
            OutputStream png = new FileOutputStream(pasta+"\\"+nome+".png");
            ChartUtilities.writeChartAsPNG(png, criaGrafico, 600, 600);
            png.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void GeraGrafico(float[] histograma, String nome, File pasta) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i =0; i < histograma.length; i++){
            dataset.addValue(histograma[i], "teste", ""+i);       
        }
        JFreeChart criaGrafico = ChartFactory.createLineChart(nome,
                null, null, dataset, PlotOrientation.VERTICAL,true,true,false);
        try {
            OutputStream png = new FileOutputStream(pasta+"\\"+nome+".png");
            ChartUtilities.writeChartAsPNG(png, criaGrafico, 600, 600);
            png.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void GeraGrafico(float[] histogramaVermelho,float[] histogramaVerde,float[] histogramaAzul, String nome, File pasta) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i =0; i < histogramaVermelho.length; i++){
            dataset.addValue(histogramaVermelho[i], "histogramaVermelho", ""+i);
            dataset.addValue(histogramaAzul[i], "histogramaAzul", ""+i);
            dataset.addValue(histogramaVerde[i], "histogramaVerde", ""+i);
        }
        JFreeChart criaGrafico = ChartFactory.createLineChart(nome,
                null, null, dataset, PlotOrientation.VERTICAL,true,true,false);
        try {
            OutputStream png = new FileOutputStream(pasta+"\\"+nome+".png");
            ChartUtilities.writeChartAsPNG(png, criaGrafico, 600, 600);
            png.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void GeraGraficoSomaRGB(float[] histogramaVermelho,float[] histogramaVerde,float[] histogramaAzul, String nome, File pasta) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i =0; i < histogramaVermelho.length; i++){
            dataset.addValue(histogramaVermelho[i] + histogramaAzul[i] + histogramaVerde[i], "histogramaVermelho", ""+i);
        }
        JFreeChart criaGrafico = ChartFactory.createLineChart(nome,
                null, null, dataset, PlotOrientation.VERTICAL,true,true,false);
        try {
            OutputStream png = new FileOutputStream(pasta+"\\"+nome+".png");
            ChartUtilities.writeChartAsPNG(png, criaGrafico, 600, 600);
            png.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
