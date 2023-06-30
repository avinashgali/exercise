package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

	int id;
	String email;
	String firstName;
	String lastName;
	String avatar;
}
