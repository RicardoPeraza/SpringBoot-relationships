package com.rperaza.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "social_media")
public class SocialMedia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_social_media")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSocialmedia;

	@Column(name = "name")
	private String name;

	@Column(name = "icon")
	private String icon;

	@ManyToMany
	@JoinTable(name = "teacher_social_media", joinColumns = @JoinColumn(name = "id_social_media", referencedColumnName = "id_social_media"), inverseJoinColumns = @JoinColumn(name = "id_teacher", referencedColumnName = "id_teacher"))
	private Set<Teacher> teacher = new HashSet<Teacher>();

	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "id_social_media")
	 * 
	 * @JsonIgnore private Set<TeacherSocialMedia> teacherSocialMedia;
	 * 
	 */

	public SocialMedia() {
		super();
	}

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}

	public SocialMedia(String name, String icon) {
		super();
		this.name = name;
		this.icon = icon;
	}

	public Long getIdSocialmedia() {
		return idSocialmedia;
	}

	public void setIdSocialmedia(Long idSocialmedia) {
		this.idSocialmedia = idSocialmedia;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcono(String icono) {
		this.icon = icono;
	}

}
