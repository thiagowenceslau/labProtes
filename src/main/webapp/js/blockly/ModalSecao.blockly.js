window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalSecao = window.blockly.js.blockly.ModalSecao
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSecao.inserir = function() {
	this.cronapi.util.callServerBlocklyNoReturn('blockly.SecaoView:inserir',
			this.cronapi.screen.getValueOfField("vars.descricao"),
			this.cronapi.screen.getValueOfField("vars.ativo"));
	this.cronapi.screen.notify('success', 'Seção inserida com sucesso');
	document.getElementById("secao").reset();
	this.cronapi.screen.refreshDatasource("Secao", 'true');
	this.blockly.js.blockly.ModalSecao.fechar();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSecao.exibir = function() {
	this.cronapi.screen.showModal("modalSecao");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSecao.fechar = function() {
	this.cronapi.screen.hideModal("modalSecao");
}
