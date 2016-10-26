package com.winterbe.java8.samples.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

        List<String> alist= Arrays.asList("abc","cba",null,"aaa");
        System.out.println (alist.stream().anyMatch(m->{return "abc".equals(m);}));
    }

}