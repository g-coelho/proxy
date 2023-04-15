package org.example;

import java.util.Arrays;
import java.util.List;

public class Fita implements IFita{
    private Integer registro;
    private String titulo;
    private String dublagem;
    private Integer duracao;
    private Integer avaliacao;

    public Fita(int registro){
        this.registro = registro;
        Fita objeto = BD.getFita(registro);
        this.titulo = objeto.titulo;
        this.dublagem = objeto.dublagem;
        this.duracao = objeto.duracao;
        this.avaliacao = objeto.avaliacao;
    }

    public Fita(Integer registro, String titulo, String dublagem, Integer duracao, Integer avaliacao){
        this.registro = registro;
        this.titulo = titulo;
        this.dublagem = dublagem;
        this.duracao = duracao;
        this.avaliacao = avaliacao;
    }

    public Integer getRegistro(){
        return registro;
    }


    @Override
    public List<String> obterDados() {
        return Arrays.asList(this.titulo, this.dublagem);
    }

    @Override
    public List<Integer> obterDuracaoAvaliacao(Funcionario funcionario) {
        return Arrays.asList(this.duracao, this.avaliacao);
    }
}
