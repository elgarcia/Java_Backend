package Ejercicio05;

public class Documento extends ItemPageAbs{
	private String title;

	public Documento of(String ruta, String title){
		return (new Documento(ruta, title));
	}

	public Documento(String ruta, String title) {
		super(ruta);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return (getTitle() + "\n" +
				"<" + getRuta() + ">");
	}
}
