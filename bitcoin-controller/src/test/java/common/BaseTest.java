package common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试基类，所有测试类都要继承此类，此类主要用于加载配置文件
 * @author Jiayanxing
 * @date 2017年1月18日 下午6:01:58
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration(locations="classpath:applicationContext.xml") //加载配置文件  
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上控制事务  
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！  
@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
public class BaseTest {
	
}
