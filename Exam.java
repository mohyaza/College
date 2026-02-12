class BookNode {
    int callNumber;
    String title;
    BookNode left;
    BookNode right;

    BookNode(int callNumber, String title) {
        this.callNumber = callNumber;
        this.title = title;
        this.left = null;
        this.right = null;
    }
}

class LibraryBST {
    BookNode root;

    public void addBook(int callNumber, String title) {
        root = addRecursive(root, callNumber, title);
    }

    // Rekursi digunakan untuk menjaga aturan BST (kiri < node < kanan)
    private BookNode addRecursive(BookNode current, int callNumber, String title) {
        if (current == null) {
            return new BookNode(callNumber, title);
        }

        if (callNumber < current.callNumber) {
            current.left = addRecursive(current.left, callNumber, title);
        } else if (callNumber > current.callNumber) {
            current.right = addRecursive(current.right, callNumber, title);
        } else {
            // Asumsi callNumber unik, jika sama maka data diperbarui
            current.title = title;
        }

        return current;
    }

    // Non rekursif: maksimum BST selalu berada di node paling kanan
    public BookNode findMax() {
        if (root == null) return null;

        BookNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }
}

public class Exam {
    public static void main(String[] args) {

        LibraryBST library = new LibraryBST();

        library.addBook(107, "Moby Dick");
        library.addBook(253, "Don Quixote");
        library.addBook(50,  "War and Peace");
        library.addBook(331, "The Odyssey");
        library.addBook(179, "The Iliad");

        BookNode maxBook = library.findMax();

        if (maxBook != null) {
            System.out.println("Buku dengan nomor panggil tertinggi:");
            System.out.println("Call Number: " + maxBook.callNumber);
            System.out.println("Title      : " + maxBook.title);
        } else {
            System.out.println("Katalog kosong.");
        }
    }
}