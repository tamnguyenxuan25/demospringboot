package com.spring.example.springBootApiDemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.example.springBootApiDemo.entity.Work;
import com.spring.example.springBootApiDemo.repository.WorkRepository;
import com.spring.example.springBootApiDemo.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService{
	
	@Autowired
	WorkRepository workRepository;

	@Override
	public List<Work> getAll(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page<Work> pagedResult = workRepository.findAll(paging);

		if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Work>();
        }
	}

	@Override
	public Optional<Work> getById(Long Id) {
		Optional<Work> workOpt = workRepository.findById(Id);
		return workOpt;
	}

	@Override
	public Work add(Work work) {
		return workRepository.save(work);
	}

	@Override
	public void delete(Long workId) {
		workRepository.deleteById(workId);
		
	}

	@Override
	public Work update(Work work) {
		return workRepository.save(work);
	}

}
