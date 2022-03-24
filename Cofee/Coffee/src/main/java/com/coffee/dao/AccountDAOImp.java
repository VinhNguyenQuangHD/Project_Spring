package com.coffee.dao;

import com.coffee.model.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDAOImp implements AccountDAO{

    private JdbcTemplate jdbcTemplate;

    public AccountDAOImp(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }
    @Override
    public void saveOrUpdate(Account account) {
        if (account.get__id_account() > 0) {
            // update
            String sql = "UPDATE account_user SET username_account=?, email_account=?, password_account=?, "
                    + "tWHERE __id_account=?";
            jdbcTemplate.update(sql, account.getUsername_account(), account.getEmail_account(),
                    account.getPassword_account());
        } else {
            // insert
            String sql = "INSERT INTO account_user (username_account, email_account, password_account)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, account.getUsername_account(), account.getEmail_account(),
                    account.getPassword_account());
        }
    }

    @Override
    public void delete(int contactId) {
        String sql = "DELETE FROM account_user WHERE __id_account=?";
        jdbcTemplate.update(sql, contactId);
    }

    @Override
    public Account get(int contactId) {
        String sql = "SELECT * FROM account_user WHERE __id_account=" + contactId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {

            @Override
            public Account extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Account accn = new Account();
                    accn.set__id_account(rs.getInt("__id_account"));
                    accn.setUsername_account(rs.getString("username_account"));
                    accn.setEmail_account(rs.getString("email_account"));
                    accn.setPassword_account(rs.getString("password_account"));
                    return accn;
                }

                return null;
            }

        });
    }

    @Override
    public List<Account> list() {
        String sql = "SELECT * FROM account_user";
        List<Account> listContact = jdbcTemplate.query(sql, new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account accn = new Account();
                accn.set__id_account(rs.getInt("__id_account"));
                accn.setUsername_account(rs.getString("username_account"));
                accn.setEmail_account(rs.getString("email_account"));
                accn.setPassword_account(rs.getString("password_account"));
                return accn;
            }

        });

        return listContact;
    }
}
