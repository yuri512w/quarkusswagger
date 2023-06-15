package com.github.yuri512w.entity;

import com.github.yuri512w.enume.EnumPessoa;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Pesssoa")
public class Pessoa  extends PanacheEntity {


    public int cpf;
    public String nome;
    public String sobrenome;
    public int tipoPessoa;
}
