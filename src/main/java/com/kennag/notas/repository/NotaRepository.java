package com.kennag.notas.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kennag.notas.model.Nota;

@Repository
public interface NotaRepository  extends JpaRepository<Nota, Long>{

  @Query(
  value = "SELECT * FROM nota n WHERE n.id = :id", 
  nativeQuery = true)
  public Nota findByNotabyId(@Param("id") Long id) throws NoResultException;


  @Query(
    value = "SELECT * FROM nota n WHERE n.titulo LIKE %:titulo%", 
    nativeQuery = true)
    public List<Nota> findByNotabyTitulo(@Param("titulo") String titulo) throws NoResultException;


}
