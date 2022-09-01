DROP ALL OBJECTS;

CREATE TABLE IF NOT EXISTS app_user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS aws_account_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    secret_key VARCHAR(255),
    access_key VARCHAR(255),
    user_id INT
);

CREATE TABLE IF NOT EXISTS site_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    site_name VARCHAR(255),
    url VARCHAR(1000),
    aws_account_info_id INT
);

ALTER TABLE aws_account_info ADD CONSTRAINT IF NOT EXISTS fk_user_aws FOREIGN KEY (user_id) REFERENCES app_user (id);
ALTER TABLE site_info ADD CONSTRAINT IF NOT EXISTS fk_site_info_aws FOREIGN KEY (aws_account_info_id) REFERENCES aws_account_info (id);