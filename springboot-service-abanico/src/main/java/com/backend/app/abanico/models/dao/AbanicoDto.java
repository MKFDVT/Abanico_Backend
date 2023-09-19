package com.backend.app.abanico.models.dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbanicoDto {
	
	private Long id;
	private String name;
	private String marca;
	private Date createAt;
}
