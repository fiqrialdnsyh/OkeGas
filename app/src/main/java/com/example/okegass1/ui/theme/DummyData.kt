package com.example.okegass1.ui.theme

import com.example.okegass1.R

data class Penginapan(
    val nama: String,
    val kota: String,
    val harga: String,
    val imageRes: Int
)

data class ProvinsiPenginapan(
    val namaProvinsi: String,
    val listPenginapan: List<Penginapan>
)

object DummyData {
    val wisataList = listOf(
        Wisata(
            id = 1,
            nama = "Pantai Kuta",
            lokasi = "Bali",
            imageRes = R.drawable.pantai_kuta,
            deskripsi = "Pantai Kuta adalah sebuah tempat pariwisata yang terletak di kecamatan Kuta sebelah selatan Kota Denpasar, Bali, Indonesia. Daerah ini merupakan sebuah tujuan wisata turis mancanegara dan telah menjadi objek wisata andalan Pulau Bali sejak awal tahun 1970-an. Pantai Kuta sering pula disebut sebagai pantai matahari terbenam sebagai lawan dari pantai Sanur. Sebelum menjadi objek wisata, Kuta merupakan sebuah pelabuhan dagang tempat produk lokal diperdagangkan kepada pembeli dari luar Bali. Pada abad ke-19, Mads Lange, seorang pedagang Denmark, datang ke Bali dan mendirikan basis perdagangan di Kuta. Ia ahli bernegosiasi sehingga dirinya terkenal di antara raja-raja Bali dan Belanda.[2]\n" +
                    "\n" +
                    "Selanjutnya, Hugh Mahbett menerbitkan sebuah buku berjudul “Praise to Kuta” yang berisi ajakan kepada masyarakat setempat untuk menyiapkan fasilitas akomodasi wisata. Tujuannya untuk mengantisipasi ledakan wisatawan yang berkunjung ke Bali. Buku itu kemudian menginspirasi banyak orang untuk membangun fasilitas wisata seperti penginapan, restoran dan tempat hiburan.",
            rating = 4.5,
            jumlahUlasan = 123,
            jamBuka = "07:00–19:00"
        ),
        Wisata(
            id = 2,
            nama = "Candi Borobudur",
            lokasi = "Magelang",
            imageRes = R.drawable.candi_borobudur,
            deskripsi = "Candi Borobudur (bahasa Jawa: ꦕꦟ꧀ꦝꦶꦧꦫꦧꦸꦝꦸꦂ, translit. Candhi Båråbudhur) adalah sebuah candi Buddha yang terletak di Borobudur, Magelang, Jawa Tengah, Indonesia. Candi ini terletak kurang lebih 100 km di sebelah barat daya Semarang, 86 km di sebelah barat Surakarta, dan 40 km di sebelah barat laut Yogyakarta. Candi dengan banyak stupa ini didirikan oleh para penganut agama Buddha Mahayana sekitar tahun 800-an Masehi pada masa pemerintahan wangsa Syailendra. Borobudur adalah candi atau kuil Buddha terbesar di dunia, sekaligus salah satu monumen Buddha terbesar di dunia.\n" +
                    "\n" +
                    "Monumen ini terdiri atas enam teras berbentuk bujur sangkar yang di atasnya terdapat tiga pelataran melingkar, pada dindingnya dihiasi dengan 2.672 panel relief dan aslinya terdapat 504 arca Buddha. Borobudur memiliki koleksi relief Buddha terlengkap dan terbanyak di dunia. Stupa utama terbesar terletak di tengah sekaligus memahkotai bangunan ini, dikelilingi oleh tiga barisan melingkar 72 stupa berlubang yang di dalamnya terdapat arca Buddha tengah duduk bersila dalam posisi teratai sempurna dengan mudra (sikap tangan) Dharmachakra mudra (memutar roda dharma).\n" +
                    "\n" +
                    "Monumen ini merupakan model alam semesta dan dibangun sebagai tempat suci untuk memuliakan Buddha sekaligus berfungsi sebagai tempat ziarah untuk menuntun umat manusia beralih dari alam nafsu duniawi menuju pencerahan dan kebijaksanaan sesuai ajaran Buddha. Para peziarah masuk melalui sisi timur dan memulai ritual di dasar candi dengan berjalan melingkari bangunan suci ini searah jarum jam, sambil terus naik ke undakan berikutnya melalui tiga tingkatan ranah dalam kosmologi Buddha. Ketiga tingkatan itu adalah Kāmadhātu (ranah hawa nafsu), Rupadhatu (ranah berwujud), dan Arupadhatu (ranah tak berwujud). Dalam perjalanannya para peziarah berjalan melalui serangkaian lorong dan tangga dengan menyaksikan tak kurang dari 1.460 panel relief indah yang terukir pada dinding dan pagar langkan.\n" +
                    "\n" +
                    "Menurut bukti-bukti sejarah, Borobudur ditinggalkan pada abad ke-10 seiring dipindahnya pusat Kerajaan Mataram Kuno ke Jawa Timur oleh Mpu Sindok. Dunia mulai menyadari keberadaan bangunan ini sejak ditemukan 1814 oleh Sir Thomas Stamford Raffles, yang saat itu menjabat sebagai Gubernur Jenderal Inggris atas Jawa. Sejak saat itu Borobudur telah mengalami serangkaian upaya penyelamatan dan pemugaran (perbaikan kembali). Proyek pemugaran terbesar digelar pada kurun waktu 1975 hingga 1982 atas upaya Pemerintah Republik Indonesia dan UNESCO, kemudian situs bersejarah ini masuk dalam daftar Situs Warisan Dunia.\n" +
                    "\n" +
                    "Borobudur kini masih digunakan sebagai tempat ziarah keagamaan; tiap tahun umat Buddha yang datang dari seluruh Indonesia dan mancanegara berkumpul di Borobudur untuk memperingati Trisuci Waisak. Terkait kepariwisataan, Borobudur adalah objek wisata tunggal di Indonesia yang paling banyak dikunjungi wisatawan.\n" +
                    "\n" +
                    "Pada 11 Februari 2022, pemerintah meresmikan status Candi Borobudur kembali sebagai tempat peribadatan umat Buddha di Indonesia dan dunia.",
            rating = 4.8,
            jumlahUlasan = 245,
            jamBuka = "06:00–17:00"
        ),
        Wisata(
            id = 3,
            nama = "Gunung Merbabu",
            lokasi = "Jawa Tengah",
            imageRes = R.drawable.merbabu,
            deskripsi = "Gunung Merbabu (Hanacaraka: ꦒꦸꦤꦸꦁꦩꦼꦂꦧꦧꦸ) adalah gunung api yang bertipe Stratovulcano yang terletak secara geografis pada 7,5° LS dan 110,4° BT. Secara administratif gunung ini berada di wilayah Kabupaten Magelang di lereng sebelah barat dan Kabupaten Boyolali di lereng sebelah timur dan selatan, Kabupaten Semarang di lereng sebelah utara, Provinsi Jawa Tengah.\n" +
                    "\n" +
                    "Gunung Merbabu dikenal melalui naskah-naskah masa pra-Islam sebagai Gunung Damalung:389 atau Gunung Pam(a)rihan.:69,:82 Di lerengnya pernah terdapat pertapaan terkenal yang pernah disinggahi oleh Bujangga Manik pada abad ke-15.:416 Menurut etimologi, \"merbabu\" berasal dari gabungan kata \"meru\" (gunung) dan \"abu\" (abu). Nama ini baru muncul pada catatan-catatan Belanda.\n" +
                    "\n" +
                    "Gunung ini pernah meletus pada tahun 1560 dan 1797. Dilaporkan juga pada tahun 1570 pernah meletus, akan tetapi belum dilakukan konfirmasi dan penelitian lebih lanjut. Puncak gunung Merbabu berada pada ketinggian 3.145 meter di atas permukaan air laut.\n" +
                    "\n" +
                    "Gunung Merbabu mempunyai kawasan Hutan Dipterokarp Bukit, Hutan Dipterokarp Atas, Hutan Montane, dan hutan Ericaceous atau hutan gunung. Gunung Merbabu merupakan salah satu gunung yang sangat populer untuk kegiatan hiking. Di Gunung Merbabu terdapat 5 jalur pendakian resmi yang sering dipakai untuk mendaki, di antaranya:\n" +
                    "\n" +
                    "Jalur pendakian gunung Merbabu via Selo (Boyolali)\n" +
                    "Jalur pendakian gunung Merbabu via Suwanting (Magelang)\n" +
                    "Jalur pendakian gunung Merbabu via Wekas (Magelang)\n" +
                    "Jalur pendakian gunung Merbabu via Cunthel (Semarang)\n" +
                    "Jalur pendakian gunung Merbabu via Thekelan (Semarang)\n" +
                    "Kelima jalur pendakian tersebut memiliki tingkat kesulitan masing-masing. Pendaki pemula biasanya memilih mendaki lewat jalur Selo sedangkan pendaki senior yang ingin cepat sampai puncak biasanya memilih jalur Wekas, karena waktu tempuhnya lebih pendek.",
            rating = 4.8,
            jumlahUlasan = 245,
            jamBuka = "06:00–17:00"
        ),
        Wisata(
            id = 4,
            nama = "Gunung Bromo",
            lokasi = "Jawa Timur",
            imageRes = R.drawable.gunung_bromo,
            deskripsi = "Gunung Bromo atau dalam bahasa Tengger dieja \"Brama\", juga disebut Kaldera Tengger, adalah sebuah gunung berapi aktif di Jawa Timur, Indonesia. Gunung ini memiliki ketinggian 2.614 meter di atas permukaan laut dan berada dalam empat wilayah kabupaten, yakni Kabupaten Probolinggo, Kabupaten Pasuruan, Kabupaten Lumajang, dan Kabupaten Malang. Gunung Bromo terkenal sebagai objek wisata utama di Jawa Timur. Sebagai sebuah objek wisata, Bromo menjadi menarik karena statusnya sebagai gunung berapi yang masih aktif. Gunung Bromo termasuk dalam kawasan Taman Nasional Bromo Tengger Semeru.\n" +
                    "\n" +
                    "Nama Bromo berasal dari nama dewa utama dalam agama Hindu, Brahma.\n" +
                    "\n" +
                    "Bentuk tubuh Gunung Bromo bertautan antara lembah dan ngarai dengan kaldera atau lautan pasir seluas sekitar 10 kilometer persegi, Ia mempunyai sebuah kawah dengan garis tengah ± 800 meter (utara-selatan) dan ± 600 meter (timur-barat). Sedangkan daerah bahayanya berupa lingkaran dengan jari-jari 4 km dari pusat kawah Bromo.",
            rating = 4.8,
            jumlahUlasan = 245,
            jamBuka = "06:00–17:00"
        ),
        Wisata(
            id = 5,
            nama = "Gunung Rinjani",
            lokasi = "Lombok",
            imageRes = R.drawable.rinjani,
            deskripsi = "Gunung Rinjani adalah gunung yang berlokasi di Pulau Lombok, Nusa Tenggara Barat. Gunung yang merupakan gunung berapi kedua tertinggi di Indonesia dengan ketinggian 3.726 mdpl serta terletak pada lintang 8º25' LS dan 116º28' BT ini merupakan gunung favorit bagi pendaki Indonesia karena keindahan pemandangannya. Gunung ini merupakan bagian dari Taman Nasional Gunung Rinjani yang memiliki luas sekitar 41.330 ha dan diusulkan penambahannya sehingga menjadi 76.000 ha ke arah barat dan timur.\n" +
                    "\n" +
                    "Gunung Rinjani merupakan penerus dari Gunung Samalas yang pernah meletus tahun 1257 pada masa Holosen di Indonesia, yang mengakibatkan penurunan suhu global, gagal panen dan hancurnya kerajaan pamatan di wilayah Pulau Lombok. Secara administratif gunung ini berada dalam wilayah tiga kabupaten: Lombok Timur, Lombok Tengah, dan Lombok Utara. Secara stratigrafi, Gunung Rinjani dialasi oleh batuan sedimen klastik Neogen (termasuk batu gamping), dan setempat oleh batuan gunung api Oligo-Miosen. Gunung api Kuarter itu sendiri sebagian besar menghasilkan piroklastik, yang dibeberapa tempat berselingan dengan lava. Litologi itu merekam sebagian letusan yang diketahui dalam sejarah. Sejak tahun 1847 telah terjadi 7 kali letusan, dengan jangka istirahat terpendek 1 tahun dan terpanjang 37 tahun.\n" +
                    "\n" +
                    "Seperti pada gunung api lainnya, Koesoemadinata (1979) menyebutkan bahwa aktivitas kegunungapian Rinjani pasca pembentukan kaldera adalah pembangunan kembali. Kegiatannya berupa efusiva yang menghasilkan lava dan eksplosiva yang membentuk endapan bahan-lepas (piroklastik). Lava umumnya berwarna hitam, dan ketika meleler tampak seperti berbusa. Peletusan pasca pembentukan kaldera relatif lemah, dan lava yang dikeluarkan oleh kerucut Gunung Barujari dan Gunung Rombongan relatif lebih basa dibanding lava gunung api lainnya di Indonesia. Kemungkinan terjadinya awan panas ketika letusan memuncak sangat kecil. Bahan letusan umumnya diendapkan di bagian dalam kaldera saja.\n" +
                    "\n" +
                    "Aliran lava, lahar letusan, lahar hujan, dan awan panas guguran berpeluang mengarah ke Kokok Putih hingga Batusantek. Awan panas guguran dapat terjadi di sepanjang leleran lava baru yang masih bergerak, meskipun kemungkinannya kecil.",
            rating = 4.8,
            jumlahUlasan = 245,
            jamBuka = "06:00–17:00"
        ),
        // Tambahkan wisata lain
    )

