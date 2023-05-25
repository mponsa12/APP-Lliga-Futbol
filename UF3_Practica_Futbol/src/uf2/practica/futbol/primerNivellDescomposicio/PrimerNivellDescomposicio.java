
package uf2.practica.futbol.primerNivellDescomposicio;

import static uf2.practica.futbol.main.UF2AppFutbol.comptadorEquips;
import static uf2.practica.futbol.main.UF2AppFutbol.numMaxEquips;
import static uf2.practica.futbol.segonNivellDescomposicio.ActualitzacioDades.afegirEquip;
import static uf2.practica.futbol.segonNivellDescomposicio.ActualitzacioDades.modificarDades;
import static uf2.practica.futbol.segonNivellDescomposicio.VisualitzacioDades.mostrarEquipsOrdenats;
import static uf2.practica.futbol.segonNivellDescomposicio.VisualitzacioDades.mostrarInfoEquips;
import static uf2.practica.futbol.segonNivellDescomposicio.VisualitzacioDades.mostrarLiderCuer;
import static uf2.practica.futbol.segonNivellDescomposicio.VisualitzacioDades.mostrarPuntuacions;
import static utils.consola.LecturaConsola.esperaTecla;
import static utils.consola.LecturaConsola.llegirEnter;



/**
 * Desenvolupament dels mètodes cridats a la classe main
 * @author montseponsa
 * @version 08.03.2023
 */
public class PrimerNivellDescomposicio{
    
    
    /**
     * Inicialitza l'array "equips" amb les dades de l'array "equips2" i li 
     * permet assignar un màxim de 20 equips.
     * @param equips2
     * @return String[] equips
     */
    public static String[] inicialitzarArrayEquips(String[] equips2){
        String[] equips = new String[numMaxEquips];
        
        for (int i = 0; i < comptadorEquips; i++) {
            equips[i] = equips2[i];
        } 
        return equips;
    }
    
    
    /**
     * Inicialitza l'array "puntsGols" amb les dades de l'array "puntsGols2" i 
     * li permet assignar puntuacions de 20 equips com a màxim.
     * @param puntsGols2
     * @return int[][] puntsGols
     */
    public static int[][] inicialitzarArrayPunts(int[][] puntsGols2){
        int[][] puntsGols = new int [numMaxEquips][8];
        
        for (int i = 0; i < comptadorEquips; i++) {
            for (int j = 0; j < 8; j++) {
                puntsGols[i][j] = puntsGols2[i][j];
            }
        }
        return puntsGols;
    }
    
    
    /**
     * Mostra per pantalla les opcions del menú.
     */
    public static void mostrarMenu() {
        System.out.println("\nMENÚ");
        System.out.println("1.- Puntuacions i gols");
        System.out.println("2.- Equips ordenats alfabèticament");
        System.out.println("3.- Informació sobre un equip");
        System.out.println("4.- Líder / Cuer");
        System.out.println("5.- Afegir equip");
        System.out.println("6.- Modificar dades");
        System.out.println("7.- Sortir");
        System.out.println("\n Tria una opció: ");
    }
    
    
    /**
     * Permet a l'usuari escullir quina opció del menú vol visualitzar
     * @param menu
     * @param equips
     * @param puntsGols
     * @return "true" si l'usuari escull sortir del programa; "false" si l'usuari 
     * escull una opció diferent a sortir del programa
     */
    public static boolean tractarOpcio(int menu, String[] equips, int[][] puntsGols) {
        
        menu = llegirEnter();
        
        switch (menu){
            case 1:
                mostrarPuntuacions(equips, puntsGols);
                break;
                
            case 2:
                mostrarEquipsOrdenats(equips);
                break;

            case 3:
                mostrarInfoEquips(equips, puntsGols);
                break;

            case 4:
                mostrarLiderCuer(equips, puntsGols);
                break;

            case 5:
                afegirEquip(equips, puntsGols);
                break;

            case 6:
                modificarDades(equips, puntsGols);
                break;

            case 7:
                System.out.println("\nAdéu, fins un altra!");
                return true;
                
            default:
                System.out.println("\nOpció INCORRECTA! Has d'escollir un número de l'1 al 7.");
        }
        
        esperaTecla();
        return false;
    }
}