package it.mirko_attina.eserciziofinale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mirko_attina.eserciziofinale.entity.LostItem;

public interface LostItemRepository extends JpaRepository<LostItem, Long>{
	List<LostItem> findByFound(boolean found);
}
