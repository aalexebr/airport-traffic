package org.java.spring.pojo.restDTO;

import java.time.LocalDateTime;

public class AirplaneMaintenanceJobDTO {
	
	private Integer id;
	private LocalDateTime dateTime;
	private String title;
	private String description;
	
	public AirplaneMaintenanceJobDTO(Integer id, LocalDateTime dateTime, String title, String description) {
		setDateTime(dateTime);
		setId(id);
		setDescription(description);
		setTitle(title);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
