package com.tracker.feeding.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "baby_details")
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 25)
    private String name;

    @DateTimeFormat
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dob;
}
