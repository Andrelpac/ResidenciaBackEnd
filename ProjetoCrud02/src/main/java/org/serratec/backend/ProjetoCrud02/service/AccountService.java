package org.serratec.backend.ProjetoCrud02.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.serratec.backend.ProjetoCrud02.entity.OperationEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	List<AccountEntity> lista = new ArrayList<AccountEntity>();
	Integer numero = 1;

	public List<AccountEntity> getAll() {
		return lista;
	}

	public AccountEntity getByNumber(Integer numero) {
		for (AccountEntity accountEntity : lista) {
			if (accountEntity.getNumero() == numero) {
				return accountEntity;
			}
		}
		System.out.println("Não achei nenhuma conta");
		return null;
	}

	public void create(AccountEntity account) {
		account.setNumero(numero);
		lista.add(account);
		numero++;
	}

	public AccountEntity update(Integer numero, AccountEntity account) {
		for (AccountEntity accountEntity : lista) {
			if (accountEntity.getNumero() == numero) {
				if (account.getNome() != null) {
					accountEntity.setNome(account.getNome());
				}
			}
		}
		System.out.println("Nenhuma conta encontrada");
		return null;

//		AccountEntity accountEntity = getByNumber(numero);
//		if (accountEntity != null) {
//			if (account.getNome() != null) {
//				accountEntity.setNome(account.getNome());
//				return accountEntity;
//			}
//		}
	}

	public AccountEntity updateSaldo(Integer numero, OperationEntity operation) {
		AccountEntity accountEntity = getByNumber(numero);
		if (accountEntity != null) {
			switch (operation.getOperacao()) {
			case CREDITO:
				accountEntity.setSaldo(accountEntity.getSaldo() + operation.getValor());
				break;
			case DEBITO:
				accountEntity.setSaldo(accountEntity.getSaldo() - operation.getValor());
				break;
			}
		}
		return accountEntity;
	}
	
	public void delete(Integer numero) {
		AccountEntity accountEntity = getByNumber(numero);
		if(accountEntity != null) {
			lista.remove(accountEntity);
		}
	}
}
