import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 boolean jogarNovamente = true;

 while (jogarNovamente) {
 char[][] tabuleiro = {
 {' ', ' ', ' '},
{' ', ' ', ' '},
{' ', ' ', ' '}
 };
 char jogador = 'x';
int rodadas = 0;
boolean venceu = false;

while (rodadas < 9 && !venceu) {
 System.out.println("Rodada " + (rodadas + 1));
System.out.println("É a vez do jogador " + (jogador == 'x' ? "1 (X)" : "2 (O)"));
mostrarTabuleiro(tabuleiro);

int linha, coluna;

while (true) {
System.out.print("Linha (1-3): ");
linha = scanner.nextInt() - 1;

System.out.print("Coluna (1-3): ");
coluna = scanner.nextInt() - 1;

if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
tabuleiro[linha][coluna] = jogador;
break;
} else {
   System.out.println("Posição inválida! Tente novamente.");
}
}

venceu = verificarVitoria(tabuleiro, jogador);

if (venceu) {
mostrarTabuleiro(tabuleiro);
System.out.println("Jogador " + (jogador == 'x' ? "1 (X)" : "2 (O)") + " ganhou!");
} else if (rodadas == 8) {
mostrarTabuleiro(tabuleiro);
 System.out.println("Empate!");
}

jogador = (jogador == 'x' ? 'o' : 'x');
rodadas++;
}

System.out.print("Deseja jogar novamente? (s/n): ");
String resposta = scanner.next();
if (!resposta.equalsIgnoreCase("s")) {
jogarNovamente = false;
System.out.println("Jogo encerrado.");
}
}
scanner.close();
}

public static void mostrarTabuleiro(char[][] tab) {
System.out.println();
for (int i = 0; i < 3; i++) {
System.out.println(" " + tab[i][0] + " | " + tab[i][1] + " | " + tab[i][2]);
if (i < 2)
System.out.println("---+---+---");
}
System.out.println();
}

public static boolean verificarVitoria(char[][] tab, char jogador) {
        // Checa linhas
for (int i = 0; i < 3; i++) {
 if (tab[i][0] == jogador && tab[i][1] == jogador && tab[i][2] == jogador) {
return true;
}
 }
        // Checa colunas
for (int i = 0; i < 3; i++) {
   if (tab[0][i] == jogador && tab[1][i] == jogador && tab[2][i] == jogador) {
    return true;
 }
 }
// Checa diagonais
if (tab[0][0] == jogador && tab[1][1] == jogador && tab[2][2] == jogador) {
return true;
}
if (tab[0][2] == jogador && tab[1][1] == jogador && tab[2][0] == jogador) {
 return true;
}
return false;
}
}

    
