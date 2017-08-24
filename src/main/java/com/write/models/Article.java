package com.write.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

	private long id;
	private String caption;
	private String description;
}
