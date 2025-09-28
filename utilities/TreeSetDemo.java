package utilities;

import java.util.*;
import java.util.stream.Collectors;

enum Issuer {
    HDFC,
    AMEX,
    SBI,
    CITI,
    AXIS,
    ICICI
}

class MovieRentingSystem {
    class Book implements Comparable<Book> {
        int movie;
        int price;
        int shop;

        Book(int s, int m, int p) {
            movie = m;
            price = p;
            shop = s;
        }

        @Override
        public int compareTo(Book other) {
            if (this.price != other.price)
                return Integer.compare(this.price, other.price);
            if (this.shop != other.shop)
                return Integer.compare(this.shop, other.shop);
            return Integer.compare(this.movie, other.movie);
        }

        public String toString() {
            return String.format("[%d, %d, %d]", shop, movie, price);
        }
        
    }

    TreeSet<Book> rented = new TreeSet<>();
    Map<Integer, Set<Book>> unrented = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            unrented.putIfAbsent(movie, new TreeSet<Book>());
            unrented.get(movie).add(new Book(shop, movie, price));
            prices.putIfAbsent(movie, new HashMap<>());
            prices.get(movie).put(shop, price);
        }
    }

    public List<Integer> search(int movie) {
        return unrented.getOrDefault(movie, Collections.emptySet()).stream().limit(5).map(e -> e.shop)
                .collect(Collectors.toList());
    }

    public void rent(int shop, int movie) {
        Book book = new Book(shop, movie, prices.get(movie).get(shop));
        unrented.get(movie).remove(book);
        rented.add(book);
    }

    public void drop(int shop, int movie) {
        rented.remove(new Book(shop, movie, prices.get(movie).get(shop)));
        unrented.putIfAbsent(movie, new TreeSet<>());
        unrented.get(movie).add(new Book(shop, movie, prices.get(movie).get(shop)));
    }

    public List<List<Integer>> report() {
        return rented.stream().limit(5).map(e -> Arrays.asList(e.shop, e.movie)).collect(Collectors.toList());
    }
}

public class TreeSetDemo {

    public static void main(String[] args) {
        int[][] entries = {
                { 0, 1, 5 }, { 0, 2, 6 }, { 0, 3, 7 }, { 1, 1, 4 }, { 1, 2, 7 }, { 2, 1, 5 }
        };
        MovieRentingSystem mrs = new MovieRentingSystem(entries.length, entries);
        mrs.rent(0, 1);
        mrs.drop(0, 1);
        System.out.println(mrs.search(1));
        mrs.rent(0, 1);
        mrs.rent(2, 1);
        mrs.rent(1, 1);
        System.out.println(mrs.report());
        // System.out.println(mrs.rented);
        // System.out.println(mrs.unrented);
        // System.out.println(mrs.prices);
    }
}
