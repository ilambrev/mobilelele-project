# INSERT INTO `roles` (`id`, `name`)
# VALUES (1, 'ADMIN'),
#        (2, 'USER');

# INSERT INTO `users` (`id`, `email`, `first_name`, `is_active`, `last_name`, `password`, `role_id`)
# VALUES (2, 'user@mobilele.bg', 'James', 1, 'Hetfield', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151', 2);

INSERT INTO `brands` (`id`, `created`, `name`)
VALUES (1, '2023-10-06 15:20:13.280835', 'Toyota'),
       (2, '2023-10-06 15:20:13.280835', 'Ford'),
       (3, '2023-10-06 15:20:13.280835', 'Skoda');

INSERT INTO `models` (`id`, `category`, `brand_id`, `name`, `start_year`, `created`)
VALUES (1, 'CAR', 1, 'Camry', 1970, '2023-10-06 15:20:13.280835'),
       (2, 'CAR', 1, 'Corolla', 1980, '2023-10-06 15:20:13.280835'),
       (3, 'CAR', 2, 'Focus', 1985, '2023-10-06 15:20:13.280835'),
       (4, 'CAR', 2, 'Fiesta', 1982, '2023-10-06 15:20:13.280835'),
       (5, 'CAR', 3, 'Octavia', 1997, '2023-10-06 15:20:13.280835'),
       (6, 'CAR', 3, 'Fabia', 1998, '2023-10-06 15:20:13.280835'),
       (7, 'CAR', 3, 'Scala', 2010, '2023-10-06 15:20:13.280835');
