-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 28 mai 2023 à 15:47
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `students`
--

-- --------------------------------------------------------

--
-- Structure de la table `students`
--

CREATE TABLE `students` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `CNE` varchar(20) NOT NULL,
  `note` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `students`
--

INSERT INTO `students` (`nom`, `prenom`, `CNE`, `note`, `tel`, `email`) VALUES
('Guendoula', 'Nour-El Houda', 'GI6688', '20', '0680740556', 'nourguendoula@gmail.com'),
('Imani', 'Fadi', 'HDDJ', '20', '07363672', 'fadi@gmail.com'),
('EL Fekak', 'Salma', 'HSSKD', '20', '06382733', 'salma@gmail.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`CNE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
