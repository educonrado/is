package org.live.is;

public class CalculoVertices {

	int columnas = 0;
	int pisos = 0;
	// int[][] matrizCalculos;
	Vertice[][] matrizVertices;
	Vertice vertice;
	int incremento = 1;
	int numeroVariacionesPorVertice = 3;
	int[][] vectorVertice;

	public CalculoVertices(int columnas, int pisos) {
		super();
		this.columnas = columnas;
		this.pisos = pisos;
		crearMatriz(columnas, pisos);
		cargarMatriz();
		calculoMatrizPrincipal(columnas, pisos);
	}

	public void calculoMatrizPrincipal(int columnas, int pisos) {
		int calculoDimension=6;
		int columasMatrizResultado=6;
		vectorVertice = new int[calculoDimension][columasMatrizResultado];
		
		for (int i = 0; i < vectorVertice.length; i++) {
			for (int j = 0; j < vectorVertice[0].length; j++) {
				vectorVertice[i][j]=0;
				//se obtiene la matriz para guardar los datos
			}
		}

		vectorVertice[0][0] = matrizVertices[2][0].getHorizontal();// 2 debe ser variable
		vectorVertice[0][1] = matrizVertices[2][0].getVertical();
		vectorVertice[0][2] = matrizVertices[2][0].getGiro();
		vectorVertice[0][3] = matrizVertices[0][0].getHorizontal();// 0 primera
		vectorVertice[0][4] = matrizVertices[0][0].getVertical();
		vectorVertice[0][5] = matrizVertices[0][0].getGiro();

		vectorVertice[1][0] = matrizVertices[2][1].getHorizontal();
		vectorVertice[1][1] = matrizVertices[2][1].getVertical();
		vectorVertice[1][2] = matrizVertices[2][1].getGiro();
		vectorVertice[1][3] = matrizVertices[0][1].getHorizontal();
		vectorVertice[1][4] = matrizVertices[0][1].getVertical();
		vectorVertice[1][5] = matrizVertices[0][1].getGiro();

		vectorVertice[2][0] = matrizVertices[2][2].getHorizontal();
		vectorVertice[2][1] = matrizVertices[2][2].getVertical();
		vectorVertice[2][2] = matrizVertices[2][2].getGiro();
		vectorVertice[2][3] = matrizVertices[0][2].getHorizontal();
		vectorVertice[2][4] = matrizVertices[0][2].getVertical();
		vectorVertice[2][5] = matrizVertices[0][2].getGiro();
		// -------------------------------------------------

		// for1
		vectorVertice[3][0] = matrizVertices[0][0].getHorizontal();
		vectorVertice[3][1] = matrizVertices[0][0].getVertical();
		vectorVertice[3][2] = matrizVertices[0][0].getGiro();
		// for2
		vectorVertice[3][3] = matrizVertices[1][0].getHorizontal();
		vectorVertice[3][4] = matrizVertices[1][0].getVertical();
		vectorVertice[3][5] = matrizVertices[1][0].getGiro();

		// 2do
		// for1
		vectorVertice[4][0] = matrizVertices[0][1].getHorizontal();
		vectorVertice[4][1] = matrizVertices[0][1].getVertical();
		vectorVertice[4][2] = matrizVertices[0][1].getGiro();
		// for2
		vectorVertice[4][3] = matrizVertices[1][1].getHorizontal();
		vectorVertice[4][4] = matrizVertices[1][1].getVertical();
		vectorVertice[4][5] = matrizVertices[1][1].getGiro();

		// 2do
		// for1
		vectorVertice[5][0] = matrizVertices[0][2].getHorizontal();
		vectorVertice[5][1] = matrizVertices[0][2].getVertical();
		vectorVertice[5][2] = matrizVertices[0][2].getGiro();
		// for2
		vectorVertice[5][3] = matrizVertices[1][2].getHorizontal();
		vectorVertice[5][4] = matrizVertices[1][2].getVertical();
		vectorVertice[5][5] = matrizVertices[1][2].getGiro();

		for (int i = 0; i < vectorVertice.length; i++) {
			for (int j = 0; j < vectorVertice[0].length; j++) {
				System.out.print(vectorVertice[i][j] + "\t");
			}
			System.out.println();
		}
		/*
		 * for (int i = 0; i < matrizVertices.length-1; i++) { for (int j = 0; j
		 * < matrizVertices[0].length; j++) { //System.out.println(i+" - "+j); }
		 * }
		 */
	}

	/*
	 * public void aMano(){
	 * vectorVertice[0][0]=matrizVertices[1][0].getHorizontal();
	 * vectorVertice[0][1]=matrizVertices[1][0].getVertical();
	 * vectorVertice[0][2]=matrizVertices[1][0].getGiro();
	 * vectorVertice[0][3]=matrizVertices[0][0].getGiro();
	 * vectorVertice[0][4]=matrizVertices[0][0].getGiro();
	 * vectorVertice[0][5]=matrizVertices[0][0].getGiro();
	 * 
	 * for (int i = 0; i < vectorVertice.length; i++) {
	 * System.out.println(vectorVertice[i]); } }
	 */

	// ok
	public void cargarMatriz() {
		for (int i = 0; i < matrizVertices.length; i++) {

			for (int j = 0; j < matrizVertices[0].length; j++) {
				vertice = new Vertice();
				vertice.setHorizontal(incremento++);
				vertice.setVertical(incremento++);
				vertice.setGiro(incremento++);
				matrizVertices[i][j] = vertice;

			}
		}

		/*
		 * for (int i = 0; i < matrizVertices.length; i++) { for (int j = 0; j <
		 * matrizVertices[0].length; j++) {
		 * System.out.printf("Matriz [%d][%d]= [%d %d %d]\n", i,j,
		 * matrizVertices[i][j].getHorizontal(),
		 * matrizVertices[i][j].getVertical(), matrizVertices[i][j].getGiro());
		 * } }
		 */

		// System.out.println("--->"+matrizVertices[3][1].getGiro());

	}

	// ok
	public void crearMatriz(int columnas, int pisos) {
		matrizVertices = new Vertice[pisos + 1][columnas];
	}

}

