USE music;

INSERT IGNORE INTO sample_table(id, string_thing, unique_string) 
VALUES (1, 'sample_string', 'qzrmn');

INSERT IGNORE INTO sample_table_2(sample_table_id, random_string)
VALUES (1, 'ASDFLKJ');