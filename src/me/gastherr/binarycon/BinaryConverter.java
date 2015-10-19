package me.gastherr.binarycon;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BinaryConverter {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame bcf = new BinaryConverterFrame();
				bcf.setTitle("BinaryConverter v1");
				bcf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bcf.setVisible(true);
			}
			
		});

	}

}
