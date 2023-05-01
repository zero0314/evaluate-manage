package com.zero314.evaluatemanage;

import com.zero314.evaluatemanage.dao.TbDimensionDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EvaluateManageApplicationTests {
    private TbDimensionDao dimensionDao;

    @Test
    void contextLoads() {
        try {
            System.out.println(dimensionDao.queryScore(3, 1));
        }catch (NullPointerException exception){
            System.out.println(0);
        }
    }

}
