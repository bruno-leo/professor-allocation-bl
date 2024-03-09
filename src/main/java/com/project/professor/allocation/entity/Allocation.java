package com.project.professor.allocation.entity;

import java.sql.Time;
import java.time.DayOfWeek;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DayOfWeek dayOfWeek;
	@Column(nullable = false)
	private Time startHour;
	@Column(nullable = false)
	private Time endHour;
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Professor professor;
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Course course;

	public Allocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Allocation(Long id, DayOfWeek dayOfWeek, Time start, Time end) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.startHour = start;
		this.endHour = end;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return dayOfWeek;
	}

	public void setDay(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Time getStart() {
		return startHour;
	}

	public void setStart(Time start) {
		this.startHour = start;
	}

	public Time getEnd() {
		return endHour;
	}

	public void setEnd(Time end) {
		this.endHour = end;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", day=" + dayOfWeek + ", start=" + startHour + ", end=" + endHour + "]";
	}
	
}
