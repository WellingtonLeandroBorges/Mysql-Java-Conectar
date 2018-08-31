package com.basedatos.conex;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ConexioBD objeto= new ConexioBD();
		objeto.getDatos();
		//objeto.insDatos();
		//objeto.actDatos();
		 //objeto.delDatos();
		
		/* agregamos otro metodo para buscar*/
		Scanner scan =  new Scanner(System.in);
		System.out.println("Ingrese  un Dato");
		String dato = scan.nextLine();
		objeto.buscDatos(dato);
	}

}
