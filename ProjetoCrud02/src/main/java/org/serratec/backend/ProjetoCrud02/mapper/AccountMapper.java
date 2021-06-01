package org.serratec.backend.ProjetoCrud02.mapper;

import org.serratec.backend.ProjetoCrud02.dto.AccountDTO;
import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

	public AccountEntity toEntity(AccountDTO dto) {
		AccountEntity entity = new AccountEntity();
		entity.setNome(dto.getNome());
		entity.setSaldo(dto.getSaldo());
		return entity;
	}
	
	public AccountDTO toDTO(AccountEntity entity) {
		AccountDTO dto = new AccountDTO();
		dto.setNumero(entity.getNumero());
		dto.setNome(entity.getNome());
		dto.setSaldo(entity.getSaldo());
		return dto;
	}
}
