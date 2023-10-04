# Pemrograman Internet 2023

# Aplikasi Pengunduhan menggunakan Java
Ini adalah program yang memungkinkan pengguna untuk mengunduh file dengan URL dengan perantara antarmuka pengguna grafis (GUI) berbasis Swing. Aplikasi ini memiliki fitur-fitur yang lebih canggih dibandingkan dengan (DownloadApp) seperti pengunaan tab untuk mengatur penginduhan dan menampiljan daftar unduhar tebaru.


![image](https://github.com/mizanulridhoaohana/java-simpe-downloader/blob/main/Screenshot%20from%202023-10-04%2011-33-40.png)
![image](https://github.com/mizanulridhoaohana/java-simpe-downloader/blob/main/Screenshot%20from%202023-10-04%2011-34-19.png)


Program awal menampilkan tampilan GUI secara kasar karena memberikan prioritas terhadap fungsionalitas terlebih dahulu. Terdapat dua halaman utama yang tersedia, yaitu halaman "Download" dan "Recent Download." Fitur-fitur yang tersedia pada halaman "Download" mencakup kemampuan untuk menghentikan dan melanjutkan proses pengunduhan (pause dan resume) guna mengatur progress pengunduhan. Informasi mengenai daftar pengunduhan yang baru-baru ini dilakukan dapat ditemukan pada halaman selanjutnya, yaitu "Recent Download."



![image](https://github.com/mizanulridhoaohana/java-simpe-downloader/blob/main/Screenshot%20from%202023-10-04%2011-34-55.png)
![image](https://github.com/mizanulridhoaohana/java-simpe-downloader/blob/main/Screenshot%20from%202023-10-04%2011-35-00.png)


Pada halaman berikutnya, kami meningkatkan desain dengan menambahkan warna dan tata letak yang lebih baik agar memudahkan pengguna dalam penggunaan. Kami menyediakan kolom tautan yang lebih jelas dengan posisi yang ditengah, serta menambahkan bilah progres unduh untuk memantau persentase unduhan. Kami memilih kombinasi warna ungu dan hitam untuk memberikan kontras yang nyaman bagi mata pengguna.

## Fungsi dan Kegunaan 
### 1. Antarnuka pengguna (GUI)
Perogram ini  menyediakan antarmuka pengguna yang berisi tab Download untuk mengunduh file baru, sementara tab recent downloads menampilkan daftar unduhan terbaru.

### 2. Pengunduhan file
Pengguna dapat memasukkan URL file yang ingin diunduh melalui tab "Download". Programan akan memulai pengunduhan file dari URL yang diberikan. Pengguna dapat menggunakan tombol "Pause" dan "Resume" untuk mengontrol status pengunduhan.

### 3. Daftar unduh terbaru
Tab "Recent Downloads" menampilkan daftar unduhan terbaru yang telah selesai. Pengguna dapat melihat daftar file yang telah diunduh sebelumnya.

### 4. Progress Bar
Aplikasi ini menampilkan progress bar yang menunjukkan kemajuan pengunduhan saat berlangsung.

### 5. Penanganan kesalahan
Aplikasi ini memiliki penanganan kesalahan yang baik dan memberikan pesan kesalahan jika terjadi masalah selama pengunduhan.

## Penjelasan Kode
1. Kode ini menggunakan pustaka Swing untuk membuat antarmuka pengguna grafis (GUI) yang lebih canggih dengan penggunaan tab.

2.Metode `downloadFile(String fileUrl)` mengatur pengunduhan file dari URL yang diberikan dalam latar belakang menggunakan `SwingWorker`.

3.Aplikasi memiliki tab "Download" dan "Recent Downloads" yang dapat digunakan untuk mengakses fungsionalitas yang berbeda.

4.Tombol "Pause" dan "Resume" digunakan untuk mengontrol status pengunduhan.

5.Tab "Recent Downloads" menampilkan daftar unduhan terbaru yang telah berhasil diunduh.

## Cara Menggunakan Aplikasi
1. Jalankan aplikasi dengan menjalankan metode `main` pada kelas `DownloadAppWithTabs`.
2. Pada tab "Download", masukkan URL file yang ingin Anda unduh ke dalam kotak teks.
3. Klik tombol "Download" untuk memulai pengunduhan.
4. Anda dapat menggunakan tombol "Pause" dan "Resume" untuk mengontrol pengunduhan.
5. Progress pengunduhan akan ditampilkan pada progress bar.
6. Beralih ke tab "Recent Downloads" untuk melihat daftar unduhan terbaru yang telah selesai.
