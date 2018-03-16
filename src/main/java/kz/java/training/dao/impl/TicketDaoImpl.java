package kz.java.training.dao.impl;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Repository;

import com.mysql.cj.mysqla.authentication.MysqlaAuthenticationProvider;

import kz.java.training.dao.TicketDao;
import kz.java.training.entity.AddTicket;
import kz.java.training.entity.MusicGenre;
import javax.xml.bind.DatatypeConverter;
import kz.java.training.entity.SearchTicket;
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
        String sql = "Select * FROM tickets inner join music_genres on tickets.music_genre_id = music_genres.id "
        		    + "WHERE tickets.id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		return jdbcTemplate.queryForObject(sql, parameters, new TicketMapper());
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
	public void addTickets(AddTicket addTicket) {
		String sql = "INSERT INTO tickets (price, name_of_group, number_of_tickets, music_genre_id, city, location, date_of_the_event, description, image)"
				+ " VALUES (:price, :nameOfGroup, :numberOfTickets, (SELECT id FROM music_genres WHERE music_genre = :musicGenre), :city, :location, :dateOfTheEvent, :description, :image)";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("price", addTicket.getPrice());
		parameters.addValue("nameOfGroup", addTicket.getNameOfGroup());
		parameters.addValue("numberOfTickets", addTicket.getNumberOfTickets());
		parameters.addValue("musicGenre", addTicket.getMusicGenre().name().toLowerCase());
		parameters.addValue("city", addTicket.getCity());
		parameters.addValue("location", addTicket.getLocation());
		parameters.addValue("dateOfTheEvent", addTicket.getDateOfTheEvent());
		parameters.addValue("description", addTicket.getDescription());
		parameters.addValue("image", new SqlLobValue(new ByteArrayInputStream(addTicket.getImage()),
				addTicket.getImage().length, new DefaultLobHandler()), Types.BLOB);
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public List<SearchTicket> selectTickets(Ticket searchTicket) {
        String sql = "Select * FROM tickets inner join music_genres on tickets.music_genre_id = music_genres.id "
        		+ "WHERE  (:city = '' OR city = :city) AND  (:musicGenre IS NULL OR music_genre = :musicGenre) "
        		+ "AND  (:nameOfGroup = '' OR name_of_group = :nameOfGroup)"
        		+ "ORDER BY date_of_the_event";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("city", Optional.ofNullable(searchTicket.getCity()).orElse(""));
		parameters.addValue("musicGenre", searchTicket.getMusicGenre(), Types.VARCHAR);
		parameters.addValue("nameOfGroup", Optional.ofNullable(searchTicket.getNameOfGroup()).orElse(""));
		return jdbcTemplate.query(sql, parameters, new SearchTicketMapper());
	}

//	private final class TicketMapper implements RowMapper<SearchTicket> {
//		public SearchTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
//			SearchTicket searchTicket = new SearchTicket();
//            fillTicket(rs, searchTicket);
//			return searchTicket;
//		}
//	}
	
	private final class SearchTicketMapper implements RowMapper<SearchTicket>  {
		public SearchTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
			SearchTicket searchTicket = new SearchTicket();
            fillTicket(rs, searchTicket);
			return searchTicket;
		}
	}
	
	private final class TicketMapper implements RowMapper<SearchTicket>  {
		public SearchTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
			SearchTicket searchTicket = new SearchTicket();
            fillTicket(rs, searchTicket);
			searchTicket.setDescription(rs.getString("description"));
			return searchTicket;
		}
	}
	
	private void fillTicket(ResultSet rs, SearchTicket searchTicket) throws SQLException {
		searchTicket.setTicketId(rs.getInt("tickets.id"));
		searchTicket.setPrice(rs.getDouble("price"));
		searchTicket.setNameOfGroup(rs.getString("name_of_group"));
		searchTicket.setNumberOfTickets(rs.getInt("number_of_tickets"));
		searchTicket.setMusicGenre(MusicGenre.getMusicGenreEnum(rs.getString("music_genre")));
		searchTicket.setCity(rs.getString("city"));
		searchTicket.setLocation(rs.getString("location"));
		searchTicket.setDateOfTheEventForPage(rs.getString("date_of_the_event"));
		searchTicket.setImageForPage(DatatypeConverter.printBase64Binary(rs.getBytes("image")));
	}

	@Override
	public boolean isAcceptableNumberOfTickets(int numberOfTickets, int ticketId) {
	    String sql = "SELECT EXISTS(SELECT id FROM tickets WHERE id = :id AND number_of_tickets >= :numberOfTickets)";
	    MapSqlParameterSource parameters = new MapSqlParameterSource();
	    parameters.addValue("id", ticketId);
	    parameters.addValue("numberOfTickets", numberOfTickets);
		return jdbcTemplate.queryForObject(sql, parameters, boolean.class);
	}

}
