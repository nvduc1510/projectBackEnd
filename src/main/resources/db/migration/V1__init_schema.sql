CREATE TABLE IF NOT EXISTS `employees` (
    employee_id bigint(20) NOT NULL AUTO_INCREMENT,
    department_id bigint(20) NOT NULL,
    employee_name VARCHAR(100) NOT NULL,
    employee_name_kana VARCHAR(255) DEFAULT NULL,
    employee_birth_date DATE DEFAULT NULL,
    employee_email VARCHAR(50) NOT NULL,
    employee_telephone VARCHAR(50) DEFAULT NULL,
    employee_login_id VARCHAR(50) NOT NULL,
    employee_login_password VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`employee_id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS departments (
    department_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL
);

CREATE TABLE certifications (
    certification_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    certification_name VARCHAR(255) NOT NULL,
    certification_level INT NOT NULL
);

CREATE TABLE employees_certifications (
    employee_certification_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    certification_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    score FLOAT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (certification_id) REFERENCES certifications(certification_id)
);

INSERT INTO certifications (certification_name, certification_level)
VALUES
('Certification 1', 1),
('Certification 2', 2),
('Certification 3', 2),
('Certification 4', 3),
('Certification 5', 3);

INSERT INTO departments (department_name)
VALUES
('Department 1'),
('Department 2'),
('Department 3'),
('Department 4'),
('Department 5'),
('Department 6'),
('Department 7'),
('Department 8'),
('Department 9'),
('Department 10'),
('Department 11'),
('Department 12'),
('Department 13'),
('Department 14'),
('Department 15');

INSERT INTO employees (department_id, employee_name, employee_name_kana, employee_birth_date, employee_email,
                        employee_telephone, employee_login_id, employee_login_password)
VALUES (1, 'Administrator', NULL, NULL, 'la@luvina.net', NULL, 'admin','$2a$10$r.XIN4K9vTioiuYQwaTop.UVQ5r5FvrKk2V5Orm9Hc6n4i9Tvjthy'),
(2, 'Jane Smith', 'ジェーン スミス', '1995-02-15', 'jane.smith@example.com', '987654321', 'janesmith', 'password456'),
(3, 'Michael Johnson', 'マイケル ジョンソン', '1985-08-22', 'michael.johnson@example.com', '555555555', 'michaeljohnson', 'password789'),
(4, 'Emma Davis', 'エマ デービス', '1992-06-30', 'emma.davis@example.com', '111111111', 'emmadavis', 'password123'),
(5, 'William Wilson', 'ウィリアム ウィルソン', '1998-04-10', 'william.wilson@example.com', '222222222', 'williamwilson', 'password456'),
(6, 'Olivia Taylor', 'オリビア テイラー', '1993-11-25', 'olivia.taylor@example.com', '333333333', 'oliviataylor', 'password789'),
(7, 'Christopher Martin', 'クリストファー マーティン', '1990-02-14', 'christopher.martin@example.com', '444444444', 'christophermartin', 'password123'),
(8, 'Jessica Anderson', 'ジェシカ アンダーソン', '1992-07-30', 'jessica.anderson@example.com', '555555555', 'jessicaanderson', 'password456'),
(9, 'Daniel Clark', 'ダニエル クラーク', '1987-12-09', 'daniel.clark@example.com', '666666666', 'danielclark', 'password789'),
(9, 'Sophia Turner', 'ソフィア ターナー', '1995-04-23', 'sophia.turner@example.com', '777777777', 'sophiaturner', 'password123'),
(11, 'Matthew Young', 'マシュー ヤング', '1993-09-18', 'matthew.young@example.com', '888888888', 'matthewyoung', 'password456'),
(12, 'Ava Harris', 'アヴァ ハリス', '1989-11-02', 'ava.harris@example.com', '999999999', 'avaharris', 'password789'),
(13, 'James Thompson', 'ジェームズ トンプソン', '1991-03-27', 'james.thompson@example.com', '111111111', 'jamesthompson', 'password123'),
(14, 'Oliver Lee', 'オリバー リー', '1988-08-10', 'oliver.lee@example.com', '222222222', 'oliverlee', 'password456'),
(15, 'Emma Lewis', 'エマ ルイス', '1994-01-25', 'emma.lewis@example.com', '333333333', 'emmalewis', 'password789'),
(10, 'Logan Walker', 'ローガン ウォーカー', '1992-05-18', 'logan.walker@example.com', '444444444', 'loganwalker', 'password123'),
(10, 'Grace King', 'グレース キング', '1993-10-11', 'grace.king@example.com', '555555555', 'graceking', 'password456'),
(12, 'Benjamin Turner', 'ベンジャミン ターナー', '1990-07-26', 'benjamin.turner@example.com', '666666666', 'benjaminturner', 'password789'),
(10, 'Chloe Carter', 'クロエ カーター', '1995-01-09', 'chloe.carter@example.com', '777777777', 'chloecarter', 'password123'),
(2, 'Andrew Adams', 'アンドリュー アダムズ', '1991-04-24', 'andrew.adams@example.com', '888888888', 'andrewadams', 'password456'),
(2, 'Samantha Wilson', 'サマンサ ウィルソン', '1989-10-08', 'samantha.wilson@example.com', '999999999', 'samanthawilson', 'password789'),
(2, 'Jacob Stewart', 'ジェイコブ スチュワート', '1994-02-21', 'jacob.stewart@example.com', '111111111', 'jacobstewart', 'password123'),
(3, 'Natalie Morris', 'ナタリー モリス', '1988-07-06', 'natalie.morris@example.com', '222222222', 'nataliemorris', 'password456'),
(4, 'Ethan Powell', 'イーサン パウエル', '1992-12-19', 'ethan.powell@example.com', '333333333', 'ethanpowell', 'password789'),
(5, 'Isabella Brooks', 'イザベラ ブルックス', '1993-05-03', 'isabella.brooks@example.com', '444444444', 'isabellabrooks', 'password123'),
(6, 'Liam Davis', 'リアム デービス', '1989-09-16', 'liam.davis@example.com', '555555555', 'liamdavis', 'password456'),
(2, 'Avery Mitchell', 'エイブリー ミッチェル', '1991-12-31', 'avery.mitchell@example.com', '666666666', 'averymitchell', 'password789'),
(2, 'Harper Anderson', 'ハーパー アンダーソン', '1994-06-14', 'harper.anderson@example.com', '777777777', 'harperanderson', 'password123'),
(2, 'Daniel White', 'ダニエル ホワイト', '1990-11-27', 'daniel.white@example.com', '888888888', 'danielwhite', 'password456'),
(3, 'Sophia Thompson', 'ソフィア トンプソン', '1988-03-12', 'sophia.thompson@example.com', '999999999', 'sophiathompson', 'password789');


INSERT INTO employees_certifications (employee_id, certification_id, start_date, end_date, score)
VALUES (1, 1, '2022-01-01', '2022-12-31', 95.5),
(2, 1, '2022-01-01', '2022-12-31', 90),
(3, 1, '2022-01-01', '2022-12-31', 100),
(4, 1, '2022-01-01', '2022-12-31', 100),
(5, 1, '2022-01-01', '2022-12-31', 90),
(6, 1, '2022-01-01', '2022-12-31', 95.5)
;