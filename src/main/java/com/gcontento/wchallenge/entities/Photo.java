package com.gcontento.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="photo")
@Entity
public class Photo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPhoto")
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="url")
	private String url;
	
	@Column(name="thumbnailurl")
	private String thumbnailUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="album_id", nullable=false)
	private Album album;

}
