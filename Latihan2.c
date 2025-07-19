//
//  Latihan2.c
//  PTCA-LAB Latihan Mandiri 2
//
//  Created by Yaza Alvashera on 19/07/25.
//

#include <stdio.h>

// Fungsi untuk melakukan insertion sort
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}


int linearSearch(int arr[], int n, int target) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == target) {
            return i; // Mengembalikan indeks jika ditemukan
        }
    }
    return -1; // Jika tidak ditemukan
}

int main(void) {
    int data[100], n, i, cari, hasil;

    // Input jumlah data
    printf("Masukkan jumlah angka: ");
    scanf("%d", &n);

    // Input data angka
    for (i = 0; i < n; i++) {
        printf("Angka ke-%d: ", i + 1);
        scanf("%d", &data[i]);
    }

    
    insertionSort(data, n);

    // Tampilkan data terurut
    printf("\nData setelah diurutkan:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    // Input angka yang ingin dicari
    printf("\n\nMasukkan angka yang ingin dicari: ");
    scanf("%d", &cari);

    
    hasil = linearSearch(data, n, cari);

    if (hasil != -1) {
        printf("Angka %d ditemukan pada indeks ke-%d\n", cari, hasil);
    } else {
        printf("Angka %d tidak ditemukan.\n", cari);
    }

    return 0;
}
