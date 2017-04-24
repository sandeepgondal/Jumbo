package com.sandy.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

/**
 * Created by gondals on 11/09/16.
 */
public class Instance2 {

    public static void main(String[] args) {
        System.out.println("This is Hazelcast instance 2");

        HazelcastInstance instance2 = Hazelcast.newHazelcastInstance();

        IMap<Integer, String> customers = instance2.getMap("customers");
        System.out.println("Instance 2 Customer: " + customers.get(1));
        System.out.println("Instance 2 Customer: " + customers.get(2));
        System.out.println("Instance 2 Customer: " + customers.get(3));
        System.out.println("Instance 2 Customer: " + customers.get(4));
        customers.put(5, "Avyan");
        customers.put(6, "Avanti");

        IQueue<String> employees = instance2.getQueue("employees");
        System.out.println("Instance 2 Employee: " + employees.poll());
        System.out.println("Instance 2 Employee: " + employees.peek());
        employees.offer("Advay");
    }

}
