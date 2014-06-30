/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

/**
 *
 * @author dominikmocher
 */
public class ConstantSrings {
    
    /*
    *
    *  Strings in Pandora.Java
    *
    */
    
    // heads for panels 
    public static final String HEAD_MAP = "Map-Editor";
    public static final String HEAD_RULES = "Regeln";
    
    public static final String MSG_SAVED = "Projekt wurde gespeichert";
    public static final String MSG_LOADED = "Projekt wurde erfolgreich geladen";
    public static final String MSG_PARSE_OK = "Spiel erfolgreich generiert";
    public static final String MSG_PARSE_FAIL = "Spiel konnte nicht erstellt werden";
    
    /*
    *
    *  Strings in RulesEditor.java
    *
    */
    public static final String ERROR_COLLISION_EMPTY = "Keine Kollisionen vorhanden";
    public static final String COLLISION_WITH_ITSELF = "Kollision mit sich selbst ist nicht erlaubt";
    public static final String MOVEMENT_RANGE = "Bitte Bewegungsweite eingeben";
    public static final String MOVEMENT_RANGE_NEW = "Bitte Bewegungsweite neu eingeben";
    
    //Actions for collisions
    public static final String ACTION_KILL = "schlagen";
    public static final String ACTION_IGNORE = "ignorieren";
    public static final String ACTION_JUMP = "überspringen";
    public static final String ACTION_DO_NOTHING = "nicht ziehen";
    //collision already exists
    public static final String COLLISION_EXISTS = "Regel für diese Objekte besteht bereits";

    //Displays "Spieler n" in List and Combobox
    public static final String PLAYER = "Spieler";
    public static final String MOVEMENT_DICE = "Bewegung durch Würfeln";
}
