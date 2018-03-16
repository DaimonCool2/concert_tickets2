package kz.java.training.dao;

import java.util.List;

import kz.java.training.entity.AddTicket;
import kz.java.training.entity.SearchTicket;
import kz.java.training.entity.Ticket;

public interface TicketDao extends AbstractDao<Ticket> {

	void addTickets(AddTicket addTicket);
	
    List<SearchTicket> selectTickets(Ticket searchTicket);

	boolean isAcceptableNumberOfTickets(int numberOfTickets, int ticketId);
}
