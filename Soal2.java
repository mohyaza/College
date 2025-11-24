class Barang {
    String nama;
    int jumlahStok;
    double harga;

    // Constructor
    public Barang(String nama, int jumlahStok, double harga) {
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.harga = harga;
    }
}

public class Soal2 {

    static Barang[] inventaris = new Barang[10];

    public static void main(String[] args) {

        // menambahkan 3 barang
        inventaris[0] = new Barang("Pensil", 50, 200);
        inventaris[1] = new Barang("Buku", 30, 15000);
        inventaris[2] = new Barang("Penghapus", 20, 500);

        // update stok
        System.out.println("Masukkan nama barang yang ingin diupdate: Pensil");
        System.out.println("Masukkan jumlah stok baru: 60");
        updateStok("Pensil", 60);

        // menampilkan inventaris setelah diupdate
        System.out.println("\nInventaris setelah diupdate:");
        tampilkanInventaris();

        // mencari barang
        System.out.println("\nMasukkan nama barang yang dicari: Buku");
        System.out.println("Hasil pencarian:");
        cariBarang("Buku");
    }

    // Menampilkan semua barang
    public static void tampilkanInventaris() {
        for (int i = 0; i < inventaris.length; i++) {
            if (inventaris[i] != null) {
                System.out.println((i + 1) + ". Nama: " + inventaris[i].nama +
                        ", Jumlah Stok: " + inventaris[i].jumlahStok +
                        ", Harga: " + inventaris[i].harga);
            }
        }
    }

    // Mengupdate stok berdasarkan nama barang
    public static void updateStok(String nama, int jumlahBaru) {
        for (Barang inventari : inventaris) {
            if (inventari != null && inventari.nama.equalsIgnoreCase(nama)) {
                inventari.jumlahStok = jumlahBaru;
                System.out.println("\nStok barang '" + nama + "' berhasil diupdate.");
                return;
            }
        }
        System.out.println("\nBarang '" + nama + "' tidak ditemukan.");
    }

    // Mencari barang berdasarkan nama
    public static void cariBarang(String nama) {
        for (Barang inventari : inventaris) {
            if (inventari != null && inventari.nama.equalsIgnoreCase(nama)) {
                System.out.println("Nama: " + inventari.nama);
                System.out.println("Jumlah Stok: " + inventari.jumlahStok);
                System.out.println("Harga: " + inventari.harga);
                return;
            }
        }
        System.out.println("Barang '" + nama + "' tidak ditemukan.");
    }
}