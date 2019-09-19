package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.factory.ReturnsFactory;
import com.ryankolbe.service.ReturnsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReturnsServiceImplTest {
    @Autowired
    @Qualifier("ReturnsServiceImpl")
    private ReturnsService returnsService;
    private Returns returns;
    private Set<Returns> returnsSet = new HashSet<>();

    @Before
    public void setUp() {
        returns = returnsService.create(ReturnsFactory.createReturns("0001", "Quality",
                5, 2500.00));
    }

    @Test
    public void create() {
        Returns createReturn = returnsService.create(ReturnsFactory.createReturns("0053",
                "Damaged Goods", 3, 450.00));
        returnsSet.add(createReturn);
    }

    @Test
    public void read() {
        Returns readReturns = returnsService.read(returns.getReturnId());
        Assert.assertEquals(readReturns, returnsService.read(readReturns.getReturnId()));
    }

    @Test
    public void update() {
        int newReturnQty = 5;
        Returns updateReturns = returnsService.update(new Returns.Builder().copy(returns).returnQty(newReturnQty)
                .build());
        returnsSet.add(updateReturns);
        Assert.assertEquals(updateReturns, returnsService.read(updateReturns.getReturnId()));
    }

    @Test
    public void delete() {
        returnsSet.addAll(returnsService.getAll());
        Returns deleteReturns = returnsService.create(ReturnsFactory.createReturns("0027",
                "Quality", 2, 2000.00));
        returnsSet.add(deleteReturns);
        returnsSet.remove(deleteReturns);
        returnsService.delete(deleteReturns.getReturnId());
        Assert.assertEquals(returnsSet.size(), returnsService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Returns> returnsSetGetAll = returnsService.getAll();
        Assert.assertEquals(returnsSetGetAll.size(), returnsService.getAll().size());
    }
}