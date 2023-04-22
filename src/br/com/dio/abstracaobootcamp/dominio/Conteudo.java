package br.com.dio.abstracaobootcamp.dominio;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    protected String titulo;
    protected String descricao;

    public String getTitulo() {
        return titulo;
    }
    public String getDescicao() {
        return descricao;
    }
}
