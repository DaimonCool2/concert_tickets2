package kz.java.training.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kz.java.training.dao.AbstractDao;
import kz.java.training.dao.PersonalINformationDao;
import kz.java.training.entity.PersonalInformation;
import kz.java.training.entity.PersonalInformationWithUserId;

@Repository
public class PersonalInformationDaoImpl implements PersonalINformationDao {

	private SimpleJdbcInsert simpleJdbcInsert;
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("personal_information")
				.usingColumns("first_name", "last_name").usingGeneratedKeyColumns("id");
	}

	@Override
	public PersonalInformation findEntityById(int id) {
		String sql = "SELECT first_name, last_name from personal_information pi inner join user u on pi.id = u.personal_information_id where u.id = :id";
		PersonalInformation personalInformation = new PersonalInformation();
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		try {
			personalInformation = jdbcTemplate.queryForObject(sql, params, new PersonalInformationMapper());
		} catch (EmptyResultDataAccessException ex) {
		}
		return personalInformation;
	}

	@Override
	public void deleteEntityById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertEntity(PersonalInformation entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEntity(PersonalInformation entity) {
		PersonalInformationWithUserId piWithUserId = (PersonalInformationWithUserId) entity;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", piWithUserId.getUserId());
		params.addValue("first_name", piWithUserId.getFirstName());
		params.addValue("last_name", piWithUserId.getLastName());
		jdbcTemplate.update("Update \r\n" + "	personal_information p_i\r\n"
				+ "    inner join user u on p_i.id = u.personal_information_id\r\n" + "set \r\n"
				+ "	p_i.first_name = :first_name, p_i.last_name = :last_name \r\n" + "where \r\n" + "	u.id = :id",
				params);
	}

	@Override
	public int insertPersonalInformationWithGeneratedKey(PersonalInformation personalInformation) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("first_name", personalInformation.getFirstName());
		params.addValue("last_name", personalInformation.getLastName());
		Number newId = simpleJdbcInsert.executeAndReturnKey(params);
		return newId.intValue();
	}

	private static final class PersonalInformationMapper implements RowMapper<PersonalInformation> {
		public PersonalInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
			PersonalInformation personalInformation = new PersonalInformation();
			personalInformation.setFirstName(rs.getString("first_name"));
			personalInformation.setLastName(rs.getString("last_name"));
			return personalInformation;
		}
	}

}
