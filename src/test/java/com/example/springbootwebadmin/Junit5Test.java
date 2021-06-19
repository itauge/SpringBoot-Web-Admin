package com.example.springbootwebadmin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Junit5Test {

    /**
     * 測試前置條件assumption
     */
    @Test
    void testAssumption(){
        Assumptions.assumeTrue(false,"結果不是true");
        System.out.println("111");
    }

    /**
     * 斷言：前面斷言失敗，後面就不會執行
     */
    @DisplayName("test simple assertions")
    @Test
    void testSimpleAssertions(){
        int cal = cal(2, 3);
        assertEquals(5,cal,"業務邏輯計算失敗");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"兩個對象不一樣");
    }

    int cal(int i,int j){
        return i+j;
    }

    @Test
    void array(){
        int[] int1 = {1, 2};
        int[] int2 = {1,2};
        assertArrayEquals(int1,int2,"數組不一樣");
    }

    /**
     * 所有斷言全部需要成功
     */
    @Test
    void all(){
        assertAll("test",
                ()-> assertTrue(true && true,"the result is not true"),
                ()-> assertEquals(1,2,"the result is not 1"));
    }

    @DisplayName("異常斷言")
    @Test
    void testException(){
        //斷定業務邏輯一定異常
        assertThrows(ArithmeticException.class,()-> {int i=10/0;},"業務邏輯居然正常");
    }

    @Test
    void testFail(){
        fail("測試失敗");
    }

    @DisplayName("test displayname")
    @Test
    void testDisplayname(){
        System.out.println(1);
    }

    @DisplayName("test displayname2")
    @Test
    void testDisplayname2(){
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3(){
        System.out.println(5);
    }

    @Disabled
    @BeforeEach
    void testBeforEach(){
        System.out.println("test is start...");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("test is end...");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("all test ready to start..");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("all test is end...");
    }

    /**
     * 規定方法的的超時時間，如果超過報錯
     * @throws InterruptedException
     */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(1200));
    }
}
