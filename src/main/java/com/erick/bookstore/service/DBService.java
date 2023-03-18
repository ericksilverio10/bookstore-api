package com.erick.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.bookstore.domain.Categoria;
import com.erick.bookstore.domain.Livro;
import com.erick.bookstore.repositories.CategoriaRepository;
import com.erick.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Fantasia", "Livros de Fantasia");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert C. Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Harry Potter e a Pedra Filosofal", "JK Rowling", "Lorem Ipsum", cat2);
		Livro l3 = new Livro(null, "Harry Potter e a Câmara Secreta", "JK Rowling", "Lorem Ipsum", cat2);
		Livro l4 = new Livro(null, "Harry Potter e o Prisioneiro de Azkaban", "JK Rowling", "Lorem Ipsum", cat2);
		Livro l5 = new Livro(null, "Harry Potter e o Cálice de Fogo", "JK Rowling", "Lorem Ipsum", cat2);
		Livro l6 = new Livro(null, "Harry Potter e a Ordem da Fênix", "JK Rowling", "Lorem Ipsum", cat2);
		Livro l7 = new Livro(null, "Harry Potter e o Enigma do Príncipe", "JK Rowling", "Lorem Ipsum", cat2);
		Livro l8 = new Livro(null, "Harry Potter e as Relíquias da Morte", "JK Rowling", "Lorem Ipsum", cat2);
		Livro l9 = new Livro(null, "Engenharia de Software Aplicada", "Erick Silvério", "Lorem Ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l9));
		cat2.getLivros().addAll(Arrays.asList(l2, l3, l4, l5, l6, l7, l8));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9));
	}
}
