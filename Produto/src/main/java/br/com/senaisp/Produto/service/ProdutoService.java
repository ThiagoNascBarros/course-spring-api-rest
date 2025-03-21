package br.com.senaisp.Produto.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

import br.com.senaisp.Produto.model.Produto;

@Service
public class ProdutoService {

	public void addProdutoText(Produto produto) throws Exception {
		
		String nomeArg = "produto" + produto.getId() + ".txt";
		String caminhoArg = "C:\\Temp\\produtos\\";
		
			try {
				FileWriter arq = new FileWriter(caminhoArg + nomeArg);
				PrintWriter pw = new PrintWriter(arq);
				pw.print(produto.getId() + "; ");
				pw.print(produto.getNome() + "; ");
				pw.print(produto.getPreco() + "; ");
				pw.print(produto.getEmail() + "; ");
				pw.print(produto.getQntd());
				
				pw.close();
			} catch (IOException e) {
				throw new Exception("Erro ao tentar gravar o arquivo");
			}			
		
	}
}
