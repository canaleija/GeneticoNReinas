/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticonreinas;

import geneticonreinas.data.Individuo;

/**
 *
 * @author CANALEIJA
 */
public class GeneticoNReinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        GeneticoV1 gen = new GeneticoV1(1000, 30, 0.25, 500);
        gen.evoluciona();
        
         System.out.println();
    
    }
    
}
