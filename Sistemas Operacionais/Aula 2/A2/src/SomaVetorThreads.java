import java.util.Random;

public class SomaVetorThreads {
    public static void main(String[] args) {
        int[] vetor = new int[100];
        Random rand = new Random();

        // Preenchendo o vetor com números aleatórios entre 1 e 10
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(10) + 1;
        }

        // Criando e iniciando duas threads
        ThreadSoma t1 = new ThreadSoma(vetor, 0, vetor.length / 2);
        ThreadSoma t2 = new ThreadSoma(vetor, vetor.length / 2, vetor.length);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int somaTotal = t1.getSomaParcial() + t2.getSomaParcial();
        System.out.println("Soma total do vetor: " + somaTotal);
    }
}