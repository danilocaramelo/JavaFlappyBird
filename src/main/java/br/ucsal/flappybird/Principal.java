package br.ucsal.flappybird;


import java.awt.EventQueue;
import javax.swing.JFrame;

    public class Principal extends JFrame{
    	
		private static final long serialVersionUID = 1L;
		
	public Principal () {
    	this.setTitle("FlappyBird"); // t�tulo do jogo
    	this.setSize(1200,700); // tamanho da janela
    	this.add(new JogoFinal()); //classe Menu
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
    


