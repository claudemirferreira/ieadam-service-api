package br.com.setebit.sgr.util;

public enum PathRelatorios {
	RELATORIO_SECRETARIA_DEBITO("RelatorioDebitoSecretaria.jasper"), 
	RELATORIO_SECRETARIA_ESTATISTICO("RelatorioEstatistico.jasper"), 
	RELATORIO_SECRETARIA_MEMBROS("RelatorioFichaMembro.jasper"),
	RELATORIO_SECRETARIA_DEBITO_PASTORAL("RelatorioDebitoPastoral.jasper"),    
	RELATORIO_TESOURARIA_SALDO_CONGREGACAO("RelatorioSaldoCongregacao.jasper"),
	RELATORIO_TESOURARIA_PROVENTOS_PASTORAL("RelatorioDemonstrativoProventos.jasper"),
	RELATORIO_TESOURARIA_DEBITO_FINANCEIRO("RelatorioDebitoFinanceiro.jasper"),
	
	RELATORIO_SECRETARIA_DEBITO_ACAO("GERACAO DE RELATORIO DEBITO SECRETARIA"), 
	RELATORIO_SECRETARIA_ESTATISTICO_ACAO("GERACAO DE RELATORIO ESTATISTICO"),
	RELATORIO_SECRETARIA_MEMBROS_ACAO("GERACAO DE FICHA DE MEMBRO"),
	RELATORIO_SECRETARIA_DEBITO_PASTORAL_ACAO("GERACAO DE RELATORIO SECRETARIA DEBITO PASTORAL"),    
	RELATORIO_TESOURARIA_SALDO_CONGREGACAO_ACAO("GERACAO DE RELATORIO TESOURARIA SALDO CONGREGACAO"),
	RELATORIO_TESOURARIA_PROVENTOS_PASTORAL_ACAO("GERACAO DE RELATORIO TESOURARIA PROVENTOS PASTORAL"),
	RELATORIO_TESOURARIA_DEBITO_FINANCEIRO_ACAO("GERACAO DE RELATORIO TESOURARIA DEBITO FINANCEIRO"); 
	
    private final String nome;

    PathRelatorios(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
