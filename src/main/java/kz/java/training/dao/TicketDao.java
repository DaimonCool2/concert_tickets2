package kz.java.training.dao;

import kz.java.training.entity.Ticket;

public interface TicketDao extends AbstractDao<Ticket> {
	
	public void addTickets(Ticket ticket);

}
