package com.ysh.web;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class WebApplicationTests {
    private final static int num = 100000;

    @Test
    public void contextLoads() {
//        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),num);默认3%
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),num,0.01);

        Set<String> sets = new HashSet<String>(num);

        List<String> lists = new ArrayList<String>(num);

        for (int i = 0; i < num; i++) {
            String uuid = UUID.randomUUID().toString();
            bf.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        }

        int wrong = 0;
        int right = 0;
        int other = 0;

        for (int i = 0; i < 10000; i++) {
            String test = i%100==0?lists.get(i/100):UUID.randomUUID().toString();
            if (bf.mightContain(test)) {
                if (sets.contains(test)) {
                    right++;
                }else {
                    wrong++;
                }
            }else {
                other++;
            }
        }

        System.out.println(String.format("wrong===%s,right===%s,other===%s",wrong,right,other));
    }

}
