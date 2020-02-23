package com.citi.scc.sccapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CharacterPojo {
	@JsonProperty("_id")
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String picture;
	private int age;
}