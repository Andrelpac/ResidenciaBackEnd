package org.serratec.backend.ProjetoCrud02.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.serratec.backend.ProjetoCrud02.entity.OperationEntity;
import org.serratec.backend.ProjetoCrud02.exceptions.AccountNotFoundException;
import org.serratec.backend.ProjetoCrud02.exceptions.SaldoInsuficienteException;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	List<AccountEntity> lista = new ArrayList<AccountEntity>();
	Integer numero = 1;

	public List<AccountEntity> getAll() {
		return lista;
	}

	public AccountEntity getByNumber(Integer numero) throws AccountNotFoundException {
		for (AccountEntity accountEntity : lista) {
			if (accountEntity.getNumero() == numero) {
				return accountEntity;
			}
		}
		throw new AccountNotFoundException("Não existe conta com esse Id.");
	}

	public void create(AccountEntity account) {
		account.setNumero(numero);
		lista.add(account);
		if (account.getSaldo() == null) {
			account.setSaldo(0.0);
		}
		numero++;
	}

	public AccountEntity update(Integer numero, AccountEntity account) throws AccountNotFoundException {
		for (AccountEntity accountEntity : lista) {
			if (accountEntity.getNumero() == numero) {
				if (account.getNome() != null) {
					accountEntity.setNome(account.getNome());
					return accountEntity;
				}
			}
		}
		throw new AccountNotFoundException("Não existe conta com esse Id.");

//		AccountEntity accountEntity = getByNumber(numero);
//		if (accountEntity != null) {
//			if (account.getNome() != null) {
//				accountEntity.setNome(account.getNome());
//				return accountEntity;
//			}
//		}
	}

	public AccountEntity updateSaldo(Integer numero, OperationEntity operation)
			throws AccountNotFoundException, SaldoInsuficienteException {
		AccountEntity accountEntity = getByNumber(numero);
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
		return accountEntity;
	}

	public void delete(Integer numero) throws AccountNotFoundException {
		AccountEntity accountEntity = getByNumber(numero);
		lista.remove(accountEntity);
	}
}
