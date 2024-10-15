package com.elias;

import java.util.List;

public interface IRepositorioCompras {
	void    insert(int  id, String info, String date, double precio, int clientid);
	void    delete(int  id);
	void    update(int  id, String date, double precio);

	List<Compra>    consultCompras(String date);
	List<Cliente>   consultClientes(String name);
}
