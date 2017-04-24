package com.sandy.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

/**
 * Created by gondals on 11/09/16.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("Using cline to fetch data from hazelcast Cluster");

        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Integer, String> customers = client.getMap("customers");
        System.out.println("Client Customer: " + customers.get(5));
        System.out.println("Client Customer: " + customers.get(6));

        IQueue<String> employees = client.getQueue("employees");
        System.out.println("Client Employee: " + employees.poll());
        System.out.println("Client Employee: " + employees.poll());
        System.out.println("Client Employee: " + employees.poll());
    }

}
