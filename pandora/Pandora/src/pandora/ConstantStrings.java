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
public class ConstantStrings {
    
    /*
    *
    *  Strings in Pandora.Java
    *
    */
    
    // heads for panels 
    public static final String HEAD_MAP = "Map-Editor";
    public static final String HEAD_RULES = "Regeln";
    
    // message boxes
    public static final String MSG_SAVED = "Projekt wurde gespeichert";
    public static final String MSG_LOADED = "Projekt wurde erfolgreich geladen";
    public static final String MSG_PARSE_OK = "Spiel erfolgreich generiert";
    public static final String MSG_PARSE_FAIL = "Spiel konnte nicht erstellt werden";

    /*
    *
    *  Strings in StartDialog.Java
    *
    */
    //Labels and Buttons
    public static final String WELCOME = "Willkommen bei Pandora" ; 
    public static final String NEW_PROJECT = "Neues Projekt"; 
    public static final String LOAD_PROJECT = "Projekt laden";
    
    
    /*
    *
    *  Strings in RulesEditor.java
    *
    */
    //Labels and Buttons
    public static final String MOVEMENT_LABEL = "Bewegungsreichweite (1-10)";
    public static final String COLLISION_LABEL = "Bei Kontakt mit";
    public static final String APPLY_BUTTON = "Übernehmen";
    
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
    
    /*
    *
    *  Strings in Wizard.java
    *
    */
    //labels and buttons
    public static final String WIZARD_HEAD_LABEL = "Neues Projekt";
    public static final String WIZARD_INFO = "DU KOMMST NICHT VORBEI (...an den Grundeinstellungen des Spieles)!";
    public static final String NAME_OF_GAME = "Name des Spieles:";
    public static final String NUMBER_OF_PLAYERS = "Spieleranzahl:";
    public static final String SIZE_OF_FIELD = "Spielfeldgröße (BxH):";
    public static final String SIZE_RESTRIC = "(min 2x2, max 42x42 Felder)";
    public static final String NUM_OF_DICE = "Anzahl der Würfel:";
    public static final String EYE_OF_DICE = "Augenzahl der Würfel:";
    public static final String NUM_OF_TOKENS = "Anzahl der Spielfiguren pro Spieler:";
    public static final String NAME_OF_GAME_FIELD = "Spielname";
    
    //error messages
    public static final String ERROR_INPUT = "Error: Falsche Eingabe erfolgt. (Zahlen/Text)";
    public static final String ERROR_WIDTH = "Error: Breite ungültig!";
    public static final String ERROR_HEIGHT = "Error: Höhe ungültig!";
    public static final String ERROR_NUM_OF_TOKEN = "Error: Anzahl der Spielfiguren!";
    public static final String ERROR_NUM_OF_DICES = "Error: Anzahl der Würfel!";
    public static final String ERROR_EYE_OF_DICES = "Error: Augenzahl der Würfel!";

    
    /*
    *
    *  Strings in Parser.java
    *
    */
    public static final String BG_FILE = "background.png";
    public static final String PIECES_FILE = "pieces.png";
    public static final String JAVA_ENGINE = "JavaScript";
    public static final String DIRECTORY_EXISTS = "Ordner besteht bereits.";
    public static final String DOT_SLASH = "./";
    public static final String SLASH = "/";
    public static final String HTML = ".html";
    //public static final String BOARD = "board.js";
    public static final String READER = "reader.js";
    //public static final String JS = ".js";
    
        /*
    *
    * String in PandoraTileMap
    *
    */
    public static final String ERROR_FILE = "Keine Datei gefunden";
    
}
