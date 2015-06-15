-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Lun 15 Juin 2015 à 12:20
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `puydufou`
--
CREATE DATABASE `puydufou` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `puydufou`;

-- --------------------------------------------------------

--
-- Structure de la table `menu_restaurant`
--

CREATE TABLE IF NOT EXISTS `menu_restaurant` (
  `id_menu` int(10) NOT NULL AUTO_INCREMENT,
  `id_service` int(10) NOT NULL,
  `menu` varchar(10) NOT NULL,
  `tarif` float NOT NULL,
  PRIMARY KEY (`id_menu`),
  KEY `id_service` (`id_service`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `id_spectacle` int(11) NOT NULL,
  `id_utilisateur` varchar(17) NOT NULL,
  `note` float NOT NULL,
  PRIMARY KEY (`id_spectacle`,`id_utilisateur`),
  KEY `id_utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE IF NOT EXISTS `planning` (
  `id_planning` int(10) NOT NULL AUTO_INCREMENT,
  `id_spectacle` int(10) NOT NULL,
  `jour_semaine` varchar(20) NOT NULL,
  `heure_debut` time NOT NULL,
  PRIMARY KEY (`id_planning`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `id_service` int(10) NOT NULL AUTO_INCREMENT,
  `type_service` int(2) NOT NULL,
  `nom_service` varchar(40) NOT NULL,
  `description_service` varchar(255) NOT NULL,
  `note_service` float NOT NULL,
  `position_latitude` float NOT NULL,
  `position_longitude` float NOT NULL,
  PRIMARY KEY (`id_service`),
  KEY `type_service` (`type_service`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `spectacle`
--

CREATE TABLE IF NOT EXISTS `spectacle` (
  `id_spectacle` int(10) NOT NULL AUTO_INCREMENT,
  `nom_spectacle` varchar(40) NOT NULL,
  `description_spectacle` varchar(255) NOT NULL,
  `nb_acteurs` int(10) NOT NULL,
  `duree` int(10) NOT NULL,
  `position_latitude` float NOT NULL,
  `position_longitude` float NOT NULL,
  `moyenne_note` float NOT NULL,
  `image` varchar(200) NOT NULL,
  PRIMARY KEY (`id_spectacle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `type_service`
--

CREATE TABLE IF NOT EXISTS `type_service` (
  `id_type` int(2) NOT NULL AUTO_INCREMENT,
  `libelle_type` varchar(40) NOT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` varchar(17) NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `menu_restaurant`
--
ALTER TABLE `menu_restaurant`
  ADD CONSTRAINT `menu_restaurant_ibfk_1` FOREIGN KEY (`id_service`) REFERENCES `service` (`id_service`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`id_spectacle`) REFERENCES `spectacle` (`id_spectacle`),
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Contraintes pour la table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `service_ibfk_1` FOREIGN KEY (`type_service`) REFERENCES `type_service` (`id_type`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
