package br.com.chamada.controller.mapping;

public interface IController {
	String CONTEXTO_API = "/api";
	String CONTEXTO_ALUNO = CONTEXTO_API + "/alunos";
	String CONTEXTO_USUARIO = CONTEXTO_API + "/usuarios";
	String CONTEXTO_PROFESSOR = CONTEXTO_API + "/professores";
	String CONTEXTO_TURMA = CONTEXTO_API + "/turmas";
	String CONTEXTO_CHAMADA = CONTEXTO_API + "/chamadas";
	String PATH_ID = "/{id}";
	String ID = "id";
}