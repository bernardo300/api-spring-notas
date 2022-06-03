package com.kennag.notas.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kennag.notas.model.Nota;
import com.kennag.notas.service.NotaService;


@RestController
@RequestMapping("/notas")
public class NotaController {

  @Autowired
  NotaService notaService;

  @ResponseBody
  @GetMapping
  public List<Nota> busca(){
    return notaService.getAll();
  }

  @ResponseBody
  @GetMapping("/{id}")
  public ResponseEntity<Nota> busca(@PathVariable("id") Long id){
    return notaService.getById(id);
  }

 
  @ResponseBody
  @Transactional
  @PostMapping
  public Nota create(@RequestBody Nota nota){
    return notaService.create(nota);
  } 

  @ResponseBody
  @Transactional
  @PutMapping("/{id}")
  public ResponseEntity<Nota> update(@RequestBody Nota nota, @PathVariable("id") Long id) throws Exception{
    return  notaService.update(nota, id);
  }

  @ResponseBody
  @Transactional
  @DeleteMapping("/{id}")
  public void deletarNota(@PathVariable("id") Long id){
    notaService.delete(id);
  }

  @GetMapping("/api/{id}")
  public ResponseEntity<Nota> pesquisarNota(@PathVariable("id") Long id){
    return notaService.pesquisar(id);
  }

  @GetMapping("/api")
  public ResponseEntity<List<Nota>> pesquisarNotaTitulo(@PathParam("titulo") String titulo){
    return notaService.pesquisarTitulo(titulo);
  }

}
