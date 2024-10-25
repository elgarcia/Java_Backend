package Ejercicio05;

public class Imagen extends ItemPageAbs{
	private int     zoom;

	public Imagen of(String ruta, int zoom){
		return (new Imagen(ruta, zoom));
	}
	public Imagen(String ruta, int zoom) {
		super(ruta);
		this.zoom = zoom;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	@Override
	public String toString() {
		return ("<" + this.getRuta() + "> : " + getZoom());
	}
}
