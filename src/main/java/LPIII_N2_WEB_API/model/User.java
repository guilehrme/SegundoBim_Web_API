package LPIII_N2_WEB_API.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
	private final UUID id;
	private final String name;
	private final String pilotoFav1;

	private final String pilotoFav2;

	private final String pilotoFav3;

	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPilotoFav1() {
		return pilotoFav1;
	}
	public String getPilotoFav2() {
		return pilotoFav2;
	}
	public String getPilotoFav3() {
		return pilotoFav3;
	}
	public User(@JsonProperty("id")UUID id,
				@JsonProperty("name") String name,
				@JsonProperty("pilotoFav1")String pilotoFav1,
				@JsonProperty("pilotoFav2")String pilotoFav2,
				@JsonProperty("pilotoFav3")String pilotoFav3){
		this.id = id;
		this.name = name;
		this.pilotoFav1 = pilotoFav1;
		this.pilotoFav2 = pilotoFav2;
		this.pilotoFav3 = pilotoFav3;
	}
}