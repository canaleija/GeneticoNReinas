/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnicas;

import com.sun.org.apache.xml.internal.serialize.IndentPrinter;
import geneticonreinas.data.Individuo;
import java.util.Random;

/**
 *
 * @author CANALEIJA
 */
public class TecnicasMuta {
    
    public static void cruza2Puntos(Individuo ind){
        Random ran = new Random();
        int p1 = ran.nextInt(ind.getCromosoma().length);
        int p2 = ran.nextInt(ind.getCromosoma().length);
        
        while(p1==p2){
         
         p2 = ran.nextInt(ind.getCromosoma().length);
        
        }
        int aux = ind.getCromosoma()[p1];
        ind.getCromosoma()[p1] = ind.getCromosoma()[p2];
        ind.getCromosoma()[p2]=aux;
        
    }
    
}
