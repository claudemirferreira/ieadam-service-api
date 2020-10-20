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


this.parametroRelatorioDTO.setZonas(new ArrayList<ZonaDTO>());
		this.parametroRelatorioDTO.setNucleos(new ArrayList<NucleoDTO>());
		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());

		// Flag para identificar se o usuario eh administrador do Sistema
		if (usuario.isZona() && usuario.isNucleo() && usuario.isArea()) {
			this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico.listarTodos()));
			this.parametroRelatorioDTO.setNucleos(NucleoDTO.toDTO(this.nucleoServico.listarTodos()));
			this.parametroRelatorioDTO.setAreas(AreaDTO.toDTO(this.areaServico.listarTodos()));
		} else {
			this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico
					.listaZonaUsuario(usuario.getId())));
			if (this.parametroRelatorioDTO.getZonas().size() == 1) {
				this.parametroRelatorioDTO.setZona(this.parametroRelatorioDTO.getZonas().iterator().next());
				this.atualizarNucleo();
			} else if (this.parametroRelatorioDTO.getZonas().size() > 1){
				//lista todos os nucleo de todas as zonas do usuario
				this.parametroRelatorioDTO.setNucleos( nucleoServico.listaNucleos(this.parametroRelatorioDTO.getZonas()));
				//lista todas as areas de todos as nucleos do usuario
				this.parametroRelatorioDTO.setAreas( areaServico.listaAreas(this.parametroRelatorioDTO.getNucleos()));
			} 
			
			if (this.parametroRelatorioDTO.getNucleos().size() == 1) {
				this.parametroRelatorioDTO.setNucleo(this.parametroRelatorioDTO.getNucleos().iterator().next());
				this.atualizarArea();
			}
//			if ( usuario.isNucleo() ) {
//				this.parametroRelatorioDTO.getNucleos().addAll(this.nucleoServico.listaNucleoToUsuario(usuario.getId()));
//				if (this.parametroRelatorioDTO.getNucleos().size() == 1) {
//					this.parametroRelatorioDTO.setNucleo(this.parametroRelatorioDTO.getNucleos().iterator().next());
//				}
//			}
			if ( usuario.isArea() ) {
				this.parametroRelatorioDTO.getAreas().addAll( this.usuarioAreaServico.findAreaByUsuario(usuario.getId()));
				
				if (this.parametroRelatorioDTO.getAreas().size() == 1) {
					this.parametroRelatorioDTO.setArea(this.parametroRelatorioDTO.getAreas().iterator().next());
					this.parametroRelatorioDTO.setNucleo(this.parametroRelatorioDTO.getArea().getNucleo());
					this.parametroRelatorioDTO.setZona(this.parametroRelatorioDTO.getArea().getNucleo().getZona());
					
					this.parametroRelatorioDTO.getNucleos().add(this.parametroRelatorioDTO.getArea().getNucleo());
					this.parametroRelatorioDTO.getZonas().add(this.parametroRelatorioDTO.getArea().getNucleo().getZona());
				}
			}else if ( usuario.isNucleo() ){
				this.parametroRelatorioDTO.getNucleos().addAll( NucleoDTO.toDTOusuarioNucleo(this.usuarioNucleoRepositorio.findByUsuario(new Usuario(usuario.getId()))));
				
				if (this.parametroRelatorioDTO.getNucleos().size() == 1) {
					this.parametroRelatorioDTO.setNucleo(this.parametroRelatorioDTO.getNucleos().iterator().next());
					this.parametroRelatorioDTO.setZona(this.parametroRelatorioDTO.getNucleo().getZona());
					this.parametroRelatorioDTO.setAreas( areaServico.findByNucleo(this.parametroRelatorioDTO.getNucleo().getId()));
					
					this.parametroRelatorioDTO.getZonas().add(this.parametroRelatorioDTO.getNucleo().getZona());
				}
				
			}
		}
	}


