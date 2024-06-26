package com.bookavaliator;

import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;
import java.util.Map;

public class BookSearcher {
    
    public List<Map<String, String>> searchBooks(String filter) {
        Session session = HibernateUtil
            .getSessionFactory()
            .openSession();
        Query query = session
            .createQuery("SELECT new map(b.title as title, b.author as author) FROM Book b WHERE lower(b.title) LIKE :query OR lower(b.author) LIKE :query");
        query.setParameter("query", "%" + filter.toLowerCase() + "%");
        List<Map<String, String>> results = query.list();
        session.close();
        return results;
    }

}