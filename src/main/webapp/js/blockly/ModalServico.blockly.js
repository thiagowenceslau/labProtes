window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalServico = window.blockly.js.blockly.ModalServico
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.fechar = function() {

	var item, idItem;
	this.cronapi.screen.hideModal("modalServico");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.exibir = function(idItem) {

	var item, idItem;
	this.cronapi.screen.showIonicModal("modalServico");
	return idItem;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.adicionar = function() {

	var item, idItem;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.EtapaItensPedido:adicionar', this.cronapi.screen
					.getValueOfField("vars.dtPrevisao"), this.cronapi.screen
					.getValueOfField("EtapaComissao.active.etapa.id"),
			this.cronapi.screen.getValueOfField("Funcionario.active.id"),
			this.cronapi.screen.getParam('idItem'), this.cronapi.screen
					.getValueOfField("vars.data"), this.cronapi.screen
					.getValueOfField("vars.hrPrevisao"));
	this.cronapi.screen.refreshDatasource("EtapaItemPedido", 'true');
}
