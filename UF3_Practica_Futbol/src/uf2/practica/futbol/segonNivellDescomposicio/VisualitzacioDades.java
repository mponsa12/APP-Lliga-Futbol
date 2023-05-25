
package uf2.practica.futbol.segonNivellDescomposicio;

import static uf2.practica.futbol.main.UF2AppFutbol.comptadorEquips;
import static uf2.practica.futbol.main.UF2AppFutbol.teclat;
import static utils.arrays.ArrayEnter.PosFilaMax;
import static utils.arrays.ArrayEnter.PosFilaMin;
import static utils.arrays.ArrayStrings.copiarArray;
import static utils.arrays.ArrayStrings.ordenarQuicksort;
import static utils.arrays.ArrayStrings.retornarPosicio;
import static utils.arrays.ArrayStrings.visualitzarArray;


/**
 * Desenvolupament dels mètodes que tenen funcions de visualització
 * @author montseponsa
 * @version 08.03.2023
 */
public class VisualitzacioDades {
    
    /**
     * Mostra les puntuacions de tots els equips que tenim introduïts
     * @param equips
     * @param puntsGols 
     */
    public static void mostrarPuntuacions(String[] equips, int[][] puntsGols){
        mostrarTitolDades();
        mostrarDades(equips, puntsGols, comptadorEquips);
        System.out.println("");
    }
    
    
    /**
     * Ordena alfabèticament els equips que tenim introduïts mitjançant el mètode Quicksort
     * @param equips 
     */
    public static void mostrarEquipsOrdenats(String[] equips){
        String[] equipsOrdenats = copiarArray(equips, comptadorEquips);
                    
        System.out.println("\nEQUIPS ENUMERATS PER ORDRE ALFABÈTIC:\n");

        ordenarQuicksort (equipsOrdenats, 0, equipsOrdenats.length - 1);
        //Introduim l'array que volem ordenar(equipsOrdenats), la posició 
        //esquerra de l'array (0) i la posició dreta (agafem el length de 
        //l'array menys 1, ja que les posicions comencen per 0)
        
        visualitzarArray(equipsOrdenats);
    }

    
    /**
     * Mostra les puntuacions de tots els equips que tenim introduïts.
     * @param equips
     * @param puntsGols 
     */
    public static void mostrarInfoEquips(String[] equips, int[][] puntsGols){
        System.out.println("\nEscriu l'equip del qual vulguis veure les seves dades: ");
        String nomEquip = teclat.nextLine();

        System.out.println("");

        int posicio = retornarPosicio(equips, nomEquip);

        if (posicio == -1){
            mostrarMissatgeEquipNoTrobat();
        } else {
            mostrarTitolDades();
            mostrarDades1Equip(equips, puntsGols, posicio);
            System.out.println("");
        }
    }
    
    
    /**
     * Mostra les puntuacions dels equips liders i cuers de la lliga
     * @param equips
     * @param puntsGols 
     */
    public static void mostrarLiderCuer(String[] equips, int[][] puntsGols){
        int posicioMax = PosFilaMax(puntsGols, 4);
        mostrarPuntuacioSegonsPosicio(equips, puntsGols, posicioMax, "lider");
        
        System.out.println("\n");
        
        int posicioMin = PosFilaMin(puntsGols, 4, comptadorEquips);
        mostrarPuntuacioSegonsPosicio(equips, puntsGols, posicioMin, "cuer");
    }
 
   

    
    /******************************* Submètodes ******************************/
    
    /**
     * Imprimeix els titols 
     */
    public static void mostrarTitolDades(){
        System.out.printf("%25s \t%s \t%s \t%s \t%s \t%s \t%s \t%s","jugats","guanyats",
                "empatats","perduts","punts totals","gols a favor","gols en contra","diferència de gols");
    }
    
    
    /**
     * Mostra les dades de tots els equips
     * @param equips
     * @param puntsGols
     * @param llargadaArray: assignem el length de l'array, per evitar els valors "null" 
     */
    public static void mostrarDades(String[] equips, int[][] puntsGols, int llargadaArray){
        for (int posicio = 0; posicio < llargadaArray; posicio++){
            mostrarDades1Equip (equips, puntsGols, posicio);
        }
    }
    
    
    /**
     * Mostra les dades d'un dels equips de l'array segons la posició que li introduim com a parametre
     * @param equips
     * @param puntsGols
     * @param posicio: es refereix a la posició de l'array que contingui les dades que ens interessin 
     */
    public static void mostrarDades1Equip (String[] equips, int[][] puntsGols, int posicio){
        System.out.printf("\n%-20s", equips[posicio]);
        System.out.printf("%2d %13d %15d %15d %15d %17d %17d %17d", puntsGols[posicio][0], 
                puntsGols[posicio][1], puntsGols[posicio][2], puntsGols[posicio][3], puntsGols[posicio][4], 
                puntsGols[posicio][5], puntsGols[posicio][6], puntsGols[posicio][7]);
    }
    
    
    /**
     * Mostra les puntuacions d'un equip segons el seu ranquing, el qual li introduim com a parametre
     * @param equips
     * @param puntsGols
     * @param posicio: es refereix a la posició de l'array "puntsGols" que contingui les dades que ens interessin
     * @param ranking: es refereix a la classificació en que es troba cada equip a la lliga (lider, segon, cuer...) 
     */
    public static void mostrarPuntuacioSegonsPosicio(String equips[], int[][] puntsGols, int posicio, String ranking){
        System.out.println("\nEl " + ranking + " de la Lliga és el " + equips[posicio] + " amb " + puntsGols[posicio][4] + " punts.");
        mostrarTitolDades();
        mostrarDades1Equip (equips, puntsGols, posicio);
    }
    
    
    /**
     * Mostra un missatge sobre la inexistència de l'equip.
     */
    public static void mostrarMissatgeEquipNoTrobat(){
        System.out.println("Aquest equip no està a la base de dades. Si us plau, comprova que l'hagis escrit correctament.");
        System.out.println("Vigila amb les majúscules!");
    }
    
     
}   
