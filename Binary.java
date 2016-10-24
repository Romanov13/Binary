import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class Binary extends JFrame{
	
	JPanel basic;
	JPanel gridPanel;
	ArrayList<JCheckBox> checkBoxes;
	ArrayList<JLabel> indexes;
	String labels[] = {"128", "64", "32", "16", "8", "4", "2", "1"};
	JLabel result;
	
	Binary(){
		super("Binary");
		basic = new JPanel();
		indexes = new ArrayList<JLabel>();
		checkBoxes = new ArrayList<JCheckBox>();
		Box basicBox = new Box(BoxLayout.Y_AXIS);
		GridLayout basicGrid = new GridLayout(3, 8);
		basicGrid.setHgap(10);
		basicGrid.setVgap(5);
		gridPanel = new JPanel(basicGrid);
		basicBox.add(BorderLayout.CENTER, gridPanel);
		
		for(int i=0; i<8; i++){
			JLabel l = new JLabel("0");
			indexes.add(l);
			gridPanel.add(l);
		}
		for(int i=0; i<8; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			c.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e){
						for(int i=0; i<8; i++){
							if((c.isSelected())&&e.getSource().equals(checkBoxes.get(i))){
						indexes.get(i).setText("1");
						}
							if((!c.isSelected())&&e.getSource().equals(checkBoxes.get(i))){
								indexes.get(i).setText("0");
								}
					}
				}
			});
			checkBoxes.add(c);
			gridPanel.add(c);
		}
		for(int i=0; i<8; i++){
			JLabel l = new JLabel(labels[i]);
			gridPanel.add(l);
		}
		
		basic.add(BorderLayout.CENTER, basicBox);
		result = new JLabel("");
		basic.add(result);
		setContentPane(basic);
		
		setSize(800, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args){
		Binary bi = new Binary();
		bi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}