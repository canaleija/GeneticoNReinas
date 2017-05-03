/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticonreinas;

import geneticonreinas.data.Grafica;
import geneticonreinas.data.Individuo;
import geneticonreinas.data.Poblacion;
import java.util.ArrayList;
import tecnicas.TecnicasSeleccion;

/**
 *
 * @author CANALEIJA
 */
public class GeneticoV1 {
    
    // campos obligados
    private int tamPob,generaciones;
    private double probMuta;
    private Poblacion poblacion;
    private int noReinas;

    
    public GeneticoV1(int generaciones, 
              int tamPob, double probMuta,int noReinas) {
      this.generaciones = generaciones;
      this.tamPob = tamPob;
      this.probMuta = probMuta;
      this.noReinas = noReinas;
    
    }
    // ejecucion inicial
    public void evoluciona(){
    
        // generar la población inicial
        this.poblacion = new Poblacion(tamPob, noReinas);
        this.poblacion.generarPoblacionInicial(Poblacion.TipoInd.SIN_CONFLICTO);
        // arreglo para graficar
        int mejores[] = new int[this.generaciones];
        
        for(int x=0;x<this.generaciones;x++){
            
             // construir la generacion
            Poblacion pobAux = new Poblacion(tamPob, noReinas);
            int mascara[] = tecnicas.Mascara.generaMascaraAleatoria(noReinas);
            for(int y=0;y<this.tamPob;y++){
               // seleccionar
                Individuo padre = tecnicas.TecnicasSeleccion.seleccionarIndividuo(this.poblacion, 
                        TecnicasSeleccion.TipoSeleccion.TORNEO);
                Individuo madre = tecnicas.TecnicasSeleccion.seleccionarIndividuo(this.poblacion,
                         TecnicasSeleccion.TipoSeleccion.TORNEO);
               //cruzar
                
                Individuo hijo = tecnicas.TecnicasCruza.cruzMascara(mascara, padre, madre);
                
                if (verificarMuta()){
                 tecnicas.TecnicasMuta.cruza2Puntos( hijo);
                }
                 pobAux.getPoblacion().add(hijo);
                //agregamos al ind a pobAux
            }
            // actualizar la población
            this.poblacion.actualizarPoblacion(pobAux.getPoblacion());
            mejores[x] = this.poblacion.getMejor().getFitness();
            System.out.println("E:"+x+" F:"+mejores[x]);
           if (mejores[x]==0){
           //break;
           }
        
        }
        System.out.println(this.poblacion.getMejor().toString());
        // graficar
        
//        Grafica grafica = new Grafica("Evolución Individuos", "Epoca", "Fitness");
//        grafica.agregarSerie(mejores, "Mejores Individuos");
//        grafica.mostrarGrafica();
        
        
    }

    private boolean verificarMuta() {
        
        if (probMuta>=Math.random()){
            return true;}else{return false;}
    }
    
    
    
}
