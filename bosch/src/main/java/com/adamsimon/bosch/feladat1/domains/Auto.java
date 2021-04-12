package com.adamsimon.bosch.feladat1.domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auto")
public class Auto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 10)
	private Integer id;
	
	@Column(name = "megnevezes", length = 40)
	private String megnevezes;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "auto")
    Szervizkonyv szervizkonyv;
	
	public Auto() {}

	public Auto(Integer id, String megnevezes, Szervizkonyv szervizkonyv) {
		super();
		this.id = id;
		this.megnevezes = megnevezes;
		this.szervizkonyv = szervizkonyv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}
	
	

	public Szervizkonyv getSzervizkonyv() {
		return szervizkonyv;
	}

	public void setSzervizkonyv(Szervizkonyv szervizkonyv) {
		this.szervizkonyv = szervizkonyv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((megnevezes == null) ? 0 : megnevezes.hashCode());
		result = prime * result + ((szervizkonyv == null) ? 0 : szervizkonyv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (megnevezes == null) {
			if (other.megnevezes != null)
				return false;
		} else if (!megnevezes.equals(other.megnevezes))
			return false;
		if (szervizkonyv == null) {
			if (other.szervizkonyv != null)
				return false;
		} else if (!szervizkonyv.equals(other.szervizkonyv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", megnevezes=" + megnevezes + ", szervizkonyv=" + szervizkonyv + "]";
	}
	
	
}