    /* ----- LIST PENGINAPAN PER PROVINSI ----- */
    val dataPerProvinsi = listOf(
        ProvinsiPenginapan(
            namaProvinsi = "Aceh",
            listPenginapan = listOf(
                Penginapan("Hotel Hermes Palace", "Banda Aceh", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Banda Aceh", "Banda Aceh", "Rp150.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Ulee Lheue", "Banda Aceh", "Rp200.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Bali",
            listPenginapan = listOf(
                Penginapan("Hotel Kuta Paradiso", "Kuta", "Rp1.000.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Ubud Backpacker", "Ubud", "Rp250.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Seminyak", "Seminyak", "Rp400.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Banten",
            listPenginapan = listOf(
                Penginapan("Hotel Marbella Anyer", "Anyer", "Rp550.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Serang", "Serang", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Cilegon", "Cilegon", "Rp220.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Bengkulu",
            listPenginapan = listOf(
                Penginapan("Hotel Raflesia", "Bengkulu", "Rp450.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Bengkulu City", "Bengkulu", "Rp150.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Pantai Panjang", "Bengkulu", "Rp200.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Yogyakarta",
            listPenginapan = listOf(
                Penginapan("Hotel Melia Purosani", "Yogyakarta", "Rp800.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Malioboro", "Yogyakarta", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Kota Gede", "Yogyakarta", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Jakarta",
            listPenginapan = listOf(
                Penginapan("Hotel Indonesia Kempinski", "Jakarta Pusat", "Rp1.200.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Jakarta Kota", "Jakarta Barat", "Rp250.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Menteng", "Jakarta Pusat", "Rp400.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Gorontalo",
            listPenginapan = listOf(
                Penginapan("Hotel Grand Q Gorontalo", "Gorontalo", "Rp500.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Limboto", "Gorontalo", "Rp150.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Pulau Saronde", "Gorontalo", "Rp220.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Jambi",
            listPenginapan = listOf(
                Penginapan("Hotel BW Luxury", "Jambi", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Kota Baru", "Jambi", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Danau Sipin", "Jambi", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Jawa Barat",
            listPenginapan = listOf(
                Penginapan("Hotel Savoy Homann", "Bandung", "Rp850.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Dago", "Bandung", "Rp220.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Lembang", "Bandung", "Rp350.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Jawa Tengah",
            listPenginapan = listOf(
                Penginapan("Hotel Tentrem", "Semarang", "Rp900.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Ungaran", "Semarang", "Rp200.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Borobudur", "Magelang", "Rp300.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Jawa Timur",
            listPenginapan = listOf(
                Penginapan("Hotel Majapahit", "Surabaya", "Rp950.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Malang", "Malang", "Rp250.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Bromo", "Probolinggo", "Rp350.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Kalimantan Barat",
            listPenginapan = listOf(
                Penginapan("Hotel Kapuas Palace", "Pontianak", "Rp700.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Pontianak", "Pontianak", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Sungai Raya", "Pontianak", "Rp220.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Kalimantan Selatan",
            listPenginapan = listOf(
                Penginapan("Hotel Rodhita", "Banjarmasin", "Rp650.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Banjarmasin", "Banjarmasin", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Martapura", "Martapura", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Kalimantan Tengah",
            listPenginapan = listOf(
                Penginapan("Hotel Luwansa", "Palangka Raya", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Palangka Raya", "Palangka Raya", "Rp160.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Tangkiling", "Palangka Raya", "Rp200.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Kalimantan Timur",
            listPenginapan = listOf(
                Penginapan("Hotel Bumi Senyiur", "Samarinda", "Rp700.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Samarinda", "Samarinda", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Tenggarong", "Kutai Kartanegara", "Rp230.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Kalimantan Utara",
            listPenginapan = listOf(
                Penginapan("Hotel Tarakan Plaza", "Tarakan", "Rp550.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Tarakan", "Tarakan", "Rp160.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Sebuku", "Tarakan", "Rp210.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Kepulauan Bangka Belitung",
            listPenginapan = listOf(
                Penginapan("Hotel Novotel Babel", "Pangkal Pinang", "Rp650.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Pangkal Pinang", "Pangkal Pinang", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Belitung", "Belitung", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Kepulauan Riau",
            listPenginapan = listOf(
                Penginapan("Hotel Turi Beach", "Batam", "Rp700.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Batam", "Batam", "Rp200.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Bintan", "Bintan", "Rp300.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Lampung",
            listPenginapan = listOf(
                Penginapan("Hotel Santika", "Bandar Lampung", "Rp450.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Metro", "Metro", "Rp200.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Pahawang", "Lampung", "Rp300.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Maluku",
            listPenginapan = listOf(
                Penginapan("Hotel Natsepa", "Ambon", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Ambon", "Ambon", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Banda", "Banda", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Maluku Utara",
            listPenginapan = listOf(
                Penginapan("Hotel Sofifi", "Sofifi", "Rp550.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Ternate", "Ternate", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Tidore", "Tidore", "Rp230.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Nanggroe Aceh Darussalam",
            listPenginapan = listOf(
                Penginapan("Hotel Hermes", "Banda Aceh", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Aceh Tengah", "Aceh Tengah", "Rp150.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Sabang", "Sabang", "Rp200.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Nusa Tenggara Barat",
            listPenginapan = listOf(
                Penginapan("Hotel Lombok Raya", "Mataram", "Rp650.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Gili Trawangan", "Lombok", "Rp250.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Senggigi", "Lombok", "Rp300.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Nusa Tenggara Timur",
            listPenginapan = listOf(
                Penginapan("Hotel Kupang", "Kupang", "Rp550.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Ende", "Ende", "Rp200.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Flores", "Flores", "Rp280.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Papua",
            listPenginapan = listOf(
                Penginapan("Hotel Horison", "Jayapura", "Rp700.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Jayapura", "Jayapura", "Rp200.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Raja Ampat", "Raja Ampat", "Rp350.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Papua Barat",
            listPenginapan = listOf(
                Penginapan("Hotel Manokwari", "Manokwari", "Rp650.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Sorong", "Sorong", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Raja Ampat", "Raja Ampat", "Rp350.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Riau",
            listPenginapan = listOf(
                Penginapan("Hotel Grand Jatra", "Pekanbaru", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Pekanbaru", "Pekanbaru", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Siak", "Siak", "Rp220.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Sulawesi Barat",
            listPenginapan = listOf(
                Penginapan("Hotel Mamasa", "Mamasa", "Rp500.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Mamuju", "Mamuju", "Rp150.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Polewali", "Polewali", "Rp200.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Sulawesi Selatan",
            listPenginapan = listOf(
                Penginapan("Hotel Claro Makassar", "Makassar", "Rp700.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Makassar", "Makassar", "Rp200.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Tana Toraja", "Tana Toraja", "Rp300.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Sulawesi Tengah",
            listPenginapan = listOf(
                Penginapan("Hotel Santika Palu", "Palu", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Palu", "Palu", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Lore Lindu", "Palu", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Sulawesi Tenggara",
            listPenginapan = listOf(
                Penginapan("Hotel Plaza Kendari", "Kendari", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Kendari", "Kendari", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Wakatobi", "Wakatobi", "Rp300.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Sumatera Barat",
            listPenginapan = listOf(
                Penginapan("Hotel Pangeran Beach", "Padang", "Rp650.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Padang", "Padang", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Bukittinggi", "Bukittinggi", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Sumatera Selatan",
            listPenginapan = listOf(
                Penginapan("Hotel Aryaduta", "Palembang", "Rp700.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Palembang", "Palembang", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Pagar Alam", "Pagar Alam", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Sumatera Utara",
            listPenginapan = listOf(
                Penginapan("Hotel Santika Premiere", "Medan", "Rp700.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Medan", "Medan", "Rp180.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Berastagi", "Berastagi", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        ),
        ProvinsiPenginapan(
            namaProvinsi = "Papua Pegunungan",
            listPenginapan = listOf(
                Penginapan("Hotel Wamena", "Wamena", "Rp600.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Hostel Wamena", "Wamena", "Rp150.000 / malam", R.drawable.ic_launcher_background),
                Penginapan("Homestay Baliem Valley", "Wamena", "Rp250.000 / malam", R.drawable.ic_launcher_background)
            )
        )
    )

    /* ---- helper ---- */
    fun getPenginapan(provinsi: String): List<Penginapan> =
        dataPerProvinsi
            .find { it.namaProvinsi.equals(provinsi, ignoreCase = true) }
            ?.listPenginapan
            ?: emptyList()
}