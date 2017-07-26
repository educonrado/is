package org.live.vector.core;

import java.util.ArrayList;
import java.util.List;
import org.live.vector.entidad.Vertice;

/**
 *
 * @author excz010715
 */
public class CalculoMatriz {

    int columnas;
    int pisos;
    Vertice[][] matrizInicialGenerada;
    Vertice vertice;
    List<int[]> listaFinal;

    public CalculoMatriz(int columnas, int pisos) {
        this.columnas = columnas;
        this.pisos = pisos;
        crearMatriz(columnas, pisos);
        cargarVariacionesMatriz(columnas, pisos);
        //comparacionVertices(columnas, pisos);
    }

    public List<int[]> comparacionVertices(int columnas, int pisos) {
        int[] vectorResultante = new int[6];
        int generadoPrimero = 0;
        int generadoSegundo = 3;
        listaFinal = new ArrayList<>();
        int a = pisos;
        int b = 0;
        int incremento = 0;
        for (int i = 0; i < matrizInicialGenerada[0].length; i++) {
            vectorResultante = new int[6];
            vectorResultante[incremento++] = matrizInicialGenerada[a][i].getHorizontal();
            vectorResultante[incremento++] = matrizInicialGenerada[a][i].getVertical();
            vectorResultante[incremento++] = matrizInicialGenerada[a][i].getGiro();
            vectorResultante[incremento++] = matrizInicialGenerada[b][i].getHorizontal();
            vectorResultante[incremento++] = matrizInicialGenerada[b][i].getVertical();
            vectorResultante[incremento++] = matrizInicialGenerada[b][i].getGiro();
            incremento = 0;
            listaFinal.add(vectorResultante);
        }

        for (int i = 0; i < (matrizInicialGenerada.length) - 1; i++) {
            for (int j = 0; j < (matrizInicialGenerada[0].length); j++) {
                vectorResultante = new int[6];
                vectorResultante[generadoPrimero++] = matrizInicialGenerada[i][j].getHorizontal();
                vectorResultante[generadoPrimero++] = matrizInicialGenerada[i][j].getVertical();
                vectorResultante[generadoPrimero++] = matrizInicialGenerada[i][j].getGiro();
                i++;
                vectorResultante[generadoSegundo++] = matrizInicialGenerada[i][j].getHorizontal();
                vectorResultante[generadoSegundo++] = matrizInicialGenerada[i][j].getVertical();
                vectorResultante[generadoSegundo++] = matrizInicialGenerada[i][j].getGiro();
                i--;
                listaFinal.add(vectorResultante);
                generadoPrimero = 0;
                generadoSegundo = 3;
            }

        }
        for (int i = 0; i < columnas; i++) {
            listaFinal.remove(listaFinal.size() - 1);
        }
        int incrementoFilas = 0;
        for (int i = 0; i < (matrizInicialGenerada.length) - 1; i++) {
            for (int j = 0; j < matrizInicialGenerada[0].length; j++) {
                if (j < columnas - 1) {
                    vectorResultante = new int[6];
                    vectorResultante[incrementoFilas++] = matrizInicialGenerada[i][j].getHorizontal();
                    vectorResultante[incrementoFilas++] = matrizInicialGenerada[i][j].getVertical();
                    vectorResultante[incrementoFilas++] = matrizInicialGenerada[i][j].getGiro();
                    j++;
                    vectorResultante[incrementoFilas++] = matrizInicialGenerada[i][j].getHorizontal();
                    vectorResultante[incrementoFilas++] = matrizInicialGenerada[i][j].getVertical();
                    vectorResultante[incrementoFilas++] = matrizInicialGenerada[i][j].getGiro();
                    j--;
                    listaFinal.add(vectorResultante);
                }
                incrementoFilas = 0;
            }
        }
        return listaFinal;

    }

    public List<int[]> presentar(List<int[]> listaFinal2) {
        listaFinal2.stream().map((is) -> {
            for (int i = 0; i < is.length; i++) {
                System.out.print(is[i] + "\t");
            }
            return is;
        }).forEachOrdered((_item) -> {
            System.out.print("\n");
        });
        return listaFinal2;
    }

    public void crearMatriz(int columnas, int pisos) {
        matrizInicialGenerada = new Vertice[pisos + 1][columnas];
    }

    public void cargarVariacionesMatriz(int columnas, int pisos) {
        int incremento = 1;
        for (Vertice[] matrizInicialGenerada1 : matrizInicialGenerada) {
            for (int j = 0; j < matrizInicialGenerada[0].length; j++) {
                vertice = new Vertice();
                vertice.setHorizontal(incremento++);
                vertice.setVertical(incremento++);
                vertice.setGiro(incremento++);
                matrizInicialGenerada1[j] = vertice;
            }
        }
    }

}
