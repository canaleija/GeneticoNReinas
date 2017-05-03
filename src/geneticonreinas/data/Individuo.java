/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticonreinas.data;

import java.util.Random;

/**
 *
 * @author CANALEIJA
 */
public class Individuo {
    // representación genotipica
    private int[]cromosoma;
    private int dimTablero;
    private int fitness;
    // ataques descendentes y ascendentes
    private int[]diagonalAsc;
    private int[]diagonalDesc;

    // creacion aleatoria/default
    public Individuo(int dimTab) {
    this.cromosoma = new int[dimTab];
    this.dimTablero = dimTab;
    this.fitness = 0; 
    calculaDiagonales();
    calculaFitness();
    }
    // creacion en base a un genotipo
    public Individuo (int[] cromosma){
     this.cromosoma = cromosma;
     this.dimTablero = cromosma.length;
     calculaDiagonales();
     calculaFitness();
    }
    
    public void calculaFitness(){
      // declaramos acumuladores
      int sumaDA = 0;
      int sumaDD = 0;
      int sumaRen = 0;
      int funcion = 0;
      int sumaAux = 0;
      
      // recorrer el tablero 
      for (int x=0; x < this.dimTablero;x++){
         for (int y=x+1; y < this.dimTablero;y++){
          
             // calcular los ataques por renglon 
             if ((this.cromosoma[x]==this.cromosoma[y]) && (y < this.dimTablero)){
             sumaRen +=1;
             }
             // calcular de descendentes  
             if((this.diagonalDesc[x]==this.diagonalDesc[y]) && (y< this.diagonalDesc.length)){
             sumaDD +=1;
             }
               // calcular de ascendentes  
             if((this.diagonalAsc[x]==this.diagonalAsc[y]) &&( y< this.diagonalAsc.length)){
             sumaDA +=1;
             }
          }
             // resultados parciales
         sumaAux = sumaRen + sumaDA + sumaDD;
         funcion+=sumaAux;  
         sumaDA =0;
         sumaRen = 0;
         sumaDD = 0;
         }
        this.fitness = funcion;
      }
      
    public void calcularIndividuoAleatorio() {
        //creacion individuo aleatorio
        Random ran = new Random();
        for (int gen=0; gen<dimTablero;gen++){
          int alelo = ran.nextInt(dimTablero);
          this.cromosoma[gen] = alelo;
        }
       
    }
    
    public void calcularIndividuoSinConflicto() {
        //creacion individuo aleatorio sin conflicto
        // de renglones
        // posicion 
        Random ran = new Random();
        
        for (int x =0; x <this.dimTablero;x++){
        
            int aux = ran.nextInt(this.dimTablero);
            // garantizando que todo el cromosoma sea 
            // llenado
            while(this.cromosoma[aux]!=0){
              aux = ran.nextInt(this.dimTablero);
            }
            
            this.cromosoma[aux]=x;
           
        }
     
    }

    /**
     * @return the cromosoma
     */
    public int[] getCromosoma() {
        return cromosoma;
    }

    /**
     * @param cromosoma the cromosoma to set
     */
    public void setCromosoma(int[] cromosoma) {
        this.cromosoma = cromosoma;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        calculaFitness();
        return fitness;
    }

    private void calculaDiagonales() {
        
        this.diagonalAsc = new int[dimTablero];
        this.diagonalDesc = new int[dimTablero];
        
        // crear las diagonales
        for(int x=0; x < this.dimTablero;x++){
          this.diagonalAsc[x] = this.cromosoma[x]+x;
          this.diagonalDesc[x] = this.cromosoma[x]-x;
        }
    
    }

    @Override
    public String toString() {
        
  String aux ="[";
      
        for (int x=0;x<cromosoma.length;x++)
                 aux += cromosoma[x]+","; 
        
        aux+="]: "+fitness;
        return aux;
    }
    
    
    
    
}
