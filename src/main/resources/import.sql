----adicione um usuário
insert into curso (nome) values ('Sistemas')
insert into curso (nome) values ('Ciencias')

insert into turma (ano_inicio, curso_id) values ('20190101', 1)
insert into turma (ano_inicio, curso_id) values ('20190101', 2)

insert into aluno (email, nome, senha, turma_id) values ('lucas@gostoso.com', 'Lucasso', '123456', 1)

insert into disciplina (nome) values ('Redes')
insert into disciplina (nome) values ('Arquitetura')

insert into turma_disciplina (turma_id, disciplina_id) values (1, 1)
insert into turma_disciplina (turma_id, disciplina_id) values (1, 2)

insert into aula (data, disciplina_id) values ('20190102', 1)
insert into aula (data, disciplina_id) values ('20190103', 1)
insert into aula (data, disciplina_id) values ('20190104', 1)
insert into aula (data, disciplina_id) values ('20190105', 1)

insert into presenca_aluno (presente, aluno_id, aula_id) values (false, 1, 1)

insert into presenca_aluno (presente, aluno_id, aula_id) values (true, 1, 3)

--insert into tb_jogador (usuario, senha, SESSAO_STATUS) values ('admin2', 'admin2', false)
----insert into tb_partidas (id, status) values (1, true)