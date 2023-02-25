package threads;



public class PrimeiroExemploThread {
	public static void main(String[] args) throws InterruptedException {
		for (int pos = 0; pos < 30; pos++) {
			
			System.out.println("Enviando email para os clientes, enviando o "+(pos+1)+"º email");
			//thread.sleep(tempo que deseja que espere para executar) se baseia em milisegundos 1000 = 1 segundo
			Thread.sleep(1000);
		}
		System.out.println("Envio de emails chegou ao fim.");
	}

}