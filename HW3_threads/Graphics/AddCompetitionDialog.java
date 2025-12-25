/**
 @authors Noa Shem Tov  , Linoy Nisim Pur
 */
package Graphics;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import animals.Animal;

//import graphics.TeamsCompetitionTable;

/**
 * A class that responsible for creating a new competition The attributes of
 * this class are: competationType - contains the possible types of competition
 * combo - will show the user the options for the competition that he can choose
 * userChoiseCompString- variable that contains user choice (from list)
 */
public class AddCompetitionDialog extends JDialog {
    
	private JRadioButton courier;
	private JRadioButton regular;
	private ButtonGroup group;
	private JButton saveCompType;
	private JButton cancelCompType;
    
	private TypeCompetitionDialog choiceCompetitionDialog;
    private String selectedCompetition;
 

    /**
     * Constructs an AddCompetitionDialog with the specified parent frame.
     * Initializes the components and layout of the dialog.
     *
     * @param parentFrame the parent frame
     */
    public AddCompetitionDialog(JFrame parentFrame, CompetitionPanel competitionPanel, Vector<Animal> AnimalsCreated)
    {
        super(parentFrame, "Add Competition", true);
        setLayout(new BorderLayout());
        selectedCompetition = null;
        choiceCompetitionDialog = null;
        
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        
        //Definition of the competition type selection screen
        courier = new JRadioButton("Courier Competition");
		regular = new JRadioButton("Regular Competition");

		group = new ButtonGroup();
		group.add(courier);
		group.add(regular);
				
		JPanel radioPanelCompType = new JPanel();
		radioPanelCompType.setLayout(new GridLayout(2, 1));
		add(new JLabel("Select Competition Type:"));
		radioPanelCompType.add(courier);
		radioPanelCompType.add(regular);
		
		saveCompType = new JButton("Save");
		cancelCompType = new JButton("Cancel");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(saveCompType);
		buttonPanel.add(cancelCompType);
		
		add(buttonPanel,BorderLayout.SOUTH);//end of definition of the competition type selection screen
		add(radioPanelCompType,BorderLayout.CENTER);
		
//		cardPanel.add(new TeamsCompetitionTable(),"Teams competition table");
		
		/**
		 * This section of the code defines the listeners for the buttons in the competition type 
		 * and animal type selection screens. Each listener handles user interactions and updates 
		 * the application state based on the user's choices.
		 */
		//Listener of save button
		saveCompType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (group.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "No option selected. Please select an option.");
					setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Option selected.");
					if (courier.isSelected())
						selectedCompetition = "courier";
					else
						selectedCompetition = "regular";
					dispose();
					choiceCompetitionDialog = new TypeCompetitionDialog(parentFrame, selectedCompetition, competitionPanel, AnimalsCreated);
				}
			}
		});
        
		// Listener for the "Cancel" button on the competition type screen
		cancelCompType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedCompetition = null;
				dispose();
			}
		});
		pack();
		setSize(300,150);
        setLocationRelativeTo(parentFrame);
        this.setVisible(true);
    }

	/**
	 * Returns userChoiseCompString field
	 * 
	 * @return string which contains user choice
	 */
	public String getUserChoiceComp() {
		// System.out.print(userChoiseCompString);
		return selectedCompetition;
	}
	public TypeCompetitionDialog GetType() {
		return this.choiceCompetitionDialog;
	}
}
