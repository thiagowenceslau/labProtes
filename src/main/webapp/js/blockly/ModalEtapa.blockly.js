window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalEtapa = window.blockly.js.blockly.ModalEtapa
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalEtapa.inserir = function() {
	this.cronapi.util.callServerBlocklyNoReturn('blockly.EtapaView:inserir',
			this.cronapi.screen.getValueOfField("vars.descricao"),
			this.cronapi.screen.getValueOfField("vars.ativo"));
			document.getElementById("etapa").reset();
	this.cronapi.screen.notify('success', 'Etapa inserida com sucesso');
	this.cronapi.screen.refreshDatasource("Etapa", 'true');
	this.blockly.js.blockly.ModalEtapa.fechar();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalEtapa.fechar = function() {
	this.cronapi.screen.hideModal("modal41892");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalEtapa.exibir = function() {
	this.cronapi.screen.showModal("modal41892");
}
