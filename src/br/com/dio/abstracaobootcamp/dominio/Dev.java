package br.com.dio.abstracaobootcamp.dominio;

import java.util.Collections;
import java.util.Set;
import java.util.Optional;
import java.util.LinkedHashSet;

public class Dev {
    private String nome;

    private double totalXp;
    private Set<ConteudoComCalculoXP> conteudoInscritos = new LinkedHashSet<>();
    private Set<ConteudoComCalculoXP> conteudoConcluido = new LinkedHashSet<>();

    public Dev (String nome)
    {
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudoInscritos.addAll(bootcamp.getConteudos());
    }

    public String getNome()
    {
        return nome;
    }

    public double getTotalXp()
    {
        return totalXp;
    }

    public void progredir()
    {
        if ((conteudoInscritos.isEmpty()) && (conteudoConcluido.isEmpty()))
        {
            System.err.println("Você não está matriculado.");
        }

        Optional<ConteudoComCalculoXP> conteudo = this.conteudoInscritos.stream().findFirst();

        if (conteudo.isPresent()){
            this.conteudoConcluido.add(conteudo.get());
            this.conteudoInscritos.remove(conteudo.get());
            this.adicionarXP(conteudo.get().calcularXP());
        }
    }
    public Set<ConteudoComCalculoXP> getConteudoConcluido()
    {
        return Collections.unmodifiableSet(this.conteudoConcluido);
    }
    public void adicionarXP(double xpAdiquirido)
    {
        this.totalXp += xpAdiquirido;
    }

    @Override
    public int hashCode()
    {
        return nome.hashCode();
    }

   @Override
   public boolean equals(Object obj)
   {

       if (obj == null){
           return false;
       }

       return (obj.hashCode() == this.hashCode());
    }

    @Override
    public String toString()
    {
        return "Nome:"+ this.nome + "XP:"+Double.toString(this.totalXp);
    }
}
