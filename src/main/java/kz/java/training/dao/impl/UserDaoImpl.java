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
import kz.java.training.entity.RegistrationUser;
import kz.java.training.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SimpleJdbcInsert simpleJdbcInsert;
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("user").usingColumns("username",
				"password", "email");
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
		RegistrationUser registrationUser = (RegistrationUser) entity;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", registrationUser.getUsername());
		params.addValue("email", registrationUser.getEmail());
		params.addValue("password", DigestUtils.md5Hex(registrationUser.getPassword()));
		simpleJdbcInsert.execute(params);
	}

	@Override
	public boolean isUserExist(String username) {
		String sql = "SELECT EXISTS (SELECT username FROM user WHERE username = :username)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);

		return jdbcTemplate.queryForObject(sql, params, boolean.class);

	}

	@Override
	public boolean isUserExist(User user) {
		String sql = "SELECT EXISTS (SELECT id FROM user WHERE username = :username and password = :password)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", DigestUtils.md5Hex(user.getPassword()));

		return jdbcTemplate.queryForObject(sql, params, boolean.class);

	}

	@Override
	public boolean isUserWithThisEmailExist(String email) {
		String sql = "SELECT EXISTS (SELECT id FROM user WHERE email = :email)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("email", email);

		return jdbcTemplate.queryForObject(sql, params, boolean.class);
	}

	@Override
	public int selectUserId(String username) {
		int userId = 0;
		String sql = "SELECT id FROM user WHERE username = :username";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		
		userId = jdbcTemplate.queryForObject(sql, params, Integer.class);
		return userId;
	}

	@Override
	public void insertPersonalInformationForeignKey(int userId, int personalInformationId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", userId);
		params.addValue("personal_information_id", personalInformationId);
		jdbcTemplate.update("UPDATE user SET personal_information_id = :personal_information_id WHERE id = :id",
				params);
	}

	@Override
	public boolean ifUserHasPersonalInformationForeignKey(int id) {
		String sql = "SELECT personal_information_id IS NOT NULL FROM concert_tickets.user WHERE id = :id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbcTemplate.queryForObject(sql, params, boolean.class);
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
		String sql = "SELECT EXISTS(SELECT id FROM user WHERE id = :id and password = :password)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", userId);
		params.addValue("password", DigestUtils.md5Hex(currentPassword));

		return jdbcTemplate.queryForObject(sql, params, boolean.class);
	}

	@Override
	public String selectUsername(int userId) {
		String sql = "SELECT username FROM user WHERE id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", userId);
		return jdbcTemplate.queryForObject(sql, params, String.class);
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
