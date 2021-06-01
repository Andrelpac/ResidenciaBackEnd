package org.serratec.backend.ProjetoCrud02.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.serratec.backend.ProjetoCrud02.entity.OperationEntity;
import org.serratec.backend.ProjetoCrud02.exceptions.AccountNotFoundException;
import org.serratec.backend.ProjetoCrud02.exceptions.SaldoInsuficienteException;
import org.serratec.backend.ProjetoCrud02.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;

	public List<AccountEntity> getAll() {
		return repository.findAll();
	}

	public AccountEntity getById(Long id) throws AccountNotFoundException {
		Optional<AccountEntity> account = repository.findById(id);
		if (account.isEmpty()) {
			throw new AccountNotFoundException("Não existe conta com esse Id.");
		}
		return account.get();
	}

	public void create(AccountEntity account) {
		account.setNumero((int) (Math.round(Math.random()*100)));
		repository.save(account);
	}

	public AccountEntity update(Long id, AccountEntity account) throws AccountNotFoundException {
		AccountEntity accountEntity = getById(id);
		if (account.getNome() != null) {
			accountEntity.setNome(account.getNome());
		}
		return repository.save(accountEntity);
	}

	public AccountEntity updateSaldo(Long id, OperationEntity operation)
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
		return repository.save(accountEntity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
