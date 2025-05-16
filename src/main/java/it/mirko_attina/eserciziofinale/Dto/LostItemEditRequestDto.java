package it.mirko_attina.eserciziofinale.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor  @AllArgsConstructor
public class LostItemEditRequestDto {
	private boolean found;
	private String found_location;
	private Date found_date;
	
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	public String getFound_location() {
		return found_location;
	}
	public void setFound_location(String found_location) {
		this.found_location = found_location;
	}
	public Date getFound_date() {
		return found_date;
	}
	public void setFound_date(Date found_date) {
		this.found_date = found_date;
	}
	
	@Override
	public String toString() {
		return "LostItemEditRequestDto [found=" + found + ", found_location=" + found_location + ", found_date="
				+ found_date + "]";
	}
}
