/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticonreinas.data;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author CANALEIJA
 */
public class Grafica {
    
    private JFreeChart grafica;
    private XYSeriesCollection coleccion;
    private String tituloGrafica, axisXlabel, axisYlabel;

    
    public Grafica(String tituloGrafica,String axisXlabel, String axisYlabel ) {
         this.tituloGrafica = tituloGrafica;
         this.axisXlabel = axisXlabel;
         this.axisYlabel = axisYlabel;
        this.coleccion = new XYSeriesCollection();
        this.grafica = null;
    }
        
    public void agregarSerie(int[]valores,String nombreSerie){
      XYSeries serie = new XYSeries(nombreSerie);
      for (int x=0; x<valores.length;x++){
      serie.add(x, valores[x]);
      }
      this.coleccion.addSeries(serie);
    
    }

    public void mostrarGrafica() {
        // Crear la serie con los datos
        
        grafica = ChartFactory.createXYLineChart(this.tituloGrafica,
                this.axisXlabel, 
                this.axisYlabel, coleccion, PlotOrientation.VERTICAL, true, false, false);
              
        ChartFrame panel = new ChartFrame(null, grafica);
        panel.pack();
        panel.setVisible(true);
    }
    
    
}
