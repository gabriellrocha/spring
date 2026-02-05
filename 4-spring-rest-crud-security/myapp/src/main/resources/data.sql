CREATE TABLE IF NOT EXISTS students (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS products (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users
    FOREIGN KEY (username) REFERENCES users(username),
    UNIQUE KEY uk_username_authority (username, authority)
);

CREATE TABLE IF NOT EXISTS members (
    user_id VARCHAR(50) NOT NULL,
    pw VARCHAR(100) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS roles (
    user_id VARCHAR(50) NOT NULL,
    `role` VARCHAR(50) NOT NULL,
    CONSTRAINT fk_roles_users
    FOREIGN KEY (user_id) REFERENCES members(user_id),
    UNIQUE KEY uk_members_roles (user_id, role)
);
