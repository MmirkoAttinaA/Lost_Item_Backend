package it.mirko_attina.eserciziofinale.mappers;

import it.mirko_attina.eserciziofinale.Dto.LostItemEditRequestDto;
import it.mirko_attina.eserciziofinale.Dto.LostItemRequestDto;
import it.mirko_attina.eserciziofinale.entity.LostItem;
public class LostItemMapper {
	public LostItem dtoToEntity(LostItemRequestDto lostItemRequestDto) {
		
		LostItem lostitem = new LostItem();
		
		lostitem.setName(lostItemRequestDto.getName());
		lostitem.setDescription(lostItemRequestDto.getDescription());
		lostitem.setLocation(lostItemRequestDto.getLocation());
		lostitem.setLost_date(lostItemRequestDto.getLost_date());
		
		
		return lostitem;
	}
	
	public LostItem dtoToEntity(LostItem lostItem, LostItemEditRequestDto lostItemEditRequestDto) {
		
		
		lostItem.setFound(true);
		lostItem.setFound_date(lostItemEditRequestDto.getFound_date());
		lostItem.setFound_location(lostItemEditRequestDto.getFound_location());
		
		return lostItem;
	}
}


