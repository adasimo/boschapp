package com.adamsimon.bosch.feladat1.domains;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "szervizkonyv")
public class Szervizkonyv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 10)
	private Integer id;
	
	@Column(name = "tulajdonos", nullable = false, length = 50)
	private String tulajdonos;
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL)
	@JoinColumn(name = "auto", nullable = false)
	private Auto auto;
	
	//JAVA maps TINYINT to INTEGER or BOOLEAN, i have chosen BOOLEAN to correlate MYSQL type
	@Column(name = "garancialis", nullable = false)
	private Boolean garancialis;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "eletkor", nullable = false)
	private AutoEletkor eletkor;
	
	@Column(name = "szerviz_kezdete", nullable = false)
	private LocalDateTime szerviz_kezdete;
	
	@Column(name = "szerviz_vege", nullable = true)
	private LocalDateTime szerviz_vege;
	
	public Szervizkonyv() {}

	public Szervizkonyv(Integer id, String tulajdonos, Auto auto, Boolean garancialis, AutoEletkor eletkor,
			LocalDateTime szerviz_kezdete, LocalDateTime szerviz_vege) {
		super();
		this.id = id;
		this.tulajdonos = tulajdonos;
		this.auto = auto;
		this.garancialis = garancialis;
		this.eletkor = eletkor;
		this.szerviz_kezdete = szerviz_kezdete;
		this.szerviz_vege = szerviz_vege;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTulajdonos() {
		return tulajdonos;
	}

	public void setTulajdonos(String tulajdonos) {
		this.tulajdonos = tulajdonos;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Boolean getGarancialis() {
		return garancialis;
	}

	public void setGarancialis(Boolean garancialis) {
		this.garancialis = garancialis;
	}

	public AutoEletkor getEletkor() {
		return eletkor;
	}

	public void setEletkor(AutoEletkor eletkor) {
		this.eletkor = eletkor;
	}

	public LocalDateTime getSzerviz_kezdete() {
		return szerviz_kezdete;
	}

	public void setSzerviz_kezdete(LocalDateTime szerviz_kezdete) {
		this.szerviz_kezdete = szerviz_kezdete;
	}

	public LocalDateTime getSzerviz_vege() {
		return szerviz_vege;
	}

	public void setSzerviz_vege(LocalDateTime szerviz_vege) {
		this.szerviz_vege = szerviz_vege;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auto == null) ? 0 : auto.hashCode());
		result = prime * result + ((eletkor == null) ? 0 : eletkor.hashCode());
		result = prime * result + ((garancialis == null) ? 0 : garancialis.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((szerviz_kezdete == null) ? 0 : szerviz_kezdete.hashCode());
		result = prime * result + ((szerviz_vege == null) ? 0 : szerviz_vege.hashCode());
		result = prime * result + ((tulajdonos == null) ? 0 : tulajdonos.hashCode());
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
		Szervizkonyv other = (Szervizkonyv) obj;
		if (auto == null) {
			if (other.auto != null)
				return false;
		} else if (!auto.equals(other.auto))
			return false;
		if (eletkor == null) {
			if (other.eletkor != null)
				return false;
		} else if (!eletkor.equals(other.eletkor))
			return false;
		if (garancialis == null) {
			if (other.garancialis != null)
				return false;
		} else if (!garancialis.equals(other.garancialis))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (szerviz_kezdete == null) {
			if (other.szerviz_kezdete != null)
				return false;
		} else if (!szerviz_kezdete.equals(other.szerviz_kezdete))
			return false;
		if (szerviz_vege == null) {
			if (other.szerviz_vege != null)
				return false;
		} else if (!szerviz_vege.equals(other.szerviz_vege))
			return false;
		if (tulajdonos == null) {
			if (other.tulajdonos != null)
				return false;
		} else if (!tulajdonos.equals(other.tulajdonos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Szervizkonyv [id=" + id + ", tulajdonos=" + tulajdonos + ", auto=" + auto + ", garancialis="
				+ garancialis + ", eletkor=" + eletkor + ", szerviz_kezdete=" + szerviz_kezdete + ", szerviz_vege="
				+ szerviz_vege + "]";
	}
	
	
	
}
