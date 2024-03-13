
package br.com.pyetro.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.pyetro.controller.PessoaController;
import br.com.pyetro.domain.Pessoa;
import br.com.pyetro.exceptions.DAOException;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;
import br.com.pyetro.service.IPessoaService;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PessoaControllerTest {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private IPessoaService pessoaService;

    @Mock
    private FacesContext facesContext;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInit() throws DAOException {
        // Simulando o retorno do serviço
        Collection<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa());
        pessoas.add(new Pessoa());
        pessoas.add(new Pessoa());

        // Definindo o comportamento esperado do serviço
        when(pessoaService.buscarTodos()).thenReturn(pessoas);

        // Chamando o método a ser testado
        pessoaController.init();

        // Verificando se as pessoas foram carregadas corretamente
        assertNotNull(pessoaController.getPessoas());
        assertEquals(3, pessoaController.getPessoas().size());
    }

    @Test
    public void testCancel() {
        // Chamando o método a ser testado
        pessoaController.cancel();

        // Verificando se a pessoa foi resetada corretamente
        assertNull(pessoaController.getPessoa());
        assertFalse(pessoaController.getIsUpdate());
    }

    @Test
    public void testEdit() {
        // Criando uma pessoa para edição
        Pessoa pessoa = new Pessoa();

        // Chamando o método a ser testado
        pessoaController.edit(pessoa);

        // Verificando se a pessoa foi configurada corretamente para edição
        assertEquals(pessoa, pessoaController.getPessoa());
        assertTrue(pessoaController.getIsUpdate());
    }

    @Test
    public void testDelete() throws DAOException {
        // Criando uma pessoa para exclusão
        Pessoa pessoa = new Pessoa();

        // Chamando o método a ser testado
        pessoaController.delete(pessoa);

        // Verificando se o serviço de exclusão foi chamado corretamente
        verify(pessoaService).excluir(pessoa);
        // Verificando se a pessoa foi removida da lista local
        assertFalse(pessoaController.getPessoas().contains(pessoa));
    }

    @Test
    public void testAdd() throws TipoChaveNaoEncontradaException, DAOException {
        // Criando uma pessoa para adição
        Pessoa pessoa = new Pessoa();

        // Chamando o método a ser testado
        pessoaController.add();

        // Verificando se o serviço de cadastro foi chamado corretamente
        verify(pessoaService).cadastrar(pessoa);
        // Verificando se a lista de pessoas foi atualizada corretamente
        verify(pessoaService).buscarTodos();
        // Verificando se uma nova pessoa foi criada
        assertNotNull(pessoaController.getPessoa());
    }

    @Test
    public void testUpdate() throws TipoChaveNaoEncontradaException, DAOException {
        // Criando uma pessoa para atualização
        Pessoa pessoa = new Pessoa();

        // Configurando o comportamento do facesContext
        when(FacesContext.getCurrentInstance()).thenReturn(facesContext);

        // Chamando o método a ser testado
        pessoaController.setIsUpdate(true);
        pessoaController.setPessoa(pessoa);
        pessoaController.update();

        // Verificando se o serviço de atualização foi chamado corretamente
        verify(pessoaService).alterar(pessoa);
        // Verificando se a pessoa foi resetada após a atualização
        assertNull(pessoaController.getPessoa());
        assertFalse(pessoaController.getIsUpdate());
        // Verificando se a mensagem de sucesso foi adicionada ao contexto
        verify(facesContext).addMessage(null, new FacesMessage("Pessoa atualizada com sucesso"));
    }
}


