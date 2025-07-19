//
//  Latihan1.c
//  PTCA-LAB Latihan Mandiri
//
//  Created by Yaza Alvashera on 19/07/25.
//

#include <stdio.h>
#include <string.h>

// Struktur untuk menyimpan data produk
struct Product {
    char nama[50];
    float harga;
    int stok;
};

int main(void) {
    struct Product productList[100];
    int productAmount, i, indexTermahal = 0;

    // Input jumlah produk
    printf("Masukkan jumlah produk: ");
    scanf("%d", &productAmount);
    

    // Input data produk
    for (i = 0; i < productAmount; i++) {
        printf("\nProduk ke-%d:\n", i + 1);

        printf("Nama: ");
        scanf(" %[^\n]", productList[i].nama);
        
        printf("Harga: ");
        scanf("%f", &productList[i].harga);

        printf("Stok: ");
        scanf("%d", &productList[i].stok);

        
    }

    // Mencari produk dengan harga tertinggi
    for (i = 1; i < productAmount; i++) {
        if (productList[i].harga > productList[indexTermahal].harga) {
            indexTermahal = i;
        }
    }

    // Menampilkan produk dengan harga tertinggi
    printf("\nProduk dengan harga tertinggi:\n");
    printf("Nama : %s\n", productList[indexTermahal].nama);
    printf("Harga: %.2f\n", productList[indexTermahal].harga);
    printf("Stok : %d\n", productList[indexTermahal].stok);

    return 0;
}
