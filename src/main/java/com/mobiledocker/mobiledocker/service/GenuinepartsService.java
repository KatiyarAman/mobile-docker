package com.mobiledocker.mobiledocker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mobiledocker.mobiledocker.entity.Geniuineparts;

@Service
@Transactional
public interface GenuinepartsService {

	   public void SaveNewParts(Geniuineparts genuineparts);
	   public List<Geniuineparts> ShowAllParts();
	   public List<Geniuineparts> FindByPartCode(String partcode);
	   public Geniuineparts editByPartCode(String partcode);
	   public Geniuineparts editById(Integer id);
	   public List<Geniuineparts> findByAVeryComplicatedQuery(Integer id, String name, String partcode,String price);

}
