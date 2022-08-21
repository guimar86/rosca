package com.rosca.customer.util;

import com.rosca.customer.model.*;
import lombok.extern.slf4j.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BorrowerOrderTest {

    Set<Customer> customers = new HashSet<>();

    @BeforeEach
    public void setup() {

        Customer firstCustomer = Customer.builder()
                .iban("9191919191")
                .email("test@gmail.com")
                .telephone("00010001002")
                .name("John Does")
                .legalDocId("01919919")
                .build();


        Customer secondCustomer = Customer.builder()
                .iban("9191919191")
                .email("test@gmail.com")
                .telephone("00010001002")
                .name("GI Joe")
                .legalDocId("910191")
                .build();

        Customer thirdCustomer = Customer.builder()
                .iban("9191919191")
                .email("test@gmail.com")
                .telephone("00010001002")
                .name("Jane Doe")
                .legalDocId("99991")
                .build();

        customers.add(firstCustomer);
        customers.add(secondCustomer);
        customers.add(thirdCustomer);

    }

    @Test
    @DisplayName("Test order for borrower")
    public void testOrder() {

        var result = BorrowerOrder.flipBorrowerOrder("_1_2_3_4_5");

        assertEquals("1", result);
    }

    @Test
    @DisplayName("Set group order")
    public void testGroupOrder() {


        String order = BorrowerOrder.setGroupOrder(customers);
        log.info(order);
        assertNotNull(order);

    }

}