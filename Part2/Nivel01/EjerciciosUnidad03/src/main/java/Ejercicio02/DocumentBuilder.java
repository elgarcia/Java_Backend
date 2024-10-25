package Ejercicio02;

public class DocumentBuilder {
	private StringBuilder document = new StringBuilder();
	public void addParrafo(String texto) {
		// Debe añadir un nuevo párrafo al final del documento.
		if (document.length() > 0){
			this.document.append("\n");
		}
		this.document.append(texto);
	}
	public int getNumeroParrafos() {
		// Debe retornar cuántos párrafos tiene el documento
		if (this.document.length() == 0){
			return (0);
		}
		return (this.document.toString().split("\n").length);
	}
	public String getParrafo(int posicion) {
		// Debe retornar el párrafo de la posición dada contando desde 1, o null
		// si no hay ningún párrafo en esa posición.
		String[] parrafos = this.document.toString().split("\n");
		if (posicion > 0 && posicion <= parrafos.length){
			return (parrafos[posicion - 1]);
		}
		return (null);
	}
	public void terminarConPunto() {
		// Garantiza que todos los párrafos terminarán con un punto.
		String[] parrafos = this.document.toString().split("\n");
		this.document.setLength(0);

		for (int i = 0; i < parrafos.length; i++){
			if (!parrafos[i].endsWith("."))
				parrafos[i] += ".";
			this.document.append(parrafos[i]);
			if (i < parrafos.length - 1){
				this.document.append("\n");
			}
		}
	}
	public void eliminarParrafo(int posicion) {
		// Eliminar el párrafo de la posición dada contando desde 1, o no hace-
		// nada si no hay un párrafo en esa posición

		String[] parrafos = this.document.toString().split("\n");
		if (posicion > 0 && posicion <= parrafos.length) {
			this.document.setLength(0);
			for (int i = 0; i < parrafos.length; i++) {
				if (i != posicion - 1) {
					this.document.append(parrafos[i]);
				}
				if (i < parrafos.length - 2 || (i == parrafos.length - 2 && posicion != parrafos.length)) {
					this.document.append("\n");
				}
			}
		}
	}
	public void sustituyePrimero(String regex, String otro) {
		// El parámetro regex es una expresión regular con la que debe casar aquel
		// texto del documento que queremos sustituir por otro.
		String  text = this.document.toString().replaceFirst(regex, otro);
		this.document.setLength(0);
		this.document.append(text);
	}
}