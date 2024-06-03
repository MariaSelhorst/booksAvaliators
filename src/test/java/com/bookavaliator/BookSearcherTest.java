package com.bookavaliator;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query; // Alteração necessária aqui
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BookSearcherTest {

    @Test
    public void testSearchBooks() {
        // Cria um mock para SessionFactory
        SessionFactory mockedSessionFactory = mock(SessionFactory.class);

        // Cria um mock para Session
        Session mockedSession = mock(Session.class);

        // Cria um mock para Query
        org.hibernate.Query mockedQuery = mock(org.hibernate.Query.class); // Corrigido aqui

        // Define o comportamento do mock de SessionFactory para retornar o mock de
        // Session
        when(mockedSessionFactory.openSession()).thenReturn((org.hibernate.classic.Session) mockedSession); // Corrigido aqui

        // Define o comportamento do mock de Session para retornar o mock de Query
        when(mockedSession.createQuery(anyString())).thenReturn(mockedQuery);

        // Define o comportamento do mock de Query para retornar uma lista vazia
        when(mockedQuery.list()).thenReturn(Collections.emptyList());

        // Cria uma instância de BookSearcher com o mock de SessionFactory
        BookSearcher bookSearcher = new BookSearcher(mockedSessionFactory);

        // Chama o método a ser testado
        List<Map<String, String>> results = bookSearcher.searchBooks("Harry Potter");

        // Verifica se o método retornou uma lista vazia
        assertNotNull(results);
        assertTrue(results.isEmpty());
    }
}