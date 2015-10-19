package me.gastherr.binarycon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BinaryConverterFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static String err_blank = "Brak wartoœci w polu ";
	public static String err_wartosc = "Nieprawid³owa wartoœæ w polu wprowadzania ";
	
	public BinaryConverterFrame(){
		
		//MAIN BODY //
		//TEXTFIELDS
		JPanel textfields = new JPanel();
		
		int max = 15;
		JTextField input1 = new JTextField(max);
		JTextField input2 = new JTextField(max);
		JTextField result1 = new JTextField(max);
		result1.setEditable(false);
		JTextField result2 = new JTextField(max);
		result2.setEditable(false);
		
		textfields.setLayout(new GridLayout(2,2));
		textfields.add(input1);
		textfields.add(result1);
		textfields.add(input2);
		textfields.add(result2);
		
		//BUTTONS
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,1));
				
		JButton bcon1 = new JButton("Na binarne");
		bcon1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = input1.getText();
				if(input.equals("")){
					error(err_blank+"pierwszym!");
					return;
				}
						
				int i = 0;
				try{
					i = Integer.parseInt(input);
				}catch(NumberFormatException e1){
					error(BinaryConverterFrame.err_wartosc+"1");
					return;
				}

				
				//BINARY CONVERTER
				StringBuilder i2 = new StringBuilder();
				while(i > 0){
					
					int x = i%2;
					if(i==1){
						i2.append("1");
						break;
					}
					if(i==0){
						i2.append("0");
						break;
					}
					i2.append(x+"");
					i = (i-x) /2;
				}

				result1.setText(i2.toString());
						
			}
		});
		JButton bcon2 = new JButton("Z binarnego");
		bcon2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = input2.getText();
				if(s.equals("")){
					error(err_blank+"drugim");
					return;
				}
				
				try{
					@SuppressWarnings("unused")
					double a = Double.parseDouble(s);
				}catch(NumberFormatException e2){
					error(err_wartosc+"2");
					return;
				}
				
				//FROM BINARY CONVERTER
				int res = 0;
				int max = s.length();
				if(s.charAt(max-1) == '0' || (s.length() == 1 && s.charAt(max-1) == '1')){
					res = Integer.parseInt(s.charAt(s.length()-1)+"");
					result2.setText(res+"");
					return;
				}
				
				res = 0;
				
				for(int i = max-1; i>-1; i--){
					int n = Integer.parseInt(s.charAt(i)+"");
					res += (int) (n * Math.pow(2, i));
				} 
				result2.setText(res+"");
			}
					
		});

		buttons.add(bcon1);
		buttons.add(bcon2);
				
		add(buttons, BorderLayout.WEST);
		add(textfields, BorderLayout.CENTER);
		pack();
		
		//FRAME LOCATION
		Toolkit dm = Toolkit.getDefaultToolkit();
		Dimension dm2 = dm.getScreenSize();
		int width = dm2.width;
		int height = dm2.height;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
	}
	
	public void error(String msg){
		Object msgO = msg;
		JOptionPane.showMessageDialog(this, msgO, "B³¹d", 0);
	}
	
}
