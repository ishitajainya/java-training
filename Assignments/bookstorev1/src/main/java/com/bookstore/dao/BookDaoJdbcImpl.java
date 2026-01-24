package com.bookstore.dao; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import com.bookstore.dto.Book; 
import com.bookstore.exceptions.DaoException; 
import com.bookstore.util.ConnectionFactory;
public class BookDaoJdbcImpl implements BookDao {

    private Connection con;

    public BookDaoJdbcImpl() throws DaoException {
        try {
            this.con = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            throw new DaoException("Failed to create DB connection", e);
        }
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        String sql = "INSERT INTO books(isbn, title, author, price) VALUES (?,?,?,?)";

        try (PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    book.setId(rs.getInt(1));
                }
            }
            return book;

        } catch (SQLException e) {
            throw new DaoException("Failed to add book", e);
        }
    }

    @Override
    public List<Book> getAllBooks() throws DaoException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                books.add(mapRow(rs));
            }
            return books;

        } catch (SQLException e) {
            throw new DaoException("Failed to fetch books", e);
        }
    }

    @Override
    public Book getBookById(int id) throws DaoException {
        String sql = "SELECT * FROM books WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                } else {
                    throw new DaoException("Book not found with id: " + id, null);
                }
            }

        } catch (SQLException e) {
            throw new DaoException("Failed to find book", e);
        }
    }

    @Override
    public void updateBook(int id, Book book) throws DaoException {
        String sql = "UPDATE books SET isbn=?, title=?, author=?, price=? WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, id);

            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DaoException("No book updated. Invalid ID: " + id, null);
            }

        } catch (SQLException e) {
            throw new DaoException("Failed to update book", e);
        }
    }

    @Override
    public void deleteBook(int id) throws DaoException {
        String sql = "DELETE FROM books WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DaoException("No book deleted. Invalid ID: " + id, null);
            }

        } catch (SQLException e) {
            throw new DaoException("Failed to delete book", e);
        }
    }

    public void close() throws DaoException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new DaoException("Failed to close connection", e);
        }
    }

    private Book mapRow(ResultSet rs) throws SQLException {
        return new Book(
                rs.getInt("id"),
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDouble("price")
        );
    }
}


