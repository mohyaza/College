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

public class Soal1 {

    // Array inventaris dengan kapasitas 10
    static Barang[] inventaris = new Barang[10];

    public static void main(String[] args) {

        // menambahkan 3 barang ke Inventaris
        inventaris[0] = new Barang("Pensil", 50, 200);
        inventaris[1] = new Barang("Buku", 30, 15000);
        inventaris[2] = new Barang("Penghapus", 20, 500);

        // menampilkan Inventaris
        System.out.println("Inventaris Toko:");
        tampilkanInventaris();
    }

    // Method untuk menampilkan Inventaris
    public static void tampilkanInventaris() {
        for (int i = 0; i < inventaris.length; i++) {
            if (inventaris[i] != null) {
                System.out.println((i + 1) + ". Nama: " + inventaris[i].nama +
                        ", Jumlah Stok: " + inventaris[i].jumlahStok +
                        ", Harga: " + inventaris[i].harga);
            }
        }
    }
}