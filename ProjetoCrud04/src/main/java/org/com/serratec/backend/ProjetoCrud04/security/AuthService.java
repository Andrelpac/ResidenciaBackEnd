package org.com.serratec.backend.ProjetoCrud04.security;

import java.util.Optional;

import org.com.serratec.backend.ProjetoCrud04.entity.AutorEntity;
import org.com.serratec.backend.ProjetoCrud04.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	AutorRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AutorEntity autor = repository.findByNome(username);
		if (autor == null) {
			return null;
		}
		return new UserSS(autor.getId(), autor.getNome(), autor.getSenha());
	}

}
