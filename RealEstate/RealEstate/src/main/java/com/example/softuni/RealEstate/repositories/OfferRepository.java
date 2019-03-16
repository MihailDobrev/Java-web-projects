package com.example.softuni.RealEstate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.softuni.RealEstate.entities.Offer;;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer>{

	
}
