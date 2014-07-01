package pandora.TileMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;
import pandora.ConstantStrings;

/**
 * A map dialog which is displayed to help in creating a new map.
 */
public class NewMapDialog extends JDialog {

    private static final long serialVersionUID = -1115249028397521382L;

    /**
     * @param aSheet the sheet to set
     */
    public static void setSheet(TileSheet aSheet) {
        sheet = aSheet;
    }

    private JTextField tileSheetField;
    private MapEditor parentFrame;
    private String selectedFilePath;
    private JSpinner xTiles;
    private JSpinner yTiles;
    private JSpinner xSize;
    private JSpinner ySize;
    private JButton colorPickerButton;
    private Color transparentColor;

    private static TileSheet sheet;
    private static TilePanel1 tilePanel;
    private static MapPanel1 mapPanel;

    private final int DEFAULT_FRAME_WIDTH = 320;
    private final int DEFAULT_FRAME_HEIGHT = 320;
    private final Color DEFAULT_COLORPICKER_COLOR = new Color(255, 0, 255);
    private final int COLORPICKER_BOX_WIDTH = 32;
    private final int COLORPICKER_BOX_HEIGHT = 32;

    /**
     * A map dialog which is displayed to help in creating a new map
     *
     * @param parentFrame - The MapperFrame which created this object
     */
    public NewMapDialog(MapEditor parentFrame) {

        //super(parentFrame, "Create a new map", true);
        // Set the frame's attributes
        this.parentFrame = parentFrame;
        transparentColor = DEFAULT_COLORPICKER_COLOR;
        setPreferredSize(new Dimension(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Create and display the frame
        createFrame();
        pack();
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Sets up the frame, calling all major subroutines
     */
    private void createFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create each of the main panels
        panel.add(createMapSizeComponents());
        panel.add(createTileSizeComponents());
        panel.add(createSheetSelectionComponents());

        // Add each of the panels
        add(panel, BorderLayout.NORTH);
        add(createColorPicker(), BorderLayout.CENTER);
        add(createConfirmButtons(), BorderLayout.SOUTH);
    }

    /**
     * Creates the JPanel which holds all of the map size GUI components
     *
     * @return The JPanel which holds all of the map size GUI components
     */
    private JPanel createMapSizeComponents() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Map Size"));

        // Create the JSpinners
        xTiles = new JSpinner();
        yTiles = new JSpinner();

        getxTiles().setValue(10);
        getyTiles().setValue(10);

        // Create the JLabels
        JLabel widthLabel = new JLabel("Width:");
        JLabel heightLabel = new JLabel("Height:");
        JLabel unitLabel = new JLabel("(in tiles)");

        // Add the components to the frame
        panel.add(widthLabel);
        panel.add(getxTiles());
        panel.add(heightLabel);
        panel.add(getyTiles());
        panel.add(unitLabel);

        return panel;
    }

    /**
     * Creates the JPanel which holds all of the tile size GUI components
     *
     * @return The JPanel which holds all of the tile size GUI components
     */
    private JPanel createTileSizeComponents() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Tile Size"));

        // Create the JSpinners
        setxSize(new JSpinner());
        setySize(new JSpinner());

        getxSize().setValue(32);
        getySize().setValue(32);

        // Create the JLabels
        JLabel widthLabel = new JLabel("Width:");
        JLabel heightLabel = new JLabel("Height:");
        JLabel unitLabel = new JLabel("(in pixels)");

        // Add the components to the frame
        panel.add(widthLabel);
        panel.add(getxSize());
        panel.add(heightLabel);
        panel.add(getySize());
        panel.add(unitLabel);

        return panel;
    }

    /**
     * Creates the JPanel which holds all of the sheet selection GUI components
     *
     * @return The JPanel which holds all of the sheet selection GUI components
     */
    private JPanel createSheetSelectionComponents() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Tilesheet"));

        // Create the components
        tileSheetField = new JTextField(15);
        JButton browseButton = new JButton("Browse");

