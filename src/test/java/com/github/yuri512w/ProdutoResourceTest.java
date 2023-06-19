package com.github.yuri512w;

import com.github.yuri512w.dto.CadastrarProdutoDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ProdutoResourceTest {

    @Test
    public void testBuscarTodosProdutos() {
        given()
                .when().get("/produtos")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0));
    }

    @Test
    public void testCadastrarProduto() {
        CadastrarProdutoDTO dto = new CadastrarProdutoDTO();
        dto.setNome("Produto Teste");
        dto.setValor(10.0);

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/produtos")
                .then()
                .statusCode(200)
                .body(is("Produto cadastrado com sucesso"));
    }

    @Test
    public void testAlterarProduto() {
        CadastrarProdutoDTO dto = new CadastrarProdutoDTO();
        dto.setNome("Produto Teste Atualizado");
        dto.setValor(20.00);

        given()
                .pathParam("id", 1)
                .body(dto)
                .contentType(ContentType.JSON)
                .when().put("/produtos/{id}")
                .then()
                .statusCode(200)
                .body(is("Produto alterado com sucesso"));
    }

    @Test
    public void testDeletarProduto() {
        given()
                .pathParam("id", 1)
                .when().delete("/produtos/{id}")
                .then()
                .statusCode(200)
                .body(is("produto deletado"));
    }
}
