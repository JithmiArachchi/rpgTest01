package com.example.rpgTest01.repository;

import com.example.rpgTest01.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM JM2026AWS1.CUSTOMER ORDER BY CUSTID";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Customer c = new Customer();
            c.setCustId(rs.getLong("CUSTID"));
            c.setCustName(rs.getString("CUSTNAME"));
            c.setAddress(rs.getString("ADDRESS"));
            c.setCity(rs.getString("CITY"));
            c.setPhone(rs.getString("PHONE"));
            c.setEmail(rs.getString("EMAIL"));
            c.setStatus(rs.getString("STATUS"));
            if (rs.getDate("CREATEDATE") != null) {
                c.setCreateDate(rs.getDate("CREATEDATE").toLocalDate());
            }
            return c;
        });
    }

    public Customer findById(Long id) {
        String sql = "SELECT * FROM JM2026AWS1.CUSTOMER WHERE CUSTID = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Customer c = new Customer();
            c.setCustId(rs.getLong("CUSTID"));
            c.setCustName(rs.getString("CUSTNAME"));
            c.setAddress(rs.getString("ADDRESS"));
            c.setCity(rs.getString("CITY"));
            c.setPhone(rs.getString("PHONE"));
            c.setEmail(rs.getString("EMAIL"));
            c.setStatus(rs.getString("STATUS"));
            if (rs.getDate("CREATEDATE") != null) {
                c.setCreateDate(rs.getDate("CREATEDATE").toLocalDate());
            }
            return c;
        }, id);
    }

    public int save(Customer customer) {
        String sql = "INSERT INTO JM2026AWS1.CUSTOMER (CUSTNAME, ADDRESS, CITY, PHONE, EMAIL, STATUS) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                customer.getCustName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getStatus());
    }

    // Update Customer
    public int update(Customer customer) {
        String sql = "UPDATE JM2026AWS1.CUSTOMER SET " +
                "CUSTNAME = ?, ADDRESS = ?, CITY = ?, PHONE = ?, EMAIL = ?, STATUS = ? " +
                "WHERE CUSTID = ?";
        return jdbcTemplate.update(sql,
                customer.getCustName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getStatus(),
                customer.getCustId());
    }

    // Delete Customer
    public int deleteById(Long id) {
        String sql = "DELETE FROM JM2026AWS1.CUSTOMER WHERE CUSTID = ?";
        return jdbcTemplate.update(sql, id);
    }
}