CREATE TABLE BlogUser (
  email VARCHAR(255) NOT NULL,
  name VARCHAR(64) NOT NULL,
  password VARCHAR(64) NOT NULL,
  is_active BOOLEAN NOT NULL,
  PRIMARY KEY (email)
);

CREATE TABLE BlogPost (
  id INT NOT NULL,
  title VARCHAR(128) NOT NULL,
  content CLOB NOT NULL,
  creation_date TIMESTAMP NOT NULL,
  author_email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);