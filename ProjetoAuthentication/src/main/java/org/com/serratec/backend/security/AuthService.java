package org.com.serratec.backend.security;

import org.com.serratec.backend.entity.ClientEntity;
import org.com.serratec.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService{

	@Autowired
	ClientRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClientEntity client = repository.findByUsername(username);
		if(client == null) {
			System.out.println("Usuario não existe");
			return null;
		}
		return new UserSS(client.getId(),client.getUsername(),client.getSenha());
	}

}
