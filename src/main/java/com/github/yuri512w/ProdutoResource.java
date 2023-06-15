package com.github.yuri512w;

import com.github.yuri512w.dto.CadastrarProdutoDTO;
import com.github.yuri512w.entity.Produto;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@Path("produtos")
@Tag (name = "Produtos", description = "Operações relacionadas a produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    @Operation (summary = "Buscar todos os produtos")
    public List<Produto> buscarTodosProdutos() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    @Operation(summary = "Cadastrar um novo produto")
    public Response cadastrarProduto(CadastrarProdutoDTO dto) {
        Produto p = new Produto();
        p.nome = dto.nome;
        p.valor = dto.valor;
        p.persist();

        return Response.ok("Produto cadastrado com sucesso").build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = " Alterar um produto")
    public Response alterarProduto(@PathParam("id") Long id, CadastrarProdutoDTO dto) {

        Optional<Produto> produtoOp = Produto.findByIdOptional(id);

        if (produtoOp.isPresent()) {
            Produto produto = produtoOp.get();
            produto.nome = dto.nome;
            produto.valor = dto.valor;
            produto.persist();
            return Response.ok("Produto alterado com sucesso").build();
        } else {
            throw new NotFoundException();
        }

    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deletar um  produto")
    public Response deletarProduto(@PathParam("id") Long id) {

        Optional<Produto> produtoOp = Produto.findByIdOptional(id);
        if(produtoOp.isPresent()) {
            return Response.ok("produto deletado").build();
        }else{throw new NotFoundException();}

    }

}
