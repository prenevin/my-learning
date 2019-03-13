package com.prenevin.application.domain;

import com.prenevin.library.crud.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "job_ticket", uniqueConstraints = @UniqueConstraint(name = "uq_blacksmith_sword", columnNames = {"blacksmith_id", "sword_id"}))
public class JobTicket extends BaseDomain {

    @OneToOne
    @JoinColumn(name = "blacksmith_id")
    private Blacksmith blacksmith;

    @OneToOne
    @JoinColumn(name = "sword_id")
    private Sword sword;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
