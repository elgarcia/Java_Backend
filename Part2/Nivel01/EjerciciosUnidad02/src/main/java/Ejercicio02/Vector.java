package Ejercicio02;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector {
	private int x;
	private int y;

	public  Vector(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int  altura(){
		return (this.y);
	}

	public int  ancho(){
		return (this.x);
	}

	public double  modulo(){
		return (sqrt(pow(this.x, 2) + pow(this.y, 2)));
	}

	public Vector   suma(Vector otro){
		Vector  sum = new Vector(this.x + otro.x, this.y + otro.y);

		return (sum);
	}

	public String toString(){
		return ("(" + this.x + ", " + this.y + ")");
	}
}
