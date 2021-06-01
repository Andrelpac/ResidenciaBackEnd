package org.serratec.backend.ProjetoCrud02.service;

import java.util.List;
import java.util.Optional;



import org.serratec.backend.ProjetoCrud02.dto.AccountDTO;
import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.serratec.backend.ProjetoCrud02.entity.OperationEntity;
import org.serratec.backend.ProjetoCrud02.exceptions.AccountNotFoundException;
import org.serratec.backend.ProjetoCrud02.exceptions.SaldoInsuficienteException;
import org.serratec.backend.ProjetoCrud02.mapper.AccountMapper;
import org.serratec.backend.ProjetoCrud02.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;
	
	@Autowired
	AccountMapper mapper;

	public List<AccountEntity> getAll() {
		return repository.findAll(Sort.by("numero"));
	}

	public List<AccountEntity> getByName(String nome) throws AccountNotFoundException {
		List<AccountEntity> account = repository.findByNomeOrderByNumero(nome);
//		if (account.isEmpty()) {
//			throw new AccountNotFoundException("Não existe conta com esse Id.");
//		}
		return account;
	}
	
	public AccountEntity getById(Long id) throws AccountNotFoundException {
		Optional<AccountEntity> account = repository.findById(id);
		if (account.isEmpty()) {
			throw new AccountNotFoundException("Não existe conta com esse Id.");
		}
		return account.get();
	}

	public void create(AccountEntity account) {
		account.setNumero((int) (Math.round(Math.random()*100)+ 100000));
		repository.save(account);
	}

	public AccountDTO update(Long id, AccountEntity account) throws AccountNotFoundException {
		AccountEntity accountEntity = getById(id);
		if (account.getNome() != null) {
			accountEntity.setNome(account.getNome());
		}
		return mapper.toDTO(repository.save(accountEntity));
	}
	
	@Transactional
	public void trasnferencia() {
		// retirarvalordaconta
		// trasnferirvalordaconta
	}

	public AccountDTO updateSaldo(Long id, OperationEntity operation)
			throws AccountNotFoundException, SaldoInsuficienteException {
		AccountEntity accountEntity = getById(id);
		switch (operation.getOperacao()) {
		case CREDITO:
			accountEntity.setSaldo(accountEntity.getSaldo() + operation.getValor());
			break;
		case DEBITO:
			if (accountEntity.getSaldo() < operation.getValor()) {
				throw new SaldoInsuficienteException("Você não tem saldo suficiente");
			}
			accountEntity.setSaldo(accountEntity.getSaldo() - operation.getValor());
			break;
		}
		accountEntity = repository.save(accountEntity);
		AccountDTO dto = mapper.toDTO(accountEntity);
		return dto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
