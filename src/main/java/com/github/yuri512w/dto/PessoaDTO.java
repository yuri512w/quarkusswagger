package com.github.yuri512w.dto;

import com.github.yuri512w.enume.EnumPessoa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {

    public int cpf;
    public String nome;
    public String sobrenome;
    public EnumPessoa tipoPessoa;

}
