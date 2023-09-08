package com.in28minutes.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28minutes.learnspringaop.aopexample.annotations.TrackTime;
import com.in28minutes.learnspringaop.aopexample.data.DataService1;

@Service
public class BusinessService1 {

    private DataService1 DataService1;

    public BusinessService1(com.in28minutes.learnspringaop.aopexample.data.DataService1 dataService1) {
        DataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() {
        int[] data = DataService1.retrieveData();

        return Arrays.stream(data).max().orElse(0);
    }

}
