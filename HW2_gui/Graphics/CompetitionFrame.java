/**
 * @author Noa Shem Tov
 */
package Graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * The CompetitionFrame class represents the main frame for the competition application.
 * It sets up the main window with a menu bar and a central competition panel.
 */
public class CompetitionFrame extends JFrame {
	
    private BufferedImage img;
    /**
     * Constructs a new CompetitionFrame.
     * Sets up the frame's layout, menu bar, and adds the CompetitionPanel.
     */
    public CompetitionFrame() {
        super("Competition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JMenuBar bar = new JMenuBar();
        JMenu FileMenu = new JMenu("File");
        JMenu HelpMenu = new JMenu("Help");
        JMenuItem ExitItem = new JMenuItem("Exit");
        JMenuItem helpItem = new JMenuItem("Help");
        FileMenu.add(ExitItem);
        HelpMenu.add(helpItem);
        ExitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        bar.add(FileMenu);
        bar.add(HelpMenu);
        this.setJMenuBar(bar);

        CompetitionPanel competitionPanelButton = new CompetitionPanel(this);
        this.add(competitionPanelButton,BorderLayout.CENTER);

        this.pack();
        this.setSize(1050, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    /**
     * The main method to run the CompetitionFrame.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new CompetitionFrame();
    }
}
