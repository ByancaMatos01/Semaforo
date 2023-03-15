package View;

import java.util.concurrent.Semaphore;

import Controller.threadCarro;

public class Exemplo_video {

	public static void main(String[] args) {
		int permissoes=3;
		Semaphore semaforo= new Semaphore(permissoes);
		for(int idCarro=0; idCarro<10; idCarro++) {
			Thread tCarro= new threadCarro(idCarro,semaforo);
			tCarro.start();
		}

	}

}
