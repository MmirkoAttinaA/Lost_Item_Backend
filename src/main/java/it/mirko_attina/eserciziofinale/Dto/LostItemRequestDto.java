package it.mirko_attina.eserciziofinale.Dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LostItemRequestDto {
    
    private Long id;
    private String name;
    private String description;
    private Date lost_date;
    private String location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLost_date() {
		return lost_date;
	}
	public void setLost_date(Date lost_date) {
		this.lost_date = lost_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "LostItemRequestDto [id=" + id + ", name=" + name + ", description=" + description + ", lost_date="
				+ lost_date + ", location=" + location + "]";
	}
	
    
}