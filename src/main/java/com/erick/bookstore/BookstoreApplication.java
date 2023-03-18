package com.erick.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erick.bookstore.domain.Categoria;
import com.erick.bookstore.domain.Livro;
import com.erick.bookstore.repositories.CategoriaRepository;
import com.erick.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática", "Livros de TI");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert C. Martin", "Lorem Ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
