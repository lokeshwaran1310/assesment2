package com.example.supportjavaspring.repository;
import com.example.supportjavaspring.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}