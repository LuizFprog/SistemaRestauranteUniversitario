package br.com.ru.negocio;

import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioRefeicao;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.Refeicao;


public class ControladorRefeicao {
	private IRepositorioGenerico<Refeicao> repositorioRefeicao;
	private static ControladorRefeicao instancia;
	private List<Refeicao> listaRefeicao;
	
	private ControladorRefeicao() {
		this.repositorioRefeicao = new RepositorioRefeicao(listaRefeicao);
	}
	
	// Garantir unica instancia da classe
	public static ControladorRefeicao getInstancia()
	{
		if(instancia == null)
		{
			instancia = new ControladorRefeicao();
		}
		return instancia;
	}
	
	public void gerarRefeicao() throws ElementoJaExisteException
	{
	   
	    
	    for(int i = 0; i < 100; i++)
	    {
	        Refeicao novoRefeicao = new Refeicao();
	        repositorioRefeicao.inserir(novoRefeicao);
	    }
	}
	
	public Refeicao cadastrarFichaRefeicao(Ficha ficha)
	{
	    List<Refeicao> atual = repositorioRefeicao.ler(); // Modificação necessaria
	    for(Refeicao r : atual)
	    {
	        if(r.getFichas() == null)
	        {
	            r.setFichas(ficha);
	            return r;
	        }
	    }
	    
	    // fica sem retorno caso falhe
	    return null;
	}
	
	public void adicionarPratoRefeicao(ItemConsumivel prato, Refeicao refeicao) throws ElementoJaExisteException
	{
		
		if(prato != null) {
			 refeicao.inserir(prato);
		}
	    
	}
	
	public void removerPratoRefeicao(ItemConsumivel prato, Refeicao refeicao) throws ElementoNaoExisteException
	{
	    refeicao.remover(prato);
	}
	
	public List<ItemConsumivel> listarRefeicao(Refeicao refeicao)
    {
        return refeicao.getItensConsumiveis();
    }

	public void inserir(Refeicao refe) throws ElementoJaExisteException {
		
		this.repositorioRefeicao.inserir(refe);
		
	}

	public void remover(Refeicao refe) throws ElementoJaExisteException, ElementoNaoExisteException {
	
		this.repositorioRefeicao.remover(refe);
		
	}


   
}
