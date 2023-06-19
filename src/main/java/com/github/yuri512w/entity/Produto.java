package com.github.yuri512w.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table (name = "PRODUTO")
public class Produto extends PanacheEntity {

    public String nome;

    public String descricao;

    public Double valor;

    @CreationTimestamp
    public Date dataCriacao;

    @UpdateTimestamp
    public Date dataAtualizacao;

}
