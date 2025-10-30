
package com.exemplo.springcrud.repository;

import com.exemplo.springcrud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
