package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import animals.Animal;
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
	private AddAnimalDialog addAniDialog;
	private Vector<String> selectedCompetition = new Vector<>();
	private String choiceString;
	private JFrame screenFrame;
	private JPanel boardPanel;

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
			addCompDialog = new AddCompetitionDialog(parent);
			choiceString = addCompDialog.getSelectedCompetition();
			if (choiceString != null)
				selectedCompetition.add(choiceString);
		});
		boardButton.add(AddCompetitionButton);

		JButton AddAnimalButton = new JButton("Add Animal");
		AddAnimalButton.addActionListener(e -> AddAnimal(parent));
		boardButton.add(AddAnimalButton);

		JButton ClearButton = new JButton("Clear");
		ClearButton.addActionListener(e -> {
			if (AnimalsCreated.isEmpty()) 
				JOptionPane.showMessageDialog(null, "No animal was created");
			else {
				boolean flag = false;
				for (Animal animal : AnimalsCreated) {
					if(!animal.GetIsCleard()) 
						flag = true;
				}
				if(flag) ClearAnimal();
				else JOptionPane.showMessageDialog(null, "there is no animals to clear");
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
					if(!animal.GetIsCleard()) 
						flag = true;
				}
				if(flag) EatSelectedAnimal();
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
	private void AddAnimal(JFrame parent) {
		if (selectedCompetition.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Competition selected. Please select an option.");
			setVisible(true);
		} else {
			addAniDialog = new AddAnimalDialog(parent, selectedCompetition, AnimalsCreated, this);
			if (!AnimalsCreated.isEmpty()) {
				AnimalsCreated.lastElement().drawObject(getGraphics());
				Timer timer = new Timer(1000, e -> {
					moveLastAnimal();
				});
				timer.start();
				// repaint();
			}
		}
	}

	/**
	 * Moves the last added animal based on its speed and updates its energy.
	 */
	private void moveLastAnimal() {
		if (AnimalsCreated.isEmpty())
			return;
		Animal animal = AnimalsCreated.lastElement();
		Point location = animal.getLocation();
		int x = location.GetFromPointX();
		int y = location.GetFromPointY();
		int speed = animal.getSpeed();
		x += speed;
		// y += speed;
		int panelWidth = boardPanel.getWidth();
		int panelHeight = boardPanel.getHeight();
		if (x > panelWidth - 100)
			x = 0;
		if (y > panelHeight - 100)
			y = 0;
		int Dis = 0;
		if (animal.GetEnergyAmount() > 0)
			Dis = (int) animal.move(new Point(x, y));
		animal.SetEnergyAmount(Dis / speed);
		repaint();
	}

	/**
	 * Displays information about all the animals in a table.
	 */
	private void showInfoDialog() {
		String[] columnNames = { "Animal", "Category", "Type", "Speed", "Energy Amount", "Distance",
				"Energy Consumption" };
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
						JOptionPane.showMessageDialog(screenFrame,
								animal.getName() + " is already full and does not need to be fed.");
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

			}
		}
	}

	/**
	 * Clears the selected animal from the competition.
	 */
	private void ClearAnimal() {
		Vector<Animal> animalsToShow = new Vector<>();
		String selectedAnimalName = SelectedAnimalFromComobox(animalsToShow);
		if (selectedAnimalName != null) {
			for (Animal animal : animalsToShow) {
				if (animal.getName().equals(selectedAnimalName)) {
					animal.SetCleard();
					JOptionPane.showMessageDialog(screenFrame, animal.getName() + " is cleard");
					repaint();
					return;
				}
			}
		}
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

}
