package com.in28minutes.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28minutes.learnspringaop.aopexample.data.DataService2;

@Service
public class BusinessService2 {

    private DataService2 DataService2;

    public BusinessService2(DataService2 dataService2) {
        DataService2 = dataService2;
    }

    public int calculateMin() {
        int[] data = DataService2.retrieveData();

        return Arrays.stream(data).min().orElse(0);
    }

}
