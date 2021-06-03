package br.ucsal.flappybird;

import java.awt.Event;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.FontUIResource;

    public class Principal extends JFrame{
    	
   
    public Principal () {
    	this.setTitle("FlappyBird"); // t�tulo do jogo
    	this.setSize(1200,700); // tamanho da janela
    	this.add(new JogoMovimento()); //classe Menu
    	this.setResizable(false); // maximizar janela (false) 
    	
    	this.setLocationRelativeTo(null); // inicializar janela no meio da tela 
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*Isso faz com que o aplicativo seja encerrado 
    	quando o aplicativo recebe um evento de fechamento de janela do sistema operacional.*/
    	
    }
	public static void main(String[] args) throws Exception {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new Principal().setVisible(true);				
    		}
    	});
     }
  }
    


