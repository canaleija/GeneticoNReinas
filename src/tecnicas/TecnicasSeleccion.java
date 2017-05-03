/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnicas;

import geneticonreinas.data.Individuo;
import geneticonreinas.data.Poblacion;
import java.util.Random;

/**
 *
 * @author CANALEIJA
 */
public final class TecnicasSeleccion {
  
    public static Individuo seleccionarIndividuo(
                          Poblacion pob,
                          TipoSeleccion tipo){
       Individuo aux = null;
       switch (tipo){
      
          case RULETA:{
              int fitnessPob = pob.getFitnessPoblacion();
              double posicion = fitnessPob * Math.random();
        
              double suma = 0;
              // generando la ruleta
        for (Individuo ind: pob.getPoblacion()){
          suma += ind.getFitness();
          
          if (suma>=posicion){
            aux = new Individuo(ind.getCromosoma());
          }
                 
        }
       aux = new Individuo(pob.getPoblacion().get(0).getCromosoma()) ;
              
              
              break;
          }
          case ALEATORIO:{
               Random ran = new Random();
               int pos = ran.nextInt(pob.getTamPob());
               aux = new Individuo(pob.getPoblacion().get(pos).getCromosoma());
              break;
          }
          case TORNEO:{
              aux = new Individuo(pob.getMejor().getCromosoma());
              break;
          }
          default:{
           aux = null;
          }
         
      }
       return aux;
    }
    
   
    
    public enum TipoSeleccion{
        RULETA,
        ALEATORIO,
        TORNEO
    }
    
}
