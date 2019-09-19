/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.factory.ReturnsFactory;
import com.ryankolbe.repository.ReturnsRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReturnsRepositoryImplTest {
    private static ReturnsRepository returnsRepository = ReturnsRepositoryImpl.getReturnsRepository();
    private static Returns returns;
    private static Set<Returns> returnsSet = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        returns = ReturnsFactory.createReturns("0012", "Damaged", 1, 1000.00);
        returnsSet.add(returnsRepository.create(returns));
    }

    @Test
    public void getReturnsRepository() {
        Assert.assertNotNull(returnsRepository);
    }

    @Test
    public void create() {
        Returns createReturns = ReturnsFactory.createReturns("0032", "Quality", 2,
                2000.00);
        returnsSet.add(returnsRepository.create(createReturns));
        Assert.assertEquals(createReturns, returnsRepository.read(createReturns.getReturnId()));
    }

    @Test
    public void read() {
        Returns readReturns = returnsRepository.read(returns.getReturnId());
        Assert.assertEquals(readReturns, returnsRepository.read(readReturns.getReturnId()));
    }

    @Test
    public void update() {
        String newReturnReason = "Out Of Spec";
        Returns updateReturns = new Returns.Builder().copy(returns).returnReason(newReturnReason).build();
        returnsSet.add(returnsRepository.update(updateReturns));
        Assert.assertEquals(updateReturns, returnsRepository.read(updateReturns.getReturnId()));
    }

    @Test
    public void delete() {
        Returns deleteReturns = ReturnsFactory.createReturns("7585", "Incorrect Product Delivered",
                1, 2300.00);
        returnsSet.add(returnsRepository.create(deleteReturns));
        returnsSet.remove(deleteReturns);
        returnsRepository.delete(deleteReturns.getReturnId());
        Assert.assertEquals(returnsSet.size(), returnsRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Returns> returnsGetAll = returnsRepository.getAll();
        Assert.assertEquals(returnsGetAll.size(), returnsRepository.getAll().size());
    }
}*/
