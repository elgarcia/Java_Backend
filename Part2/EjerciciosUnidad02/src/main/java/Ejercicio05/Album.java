package Ejercicio05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Album {
	public static Album    newInstance(){
		return (new Album());
	}

	private List<Pagina>    pages = new ArrayList<>();

	public void addPagina(Pagina page){
		this.pages.add(page);
	}

	public void removePagina(Pagina page){
		this.pages.remove(page);
	}
	public List<Pagina> selectPaginas(Predicate<Imagen> filtro){
		List<Pagina> res = new ArrayList<>();

		for (Pagina page: this.pages){
			if (containsFilteredImage(page, filtro)){
				res.add(page);
			}
		}
		return (res);
	}

	private boolean containsFilteredImage(Pagina page, Predicate<Imagen> filtro) {
		for (ItemPageAbs item : page.getItems()) {
			if (item instanceof Imagen && filtro.test((Imagen) item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String text = "";

		for (int i = 0; i < pages.size(); i++){
			text += "PAGINA " + (i + 1) + ":\n";
			text += pages.get(i).toString() + "\n";
			if (i < pages.size() - 1){
				text += "-----------------------------------------------------\n\n";
			}
		}
		return (text);
	}
}
