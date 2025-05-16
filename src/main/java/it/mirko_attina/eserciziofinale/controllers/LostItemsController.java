package it.mirko_attina.eserciziofinale.controllers;

import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.mirko_attina.eserciziofinale.Dto.LostItemEditRequestDto;
import it.mirko_attina.eserciziofinale.Dto.LostItemRequestDto;
import it.mirko_attina.eserciziofinale.entity.LostItem;
import it.mirko_attina.eserciziofinale.mappers.LostItemMapper;
import it.mirko_attina.eserciziofinale.repository.LostItemRepository;
import jakarta.validation.Valid;

@RestController
public class LostItemsController {
	private LostItemRepository lostItemRepository;

	public LostItemsController(LostItemRepository lostItemRepository) {
		super();
		this.lostItemRepository = lostItemRepository;
	}

	@GetMapping("/lost_items")
	public ResponseEntity<List<LostItem>> index() {
		List<LostItem> lost_items = this.lostItemRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(lost_items);
	}
	
	@GetMapping("/lost_items/not_found")
	public ResponseEntity<List<LostItem>> index2() {
		List<LostItem> lost_items = this.lostItemRepository.findByFound(false);
		return ResponseEntity.status(HttpStatus.OK).body(lost_items);
	}
	
	@GetMapping("/lost_items/found")
	public ResponseEntity<List<LostItem>> index3() {
		List<LostItem> lost_items = this.lostItemRepository.findByFound(true);
		return ResponseEntity.status(HttpStatus.OK).body(lost_items);
	}
	
	@PostMapping("/lost_items/add")
	public ResponseEntity<?> add(
			@Valid @RequestBody LostItemRequestDto lostItemRequestDto,
			BindingResult result
	){
		if(result.hasErrors()) {
			Map<String, String> errors = new HashMap<String,String>();
			result.getFieldErrors().forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		
		LostItemMapper lostItemMapper = new LostItemMapper();
		
		LostItem lostitem = lostItemMapper.dtoToEntity(lostItemRequestDto);
		
		LostItem lostitemInserted = this.lostItemRepository.save(lostitem);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(lostitemInserted);
	}
	
	@PutMapping("/lost_items/update/{id}")
	public ResponseEntity<?> update(
			@Valid @RequestBody LostItemEditRequestDto lostItemEditRequestDto,
			@PathVariable Long id,
			BindingResult result
	) {
	    if (result.hasErrors()) {
	    	Map<String, String> errors = new HashMap<String,String>();
			result.getFieldErrors().forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	    }
	    
	    Optional<LostItem> oldLostItem = this.lostItemRepository.findById(id);
	    
	    if(oldLostItem.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(oldLostItem);
	    }
	    
	    if (oldLostItem.get().isFound()) {
	        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(oldLostItem);
	    }
	    
	    LostItemMapper lostItemMapper = new LostItemMapper();
	    
	    LostItem lostItem = lostItemMapper.dtoToEntity(oldLostItem.get(), lostItemEditRequestDto);
	    
	    
	    LostItem lostItemInserted = this.lostItemRepository.save(lostItem);
	    
	    return  ResponseEntity.status(HttpStatus.OK).body(lostItemInserted);
	}

	
	@DeleteMapping("/lost_items/delete/{id}")
	public ResponseEntity<String> destroy(@PathVariable Long id) {
		Optional<LostItem> optionalLostItem = this.lostItemRepository.findById(id);
		if(optionalLostItem.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id non trovato");
		}
		
		this.lostItemRepository.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	
	}
	
}
