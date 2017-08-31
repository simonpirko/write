package com.write.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private int id;

	@Column(name = "category")
	private String category;

	@Column(name = "label")
	private String label;

	@Column(name = "url")
	private String url;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = category.toLowerCase();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = "/" + category.toLowerCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
