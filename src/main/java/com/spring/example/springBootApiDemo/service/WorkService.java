package com.spring.example.springBootApiDemo.service;

import java.util.List;
import java.util.Optional;

import com.spring.example.springBootApiDemo.entity.Work;

public interface WorkService {
	public List<Work> getAll(Integer pageNo, Integer pageSize, String sortBy);

    public Optional<Work> getById(Long Id);

    public Work add(Work work);

    public void delete(Long workId);

    public Work update(Work work);
}
