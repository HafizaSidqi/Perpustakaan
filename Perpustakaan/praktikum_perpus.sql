-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Apr 2020 pada 02.35
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `praktikum_perpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `nim` int(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jk` varchar(10) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `kelas` varchar(3) NOT NULL,
  `tgl_daftar` date NOT NULL,
  `berlaku_hg` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`nim`, `nama`, `tgl_lahir`, `jk`, `agama`, `kelas`, `tgl_daftar`, `berlaku_hg`) VALUES
(123180004, 'Fred', '2000-10-21', ' Laki=laki', 'Kristen', 'E', '2019-12-12', '2020-02-12'),
(123180130, 'Hafiza Sidqi', '2000-10-27', 'perempuan', 'Islam', 'C', '2020-04-01', '2020-04-30');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `kdbuku` int(11) NOT NULL,
  `nmbuku` varchar(50) NOT NULL,
  `nmpengarang` varchar(50) NOT NULL,
  `nmpenerbit` varchar(50) NOT NULL,
  `thnterbit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`kdbuku`, `nmbuku`, `nmpengarang`, `nmpenerbit`, `thnterbit`) VALUES
(1, 'Miiko', 'Eriko', 'MnC', 2012),
(7, 'Kindaichi', 'Key', 'ElexM', 2020),
(10, 'Khadijah', 'Sibel', 'Kaysa', 2015);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE `jabatan` (
  `golongan` int(11) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `tunjangan` int(11) NOT NULL,
  `jmlgaji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`golongan`, `jabatan`, `tunjangan`, `jmlgaji`) VALUES
(1, 'Manager', 500000, 1000000),
(2, 'Staff', 200000, 800000),
(3, 'magang', 100000, 500000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `nik` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` varchar(10) NOT NULL,
  `golongan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`nik`, `nama`, `jk`, `golongan`) VALUES
(253, 'faiz', 'laki-laki', 1),
(897, 'Ima', ' Perempuan', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pinjam`
--

CREATE TABLE `pinjam` (
  `nmrpinjam` int(11) NOT NULL,
  `nim` int(11) NOT NULL,
  `kdbuku` int(11) NOT NULL,
  `tglpinjam` date NOT NULL,
  `tglkembali` date NOT NULL,
  `nik` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pinjam`
--

INSERT INTO `pinjam` (`nmrpinjam`, `nim`, `kdbuku`, `tglpinjam`, `tglkembali`, `nik`) VALUES
(1, 123180130, 1, '2020-04-01', '2020-04-14', 897);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`nim`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kdbuku`);

--
-- Indeks untuk tabel `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`golongan`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nik`),
  ADD KEY `fkgolongan` (`golongan`);

--
-- Indeks untuk tabel `pinjam`
--
ALTER TABLE `pinjam`
  ADD PRIMARY KEY (`nmrpinjam`),
  ADD KEY `fknim` (`nim`),
  ADD KEY `fkkdbuku` (`kdbuku`),
  ADD KEY `fknik` (`nik`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `fkgolongan` FOREIGN KEY (`golongan`) REFERENCES `jabatan` (`golongan`);

--
-- Ketidakleluasaan untuk tabel `pinjam`
--
ALTER TABLE `pinjam`
  ADD CONSTRAINT `fkkdbuku` FOREIGN KEY (`kdbuku`) REFERENCES `buku` (`kdbuku`),
  ADD CONSTRAINT `fknik` FOREIGN KEY (`nik`) REFERENCES `karyawan` (`nik`),
  ADD CONSTRAINT `fknim` FOREIGN KEY (`nim`) REFERENCES `anggota` (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
