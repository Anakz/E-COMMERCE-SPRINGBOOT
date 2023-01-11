package com.pfa.projetpfa.service.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date paid_date;
    private float amount;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    private String is_deleted;
}
