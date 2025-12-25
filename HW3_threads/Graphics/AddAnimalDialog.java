/**
 @authors Noa Shem Tov  , Linoy Nisim Pur
 */
package Graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import animals.*;
import mobility.Point;
/**
 * The AddAnimalDialog class is responsible for displaying a dialog that allows the user
 * to add an animal to the competition. It includes options to select the type of animal,
 * input its details, and handle the validation and creation of the animal instance.
 */
public class AddAnimalDialog extends JDialog {

	private JRadioButton Alligator;
	private JRadioButton Dog;
	private JRadioButton Cat;
	private JRadioButton Snake;
	private JRadioButton Eagle;
	private JRadioButton Pigeon;
	private JRadioButton Dolphin;
	private JRadioButton Whale;
	private JButton okButton;
	private JButton cancelButton;
	private ButtonGroup buttonGroup;

	private JButton cancelAnimalDetailesButton;
	private JButton okAnimalDetailesButton;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel speedLabel;
	private JTextField speedField;
	private JLabel maxEnergyLabel;
	private JTextField maxEnergyField;
	private JLabel energyPerMeterLabel;
	private JTextField energyPerMeterField;
	private JDialog detailsDialog;

	private JLabel TrackPoolNumberLabel;
	private JComboBox<String> trackNumberComboBox;

	private String selectedAnimal;
	private CompetitionPanel panel;
	
	private String trackCourier;

