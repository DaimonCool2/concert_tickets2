package kz.java.training.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.cj.jdbc.PreparedStatement;

import org.apache.commons.codec.digest.DigestUtils;
import kz.java.training.dao.AbstractDao;
import kz.java.training.dao.UserDao;
import kz.java.training.entity.ChangePasswordEntity;
import kz.java.training.entity.PersonalInformation;
import kz.java.training.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

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
	public void updateEntity(User entity) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void insertEntity(User entity) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", entity.getUsername());
		params.addValue("password", DigestUtils.md5Hex(entity.getPassword()));
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
		params.addValue("password", DigestUtils.md5Hex(user.getPassword()));
		try {
			checkUser = jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException ex) {
		}
		return checkUser != 0;

	}
	
	@Override
	public int selectUserId(String username) {
		int userId = 0;
		String sql = "SELECT id FROM user WHERE username = :username";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		try {
			userId = jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException ex) {
		}
		return userId;
	}

	@Override
	public void insertPersonalInformationForeignKey(int userId, int personalInformationId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", userId);		
		params.addValue("personal_information_id", personalInformationId);
        jdbcTemplate.update("UPDATE user SET personal_information_id = :personal_information_id WHERE id = :id", params);
	}
	
	@Override
	public boolean ifUserHasPersonalInformationForeignKey(int id) {
		Object checkIfUserHasForeignKey = null;
		String sql = "SELECT personal_information_id FROM user WHERE id = :id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		try {
			checkIfUserHasForeignKey = jdbcTemplate.queryForObject(sql, params, Object.class);
		} catch (EmptyResultDataAccessException ex) {
		}
		return checkIfUserHasForeignKey != null;
	}

	@Override
	public void changePassword(String newPassword, int userId) {
		String sql = "UPDATE user SET password = :password WHERE id = :id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("password", DigestUtils.md5Hex(newPassword));
		params.addValue("id", userId);
		jdbcTemplate.update(sql, params);
	}

	@Override
	public boolean isCurrentPasswordIsCorrect(String currentPassword, int userId) {
		int checkCurrentPassword = 0;
		String sql = "SELECT id FROM user WHERE id = :id and password = :password";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", userId);
		params.addValue("password", DigestUtils.md5Hex(currentPassword));
		try {
			checkCurrentPassword = jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException ex) {
		}
		return checkCurrentPassword != 0;
	}


	// @Override
	// public boolean isUserExist(User user) {
	// User checkUser = null;
	// String sql = "SELECT username, password FROM user WHERE username = :username
	// and password = :password";
	//
	// MapSqlParameterSource params = new MapSqlParameterSource();
	// params.addValue("username", user.getUsername());
	// params.addValue("password", user.getPassword());
	// try {
	// checkUser = this.jdbcTemplate.queryForObject(sql, params, new UserMapper());
	// }catch(EmptyResultDataAccessException ex) {
	// }
	// return checkUser != null;
	//
	// }

	// private static final class UserMapper implements RowMapper<User> {
	// public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	// User user = new User();
	// user.setUsername(rs.getString("username"));
	// user.setPassword(rs.getString("password"));
	// return user;
	// }
	// }

}
