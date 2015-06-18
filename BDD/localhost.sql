-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Jeu 18 Juin 2015 à 12:35
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `puydufou`
--
CREATE DATABASE IF NOT EXISTS `puydufou` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
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
(1, '10:68:3f:4f:30:01', 2),
(2, '00:00:00:00:00:0A', 3),
(2, '00:00:00:00:00:0B', 5),
(3, '00:00:00:00:00:0A', 4),
(3, '10:A5:D0:46:4B:A4', 4),
(4, '00:00:00:00:00:0A', 3),
(4, '00:00:00:00:00:0B', 3),
(9, '10:A5:D0:46:4B:A4', 5);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1135 ;

--
-- Contenu de la table `planning`
--

INSERT INTO `planning` (`id_planning`, `id_spectacle`, `jour_semaine`, `heure_debut`) VALUES
(757, 1, 'mardi', '14:00:00'),
(758, 1, 'mardi', '17:00:00'),
(759, 2, 'mardi', '11:30:00'),
(760, 2, 'mardi', '13:00:00'),
(761, 2, 'mardi', '16:00:00'),
(762, 2, 'mardi', '19:30:00'),
(763, 3, 'mardi', '11:45:00'),
(764, 3, 'mardi', '14:15:00'),
(765, 3, 'mardi', '16:15:00'),
(766, 3, 'mardi', '18:15:00'),
(767, 4, 'mardi', '10:45:00'),
(768, 4, 'mardi', '13:15:00'),
(769, 4, 'mardi', '15:15:00'),
(770, 4, 'mardi', '16:45:00'),
(771, 5, 'mardi', '10:30:00'),
(772, 5, 'mardi', '12:15:00'),
(773, 5, 'mardi', '15:15:00'),
(774, 5, 'mardi', '17:00:00'),
(775, 6, 'mardi', '22:00:00'),
(776, 7, 'mardi', '11:30:00'),
(777, 7, 'mardi', '12:30:00'),
(778, 7, 'mardi', '15:00:00'),
(779, 7, 'mardi', '17:00:00'),
(780, 7, 'mardi', '19:00:00'),
(781, 7, 'mardi', '20:45:00'),
(782, 8, 'mardi', '12:00:00'),
(783, 8, 'mardi', '13:00:00'),
(784, 8, 'mardi', '14:00:00'),
(785, 8, 'mardi', '15:00:00'),
(786, 8, 'mardi', '16:00:00'),
(787, 8, 'mardi', '17:00:00'),
(788, 8, 'mardi', '18:00:00'),
(789, 8, 'mardi', '19:00:00'),
(790, 8, 'mardi', '20:00:00'),
(791, 9, 'mardi', '09:45:00'),
(792, 9, 'mardi', '10:15:00'),
(793, 9, 'mardi', '11:45:00'),
(794, 9, 'mardi', '12:30:00'),
(795, 9, 'mardi', '14:30:00'),
(796, 9, 'mardi', '16:00:00'),
(797, 9, 'mardi', '17:45:00'),
(798, 9, 'mardi', '18:15:00'),
(799, 9, 'mardi', '18:45:00'),
(800, 9, 'mardi', '19:15:00'),
(801, 9, 'mardi', '19:45:00'),
(802, 9, 'mardi', '20:30:00'),
(803, 9, 'mardi', '21:00:00'),
(804, 10, 'mardi', '11:30:00'),
(805, 10, 'mardi', '14:15:00'),
(806, 10, 'mardi', '15:15:00'),
(807, 10, 'mardi', '16:00:00'),
(808, 10, 'mardi', '17:00:00'),
(809, 10, 'mardi', '18:00:00'),
(810, 10, 'mardi', '19:30:00'),
(811, 11, 'mardi', '13:00:00'),
(812, 11, 'mardi', '15:00:00'),
(813, 11, 'mardi', '18:15:00'),
(814, 11, 'mardi', '18:45:00'),
(815, 12, 'mardi', '12:30:00'),
(816, 12, 'mardi', '16:00:00'),
(817, 12, 'mardi', '18:15:00'),
(818, 12, 'mardi', '19:00:00'),
(819, 12, 'mardi', '20:15:00'),
(820, 1, 'lundi', '14:00:00'),
(821, 1, 'lundi', '17:00:00'),
(822, 2, 'lundi', '11:30:00'),
(823, 2, 'lundi', '13:00:00'),
(824, 2, 'lundi', '16:00:00'),
(825, 2, 'lundi', '19:30:00'),
(826, 3, 'lundi', '11:45:00'),
(827, 3, 'lundi', '14:15:00'),
(828, 3, 'lundi', '16:15:00'),
(829, 3, 'lundi', '18:15:00'),
(830, 4, 'lundi', '10:45:00'),
(831, 4, 'lundi', '13:15:00'),
(832, 4, 'lundi', '15:15:00'),
(833, 4, 'lundi', '16:45:00'),
(834, 5, 'lundi', '10:30:00'),
(835, 5, 'lundi', '12:15:00'),
(836, 5, 'lundi', '15:15:00'),
(837, 5, 'lundi', '17:00:00'),
(838, 6, 'lundi', '22:00:00'),
(839, 7, 'lundi', '11:30:00'),
(840, 7, 'lundi', '12:30:00'),
(841, 7, 'lundi', '15:00:00'),
(842, 7, 'lundi', '17:00:00'),
(843, 7, 'lundi', '19:00:00'),
(844, 7, 'lundi', '20:45:00'),
(845, 8, 'lundi', '12:00:00'),
(846, 8, 'lundi', '13:00:00'),
(847, 8, 'lundi', '14:00:00'),
(848, 8, 'lundi', '15:00:00'),
(849, 8, 'lundi', '16:00:00'),
(850, 8, 'lundi', '17:00:00'),
(851, 8, 'lundi', '18:00:00'),
(852, 8, 'lundi', '19:00:00'),
(853, 8, 'lundi', '20:00:00'),
(854, 9, 'lundi', '09:45:00'),
(855, 9, 'lundi', '10:15:00'),
(856, 9, 'lundi', '11:45:00'),
(857, 9, 'lundi', '12:30:00'),
(858, 9, 'lundi', '14:30:00'),
(859, 9, 'lundi', '16:00:00'),
(860, 9, 'lundi', '17:45:00'),
(861, 9, 'lundi', '18:15:00'),
(862, 9, 'lundi', '18:45:00'),
(863, 9, 'lundi', '19:15:00'),
(864, 9, 'lundi', '19:45:00'),
(865, 9, 'lundi', '20:30:00'),
(866, 9, 'lundi', '21:00:00'),
(867, 10, 'lundi', '11:30:00'),
(868, 10, 'lundi', '14:15:00'),
(869, 10, 'lundi', '15:15:00'),
(870, 10, 'lundi', '16:00:00'),
(871, 10, 'lundi', '17:00:00'),
(872, 10, 'lundi', '18:00:00'),
(873, 10, 'lundi', '19:30:00'),
(874, 11, 'lundi', '13:00:00'),
(875, 11, 'lundi', '15:00:00'),
(876, 11, 'lundi', '18:15:00'),
(877, 11, 'lundi', '18:45:00'),
(878, 12, 'lundi', '12:30:00'),
(879, 12, 'lundi', '16:00:00'),
(880, 12, 'lundi', '18:15:00'),
(881, 12, 'lundi', '19:00:00'),
(882, 12, 'lundi', '20:15:00'),
(883, 1, 'mercredi', '14:00:00'),
(884, 1, 'mercredi', '17:00:00'),
(885, 2, 'mercredi', '11:30:00'),
(886, 2, 'mercredi', '13:00:00'),
(887, 2, 'mercredi', '16:00:00'),
(888, 2, 'mercredi', '19:30:00'),
(889, 3, 'mercredi', '11:45:00'),
(890, 3, 'mercredi', '14:15:00'),
(891, 3, 'mercredi', '16:15:00'),
(892, 3, 'mercredi', '18:15:00'),
(893, 4, 'mercredi', '10:45:00'),
(894, 4, 'mercredi', '13:15:00'),
(895, 4, 'mercredi', '15:15:00'),
(896, 4, 'mercredi', '16:45:00'),
(897, 5, 'mercredi', '10:30:00'),
(898, 5, 'mercredi', '12:15:00'),
(899, 5, 'mercredi', '15:15:00'),
(900, 5, 'mercredi', '17:00:00'),
(901, 6, 'mercredi', '22:00:00'),
(902, 7, 'mercredi', '11:30:00'),
(903, 7, 'mercredi', '12:30:00'),
(904, 7, 'mercredi', '15:00:00'),
(905, 7, 'mercredi', '17:00:00'),
(906, 7, 'mercredi', '19:00:00'),
(907, 7, 'mercredi', '20:45:00'),
(908, 8, 'mercredi', '12:00:00'),
(909, 8, 'mercredi', '13:00:00'),
(910, 8, 'mercredi', '14:00:00'),
(911, 8, 'mercredi', '15:00:00'),
(912, 8, 'mercredi', '16:00:00'),
(913, 8, 'mercredi', '17:00:00'),
(914, 8, 'mercredi', '18:00:00'),
(915, 8, 'mercredi', '19:00:00'),
(916, 8, 'mercredi', '20:00:00'),
(917, 9, 'mercredi', '09:45:00'),
(918, 9, 'mercredi', '10:15:00'),
(919, 9, 'mercredi', '11:45:00'),
(920, 9, 'mercredi', '12:30:00'),
(921, 9, 'mercredi', '14:30:00'),
(922, 9, 'mercredi', '16:00:00'),
(923, 9, 'mercredi', '17:45:00'),
(924, 9, 'mercredi', '18:15:00'),
(925, 9, 'mercredi', '18:45:00'),
(926, 9, 'mercredi', '19:15:00'),
(927, 9, 'mercredi', '19:45:00'),
(928, 9, 'mercredi', '20:30:00'),
(929, 9, 'mercredi', '21:00:00'),
(930, 10, 'mercredi', '11:30:00'),
(931, 10, 'mercredi', '14:15:00'),
(932, 10, 'mercredi', '15:15:00'),
(933, 10, 'mercredi', '16:00:00'),
(934, 10, 'mercredi', '17:00:00'),
(935, 10, 'mercredi', '18:00:00'),
(936, 10, 'mercredi', '19:30:00'),
(937, 11, 'mercredi', '13:00:00'),
(938, 11, 'mercredi', '15:00:00'),
(939, 11, 'mercredi', '18:15:00'),
(940, 11, 'mercredi', '18:45:00'),
(941, 12, 'mercredi', '12:30:00'),
(942, 12, 'mercredi', '16:00:00'),
(943, 12, 'mercredi', '18:15:00'),
(944, 12, 'mercredi', '19:00:00'),
(945, 12, 'mercredi', '20:15:00'),
(946, 1, 'jeudi', '14:00:00'),
(947, 1, 'jeudi', '17:00:00'),
(948, 2, 'jeudi', '11:30:00'),
(949, 2, 'jeudi', '13:00:00'),
(950, 2, 'jeudi', '16:00:00'),
(951, 2, 'jeudi', '19:30:00'),
(952, 3, 'jeudi', '11:45:00'),
(953, 3, 'jeudi', '14:15:00'),
(954, 3, 'jeudi', '16:15:00'),
(955, 3, 'jeudi', '18:15:00'),
(956, 4, 'jeudi', '10:45:00'),
(957, 4, 'jeudi', '13:15:00'),
(958, 4, 'jeudi', '15:15:00'),
(959, 4, 'jeudi', '16:45:00'),
(960, 5, 'jeudi', '10:30:00'),
(961, 5, 'jeudi', '12:15:00'),
(962, 5, 'jeudi', '15:15:00'),
(963, 5, 'jeudi', '17:00:00'),
(964, 6, 'jeudi', '22:00:00'),
(965, 7, 'jeudi', '11:30:00'),
(966, 7, 'jeudi', '12:30:00'),
(967, 7, 'jeudi', '15:00:00'),
(968, 7, 'jeudi', '17:00:00'),
(969, 7, 'jeudi', '19:00:00'),
(970, 7, 'jeudi', '20:45:00'),
(971, 8, 'jeudi', '12:00:00'),
(972, 8, 'jeudi', '13:00:00'),
(973, 8, 'jeudi', '14:00:00'),
(974, 8, 'jeudi', '15:00:00'),
(975, 8, 'jeudi', '16:00:00'),
(976, 8, 'jeudi', '17:00:00'),
(977, 8, 'jeudi', '18:00:00'),
(978, 8, 'jeudi', '19:00:00'),
(979, 8, 'jeudi', '20:00:00'),
(980, 9, 'jeudi', '09:45:00'),
(981, 9, 'jeudi', '10:15:00'),
(982, 9, 'jeudi', '11:45:00'),
(983, 9, 'jeudi', '12:30:00'),
(984, 9, 'jeudi', '14:30:00'),
(985, 9, 'jeudi', '16:00:00'),
(986, 9, 'jeudi', '17:45:00'),
(987, 9, 'jeudi', '18:15:00'),
(988, 9, 'jeudi', '18:45:00'),
(989, 9, 'jeudi', '19:15:00'),
(990, 9, 'jeudi', '19:45:00'),
(991, 9, 'jeudi', '20:30:00'),
(992, 9, 'jeudi', '21:00:00'),
(993, 10, 'jeudi', '11:30:00'),
(994, 10, 'jeudi', '14:15:00'),
(995, 10, 'jeudi', '15:15:00'),
(996, 10, 'jeudi', '16:00:00'),
(997, 10, 'jeudi', '17:00:00'),
(998, 10, 'jeudi', '18:00:00'),
(999, 10, 'jeudi', '19:30:00'),
(1000, 11, 'jeudi', '13:00:00'),
(1001, 11, 'jeudi', '15:00:00'),
(1002, 11, 'jeudi', '18:15:00'),
(1003, 11, 'jeudi', '18:45:00'),
(1004, 12, 'jeudi', '12:30:00'),
(1005, 12, 'jeudi', '16:00:00'),
(1006, 12, 'jeudi', '18:15:00'),
(1007, 12, 'jeudi', '19:00:00'),
(1008, 12, 'jeudi', '20:15:00'),
(1009, 1, 'vendredi', '14:00:00'),
(1010, 1, 'vendredi', '17:00:00'),
(1011, 2, 'vendredi', '11:30:00'),
(1012, 2, 'vendredi', '13:00:00'),
(1013, 2, 'vendredi', '16:00:00'),
(1014, 2, 'vendredi', '19:30:00'),
(1015, 3, 'vendredi', '11:45:00'),
(1016, 3, 'vendredi', '14:15:00'),
(1017, 3, 'vendredi', '16:15:00'),
(1018, 3, 'vendredi', '18:15:00'),
(1019, 4, 'vendredi', '10:45:00'),
(1020, 4, 'vendredi', '13:15:00'),
(1021, 4, 'vendredi', '15:15:00'),
(1022, 4, 'vendredi', '16:45:00'),
(1023, 5, 'vendredi', '10:30:00'),
(1024, 5, 'vendredi', '12:15:00'),
(1025, 5, 'vendredi', '15:15:00'),
(1026, 5, 'vendredi', '17:00:00'),
(1027, 6, 'vendredi', '22:00:00'),
(1028, 7, 'vendredi', '11:30:00'),
(1029, 7, 'vendredi', '12:30:00'),
(1030, 7, 'vendredi', '15:00:00'),
(1031, 7, 'vendredi', '17:00:00'),
(1032, 7, 'vendredi', '19:00:00'),
(1033, 7, 'vendredi', '20:45:00'),
(1034, 8, 'vendredi', '12:00:00'),
(1035, 8, 'vendredi', '13:00:00'),
(1036, 8, 'vendredi', '14:00:00'),
(1037, 8, 'vendredi', '15:00:00'),
(1038, 8, 'vendredi', '16:00:00'),
(1039, 8, 'vendredi', '17:00:00'),
(1040, 8, 'vendredi', '18:00:00'),
(1041, 8, 'vendredi', '19:00:00'),
(1042, 8, 'vendredi', '20:00:00'),
(1043, 9, 'vendredi', '09:45:00'),
(1044, 9, 'vendredi', '10:15:00'),
(1045, 9, 'vendredi', '11:45:00'),
(1046, 9, 'vendredi', '12:30:00'),
(1047, 9, 'vendredi', '14:30:00'),
(1048, 9, 'vendredi', '16:00:00'),
(1049, 9, 'vendredi', '17:45:00'),
(1050, 9, 'vendredi', '18:15:00'),
(1051, 9, 'vendredi', '18:45:00'),
(1052, 9, 'vendredi', '19:15:00'),
(1053, 9, 'vendredi', '19:45:00'),
(1054, 9, 'vendredi', '20:30:00'),
(1055, 9, 'vendredi', '21:00:00'),
(1056, 10, 'vendredi', '11:30:00'),
(1057, 10, 'vendredi', '14:15:00'),
(1058, 10, 'vendredi', '15:15:00'),
(1059, 10, 'vendredi', '16:00:00'),
(1060, 10, 'vendredi', '17:00:00'),
(1061, 10, 'vendredi', '18:00:00'),
(1062, 10, 'vendredi', '19:30:00'),
(1063, 11, 'vendredi', '13:00:00'),
(1064, 11, 'vendredi', '15:00:00'),
(1065, 11, 'vendredi', '18:15:00'),
(1066, 11, 'vendredi', '18:45:00'),
(1067, 12, 'vendredi', '12:30:00'),
(1068, 12, 'vendredi', '16:00:00'),
(1069, 12, 'vendredi', '18:15:00'),
(1070, 12, 'vendredi', '19:00:00'),
(1071, 12, 'vendredi', '20:15:00'),
(1072, 1, 'samedi', '14:00:00'),
(1073, 1, 'samedi', '17:00:00'),
(1074, 2, 'samedi', '11:30:00'),
(1075, 2, 'samedi', '13:00:00'),
(1076, 2, 'samedi', '16:00:00'),
(1077, 2, 'samedi', '19:30:00'),
(1078, 3, 'samedi', '11:45:00'),
(1079, 3, 'samedi', '14:15:00'),
(1080, 3, 'samedi', '16:15:00'),
(1081, 3, 'samedi', '18:15:00'),
(1082, 4, 'samedi', '10:45:00'),
(1083, 4, 'samedi', '13:15:00'),
(1084, 4, 'samedi', '15:15:00'),
(1085, 4, 'samedi', '16:45:00'),
(1086, 5, 'samedi', '10:30:00'),
(1087, 5, 'samedi', '12:15:00'),
(1088, 5, 'samedi', '15:15:00'),
(1089, 5, 'samedi', '17:00:00'),
(1090, 6, 'samedi', '22:00:00'),
(1091, 7, 'samedi', '11:30:00'),
(1092, 7, 'samedi', '12:30:00'),
(1093, 7, 'samedi', '15:00:00'),
(1094, 7, 'samedi', '17:00:00'),
(1095, 7, 'samedi', '19:00:00'),
(1096, 7, 'samedi', '20:45:00'),
(1097, 8, 'samedi', '12:00:00'),
(1098, 8, 'samedi', '13:00:00'),
(1099, 8, 'samedi', '14:00:00'),
(1100, 8, 'samedi', '15:00:00'),
(1101, 8, 'samedi', '16:00:00'),
(1102, 8, 'samedi', '17:00:00'),
(1103, 8, 'samedi', '18:00:00'),
(1104, 8, 'samedi', '19:00:00'),
(1105, 8, 'samedi', '20:00:00'),
(1106, 9, 'samedi', '09:45:00'),
(1107, 9, 'samedi', '10:15:00'),
(1108, 9, 'samedi', '11:45:00'),
(1109, 9, 'samedi', '12:30:00'),
(1110, 9, 'samedi', '14:30:00'),
(1111, 9, 'samedi', '16:00:00'),
(1112, 9, 'samedi', '17:45:00'),
(1113, 9, 'samedi', '18:15:00'),
(1114, 9, 'samedi', '18:45:00'),
(1115, 9, 'samedi', '19:15:00'),
(1116, 9, 'samedi', '19:45:00'),
(1117, 9, 'samedi', '20:30:00'),
(1118, 9, 'samedi', '21:00:00'),
(1119, 10, 'samedi', '11:30:00'),
(1120, 10, 'samedi', '14:15:00'),
(1121, 10, 'samedi', '15:15:00'),
(1122, 10, 'samedi', '16:00:00'),
(1123, 10, 'samedi', '17:00:00'),
(1124, 10, 'samedi', '18:00:00'),
(1125, 10, 'samedi', '19:30:00'),
(1126, 11, 'samedi', '13:00:00'),
(1127, 11, 'samedi', '15:00:00'),
(1128, 11, 'samedi', '18:15:00'),
(1129, 11, 'samedi', '18:45:00'),
(1130, 12, 'samedi', '12:30:00'),
(1131, 12, 'samedi', '16:00:00'),
(1132, 12, 'samedi', '18:15:00'),
(1133, 12, 'samedi', '19:00:00'),
(1134, 12, 'samedi', '20:15:00');

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
(1, 'Le signe du triomphe', 'Vivez la fureur des jeux du cirque !  Pour sauver leur vie, des prisonniers gaulois sont condamnés à remporter les Jeux du Cirque sous les yeux du gouverneur romain. Vous êtes prêts ? Installez-vous dans les tribunes du Stadium Gallo-Romain et laissez vou', 8, 45, 46.8858, -0.928967, 3, 'plan_signe'),
(2, 'Les vikings', 'Surgissant de leurs drakkars au milieu des flammes gigantesques, les féroces vikings attaquent le paisible Fort de l''An Mil aux toits de chaume. Au pied d''une tour de 22 mètres, le combat fait rage dans un déluge d''effets spéciaux.', 8, 28, 46.8869, -0.929668, 4, 'plan_vikings'),
(3, 'Le bal des oiseaux fantômes', 'Aliénor se réveille dans les ruines du vieux château et ses souvenirs font surgir les faucons, les hiboux et les vautours qui vous frôlent de leurs ailes géantes.Vous n''oublierez jamais le grand ballet des milans, pélicans, cigognes et marabouts... un spe', 2, 33, 46.887, -0.928569, 4, 'plan_bof'),
(4, 'Le secret de la lance', 'Après le départ des chevaliers pour Orléans, Marguerite, une jeune bergère, reste seule au château. Elle va devoir découvrir le secret d''une lance aux pouvoirs fantastiques pour protéger les remparts enchantés du château en pleine bataille.', 8, 28, 46.8909, -0.931301, 3, 'plan_lance'),
(5, 'Mousquetaire de Richelieu', 'Sur les planches d''un théâtre monumental du XVIIème siècle, les mousquetaires vous emportent dans un spectacle de cape et d''épée où l''émerveillement est permanent.', 6, 36, 46.892, -0.932919, 2.5, 'plan_mousquetaires'),
(6, 'Les orgues de feu', 'Chaque soir, sur le vieil étang du Puy du Fou, les musiciens romantiques apparaissent dans leurs costumes de lumières et font danser muses et farfadets dans une symphonie fantastique d''eau et de feu.', 0, 30, 46.8903, -0.929744, 2.5, 'plan_orgues'),
(7, 'Les chevaliers de la table ronde', 'Au pied des remparts, Merlin met le courage d’Arthur à l’épreuve. Après avoir vaincu le sortilège d’Excalibur, Arthur découvre les prodiges du lac enchanteur? !', 4, 18, 46.8872, -0.927724, 2.5, 'plan_tableronde'),
(8, 'L''Odyssée du Puy du Fou', 'Vous traverserez les siècles de la Rome Antique à la Révolution Française.', 1, 18, 46.8902, -0.931246, 2.5, 'plan_odyssee'),
(9, 'Les automates musiciens', 'Au Bourg 1900, les "Avis à la population" du garde champêtre sont souvent interrompus par l''apparition des automates musiciens aux balcons.', 1, 7, 46.892, -0.932577, 5, 'plan_automates'),
(10, 'Les musiciens traditionnels', 'Les musiciens traditionnels vous invitent à la danse.', 2, 20, 46.8879, -0.932096, 2.5, 'plan_musiciens'),
(11, 'Les Grands Eaux', 'Grand spectacle, grande musique, laissez-vous porter par cet orchestre d''eau.', 0, 8, 46.8909, -0.92958, 2.5, 'plan_grandeseaux'),
(12, 'La légende de Martin', 'Les marionnettes de la Légende de Martin entraînent les enfants à la poursuite de la malbête, un monstre férocement drôle.', 1, 15, 46.8898, -0.932015, 2.5, 'plan_martin');

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
