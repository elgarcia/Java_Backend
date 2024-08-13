package Ejercicio05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Pagina {
	final List<ItemPageAbs>    items = new ArrayList<>();
	public static Pagina    newInstance(){
		return (new Pagina());
	}

	public void addItem(ItemPageAbs item){
		this.items.add(item);
	}

	public void removeItem(ItemPageAbs item){
		this.items.remove(item);
	}

	public void changeTitulo(Function<String, String> sustituidor){
		List<ItemPageAbs> items = this.getItems();

		for (ItemPageAbs item: this.getItems()){
			if (item instanceof Documento){
				((Documento) item).setTitle(sustituidor.apply(((Documento) item).getTitle()));
			}
		}
	}

	@Override
	public String toString() {
		String  res = "";

		for (int i = 0; i < items.size(); i++){
			res += items.get(i).toString();
			if (i < items.size() - 1){
				res += "\n\n";
			}
		}
		return (res);
	}

	public List<ItemPageAbs> getItems() {
		return (List.copyOf(this.items));
	}
}
