package Ejercicio05;

abstract class ItemPageAbs implements ItemPage{
	private String path;

	public ItemPageAbs(String ruta){
		this.path = ruta;
	}

	@Override
	public String getRuta() {
		return (this.path);
	}

	@Override
	public void setRuta(String ruta) {
		this.path = ruta;
	}
}
