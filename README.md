# Pemrograman Internet 2023

# Aplikasi Pengunduhan menggunakan Java
Ini adalah program yang memungkinkan pengguna untuk mengunduh file dengan URL dengan perantara antarmuka pengguna grafis (GUI) berbasis Swing.

Dalam proyek ini kami mengembangkan 2 aplikasi yang dibangun dengan tools yang berbeda yaitu Visual Studio Code dan NetBeans. Kedua aplikasi yang dibuat memiliki fitur yang cukup menarik untuk digunakan, diantaranya fitur pause, resume dan history unduhan. Aplikasi yang dibangun menggunakan `VS Code` memiliki `GUI` yang sangat `sederhana` karena sulitnya mengimplementasikan swing tanpa ada panduan. 

Sedangkan, Aplikasi yang dibangun menggunakan `NetBeans` memiliki `tampilan GUI yang lebih elegan dan memanjakan mata`, hal ini didukung oleh fitur design yang disediakan oleh NetBeans sehingga memudahkan developer untuk berkreasi.


**CATATAN   : Projeck menggunakan VS Code berada di branch main**

![image](https://github.com/mizanulridhoaohana/java-simpe-downloader/blob/main/Screenshot%20from%202023-10-04%2011-33-40.png)
![image](https://github.com/mizanulridhoaohana/java-simpe-downloader/blob/main/Screenshot%20from%202023-10-04%2011-34-19.png)


Program awal menampilkan tampilan GUI secara kasar karena memberikan prioritas terhadap fungsionalitas terlebih dahulu. Terdapat dua halaman utama yang tersedia, yaitu halaman "Download" dan "Recent Download." Fitur-fitur yang tersedia pada halaman "Download" mencakup kemampuan untuk menghentikan dan melanjutkan proses pengunduhan (pause dan resume) guna mengatur progress pengunduhan. Informasi mengenai daftar pengunduhan yang baru-baru ini dilakukan dapat ditemukan pada halaman selanjutnya, yaitu "Recent Download."

**CATATAN   : Projeck menggunakan NetBeans berada di branch master**
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

## Github Repository
1. GUI sederhana menggunakan Visual Studio Code
   
   Untuk GUI sederhana, anda bisa langsung mengunduh/clone file yang ada di branch `main`.
   
   ```git clone https://github.com/mizanulridhoaohana/java-simpe-downloader.git```
   
3. GUI pengembangan menggunakan NetBeans
   
   Untuk versi ini, anda dapat mengunduh/clone brach `master` yang ada di repository ini ke dalam NetBeans anda.


## Cara Menggunakan Aplikasi
1. Clone code yang ingin dijalankan, kemudian run code agar menampilkan aplikasi.
   - Untuk GUI sederhana anda dapat langsung mengeksekusi file bernama `DownloadAppWithTabs.java`.
   - Sedangkan untuk GUI perubahan anda dapat mengakses file `./src/base/downloadFrame.java` pada branch master.
3. Pada tab "Download", masukkan URL file yang ingin Anda unduh ke dalam kotak teks.
4. Klik tombol "Download" untuk memulai pengunduhan.
5. Anda dapat menggunakan tombol "Pause" dan "Resume" untuk mengontrol pengunduhan.
6. Progress pengunduhan akan ditampilkan pada progress bar.
7. Beralih ke tab "Recent Downloads" untuk melihat daftar unduhan terbaru yang telah selesai.
