package org.live.is;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	int columnas = 0;
    	int pisos = 0;
    	String dato1=null;
    	int posiblesErrores=3;
    	CalculoMatriz calculoMatriz;
    	ManejoArchivo manejoArchivo;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        do {
        	System.out.print("Ingrese # de columnas: ");
			dato1=br.readLine();
			if (esEntero(dato1)) {
				columnas=Integer.parseInt(dato1);
				break;
			}else {
				posiblesErrores--;
			}
		} while (posiblesErrores>0);
        if (posiblesErrores==0) {
        	System.out.println("El programa finalizo sin datos que procesar");
			System.exit(0);
		}
        dato1=null;
        posiblesErrores=3;
        do {
        	System.out.print("Ingrese # de pisos: ");
			dato1=br.readLine();
			if (esEntero(dato1)) {
				pisos=Integer.parseInt(dato1);
				break;
			}else {
				posiblesErrores--;
			}
		} while (posiblesErrores>0);
        if (posiblesErrores==0) {
        	System.out.println("El programa finalizo sin datos que procesar");
			System.exit(0);
		}
        System.out.println("-------------------------------------");
        System.out.printf("\tDatos de Matriz\nColumnas: %d\nPisos: %d\n",columnas,pisos);
        System.out.println("-------------------------------------");
        calculoMatriz=new CalculoMatriz(columnas, pisos);
        List<int[]> matrizResultante=new ArrayList<int[]>();
        matrizResultante=calculoMatriz.comparacionVertices(columnas, pisos);
        //calculoMatriz.presentar(matrizResultante);
        manejoArchivo=new ManejoArchivo();
        manejoArchivo.crearArchivo(matrizResultante);
        System.out.println("Autor: HICZ");
		System.exit(0);
        
        
        
    }
    
    public static boolean esEntero(String cad)
    {
    for(int i = 0; i<cad.length(); i++)
    if( !Character.isDigit(cad.charAt(i)) )
    return false;
    
    return true;
    }
}
