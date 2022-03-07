package com.dao;

import java.util.Date;
import java.util.List;

import com.bean.Book;

public interface BookDao {

	
	 List<Book> addBook(Book book); 
	 Book updateBook(int qty, float price);
     List<Book>removeOldBooks();
     List<Book>availableBooksBySubject(String subject);
     List<Book>availableBooksByAuthor(String author);
     List<Book>availableBooks(float price);
     Book findBookByID(long id);
     Book findBookBysubject(long id);
     Book availableCheckParticularCount();      
     List<Book>booksToBeOrdered();
     void saleReportOnDate(Date date);
      void saleReportOnDate(Date date1, Date date2);
      List<Book> bookQuantityReportBySubject();
}
