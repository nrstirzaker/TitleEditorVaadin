package com.nielsenbook.titleeditor.entity;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nielsenbook.titleeditor.common.PublicationStatus;

@Entity
@Table(name = "book")
@Access(value=AccessType.FIELD)
public class Book {

	@Id
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;
	
	private String isbn;
	private Date publicationDate;
	private PublicationStatus publicationStatus;
	
}
