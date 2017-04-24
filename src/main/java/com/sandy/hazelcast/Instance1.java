package com.sandy.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

/**
 * Created by gondals on 11/09/16.
 */
public class Instance1 {

    public static void main(String[] args) {
        System.out.println("This is Hazelcast instance 1");

        HazelcastInstance instance1 = Hazelcast.newHazelcastInstance();

        IMap<Integer, String> customers = instance1.getMap("customers");
        customers.put(1, "Sandeep");
        customers.put(2, "Smita");
        customers.put(3, "Vivaan");
        customers.put(4, "Arjun");

        IQueue<String> employees = instance1.getQueue("employees");
        employees.offer("Anushka");
        employees.offer("Arya");
        employees.offer("Anaya");
    }

}
