/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnicas;

import java.util.Random;

/**
 *
 * @author CANALEIJA
 */
public class Mascara {
    
    
    public static int[] generaMascaraAleatoria(int dim){
    
        int mascara[] = new int[dim];
        Random ran = new Random();
        for (int x = 0 ; x < dim; x++)
            mascara[x] = ran.nextInt(2);
        
        return mascara;
    }
    
    
}
