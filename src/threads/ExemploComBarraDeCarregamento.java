package threads;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ExemploComBarraDeCarregamento {
    public static void main(String[] args) throws InterruptedException {
        int escolhe = JOptionPane.showConfirmDialog(null, "Deseja enviar emails por mala direta?");
        if (escolhe == 0) {
            JFrame frame = new JFrame("Enviando mala direta");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setLocationRelativeTo(null); 

            JProgressBar progressBar = new JProgressBar(0, 10);
            progressBar.setStringPainted(true);
            frame.add(progressBar);

            new Thread() {
                public void run() { 
                    for (int pos = 0; pos < 10; pos++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            int resposta = JOptionPane.showConfirmDialog(null, "A execução da thread foi interrompida. Deseja continuar de onde parou?");
                            if (resposta == JOptionPane.NO_OPTION) {
                                break;
                            }
                        }
                        progressBar.setValue(pos + 1);
                    } 
                    frame.dispose();
                }
            }.start();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    frame.setVisible(true);
                }
            });
        }
    }
}
