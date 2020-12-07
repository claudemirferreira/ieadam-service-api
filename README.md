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

50344 1 area
2155  2 area
12580 1 nucleo
3235 2 nucleo

