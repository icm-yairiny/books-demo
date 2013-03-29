insert into author(first_name, last_name) values ('Ernest', 'Hemingway');
insert into author(first_name, last_name) values ('John', 'Steinback');

insert into book(author_id, title, description)
       values((select id from author where last_name = 'Steinback'), 'Of Mice and Men',
                      'A tragic story set in 1930s America');

insert into book(author_id, title, description)
       values((select id from author where last_name = 'Steinback'), 'The Grapes of Wrath',
                      'The story of a sharecropper family set in the Great Depression');

insert into book(author_id, title, description)
       values((select id from author where last_name = 'Hemingway'), 'A Farewell to Arms',
                      'A novel set in the WWI Italian campaign');

insert into book(author_id, title, description)
       values((select id from author where last_name = 'Hemingway'), 'For Whom the Bell Tolls',
                      'The story of a young American in the Spanish Civil War');

insert into book(author_id, title, description)
       values((select id from author where last_name = 'Hemingway'), 'The Old Man and the Sea',
                      'An aging fisherman struggles with a giant marlin');
