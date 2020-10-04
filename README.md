# FACA BACKUP DO BANDO DE DADOS
## 1 execute o script de importacao do banco de dados src/main/resources/backup.sql
## 1.1 UPDATE `saa_usuario` SET senha = '$2a$10$0bnrmA15bLbZb.LhOEGrVuFt5mAlz1FOU0hSClnBsPvRCLex1TvMi' where login = 'admin'

# alterar o nome do campo na tabela IEADAM_LOG_APP
## ALTER TABLE `ieadam_log_app` CHANGE COLUMN `usuario` `id_usuario` INT(11) DEFAULT NULL;


## configure o usuario e senha no arquivo application.properties
## crie o usuario no banco de dados
## database= sgr_test
## username = root
## password = root12!@

# mvn install

# mvn clean install && java -jar ieadam-service-app-0.0.1-SNAPSHOT.jar

# Atualizar as rotinas 
# http://localhost:8080/api/script/atualizar-rotinas

# Atualização de Senha

## criptografa a senha de todos os usuario
## http://localhost:8080/api/script/atualizar-senhas/

## seta a senha ieadam para o usuario admin
## http://localhost:8080/api/script/atualizar-senhas/admin

# PENDÊNCIA



-----
# relatorio de membro
## 	- remover o botao imprimir da listagem
## 	- incluir todos os campos no detalhe
# Geral 
## 	- incluir o botao voltar em todas as telas.
## 	- Layout dos campos de todas as telas.
## 		- tamanho dos campos.
## 		- Cores do sistema
## 		- icones
## 		- logo
	
## ---RELATORIO COM ERRO
# RelatorioEstatistico -> PROCEDURE SIIAD.dbo.STP_EXPORTA_REL_EST_TER não existe


Reunião ieadam (26/09)

Parâmetros de teste:     
        Login com pastor de área (38364)

Problema 1:

1. não está carregando a área no combo (não exibe)

2. Os filtros não estão sendo aplicados na geração do relatório 

Obs. Apenas funciona quando se usa o Adm

Obs2. Todos os relatório estão com o mesmo problema

*********

Problema 2:

os filtros não estão funcionando (quando o usuário seleciona a região.... o combo de área não carrega nada

