package br.com.dio.abstracaobootcamp.dominio;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Collections;
import java.util.List;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;
    private Set<Dev>  devsInscritos = new HashSet<>();
    private Set<ConteudoComCalculoXP> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao, LocalDate dataInicial)
    {
        this.nome        = nome;
        this.descricao   = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal   = this.dataInicial.plusDays(45l);
    }
    public String getNome()
    {
        return this.nome;
    }
    public String getDescricao()
    {
        return this.descricao;
    }
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    public LocalDate getDataFinal() {
        return dataFinal;
    }
    public Set<ConteudoComCalculoXP> getConteudos()
    {
       return Collections.unmodifiableSet(conteudos);
    }
    public Set<Dev> getDevInscritos()
    {
        return Collections.unmodifiableSet(devsInscritos);
    }
    public void adicionarConteudo(ConteudoComCalculoXP conteudo)
    {
        if (! conteudos.contains(conteudo)) {
            conteudos.add(conteudo);
        }
    }
    public void inscreverDev(Dev novoDevInscrito)
    {
        if (! devsInscritos.contains(novoDevInscrito)) {
            devsInscritos.add(novoDevInscrito);
            novoDevInscrito.inscreverBootcamp(this);
        } else {
            System.err.println("Já matriculado.");
        }
    }

    public List<Dev> getDevsOrdenadosXP()
    {
        Comparator<Dev> comparaporXp = new Comparator<Dev>() {
            @Override
            public int compare(Dev d1, Dev d2) {
                if (d1.getTotalXp() > d2.getTotalXp()) {
                    return -1;
                } else if (d1.getTotalXp() < d2.getTotalXp())
                {
                    return 1;
                }
                return 0;
            }
        };

        List<Dev> devsOrdenados = devsInscritos.stream().collect(Collectors.toList());
        Collections.sort(devsOrdenados, comparaporXp);
        return Collections.unmodifiableList(devsOrdenados);
    }
}
