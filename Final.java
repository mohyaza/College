import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ArrayOperations {

    int[] numbers = {10, 20, 30, 40, 50};

    // method traversal untuk output
    void traversalPrint() {
        System.out.println("Array Traversal: " + Arrays.toString(numbers));
    }

    /* method traversal untuk Benchmark
    dipanggil di Comparison agar hasil benchmark murni tnapa Print */
    void traversalBenchmark() {
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
        }
    }
    
    // method Linear Search
    int linearSearch(int target) {
        int index = -1; // default tidak ketemu karena indeks tidak mungkin negatif
        int i = 0;

        while (i < numbers.length) {
            if (numbers[i] == target) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    // method Binary Search
    int binarySearch(int target) {
        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;
        int index = -1; // default tidak ketemu karena indeks tidak mungkin negatif

        while (left <= right) {
            int mid = (left + right) / 2;

            if (numbers[mid] == target) {
                index = mid;
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    // method penyisipan
    void insert(int value, int index) {
        // buat array baru panjang + 1
        int[] newNumbers = new int[numbers.length + 1];

        // salin bagian sebelum indeks
        System.arraycopy(numbers, 0, newNumbers, 0, index);

        // taruh value di posisi indeks
        newNumbers[index] = value;

        // salin sisa elemen stelah indeks
        System.arraycopy(
                numbers,
                index,
                newNumbers,
                index + 1,
                numbers.length - index
        );

        // ganti array lama dengan array baru
        numbers = newNumbers;
    }

    // method penghapusan
    void delete(int index) {
        // buat array baru - 1
        int[] newNumbers = new int[numbers.length - 1];

        // salin bagian sebelum indeks
        System.arraycopy(numbers, 0, newNumbers, 0, index);

        // salin bagian setelah indeks (skipping elemen yang diapus)
        System.arraycopy(
                numbers,
                index + 1,
                newNumbers,
                index,
                numbers.length - index - 1
        );

        // ganti array lama dengan array baru
        numbers = newNumbers;
    }
}

class ArrayListOperations {

    ArrayList<Integer> numbers = new ArrayList<>();

    ArrayListOperations() {
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
    }

    // method traversal untuk output
    void traversalPrint() {
        System.out.println("ArrayList Traversal: " + numbers);
    }

    /* method traversal untuk Benchmark
    dipanggil di Comparison agar hasil benchmark murni tanpa Print */
    void traversalBenchmark() {
        for (int i = 0; i < numbers.size(); i++) {
            int temp = numbers.get(i);
        }
    }

    // method penambahan di Array Lst
    void add(int value, int index) {
        numbers.add(index, value);
    }

    // method penghapusan di Array List
    void delete(int index) {
        numbers.remove(index);
    }

    // method pencarian di Array List
    int search(int target) {
        return numbers.indexOf(target);
    }

    // method pengurutan di Array List
    void sort() {
        Collections.sort(numbers);
    }
}


class Comparison {

    // unutk pengukuran pada Array
    long arrayTraversalTime;
    long arrayLinearSearchTime;
    long arrayBinarySearchTime;
    long arrayInsertTime;
    long arrayDeleteTime;

    // untuk pengukuran pada Array List
    long listTraversalTime;
    long listSearchTime;
    long listSortTime;
    long listInsertTime;
    long listDeleteTime;

    // konversi nano to millisecond
    double nanoToMs(long nano) {
        return nano / 1_000_000.0;
    }

    // jalankan operasi dasar dan ukur waktu
    void compareAll(
            ArrayOperations arrayOps,
            ArrayListOperations listOps,
            int target,
            int value,
            int index
    ) {

        long start, end;

        // ===== ARRAY =====
        // ukur waktu traversal array
        start = System.nanoTime();
        arrayOps.traversalBenchmark();
        end = System.nanoTime();
        arrayTraversalTime = end - start;

        // ukur waktu linear search array
        start = System.nanoTime();
        arrayOps.linearSearch(target);
        end = System.nanoTime();
        arrayLinearSearchTime = end - start;

        // ukur waktu binary search array
        start = System.nanoTime();
        arrayOps.binarySearch(target);
        end = System.nanoTime();
        arrayBinarySearchTime = end - start;

        // ukur waktu penyisipan array
        start = System.nanoTime();
        arrayOps.insert(value, index);
        end = System.nanoTime();
        arrayInsertTime = end - start;

        // ukur waktu penyisipan array
        start = System.nanoTime();
        arrayOps.delete(index);
        end = System.nanoTime();
        arrayDeleteTime = end - start;

        // ===== ARRAYLIST =====
        // ukur waktu traversal array list
        start = System.nanoTime();
        listOps.traversalBenchmark();
        end = System.nanoTime();
        listTraversalTime = end - start;

        // ukur waktu search array list
        start = System.nanoTime();
        listOps.search(target);
        end = System.nanoTime();
        listSearchTime = end - start;

        // ukur waktu pengurutan Array List
        start = System.nanoTime();
        listOps.sort();
        end = System.nanoTime();
        listSortTime = end - start;

        // ukur waktu penyisipan array list
        start = System.nanoTime();
        listOps.add(value, index);
        end = System.nanoTime();
        listInsertTime = end - start;

        // ukur waktu penghapusan array list
        start = System.nanoTime();
        listOps.delete(index);
        end = System.nanoTime();
        listDeleteTime = end - start;
    }
}

public class Final {

    public static void main(String[] args) {

        int target = 30;
        int value = 25;
        int index = 2;

        // object untuk output
        ArrayOperations arrayOps = new ArrayOperations();
        ArrayListOperations listOps = new ArrayListOperations();

        // Tampilkan hasil traversal dari method di kelas Array & Array List
        arrayOps.traversalPrint();
        listOps.traversalPrint();
        System.out.println();

        // Search dan tampilkan hasilnya
        System.out.println(
                "Pencarian " + target +
                " dalam Array: Ditemukan di indeks " +
                arrayOps.linearSearch(target)
        );

        System.out.println(
                "Pencarian " + target +
                " dalam ArrayList: Ditemukan di indeks " +
                listOps.search(target)
        );
        System.out.println();

        // Insertion
        arrayOps.insert(value, index);
        listOps.add(value, index);

        // menampilkan hasil setelah insertion
        System.out.println(
                "Array setelah penyisipan elemen " + value +
                ": " + Arrays.toString(arrayOps.numbers)
        );
        System.out.println(
                "ArrayList setelah penyisipan elemen " + value +
                ": " + listOps.numbers
        );
        System.out.println();
        
        /* object khusus benchmark agar data set kembali seperti awal dengan 5 elemen
        (bukan yang sudah dirubah rubah oleh main) */
        ArrayOperations arrayBench = new ArrayOperations();
        ArrayListOperations listBench = new ArrayListOperations();

        // jalankan perbandingan waktu
        Comparison comp = new Comparison();
        comp.compareAll(arrayBench, listBench, target, value, index);

        // menampilkan waktu eksekusi
        System.out.println(
                "Waktu eksekusi pencarian pada Array: " +
                comp.nanoToMs(comp.arrayLinearSearchTime) + " ms"
        );
        System.out.println(
                "Waktu eksekusi pencarian pada ArrayList: " +
                comp.nanoToMs(comp.listSearchTime) + " ms"
        );
    }
}