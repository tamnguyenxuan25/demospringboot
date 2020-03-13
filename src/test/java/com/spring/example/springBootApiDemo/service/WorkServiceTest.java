package com.spring.example.springBootApiDemo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.example.springBootApiDemo.config.WorkStatus;
import com.spring.example.springBootApiDemo.entity.Work;
import com.spring.example.springBootApiDemo.repository.WorkRepository;
import com.spring.example.springBootApiDemo.service.impl.WorkServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class WorkServiceTest {
	@Mock
    WorkRepository workRepository;

    @InjectMocks
    WorkServiceImpl workService;

    @Test
    public void getAll() {
        List<Work> list = new ArrayList<Work>();
        Work work1 = new Work("w1","2020-01-01","2020-12-12", WorkStatus.DOING);
        Work work2 = new Work("w2","2020-01-01","2020-12-12", WorkStatus.PLANNING);

        list.add(work1);
        list.add(work2);

        when(workRepository.findAll()).thenReturn(list);

        List<Work> workList = workService.getAll(0, 10, "Id");

        assertEquals(2,workList.size());
        verify(workRepository, times(1)).findAll();
    }

    @Test
    public void getById() {
    	Work work1 = new Work("w1","2020-01-01","2020-12-12", WorkStatus.DOING);
        Optional<Work> workOptional = Optional.of(work1);

        when(workRepository.findById(1l)).thenReturn(workOptional);

        Optional<Work> workOptional1 = workService.getById(1l);

        assertEquals(workOptional, workOptional1);
    }

}