	private String CurrentCompetition;
	 /**
     * Constructs an AddAnimalDialog with the specified parameters.
     *
     * @param parent the parent frame
     * @param selectedCompetition the list of selected competitions
     * @param AnimalsCreated the list of animals created
     * @param pan the competition panel
     */
	public AddAnimalDialog(JFrame parent, Vector<String> selectedCompetition, Vector<Animal> AnimalsCreated,
			CompetitionPanel pan,String Track) {
		super(parent, "Add Animal", true);
		setLayout(new BorderLayout());
		panel = pan;
		initializeComponents();
		trackCourier = Track;
		this.CurrentCompetition = selectedCompetition.lastElement();

		JPanel buttonPanel = createButtonPanel();
		JPanel radioPanel = createRadioPanel();

		okButton.setEnabled(false);

		add(new JLabel("Select Animal"), BorderLayout.NORTH);
		add(radioPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		addRadioButtonListeners(selectedCompetition);

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleOkButton(parent, AnimalsCreated);
				dispose();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedAnimal = null;
				dispose();
			}
		});

		setSize(300, 300);
		setLocationRelativeTo(parent);
		this.setVisible(true);
	}
	 /**
     * Resets the detail fields to their default values.
     */
	private void resetDetailFields() {
	    nameField.setText("");
	    speedField.setText("");
	    maxEnergyField.setText("");
	    energyPerMeterField.setText("");
	    if (trackNumberComboBox != null) {
	        trackNumberComboBox.setSelectedIndex(-1);  // אפס את הבחירה בקומבו בוקס
	    }
	}
	 /**
     * Initializes the components of the dialog.
     */
	private void initializeComponents() {
		Alligator = new JRadioButton("Alligator");
		Dog = new JRadioButton("Dog");
		Cat = new JRadioButton("Cat");
		Snake = new JRadioButton("Snake");
		Eagle = new JRadioButton("Eagle");
		Pigeon = new JRadioButton("Pigeon");
		Dolphin = new JRadioButton("Dolphin");
		Whale = new JRadioButton("Whale");

		buttonGroup = new ButtonGroup();
		buttonGroup.add(Alligator);
		buttonGroup.add(Dog);
		buttonGroup.add(Cat);
		buttonGroup.add(Snake);
		buttonGroup.add(Eagle);
		buttonGroup.add(Pigeon);
		buttonGroup.add(Dolphin);
		buttonGroup.add(Whale);

		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
	}
	 /**
     * Creates the button panel for the dialog.
     *
     * @return the created button panel
     */
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		return buttonPanel;
	}
	  /**
     * Creates the radio button panel for selecting animal types.
     *
     * @return the created radio button panel
     */
	private JPanel createRadioPanel() {
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(8, 1));
		radioPanel.add(Alligator);
		radioPanel.add(Dog);
		radioPanel.add(Cat);
		radioPanel.add(Snake);
		radioPanel.add(Eagle);
		radioPanel.add(Pigeon);
		radioPanel.add(Dolphin);
		radioPanel.add(Whale);
		return radioPanel;
	}
	 /**
     * Adds action listeners to the radio buttons for selecting animal types.
     *
     * @param selectedCompetition the list of selected competitions
     */
	private void addRadioButtonListeners(Vector<String> selectedCompetition) {
		String TerrestrialAnimals = "Terrestrial";
		String WaterAnimals = "Water";
		String AirAnimals = "Air";

		Dog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, TerrestrialAnimals);
			}
		});
		Alligator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, WaterAnimals);
			}
		});
		Cat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, TerrestrialAnimals);
			}
		});
		Eagle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, AirAnimals);
			}
		});
		Pigeon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, AirAnimals);
			}
		});
		Dolphin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, WaterAnimals);
			}
		});
		Whale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, WaterAnimals);
			}
		});
		Snake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAnimalSelection(selectedCompetition, TerrestrialAnimals);
			}
		});
	}
	 /**
     * Handles the selection of an animal type and validates the competition type.
     *
     * @param selectedCompetition the list of selected competitions
     * @param animalType the type of animal selected
     */
	private void handleAnimalSelection(Vector<String> selectedCompetition, String animalType) {
		if (selectedCompetition != null ){
			if(!selectedCompetition.lastElement().equals(animalType)) {
			JOptionPane.showMessageDialog(null, "The animal type must match the competition type.");
			buttonGroup.clearSelection();
			okButton.setEnabled(false);
		} else okButton.setEnabled(true);
	}}
	 /**
     * Handles the OK button click event, which confirms the animal selection.
     *
     * @param parent the parent frame
     * @param AnimalsCreated the list of animals created
     */
	private void handleOkButton(JFrame parent, Vector<Animal> AnimalsCreated) {
		if (Alligator.isSelected()) {
			selectedAnimal = "Alligator";
		} else if (Dog.isSelected()) {
			selectedAnimal = "Dog";
		} else if (Cat.isSelected()) {
			selectedAnimal = "Cat";
		} else if (Snake.isSelected()) {
			selectedAnimal = "Snake";
		} else if (Eagle.isSelected()) {
			selectedAnimal = "Eagle";
		} else if (Pigeon.isSelected()) {
			selectedAnimal = "Pigeon";
		} else if (Dolphin.isSelected()) {
			selectedAnimal = "Dolphin";
		} else if (Whale.isSelected()) {
			selectedAnimal = "Whale";
		}

		JOptionPane.showMessageDialog(null, "You selected " + selectedAnimal + ".");
		dispose();
		openAnimalDetailsDialog(parent, selectedAnimal, AnimalsCreated);
	}

	 /**
     * Opens a dialog for entering the details of the selected animal.
     *
     * @param parent the parent frame
     * @param selectedAnimal the type of animal selected
     * @param AnimalsCreated the list of animals created
     */
	private void openAnimalDetailsDialog(JFrame parent, String selectedAnimal, Vector<Animal> AnimalsCreated) {
		detailsDialog = new JDialog(parent, "Enter " + selectedAnimal + " Details", true);
		detailsDialog.setLayout(new BorderLayout());

		detailsDialog.add(new JLabel("Please enter:"), BorderLayout.NORTH);

		JPanel detailsPanel = new JPanel();
		detailsPanel.setLayout(new GridLayout(6, 2));
		detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		nameLabel = new JLabel("Name:");
		nameField = new JTextField();
		speedLabel = new JLabel("Speed:");
		speedField = new JTextField();
		maxEnergyLabel = new JLabel("Max Energy:");
		maxEnergyField = new JTextField();
		energyPerMeterLabel = new JLabel("Energy Per Meter:");
		energyPerMeterField = new JTextField();

		detailsPanel.add(nameLabel);
		detailsPanel.add(nameField);
		detailsPanel.add(speedLabel);
		detailsPanel.add(speedField);
		detailsPanel.add(maxEnergyLabel);
		detailsPanel.add(maxEnergyField);
		detailsPanel.add(energyPerMeterLabel);
		detailsPanel.add(energyPerMeterField);

		String[] airTracks = { "Please choose", "1", "2", "3", "4", "5" };
		String[] waterTracks = { "Please choose", "1", "2", "3", "4" };

		if (selectedAnimal.equals("Eagle") || selectedAnimal.equals("Pigeon")) {
			if(trackCourier != null) {
				String[] airTrackCourier =  { trackCourier };
				trackNumberComboBox = new JComboBox<>(airTrackCourier);
				trackNumberComboBox.setEnabled(false);
			}
			else 
				trackNumberComboBox = new JComboBox<>(airTracks);
			
			TrackPoolNumberLabel = new JLabel("Track Number:");
			detailsPanel.add(TrackPoolNumberLabel);
			detailsPanel.add(trackNumberComboBox);
			
		} else if (selectedAnimal.equals("Dolphin") || selectedAnimal.equals("Whale")|| selectedAnimal.equals("Alligator")) {
			if(trackCourier != null) {
				String[] WaterTrackCourier =  { trackCourier };
				trackNumberComboBox = new JComboBox<>(WaterTrackCourier);
				trackNumberComboBox.setEnabled(false);}
			else
				trackNumberComboBox = new JComboBox<>(waterTracks);
			
			TrackPoolNumberLabel = new JLabel("Pool Number:");
			detailsPanel.add(TrackPoolNumberLabel);
			detailsPanel.add(trackNumberComboBox);
		} else {
			trackNumberComboBox = new JComboBox<>();
		}

		addDocumentFilters();

		okAnimalDetailesButton = new JButton("OK");
		okAnimalDetailesButton.setEnabled(false); // Initially disable OK button
		okAnimalDetailesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleOkAnimalDetailsButton(AnimalsCreated);
				
			}
		});

		cancelAnimalDetailesButton = new JButton("Cancel");
		cancelAnimalDetailesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetDetailFields();
				detailsDialog.dispose();
			}
		});
		DocumentListener docListener = new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields();
			}
		};

		nameField.getDocument().addDocumentListener(docListener);
		speedField.getDocument().addDocumentListener(docListener);
		maxEnergyField.getDocument().addDocumentListener(docListener);
		energyPerMeterField.getDocument().addDocumentListener(docListener);
		if (trackNumberComboBox.getItemCount() > 0) {
			trackNumberComboBox.addActionListener(e -> checkFields());
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okAnimalDetailesButton);
		buttonPanel.add(cancelAnimalDetailesButton);

		detailsDialog.add(detailsPanel, BorderLayout.CENTER);
		detailsDialog.add(buttonPanel, BorderLayout.SOUTH);

		detailsDialog.setSize(450,300);
		detailsDialog.setLocationRelativeTo(parent);
		detailsDialog.setVisible(true);
	}
	 /**
     * Checks if all required fields are filled and enables the OK button accordingly.
     */
	private void checkFields() {
		String name = nameField.getText().trim();
		String speed = speedField.getText().trim();
		String maxEnergy = maxEnergyField.getText().trim();
		String energyPerMeter = energyPerMeterField.getText().trim();
		boolean allFilled = !name.isEmpty() && !speed.isEmpty() && !maxEnergy.isEmpty() && !energyPerMeter.isEmpty();

		if ((trackNumberComboBox.getSelectedItem() != null)
				&& (trackNumberComboBox.getSelectedItem().equals("Please choose")))
			okAnimalDetailesButton.setEnabled(false);
		else
			okAnimalDetailesButton.setEnabled(allFilled);
	}
	  /**
     * Handles the OK button click event for the animal details dialog.
     * Validates the input and creates a new animal instance based on the entered details.
     *
     * @param AnimalsCreated the list of animals created
     */
	private void handleOkAnimalDetailsButton(Vector<Animal> AnimalsCreated) {
		try {
			String name = nameField.getText().trim();
			int speed = Integer.parseInt(speedField.getText().trim());
			int maxEnergy = Integer.parseInt(maxEnergyField.getText().trim());
			int energyPerMeter = Integer.parseInt(energyPerMeterField.getText().trim());

			if ((selectedAnimal.equals("Snake") || selectedAnimal.equals("Alligator")) && speed > 5) {
				JOptionPane.showMessageDialog(AddAnimalDialog.this,
						"Speed for reptiles must be 5 or less. Please re-enter.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				okAnimalDetailesButton.setEnabled(false);
				return;
			}
			if (energyPerMeter >= maxEnergy) {
				JOptionPane.showMessageDialog(AddAnimalDialog.this, "maxEnergy should be greater than energyPerMeter",
						"Input Error", JOptionPane.ERROR_MESSAGE);
				okAnimalDetailesButton.setEnabled(false);
				return;
			}
			if (!FindName(name, AnimalsCreated)) {
				JOptionPane.showMessageDialog(AddAnimalDialog.this, "Change name please",
						"Input Error", JOptionPane.ERROR_MESSAGE);
				okAnimalDetailesButton.setEnabled(false);
				return;
			}
			
			Point pointAnimalPoint;
			int PoolTrack = 0;
			int trackNumber = 0;
			if (!selectedAnimal.equals("Dog") && !selectedAnimal.equals("Cat") && !selectedAnimal.equals("Snake")) {
				if(trackCourier != null)
					trackNumber =  Integer.parseInt(trackCourier);
				else {
					trackNumber = trackNumberComboBox.getSelectedIndex();
					if(!AnimalsCreated.isEmpty()){
						for(Animal animal: AnimalsCreated)
						{
							int trackChoice = Integer.parseInt(animal.getTrack());
							if(!animal.GetIsCleard() && animal.Category().equals(CurrentCompetition ) && trackCourier == null && trackNumber == trackChoice ){
								JOptionPane.showMessageDialog(AddAnimalDialog.this, "Please choose a different track, the current one is already selected","Input Error", JOptionPane.ERROR_MESSAGE);
								okAnimalDetailesButton.setEnabled(false);
								return;
							}
						}
					}
				}
				PoolTrack = trackNumber;
				pointAnimalPoint = TrackPoolPosition(PoolTrack);
			} else
				pointAnimalPoint = new Point(0, 10);
			Animal newAnimal = null;
			switch (selectedAnimal) {
			case "Dog":
				newAnimal = new Dog(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			case "Cat":
				newAnimal = new Cat(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			case "Snake":
				newAnimal = new Snake(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			case "Alligator":
				newAnimal = new Alligator(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			case "Eagle":
				newAnimal = new Eagle(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			case "Pigeon":
				newAnimal = new Pigeon(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			case "Dolphin":
				newAnimal = new Dolphin(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			case "Whale":
				newAnimal = new Whale(name, speed, pointAnimalPoint, maxEnergy, energyPerMeter, panel,String.valueOf(PoolTrack));
				break;
			}
			AnimalsCreated.add(newAnimal);
			JOptionPane.showMessageDialog(AddAnimalDialog.this, "Animal details saved.");
			dispose();
			detailsDialog.dispose();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(AddAnimalDialog.this,
					"Please enter valid numbers for speed, max energy, and energy per meter.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(AddAnimalDialog.this, ex.getMessage(), "Input Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	private boolean FindName(String name,Vector<Animal> AnimalsCreated ) {
		for (Animal Other : AnimalsCreated) {
			if(Other.getName().equals(name))
				return false;}
			return true;
		}
	 /**
     * Determines the position of the animal on the track or in the pool based on the selected track number.
     *
     * @param choice the selected track number
     * @return the point representing the position of the animal
     */
	private Point TrackPoolPosition(int choice) {
		Point PointAnimal;

		if (selectedAnimal.equals("Pigeon") || selectedAnimal.equals("Eagle")) {
			switch (choice) {
			case 1: {PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25, 10 );  break;}
			case 2: {PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25,(choice - 1 ) *Drawable.SIZE_PICTURE*2 + 15  );  break;	}
			case 3: {	PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25,(choice - 1 ) *Drawable.SIZE_PICTURE*2 +15 );   break;  }
			default: PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25,(choice - 1 ) *Drawable.SIZE_PICTURE*2 + 23 );  break;	}
			return PointAnimal;
		}
		switch (choice) {
		case 1: {PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25, (2*choice - 1) * Drawable.SIZE_PICTURE  + 12);     break;}
		case 2: {PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25, (2*choice - 1) * Drawable.SIZE_PICTURE + 14);	      break;}
		case 3: {	PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25, (2*choice - 1) * Drawable.SIZE_PICTURE + 20);	  break;}
		default: PointAnimal = new Point(Drawable.SIZE_PICTURE*2-25, (2*choice - 1) * Drawable.SIZE_PICTURE + 25);	  break;}
		return PointAnimal;
	}
	/**
     * Adds document filters to the input fields to enforce valid input.
     */
	private void addDocumentFilters() {
		((AbstractDocument) nameField.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) {
				try {
					if (string.matches("[a-zA-Z]+")) {
						super.insertString(fb, offset, string, attr);
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error inserting text into document.");
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text,
					javax.swing.text.AttributeSet attrs) {
				try {
					if (text.matches("[a-zA-Z]+")) {
						super.replace(fb, offset, length, text, attrs);
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error replacing text in document.");
				}
			}
		});

		DocumentFilter numberFilter = new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) {
				try {
					if (string.matches("\\d+")) {
						super.insertString(fb, offset, string, attr);
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error inserting text into document.");
				}
			}

			public void replace(FilterBypass fb, int offset, int length, String text,
					javax.swing.text.AttributeSet attrs) {
				try {
					if (text.matches("\\d+")) {
						super.replace(fb, offset, length, text, attrs);
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error replacing text in document.");
				}
			}
		};

		((AbstractDocument) speedField.getDocument()).setDocumentFilter(numberFilter);
		((AbstractDocument) maxEnergyField.getDocument()).setDocumentFilter(numberFilter);
		((AbstractDocument) energyPerMeterField.getDocument()).setDocumentFilter(numberFilter);
	}

}