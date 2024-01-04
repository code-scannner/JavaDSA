package binarysearch;

public class AllocateBooks {

    public static int can_allocate(int books[], int students, int max) {
        int b = 1, pages = books[0], s = 1;

        while (b < books.length && s <= students) {
            if (pages + books[b] > max) {
                s++;
                pages = books[b];
            } else {
                pages += books[b];
            }
            b++;
        }

        if(b < books.length) return -1;
        if(s < students) return 1;
        return 0;
    }

    public static int allocateBooks(int books[], int students) {
        return 0;
    }

    public static void main(String[] args) {
        int books[] = { 25, 46, 28, 49, 24 };
        System.out.println(can_allocate(books, 4, 70));
    }

}
