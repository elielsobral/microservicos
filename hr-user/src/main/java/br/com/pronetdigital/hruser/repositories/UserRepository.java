package br.com.pronetdigital.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pronetdigital.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
