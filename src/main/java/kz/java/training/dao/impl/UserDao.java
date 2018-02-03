package kz.java.training.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kz.java.training.dao.AbstractDao;
import kz.java.training.entity.User;

@Repository("userDao")
public class UserDao implements AbstractDao<User> {

	private SimpleJdbcInsert simpleJdbcInsert;
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("user").usingColumns("username",
				"password");
	}

	@Override
	public User findEntityById(int id) {
		return null;
	}

	@Override
	public void deleteEntityById(int id) {

	}

	@Override
	public void insertEntity(User entity) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", entity.getUsername());
		params.addValue("password", entity.getPassword());
		simpleJdbcInsert.execute(params);
	}

	@Override
	public boolean isUserExist(String username) {
		String user = null;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		try {
			user = jdbcTemplate.queryForObject("SELECT username FROM user WHERE username = :username", params,
					String.class);
		} catch (EmptyResultDataAccessException ex) {
		}
		return user != null;

	}
	
	@Override
	public boolean isUserExist(User user) {
		int checkUser = 0;
		String sql = "SELECT id FROM user WHERE username = :username and password = :password";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", user.getPassword());
		try {
		checkUser = this.jdbcTemplate.queryForObject(sql, params, Integer.class);
		}catch(EmptyResultDataAccessException ex) {
		}
		return checkUser != 0;

	}
	
//	@Override
//	public boolean isUserExist(User user) {
//		User checkUser = null;
//		String sql = "SELECT username, password FROM user WHERE username = :username and password = :password";
//		
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("username", user.getUsername());
//		params.addValue("password", user.getPassword());
//		try {
//		checkUser = this.jdbcTemplate.queryForObject(sql, params, new UserMapper());
//		}catch(EmptyResultDataAccessException ex) {
//		}
//		return checkUser != null;
//
//	}
	
	
//	private static final class UserMapper implements RowMapper<User> {
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			User user = new User();
//			user.setUsername(rs.getString("username"));
//			user.setPassword(rs.getString("password"));
//			return user;
//		}
//	}

}
