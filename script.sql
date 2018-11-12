CREATE DATABASE QUIZ;

USE QUIZ;

CREATE TABLE PERGUNTA(
	ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	PERGUNTA VARCHAR(100),
	A VARCHAR(100),
	B VARCHAR(100),
	C VARCHAR(100),
	D VARCHAR(100),
	E VARCHAR(100),
	RESPOSTA VARCHAR(100)
);


insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Qual dos animais abaixo é mais rápido?','O Elefante','O porco','A Girafa','O gato doméstico','A cobra','A Girafa');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Que animal, em média, vive mais?','O chimpanzé','O coelho','O porco','A girafa','O rinoceronte','O rinoceronte');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Qual o animal mais pesado do mundo?','A Orca','O Elefante Asiático','O Elefante Africano','A Baleia Azul','A Baleia Branca','A Baleia Azul');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Em que parte do corpo humano você encontra uma amostra completa do seu DNA?','Nas unhas','Nos ossos','No tecido dos dedos','Nos cabelos','No coração','Nos cabelos');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Qual o maior órgão do corpo humano?','Rim','Figado','Pulmão','Pele','Cerebro','Pele');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('No esgrima, o que significa a expressão "touché"?','Morto','Toquei','Tudo acabado','Tu morreu','Morte','Toquei');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Qual é o animal terrestre mais rápido do mundo?','Coiote','Avestruz','Leão','Elefante','Guepardo','Guepardo');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Qual é a menor capital estadual do Brasil em população?','Boa Vista-RR','Macapá-AP','Rio Branco-AC ','Porto Velho-RO','Palmas-TO','Palmas-TO');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Segundo a constituição federal de 1988, qual o status atual do Arquipélago de Fernando de Noronha?','Território Federal','Distrito Estadual','Município','Estado','Município Autônomo','Distrito Estadual');
insert into PERGUNTA (PERGUNTA,a,b,c,d,e,RESPOSTA) values 
('Atualmente, existem quantos fusos horários no território brasileiro?','1','2','3','4','5','3');

CREATE TABLE JOGADOR(
  NOME VARCHAR(100),
  PONTUACAO INTEGER
);
