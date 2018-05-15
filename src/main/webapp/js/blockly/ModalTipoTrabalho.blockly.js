window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalTipoTrabalho = window.blockly.js.blockly.ModalTipoTrabalho
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalTipoTrabalho.inserir = function() {
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.TipoTrabalhoView:inserir', this.cronapi.screen
					.getValueOfField("vars.nome"));
	this.cronapi.screen.notify('success',
			'Tipo de Trabalho inserido com sucesso');
			document.getElementById("tipo").reset();
	this.cronapi.screen.refreshDatasource("TipoTrabalho", 'true');
	this.blockly.js.blockly.ModalTipoTrabalho.fechar();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalTipoTrabalho.fechar = function() {
	this.cronapi.screen.hideModal("modalTipo");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalTipoTrabalho.exibir = function() {
	this.cronapi.screen.showModal("modalTipo");
}
