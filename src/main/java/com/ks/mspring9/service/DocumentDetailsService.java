package com.ks.mspring9.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ks.mspring9.entity.DocumentDetails;
import com.ks.mspring9.repository.DocumentDetailsRepository;

@Service
public class DocumentDetailsService {
	private static final Logger l = LogManager.getLogger(DocumentDetailsService.class);

	private DocumentDetailsRepository documentDetailsRepository;

	public DocumentDetailsService(DocumentDetailsRepository documentDetailsRepository) {
		this.documentDetailsRepository = documentDetailsRepository;
	}

	public void createUserInfo(DocumentDetails documentDetails) {
		l.debug("Start : UserInfoService.createUserInfo(...)");
		
		documentDetailsRepository.save(documentDetails);
		
		l.debug("End : UserInfoService.createUserInfo(...)");
	}

	public List<DocumentDetails> get() {
		l.debug("Start : UserInfoService.get(...)");

		List<DocumentDetails> findAll = documentDetailsRepository.findAll();

		l.debug("End : UserInfoService.get(...) : findAll.size() = {}", (CollectionUtils.isEmpty(findAll)?0:findAll.size()));
		return findAll;
	}
	public DocumentDetails get(Long id) {
		l.debug("Start : UserInfoService.get(...) : id = {}", id);

		Optional<DocumentDetails> optUserInfo = documentDetailsRepository.findById(id);

		l.debug("End : UserInfoService.get(...) : id = {}, UserExist = {}", id, optUserInfo.isPresent());
		return optUserInfo.get();
	}
	public void delete(Long id) {
		l.debug("Start : UserInfoService.delete(...) : id = {}", id);

		documentDetailsRepository.deleteById(id);

		l.debug("End : UserInfoService.delete(...) : id = {}", id);
	}	
	public void deleteAll() {
		l.debug("Start : UserInfoService.deleteAll()");

		documentDetailsRepository.deleteAll();

		l.debug("End : UserInfoService.deleteAll()");
	}	
	public void update(DocumentDetails documentDetails) {
		l.debug("Start : UserInfoService.Update(...) : userInfo = {}", documentDetails);

		documentDetailsRepository.save(documentDetails);

		l.debug("End : UserInfoService.Update(...) : userInfo = {}", documentDetails);
	}	
}