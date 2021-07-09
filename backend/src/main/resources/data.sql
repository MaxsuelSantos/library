INSERT INTO tb_user (name, phone, email) VALUES ('Ana Clara', '998452545', 'ana@gmail.com');

INSERT INTO tb_publishing_company (name) VALUES ('Sextante');
INSERT INTO tb_publishing_company (name) VALUES ('Bookman');

INSERT INTO tb_genre (description) VALUES ('Informática');
INSERT INTO tb_genre (description) VALUES ('Fantasia');

INSERT INTO tb_collection (name) VALUES ('Java Oficial');

INSERT INTO tb_book (title, pages, fine_amount, publishing_company_id, genre_id, collection_id) VALUES ('Core Java', 320, 2.00, 2, 1, 1);
INSERT INTO tb_book (title, pages, fine_amount, publishing_company_id, genre_id, collection_id) VALUES ('Senhor dos Anéis', 1100, 3.00, 1, 2, null);
INSERT INTO tb_book (title, pages, fine_amount, publishing_company_id, genre_id, collection_id) VALUES ('O Hobbit', 310, 2.00, 1, 2, null);

INSERT INTO tb_loan (loan_date, return_date, book_id, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-11-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-11-22T03:00:00Z', 1, 1);
INSERT INTO tb_loan (loan_date, return_date, book_id, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-11-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-11-25T03:00:00Z', 3, 1);