package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaService implements PersonaRepository {
  @Lazy
  @Autowired
  private PersonaRepository personaRepository;

  public PersonaService() {
  }

  public PersonaService(PersonaRepository personaRepository) {
    this.personaRepository = personaRepository;
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
  }

  @Override
  public void deleteAllInBatch() {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
  }

  @Override
  public void deleteAllInBatch(Iterable<Persona> entities) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
  }

  @Override
  public <S extends Persona> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends Persona> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public void flush() {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'flush'");
  }

  @Override
  public Persona getById(Long arg0) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public Persona getOne(Long arg0) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'getOne'");
  }

  @Override
  public Persona getReferenceById(Long id) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
  }

  @Override
  public <S extends Persona> List<S> saveAllAndFlush(Iterable<S> entities) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
  }

  @Override
  public <S extends Persona> S saveAndFlush(S entity) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
  }

  @Override
  public List<Persona> findAll() {
    return personaRepository.findAll();
  }

  @Override
  public List<Persona> findAllById(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
  }

  @Override
  public <S extends Persona> List<S> saveAll(Iterable<S> entities) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
  }

  @Override
  public long count() {
    return personaRepository.count();
  }

  @Override
  public void delete(Persona entity) {
    personaRepository.delete(entity);
  }

  @Override
  public void deleteAll() {
    personaRepository.deleteAll();
  }

  @Override
  public void deleteAll(Iterable<? extends Persona> entities) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

  @Override
  public void deleteAllById(Iterable<? extends Long> ids) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
  }

  @Override
  public void deleteById(Long id) {
    personaRepository.deleteById(id);
  }

  @Override
  public boolean existsById(Long id) {
    return personaRepository.existsById(id);
  }

  @Override
  public Optional<Persona> findById(Long id) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public <S extends Persona> S save(S entity) {
    return personaRepository.save(entity);
  }

  @Override
  public List<Persona> findAll(Sort sort) {
    return personaRepository.findAll(sort);
  }

  @Override
  public Page<Persona> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends Persona> long count(Example<S> example) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'count'");
  }

  @Override
  public <S extends Persona> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'exists'");
  }

  @Override
  public <S extends Persona> Page<S> findAll(Example<S> example, Pageable pageable) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends Persona, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findBy'");
  }

  @Override
  public <S extends Persona> Optional<S> findOne(Example<S> example) {
    // TODO Auto-generated method stub
    System.out.println("NO USAR");
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
  }

}
