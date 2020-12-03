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