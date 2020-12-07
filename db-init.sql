USE `parts_db`;

CREATE TABLE `spare_part` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(256) DEFAULT NULL,
    `note` text,
    `price` float NOT NULL,
    `vendor_code` varchar(256) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

CREATE TABLE `supplier` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `address` varchar(256) DEFAULT NULL,
    `name` varchar(256) DEFAULT NULL,
    `phone` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `supply` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `supply_date` date DEFAULT NULL,
    `price` float DEFAULT NULL,
    `quantity` int(11) DEFAULT NULL,
    `spare_part_id` bigint(20) DEFAULT NULL,
    `supplier_id` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `supplier_fk` (`supplier_id`),
    KEY `spare_part_fk` (`spare_part_id`),
    CONSTRAINT `supplier_fk` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
    CONSTRAINT `spare_part_fk` FOREIGN KEY (`spare_part_id`) REFERENCES `spare_part` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;


INSERT INTO `parts_db`.`spare_part`
    (`id`,`name`,`note`,`price`,`vendor_code`)
VALUES
    (1,'Oil Filter MAGNETI MARELLI','Outer diameter [mm]: 65\nHeight [mm]: 69\nFilter type: Filter Insert',3.35,'5621865429'),
    (2,'Oil Filter VALEO','Outer diameter [mm]: 65\nHeight [mm]: 69\nInner diameter [mm]: 24,2\nFilter type: Filter Insert',3.52,'752186408'),
    (3,'Oil Filter MAGNETI MARELLI','Outer diameter [mm]: 65\nHeight [mm]: 69\nFilter type: Filter Insert',35.54,'5621865429'),
    (4,'Brake Disc TEXTAR PRO','Fitting Position: Front Axle\nOuter diameter [mm]: 283\nBrake Disc Type: Externally Vented',29.08,'25784690'),
    (5,'Brake Disc FERODO PREMIER Coat+ disc','Fitting Position: Front Axle\nOuter diameter [mm]: 283\nBrake Disc Type:Vented',39.22,'4528617082'),
    (6,'Brake Fluid A.B.S.','Supplementary Info: DOT4, ABS\nContent [litre]: 0,25\nDOT specification: DOT 4',2.10,'4852618950'),
    (7,'Brake Fluid TEXTAR','Specification: DOT4, ISO 4925 (Class 4), SAE J 1704, FMVSS 116 DOT 4',2.89,'4852618950'),
    (8,'Shock Absorber RIDEX','Shock Absorber System: Twin-Tube\nShock Absorber Type: Gas Pressure\nShock Absorber Design:Suspension Strut',29.45,'8751594264'),
    (9,'Wiper Motor ESEN SKV','Fitting Position: Front\nVoltage [V]: 12\nConstruction year to: 12/2005',32.83,'5148625477'),
    (10,'Steering Gear ERA Benelux','Operating Mode: Electric\nEquipment Variant: Electric assist\nCondition: Remanufactured',168.78,'5426871595'),
    (11,'Starter Battery EXIDE EXCELL','Battery Capacity [Ah]: 71\nVoltage [V]: 12',71.72,'4529751580'),
    (12,'EGR Valve ABAKUS','Operating Mode: Electric\nSupplementary Article/Supplementary Info: with gaskets/seals',46.49,'7519524860');

INSERT INTO `parts_db`.`supplier`
    (`id`,`address`,`name`,`phone`)
VALUES
    (1,'https://www.alibaba.com/','Alibaba','+1 89-254-7526'),
    (2,'Via dei Lombardi 5 40069 - Zola Predosa (BO) - Italy','VRM SPA','+390 51-595-0148'),
    (3,'22 Florence St, South Hackensack, NJ 07606, USA','Wholesale Auto Supply Co., Inc.','+1 201-489-1600'),
    (4,'2346 W Warren Ave, Detroit, MI 48208, USA','US Auto Supply of Detroit','+1 313-894-1194'),
    (5,'15 Jackson Rd, Totowa, NJ 07512, USA','Empire Auto Parts','+1 800-624-4561'),
    (6,'339 MB-12, Steinbach, MB R5G 1T8, Canada','NAPA Auto Parts','+1 204-326-3485');

INSERT INTO `parts_db`.`supply`
    (`supply_date`, `price`, `quantity`, `spare_part_id`, `supplier_id`)
VALUES
    ('2020-9-20',2.1,1,6,5),
    ('2020-3-27',39.22,2,5,6),
    ('2020-6-05',2.1,1,6,5),
    ('2020-8-05',3.35,3,1,2),
    ('2020-3-27',71.72,9,11,3),
    ('2020-3-21',71.72,2,11,4),
    ('2020-6-06',3.35,2,1,5),
    ('2020-6-26',2.89,10,7,6),
    ('2020-10-01',29.45,10,8,1),
    ('2020-8-16',46.49,7,12,1),
    ('2020-7-07',2.1,7,6,4),
    ('2020-7-19',3.52,6,2,4),
    ('2020-8-18',39.22,9,5,6),
    ('2020-9-24',29.45,2,8,5),
    ('2020-3-09',29.45,6,8,6),
    ('2020-5-25',29.45,11,8,2),
    ('2020-9-20',71.72,1,11,1),
    ('2020-8-03',32.83,6,9,2),
    ('2020-5-23',46.49,8,12,2),
    ('2020-4-20',35.54,8,3,1),
    ('2020-5-10',71.72,8,11,5),
    ('2020-6-28',71.72,2,11,3),
    ('2020-3-12',29.45,4,8,2),
    ('2020-6-09',29.45,2,8,1),
    ('2020-7-20',39.22,3,5,1),
    ('2020-7-11',29.45,6,8,4),
    ('2020-5-19',32.83,5,9,1),
    ('2020-7-19',39.22,10,5,3),
    ('2020-6-22',29.08,3,4,6),
    ('2020-7-06',3.35,8,1,1),
    ('2020-7-05',3.52,2,2,4),
    ('2020-3-04',2.1,7,6,4),
    ('2020-4-29',168.78,10,10,3),
    ('2020-7-13',35.54,6,3,3),
    ('2020-10-02',2.1,6,6,2),
    ('2020-7-06',32.83,5,9,6),
    ('2020-3-27',2.89,11,7,6),
    ('2020-4-18',71.72,9,11,5),
    ('2020-7-08',35.54,10,3,3),
    ('2020-9-14',168.78,8,10,4);