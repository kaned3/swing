package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame{

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	
	public MainFrame(){
		super("Create Person");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		controller = new Controller();
		
		tablePanel.setData(controller.getPeople());
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		setJMenuBar(createMenuBar());
		
		toolbar.setStringListener(new StringListener(){
			@Override
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});
		
		formPanel.setFormListener(new FormListener(){
			public void formEventOccurred(FormEvent e){
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});
		
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(500,400));
		setSize(800,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
				
		showFormItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)ev.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 
				ActionEvent.CTRL_MASK));
		
		importDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		
		exportDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				String text = JOptionPane.showInputDialog(MainFrame.this, "Enter your username",
						"Enter User Name", JOptionPane.OK_OPTION|JOptionPane.QUESTION_MESSAGE);
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit?", 
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION); 
				
				if(action == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		
		return menuBar;
	}
	
}
