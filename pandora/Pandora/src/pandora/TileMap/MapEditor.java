/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.TileMap;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author achillis
 */
public class MapEditor extends javax.swing.JPanel {

    private MapPanel1 panelmap;
    private TilePanel1 teilpanel;
    private OptionPanel1 option;
    private LayoutManager layoutManager;

    /**
     * Creates new form MapEditor
     */
    public MapEditor() {
        initComponents();
        setLayout(new GridLayout());
        this.option = new OptionPanel1();
        MapIO.loadProjectAsXML("image/example_map.tmf", this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();

        setLayout(new java.awt.GridLayout(1, 1, 1, 1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the panelmap
     */
    public MapPanel1 getPanelmap() {
        return panelmap;
    }

    /**
     * @param panelmap the panelmap to set
     */
    public void setPanelmap(MapPanel1 panelmap) {
        this.panelmap = panelmap;
    }

    /**
     * @return the teilpanel
     */
    public TilePanel1 getTeilpanel() {
        return teilpanel;
    }

    /**
     * @param teilpanel the teilpanel to set
     */
    public void setTeilpanel(TilePanel1 teilpanel) {
        this.teilpanel = teilpanel;
    }

    /**
     * @return the option
     */
    public OptionPanel1 getOption() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setOption(OptionPanel1 option) {
        this.option = option;
    }

    /**
     * @return the layoutManager
     */
    public LayoutManager getLayoutManager() {
        return layoutManager;
    }

    /**
     * @param layoutManager the layoutManager to set
     */
    public void setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

}
