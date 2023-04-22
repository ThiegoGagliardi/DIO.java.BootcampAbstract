package br.com.dio.abstracaobootcamp.dominio;

public class Curso extends Conteudo implements ConteudoComCalculoXP {

    private int cargaHoraria;

    public Curso(String titulo,String descricao, int cargaHoraria)
    {
        super.titulo       = titulo;
        super.descricao    = descricao;
        this.cargaHoraria  = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString()
    {
        return "Curso{"+
               "Titulo="       + this.titulo  +
               "Descicao="     + this.descricao +
               "Cargahoraria=" + Integer.toString(this.cargaHoraria)+
                '}';
    }
    @Override
    public int hashCode()
    {
        return titulo.hashCode() + cargaHoraria;
    }

    @Override
    public double calcularXP()
    {
        return super.XP_PADRAO * this.cargaHoraria;
    }
}
