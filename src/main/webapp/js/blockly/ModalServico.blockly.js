window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalServico = window.blockly.js.blockly.ModalServico
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.adicionar = function() {
	window.alert(this.cronapi.screen
			.getValueOfField("EtapaComissao.active.etapa"));
	window.alert(this.cronapi.screen.getValueOfField("Funcionario.active.id"));
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.EtapaItensPedido:adicionar', this.cronapi.screen
					.getValueOfField("vars.dtPrevisao"), this.cronapi.screen
					.getValueOfField("EtapaComissao.active.etapa"),
			this.cronapi.screen.getValueOfField("Funcionario.active.id"),
			this.cronapi.screen.getValueOfField("ItemPedido.active.id"),
			this.cronapi.screen.getValueOfField("vars.data"),
			this.cronapi.screen.getValueOfField("vars.hrPrevisao"));
	this.cronapi.screen.refreshDatasource("EtapaItemPedido", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.fechar = function() {
	this.cronapi.screen.hideModal("modalServico");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.exibir = function() {
	this.cronapi.screen.showModal("modalServico");
}
