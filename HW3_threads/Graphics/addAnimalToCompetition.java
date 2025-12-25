package Graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import animals.Animal;
import animals.Orientation;
import competition.CourierTournament;
import competition.RegularTournament;
import mobility.Point;

/**
 * @authors Noa Shem Tov  , Linoy Nisim Pur
 *
 * The addAnimalToCompetition class represents a dialog that allows the user to add animals to a competition.
 * The class provides functionality to create groups of animals, assign them to the competition, and configure their properties.
 */
public class addAnimalToCompetition extends JDialog {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<List<Animal>> animalGroups;
    private int maxAnimalsInGroup;
    private JPanel buttonPanel;
    private String waterAirTerrCurrent;
    private JButton saveButton;
    private CompetitionPanel pan;
    private Vector<Animal> allAnimals;
    private String reguCourCurrent;
    private int RemainingLength;

    /**
     * Constructor for the addAnimalToCompetition class.
     *
     * @param parent the parent frame
     * @param AnimalsCreated the list of animals created
     * @param pan the competition panel
     * @param AirWaterTerr the type of competition (Air, Water, or Terrestrial)
     * @param CourierRegular the type of competition (Courier or Regular)
     */
    public addAnimalToCompetition(JFrame parent, Vector<Animal> AnimalsCreated, CompetitionPanel pan,
                                  String AirWaterTerr, String CourierRegular) {
        super(parent, "Add Animals To The Competition", true);
        this.maxAnimalsInGroup = 3;
        this.animalGroups = Collections.synchronizedList(new ArrayList<>());
        this.waterAirTerrCurrent = AirWaterTerr;
        this.reguCourCurrent = CourierRegular;
        this.pan = pan;
        this.tableModel = new DefaultTableModel();
        this.table = new JTable(tableModel);
        saveButton = new JButton("Save");
        allAnimals = AnimalsCreated;
        customizeTableAppearance(); // design
        JScrollPane scrollPane = new JScrollPane(table);
        saveButton.addActionListener(e -> SaveButton());

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        buttonPanel = new JPanel();
        JButton addGroupButton = new JButton("Add Group");
        addGroupButton.addActionListener(e -> addNewGroup(parent, pan));
        buttonPanel.add(addGroupButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        setSize(900, 500);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    /**
     * Customizes the appearance of the table used to display animal groups.
     */
    private void customizeTableAppearance() {
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);

        JTableHeader header = table.getTableHeader();
        header.setBackground(UIManager.getColor("Button.background"));
        header.setForeground(UIManager.getColor("Button.foreground"));
        header.setFont(new java.awt.Font("Calibri", java.awt.Font.BOLD, 14));
        header.setBorder(UIManager.getBorder("Button.border"));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 12));
                setHorizontalAlignment(CENTER);
                return c;
            }
        };
        table.setDefaultRenderer(Object.class, cellRenderer);
    }

    /**
     * Adds a new group to the competition and assigns animals to the group.
     *
     * @param parent the parent frame
     * @param pan the competition panel
     */
    private void addNewGroup(JFrame parent, CompetitionPanel pan) {
        if (this.waterAirTerrCurrent.equals("Air")) {
            if (pan.GetGroupsAir() < 5)
                pan.SetGroupsAir();
            else {
                GroupsIsFull();
                return;
            }
        }
        if (this.waterAirTerrCurrent.equals("Water")) {
            if (pan.GetGroupsWater() < 4)
                pan.SetGroupsWater();
            else {
                GroupsIsFull();
                return;
            }
        }
        int size = this.allAnimals.size();
        pan.AddAnimal(parent, null); // add animal to group
        if (size != this.allAnimals.size()) {
            String newRow = this.allAnimals.lastElement().getName();
            animalGroups.add(new ArrayList<Animal>());
            tableModel.addColumn("Group " + (animalGroups.size()));
            animalGroups.get(animalGroups.size() - 1).add(this.allAnimals.lastElement());
            if (animalGroups.size() == 1) {
                tableModel.addRow(new Object[]{newRow});
                saveButton.setEnabled(false);
            } else {
                tableModel.setValueAt(newRow, 0, animalGroups.size() - 1);
                if (reguCourCurrent.equals("regular"))
                    saveButton.setEnabled(true);
                else
                    saveButton.setEnabled(false);
            }
            updateButtonPanel(parent, this.allAnimals, pan); // עידכון הכפתורים בכל הוספת עמודה
        }
    }

    /**
     * Adds an animal to a specific group in the competition.
     *
     * @param parent the parent frame
     * @param AnimalsCreated the list of animals created
     * @param pan the competition panel
     * @param groupIndex the index of the group to add the animal to
     */
    private void addAnimalToGroup(JFrame parent, Vector<Animal> AnimalsCreated, CompetitionPanel pan, int groupIndex) {
        if (animalGroups.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No groups available. Please add a group first.");
            return;
        }
        if (groupIndex >= 0 && groupIndex < animalGroups.size()) {
            if (animalGroups.get(groupIndex).size() < maxAnimalsInGroup) {// האם עברתי את מספר החיות המקסימלי
                int size = AnimalsCreated.size();
                pan.AddAnimal(parent, animalGroups.get(groupIndex).get(0).getTrack());
                if (size != AnimalsCreated.size()) {
                    animalGroups.get(groupIndex).add(AnimalsCreated.lastElement());
                    if (tableModel.getRowCount() < animalGroups.get(groupIndex).size()) {
                        Object[] emptyRow = new Object[animalGroups.size()]; // הוספת השורה הריקה לטבלה
                        tableModel.addRow(emptyRow);
                    }
                    if (!reguCourCurrent.equals("regular"))
                        SetSave();
                    tableModel.setValueAt(AnimalsCreated.lastElement().getName(),
                            animalGroups.get(groupIndex).size() - 1, groupIndex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Group is full. Cannot add more animals.");
            }
        }
    }

    /**
     * Updates the button panel to reflect the current state of the animal groups.
     *
     * @param parent the parent frame
     * @param AnimalsCreated the list of animals created
     * @param pan the competition panel
     */
    private void updateButtonPanel(JFrame parent, Vector<Animal> AnimalsCreated, CompetitionPanel pan) {
        if (buttonPanel != null)
            buttonPanel.removeAll();
        if (!reguCourCurrent.equals("regular")) {
            SetSave();
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                int columnIndex = i; // שמירת אינדקס העמודה
                JButton button = new JButton("Add to group No." + (i + 1));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addAnimalToGroup(parent, AnimalsCreated, pan, columnIndex);
                    }
                });

                buttonPanel.add(button);
            }
        } else {
            if (animalGroups.size() < 2)
                saveButton.setEnabled(false);
            else
                saveButton.setEnabled(true);
        }
        JButton addGroupButton = new JButton("Add Group");
        addGroupButton.addActionListener(e -> addNewGroup(parent, pan));
        buttonPanel.add(saveButton);
        buttonPanel.add(addGroupButton);
        buttonPanel.revalidate();
        buttonPanel.repaint();
        buttonPanel.setVisible(true);

    }

    /**
     * Enables or disables the save button based on the state of the animal groups.
     */
    private void SetSave() {
        boolean flag = true;
        int i;
        for (i = 0; i < animalGroups.size() && flag; i++) {
            if (animalGroups.get(i).size() < 2)
                flag = false;
        }
        if (flag && i > 1)
            saveButton.setEnabled(true);
        else
            saveButton.setEnabled(false);
    }

    /**
     * Handles the save button action, creating the appropriate tournament and setting up the competition.
     */
    private void SaveButton() {
        if (!reguCourCurrent.equals("regular")) {
            for (int i = 0; i < animalGroups.size(); i++) {
                if (animalGroups.get(i).size() < 2 && animalGroups.getFirst().size() != animalGroups.get(i).size()) {
                    JOptionPane.showMessageDialog(this,
                            " In a courier competition, each team Each group must contain an equal number of participants, ranging from 2 to 3", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    saveButton.setEnabled(false);
                    return;
                }
            }
        }
        SettingPoint();
        if (reguCourCurrent.equals("regular")) {
            RegularTournament thread = new RegularTournament(animalGroups, pan);
        } else {
            CourierTournament courierTournament = new CourierTournament(animalGroups, pan);
        }
        this.dispose();
        pan.AddCompetition(animalGroups);
    }

    /**
     * Sets the location and finish line of each animal in the competition based on the group type and competition type.
     */
    private void SettingPoint() {
        int size;
        if (!reguCourCurrent.equals("regular")) {
            size = animalGroups.getFirst().size();
            if (!waterAirTerrCurrent.equals("Terrestrial")) {
                for (int i = 0; i < animalGroups.size(); i++) {
                    int plusX = ((pan.getWidth() - Drawable.SIZE_PICTURE * 3 + 17)- (animalGroups.get(i).getFirst().getLocation().GetFromPointX())) / size;
                    int x = animalGroups.get(i).getFirst().getLocation().GetFromPointX();
                    for (int j = 0; j < size; j++) {
                        int y = animalGroups.get(i).get(j).getLocation().GetFromPointY();
                        int NewX = x + plusX * j;
                        animalGroups.get(i).get(j).setLocation(new Point(NewX, y));
                        animalGroups.get(i).get(j).SetFinishLine(new Point(NewX + plusX, y));
                    }
                }
            } else {
                int X = pan.getWidth() - (Drawable.SIZE_PICTURE * 3 + 115);
                int Y = pan.getHeight() - Drawable.SIZE_PICTURE -25;
                int TrackLength = X * 2 + Y * 2;
                int SegmentLength = TrackLength / size;
                Point NewPoint;
                for (int i = 0; i < animalGroups.size(); i++) {
                    for (int j = 0; j < size - 1; j++) {
                        RemainingLength = SegmentLength;
                        Animal animal = animalGroups.get(i).get(j);
                        int CurrenX = animal.getLocation().GetFromPointX();
                        int CurrenY = animal.getLocation().GetFromPointY();
                        NewPoint= new Point(CurrenX, CurrenY);
                        if(animal.getOrien() == Orientation.SOUTH)
                            MoveAllSouth(NewPoint,animal,SegmentLength,X,Y);
                        else if(animal.getOrien() == Orientation.NORTH)
                            MoveAllNorth(NewPoint,animal,SegmentLength,X,Y);
                        else if(animal.getOrien() == Orientation.EAST){
                            if (CurrenX + SegmentLength > X) {
                                MoveAllEast(NewPoint,animal,SegmentLength,X,Y);
                            }else NewPoint.SetX(CurrenX + SegmentLength);
                        }
                        else if(animal.getOrien() == Orientation.WEST)
                            MoveAllWest(NewPoint,animal,SegmentLength,X,Y);

                        animal.SetFinishLine(new Point(NewPoint));  // Update the animal's location

                        if (j < animalGroups.get(i).size() - 1) {
                            animalGroups.get(i).get(j + 1).setLocation(new Point(NewPoint));
                            if(NewPoint.GetFromPointX() == X)
                                animalGroups.get(i).get(j + 1).SetOrientation(Orientation.SOUTH);
                            if(NewPoint.GetFromPointY() == Y)
                                animalGroups.get(i).get(j + 1).SetOrientation(Orientation.WEST);
                            if(NewPoint.GetFromPointX() == 0)
                                animalGroups.get(i).get(j + 1).SetOrientation(Orientation.NORTH);
                        }
                    }
                }
                for (int i = 0; i < animalGroups.size(); i++) {
                    animalGroups.get(i).getLast().SetFinishLine(new Point(1, 10));
                }
            }
            pan.repaint();
        }
        else {//regular
            if(!waterAirTerrCurrent.equals("Terrestrial")){
                for(int i = 0; i < animalGroups.size(); i++) {
                    for (int j = 0; j < animalGroups.get(i).size(); j++) {
                        animalGroups.get(i).getFirst().SetFinishLine
                                (new Point(animalGroups.get(i).getFirst().getLocation().GetFromPointX()+((pan.getWidth() - Drawable.SIZE_PICTURE * 3 + 17)- (animalGroups.get(i).getFirst().getLocation().GetFromPointX()))
                                        ,animalGroups.get(i).getFirst().getLocation().GetFromPointY()));}
                }
            }
        }
        pan.repaint();
    }

    /**
     * Displays a message that the number of teams in the competition is full.
     */
    private void GroupsIsFull() {
        JOptionPane.showMessageDialog(this, "The number of teams in the competition is full", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Moves the animal east and adjusts its position if the segment length exceeds the track length.
     *
     * @param NewPoint the new point to set for the animal's position
     * @param animal the animal being moved
     * @param SegmentLength the length of the segment the animal should move
     * @param X the maximum X coordinate
     * @param Y the maximum Y coordinate
     */
    private void MoveAllEast(Point NewPoint, Animal animal, Integer SegmentLength, int X, int Y) {
        int CurrenX = NewPoint.GetFromPointX();
        RemainingLength = SegmentLength - (X - CurrenX);
        NewPoint.SetX(X);
        MoveAllSouth(NewPoint, animal, SegmentLength, X, Y);
    }

    /**
     * Moves the animal west and adjusts its position if the segment length exceeds the track length.
     *
     * @param NewPoint the new point to set for the animal's position
     * @param animal the animal being moved
     * @param SegmentLength the length of the segment the animal should move
     * @param X the maximum X coordinate
     * @param Y the maximum Y coordinate
     */
    private void MoveAllWest(Point NewPoint, Animal animal, Integer SegmentLength, int X, int Y) {
        int CurrenX = NewPoint.GetFromPointX();
        CurrenX = CurrenX - RemainingLength;
        if (CurrenX < 0) {
            CurrenX = 0;
            NewPoint.SetX(CurrenX);
            RemainingLength = RemainingLength - X;
            MoveAllNorth(NewPoint, animal, SegmentLength, X, Y);
        }
        else NewPoint.SetX(CurrenX);
    }

    /**
     * Moves the animal north and adjusts its position if the segment length exceeds the track length.
     *
     * @param NewPoint the new point to set for the animal's position
     * @param animal the animal being moved
     * @param SegmentLength the length of the segment the animal should move
     * @param X the maximum X coordinate
     * @param Y the maximum Y coordinate
     */
    private void MoveAllNorth(Point NewPoint, Animal animal, Integer SegmentLength, int X, int Y){
        int CurrenY = NewPoint.GetFromPointY();
        CurrenY = CurrenY - RemainingLength;
        if(CurrenY < 0){
            CurrenY = 10;
            NewPoint.SetY(CurrenY);
        }
        else NewPoint.SetY(CurrenY);
    }

    /**
     * Moves the animal south and adjusts its position if the segment length exceeds the track length.
     *
     * @param NewPoint the new point to set for the animal's position
     * @param animal the animal being moved
     * @param SegmentLength the length of the segment the animal should move
     * @param X the maximum X coordinate
     * @param Y the maximum Y coordinate
     */
    private void MoveAllSouth(Point NewPoint, Animal animal, Integer SegmentLength, int X, int Y) {
        int CurrenY = NewPoint.GetFromPointY();
        CurrenY = CurrenY + RemainingLength; // Move downwards
        if (CurrenY > Y) {
            CurrenY = Y;
            RemainingLength = RemainingLength - CurrenY;
            NewPoint.SetY(CurrenY);
            MoveAllWest(NewPoint, animal, SegmentLength, X, Y);
        }
        else NewPoint.SetY(CurrenY);
    }
}
