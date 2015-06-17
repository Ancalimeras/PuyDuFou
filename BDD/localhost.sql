-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Mer 17 Juin 2015 à 15:51
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
-- Structure de la table `boutique`
--

CREATE TABLE IF NOT EXISTS `boutique` (
  `id_boutique` int(10) NOT NULL AUTO_INCREMENT,
  `nom_boutique` varchar(40) NOT NULL,
  `description_boutique` varchar(255) NOT NULL,
  `note_boutique` float NOT NULL,
  `position_latitude` float NOT NULL,
  `position_longitude` float NOT NULL,
  PRIMARY KEY (`id_boutique`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `boutique`
--

INSERT INTO `boutique` (`id_boutique`, `nom_boutique`, `description_boutique`, `note_boutique`, `position_latitude`, `position_longitude`) VALUES
(1, 'Souvenir', 'Boutique de souvenir exceptionnelle.', 4, 0, 0),
(2, 'Bricole', 'Boutique pour les bricoleurs.', 3, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `menu_restaurant`
--

CREATE TABLE IF NOT EXISTS `menu_restaurant` (
  `id_menu` int(10) NOT NULL AUTO_INCREMENT,
  `id_restaurant` int(10) NOT NULL,
  `menu` varchar(50) NOT NULL,
  `description_menu` varchar(255) NOT NULL,
  `tarif` float NOT NULL,
  PRIMARY KEY (`id_menu`),
  KEY `id_service` (`id_restaurant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `menu_restaurant`
--

INSERT INTO `menu_restaurant` (`id_menu`, `id_restaurant`, `menu`, `description_menu`, `tarif`) VALUES
(2, 2, 'MENU JEUNES CONVIVES (Menu enfant jusqu''à 13ans)', 'Rosace de saumon fumé, Brochette de volaille marinée thym citron, pommes de terre de Noirmoutier, Profiteroles revisitées, sauce chocolat (crème glacée chocolat, vanille, fraises avec morceaux), Jus d’Orange (25 cl)', 18),
(3, 2, 'MENU DILIGENCE (menu adulte)', 'Foie gras de canard confit au piment d’Espelette, Dos de saumon, jus vert de roquette, tomates farcies aux légumes, pommes de terre fondantes aux girolles et fèves\nAllumette croustillant caramel', 39),
(4, 3, 'MENU ENFANT', 'Salade de tomates, oeuf dur façon mimosa, Croustillants de poulet, frites, Coupe gourmande glace vanille, sauce chocolat, Boisson enfant : Volvic au jus de pomme (33 cl)', 12.9),
(5, 3, 'MENU ADULTE', 'Frisée aux lardons et croûtons, Cuisse de canard confite, sauce échalotes, pommes de terre de Noirmoutier, Éclair', 24),
(6, 4, 'DEJEUNER ADULTE', 'Salade tomates roquette, Penne ou risotto avec 2 garnitures au choix, Panacotta, coulis de fruits', 20),
(7, 4, 'DEJEUNER ENFANT', 'Salade tomates mozzarella, Penne bolognaise ou croustillant de poulet et tagliatelles, Coupe gourmande glace vanille, sauce chocolat, Boisson enfant : Volvic au jus de pomme (33 cl)', 12.9);

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

--
-- Contenu de la table `note`
--

INSERT INTO `note` (`id_spectacle`, `id_utilisateur`, `note`) VALUES
(1, '00:00:00:00:00:0A', 2),
(1, '00:00:00:00:00:0B', 3),
(1, '00:00:00:00:00:0C', 5),
(2, '00:00:00:00:00:0A', 3),
(3, '00:00:00:00:00:0A', 4),
(4, '00:00:00:00:00:0A', 3),
(4, '00:00:00:00:00:0B', 3);

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE IF NOT EXISTS `planning` (
  `id_planning` int(10) NOT NULL AUTO_INCREMENT,
  `id_spectacle` int(10) NOT NULL,
  `jour_semaine` varchar(20) NOT NULL,
  `heure_debut` time NOT NULL,
  PRIMARY KEY (`id_planning`),
  KEY `id_spectacle` (`id_spectacle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=757 ;

--
-- Contenu de la table `planning`
--

INSERT INTO `planning` (`id_planning`, `id_spectacle`, `jour_semaine`, `heure_debut`) VALUES
(1, 1, 'mardi', '14:00:00'),
(2, 1, 'mardi', '17:00:00'),
(3, 2, 'mardi', '11:30:00'),
(4, 2, 'mardi', '13:00:00'),
(5, 2, 'mardi', '16:00:00'),
(6, 2, 'mardi', '19:30:00'),
(7, 3, 'mardi', '11:45:00'),
(8, 3, 'mardi', '14:15:00'),
(9, 3, 'mardi', '16:15:00'),
(10, 3, 'mardi', '18:15:00'),
(11, 4, 'mardi', '10:45:00'),
(12, 4, 'mardi', '13:15:00'),
(13, 4, 'mardi', '15:15:00'),
(14, 4, 'mardi', '16:45:00'),
(15, 5, 'mardi', '10:30:00'),
(16, 5, 'mardi', '12:15:00'),
(17, 5, 'mardi', '15:15:00'),
(18, 5, 'mardi', '17:00:00'),
(19, 6, 'mardi', '22:00:00'),
(20, 7, 'mardi', '11:30:00'),
(21, 7, 'mardi', '12:30:00'),
(22, 7, 'mardi', '15:00:00'),
(23, 7, 'mardi', '17:00:00'),
(24, 7, 'mardi', '19:00:00'),
(25, 7, 'mardi', '20:45:00'),
(26, 8, 'mardi', '12:00:00'),
(27, 8, 'mardi', '13:00:00'),
(28, 8, 'mardi', '14:00:00'),
(29, 8, 'mardi', '15:00:00'),
(30, 8, 'mardi', '16:00:00'),
(31, 8, 'mardi', '17:00:00'),
(32, 8, 'mardi', '18:00:00'),
(33, 8, 'mardi', '19:00:00'),
(34, 8, 'mardi', '20:00:00'),
(35, 9, 'mardi', '09:45:00'),
(36, 9, 'mardi', '10:15:00'),
(37, 9, 'mardi', '11:45:00'),
(38, 9, 'mardi', '12:30:00'),
(39, 9, 'mardi', '14:30:00'),
(40, 9, 'mardi', '16:00:00'),
(41, 9, 'mardi', '17:45:00'),
(42, 9, 'mardi', '18:15:00'),
(43, 9, 'mardi', '18:45:00'),
(44, 9, 'mardi', '19:15:00'),
(45, 9, 'mardi', '19:45:00'),
(46, 9, 'mardi', '20:30:00'),
(47, 9, 'mardi', '21:00:00'),
(48, 10, 'mardi', '11:30:00'),
(49, 10, 'mardi', '14:15:00'),
(50, 10, 'mardi', '15:15:00'),
(51, 10, 'mardi', '16:00:00'),
(52, 10, 'mardi', '17:00:00'),
(53, 10, 'mardi', '18:00:00'),
(54, 10, 'mardi', '19:30:00'),
(55, 11, 'mardi', '13:00:00'),
(56, 11, 'mardi', '15:00:00'),
(57, 11, 'mardi', '18:15:00'),
(58, 11, 'mardi', '18:45:00'),
(59, 12, 'mardi', '12:30:00'),
(60, 12, 'mardi', '16:00:00'),
(61, 12, 'mardi', '18:15:00'),
(62, 12, 'mardi', '19:00:00'),
(63, 12, 'mardi', '20:15:00'),
(64, 1, 'lundi', '14:00:00'),
(65, 1, 'lundi', '17:00:00'),
(66, 2, 'lundi', '11:30:00'),
(67, 2, 'lundi', '13:00:00'),
(68, 2, 'lundi', '16:00:00'),
(69, 2, 'lundi', '19:30:00'),
(70, 3, 'lundi', '11:45:00'),
(71, 3, 'lundi', '14:15:00'),
(72, 3, 'lundi', '16:15:00'),
(73, 3, 'lundi', '18:15:00'),
(74, 4, 'lundi', '10:45:00'),
(75, 4, 'lundi', '13:15:00'),
(76, 4, 'lundi', '15:15:00'),
(77, 4, 'lundi', '16:45:00'),
(78, 5, 'lundi', '10:30:00'),
(79, 5, 'lundi', '12:15:00'),
(80, 5, 'lundi', '15:15:00'),
(81, 5, 'lundi', '17:00:00'),
(82, 6, 'lundi', '22:00:00'),
(83, 7, 'lundi', '11:30:00'),
(84, 7, 'lundi', '12:30:00'),
(85, 7, 'lundi', '15:00:00'),
(86, 7, 'lundi', '17:00:00'),
(87, 7, 'lundi', '19:00:00'),
(88, 7, 'lundi', '20:45:00'),
(89, 8, 'lundi', '12:00:00'),
(90, 8, 'lundi', '13:00:00'),
(91, 8, 'lundi', '14:00:00'),
(92, 8, 'lundi', '15:00:00'),
(93, 8, 'lundi', '16:00:00'),
(94, 8, 'lundi', '17:00:00'),
(95, 8, 'lundi', '18:00:00'),
(96, 8, 'lundi', '19:00:00'),
(97, 8, 'lundi', '20:00:00'),
(98, 9, 'lundi', '09:45:00'),
(99, 9, 'lundi', '10:15:00'),
(100, 9, 'lundi', '11:45:00'),
(101, 9, 'lundi', '12:30:00'),
(102, 9, 'lundi', '14:30:00'),
(103, 9, 'lundi', '16:00:00'),
(104, 9, 'lundi', '17:45:00'),
(105, 9, 'lundi', '18:15:00'),
(106, 9, 'lundi', '18:45:00'),
(107, 9, 'lundi', '19:15:00'),
(108, 9, 'lundi', '19:45:00'),
(109, 9, 'lundi', '20:30:00'),
(110, 9, 'lundi', '21:00:00'),
(111, 10, 'lundi', '11:30:00'),
(112, 10, 'lundi', '14:15:00'),
(113, 10, 'lundi', '15:15:00'),
(114, 10, 'lundi', '16:00:00'),
(115, 10, 'lundi', '17:00:00'),
(116, 10, 'lundi', '18:00:00'),
(117, 10, 'lundi', '19:30:00'),
(118, 11, 'lundi', '13:00:00'),
(119, 11, 'lundi', '15:00:00'),
(120, 11, 'lundi', '18:15:00'),
(121, 11, 'lundi', '18:45:00'),
(122, 12, 'lundi', '12:30:00'),
(123, 12, 'lundi', '16:00:00'),
(124, 12, 'lundi', '18:15:00'),
(125, 12, 'lundi', '19:00:00'),
(126, 12, 'lundi', '20:15:00'),
(127, 1, 'mercredi', '14:00:00'),
(128, 1, 'mercredi', '17:00:00'),
(129, 2, 'mercredi', '11:30:00'),
(130, 2, 'mercredi', '13:00:00'),
(131, 2, 'mercredi', '16:00:00'),
(132, 2, 'mercredi', '19:30:00'),
(133, 3, 'mercredi', '11:45:00'),
(134, 3, 'mercredi', '14:15:00'),
(135, 3, 'mercredi', '16:15:00'),
(136, 3, 'mercredi', '18:15:00'),
(137, 4, 'mercredi', '10:45:00'),
(138, 4, 'mercredi', '13:15:00'),
(139, 4, 'mercredi', '15:15:00'),
(140, 4, 'mercredi', '16:45:00'),
(141, 5, 'mercredi', '10:30:00'),
(142, 5, 'mercredi', '12:15:00'),
(143, 5, 'mercredi', '15:15:00'),
(144, 5, 'mercredi', '17:00:00'),
(145, 6, 'mercredi', '22:00:00'),
(146, 7, 'mercredi', '11:30:00'),
(147, 7, 'mercredi', '12:30:00'),
(148, 7, 'mercredi', '15:00:00'),
(149, 7, 'mercredi', '17:00:00'),
(150, 7, 'mercredi', '19:00:00'),
(151, 7, 'mercredi', '20:45:00'),
(152, 8, 'mercredi', '12:00:00'),
(153, 8, 'mercredi', '13:00:00'),
(154, 8, 'mercredi', '14:00:00'),
(155, 8, 'mercredi', '15:00:00'),
(156, 8, 'mercredi', '16:00:00'),
(157, 8, 'mercredi', '17:00:00'),
(158, 8, 'mercredi', '18:00:00'),
(159, 8, 'mercredi', '19:00:00'),
(160, 8, 'mercredi', '20:00:00'),
(161, 9, 'mercredi', '09:45:00'),
(162, 9, 'mercredi', '10:15:00'),
(163, 9, 'mercredi', '11:45:00'),
(164, 9, 'mercredi', '12:30:00'),
(165, 9, 'mercredi', '14:30:00'),
(166, 9, 'mercredi', '16:00:00'),
(167, 9, 'mercredi', '17:45:00'),
(168, 9, 'mercredi', '18:15:00'),
(169, 9, 'mercredi', '18:45:00'),
(170, 9, 'mercredi', '19:15:00'),
(171, 9, 'mercredi', '19:45:00'),
(172, 9, 'mercredi', '20:30:00'),
(173, 9, 'mercredi', '21:00:00'),
(174, 10, 'mercredi', '11:30:00'),
(175, 10, 'mercredi', '14:15:00'),
(176, 10, 'mercredi', '15:15:00'),
(177, 10, 'mercredi', '16:00:00'),
(178, 10, 'mercredi', '17:00:00'),
(179, 10, 'mercredi', '18:00:00'),
(180, 10, 'mercredi', '19:30:00'),
(181, 11, 'mercredi', '13:00:00'),
(182, 11, 'mercredi', '15:00:00'),
(183, 11, 'mercredi', '18:15:00'),
(184, 11, 'mercredi', '18:45:00'),
(185, 12, 'mercredi', '12:30:00'),
(186, 12, 'mercredi', '16:00:00'),
(187, 12, 'mercredi', '18:15:00'),
(188, 12, 'mercredi', '19:00:00'),
(189, 12, 'mercredi', '20:15:00'),
(190, 1, 'jeudi', '14:00:00'),
(191, 1, 'jeudi', '17:00:00'),
(192, 2, 'jeudi', '11:30:00'),
(193, 2, 'jeudi', '13:00:00'),
(194, 2, 'jeudi', '16:00:00'),
(195, 2, 'jeudi', '19:30:00'),
(196, 3, 'jeudi', '11:45:00'),
(197, 3, 'jeudi', '14:15:00'),
(198, 3, 'jeudi', '16:15:00'),
(199, 3, 'jeudi', '18:15:00'),
(200, 4, 'jeudi', '10:45:00'),
(201, 4, 'jeudi', '13:15:00'),
(202, 4, 'jeudi', '15:15:00'),
(203, 4, 'jeudi', '16:45:00'),
(204, 5, 'jeudi', '10:30:00'),
(205, 5, 'jeudi', '12:15:00'),
(206, 5, 'jeudi', '15:15:00'),
(207, 5, 'jeudi', '17:00:00'),
(208, 6, 'jeudi', '22:00:00'),
(209, 7, 'jeudi', '11:30:00'),
(210, 7, 'jeudi', '12:30:00'),
(211, 7, 'jeudi', '15:00:00'),
(212, 7, 'jeudi', '17:00:00'),
(213, 7, 'jeudi', '19:00:00'),
(214, 7, 'jeudi', '20:45:00'),
(215, 8, 'jeudi', '12:00:00'),
(216, 8, 'jeudi', '13:00:00'),
(217, 8, 'jeudi', '14:00:00'),
(218, 8, 'jeudi', '15:00:00'),
(219, 8, 'jeudi', '16:00:00'),
(220, 8, 'jeudi', '17:00:00'),
(221, 8, 'jeudi', '18:00:00'),
(222, 8, 'jeudi', '19:00:00'),
(223, 8, 'jeudi', '20:00:00'),
(224, 9, 'jeudi', '09:45:00'),
(225, 9, 'jeudi', '10:15:00'),
(226, 9, 'jeudi', '11:45:00'),
(227, 9, 'jeudi', '12:30:00'),
(228, 9, 'jeudi', '14:30:00'),
(229, 9, 'jeudi', '16:00:00'),
(230, 9, 'jeudi', '17:45:00'),
(231, 9, 'jeudi', '18:15:00'),
(232, 9, 'jeudi', '18:45:00'),
(233, 9, 'jeudi', '19:15:00'),
(234, 9, 'jeudi', '19:45:00'),
(235, 9, 'jeudi', '20:30:00'),
(236, 9, 'jeudi', '21:00:00'),
(237, 10, 'jeudi', '11:30:00'),
(238, 10, 'jeudi', '14:15:00'),
(239, 10, 'jeudi', '15:15:00'),
(240, 10, 'jeudi', '16:00:00'),
(241, 10, 'jeudi', '17:00:00'),
(242, 10, 'jeudi', '18:00:00'),
(243, 10, 'jeudi', '19:30:00'),
(244, 11, 'jeudi', '13:00:00'),
(245, 11, 'jeudi', '15:00:00'),
(246, 11, 'jeudi', '18:15:00'),
(247, 11, 'jeudi', '18:45:00'),
(248, 12, 'jeudi', '12:30:00'),
(249, 12, 'jeudi', '16:00:00'),
(250, 12, 'jeudi', '18:15:00'),
(251, 12, 'jeudi', '19:00:00'),
(252, 12, 'jeudi', '20:15:00'),
(253, 1, 'vendredi', '14:00:00'),
(254, 1, 'vendredi', '17:00:00'),
(255, 2, 'vendredi', '11:30:00'),
(256, 2, 'vendredi', '13:00:00'),
(257, 2, 'vendredi', '16:00:00'),
(258, 2, 'vendredi', '19:30:00'),
(259, 3, 'vendredi', '11:45:00'),
(260, 3, 'vendredi', '14:15:00'),
(261, 3, 'vendredi', '16:15:00'),
(262, 3, 'vendredi', '18:15:00'),
(263, 4, 'vendredi', '10:45:00'),
(264, 4, 'vendredi', '13:15:00'),
(265, 4, 'vendredi', '15:15:00'),
(266, 4, 'vendredi', '16:45:00'),
(267, 5, 'vendredi', '10:30:00'),
(268, 5, 'vendredi', '12:15:00'),
(269, 5, 'vendredi', '15:15:00'),
(270, 5, 'vendredi', '17:00:00'),
(271, 6, 'vendredi', '22:00:00'),
(272, 7, 'vendredi', '11:30:00'),
(273, 7, 'vendredi', '12:30:00'),
(274, 7, 'vendredi', '15:00:00'),
(275, 7, 'vendredi', '17:00:00'),
(276, 7, 'vendredi', '19:00:00'),
(277, 7, 'vendredi', '20:45:00'),
(278, 8, 'vendredi', '12:00:00'),
(279, 8, 'vendredi', '13:00:00'),
(280, 8, 'vendredi', '14:00:00'),
(281, 8, 'vendredi', '15:00:00'),
(282, 8, 'vendredi', '16:00:00'),
(283, 8, 'vendredi', '17:00:00'),
(284, 8, 'vendredi', '18:00:00'),
(285, 8, 'vendredi', '19:00:00'),
(286, 8, 'vendredi', '20:00:00'),
(287, 9, 'vendredi', '09:45:00'),
(288, 9, 'vendredi', '10:15:00'),
(289, 9, 'vendredi', '11:45:00'),
(290, 9, 'vendredi', '12:30:00'),
(291, 9, 'vendredi', '14:30:00'),
(292, 9, 'vendredi', '16:00:00'),
(293, 9, 'vendredi', '17:45:00'),
(294, 9, 'vendredi', '18:15:00'),
(295, 9, 'vendredi', '18:45:00'),
(296, 9, 'vendredi', '19:15:00'),
(297, 9, 'vendredi', '19:45:00'),
(298, 9, 'vendredi', '20:30:00'),
(299, 9, 'vendredi', '21:00:00'),
(300, 10, 'vendredi', '11:30:00'),
(301, 10, 'vendredi', '14:15:00'),
(302, 10, 'vendredi', '15:15:00'),
(303, 10, 'vendredi', '16:00:00'),
(304, 10, 'vendredi', '17:00:00'),
(305, 10, 'vendredi', '18:00:00'),
(306, 10, 'vendredi', '19:30:00'),
(307, 11, 'vendredi', '13:00:00'),
(308, 11, 'vendredi', '15:00:00'),
(309, 11, 'vendredi', '18:15:00'),
(310, 11, 'vendredi', '18:45:00'),
(311, 12, 'vendredi', '12:30:00'),
(312, 12, 'vendredi', '16:00:00'),
(313, 12, 'vendredi', '18:15:00'),
(314, 12, 'vendredi', '19:00:00'),
(315, 12, 'vendredi', '20:15:00'),
(316, 1, 'samedi', '14:00:00'),
(317, 1, 'samedi', '17:00:00'),
(318, 2, 'samedi', '11:30:00'),
(319, 2, 'samedi', '13:00:00'),
(320, 2, 'samedi', '16:00:00'),
(321, 2, 'samedi', '19:30:00'),
(322, 3, 'samedi', '11:45:00'),
(323, 3, 'samedi', '14:15:00'),
(324, 3, 'samedi', '16:15:00'),
(325, 3, 'samedi', '18:15:00'),
(326, 4, 'samedi', '10:45:00'),
(327, 4, 'samedi', '13:15:00'),
(328, 4, 'samedi', '15:15:00'),
(329, 4, 'samedi', '16:45:00'),
(330, 5, 'samedi', '10:30:00'),
(331, 5, 'samedi', '12:15:00'),
(332, 5, 'samedi', '15:15:00'),
(333, 5, 'samedi', '17:00:00'),
(334, 6, 'samedi', '22:00:00'),
(335, 7, 'samedi', '11:30:00'),
(336, 7, 'samedi', '12:30:00'),
(337, 7, 'samedi', '15:00:00'),
(338, 7, 'samedi', '17:00:00'),
(339, 7, 'samedi', '19:00:00'),
(340, 7, 'samedi', '20:45:00'),
(341, 8, 'samedi', '12:00:00'),
(342, 8, 'samedi', '13:00:00'),
(343, 8, 'samedi', '14:00:00'),
(344, 8, 'samedi', '15:00:00'),
(345, 8, 'samedi', '16:00:00'),
(346, 8, 'samedi', '17:00:00'),
(347, 8, 'samedi', '18:00:00'),
(348, 8, 'samedi', '19:00:00'),
(349, 8, 'samedi', '20:00:00'),
(350, 9, 'samedi', '09:45:00'),
(351, 9, 'samedi', '10:15:00'),
(352, 9, 'samedi', '11:45:00'),
(353, 9, 'samedi', '12:30:00'),
(354, 9, 'samedi', '14:30:00'),
(355, 9, 'samedi', '16:00:00'),
(356, 9, 'samedi', '17:45:00'),
(357, 9, 'samedi', '18:15:00'),
(358, 9, 'samedi', '18:45:00'),
(359, 9, 'samedi', '19:15:00'),
(360, 9, 'samedi', '19:45:00'),
(361, 9, 'samedi', '20:30:00'),
(362, 9, 'samedi', '21:00:00'),
(363, 10, 'samedi', '11:30:00'),
(364, 10, 'samedi', '14:15:00'),
(365, 10, 'samedi', '15:15:00'),
(366, 10, 'samedi', '16:00:00'),
(367, 10, 'samedi', '17:00:00'),
(368, 10, 'samedi', '18:00:00'),
(369, 10, 'samedi', '19:30:00'),
(370, 11, 'samedi', '13:00:00'),
(371, 11, 'samedi', '15:00:00'),
(372, 11, 'samedi', '18:15:00'),
(373, 11, 'samedi', '18:45:00'),
(374, 12, 'samedi', '12:30:00'),
(375, 12, 'samedi', '16:00:00'),
(376, 12, 'samedi', '18:15:00'),
(377, 12, 'samedi', '19:00:00'),
(378, 12, 'samedi', '20:15:00'),
(379, 1, 'jeudi', '17:00:00'),
(380, 1, 'mardi', '17:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `restaurant`
--

CREATE TABLE IF NOT EXISTS `restaurant` (
  `id_restaurant` int(10) NOT NULL AUTO_INCREMENT,
  `nom_restaurant` varchar(40) NOT NULL,
  `description_restaurant` varchar(255) NOT NULL,
  `note_restaurant` float NOT NULL,
  `position_latitude` float NOT NULL,
  `position_longitude` float NOT NULL,
  PRIMARY KEY (`id_restaurant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `restaurant`
--

INSERT INTO `restaurant` (`id_restaurant`, `nom_restaurant`, `description_restaurant`, `note_restaurant`, `position_latitude`, `position_longitude`) VALUES
(2, 'L''Auberge', 'Au cœur du Village XVIIIème, profitez d''un repas classique dans le calme et le prestige de ce restaurant unique au Grand Parc.', 2.5, 0, 0),
(3, 'Le Bistrot', 'Dans le décor du Bourg 1900, cette véritable brasserie de la Belle Époque vous invite à redécouvrir une cuisine traditionnelle.', 2.5, 0, 0),
(4, 'L''Atrium', 'Revivez les fastes de l''Empire Romain dans le restaurant de la "Villa Gallo-Romaine".', 2.5, 0, 0),
(5, 'Les Deux Couronnes', 'Autour du grand brasero du palais du "Camp du Drap d''Or", partagez à volonté les grillades préférées du roi François Ier.', 2.5, 0, 0),
(6, 'Le Banquet de Mérovée', 'Situé dans les "Îles de Clovis", ce restaurant vous donne rendez-vous autour du vase de Soisson avec son grand buffet à volonté.', 2.5, 0, 0),
(7, 'L''Orangerie', 'A deux pas du Grand Carrousel et du Bourg 1900, profitez d''un grand buffet froid à volonté pour vous restaurer entre deux spectacles.', 2.5, 0, 0),
(8, 'La Taverne', 'Au cœur de la Cité Médiévale, accordez-vous une pause gourmande à la Taverne.', 2.5, 0, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `spectacle`
--

INSERT INTO `spectacle` (`id_spectacle`, `nom_spectacle`, `description_spectacle`, `nb_acteurs`, `duree`, `position_latitude`, `position_longitude`, `moyenne_note`, `image`) VALUES
(1, 'Le signe du triomphe', 'Vivez la fureur des jeux du cirque !  Pour sauver leur vie, des prisonniers gaulois sont condamnés à remporter les Jeux du Cirque sous les yeux du gouverneur romain. Vous êtes prêts ? Installez-vous dans les tribunes du Stadium Gallo-Romain et laissez vou', 8, 45, 0, 0, 3.33333, 'plan_signe'),
(2, 'Les vikings', 'Surgissant de leurs drakkars au milieu des flammes gigantesques, les féroces vikings attaquent le paisible Fort de l''An Mil aux toits de chaume. Au pied d''une tour de 22 mètres, le combat fait rage dans un déluge d''effets spéciaux.', 8, 28, 0, 0, 2.5, 'plan_vikings'),
(3, 'Le bal des oiseaux fantômes', 'Aliénor se réveille dans les ruines du vieux château et ses souvenirs font surgir les faucons, les hiboux et les vautours qui vous frôlent de leurs ailes géantes.Vous n''oublierez jamais le grand ballet des milans, pélicans, cigognes et marabouts... un spe', 2, 33, 0, 0, 2.5, 'plan_bof'),
(4, 'Le secret de la lance', 'Après le départ des chevaliers pour Orléans, Marguerite, une jeune bergère, reste seule au château. Elle va devoir découvrir le secret d''une lance aux pouvoirs fantastiques pour protéger les remparts enchantés du château en pleine bataille.', 8, 28, 0, 0, 3, 'plan_lance'),
(5, 'Mousquetaire de Richelieu', 'Sur les planches d''un théâtre monumental du XVIIème siècle, les mousquetaires vous emportent dans un spectacle de cape et d''épée où l''émerveillement est permanent.', 6, 36, 0, 0, 2.5, 'plan_mousquetaires'),
(6, 'Les orgues de feu', 'Chaque soir, sur le vieil étang du Puy du Fou, les musiciens romantiques apparaissent dans leurs costumes de lumières et font danser muses et farfadets dans une symphonie fantastique d''eau et de feu.', 0, 30, 0, 0, 2.5, 'plan_orgues'),
(7, 'Les chevaliers de la table ronde', 'Au pied des remparts, Merlin met le courage d’Arthur à l’épreuve. Après avoir vaincu le sortilège d’Excalibur, Arthur découvre les prodiges du lac enchanteur? !', 4, 18, 0, 0, 2.5, 'plan_tableronde'),
(8, 'L''Odyssée du Puy du Fou', 'Vous traverserez les siècles de la Rome Antique à la Révolution Française.', 1, 18, 0, 0, 2.5, 'plan_odyssee'),
(9, 'Les automates musiciens', 'Au Bourg 1900, les "Avis à la population" du garde champêtre sont souvent interrompus par l''apparition des automates musiciens aux balcons.', 1, 7, 0, 0, 2.5, 'plan_automates'),
(10, 'Les musiciens traditionnels', 'Les musiciens traditionnels vous invitent à la danse.', 2, 20, 0, 0, 2.5, 'plan_musiciens'),
(11, 'Les Grands Eaux', 'Grand spectacle, grande musique, laissez-vous porter par cet orchestre d''eau.', 0, 8, 0, 0, 2.5, 'plan_grandeseaux'),
(12, 'La légende de Martin', 'Les marionnettes de la Légende de Martin entraînent les enfants à la poursuite de la malbête, un monstre férocement drôle.', 1, 15, 0, 0, 2.5, 'plan_martin');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` varchar(17) NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`) VALUES
('00:00:00:00:00:01'),
('00:00:00:00:00:0A'),
('00:00:00:00:00:0B'),
('00:00:00:00:00:0C'),
('10:68:3f:4f:30:01'),
('10:A5:D0:46:4B:A4'),
('b4:ce:f6:08:b8:fc');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `menu_restaurant`
--
ALTER TABLE `menu_restaurant`
  ADD CONSTRAINT `menu_restaurant_ibfk_1` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurant` (`id_restaurant`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`id_spectacle`) REFERENCES `spectacle` (`id_spectacle`),
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `planning_ibfk_1` FOREIGN KEY (`id_spectacle`) REFERENCES `spectacle` (`id_spectacle`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
