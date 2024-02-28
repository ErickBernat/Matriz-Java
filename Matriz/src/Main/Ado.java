package Main;

import javax.swing.JOptionPane;

public class Ado {
	public static void main(String[] args) {

		double soma = 0;
		int principal = 0, secundaria = 0, opcao = 0, ordem = 0, valor = 0, maior = 0, menor = 0;
		
		// Opçao para criar a matriz ou nao
		opcao = JOptionPane.showOptionDialog(null, "Criar uma nova matriz ?", "Matriz", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new String[] { "Sim", "Nao" }, "Nao");
		
		//While ate a opçao for nao
		while (opcao != JOptionPane.NO_OPTION) {

			// Pergunta a ordem da matriz quadrada e inicializa ela (trata a exceção caso aperte em cancelar)
			try {
				ordem = Integer.parseInt(JOptionPane.showInputDialog("Digite a ordem da matriz"));
			} catch (NumberFormatException cancelou) {
				JOptionPane.showMessageDialog(null, "Fechou o programa");
				System.exit(0);
			}
			//inicializa a matriz
			int[][] matriz = new int[ordem][ordem];

			// Preenche a matriz com os valores digitados(trata a exceção caso aperte em cancelar)
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					try {
						valor = Integer.parseInt(
								JOptionPane.showInputDialog("Digite o valor da linha " + i + " Coluna " + j + ":"));
					} catch (NumberFormatException cancelou) {
						JOptionPane.showMessageDialog(null, "Fechou o programa");
						System.exit(0);
					}

					matriz[i][j] = valor;

				}
			}
			maior = matriz[0][0];
			menor = matriz[0][0];
			// Realiza os calculos do problema
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					// Procura algum numero maior
					if (matriz[i][j] > maior) {
						maior = matriz[i][j];
					}
					// Procura algum numero menor
					if (matriz[i][j] < menor) {
						menor = matriz[i][j];
					}
					// soma dos valores da matriz
					soma += matriz[i][j];

					// soma da diagonal principal
					if (i == j) {
						principal += matriz[i][j];
					}
					// soma da diagonal secundaria
					if ((i + j) == matriz.length - 1) {
						secundaria += matriz[i][j];
					}
				}
			}

			// Exibe a matriz
			JOptionPane.showMessageDialog(null, "MATRIZ \n" + imprimirM(matriz));
			// Exibe os calculos
			JOptionPane.showMessageDialog(null,
					"A soma de todos os numeros da matriz é: " + soma + "\n" + "O maior numero da matriz é: " + maior
							+ "\n" + "O menor numero da matriz é: " + menor + "\n"
							+ "A soma da diagonal principal da matriz é: " + principal + "\n"
							+ "A soma da diagonal secundaria da matriz é: " + secundaria);
			// Opçao para criar a matriz ou nao
			opcao = JOptionPane.showOptionDialog(null, "Criar uma nova matriz ?", "Matriz", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new String[] { "Sim", "Nao" }, "Nao");
			//Reinicia o valor das variaveis
			soma=0;
			principal = 0;
			secundaria = 0;
			ordem = 0;
			maior = 0;
			menor = 0;
			
			
		}

	}

	// Metodo para imprimir a matriz
	public static String imprimirM(int[][] matriz) {
		StringBuilder e = new StringBuilder();

		for (int i = 0; i < matriz.length; i++) {
			e.append("| ");
			for (int j = 0; j < matriz.length; j++) {
				if (j == matriz.length - 1) {
					e.append(matriz[i][j]);
				} else {
					e.append(matriz[i][j] + "  ");
				}
			}
			e.append(" |");
			e.append("\n");
		}
		e.append("\n");

		return e.toString();
	}
}
