package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;

	private final BookRepository bookRepository;
	
	private final PublisherRepository publisherRepository;

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher("SFG Publication", "SFG Publication", "Mumbai", "Maharashtra", "401305");
		publisherRepository.save(publisher);
		
		Author author = new Author("Eric", "Evans");
		Book book = new Book("Domain dirven Design", "1232123");
		author.getBooks().add(book);
		book.getAuthors().add(author);
		book.setPublisher(publisher);
		authorRepository.save(author);
		bookRepository.save(book);
		
		Author author1 = new Author("Rod", "Johnson");
		Book book1 = new Book("J2EE Development without EJB", "290384014");
		author.getBooks().add(book1);
		book.getAuthors().add(author1);
		book1.setPublisher(publisher);
		authorRepository.save(author1);
		bookRepository.save(book1);
		publisher.getBooks().add(book);
		publisher.getBooks().add(book1);
		publisherRepository.save(publisher);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books "+bookRepository.count());
		System.out.println("Number of Books for the Publisher "+publisher.getBooks().size());
		
	}

}
