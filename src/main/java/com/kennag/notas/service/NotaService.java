
package com.kennag.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kennag.notas.model.Nota;
import com.kennag.notas.repository.NotaRepository;

@Service
public class NotaService {

  @Autowired
  NotaRepository notaRepository;

  public List<Nota> getAll(){
    return notaRepository.findAll();
  }

  public Nota create(Nota nota){
    return notaRepository.save(nota);
  }

  public void delete(Long id){
    try {
      notaRepository.deleteById(id);
      
    } catch (Exception e) {
      throw e;
    }
    
  }

  public ResponseEntity<Nota> update(Nota nota, Long id){
    Optional<Nota> notaSearch = notaRepository.findById(id);
    if(notaSearch.isPresent()){
      nota.setId(notaSearch.get().getId());
      return ResponseEntity.ok(notaRepository.save(nota));
    }else{
     return  ResponseEntity.status(404).build();
    }
  }

  public ResponseEntity<Nota> getById(Long id) {
    Optional<Nota> notaSearch = notaRepository.findById(id);
    if(notaSearch.isPresent()){
      return ResponseEntity.ok(notaSearch.get());
    }
    return ResponseEntity.status(404).build();
  }

  public ResponseEntity<Nota> pesquisar(Long id) {
    Nota nota = notaRepository.findByNotabyId(id);
    if(nota != null){
      return ResponseEntity.ok(nota);
    }
    return ResponseEntity.status(404).build();
  }

  public ResponseEntity<List<Nota>> pesquisarTitulo(String titulo) {
    List<Nota> nList = notaRepository.findByNotabyTitulo(titulo);
    
    return ResponseEntity.status(200).body(nList);
  }
}
