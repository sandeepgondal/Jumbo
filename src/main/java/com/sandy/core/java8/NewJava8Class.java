package com.sandy.core.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by gondals on 17/09/16.
 */
public class NewJava8Class {

    private static List<Student> students = new ArrayList<>();

    static
    {
        students.add(new Student(1, "Sandeep"));
        students.add(new Student(5, "Smita"));
        students.add(new Student(3, "Vivaan"));
        students.add(new Student(9, "Sandeep"));
        students.add(new Student(7, "Anushka"));
        students.add(new Student(7, "Anushka1"));
    }

    public static void main(String[] args) {
        System.out.println("Hello Java 8");

        NewJava8Class newJava8Class = new NewJava8Class();
        newJava8Class.exercise1();
        newJava8Class.printAllCollectionValues();
        newJava8Class.collectToList();
        newJava8Class.collectToSet();
        newJava8Class.collectToMap();
        newJava8Class.groupingBy();
        newJava8Class.joining();
        newJava8Class.distinct();
        newJava8Class.reduce1();
        newJava8Class.reduce2();
        newJava8Class.averageInt();
        newJava8Class.summarizingInt();
        newJava8Class.sort();
    }

    private void sort() {
        System.out.println("---------------");
        students.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
    }

    private void summarizingInt() {
        System.out.println("---------------");
        IntSummaryStatistics collect = students.stream()
                .collect(Collectors.summarizingInt(Student::getId));
        System.out.println(collect);
    }

    private void averageInt() {
        System.out.println("---------------");
        Double collect = students.stream()
                .collect(Collectors.averagingInt(Student::getId));
        System.out.println("Average id: " + collect);
    }

    private void reduce2() {
        System.out.println("---------------");
        Integer reduce = students.stream()
                .map(Student::getId)
                .reduce(0, Integer::sum);
        System.out.println("Total of ids: " + reduce);
    }

    private void reduce1() {
        System.out.println("---------------");
        students.stream()
                .reduce((s1, s2) -> s1.getId() > s2.getId() ? s1 : s2)
                .ifPresent(System.out::println);

    }

    private void distinct() {
        System.out.println("---------------");
        students.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private void joining() {
        System.out.println("---------------");
        String collect = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining("*"));
        System.out.println(collect);
    }

    private void groupingBy() {
        System.out.println("---------------");
        Map<Integer, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getId));
        collect.keySet().stream()
                .forEach(k -> System.out.println("Id: " + k +", count: " + collect.get(k).size()));
    }

    private void collectToMap() {
        System.out.println("---------------");
        Map<Integer, Student> collect = students.stream()
                .collect(Collectors.toMap(Student::getId, Function.identity(), (a, b) -> b));
        collect.keySet().stream()
                .forEach(k -> System.out.println(collect.get(k)));
    }

    private void collectToSet() {
        System.out.println("---------------");
        Set<Student> students = NewJava8Class.students.stream()
                .collect(Collectors.toSet());
        students.stream()
                .forEach(System.out::println);
    }

    private void collectToList() {
        System.out.println("---------------");
        List<Student> students = NewJava8Class.students.stream()
                .filter(s -> s.getId() > 3)
                .collect(Collectors.toList());
        students.stream()
                .forEach(System.out::println);
    }

    private void printAllCollectionValues() {
        System.out.println("---------------");
        students.stream()
                .forEach(System.out::println);
    }

    private void exercise1() {
        List<Track> tracks1 = new ArrayList<>();
        tracks1.add(new Track(2));
        tracks1.add(new Track(1));
        Album album1 = new Album("Sandeep", tracks1);

        List<Track> tracks2 = new ArrayList<>();
        tracks2.add(new Track(5));
        tracks2.add(new Track(1));
        Album album2 = new Album("Parth", tracks2);

        List<Track> tracks3 = new ArrayList<>();
        tracks3.add(new Track(2));
        tracks3.add(new Track(4));
        Album album3 = new Album("Champak", tracks3);

        List<Album> albumList = new ArrayList<>();
        albumList.add(album1);
        albumList.add(album2);
        albumList.add(album3);

        // Solution 1
        System.out.println("Solution 1");
        List<Album> favourite = new ArrayList<>();
        for (Album album : albumList) {
            boolean flag = false;
            for (Track track : album.getTracks()) {
                if (track.getRating() >= 4) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                favourite.add(album);
        }

        Collections.sort(favourite, new Comparator<Album>() {
            @Override
            public int compare(final Album o1, final Album o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        for (Album album : favourite)
            System.out.println(album);

        // Solution 2
        System.out.println("\n\nSolution 2\n");
        albumList.stream()
                .filter(a -> {
                    long count = a.getTracks().stream()
                            .filter(t -> t.getRating() >= 4)
                            .count();
                    return count > 0;

                })
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);

        // Solution 3
        System.out.println("\n\nSolution 3\n");
        albumList.stream()
                .filter(a -> a.getTracks().stream().anyMatch(t -> t.getRating() >= 4))
                .sorted(Comparator.comparing(Album::getName))
                .forEach(System.out::println);
    }

    private class Album {
        private String name;
        private List<Track> tracks;

        public Album(final String name, final List<Track> tracks) {
            this.name = name;
            this.tracks = tracks;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public List<Track> getTracks() {
            return tracks;
        }

        public void setTracks(final List<Track> tracks) {
            this.tracks = tracks;
        }

        @Override
        public String toString() {
            return "Album{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private class Track {
        private int rating;

        public Track(final int rating) {
            this.rating = rating;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(final int rating) {
            this.rating = rating;
        }
    }

}
