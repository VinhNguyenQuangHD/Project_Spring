package com.coffee.dao;

import com.coffee.model.Account;

import java.util.List;

public interface AccountDAO {

        public void saveOrUpdate(Account account);

        public void delete(int contactId);

        public Account get(int contactId);

        public List<Account> list();
}
