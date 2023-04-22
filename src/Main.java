import java.time.LocalDate;

import br.com.dio.abstracaobootcamp.dominio.*;

public class Main {
    public static void main(String[] args) {

        ConteudoComCalculoXP curso     = new Curso("Java","java",8);
        ConteudoComCalculoXP mentoria  = new Mentoria("Java Collections", "java Collections", LocalDate.now());

        Dev dev1  = new Dev("João");
        Dev dev2 = new Dev("Maria");
        dev2.progredir();

        Bootcamp TQIJava = new Bootcamp("TQI-Java", "Programa gratuito para formação de profissionais que estão iniciando sua carreira e buscam mais conhecimento técnico em desenvolvimento back-end.", LocalDate.now());
        TQIJava.adicionarConteudo(curso);
        TQIJava.adicionarConteudo(mentoria);

        TQIJava.inscreverDev(dev1);
        TQIJava.inscreverDev(dev2);
        TQIJava.inscreverDev(dev2);

        System.out.println("Criado bootcamp:" + TQIJava.getNome());
        System.out.println("-- Com os conteudos: "+ TQIJava.getConteudos());
        System.out.println("-- Inicio:"+ TQIJava.getDataInicial());
        System.out.println("-- Prazo para finalizaacao:"+ TQIJava.getDataFinal());
        System.out.println("Inscritos:"+TQIJava.getDevInscritos());

        dev1.progredir();
        System.out.println("Dev:"+ dev1.getNome());
        System.out.println("Finalizou conteudo:"+ dev1.getConteudoConcluido());
        System.out.println("Total de xp:" + dev1.getTotalXp());

        dev2.progredir();
        dev2.progredir();
        System.out.println("Dev:"+ dev2.getNome());
        System.out.println("Finalizou conteudo:"+ dev2.getConteudoConcluido());
        System.out.println("Total de xp:" + dev2.getTotalXp());

        System.out.println("Devs ordenados por xp:" + TQIJava.getDevsOrdenadosXP());
    }
}