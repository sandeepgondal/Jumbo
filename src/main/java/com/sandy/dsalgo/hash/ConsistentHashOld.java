package com.sandy.dsalgo.hash;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by gondals on 17/08/16.
 */
public class ConsistentHashOld {

    private static int MAX_REPLICA = 1;
    private SortedMap<BigInteger, String> entries = new TreeMap<>();

    public void put(String node) throws NoSuchAlgorithmException,
            UnsupportedEncodingException{
        BigInteger key = hash(node);
        entries.put(key, node);

        for (int i = 0 ; i < MAX_REPLICA ; i++ ) {
            key = hash(node + ":" + i);
            entries.put(key, node);
        }
    }

    private String get(String entry) throws NoSuchAlgorithmException,
            UnsupportedEncodingException{
        assert !entries.isEmpty() : "Handle this case properly";

        BigInteger key = hash(entry);

        if (!entries.containsKey(key)) {
            SortedMap<BigInteger, String> tailMap = entries.tailMap(key);
            key = tailMap.isEmpty() ? entries.firstKey() : tailMap.firstKey();
        }

        return entries.get(key);
    }

    private BigInteger hash(String node) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] checksum = md5.digest(node.getBytes("UTF-8"));
        return new BigInteger(1, checksum);
    }

    public static void main(String[] args) throws Exception {
        ConsistentHashOld s = new ConsistentHashOld();

        for (char c = 'A' ; c <= 'C' ; c++) {
            s.put(String.valueOf(c));
        }

        for (int i = 0 ; i < MAX_REPLICA ; i++) {
            System.out.print(s.get("user-id-" + i + "-data"));
        }
    }

}
