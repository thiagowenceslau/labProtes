window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalListaPreco = window.blockly.js.blockly.ModalListaPreco
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalListaPreco.inserir = function() {

	var item;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.ListaPecoView:inserir', this.cronapi.screen
					.getValueOfField("vars.nome"), this.cronapi.screen
					.getValueOfField("vars.ordem"), this.cronapi.screen
					.getValueOfField("vars.ativo"));
	this.cronapi.screen.notify('success', 'Lista inserida com sucesso');
	document.getElementById("lista").reset();
	this.cronapi.screen.refreshDatasource("ListaPreco", 'true');
	this.blockly.js.blockly.ModalListaPreco.fechar();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalListaPreco.fechar = function() {

	var item;
	this.cronapi.screen.hideModal("modalLista");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalListaPreco.exibir = function() {

	var item;
	this.cronapi.screen.showModal("modalLista");
}
