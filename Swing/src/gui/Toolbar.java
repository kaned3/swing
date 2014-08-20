package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton viewButton;
	private JButton createButton;
	private JButton editButton;
	private JButton deleteButton;
	private StringListener textListener;
	
	public Toolbar(){
		setBorder(BorderFactory.createEtchedBorder());
		viewButton = new JButton("View Orders\n");
		createButton = new JButton("Create Order\n");
		editButton = new JButton("Edit Order\n");
		deleteButton = new JButton("Delete Order\n");
		
		viewButton.addActionListener(this);
		createButton.addActionListener(this);
		editButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(viewButton);
		add(createButton);
		add(editButton);
		add(deleteButton);
		
	}
	
	public void setStringListener(StringListener listener){
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if(clicked==viewButton){
			if(textListener != null){
				textListener.textEmitted("Hello\n");
			}
		}
		else if(clicked==createButton){
			if(textListener != null){
				textListener.textEmitted("Goodbye\n");
			}
		}
		else if(clicked==editButton){
			if(textListener != null){
				textListener.textEmitted("Goodbye\n");
			}
		}
		else if(clicked==deleteButton){
			if(textListener != null){
				textListener.textEmitted("Goodbye\n");
			}
		}
	}
	
}
