package Maths;
import javax.swing.*;

public class desviacionstandar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cuenta;
		double media=0;
		double resultado=0;
		int []numeros;
		int tamano=0;
		double suma=0;
		double div;
		double desv;
		int a=0;
	
	System.out.println("Hola, bienvenido");
	System.out.println();
	System.out.println("Vamos a calcular la desviación estandar");
	
	do {
	a=Integer.parseInt(JOptionPane.showInputDialog("Introduce cantidad de numeros: "));
	numeros=new int[a];
	}while(a<3);
	
	if(numeros.length!=0) {
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "));
			
			
			}
		
		}
	
	tamano=numeros.length;
	for(int i=0;i<numeros.length;i++) {
		suma=suma+numeros[i];
		media=suma/tamano;
		resultado=resultado+Math.pow((numeros[i]-media),2f);
		}
	div=resultado/tamano;
	desv=Math.sqrt(div);

	System.out.println("La desviación estandar es: " + desv);
	}

}
