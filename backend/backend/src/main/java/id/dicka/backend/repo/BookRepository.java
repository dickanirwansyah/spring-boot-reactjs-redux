package id.dicka.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import id.dicka.backend.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
