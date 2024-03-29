package br.com.cadmus.solicitacaoServico.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.cadmus.solicitacaoServico.Repository.SolicitacaoRepository;
import br.com.cadmus.solicitacaoServico.domain.SolicitacaoCliente;

@Service
public class SolicitacaoClienteService {

	@Autowired
	SolicitacaoRepository solicitacaoRepo;
	
	
	public SolicitacaoCliente criar(String msg) {
		SolicitacaoCliente solicitacao = new SolicitacaoCliente();
		solicitacao.setMensagemSolicitacao(msg);
		return solicitacaoRepo.save(solicitacao);
	}
	
	public Page<SolicitacaoCliente> listarSolicitacoes(Integer pageAtual, Integer tamanho){
		Page<SolicitacaoCliente> page = solicitacaoRepo.findAll(PageRequest.of(pageAtual, tamanho));
		
		return page;
	}
	
}
