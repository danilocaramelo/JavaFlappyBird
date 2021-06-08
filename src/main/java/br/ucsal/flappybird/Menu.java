package br.ucsal.flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class Menu{

	private JButton play = new JButton("JOGAR"); 
    private JButton comojogar = new JButton("COMO JOGAR");
    private JButton resolucao = new JButton("RESOLU«√O");
    private JPanel thiis;
	
	public void MenuConfig() {
			
            //bot√µes    	
	     	play.setBackground(Color.GREEN);resolucao.setBackground(Color.GREEN);comojogar.setBackground(Color.GREEN);
	     	play.setForeground(Color.WHITE);resolucao.setForeground(Color.WHITE);comojogar.setForeground(Color.WHITE);
	     	play.setFont(new FontUIResource("SansSerif",Font.BOLD, 18));
	     	comojogar.setFont(new FontUIResource("SansSerif",Font.BOLD, 18));
	     	resolucao.setFont(new FontUIResource("SansSerif",Font.BOLD, 18));
	     	
	     	
	     	//posi√ß√£o x e y e largura e altura
	     	play.setBounds(325, 290, 540, 80);
	     	resolucao.setBounds(325, 400, 540, 80);
	     	comojogar.setBounds(325, 500, 540, 80);
	    
	}
	
	public void setPanel(JPanel thiis) {
		this.thiis = thiis;
		
		play.addActionListener((ActionListener) thiis);
	    resolucao.addActionListener((ActionListener) thiis);
	    comojogar.addActionListener((ActionListener) thiis);
	}
	
    //imagens
	public void desenhar(Graphics g, boolean go) {
	    
	    if (go) {
	    	ImageIcon ii = new ImageIcon(getClass().getResource("/Menu.png"));
			ImageIcon i = new ImageIcon(getClass().getResource("/nuveem.png"));
			Image title = ii.getImage();
			Image clouds = i.getImage();
		    MenuConfig();
	    	g.drawImage(title, 0,-5,1200,200,null);
		    g.drawImage(clouds, 0,190,1200,500,null);
		    thiis.add(play);
		    thiis.add(resolucao);
		    thiis.add(comojogar);
	    } else {
	    	thiis.remove(play);
	    	thiis.remove(resolucao);
	    	thiis.remove(comojogar);
	    	
	    }
	    
	    
	}
	
	
}