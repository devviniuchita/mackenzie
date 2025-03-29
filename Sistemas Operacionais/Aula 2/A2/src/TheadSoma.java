class ThreadSoma extends Thread {
    private int[] vetor;
    private int inicio, fim;
    private int somaParcial;

    public ThreadSoma(int[] vetor, int inicio, int fim) {
        this.vetor = vetor;
        this.inicio = inicio;
        this.fim = fim;
        this.somaParcial = 0;
    }

    public int getSomaParcial() {
        return somaParcial;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fim; i++) {
            somaParcial += vetor[i];
        }
    }
}