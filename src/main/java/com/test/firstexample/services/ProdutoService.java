package com.test.firstexample.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.firstexample.model.Produto;
import com.test.firstexample.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
    * Método para retornar uma lista de produtos
    * @return lista de produtos
    */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado 
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.obterPorId(id);
    }

    /**
     * Método para adicionar produto na lista
     * @param produto que será adicionado
     * @return o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
       return produtoRepository.adicionar(produto);
    }
    
    /**
     * Método para deletar o produto por Id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
       produtoRepository.deletar(id);
    }

    /**
     * Método para atualizar o produto na lista
     * @param produto que será atualizado
     * @param id id do produto
     * @return o produto após atualizar a lista
     */
    public Produto atualizar(Integer id, Produto produto){

        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }
}
