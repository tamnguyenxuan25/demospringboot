package com.spring.example.springBootApiDemo.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.example.springBootApiDemo.config.WorkStatus;
import com.spring.example.springBootApiDemo.entity.Work;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkRepositoryTest {
	@Autowired
    TestEntityManager entityManager;
	
	@Autowired
    WorkRepository workRepository;

    @Test
    public void findAll() {
        Work work = initWork1();
        Work work2 = initWork2();

        List<Work> list = workRepository.findAll();

        assertEquals(2, list.size());
    }

    @Test
    public void delete() {
        Work work = initWork1();

        workRepository.delete(work);
    }

    private Work initWork1() {
    	Work work = new Work();
    	work.setWorkName("work1");
    	work.setStartingDate("01-01-2020");
    	work.setEndDate("12-12-2020");
    	work.setStatus(WorkStatus.PLANNING);

    	work = entityManager.persistAndFlush(work);

        return work;
    }

    private Work initWork2() {
    	Work work = new Work();
    	work.setWorkName("work2");
    	work.setStartingDate("01-01-2020");
    	work.setEndDate("12-12-2020");
    	work.setStatus(WorkStatus.DOING);

    	work = entityManager.persistAndFlush(work);

        return work;
    }

}
