package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.dto.Book;
import org.junit.jupiter.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

class BookServiceTest {

    private static final Logger logger =
            LogManager.getLogger(BookServiceTest.class);

    private BookService bookService;
    private BookDao bookDao;

    @BeforeAll
    static void beforeAll() {
        System.out.println("=== Starting BookService Tests ===");
    }

    @BeforeEach
    void setUp() {
        logger.info("Setting up test...");
        bookDao = mock(BookDao.class);
        bookService = new BookService(bookDao);
    }

    @AfterEach
    void tearDown() {
        logger.info("Test completed.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("=== All tests finished ===");
    }

    // addBook() Tests

    @Test
    void shouldAddBookSuccessfully() throws Exception {
        logger.info("Starting addBook positive test...");

        Book book = new Book(0, "ISBN123", "Clean Code", "Robert Martin", 500);
        when(bookDao.addBook(book)).thenReturn(book);

        Book result = bookService.addBook(book);

        assertNotNull(result);
        assertEquals("Clean Code", result.getTitle());

        logger.info("Book added successfully");
    }

    @Test
    void shouldThrowExceptionWhenPriceIsInvalid() {
        logger.info("Starting addBook negative test - invalid price");

        Book book = new Book(0, "ISBN124", "Bad Book", "Author", -10);

        assertThrows(IllegalArgumentException.class,
                () -> bookService.addBook(book));
    }

    @Test
    void shouldThrowExceptionWhenTitleIsEmpty() {
        logger.info("Starting addBook negative test - empty title");

        Book book = new Book(0, "ISBN125", "", "Author", 100);

        assertThrows(IllegalArgumentException.class,
                () -> bookService.addBook(book));
    }

    //  getBookById() Tests

    @Test
    void shouldReturnBookWhenIdExists() throws Exception {
        logger.info("Starting getBookById positive test...");

        Book book = new Book(1, "ISBN111", "Java Basics", "James", 300);
        when(bookDao.getBookById(1)).thenReturn(book);

        Book result = bookService.getBookById(1);

        assertNotNull(result);
        assertEquals("Java Basics", result.getTitle());
        assertEquals(300, result.getPrice());
    }

    @Test
    void shouldThrowExceptionWhenIdIsInvalid() {
        logger.info("Starting getBookById negative test...");

        assertThrows(IllegalArgumentException.class,
                () -> bookService.getBookById(0));
    }

    // updateBook() Tests 

    @Test
    void shouldUpdateBookSuccessfully() throws Exception {
        logger.info("Starting updateBook positive test...");

        Book updatedBook = new Book(1, "ISBN999", "Updated Title", "New Author", 600);

        doNothing().when(bookDao).updateBook(1, updatedBook);

        bookService.updateBook(1, updatedBook);

        verify(bookDao, times(1)).updateBook(1, updatedBook);
    }

    @Test
    void shouldFailUpdateWhenBookIsInvalid() {
        logger.info("Starting updateBook negative test...");

        Book invalidBook = new Book(1, "ISBN000", null, "Author", 100);

        assertThrows(IllegalArgumentException.class,
                () -> bookService.updateBook(1, invalidBook));
    }

    // deleteBook() Tests

    @Test
    void shouldDeleteBookSuccessfully() throws Exception {
        logger.info("Starting deleteBook positive test...");

        doNothing().when(bookDao).deleteBook(1);

        bookService.deleteBook(1);

        verify(bookDao, times(1)).deleteBook(1);
    }

    @Test
    void shouldThrowExceptionWhenDeletingInvalidId() {
        logger.error("Book not found for deletion");

        assertThrows(IllegalArgumentException.class,
                () -> bookService.deleteBook(-1));
    }

    //  getAllBooks() Tests 
    @Test
    void shouldReturnAllBooks() throws Exception {
        logger.info("Starting getAllBooks positive test...");

        List<Book> books = List.of(
                new Book(1, "ISBN1", "Book One", "A", 100),
                new Book(2, "ISBN2", "Book Two", "B", 200)
        );

        when(bookDao.getAllBooks()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        assertEquals(2, result.size());
        assertEquals("Book One", result.get(0).getTitle());
    }

    @Test
    void shouldReturnEmptyListWhenNoBooksExist() throws Exception {
        logger.info("Starting getAllBooks negative test...");

        when(bookDao.getAllBooks()).thenReturn(List.of());

        List<Book> result = bookService.getAllBooks();

        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
