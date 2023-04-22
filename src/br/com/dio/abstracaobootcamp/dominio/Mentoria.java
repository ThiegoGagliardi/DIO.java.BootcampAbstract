package br.com.dio.abstracaobootcamp.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo implements ConteudoComCalculoXP {
    private LocalDate data;
    public Mentoria (String titulo, String descricao, LocalDate data)
    {
        super.titulo     = titulo;
        super.descricao  = descricao;
        this.data        = data;
    }
    public LocalDate getData()
    {
        return this.data;
    }
    @Override
    public String toString()
    {
        return "Mentoria{"   +
                "titulo="    + this.titulo    +
                "descricao=" + this.descricao +
                "data="      + this.data      +
                '}';
    }
    @Override
    public int hashCode()
    {
       return titulo.hashCode() + data.hashCode();
    }

    @Override
    public boolean equals(Object obj){

        if (obj == null){
            return false;
        }

        return (obj.hashCode() == this.hashCode());
    }

    @Override
    public double calcularXP() {
        return super.XP_PADRAO + 20;
    }
}
