package com.backend.app.abanico.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.app.abanico.models.entity.Abanico;
import com.backend.app.abanico.models.dao.AbanicoDao;

@Service
public class AbanicoServiceImpl implements AbanicoService {

	@Autowired
	private AbanicoDao AbanicoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Abanico> findAll() {

		return (List<Abanico>) AbanicoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Abanico findById(Long id) {
		return AbanicoDao.findById(id).orElse(null);
	}

}
