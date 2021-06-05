package br.com.pronetdigital.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pronetdigital.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
