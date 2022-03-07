package com.service;

import java.util.Date;
import java.util.List;

import com.bean.Book;
import com.dao.BookDao;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> addBook(Book book) {
		
		
		return null;
	}

	@Override
	public Book updateBook(int qty, float price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> removeOldBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> availableBooksBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> availableBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> availableBooks(float price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookBysubject(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book availableCheckParticularCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> booksToBeOrdered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saleReportOnDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saleReportOnDate(Date date1, Date date2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> bookQuantityReportBySubject() {
		// TODO Auto-generated method stub
		return null;
	}

}
