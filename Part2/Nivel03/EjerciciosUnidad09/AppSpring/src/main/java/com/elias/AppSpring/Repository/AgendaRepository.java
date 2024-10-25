package com.elias.AppSpring.Repository;

import com.elias.AppSpring.Entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
	List<Agenda>    findByAnho(int anho);
}
