# ALKEMY JAVA TECHNICAL CHALLENGE - WALLET

### PROJECT SETUP & TOOLS
1. JDK 17
2. [MySQL](https://dev.mysql.com/doc/refman/8.0/en/installing.html).
3. [Postman](https://www.postman.com/downloads/) for testing endpoints.

### CODE STANDARDS
- Keep in mind rules from [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
- Code must be in English.
- The controllers should finish with suffix "Controller". Example: UserController.
- The services should finish with suffix "Service". Example: UserService.
- The repositories should finish with suffix "Repository". Example: UserRepository.
- The interfaces should start with prefix "I". Example: IUserRepository.
- The implementations should finish with suffix "Impl". Example: UserServiceImpl.
- The DTOs should finish with suffix "Dto". Example: UserDto, UserRequestDto.
- Usage of DTOs is a must. Can have DTOs for request and response.
- Package names are in singular.
- The names of attributes/fields from Java classes must be written using camel case. Example: firstName.
- The name of columns in the entities must be written using underscore and uppercase. Example: FIRST_NAME. The name of the tables is always in plural, but the entity name should be in singular.
- Exceptions should be handled by an implementation of ControllerAdvice. 
- Messages to user can't be hardcoded them should be handled. Some refs [here](https://looksok.wordpress.com/2014/07/05/string-externalization-in-spring-3-1-with-messagesource-no-web-xml/) and [here](https://zetcode.com/spring/messagesource/). 
- If you add a new endpoint, make sure to set the role access for it in the SecurityConfig class.


You will find an example of how to work with the project architecture in `architecture-example` branch.

### GIT STANDARDS

#### FORMAT
- Always create the branch from develop
- The branch name format is: `feature/{jiraTicket#}`.
- The pull request title format is: `{jiraTicket#}: {jiraTitle}`.
- The commits format is: `{jiraTicket#}: {commitDescription}`. Small commits are a nice to have.
- The pull request has to contain only the changes related to the scope defined in the ticket.
- Pull request should always be from your current branch to develop.

#### EVIDENCE
- If you do not write unit test or integration test as part of your code changes, you should add the HTTP request and response as evidence that the code is working as expected.
- Screenshots from Postman with different scenarios are a good way to show your work.

#### BRANCHES
In the current repository you will see three diferent branches
- `master` -> this branch is only for productive versions, it has official release history.
- `develop` -> this branch serves as an integration branch for features. All features must start from this branch and after it's finished it gets merged back into develop.
- `architecture-example` -> in this branch you will find an example of a suggested architecture. You can take it as a reference but you should not modify it. 

For understanding more about git and how to work with different branches, I recommend to read about Gitflow workflow. [Here](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) you have a little explanation that can serve as introduction.

### RUN LOCALLY
On the root folder run:
```
mvn spring-boot:run
```


## SEED USUARIOS
//////////////SCRIPT SQL TABLLA USER//////////

INSERT INTO chanchez_squad3.user (email, first_name, last_name, password)
VALUES
('johndoe@example.com', 'John', 'Doe', 'password123'),
('janedoe@example.com', 'Jane', 'Doe', 'doe456'),
('mike.smith@example.com', 'Mike', 'Smith', 'smith789'),
('emily.jones@example.com', 'Emily', 'Jones', 'ejones123'),
('chris.wilson@example.com', 'Chris', 'Wilson', 'wilson456'),
('sarah.brown@example.com', 'Sarah', 'Brown', 'sbrown789'),
('david.johnson@example.com', 'David', 'Johnson', 'davidj123'),
('olivia.miller@example.com', 'Olivia', 'Miller', 'miller456'),
('william.moore@example.com', 'William', 'Moore', 'wmoore789'),
('ava.taylor@example.com', 'Ava', 'Taylor', 'ataylor123'),
('lucas.anderson@example.com', 'Lucas', 'Anderson', 'landerson456'),
('mia.thomas@example.com', 'Mia', 'Thomas', 'miathomas789'),
('ethan.wilson@example.com', 'Ethan', 'Wilson', 'ewilson123'),
('emma.jackson@example.com', 'Emma', 'Jackson', 'ejackson456'),
('noah.white@example.com', 'Noah', 'White', 'nwhite789'),
('isabella.harris@example.com', 'Isabella', 'Harris', 'iharris123'),
('james.martin@example.com', 'James', 'Martin', 'jmartin456'),
('amelia.lee@example.com', 'Amelia', 'Lee', 'alee789'),
('alexander.thompson@example.com', 'Alexander', 'Thompson', 'athompson123'),
('sophia.garcia@example.com', 'Sophia', 'Garcia', 'sgarcia456'),
('logan.martinez@example.com', 'Logan', 'Martinez', 'lmartinez789'),
('mia.robinson@example.com', 'Mia', 'Robinson', 'miarobinson123'),
('mason.clark@example.com', 'Mason', 'Clark', 'mclark456'),
('ava.rodriguez@example.com', 'Ava', 'Rodriguez', 'arodriguez789'),
('william.hall@example.com', 'William', 'Hall', 'whall123'),
('harper.edwards@example.com', 'Harper', 'Edwards', 'hedwards456'),
('evelyn.gonzalez@example.com', 'Evelyn', 'Gonzalez', 'egonzalez789'),
('jackson.perez@example.com', 'Jackson', 'Perez', 'jperez123'),
('avery.turner@example.com', 'Avery', 'Turner', 'aturner456'),
('victoria.cook@example.com', 'Victoria', 'Cook', 'vcook789'),
('dylan.collins@example.com', 'Dylan', 'Collins', 'dcollins123'),
('zoe.bailey@example.com', 'Zoe', 'Bailey', 'zbailey456'),
('levi.stewart@example.com', 'Levi', 'Stewart', 'lstewart789'),
('nora.murphy@example.com', 'Nora', 'Murphy', 'nmurphy123'),
('asher.rivera@example.com', 'Asher', 'Rivera', 'arivera456'),
('elizabeth.ward@example.com', 'Elizabeth', 'Ward', 'eward789'),
('grayson.diaz@example.com', 'Grayson', 'Diaz', 'gdiaz123'),
('aubrey.evans@example.com', 'Aubrey', 'Evans', 'aevans456'),
('wyatt.reyes@example.com', 'Wyatt', 'Reyes', 'wreyes789'),
('stella.phillips@example.com', 'Stella', 'Phillips', 'sphillips123'),
('leo.carter@example.com', 'Leo', 'Carter', 'lcarter456'),
('nova.scott@example.com', 'Nova', 'Scott', 'nscott789'),
('emmett.nguyen@example.com', 'Emmett', 'Nguyen', 'enguyen123'),
('aurora.howard@example.com', 'Aurora', 'Howard', 'ahoward456'),
('zoey.campbell@example.com', 'Zoey', 'Campbell', 'zcampbell789');


//////////////SCRIPT SQL TABLA TRANSACTIONS//////////
INSERT INTO chanchez_squad3.transactions(amount, description, transaction_date, type_enum, account_id)
VALUES
(8000, 'Compra en tienda', '2023-12-16 16:10:23.428000', 'PAYMENT', 3),
(10000, 'Ingreso por venta', '2023-12-16 16:11:45.652000', 'INCOME', 2),
(3000, 'Gastos varios', '2023-12-16 16:13:57.831000', 'PAYMENT', 4),
(5000, 'Depósito de salario', '2023-12-16 16:15:21.997000', 'DEPOSIT', 1),
(7000, 'Compra de libros', '2023-12-16 16:17:34.112000', 'PAYMENT', 2),
(20000, 'Ingreso por servicios', '2023-12-16 16:19:45.287000', 'INCOME', 3),
(1000, 'Pago de suscripción', '2023-12-16 16:21:59.421000', 'PAYMENT', 1),
(15000, 'Ingreso por alquiler', '2023-12-16 16:24:11.518000', 'INCOME', 4),
(4000, 'Gastos de entretenimiento', '2023-12-16 16:26:23.623000', 'PAYMENT', 3),
(6000, 'Ingreso por bonificación', '2023-12-16 16:28:35.712000', 'INCOME', 2),
(9000, 'Gastos de viaje', '2023-12-16 16:30:49.889000', 'PAYMENT', 1),
(12000, 'Ingreso por inversiones', '2023-12-16 16:33:02.973000', 'INCOME', 4),
(2500, 'Gastos médicos', '2023-12-16 16:35:14.105000', 'PAYMENT', 2),
(18000, 'Ingreso por ventas', '2023-12-16 16:37:27.201000', 'INCOME', 3),
(3500, 'Pago de préstamo', '2023-12-16 16:39:39.345000', 'PAYMENT', 4),
(30000, 'Ingreso por subvención', '2023-12-16 16:41:51.432000', 'INCOME', 1),
(6000, 'Gastos de comida', '2023-12-16 16:44:03.579000', 'PAYMENT', 3),
(1000, 'Otros gastos', '2023-12-16 16:46:15.701000', 'PAYMENT', 2),
(2000, 'Ingreso por servicios', '2023-12-16 16:48:29.802000', 'INCOME', 1),
(500, 'Gastos pequeños', '2023-12-16 16:50:43.934000', 'PAYMENT', 4),
(12000, 'Ingreso por bonificación', '2023-12-16 16:52:56.006000', 'INCOME', 3),
(800, 'Gastos misceláneos', '2023-12-16 16:55:08.103000', 'PAYMENT', 2),
(15000, 'Ingreso por ventas', '2023-12-16 16:57:21.234000', 'INCOME', 1),
(4500, 'Gastos de transporte', '2023-12-16 16:59:35.332000', 'PAYMENT', 3),
(5000, 'Ingreso adicional', '2023-12-16 17:01:49.401000', 'INCOME', 4),
(2500, 'Gastos de suministros', '2023-12-16 17:04:03.501000', 'PAYMENT', 1),
(20000, 'Ingreso por proyectos', '2023-12-16 17:06:18.602000', 'INCOME', 2),
(10000, 'Gastos de regalos', '2023-12-16 17:08:33.719000', 'PAYMENT', 3),
(3000, 'Ingreso por servicios', '2023-12-16 17:10:48.808000', 'INCOME', 4),
(7000, 'Gastos de entretenimiento', '2023-12-16 17:13:04.907000', 'PAYMENT', 1),
(15000, 'Ingreso por ventas', '2023-12-16 17:15:21.008000', 'INCOME', 2),
(8000, 'Gastos de educación', '2023-12-16 17:17:36.121000', 'PAYMENT', 4),
(2500, 'Ingreso adicional', '2023-12-16 17:19:53.217000', 'INCOME', 3),
(5000, 'Gastos de hogar', '2023-12-16 17:22:09.324000', 'PAYMENT', 2),
(10000, 'Ingreso por bonificación', '2023-12-16 17:24:25.449000', 'INCOME', 1),
(3000, 'Gastos de mantenimiento', '2023-12-16 17:26:41.555000', 'PAYMENT', 3),
(12000, 'Ingreso por bonificación', '2023-12-16 17:28:57.672000', 'INCOME', 4),
(2500, 'Gastos varios', '2023-12-16 17:31:13.783000', 'PAYMENT', 1),
(8000, 'Ingreso por servicios', '2023-12-16 17:33:29.901000', 'INCOME', 2),
(5000, 'Gastos de salud', '2023-12-16 17:35:46.006000', 'PAYMENT', 3),
(20000, 'Ingreso por ventas', '2023-12-16 17:38:02.123000', 'INCOME', 4),
(12000, 'Gastos de viaje', '2023-12-16 17:40:18.239000', 'PAYMENT', 1),
(3000, 'Ingreso por servicios', '2023-12-16 17:42:34.365000', 'INCOME', 2),
(1500, 'Gastos pequeños', '2023-12-16 17:44:50.492000', 'PAYMENT', 3),
(7000, 'Ingreso por bonificación', '2023-12-16 17:47:06.601000', 'INCOME', 4),
(25000, 'Gastos de compra', '2023-12-16 17:49:22.725000', 'PAYMENT', 1),
(5000, 'Ingreso por servicios', '2023-12-16 17:51:38.821000', 'INCOME', 2),
(1500, 'Gastos de entretenimiento', '2023-12-16 17:53:54.938000', 'PAYMENT', 3),
(9000, 'Ingreso adicional', '2023-12-16 17:56:11.046000', 'INCOME', 4),
(10000, 'Gastos de alimentación', '2023-12-16 17:58:27.162000', 'PAYMENT', 1),
(5000, 'Ingreso por proyectos', '2023-12-16 18:00:43.288000', 'INCOME', 2),
(1500, 'Gastos de transporte', '2023-12-16 18:02:59.384000', 'PAYMENT', 3),
(3000, 'Ingreso por bonificación', '2023-12-16 18:05:15.501000', 'INCOME', 4),
(8000, 'Gastos de educación', '2023-12-16 18:07:31.618000', 'PAYMENT', 1),
(2500, 'Ingreso por servicios', '2023-12-16 18:09:47.724000', 'INCOME', 2),
(5000, 'Gastos de hogar', '2023-12-16 18:12:03.848000', 'PAYMENT', 3),
(10000, 'Ingreso por bonificación', '2023-12-16 18:14:19.944000', 'INCOME', 4),
(3000, 'Gastos de mantenimiento', '2023-12-16 18:16:36.078000', 'PAYMENT', 1),
(12000, 'Ingreso por bonificación', '2023-12-16 18:18:52.221000', 'INCOME', 2),
(2500, 'Gastos varios', '2023-12-16 18:21:08.328000', 'PAYMENT', 3),
(8000, 'Ingreso por servicios', '2023-12-16 18:23:24.443000', 'INCOME', 4),
(5000, 'Gastos de salud', '2023-12-16 18:25:40.568000', 'PAYMENT', 1),
(20000, 'Ingreso por ventas', '2023-12-16 18:27:56.683000', 'INCOME', 2),
(12000, 'Gastos de viaje', '2023-12-16 18:30:12.788000', 'PAYMENT', 3),
(3000, 'Ingreso por servicios', '2023-12-16 18:32:28.906000', 'INCOME', 4),
(1500, 'Gastos pequeños', '2023-12-16 18:34:45.002000', 'PAYMENT', 1),
(7000, 'Ingreso por bonificación', '2023-12-16 18:37:01.138000', 'INCOME', 2),
(25000, 'Gastos de compra', '2023-12-16 18:39:17.244000', 'PAYMENT', 3),
(5000, 'Ingreso por servicios', '2023-12-16 18:41:33.362000', 'INCOME', 4),
(1500, 'Gastos de entretenimiento', '2023-12-16 18:43:49.478000', 'PAYMENT', 1),
(9000, 'Ingreso adicional', '2023-12-16 18:46:05.605000', 'INCOME', 2),
(10000, 'Gastos de alimentación', '2023-12-16 18:48:21.711000', 'PAYMENT', 3),
(5000, 'Ingreso por proyectos', '2023-12-16 18:50:37.829000', 'INCOME', 4),
(1500, 'Gastos de transporte', '2023-12-16 18:52:53.944000', 'PAYMENT', 1),
(3000, 'Ingreso por bonificación', '2023-12-16 18:55:10.068000', 'INCOME', 2),
(8000, 'Gastos de educación', '2023-12-16 18:57:26.175000', 'PAYMENT', 3),
(2500, 'Ingreso por servicios', '2023-12-16 18:59:42.283000', 'INCOME', 4),
(5000, 'Gastos de hogar', '2023-12-16 19:01:58.398000', 'PAYMENT', 1),
(10000, 'Ingreso por bonificación', '2023-12-16 19:04:14.525000', 'INCOME', 2),
(3000, 'Gastos de mantenimiento', '2023-12-16 19:06:30.644000', 'PAYMENT', 3),
(12000, 'Ingreso por bonificación', '2023-12-16 19:08:46.748000', 'INCOME', 4),
(2500, 'Gastos varios', '2023-12-16 19:11:02.863000', 'PAYMENT', 1),
(8000, 'Ingreso por servicios', '2023-12-16 19:13:19.977000', 'INCOME', 2),
(5000, 'Gastos de salud', '2023-12-16 19:15:36.094000', 'PAYMENT', 3),
(20000, 'Ingreso por ventas', '2023-12-16 19:17:52.207000', 'INCOME', 4),
(12000, 'Gastos de viaje', '2023-12-16 19:20:08.322000', 'PAYMENT', 1),
(3000, 'Ingreso por servicios', '2023-12-16 19:22:24.435000', 'INCOME', 2);

//////////////SCRIPT SQL TABLA TRANSACTIONS//////////
INSERT INTO chanchez_squad3.account(balance, creation_date, currency_enum, transaction_limit, update_date, user_id)
VALUES
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 5),
(4850, '2023-12-15 20:25:44.377000', 'ARS', 300000, '2023-12-16 22:28:35.279000', 6),
(2796, '2023-12-15 20:25:27.763000', 'USD', 1000, '2023-12-15 22:43:06.307000', 7),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 8),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 9),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 10),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 11),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 12),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 13),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 14),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 15),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 16),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 17),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 18),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 19),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 20),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 21),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 22),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 23),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 24),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 25),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 26),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 27),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 28),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 29),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 30),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 31),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 32),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 33),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 34),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 35),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 36),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 37),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 38),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 39),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 40),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 41),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 42),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 43),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 44),
(8000, '2023-12-15 20:21:22.023000', 'ARS', 300000, '2023-12-16 18:36:41.925000', 45),
(4850, '2023-12-15 20:25:44.377000', 'USD', 1000, '2023-12-16 22:28:35.279000', 46),
(2796, '2023-12-15 20:25:27.763000', 'ARS', 300000, '2023-12-15 22:43:06.307000', 47),
(1204, '2023-12-15 20:25:57.453000', 'USD', 1000, '2023-12-16 19:19:57.121000', 48);

