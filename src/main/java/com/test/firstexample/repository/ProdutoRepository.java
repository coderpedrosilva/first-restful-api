package com.test.firstexample.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.test.firstexample.model.Produto;

@Repository
public class ProdutoRepository {
    
    // simulando o banco de dados
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;
 
    /**
     * Método para retornar uma lista de produtos
     * @return lista de produtos
    */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado 
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> Objects.equals(produto.getId(), id))
                .findFirst();
    }

    /**
     * Método para adicionar produto na lista
     * @param produto que será adicionado
     * @return o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){

        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método para deletar o produto por Id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> Objects.equals(produto.getId(), id));
    }

    /**
     * Método para atualizar o produto na lista
     * @param produto que será atualizado
     * @return o produto após atualizar a lista
     */
    public Produto atualizar(Produto produto){

        // Encontra o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }

        // Eu tenho que remover o produto antigo da lista
        deletar(produto.getId());

        // Depois adicionar o produto atualizado na lista
        produtos.add(produto);

        return produto;
    }
}   
