package threads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//essa é a classe que contem a tela, isto não é um metodo é uma classe
public class TelaExemploThreadComSwingJdialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel jpanel = new JPanel(new GridBagLayout());// painel de componentes

	private JLabel descricaoHora = new JLabel("Time thread 1"); // cria o label com a descrição da thread 1
	private JTextField mostraTempo = new JTextField(); // cria o campo que irá mostrar a hora

	private JLabel descricaoHora2 = new JLabel("Time thread 2"); // cria o label com a descrição da thread 2
	private JTextField mostraTempo2 = new JTextField(); // cria o campo que irá mostrar a hora

	private JButton jButton = new JButton("Start"); // cria o botão responsavel por startar a thread
	private JButton jButton2 = new JButton("Stop"); // cria o botão responsavel por stopar a thread

	private Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			while (true) { // fica sempre rodando ehile (enquanto) for verdadeiro (estiver com o start clickado), quando clicar no stop
				//ele palsa a ser falso e para o while
				// chama o campo de texto e seta um texto, passa o formato e recebe a bata
				mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh-mm-ss").format(Calendar.getInstance().getTime()));
				try { // cria uma exception
					Thread.sleep(1000); //cria um intervalo de um segundo
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	
	private Runnable thread2 = new Runnable() { //cria o runnable da thread 2

		@Override
		public void run() {
			while (true) { // fica sempre rodando ehile (enquanto) for verdadeiro (estiver com o start clickado), quando clicar no stop
				//ele palsa a ser falso e para o while
				// chama o campo de texto2 e seta um texto, passa o formato e recebe a bata
				mostraTempo2.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				try { // cria uma exception
					Thread.sleep(1000); //cria um intervalo de um segundo
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	private Thread thread1Time; // cria a thread1
	private Thread thread2Time; // cria a thread2 

	// ↓ esse é o construtor responsavel por conter as configurações da tela
	public TelaExemploThreadComSwingJdialog() {// executa o que tiver dentro no momento dá abertura ou execução

		setTitle("tela exemplo threads");// responsavel pelo titulo da tela
		setSize(new Dimension(240, 240)); // responsavel pela dimensão da tela
		setLocationRelativeTo(null);// responsavel por fazer a aparecer no meio do monitor
		setResizable(false);// responsavel por não permitir redimensionar a tela
		// ↑ codigo responsavel praticamente pela configuação de exibição da tela

		// esse é o gerenciador de posicionamento de componentes ↓
		GridBagConstraints gridBagConstraints = new GridBagConstraints();// para utilizar o GridBagConstraints é
																			// necessário inicia-lo como um objeto
		gridBagConstraints.gridx = 0; // responsavel pelas linhas o valor após o igual é responsavel pela posição onde
										// deve iniciar
		gridBagConstraints.gridy = 0; // faz o mesmo só que para colunas
		gridBagConstraints.gridwidth = 2; // modifica o tamanho ocupado para 2
		gridBagConstraints.insets = new Insets(5, 10, 5, 5); // seta as distancias das bordas
		gridBagConstraints.anchor = GridBagConstraints.WEST; // seta a ancoragem a esquerda

		descricaoHora.setPreferredSize(new Dimension(200, 25)); // seta as dimensões do label responsavel pela descrição
																// da thread 1
		jpanel.add(descricaoHora, gridBagConstraints); // adiciona o label ao painel

		mostraTempo.setPreferredSize(new Dimension(200, 25));// seta as dimensões do painel que mostra a hora
		gridBagConstraints.gridy++; // movimenta o campo de texto para a proxima coluna
		mostraTempo.setEditable(false);// seta que os campos de texto que vão mostrar o tempo não possam ser editados
		jpanel.add(mostraTempo, gridBagConstraints);// adiciona o campo que mostra a hora ao painel

		descricaoHora2.setPreferredSize(new Dimension(200, 25)); // seta as dimensões do label2 responsavel pela
																	// descrição da thread 2
		gridBagConstraints.gridy++; // movimenta a label para a proxima coluna
		jpanel.add(descricaoHora2, gridBagConstraints); // adiciona o label2 ao painel

		mostraTempo2.setPreferredSize(new Dimension(200, 25));// seta as dimensões do painel que mostra a hora
		gridBagConstraints.gridy++; // movimenta o campo de texto para a proxima coluna
		mostraTempo2.setEditable(false); // seta que os campos de texto que vão mostrar o tempo não possam ser editados
		jpanel.add(mostraTempo2, gridBagConstraints);// adiciona o campo que mostra a hora ao painel

		/************************************************************************************************/

		gridBagConstraints.gridwidth = 1;// volta a ser 1 par que fique alinhado

		jButton.setPreferredSize(new Dimension(92, 25)); // seta as dimensões do botão
		gridBagConstraints.gridy++; // movimenta o botão para a proxima coluna
		jpanel.add(jButton, gridBagConstraints); // adiciona o botão ao painel

		jButton2.setPreferredSize(new Dimension(92, 25)); // seta as dimensões do botão
		gridBagConstraints.gridx++; // movimenta o botão para a proxima coluna
		jpanel.add(jButton2, gridBagConstraints); // adiciona o botão ao painel

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // executa o clique no botão start
				// TODO Auto-generated method stub
				thread1Time = new Thread(thread1); // instancia a thread
				thread1Time.start(); //starta a thread
				
				thread2Time = new Thread(thread2); // instancia a thread2
				thread2Time.start(); //starta a thread2
				jButton2.setEnabled(true); // reabilita o botão stop ao clicar em start
				jButton.setEnabled(false);
			}
		});
		
	
		jButton2.addActionListener(new ActionListener() { 

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) { // executa o clique no botão stop
				// TODO Auto-generated method stub
				thread1Time.stop(); //stopa a thread
				thread2Time.stop(); //stopa a thread2
				jButton2.setEnabled(false);
				jButton.setEnabled(true);

			}
		});
		jButton2.setEnabled(false); //desabilita o botão de stop ao abrir a tela
		

		add(jpanel, BorderLayout.WEST);// aqui adiciona o painel no dialog orientando ele a esquerda com o
										// borderLayout.WEST
		setVisible(true);// sempre sera o ultimo comando do construtor a ser executavel, ele é quem faz a
							// tela ser visivel verdadeiro ou falso
	}
}