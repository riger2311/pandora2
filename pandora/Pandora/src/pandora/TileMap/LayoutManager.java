package pandora.TileMap;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Responsible for managing the layout of the current frame. It takes care of
 * setting up and clearing the entire frame when a new map is created or loaded.
 */
public class LayoutManager 
{
	private MapEditor parentFrame;
	private MapPanel1 mapPanel;
        private JPanel secondpanel;
	private JScrollPane tilePanelScrollPane;
	private JScrollPane mapPanelScrollPane;
	
	private final float TILE_PANEL_RATIO = 0.25f;	
	
	/**
	 * Constructs a new LayoutManager
	 * @param parentFrame - The MapperFrame to assign this layout manager to
	 * @param mapPanel - The MapPanel to assign this layout manager to
	 */
	public LayoutManager(MapEditor parentFrame, MapPanel1 mapPanel)
	{
		this.parentFrame = parentFrame;
		this.mapPanel = mapPanel;
	}
	
	/**
	 * Sets the layout manager's components to the new incoming parameters
	 * @param parentFrame - The new MapperFrame to assign the layout manager to
	 * @param mapPanel - The new MapPanel to assign the layout manager to
	 */
	public void setNewInfo(MapEditor parentFrame, MapPanel1 mapPanel)
	{
		this.parentFrame = parentFrame;
		this.mapPanel = mapPanel;
	}
	
	/**
	 * Creates all of the scroll panes and adds the
	 * components that are set in the layout manager to them
	 */
	public void initializeLayout()
	{	
		// Create the JScrollPanes for the tile and map panels
		tilePanelScrollPane = new JScrollPane(parentFrame.getTeilpanel());
		mapPanelScrollPane = new JScrollPane(mapPanel);
	
                secondpanel = new JPanel(new GridLayout(2, 1));
				
                parentFrame.setLayout(new GridLayout(1, 2));
		parentFrame.add(mapPanelScrollPane);
		secondpanel.add(tilePanelScrollPane);
                secondpanel.add(parentFrame.getOption());
		secondpanel.validate();
		
                parentFrame.add(secondpanel);

		parentFrame.repaint();
	}
	
	/**
	 * Clears the existing layout so that a new map can be loaded
	 */
	public void clearExistingLayout()
	{
		tilePanelScrollPane.removeAll();
		mapPanelScrollPane.removeAll();
		
		parentFrame.remove(tilePanelScrollPane);
		parentFrame.remove(mapPanelScrollPane);
                parentFrame.remove(secondpanel);
	}
	
}