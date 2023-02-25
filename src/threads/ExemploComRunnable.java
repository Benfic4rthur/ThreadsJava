package threads;

import javax.swing.JOptionPane;

public class ExemploComRunnable {
	public static void main(String[] args) throws InterruptedException {
		int escolhe = JOptionPane.showConfirmDialog(null, "Deseja enviar e-mails por mala direta?");
		if (escolhe == 0) {
			//instancia a thread como um objecto
			Thread email = new Thread(thread1);
			email.start(); //starta a thread instanciada acima, utilizando os codigos informado no Runnable abajo
			JOptionPane.showMessageDialog(null, "Disparando e-mails para os clientes");
			int escolhe2 = JOptionPane.showConfirmDialog(null, "Deseja enviar os xmls para os clientes??");
			if (escolhe2 == 0) {
				Thread xml = new Thread(thread2);
				xml.start();
			}
			if (escolhe2 == 0) {
				JOptionPane.showMessageDialog(null, "Disparando xmls para os clientes");
				JOptionPane.showMessageDialog(null, "Envio dos e-mails e xmls chegou ao fim.");
			} else {
				{
					JOptionPane.showMessageDialog(null, "Envio de e-mails chegou ao fim.");
				}
			}
		}
	}
	//cria o runnable que contem os codigos da thread1
	private static Runnable thread1 = new Runnable() {
		@Override
		public void run() {
			for (int pos = 0; pos < 5; pos++) {
				System.out.println("Envio E-mail " + (pos + 1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					int resposta = JOptionPane.showConfirmDialog(null,
							"O envio da mala direta foi interrompida. Deseja continuar de onde parou?");
					if (resposta == JOptionPane.NO_OPTION) {
						break;
					}
				}
			}
		}
	};
	//cria o runnable que contem os codigos da thread2
	private static Runnable thread2 = new Runnable() {
		@Override
		public void run() {
			for (int pos = 0; pos < 5; pos++) {
				System.out.println("Envio Xml " + (pos + 1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					int resposta = JOptionPane.showConfirmDialog(null,
							"O envio dos XMLS foi interrompido. Deseja continuar de onde parou?");
					if (resposta == JOptionPane.NO_OPTION) {
						break;
					}
				}
			}

		}
	};
}