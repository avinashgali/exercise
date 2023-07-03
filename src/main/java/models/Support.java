package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Support {
	
	 private String url;
	 private String text;


	 // Getter Methods 

	 public String getUrl() {
	  return url;
	 }

	 public String getText() {
	  return text;
	 }

	 // Setter Methods 

	 public void setUrl(String url) {
	  this.url = url;
	 }

	 public void setText(String text) {
	  this.text = text;
	 }

}
