package com.raya.parkinglot.repository;

import com.raya.parkinglot.dto.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}