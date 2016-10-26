package com.winterbe.java8.samples.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

/**
 * @author Benjamin Winterberg
 */
public class LongAccumulator1 {

    public static void main(String[] args) {
        testAccumulate();
    }

    private static void testAccumulate() {
        LongBinaryOperator op = (x, y) -> 2 * x + y;//定义一个二元操作
        LongAccumulator accumulator = new LongAccumulator(op, 1L);//生成新二元操作对象的累加方法,初始值为1
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        ConcurrentUtils.stop(executor);

        System.out.format("Add: %d\n", accumulator.getThenReset());
    }
}
