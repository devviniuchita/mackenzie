import java.util.Scanner;

        public class Vetor {
            private static final int TAMANHO = 10;
            private static int[] vetor = new int[TAMANHO];
            private static int count = 0;

            // Método para adicionar elemento ao vetor
            public static void adicionarElemento(int elemento) {
                if (count < TAMANHO) {
                    vetor[count] = elemento;
                    count++;
                }
            }

            // Método para calcular a soma dos elementos
            public static int calcularSoma() {
                int soma = 0;
                for (int i = 0; i < count; i++) {
                    soma += vetor[i];
                }
                return soma;
            }

            // Método para encontrar o maior valor
            public static int encontrarMaior() {
                int maior = vetor[0];
                for (int i = 1; i < count; i++) {
                    if (vetor[i] > maior) {
                        maior = vetor[i];
                    }
                }
                return maior;
            }

            // Método para encontrar o menor valor
            public static int encontrarMenor() {
                int menor = vetor[0];
                for (int i = 1; i < count; i++) {
                    if (vetor[i] < menor) {
                        menor = vetor[i];
                    }
                }
                return menor;
            }

            // Método para calcular a média
            public static double calcularMedia(int soma) {
                if (count == 0) return 0.0;
                return (double) soma / count;
            }

            // NÃO ALTERE O CÓDIGO DO MÉTODO PRINCIPAL //
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

                // Inserir elementos no vetor
                for (int i = 0; i < TAMANHO; i++) {
                    int elemento = input.nextInt();
                    adicionarElemento(elemento);
                }

                // Calcular e exibir soma dos elementos
                int soma = calcularSoma();
                System.out.println("Soma dos elementos: " + soma);

                // Encontrar e exibir o maior valor
                int maior = encontrarMaior();
                System.out.println("Maior valor: " + maior);

                // Encontrar e exibir o menor valor
                int menor = encontrarMenor();
                System.out.println("Menor valor: " + menor);

                // Calcular e exibir a média dos elementos
                double media = calcularMedia(soma);
                System.out.println("Média dos elementos: " + media);
                input.close();
            }
        }
