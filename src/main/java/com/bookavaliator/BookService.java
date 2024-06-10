package com.bookavaliator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.bookavaliator.model.Book;
// import com.bookavaliator.EntityManagerUtil;

public class BookService {
    
    // public static Book getBookById(Long bookId) {
    //     EntityManager entityManager = EntityManagerUtil.getEntityManager();
    //     try {
    //         String jpql = "SELECT b FROM Book b WHERE b.id = :bookId";
    //         TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
    //         query.setParameter("bookId", bookId);
    //         return query.getSingleResult();
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //         return null;
    //     } finally {
    //         entityManager.close();
    //     }
    // }
}

