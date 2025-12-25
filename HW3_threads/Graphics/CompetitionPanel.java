/**
 @authors Noa Shem Tov  , Linoy Nisim Pur
*/
package Graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import animals.Animal;
import animals.Orientation;
import mobility.Point;

/**
 * The CompetitionPanel class represents the main panel for the competition. It
 * handles the display and management of the competition, including adding
 * competitions and animals, clearing animals, feeding animals, and displaying
 * animal information.
 */
public class CompetitionPanel extends JPanel {

    private BufferedImage img;
    private AddCompetitionDialog addCompDialog;
    private Vector<Animal> AnimalsCreated = new Vector<>();
    private Vector<String> selectedCompetition = new Vector<>();
    private String choiceString;
    private JFrame screenFrame;
    private JPanel boardPanel;
    private List<List<List<Animal>>> AllCompetition = new ArrayList<>();

    private int NumberOfWaterCompetition;
    private int NumberOfAirCompetition;
    private boolean IsTerr;

    private int AirGroup;
    private int WaterGroup;

    /**
     * Constructs a CompetitionPanel with the specified parent frame.
     *
     * @param parent the parent frame
     */
    public CompetitionPanel(JFrame parent) {
        screenFrame = parent;
        try {
            img = ImageIO.read(new File("bin/image/competitionBackground.png"));
        } catch (IOException e) {
            System.out.println("Cannot load image");
        }

        this.AirGroup = 0;
        this.WaterGroup = 0;
        boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), parent);
                if (!AnimalsCreated.isEmpty()) {
                    for (Animal animal : AnimalsCreated) {
                        if (!animal.GetIsCleard())
                            animal.drawObject(g);
                    }
                }
            }
        };
        this.setLayout(new BorderLayout());
        this.add(boardPanel, BorderLayout.CENTER);
        JPanel boardButton = new JPanel();
        boardButton.setLayout(new GridLayout(1, 6));
        JButton AddCompetitionButton = new JButton("Add Competition");
        AddCompetitionButton.addActionListener(e -> {
            if (AirGroup == 5 && WaterGroup == 4 && IsTerr) {
                JOptionPane.showMessageDialog(null, "The panel is full.\n To add a new competition, please clear an existing one");
                return;
            }
            addCompDialog = new AddCompetitionDialog(parent, this, AnimalsCreated);
            addCompDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            if (addCompDialog.GetType() != null)
                choiceString = addCompDialog.GetType().getUserChoiceComp();
            else return;
            if (choiceString != null)
                selectedCompetition.add(choiceString);
        });
        boardButton.add(AddCompetitionButton);

        JButton ClearButton = new JButton("Clear competition");
        ClearButton.addActionListener(e -> {
            if (AnimalsCreated.isEmpty())
                JOptionPane.showMessageDialog(null, "No Competition was created");
            else {
                if (!AllCompetition.isEmpty()) ClearAnimal();
                else JOptionPane.showMessageDialog(null, "there is no Competition to clear");
            }
        });
        boardButton.add(ClearButton);

        JButton EatButton = new JButton("Eat");
        EatButton.addActionListener(e -> {
            if (AnimalsCreated.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No animal was created");
                setVisible(true);
            } else {
                boolean flag = false;
                for (Animal animal : AnimalsCreated) {
                    if (!animal.GetIsCleard())
                        flag = true;
                }
                if (flag) EatSelectedAnimal();
                else JOptionPane.showMessageDialog(null, "there is no animals to feed");
            }
        });
        boardButton.add(EatButton);

        JButton InfoButton = new JButton("Info");
        InfoButton.addActionListener(e -> {
            if (AnimalsCreated.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No animal was created");
                setVisible(true);
            } else {
                showInfoDialog();
            }
        });
        boardButton.add(InfoButton);

        NumberOfWaterCompetition = 0;
        NumberOfAirCompetition = 0;
        IsTerr = false;

        JButton ExitButton = new JButton("Exit");
        ExitButton.addActionListener(e -> System.exit(0));
        boardButton.add(ExitButton);
        this.add(boardButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * Handles the addition of a new animal to the competition.
     *
     * @param parent the parent frame
     */
    protected void AddAnimal(JFrame parent, String Track) {
        if (selectedCompetition.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Competition selected. Please select an option.");
            setVisible(true);
        } else {
            new AddAnimalDialog(parent, selectedCompetition, AnimalsCreated, this, Track);
            if (!AnimalsCreated.isEmpty()) {
                AnimalsCreated.lastElement().drawObject(getGraphics());
            }
            ;
            repaint();
        }
    }

    protected void SetSelectedCompetition(String Selected) {
        selectedCompetition.add(Selected);
    }

    /**
     * Moves the last added animal based on its speed and updates its energy.
     */
    public void moveAnimal(Animal animal) {
        if (AnimalsCreated.isEmpty())
            return;
        String categoryString = animal.Category();
        if (categoryString.equals("Terrestrial"))
            MoveTerrestrialAnimal(animal);
        else {

                Point location = animal.getLocation();
                int x = location.GetFromPointX();
                int y = location.GetFromPointY();
                int speed = animal.getSpeed();
                x = x + speed;
                if (x >= animal.GetFinish().GetFromPointX()) {
                    animal.SetEnergyAmount(0);
                    x = animal.GetFinish().GetFromPointX();
                    Repaint(animal, x, y);
                } else Repaint(animal, x, y);
            }
    }

    protected void Repaint(Animal animal, int x, int y) {
        int Dis = 0;
        if (animal.GetEnergyAmount() > 0)
            Dis = (int) animal.move(new Point(x, y));
        animal.SetEnergyAmount((Dis / animal.getSpeed()) * animal.getEnergyPerMeter());
        repaint();
    }

    private void MoveTerrestrialAnimal(Animal animal) {

            Point location = animal.getLocation();
            int x = location.GetFromPointX();
            int y = location.GetFromPointY();
            int speed = animal.getSpeed();

            if (animal.getOrien() == Orientation.EAST) {
                if (x != 1) {
                    x = x + speed;
                    if (x > boardPanel.getWidth() - Drawable.SIZE_PICTURE * 3 + 115) {
                        animal.setOrien();
                        x = boardPanel.getWidth() - Drawable.SIZE_PICTURE * 3 + 115;
                    }
                }
            } else {
                if (animal.getOrien() == Orientation.WEST) {
                    x = x - speed;
                    if (x < 0) {
                        animal.setOrien();
                        x = 35;
                    }
                } else if (animal.getOrien() == Orientation.NORTH) {
                    y = y - speed;
                    if (y > boardPanel.getHeight() + Drawable.SIZE_PICTURE || y < 0) {
                        animal.setOrien();
                        x = 1;
                        y = 10;
                        animal.SetEnergyAmount(0);
                    }
                } else {
                    y = y + speed;
                    if (y > boardPanel.getHeight() - Drawable.SIZE_PICTURE) {
                        animal.setOrien();
                        y = boardPanel.getHeight() - Drawable.SIZE_PICTURE;
                    }
                }
            }
            Repaint(animal, x, y);
    }

    /**
     * Displays information about all the animals in a table.
     */
    private void showInfoDialog() {
        String[] columnNames = {"Animal", "Category", "Type", "Speed", "Energy Amount", "Distance",
                "Energy Consumption"};
        Object[][] data = new Object[AnimalsCreated.size()][7];

        for (int i = 0; i < AnimalsCreated.size(); i++) {
            Animal animal = AnimalsCreated.get(i);
            data[i][0] = animal.getName();
            data[i][1] = animal.Category();
            data[i][2] = animal.getAnimaleName();
            data[i][3] = animal.getSpeed();
            data[i][4] = animal.GetEnergyAmount();
            data[i][5] = animal.getTotalDistance();
            data[i][6] = animal.GetEnergyConsumption();
        }
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30); // Set row height for better readability

        // Custom renderer for header
        JTableHeader header = table.getTableHeader();
        header.setBackground(UIManager.getColor("Button.background"));
        header.setForeground(UIManager.getColor("Button.foreground"));
        header.setFont(new java.awt.Font("Calibri", java.awt.Font.BOLD, 14));
        header.setBorder(UIManager.getBorder("Button.border"));

        // Custom renderer for cells
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 12));
                setHorizontalAlignment(CENTER); // Center align the text
                return c;
            }
        };

        table.setDefaultRenderer(Object.class, cellRenderer);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a new JFrame to display the table
        JFrame infoFrame = new JFrame("Animals Information");
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setSize(1000, 400);
        infoFrame.add(scrollPane);
        infoFrame.setLocationRelativeTo(null); // Center the frame on the screen
        infoFrame.setVisible(true);
    }

    /**
     * Prompts the user to select an animal and feeds the selected animal.
     */
    public void EatSelectedAnimal() {
        Vector<Animal> animalsToShow = new Vector<>();
        String selectedAnimalName = SelectedAnimalFromComobox(animalsToShow);
        if (selectedAnimalName != null) {
            for (Animal animal : animalsToShow) {
                if (animal.getName().equals(selectedAnimalName)) {
                    if (animal.IsFull()) {
                        JOptionPane.showMessageDialog(screenFrame, animal.getName() + " is already full and does not need to be fed.");
                    } else {
                        showFoodAmountDialog(animal);
                    }
                    break;
                }
            }
        }
    }

    /**
     * Shows a dialog to enter the food amount to feed the selected animal.
     *
     * @param animal the selected animal
     */
    private void showFoodAmountDialog(Animal animal) {
        JTextField foodAmountField = new JTextField();
        foodAmountField.setHorizontalAlignment(JTextField.CENTER);
        // Add key listener to allow only numbers
        foodAmountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume(); // Ignore non-digit characters
                }
            }
        });

        int result = JOptionPane.showConfirmDialog(screenFrame, foodAmountField, "Enter Food Amount",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String input = foodAmountField.getText();
            if (!input.isEmpty()) {
                int foodAmount = Integer.parseInt(input);
                if (animal.eat(foodAmount))
                    JOptionPane.showMessageDialog(screenFrame, "Food amount updated for " + animal.getName());
                else {
                    JOptionPane.showMessageDialog(screenFrame, "The amount must be valid, not exceeding  " + animal.getMaxEnergy() + " and not falling below 0.");
                }

            }
        }
    }

    /**
     * Clears the selected animal from the competition.
     */
    private void ClearAnimal() {
        int selectedCompetitionToClear = SelectedCompetitionFromComoboxForClear();
        if (selectedCompetitionToClear != -1) {
            if (ClearedCompetition(selectedCompetitionToClear)) {
                JOptionPane.showMessageDialog(screenFrame, "Competition #" + selectedCompetitionToClear + " has been removed.");
                repaint();
            }
        }
    }

    private int SelectedCompetitionFromComoboxForClear() {
        int selectedCompetitionToClear = -1;
        JComboBox<Integer> ComboBox = new JComboBox<>();
        // Add competition numbers to the combo box
        for (int i = 0; i < this.AllCompetition.size(); i++)
            ComboBox.addItem(i + 1); // Adding competition numbers (1, 2, 3, ...)
        // Show a dialog to select a competition
        int result = JOptionPane.showConfirmDialog(screenFrame, ComboBox, "Select a Competition", JOptionPane.OK_CANCEL_OPTION);
        // If the user clicked OK, get the selected competition number
        if (result == JOptionPane.OK_OPTION)
            selectedCompetitionToClear = (Integer) ComboBox.getSelectedItem(); // Get selected item as an integer
        return selectedCompetitionToClear; // Return the selected competition number
    }

    /**
     * Displays a combo box with animals to select from.
     *
     * @param animalsToShow the vector of animals to show in the combo box
     * @return the name of the selected animal
     */
    private String SelectedAnimalFromComobox(Vector<Animal> animalsToShow) {
        String selectedAnimalName = null;
        for (Animal animal : AnimalsCreated) {
            if (!animal.GetIsCleard()) {
                animalsToShow.add(animal);
            }
        }
        JComboBox<String> animalComboBox = new JComboBox<>();
        for (Animal animal : animalsToShow) {
            animalComboBox.addItem(animal.getName());
        }
        // Show the combo box in a dialog
        if (!animalsToShow.isEmpty()) {
            int result = JOptionPane.showConfirmDialog(screenFrame, animalComboBox, "Select an Animal",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION)
                selectedAnimalName = (String) animalComboBox.getSelectedItem();
            return selectedAnimalName;
        } else
            return null;
    }


    protected List<List<List<Animal>>> GetAllCompetitions() {
        return this.AllCompetition;
    }

    protected boolean AddCompetition(List<List<Animal>> animalGroups) {
        if (animalGroups != null && !animalGroups.isEmpty()) {
            boolean allListsAreNotNull = true;
            for (List<Animal> group : animalGroups) {
                if (group == null) {
                    allListsAreNotNull = false;
                    break;
                }
            }
            if (allListsAreNotNull) {
                this.AllCompetition.add(animalGroups);
                if (animalGroups.getFirst().getFirst().Category().equals("Air"))
                    this.AirGroup = animalGroups.size();
                else if (animalGroups.getFirst().getFirst().Category().equals("Water"))
                    this.WaterGroup = animalGroups.size();
                else this.IsTerr = true;
                return true;
            }
        }
        return false;
    }

    protected boolean ClearedCompetition(int competitionIndex) {
        if (AllCompetition != null) {
            if (competitionIndex >= 0 && competitionIndex - 1 < this.AllCompetition.size()) {
                List<List<Animal>> selectedListOfLists = AllCompetition.get(competitionIndex - 1);
                String categoryCompetition = selectedListOfLists.getFirst().getFirst().Category();
                for (List<Animal> innerList : selectedListOfLists) {
                    for (Animal animal : innerList)
                        animal.SetCleard();
                }
                int size = selectedListOfLists.size();
                AllCompetition.remove(competitionIndex - 1);
                ClearedCompetition(categoryCompetition);
                if (categoryCompetition.equals("Air"))
                    ClearedGroupsAir(size);
                else if (categoryCompetition.equals("Water"))
                    ClearedGroupsWater(size);
                return true;
            }
        }
        return false;
    }

    protected int GetAmountWaterCompetition() {
        return this.NumberOfWaterCompetition;
    }

    protected int GetAmountAirCompetition() {
        return this.NumberOfAirCompetition;
    }

    protected boolean IsTerrCompetition() {
        return this.IsTerr;
    }

    protected void SetAmountAirCompetition() {
        this.NumberOfAirCompetition = this.NumberOfAirCompetition + 1;
    }

    protected void SetAmountWaterCompetition() {
        this.NumberOfWaterCompetition = this.NumberOfWaterCompetition + 1;
    }

    protected void CreateTerrCompetition() {
        this.IsTerr = true;
    }

    protected void ClearedCompetition(String Category) {
        if (Category != null) {
            if (Category.equals("Air")) {
                if (NumberOfAirCompetition > 0)
                    NumberOfAirCompetition = NumberOfAirCompetition - 1;
            } else if (Category.equals("Water")) {
                if (NumberOfWaterCompetition > 0)
                    NumberOfWaterCompetition = NumberOfWaterCompetition - 1;
            } else if (Category.equals("Terrestrial")) {
                IsTerr = false;
            }
        }
    }

    protected void ClearedGroupsAir(int number) {
        this.AirGroup = AirGroup - number;
    }

    protected void ClearedGroupsWater(int number) {
        this.WaterGroup = WaterGroup - number;
    }

    protected int GetGroupsAir() {
        return this.AirGroup;
    }

    protected int GetGroupsWater() {
        return this.WaterGroup;
    }

    protected void SetGroupsAir() {
        this.AirGroup = this.AirGroup + 1;
    }

    protected void SetGroupsWater() {
        this.WaterGroup = this.WaterGroup + 1;
    }
}
