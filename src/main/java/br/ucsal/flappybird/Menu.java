package br.ucsal.flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class Menu extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton play = new JButton("JOGAR"); 
    private JButton comojogar = new JButton("COMO JOGAR");
    private JButton resolucao = new JButton("RESOLUÇÃO");
	
	public Menu() {

            //botões
	     	this.setLayout(null);    	    	
	     	play.setBackground(Color.GREEN);resolucao.setBackground(Color.GREEN);comojogar.setBackground(Color.GREEN);
	     	play.setForeground(Color.WHITE);resolucao.setForeground(Color.WHITE);comojogar.setForeground(Color.WHITE);
	     	play.setFont(new FontUIResource("SansSerif",Font.BOLD, 18));
	     	comojogar.setFont(new FontUIResource("SansSerif",Font.BOLD, 18));
	     	resolucao.setFont(new FontUIResource("SansSerif",Font.BOLD, 18));
	     	
	     	
	     	//posição x e y e largura e altura
	     	play.setBounds(325, 290, 540, 80);
//	     	resolucao.setBounds(55, 120, 180, 40);
//	     	comojogar.setBounds(55, 170, 180, 40);
	     	//adicionar um boto
	     	this.add(play);
//	     	this.add(resolucao); 
//	     	this.add(comojogar);
	    
	}
	//imagens
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);
		desenhar(g);
	}
    //imagens
	private void desenhar(Graphics g) {
		
		ImageIcon ii = new ImageIcon(getClass().getResource("/Menu.png"));
		ImageIcon i = new ImageIcon(getClass().getResource("/nuveem.png"));
		Image title = ii.getImage();
		Image clouds = i.getImage();

		g.drawImage(title, 0,-5,1200,200,null);
	    g.drawImage(clouds, 0,190,1200,500,null);
	}
	
	
}