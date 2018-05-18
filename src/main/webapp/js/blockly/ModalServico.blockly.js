window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalServico = window.blockly.js.blockly.ModalServico
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.adicionar = function() {

	var itemPedido, etapa, funcionario;
	etapa = this.cronapi.object.getProperty(this.cronapi.screen
			.getValueOfField("vars.txtEtapa"), 'id');
	funcionario = this.cronapi.object.getProperty(this.cronapi.screen
			.getValueOfField("vars.txtFuncionario"), 'id');
	itemPedido = this.cronapi.screen.getValueOfField("ItemPedido.active");
	window.alert(itemPedido);
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.EtapaItensPedido:adicionar', this.cronapi.screen
					.getValueOfField("vars.dtPrevisao"), etapa, funcionario,
			this.cronapi.screen.getValueOfField("ItemPedido.active.id"),
			this.cronapi.screen.getValueOfField("vars.data"),
			this.cronapi.screen.getValueOfField("vars.hrPrevisao"));
	this.cronapi.screen.refreshDatasource("EtapaItemPedido", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.fechar = function() {

	var itemPedido, etapa, funcionario;
	this.cronapi.screen.hideModal("modalServico");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.exibir = function() {

	var itemPedido, etapa, funcionario;
	this.cronapi.screen.showModal("modalServico");
}
