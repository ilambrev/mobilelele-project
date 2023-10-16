# INSERT INTO `roles`
# VALUES (1,'USER'),
#        (2,'ADMIN');

INSERT INTO `users`
VALUES (2,'2023-10-08 21:14:04.064538','ribeiro@mobilelele.bg','Fernando',NULL,1,'Ribeiro',NULL,'5d35c1aa5f7988e6593c1a6295bea8994890495e6b7877a596c4b0daefe78b39ef33814326aed09289542ecaab9e5f29',1),
       (3,'2023-10-08 21:14:42.885583','hetfield@mobilelele.bg','James',NULL,1,'Hetfield',NULL,'74a327b4946b5e389b57f9e23547941a1dc902d65fe53ff2d7a405ef1e1f1e63117ab53e1337ea00bfe91b3e726a1c9b',1),
       (4,'2023-10-10 07:49:07.200338','joutsen@mobilelele.bg','Tomi',NULL,1,'Joutsen',NULL,'f39e1b831800684ee340c489c4b61be6a84c4ea13f432dc5622d9b4570e43f01cdb064b8d69e9e2244896d420c405e1b',1);

INSERT INTO `brands`
VALUES (1,'2023-10-06 15:20:13.280835',NULL,'Toyota'),
       (2,'2023-10-06 15:20:13.280835',NULL,'Ford'),
       (3,'2023-10-06 15:20:13.280835',NULL,'Skoda'),
       (4,'2023-10-06 15:20:13.280835',NULL,'Opel');

INSERT INTO `models`
VALUES (1,'CAR','2023-10-06 15:20:13.280835',NULL,'https://upload.wikimedia.org/wikipedia/commons/6/6d/1982_Toyota_Camry_01.jpg',NULL,'Camry',1983,1),
       (2,'CAR','2023-10-06 15:20:13.280835',NULL,'https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/1968_Toyota_Corolla_1100_Deluxe.jpg/1920px-1968_Toyota_Corolla_1100_Deluxe.jpg',NULL,'Corolla',1966,1),
       (3,'CAR','2023-10-06 15:20:13.280835',NULL,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/2003_Ford_Focus_Zetec_1.6_Front.jpg/1920px-2003_Ford_Focus_Zetec_1.6_Front.jpg',NULL,'Focus',1998,2),
       (4,'CAR','2023-10-06 15:20:13.280835',2023,'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Ford_Fiesta_ST-Line_%28VII%2C_Facelift%29_%E2%80%93_f_30012023.jpg/1920px-Ford_Fiesta_ST-Line_%28VII%2C_Facelift%29_%E2%80%93_f_30012023.jpg',NULL,'Fiesta',1976,2),
       (5,'CAR','2023-10-06 15:20:13.280835',NULL,'https://upload.wikimedia.org/wikipedia/commons/1/1c/Skoda_Octavia_I_front_20080213.jpg',NULL,'Octavia',1996,3),
       (6,'CAR','2023-10-06 15:20:13.280835',NULL,'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Skoda_Fabia_vRS_%287914423470%29.jpg/1280px-Skoda_Fabia_vRS_%287914423470%29.jpg',NULL,'Fabia',1999,3),
       (7,'CAR','2023-10-06 15:20:13.280835',NULL,'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Skoda_Scala_IMG_2515.jpg/1920px-Skoda_Scala_IMG_2515.jpg',NULL,'Scala',2019,3),
       (8,'CAR','2023-10-06 15:20:13.280835',2022,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Opel_Insignia_Sports_Tourer_1.5_DIT_Innovation_%28B%29_%E2%80%93_Frontansicht%2C_12._Mai_2017%2C_D%C3%BCsseldorf.jpg/1920px-Opel_Insignia_Sports_Tourer_1.5_DIT_Innovation_%28B%29_%E2%80%93_Frontansicht%2C_12._Mai_2017%2C_D%C3%BCsseldorf.jpg',NULL,'Insignia',2009,4);

INSERT INTO `offers`
VALUES (1,'2023-10-06 15:20:13.280835','Preserved car in good technical condition with all insurances and taxes paid.','DIESEL','https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/2005_Skoda_Octavia_VRS_1.8_Front.jpg/1920px-2005_Skoda_Octavia_VRS_1.8_Front.jpg',263734,'2023-10-06 15:20:13.280835',5000.00,'MANUAL','a9c04c60-bda5-4af4-b5f3-41dd7d6b937e',2001,5,4),
       (2,'2023-10-10 18:35:13.280835','Like New!','DIESEL','https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/2018_Skoda_Fabia_SE_MPi_1.0.jpg/1920px-2018_Skoda_Fabia_SE_MPi_1.0.jpg',97435,'2023-10-11 20:09:13.280835',10000.00,'MANUAL','050638f0-f5d5-4d01-9849-16e7a514763b',2015,6,3),
       (3,'2023-10-14 11:21:12.280835','Perfect car!','GASOLINE','https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/2008_Ford_Focus_Zetec_TD_109_1.6_Front.jpg/1920px-2008_Ford_Focus_Zetec_TD_109_1.6_Front.jpg',143291,'2023-10-14 12:15:10.280835',4500.00,'AUTOMATIC','4235919c-c82b-47f5-bc52-d08f6eb42faf',2006,3,2);
