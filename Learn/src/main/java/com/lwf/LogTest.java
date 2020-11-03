package com.lwf;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author lwf
 * @title: LogTest
 * @projectName Learn
 * @description: log4j练习
 * @date 2020/10/2019:24
 */
public class LogTest {
    static Logger logger = Logger.getLogger(LogTest.class);

    public static void test1() {
        BasicConfigurator.configure();
        logger.setLevel(Level.DEBUG);
        logger.info("122334");
        int num = 0;
        for (int i = 0; i < 10; i++) {
            logger.debug("num加" + i);
            num += i;
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