        // Implement and add the listener for the browse button
        class BrowseButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "PNG Images", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(getParent());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    tileSheetField.setText(chooser.getSelectedFile().getName());
                    selectedFilePath = chooser.getSelectedFile().getAbsolutePath();
                }
            }

        }

        browseButton.addActionListener(new BrowseButtonListener());

        // Add the components to the frame
        panel.add(tileSheetField);
        panel.add(browseButton);

        return panel;
    }

    /**
     * Creates the components for choosing the transparent color
     *
     * @return The JPanel which holds the color choosing button and label
     */
    private JPanel createColorPicker() {
        JPanel panel = new JPanel();

        BufferedImage defaultColorImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = defaultColorImage.getGraphics();
        g.setColor(DEFAULT_COLORPICKER_COLOR);
        g.fillRect(0, 0, COLORPICKER_BOX_WIDTH, COLORPICKER_BOX_HEIGHT);

        JLabel transparentLabel = new JLabel("Transparent Color:");
        colorPickerButton = new JButton(new ImageIcon(defaultColorImage));

        class ColorPickerListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                Color c = JColorChooser.showDialog(null, "Pick a transprent tile color", null);
                colorPickerButton.setIcon(new ImageIcon(createImageFromColor(c)));
                transparentColor = c;
            }

        }
        colorPickerButton.addActionListener(new ColorPickerListener());

        panel.add(transparentLabel);
        panel.add(colorPickerButton);
        return panel;
    }

    /**
     * Creates the JPanel which holds the confirm buttons
     *
     * @return The JPanel which holds the confirm buttons
     */
    private JPanel createConfirmButtons() {
        JPanel panel = new JPanel();

        JButton createButton = new JButton("Create");
        JButton cancelButton = new JButton("Cancel");

        // Create button listeners for each button
        class CreateButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                setupLayout();
                dispose();
            }
        }

        class CancelButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }

        // Add the listeners
        createButton.addActionListener(new CreateButtonListener());
        cancelButton.addActionListener(new CancelButtonListener());

        // Add each of the buttons to the frame
        panel.add(createButton);
        panel.add(cancelButton);
        return panel;
    }

    /**
     * Sets up the map, object, and tile panels after the create button has been
     * clicked
     */
    private void setupLayout() {
        // Create a new TileSheet 
        try {
            setSheet(new TileSheet(new File(getSelectedFilePath()), (Integer) getxSize().getValue(), (Integer) getySize().getValue(), transparentColor));
            System.out.println("You chose to open this file: " + getSelectedFilePath());

            parentFrame.setSelectedFilePath(getSelectedFilePath());

            // Create the map, tile, and object panels					
            tilePanel = new TilePanel1(getSheet(), false);
            //TilePanel1 objectPanel = new TilePanel(sheet, true);
            mapPanel = new MapPanel1(parentFrame,(Integer)getxTiles().getValue(), 
                    (Integer)getyTiles().getValue(), tilePanel);

            // Assign the panels to the main frame
            parentFrame.setTeilpanel(tilePanel);
            parentFrame.setPanelmap(mapPanel);

            // Assign the map panel to the tile selection panels
            tilePanel.setMapPanel(mapPanel);
            //objectPanel.setMapPanel(mapPanel);

            LayoutManager manager;

            // If a layout manager doesn't already exist, create one
            if (parentFrame.getLayoutManager() == null) {
                //System.out.println("Manager not exist");
                manager = new LayoutManager(parentFrame, mapPanel);
                parentFrame.setLayoutManager(manager);
            } // If one does exist, clear old layout and update it with the new info
            else {
                //System.out.println("Manager exist");
                manager = parentFrame.getLayoutManager();
                manager.clearExistingLayout();
                manager.setNewInfo(parentFrame, mapPanel);
                //parentFrame.setTeilplan("Tile Mapper");
            }

            manager.initializeLayout();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            JOptionPane.showMessageDialog(this, ConstantStrings.ERROR_FILE ,"File Error",JOptionPane.ERROR_MESSAGE);
            
        }


    }

    /**
     * Creates a 32x32 image of a single color
     *
     * @param c - The color to make the image
     * @return The single color image
     */
    private BufferedImage createImageFromColor(Color c) {
        BufferedImage temp = new BufferedImage(COLORPICKER_BOX_WIDTH, COLORPICKER_BOX_HEIGHT, BufferedImage.TYPE_INT_RGB);

        Graphics g = temp.getGraphics();
        g.setColor(c);
        g.fillRect(0, 0, COLORPICKER_BOX_WIDTH, COLORPICKER_BOX_HEIGHT);

        return temp;
    }

    public static TileSheet getSheet() {
        return sheet;
    }

    /**
     * @return the tilePanel
     */
    public static TilePanel1 getTilePanel() {
        return tilePanel;
    }

    /**
     * @return the mapPanel
     */
    public static MapPanel1 getMapPanel() {
        return mapPanel;
    }

    /**
     * @return the selectedFilePath
     */
    public String getSelectedFilePath() {
        return selectedFilePath;
    }

    /**
     * @return the xSize
     */
    public JSpinner getxSize() {
        return xSize;
    }

    /**
     * @param xSize the xSize to set
     */
    public void setxSize(JSpinner xSize) {
        this.xSize = xSize;
    }

    /**
     * @return the ySize
     */
    public JSpinner getySize() {
        return ySize;
    }

    /**
     * @param ySize the ySize to set
     */
    public void setySize(JSpinner ySize) {
        this.ySize = ySize;
    }

    /**
     * @return the xTiles
     */
    public JSpinner getxTiles() {
        return xTiles;
    }

    /**
     * @return the yTiles
     */
    public JSpinner getyTiles() {
        return yTiles;
    }
}
