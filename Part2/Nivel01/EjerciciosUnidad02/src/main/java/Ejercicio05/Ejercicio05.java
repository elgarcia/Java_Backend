package Ejercicio05;

import java.util.List;

public class Ejercicio05 {
	public static void main(String[] args) {
		Pagina  p1 = Pagina.newInstance();
		Pagina  p2 = Pagina.newInstance();
		Pagina  p3 = Pagina.newInstance();
		Pagina  p4 = Pagina.newInstance();

		Album ab = Album.newInstance();

		p1.addItem(new Documento("c/user/Documents/file1.pdf", "file1"));
		p1.addItem(new Imagen("c/user/Documents/file1.jpeg", 10));
		p2.addItem(new Documento("c/user/Documents/file2.pdf", "file2"));
		p2.addItem(new Imagen("c/user/Documents/file2.jpeg", 0));
		p3.addItem(new Documento("c/user/Documents/file3.pdf", "file3"));
		p3.addItem(new Imagen("c/user/Documents/file3.jpeg", 50));
		p4.addItem(new Documento("c/user/Documents/file4.pdf", "file4"));
		p4.addItem(new Imagen("c/user/Documents/file4.jpeg", 20));
		p1.addItem(new Documento("c/user/Documents/casdw.pdf", "Cuenta"));
		p1.addItem(new Imagen("c/user/Documents/casdw.jpeg", 25));
		p2.addItem(new Documento("c/user/Documents/xcvs.pdf", "Pago"));
		p2.addItem(new Imagen("c/user/Documents/xcvs.jpeg", 15));
		p3.addItem(new Documento("c/user/Documents/e123w.pdf", "Recibo"));
		p3.addItem(new Imagen("c/user/Documents/e123w.jpeg", 23));
		p4.addItem(new Documento("c/user/Documents/other.pdf", "1elif"));
		p4.addItem(new Imagen("c/user/Documents/other.jpeg", 18));

		ab.addPagina(p1);
		ab.addPagina(p2);
		ab.addPagina(p3);
		ab.addPagina(p4);

		System.out.println(ab.toString());

		System.out.println("Filtro test: ");
		List<Pagina> imagenes = ab.selectPaginas(x -> x.getZoom() > 25);
		System.out.println(imagenes.toString());

		System.out.println("Sustituidor test: ");
		p2.changeTitulo(String::toUpperCase);
		System.out.println(p2.toString());
	}
}
