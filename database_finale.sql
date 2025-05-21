-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 21, 2025 alle 09:56
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_finale`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `lost_items`
--

CREATE TABLE `lost_items` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `lost_date` date NOT NULL,
  `location` varchar(255) NOT NULL,
  `found` tinyint(1) DEFAULT NULL,
  `found_date` date DEFAULT NULL,
  `found_location` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `lost_items`
--

INSERT INTO `lost_items` (`id`, `name`, `description`, `lost_date`, `location`, `found`, `found_date`, `found_location`) VALUES
(1, 'Zaino nero', 'Zaino nero con laptop e libri all\'interno', '2025-05-15', 'Biblioteca universitaria', 0, NULL, NULL),
(2, 'Cellulare Samsung', 'Samsung Galaxy S22 con cover rossa', '2025-05-10', 'Aula B4 - Dipartimento Informatica', 1, '2025-05-11', 'Reception edificio principale'),
(3, 'Chiavi auto', 'Mazda CX-5 - portachiavi con logo Avengers', '2025-04-30', 'Parcheggio studenti', 0, NULL, NULL),
(4, 'Portafoglio marrone', 'Contiene documenti e carta di credito', '2025-05-01', 'Mensa universitaria', 1, '2025-05-02', 'Ufficio oggetti smarriti'),
(5, 'Occhiali da vista', 'Occhiali neri Ray-Ban', '2025-05-18', 'Aula studio edificio E', 0, NULL, NULL),
(6, 'Libro di matematica', 'Analisi Matematica II - Edizione Zanichelli', '2025-05-05', 'Biblioteca centrale', 1, '2025-05-06', 'Bancone accoglienza biblioteca');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
