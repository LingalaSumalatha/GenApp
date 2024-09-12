package com.prototype.genapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ksdspoly")
public class Ksdspoly {
	@NotNull
	@Id
	@Column(name = "pkey")
	private byte[] pkey;// pk
	@Column(name = "record")
	private byte[] record;

}
