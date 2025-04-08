package com.ankan.SpringJDBC.repository;

import com.ankan.SpringJDBC.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeveloperRepo {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DeveloperRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    public void save(Developer developer) {
    System.out.println("added");
    String sql = "insert into developer values(?,?,?)";
    int rows=jdbcTemplate.update(sql,developer.getId(),developer.getName(),developer.getTech());
System.out.println("inserted "+rows);
    }
    public List<Developer> findAll() {
String sql = "select * from developer";
        RowMapper<Developer> mapper=new RowMapper<Developer>() {
            @Override
            public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Developer developer=new Developer();
                developer.setId(rs.getInt("id"));
                developer.setName(rs.getString("name"));
                developer.setTech(rs.getString("tech"));

                return developer;
            }
        };
       List<Developer> dev= jdbcTemplate.query(sql,mapper);
        return dev;
    }
}
