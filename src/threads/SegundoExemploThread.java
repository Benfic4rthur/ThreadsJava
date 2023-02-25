package threads;

import javax.swing.JOptionPane;

public class SegundoExemploThread {
	public static void main(String[] args) throws InterruptedException {
		// suponhamos que chegamos em uma tela no sistema, onde se envia uma mala direta
		// para os clientes
		int escolhe = JOptionPane.showConfirmDialog(null, "Deseja enviar emails por mala direta?");
		if (escolhe == 0) {
			new Thread() {// INICIA O CODIGO DA THREAD para 
				public void run() { //executa o que nós queremos, é obrigatorio
					// rotina que sera executada em paralelo
					for (int pos = 0; pos < 10; pos++) {
						System.out.println("exemplo");
						// thread.sleep(tempo que deseja que espere para executar) se baseia em
						// milisegundos 1000 = 1 segundo
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
                            // Tratando a exceção
                            int resposta = JOptionPane.showConfirmDialog(null, "A execução da thread foi interrompida. Deseja continuar de onde parou?");
                            if (resposta == JOptionPane.NO_OPTION) {
                                break; // interrompe a execução da thread
                            }
						}
					} // fim do codigo em paralelo
				}
			}.start(); // starta o codigo que vai rodar paralelamente
			// Sistema normal, que esta a frente para visualização do usuario, ou seja, a
			// continuidade do fluxo de trabalho
			JOptionPane.showMessageDialog(null, "Disparando email para os clientes");
			JOptionPane.showMessageDialog(null, "Envio de emails chegou ao fim.");
		}
	}
}