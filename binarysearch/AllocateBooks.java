package binarysearch;

public class AllocateBooks {

    public static int allocated_to_students(int books[], int max) {
        int b = 0, pages = 0, s = 1;

        while (b < books.length) {
            if (pages + books[b] > max) {
                s++;
                pages = books[b];
            } else {
                pages += books[b];
            }
            b++;
        }

        return s;
    }

    public static int allocateBooks(int books[], int students) {

        if(students > books.length) return -1;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int book : books){
            if(book > max) max = book;
            sum += book;
        }

        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int studs = allocated_to_students(books, mid);
            if(studs > students)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int books[] = { 25, 46, 28, 49, 24 };
        System.out.println(allocateBooks(books, 4));
        // System.out.println(allocated_to_students(books, 77));
    }

}
