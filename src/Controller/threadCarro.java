package Controller;

import java.util.concurrent.Semaphore;

public class threadCarro extends Thread {
	private int idCarro;
	private static int posicaoChegada;
	private static int posSaida;
	private Semaphore semaforo;

	public threadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {

		carroAndadndo();
//-------------critico------------------------
		try {
			semaforo.acquire();
			carroEstaciona();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
//-----------------fim----------------------
			carroSaido();
		}
	}

	private void carroAndadndo() {
		int distanciaTotal = (int) ((Math.random() * 1001) + 1000);
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(" # " + idCarro + " ja andou " + distanciaPercorrida + " m. ");
		}

		posicaoChegada++;
		System.out.println("# " + idCarro + " Foi o " + posicaoChegada + " o a chegar");
	}

	private void carroEstaciona() {
		System.out.println("# " + idCarro + " Estacionou");
		int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void carroSaido() {
		posSaida++;
		System.out.println("# " + idCarro + " foi o " + posSaida + " o.a sair");

	}

}
