
package uf2.practica.futbol.main;

import java.util.Scanner;
import static uf2.practica.futbol.primerNivellDescomposicio.PrimerNivellDescomposicio.inicialitzarArrayEquips;
import static uf2.practica.futbol.primerNivellDescomposicio.PrimerNivellDescomposicio.inicialitzarArrayPunts;
import static uf2.practica.futbol.primerNivellDescomposicio.PrimerNivellDescomposicio.mostrarMenu;
import static uf2.practica.futbol.primerNivellDescomposicio.PrimerNivellDescomposicio.tractarOpcio;
import static uf3.practica.futbol.persistenciaDades.PersistenciaDades.llegirFitxer;

/**
 * Aplicació informàtica en Java que gestiona les puntuacions d'una lliga esportiva.
 * Aquesta classe conté el mètode main, inicialitza les variables principals i crida les altres classes.
 * @author montseponsa
 * @version 08.03.2023
 */
public class UF2AppFutbol {

    public static int numMaxEquips = 20;
    public static int comptadorEquips = 5; //Porta el compte d'equips que estan introduïts a l'array general, es va augmentant cada cop que s'afegeix un equip
    public static Scanner teclat = new Scanner (System.in);
        

    public static void main(String[] args) {
        
        int menu = 0;
        boolean acabar = false;
        
        String[] equips2 = {"Barcelona", "Real Madrid", "Real Sociedad", "Athletic", "Osasuna"};
        int [][] puntsGols2 = {{14,12,1,1,37,33,5,28}, {14,11,2,1,35,33,14,19}, {14,8,2,4,26,19,17,2}, {14,7,3,4,24,24,14,10}, {14,7,2,5,23,16,14,2}};

        String[] equips = inicialitzarArrayEquips(equips2);
        int [][] puntsGols = inicialitzarArrayPunts(puntsGols2);
        
        //llegim el fitxer Equips.dat per extreure la informació dels equips i dels punts emmagatzemada
        llegirFitxer(equips, puntsGols);
        
        for (int i = 5; i < equips.length; i++){
            if (equips[i] != null){
                ++comptadorEquips;
            }
        }
        
        
        do{
            mostrarMenu();
            acabar = tractarOpcio(menu, equips, puntsGols);
        } while (!acabar);
          
    }
}