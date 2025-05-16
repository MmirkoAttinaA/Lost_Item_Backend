package it.mirko_attina.eserciziofinale.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter @Setter @NoArgsConstructor  @AllArgsConstructor @ToString
@Table(name = "lost_items")
public class LostItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "lost_date", nullable = false)
	private Date lost_date;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "found")
	private boolean found;
	
	@Column(name = "found_date")
	private Date found_date;
	
	@Column(name = "found_location")
	private String found_location;

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

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	public Date getFound_date() {
		return found_date;
	}

	public void setFound_date(Date found_date) {
		this.found_date = found_date;
	}

	public String getFound_location() {
		return found_location;
	}

	public void setFound_location(String found_location) {
		this.found_location = found_location;
	}

	@Override
	public String toString() {
		return "LostItem [id=" + id + ", name=" + name + ", description=" + description + ", lost_date=" + lost_date
				+ ", location=" + location + ", found=" + found + ", found_date=" + found_date + ", found_location="
				+ found_location + "]";
	}
}
