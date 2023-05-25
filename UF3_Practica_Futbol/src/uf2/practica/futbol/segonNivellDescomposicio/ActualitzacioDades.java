
package uf2.practica.futbol.segonNivellDescomposicio;

import static uf2.practica.futbol.main.UF2AppFutbol.comptadorEquips;
import static uf2.practica.futbol.main.UF2AppFutbol.numMaxEquips;
import static uf2.practica.futbol.main.UF2AppFutbol.teclat;
import static uf2.practica.futbol.segonNivellDescomposicio.VisualitzacioDades.mostrarMissatgeEquipNoTrobat;
import static uf3.practica.futbol.persistenciaDades.PersistenciaDades.escriureFitxer;
import static utils.arrays.ArrayStrings.retornarPosicio;
import static utils.consola.LecturaConsola.llegirEnter;


/**
 * Desenvolupament dels mètodes que tenen funcions d'actualització
 * @author montseponsa
 * @version 08.03.2023
 */
public class ActualitzacioDades {
     
    
    /**
     * Permet afegir un equip introduint les dades corresponents per consola.
     * @param equips
     * @param puntsGols 
     */
    public static void afegirEquip(String[] equips, int[][] puntsGols){
        if (comptadorEquips == 20){
            mostrarMissatgeNumMaximEquips(numMaxEquips);
        }

        for (int i = comptadorEquips; i < 20; i++){ //Comença a introduir equips a partir de l'últim equip introduït, per evitar sobreescriure dades
            System.out.println("\nIntrodueix el nom de l'equip que vulguis afegir:");
            String nomEquip = teclat.nextLine();

            int posicio = retornarPosicio(equips, nomEquip); 

            //Retornem la posició de l'equip que acabem d'afegir.
            //A continuació, recorrem l'array per veure si aquest equip ja existeix.
            //Si ja existeix, demanem a l'usuari que n'introdueixi un altre.
            
            for (int j = 0; equips[j] != null; j++){
                if (posicio != -1){
                    System.out.println("\nAquest equip ja està introduït.\n\nIntrodueix un altre nom: ");
                    nomEquip = teclat.nextLine();
                    break;
                }
            }

            //Assignem el valor introduït a la variable equips[i] per a que s'emmagatzemi la dada:
            equips[i] = nomEquip;

            insertarDadesEquips(puntsGols, i);

            //Escrivim l'equip que em afegit a l'arxiu Equips.dat per mantenir la persistència de dades
            escriureFitxer(equips, puntsGols);
            
            System.out.println("\n\tEquip introduït");

            comptadorEquips += 1; //Sumem 1 al comptador ja que hem afegit un nou equip.

            if (comptadorEquips >= 20){
                mostrarMissatgeNumMaximEquips(numMaxEquips); //El numMaxEquips és 20
                break;

            } else {
                System.out.println("Vols introduir un altre equip? (1 --> sí / 2 --> no)");
                int opcio = llegirEnter();
                teclat.nextLine();

                if (opcio != 1){
                    break;
                }
            }
        }
    }
    
    
    /**
     * Permet modificar les dades dels equips que tenim introduïts per consola.
     * @param equips
     * @param puntsGols 
     */
    public static void modificarDades(String[] equips, int[][] puntsGols){
        boolean trobat = false;
        
        System.out.println("\nEscull l'equip del qual vols modificar les seves dades: ");
        String nomEquip = teclat.nextLine();

        for (int i = 0; i < equips.length; i++) {

            if (nomEquip.equals(equips[i])) {
                insertarDadesEquips(puntsGols, i);
                System.out.println("\n\tEquip modificat.");
                trobat = true;
            } else {
                trobat = false;
            }
        }
        
        if (trobat){ // trobat = false (l'equip introduït no existeix)
            mostrarMissatgeEquipNoTrobat();
        }
        
        //Escrivim l'equip que em afegit a l'arxiu Equips.dat per mantenir la persistència de dades
        escriureFitxer(equips, puntsGols);
    }
    
    
    
    /******************************* Submètode* ******************************/
    
    /**
     * Pregunta per consola, pas a pas, les diverses dades que hem d'introduir.
     * @param puntsGols
     * @param i: fa referencia a la variable que utilitzem normalment amb el bucle "for" 
     */
    public static void insertarDadesEquips(int[][] puntsGols, int i){
        System.out.println("\nIntrodueix quants partits ha jugat: ");
        puntsGols [i][0] = llegirEnter();

        System.out.println("Introdueix quants partits ha guanyat: ");
        puntsGols [i][1] = llegirEnter();

        System.out.println("Introdueix quants partits ha empatat: ");
        puntsGols [i][2] = llegirEnter();

        System.out.println("Introdueix quants partits ha perdut: ");
        puntsGols [i][3] = llegirEnter();

        //Punts totals:
        puntsGols[i][4] = puntsGols[i][1] * 3 + puntsGols[i][2] * 1;

        System.out.println("Introdueix quants gols a favor té: ");
        puntsGols [i][5] = llegirEnter();

        System.out.println("Introdueix quants gols en contra té: ");
        puntsGols [i][6] = llegirEnter();

        //Diferència de gols:
        puntsGols [i][7] = puntsGols[i][5] - puntsGols[i][6];
    }
    
    
    /**
     * Mostra un missatge sobre el màxim d'equips que conté la lliga
     * @param numMaxEquips 
     */
    public static void mostrarMissatgeNumMaximEquips(int numMaxEquips){
        System.out.println("\nLa lliga consta de " + numMaxEquips + " equips. Ja no en pots introduir cap més.");
    }
    
}
