USE music;

--Sample table

CREATE TABLE IF NOT EXISTS sample_table(
	id					INT AUTO_INCREMENT NOT NULL,
	string_thing 		VARCHAR(256) NOT NULL,
	unique_string 		VARCHAR(256) NOT NULL UNIQUE,
	PRIMARY KEY(id)

);

CREATE TABLE IF NOT EXISTS sample_table_2(
	id					INT AUTO_INCREMENT NOT NULL,
	sample_table_id		VARCHAR(256) NOT NULL,
	random_string		VARCHAR(256),
	PRIMARY KEY(id)
	FOREIGN KEY(sample_table_id) REFERENCES sample_table(id)

);