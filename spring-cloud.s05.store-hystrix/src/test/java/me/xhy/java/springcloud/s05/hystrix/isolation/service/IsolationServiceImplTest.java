package me.xhy.java.springcloud.s05.hystrix.isolation.service;

import me.xhy.java.springcloud.s05.hystrix.StoreHystrix;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StoreHystrix.class)
@WebAppConfiguration
public class IsolationServiceImplTest {

  @Autowired
  IsolationServiceImpl isolationService;

  private int count = 11;

  private CountDownLatch cdl = new CountDownLatch(count);

  @Test
  public void testHystrix() {

    for (int i = 0; i < count; i++) {
      new Thread(() -> {
          try {
            cdl.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        System.out.println(Thread.currentThread().getName() + " ==> " + isolationService.isolationByThread());
        }
      , "Test Thread-" + i).start();
      cdl.countDown();
    }

    try {
      Thread.currentThread().join();
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testHystrixSemaphore() {

    for (int i = 0; i < count; i++) {
      new Thread(() -> {
        try {
          cdl.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ==> " + isolationService.isolationBySemaphore());
      }
          , "Test Thread-" + i).start();
      cdl.countDown();
    }

    try {
      Thread.currentThread().join();
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  @After
  public void after() {

  }


}
