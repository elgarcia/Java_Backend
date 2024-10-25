package com.elias;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface GestionAccesos {
	Path getFichero();
	void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException;
	List<String> consultarUsuarios(LocalDate dia) throws IOException;
}
