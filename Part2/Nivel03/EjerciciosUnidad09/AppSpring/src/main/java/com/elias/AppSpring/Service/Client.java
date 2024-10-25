package com.elias.AppSpring.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.elias.AppSpring.Entity.Agenda;
import com.elias.AppSpring.Entity.Anotacion;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
	private static final HttpClient client = HttpClient.newHttpClient();

	public static void createAgenda(Agenda agenda) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/agendas"))
				.POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(agenda)))
				.header("Content-Type", "application/json")
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	public static void getAgendaById(int id) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/agendas/" + id))
				.GET()
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	public static void getAgendasByAnho(int anho) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/agendas/anho/" + anho))
				.GET()
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	public static void  createAnotacion(Anotacion anotacion, int agendaId) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/agendas/" + agendaId +
						"/anotaciones"))
				.POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(anotacion)))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	public static void  deleteAgenda(int id) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/agendas" + id))
				.DELETE()
				.build();
		HttpResponse<String>    response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	public static void  deleteAnotacion(int id) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/agendas/anotaciones/" + id))
				.DELETE()
				.build();
		HttpResponse<String>    response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	public static void updateAnotacion(int id, Anotacion newAnotacion) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/agendas/anotaciones/" + id))
				.PUT(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(newAnotacion)))
				.header("Content-Type", "application/json")
				.build();
		HttpResponse<String>    response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	public static void main(String[] args) throws Exception {
		Agenda agenda = new Agenda("Elias", 2024);
		createAgenda(agenda);

		Anotacion anotacion = new Anotacion(15, 10, "Reunión importante");
		createAnotacion(anotacion, 1);

		Anotacion nuevaAnotacion = new Anotacion(15, 10, "Reunión modificada");
		updateAnotacion(1, nuevaAnotacion);

		getAgendasByAnho(2024);

		deleteAnotacion(1);

		deleteAgenda(1);
	}
}
