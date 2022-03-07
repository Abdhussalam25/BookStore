package com.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	
@Entity
@Table(name="book")
public class Book {
       
	  @Id
	
	  @GeneratedValue(strategy=GenerationType.SEQUENCE)
	   private Long bookId; 	  
	  
      private String subject; 
      private String title;
      private String author;
      private String publication;
      private String edition;
      private float price;
      
		public Book() {
			super();
		}

		public Book(Long bookId, String subject, String title, String author, String publication, String edition,
				float price) {
			super();
			this.bookId = bookId;
			this.subject = subject;
			this.title = title;
			this.author = author;
			this.publication = publication;
			this.edition = edition;
			this.price = price;
		}
		
		public Book( String subject, String title, String author, String publication, String edition,
				float price) {
			super();
			
			this.subject = subject;
			this.title = title;
			this.author = author;
			this.publication = publication;
			this.edition = edition;
			this.price = price;
		}

		public Long getBookId() {
			return bookId;
		}

		public void setBookId(Long bookId) {
			this.bookId = bookId;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublication() {
			return publication;
		}

		public void setPublication(String publication) {
			this.publication = publication;
		}

		public String getEdition() {
			return edition;
		}

		public void setEdition(String edition) {
			this.edition = edition;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Book  ==> bookId=" + bookId + ", subject=" + subject + ", title=" + title + ", author=" + author
					+ ", publication=" + publication + ", edition=" + edition + ", price=" + price;
		}

		
		

		
		
		
      
      
	
	
}
