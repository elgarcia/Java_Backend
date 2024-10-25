package com.elias;

import com.elias.Entidades.Cliente;
import com.elias.Entidades.Compra;

import java.util.List;

public interface IRepositorioCompras {
	void    insert(int  id, String info, String date, double precio, int clientid);
	void    delete(int  id);
	void    update(int  id, String info, String date, double precio, int clienteid);

	List<Compra>    consultCompras(String date);
	List<Cliente>   consultClientes(String name);
}
