package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefaController {

	private JdbcTarefaDao dao = null;

	@Autowired
	public	void TarefasController(JdbcTarefaDao	dao) {
					this.dao	=	dao;		
	}

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario-tarefa";
	}

	@RequestMapping("adicionaTarefa")
	public String criaTarefa(@Valid Tarefa tarefa, BindingResult result) {
		/*
		 * Validacao programatica o maior problema sao os ifs no caso de mais campos
		 * if(tarefa.getDescricao() == null || tarefa.getDescricao().equals("")) {
		 * return "tarefa/formulario"; }
		 */
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario-tarefa";
		}

		// ele ira pegar o campo descricao da req e ira linkar esse campo com o do obj
		dao.adiciona(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("listaTarefas")
	public ModelAndView lista() {

		List<Tarefa> tarefas = dao.lista();
		ModelAndView modelAndView = new ModelAndView("tarefa/lista");
		modelAndView.addObject("tarefas", tarefas);

		return modelAndView;
	}

	@RequestMapping("listaTarefas2")
	public String lista2(Model model) {
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		dao.remove(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}

	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		dao.finaliza(id);
	}
}
