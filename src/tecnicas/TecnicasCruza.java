/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnicas;

import geneticonreinas.data.Individuo;

/**
 *
 * @author CANALEIJA
 */
public final class TecnicasCruza {
    
    
    public enum TipoCruza {
       MASCARA,INDICE
       
    }
    
    public static Individuo cruzaIndice(int n, Individuo padre, 
                     Individuo madre){
        
        int auxGeno2[] = new int[padre.getCromosoma().length];
        int auxGeno[] = new int[padre.getCromosoma().length];
        // recorremos el genotipo/cromosoma
        
        for (int x=0; x <n;x++){
          auxGeno[x] += padre.getCromosoma()[x];
          auxGeno2[x] += madre.getCromosoma()[x];
                           
        }
        
        for (int x=padre.getCromosoma().length-1; x >=n;x--){
          auxGeno[x] += madre.getCromosoma()[x];
          auxGeno2[x] += padre.getCromosoma()[x];
                           
        }
        //verificar que hijo es el mejor
        Individuo hijo1 = new Individuo(auxGeno);
        Individuo hijo2 = new Individuo(auxGeno2);
               
        // retornamos el mejor hijo
        
        if (hijo1.getFitness()>= hijo2.getFitness()){
            return hijo1;}
        else {
        return hijo2;
        }
              
    }
    
    public static Individuo cruzMascara(int[]mascara,
                     Individuo padre, Individuo madre){
         int aux[]= new int[mascara.length];
        
        // recorremos las mascara
        for (int x =0 ; x < mascara.length;x++){
         
            if (mascara[x]==1){
             aux[x]= padre.getCromosoma()[x];
             } else{
            aux[x] = madre.getCromosoma()[x];
            }
           
        
        }
        return new Individuo(aux);
     
    }
}
