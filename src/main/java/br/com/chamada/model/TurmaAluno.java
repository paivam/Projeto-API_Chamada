package br.com.chamada.model;


import java.util.List;

public class TurmaAluno{
    Turma turma;

    List<Aluno> alunos;

    public void setTurma(Turma turma){
        this.turma = turma;
    }

    public Turma getTurma(){
        return this.turma;
    }

    public void setAlunos(List<Aluno> alunos){
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos(){
        return this.alunos;
    }
}