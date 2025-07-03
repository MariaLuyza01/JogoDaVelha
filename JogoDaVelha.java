import java.util.Scanner;

public class JogoDaVelha {

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        System.out.println();
        for(int linha = 0; linha < 3; linha++) {
            for(int coluna = 0; coluna < 3; coluna++) {
                System.out.print("\t" + tabuleiro[linha][coluna]);
                if(coluna < 2)
                    System.out.print("\t|");
            }
            System.out.println();
            if(linha < 2) {
                System.out.println("-------------------------------------------------------");
            }
        }
        System.out.println();
    }

    public static void fazerJogada(Scanner scanner, char[][] tabuleiro, char jogador) {
        int linha, coluna;
        do {
            System.out.println("Jogador '" + jogador + "' digite a linha (1, 2 ou 3):");
            linha = scanner.nextInt() - 1;

            System.out.println("Jogador '" + jogador + "' digite a coluna (1, 2 ou 3):");
            coluna = scanner.nextInt() - 1;

            if(tabuleiro[linha][coluna] != ' ') {
                System.out.println("Posição ocupada, escolha novamente.");
            }

        } while(tabuleiro[linha][coluna] != ' ');

        tabuleiro[linha][coluna] = jogador;
        imprimirTabuleiro(tabuleiro);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matriz = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        System.out.println("### Jogo da Velha ###");

        imprimirTabuleiro(matriz);

        char jogadorAtual = 'X';

        while (true) {
            fazerJogada(scanner, matriz, jogadorAtual);

            if (verificarVitoria(matriz, jogadorAtual)) {
                System.out.println("Jogador '" + jogadorAtual + "' venceu!");
                break;
            }

            if (verificarEmpate(matriz)) {
                System.out.println("Empate!");
                break;
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

  
   public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
    // Verifica linhas
    for (int i = 0; i < 3; i++) {
        if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
            return true;
        }
    }

    // Verifica colunas
    for (int i = 0; i < 3; i++) {
        if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
            return true;
        }
    }

    // Verifica diagonais
    if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
        return true;
    }

    if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
        return true;
    }

    return false;
}

public static boolean verificarEmpate(char[][] tabuleiro) {
    for (int linha = 0; linha < 3; linha++) {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (tabuleiro[linha][coluna] == ' ') {
                return false;
            }
        }
    }
    return true;
}


}



