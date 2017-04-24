package com.sandy.dsalgo.hash;

/**
 * Created by gondals on 17/08/16.
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This is an implementation of a consistent hash. T is the type of a bin.
 *
 * It is mostly copied from Tom White's implementation found here:
 * http://www.lexemetech.com/2007/11/consistent-hashing.html
 *
 * Blog comments mention that there may be a bug in this implementation -- if
 * there is a key collision we may lose bins. Probabilistically this is small,
 * and even smaller with a higher more replication factor. This could be made
 * even rarer by enlarging the circle by using Long instead of Integer.
 *
 * getNBins and getNUniqBins return ordered lists of bins for a particular
 * object. This is useful for assigning backups if the first bin fails.
 *
 * This datastructure is not threadsafe.
 */
public class ConsistentHash<T> {

    // when looking for n unique bins, give up after a streak of MAX_DUPES
    // duplicates
    public final static int MAX_DUPES = 10;

    // # of times a bin is replicated in hash circle. (for better load balancing)
    private final int numberOfReplicas;

    private final SortedMap<BigInteger, T> circle = new TreeMap<BigInteger, T>();


    public ConsistentHash(int numberOfReplicas, Collection<T> nodes) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.numberOfReplicas = numberOfReplicas;

        for (T node : nodes) {
            addBin(node);
        }
    }

    /**
     * Add a new bin to the consistent hash
     *
     * This assumes that the bin's toString method is immutable.
     *
     * This is not thread safe.
     */
    public void addBin(T bin) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        for (int i = 0; i < numberOfReplicas; i++) {
            // The string addition forces each replica to have different hash
            circle.put(hash(bin.toString() + i), bin);
        }
    }

    /**
     * Remove a bin from the consistent hash
     *
     * This assumes that the bin's toString method is immutable.
     *
     * This is not thread safe.
     */
    public void removeBin(T bin) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        for (int i = 0; i < numberOfReplicas; i++) {
            // The string addition forces each replica to be different. This needs
            // to resolve to the same keys as addBin.
            circle.remove(hash(bin.toString() + i));
        }
    }

    /**
     * This returns the closest bin for the object. If the object is the bin it
     * should be an exact hit, but if it is a value traverse to find closest
     * subsequent bin.
     */
    public T getBinFor(Object key) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (circle.isEmpty()) {
            return null;
        }
        BigInteger hash = hash(key.toString());
        T bin = circle.get(hash);

        if (bin == null) {
            // inexact match -- find the next value in the circle
            SortedMap<BigInteger, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
            bin = circle.get(hash);
        }
        return bin;
    }

    /**
     * This returns the closest n bins in order for the object. There may be
     * duplicates.
     */
    public List<T> getNBinsFor(Object key, int n) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (circle.isEmpty()) {
            return Collections.<T> emptyList();
        }

        List<T> list = new ArrayList<T>(n);
        BigInteger hash = hash(key.toString());
        for (int i = 0; i < n; i++) {
            if (!circle.containsKey(hash)) {
                // go to next element.
                SortedMap<BigInteger, T> tailMap = circle.tailMap(hash);
                hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
            }
            list.add(circle.get(hash));

            // was a hit so we increment and loop to find the next bin in the
            // circle
            hash.add(BigInteger.ONE);
        }
        return list;
    }

    /**
     * This returns the closest n bins in order for the object. There is extra
     * code that forces the bin values to be unique.
     *
     * This will return a list that has all the bins (and is smaller than n) if n
     * > number of bins.
     */
    public List<T> getNUniqueBinsFor(Object key, int n) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (circle.isEmpty()) {
            return Collections.<T> emptyList();
        }

        List<T> list = new ArrayList<T>(n);
        BigInteger hash = hash(key.toString());
        int duped = 0;
        for (int i = 0; i < n; i++) {
            if (!circle.containsKey(hash)) {
                // go to next element.
                SortedMap<BigInteger, T> tailMap = circle.tailMap(hash);
                hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
            }
            T candidate = circle.get(hash);
            if (!list.contains(candidate)) {
                duped = 0;
                list.add(candidate);
            } else {
                duped++;
                i--; // try again.
                if (duped > MAX_DUPES) {
                    i++; // we've been duped too many times, just skip to next, returning
                    // fewer than n
                }

            }

            // find the next element in the circle
            hash.add(BigInteger.ONE);
        }
        return list;
    }

    private BigInteger hash(String node) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] checksum = md5.digest(node.getBytes("UTF-8"));
        return new BigInteger(1, checksum);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("Consistent Hashing");
        ConsistentHash consistentHash = new ConsistentHash(2, new ArrayList());
        consistentHash.addBin("A");
        consistentHash.addBin("B");

        Object binFor1 = consistentHash.getBinFor(10);
        Object binFor2 = consistentHash.getBinFor(20);
        Object binFor3 = consistentHash.getBinFor(30);
        Object binFor4 = consistentHash.getBinFor(40);

        System.out.println("Done");
    }

}
