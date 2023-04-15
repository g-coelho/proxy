package org.example;

import java.util.List;

public class FitaProxy implements IFita{

    private Fita fita;
    private Integer registro;

    public FitaProxy(Integer registro) {
        this.registro = registro;
    }

    @Override
    public List<String> obterDados() {
        if(this.fita == null){
            this.fita = new Fita(this.registro);
        }
        return this.fita.obterDados();
    }

    @Override
    public List<Integer> obterDuracaoAvaliacao(Funcionario funcionario) {
        if(!funcionario.isAdministrador()){
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if(this.fita == null){
            this.fita = new Fita(this.registro);
        }
        return this.fita.obterDuracaoAvaliacao(funcionario);
    }
}
