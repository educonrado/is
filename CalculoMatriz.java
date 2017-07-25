package org.live.is;

import java.util.ArrayList;
import java.util.List;

public class CalculoMatriz {
	
	int columnas;
	int pisos;
	Vertice[][] matrizInicialGenerada; 
	Vertice vertice;
	List<int[]> listaFinal;
	
	public CalculoMatriz(int columnas, int pisos) {
		this.columnas=columnas;
		this.pisos=pisos;
		crearMatriz(columnas, pisos);
		cargarVariacionesMatriz(columnas, pisos);
		comparacionVertices(columnas, pisos);
	}
	
	public void comparacionVertices(int columnas, int pisos){
		int[] vectorResultante=new int[6];
		int generadoPrimero=0;
		int generadoSegundo=3;
		listaFinal=new ArrayList<int[]>();
		int a=0;
		int b=0;
		int incremento=0;
	
			vectorResultante[incremento++]=matrizInicialGenerada[pisos][a].getHorizontal();
			vectorResultante[incremento++]=matrizInicialGenerada[pisos][a].getVertical();
			vectorResultante[incremento++]=matrizInicialGenerada[pisos][a].getGiro();
			vectorResultante[incremento++]=matrizInicialGenerada[b][a].getHorizontal();
			vectorResultante[incremento++]=matrizInicialGenerada[b][a].getVertical();
			vectorResultante[incremento++]=matrizInicialGenerada[b][a].getGiro();
	listaFinal.add(vectorResultante);
		
		for (int i = 0; i < (matrizInicialGenerada.length)-1; i++) {
			for (int j = 0; j < (matrizInicialGenerada[0].length); j++) {
				vectorResultante=new int[6];
				vectorResultante[generadoPrimero++]=matrizInicialGenerada[i][j].getHorizontal();
				vectorResultante[generadoPrimero++]=matrizInicialGenerada[i][j].getVertical();
				vectorResultante[generadoPrimero++]=matrizInicialGenerada[i][j].getGiro();
				//System.out.println(matrizInicialGenerada[i][j].getHorizontal());
				i++;
				vectorResultante[generadoSegundo++]=matrizInicialGenerada[i][j].getHorizontal();
				vectorResultante[generadoSegundo++]=matrizInicialGenerada[i][j].getVertical();
				vectorResultante[generadoSegundo++]=matrizInicialGenerada[i][j].getGiro();
				
				//System.out.println(matrizInicialGenerada[i][j].getHorizontal());
				i--;
				listaFinal.add(vectorResultante);
				generadoPrimero=0;
				generadoSegundo=3;
			}			
			
		}
		for (int i = 0; i < columnas; i++) {
			listaFinal.remove(listaFinal.size()-1);
		}
		
		for (int[] is : listaFinal) {
			for (int i = 0; i < is.length; i++) {
				System.out.print(is[i]+"\t");
			}
			System.out.print("\n");
		}
		
		
	}

	public void presentar(Vertice[][] matriz){
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.println(matriz[i][j].getHorizontal()+"\t"+
						matriz[i][j].getVertical()+"\t"+matriz[i][j].getGiro());
			}
		}
	}
	
	public void crearMatriz(int columnas, int pisos){
		matrizInicialGenerada=new Vertice[pisos+1][columnas];
	}
	
	public void cargarVariacionesMatriz(int columnas, int pisos){
		int incremento=1;
		for (int i = 0; i < matrizInicialGenerada.length; i++) {
			for (int j = 0; j < matrizInicialGenerada[0].length; j++) {
				vertice=new Vertice();
				vertice.setHorizontal(incremento++);
				vertice.setVertical(incremento++);
				vertice.setGiro(incremento++);
				matrizInicialGenerada[i][j]=vertice;
			}
		}
	}

}
