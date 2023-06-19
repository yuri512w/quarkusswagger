package com.github.yuri512w;

import com.github.yuri512w.dto.PessoaDTO;
import com.github.yuri512w.entity.Pessoa;
import com.github.yuri512w.entity.Produto;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;


@Path("pessoas")
@Tag(name = "Pessoas", description = "Operações relacionadas a produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @GET
    @Operation(summary = "Buscar todos os produtos")
    public List<Pessoa> buscarTodasPessoas() {
        return Pessoa.listAll();
    }

    @POST
    @Transactional
    @Operation(summary = "Cadastrar pessoa")
    public Response cadastrarPessoa(PessoaDTO dto) {
        Pessoa p = new Pessoa();
        p.nome = dto.nome;
        p.cpf = dto.cpf;
        p.sobrenome= dto.sobrenome;
        p.persist();

        return Response.ok("{\"message\": \"cadastrado com sucesso\"}").build();

    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deletar cliente")
    public Response deletarCliente(@PathParam("id") Long id) {

        Optional<Pessoa> PessoaOp = Pessoa.findByIdOptional(id);
        if(PessoaOp.isPresent()) {
            return Response.ok("{\"message\": \"deletado com sucesso\"}").build();
        }else{throw new NotFoundException();}

    }
}
