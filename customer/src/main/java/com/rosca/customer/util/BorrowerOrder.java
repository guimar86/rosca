package com.rosca.customer.util;

import com.rosca.customer.model.Customer;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BorrowerOrder {

    public static String setGroupOrder(Set<Customer> customers) {

        StringBuilder returnValue = new StringBuilder();
        String separator = "_";

        customers.forEach(p -> returnValue.append(separator.concat(p.getLegalDocId())));

        return returnValue.toString();
    }


    public static long nextBorrower(String order) {

        String separator = "_";
        String[] ord = order.split(separator);
        ord = Arrays.stream(ord).filter(p -> !p.isEmpty()).toArray(String[]::new);
        Collections.rotate(Arrays.asList(ord), -1);
        return Long.parseLong(ord[0]);
    }

    public static String flipBorrowerOrder(String order) {

        String separator = "_";
        String[] ord = order.split(separator);
        ord = Arrays.stream(ord).filter(p -> !p.isEmpty()).toArray(String[]::new);
        String returnValue = ord[0];
        Collections.rotate(Arrays.asList(ord), -1);

        return returnValue;

    }
}
