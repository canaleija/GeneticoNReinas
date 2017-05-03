/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticonreinas.data;

import java.util.ArrayList;

/**
 *
 * @author CANALEIJA
 */
public class Poblacion {

    // tamaño de población
    private int tamPob;
    // población
    private ArrayList<Individuo> poblacion;
    private int n;
    // fitness poblacion
    private int fitnessPoblacion;
    
    
    public Poblacion(int tamPob,int n) {
      this.tamPob = tamPob;
      this.poblacion = new ArrayList<>();
      this.n = n;
    }
    
    public void generarPoblacionInicial(TipoInd tipo){
      
        switch (tipo){
        
            case ALEATORIO:{
            
                for (int x=0; x < tamPob;x++){
                  Individuo aux = new Individuo(n);
                  aux.calcularIndividuoAleatorio();
                  this.poblacion.add(aux);
                }
                
                break;
                 
            }
            case SIN_CONFLICTO:{
              for (int x=0; x < tamPob;x++){
                  Individuo aux = new Individuo(n);
                  aux.calcularIndividuoSinConflicto();
                  this.poblacion.add(aux);
                }
                
                break;
            
            }
            default:{
            
            this.poblacion.add(null);
            }
        
        }
               
    }
    
    public void actualizarPoblacion(ArrayList<Individuo> pob){
        // eliminamos los elementos de la lista
        this.poblacion.clear();
        for (Individuo aux: pob){
        
        this.poblacion.add(new Individuo(aux.getCromosoma()));
        }
       
    }
    // RETORNA AL MEJOR INDIVIDUO DE LA CLASE
    public Individuo getMejor(){
       int mejor = 0;
       for (int x=1;x<this.tamPob;x++){
         if(this.poblacion.get(x).getFitness()<this.poblacion.get(mejor).getFitness()){
          mejor = x;
         }
       }
        // retornamos el mejor
        return this.poblacion.get(mejor);
    }
    
    
    
    /**
     * @return the tamPob
     */
    public int getTamPob() {
        return tamPob;
    }

    /**
     * @return the poblacion
     */
    public ArrayList<Individuo> getPoblacion() {
        return poblacion;
    }

    /**
     * @return the fitnessPob
     */
    public int getFitnessPoblacion(){
        this.fitnessPoblacion = calculaFitnessPoblacion();
        return this.fitnessPoblacion;
    }

    private int calculaFitnessPoblacion() {
       // recorremos la poblacion
      int suma=0;
      for (Individuo aux: this.poblacion)
          suma += aux.getFitness();
    
      return suma;
    }
    
    public enum TipoInd {SIN_CONFLICTO,ALEATORIO}
    
    
    
}
