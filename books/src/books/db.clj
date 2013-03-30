(ns books.db
  (:use [korma.db]
        [korma.core]))

(defdb booksdb
  (postgres {:db "books"
             :user "books"
             :password "books"}))

(defentity author)

(defentity book
  (belongs-to author {:fk :author_id}))

(defn get-author
  "gets an author by id"
  [id]
  (first (select author (where {:id id}))))

(defn find-authors
  "finds authors by passing the supplied filter as the where parameters, filter should be a map"
  [filter]
  (select author (where filter)))

(defn get-book
  "gets a book by id"
  [id]
  (first (select book (where {:id id}))))

(defn find-books
  "finds books by passing the supplied filter as the where parameters, filter should be a map"
  [filter]
  (select book (where filter)))