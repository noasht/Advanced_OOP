package Graphics;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The AddCompetitionDialog class is responsible for displaying a dialog that allows the user
 * to add a competition. It includes options to select the type of competition (Air, Water, Terrestrial)
 * and handles the user's selection.
 */
public class AddCompetitionDialog extends JDialog {
	
    private JRadioButton airButton;
    private JRadioButton waterButton;
    private JRadioButton terrestrialButton;
    private JButton okButton;
    private JButton cancelButton;
    private ButtonGroup buttonGroup;
    
    private String selectedCompetition;

    /**
     * Constructs an AddCompetitionDialog with the specified parent frame.
     * Initializes the components and layout of the dialog.
     *
     * @param parentFrame the parent frame
     */
    public AddCompetitionDialog(JFrame parentFrame) {
        super(parentFrame, "Add Competition", true);
        setLayout(new BorderLayout());
        selectedCompetition = null;
        airButton = new JRadioButton("Air");
        waterButton = new JRadioButton("Water");
        terrestrialButton = new JRadioButton("Terrestrial");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(airButton);
        buttonGroup.add(waterButton);
        buttonGroup.add(terrestrialButton);
        
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1)); 
        radioPanel.add(airButton);
        radioPanel.add(waterButton);
        radioPanel.add(terrestrialButton);

        okButton = new JButton("OK");        
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "No option selected. Please select an option.");
                    setVisible(true);
                } 
                else 
                {	
                JOptionPane.showMessageDialog(null, "Option selected.");
                if	 (airButton.isSelected()) {
                    selectedCompetition = "Air animals";
                } 
                else if (waterButton.isSelected()) {
                    selectedCompetition = "Water animals";
                } 
                else if (terrestrialButton.isSelected()) {
                    selectedCompetition = "Terrestrial animals";
                	}
                dispose();
                }
            }
        });
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCompetition = null;
                dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(new JLabel("Select Competition Type:"), BorderLayout.NORTH);
        add(radioPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setSize(300, 150);
        setLocationRelativeTo(parentFrame);
        this.setVisible(true);
    }
    /**
     * Returns the selected competition type.
     *
     * @return the selected competition type
     */
    public String getSelectedCompetition() {
        return selectedCompetition;
    }
}