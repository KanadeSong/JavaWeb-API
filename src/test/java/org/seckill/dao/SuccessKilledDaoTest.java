package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception{
        /**
         * 第一次执行结果：insertCount=1
         * 第二次执行结果：insertCount=0
         */
        long id = 1001L;
        long phone = 13030262635L;
        int insertCount = successKilledDao.insertSuccessKilled(id,phone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception{

        long id = 1001L;
        long phone = 13030262635L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
        /**
         * 第一次
         * SuccessKilled{seckillId=1000,
         * userPhone=13030262635,
         * state=-1,
         * createTime=Wed Dec 26 17:34:59 CST 2018}
         * Seckill{seckillId=1000,
         * name='500元秒杀iphone6',
         * number=100,
         * startTime=Sun Dec 30 00:00:00 CST 2018,
         * endTime=Tue Jan 01 00:00:00 CST 2019,
         * createTime=Tue Dec 25 14:41:13 CST 2018}
         *
         * 第二次
         * SuccessKilled{
         * seckillId=1001,
         * userPhone=13030262635,
         * state=0,
         * createTime=Wed Dec 26 17:56:09 CST 2018}
         * Seckill{
         * seckillId=1001,
         * name='1000元秒杀ipad2',
         * number=200,
         * startTime=Sun Dec 30 00:00:00 CST 2018,
         * endTime=Tue Jan 01 00:00:00 CST 2019,
         * createTime=Tue Dec 25 14:41:13 CST 2018}
         */
    }
}