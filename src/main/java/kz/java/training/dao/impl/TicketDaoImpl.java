package kz.java.training.dao.impl;

import java.io.ByteArrayInputStream;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Repository;

import kz.java.training.dao.TicketDao;
import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Ticket findEntityById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntityById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertEntity(Ticket entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEntity(Ticket entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTickets(Ticket ticket) {
		String sql = "INSERT INTO tickets (name_of_group, number_of_tickets, music_genre, city, location, date_of_the_event, description, image)"
				+ " VALUES (:nameOfGroup, :numberOfTickets, :musicGenre, :city, :location, :dateOfTheEvent, :description, :image)";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("nameOfGroup", ticket.getNameOfGroup());
		parameters.addValue("numberOfTickets", ticket.getNumberOfTickets());
		parameters.addValue("musicGenre", ticket.getMusicGenre().getMusicGenreInDB());
		parameters.addValue("city", ticket.getCity());
		parameters.addValue("location", ticket.getLocation());
		parameters.addValue("dateOfTheEvent", ticket.getDateOfTheEvent());
		parameters.addValue("description", ticket.getDescription());
		parameters.addValue("image", new SqlLobValue(new ByteArrayInputStream(ticket.getImage()),
				ticket.getImage().length, new DefaultLobHandler()), Types.BLOB);
		jdbcTemplate.update(sql, parameters);
	}

}
