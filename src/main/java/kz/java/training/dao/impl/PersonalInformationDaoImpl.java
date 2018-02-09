package kz.java.training.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		// TODO Auto-generated method stub
		return null;
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
				+ "	p_i.first_name = :first_name, p_i.last_name = :last_name \r\n" + "where \r\n" + "	u.id = :id", params);
	}

	@Override
	public int insertPersonalInformationWithGeneratedKey(PersonalInformation personalInformation) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("first_name", personalInformation.getFirstName());
		params.addValue("last_name", personalInformation.getLastName());
		Number newId = simpleJdbcInsert.executeAndReturnKey(params);
		return newId.intValue();
	}

}
