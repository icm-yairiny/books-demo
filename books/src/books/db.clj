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
