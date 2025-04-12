package ejc;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Realiza un programa que vaya pidiendo números hasta que se introduzca un número negativo y 
 * nos diga cuántos números se han introducido, la media de los impares y el mayor de los pares.
 * El número negativo sólo se utiliza para indicar el final de la introducción de datos pero no se incluye en el cómputo.
 * **/

public class ejercicioC {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int cont =0;
		int impares [] = new int [0];
		int par []= new int[0];
		System.out.println("introduzca numeros (numero negativo para terminar)");
		for(int i =1; i>0; i++) {
			
			System.out.println();
			int num = sc.nextInt();
			if(num<0) {
				break;
			} if (num %2 !=0){
				int impar= num;
				//nuevo array con tamaño mayor
				int red[] = new int [impares.length+1];
				//copiamos los valores del array impares al nuevo
				for(int j=0;j<impares.length;j++) {
					red[j]=impares[j];
				}
				// pone le nuevo valor al final del array
				red[red.length-1]=impar;
				//igualamos los arrays
				impares=red;
			}
			if(num %2==0) {
				int blue[]=new int [par.length+1];
				for (int a=0;a<par.length;a++) {
					blue[a]=par[a];
				}
				blue[blue.length-1]=num;
				par=blue;
			}
			
			
			cont ++;
			
		}
		// recorremos el array con el bucle
		int suma=0;
		for(int b=0;b<impares.length;b++) {
		suma = suma+impares[b];
					}
		
		double media= suma/impares.length;
		
		   // Encontramos el número mayor de los pares
		 int mayorPar = 0; 
        if (par.length > 0) {
            for (int c = 0; c < par.length; c++) {
                if (par[c] > mayorPar) {
                    mayorPar = par[c];
                }
            }
        }
		
		System.out.println("se introdujeron " + cont + " numeros");
		System.out.println("Se introdugeron " + impares.length + " numeros impares");
		System.out.println("la mdedia de los numeros impares es de " + media);
		System.out.println("El número par mayor es: " + mayorPar);
	}
}
