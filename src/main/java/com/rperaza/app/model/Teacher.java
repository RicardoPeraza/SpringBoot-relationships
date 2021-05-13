package com.rperaza.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_teacher")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTeacher;

	@Column(name = "name")
	private String name;

	@Column(name = "avatar")
	private String avatar;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
	@JsonIgnore
	private Set<Course> courses;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "teacher_social_media", joinColumns = @JoinColumn(name = "id_teacher", referencedColumnName = "id_teacher"), inverseJoinColumns = @JoinColumn(name = "id_social_media", referencedColumnName = "id_social_media"))
	private Set<SocialMedia> social_media = new HashSet<SocialMedia>();

	/*
	 * @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="id_teacher") private Set<TeacherSocialMedia>
	 * teacherSocialMedia;
	 * 
	 * public Set<TeacherSocialMedia> getTeacherSocialMedia() { return
	 * teacherSocialMedia; }
	 * 
	 * public void setTeacherSocialMedia(Set<TeacherSocialMedia> teacherSocialMedia)
	 * { this.teacherSocialMedia = teacherSocialMedia; }
	 */

	public Set<SocialMedia> getSocial_media() {
		return social_media;
	}

	public void setSocial_media(Set<SocialMedia> social_media) {
		this.social_media = social_media;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, String avatar) {
		super();
		this.name = name;
		this.avatar = avatar;
	}

	public Long getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
