window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalServico = window.blockly.js.blockly.ModalServico
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.pegarIdPedido = function(dadosPedido) {

	var dadosPedido, itemPedido, funcionario, etapa, dados;
	this.cronapi.screen.createScopeVariable('pedido', dadosPedido);
	this.cronapi.screen.showComponent("crn-button-brnRecusa");
	this.cronapi.screen.showComponent("crn-button-btnEfetiva");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.recusarPedido = function() {

	var dadosPedido, itemPedido, funcionario, etapa, dados;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.EtapaItensPedido:recusarPedido', this.cronapi.object
					.getProperty(
							this.cronapi.screen.getScopeVariable('pedido'),
							'id'));
	this.cronapi.screen.refreshDatasource("Pedido", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.efetivarPedido = function() {

	var dadosPedido, itemPedido, funcionario, etapa, dados;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.EtapaItensPedido:efetivar', this.cronapi.screen
					.getValueOfField("Pedido.active.id"), this.cronapi.screen
					.getValueOfField("vars.dtPrev"));
	this.cronapi.screen.refreshDatasource("Pedido", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.adicionar = function() {

	var dadosPedido, itemPedido, funcionario, etapa, dados;
	etapa = this.cronapi.object.getProperty(this.cronapi.screen
			.getValueOfField("vars.txtEtapa"), 'etapa.id');
	funcionario = this.cronapi.object.getProperty(this.cronapi.screen
			.getValueOfField("vars.txtFuncionario"), 'id');
	itemPedido = this.cronapi.object.getProperty(this.cronapi.screen
			.getScopeVariable('itemPedido'), 'id');
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.EtapaItensPedido:adicionar', this.cronapi.screen
					.getValueOfField("vars.dtPrevisao"), etapa, funcionario,
			itemPedido, this.cronapi.screen.getValueOfField("vars.data"),
			this.cronapi.screen.getValueOfField("vars.hrPrevisao"));
	this.cronapi.screen.changeValueOfField("vars.txtEtapa", '0');
	this.cronapi.screen.changeValueOfField("vars.txtFuncionario", '0');
	this.cronapi.screen.refreshDatasource("EtapaItemPedido", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.exibir = function(dados) {

	var dadosPedido, itemPedido, funcionario, etapa, dados;
	this.cronapi.screen.createScopeVariable('itemPedido', dados);
	this.cronapi.screen.showIonicModal("modalServico");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalServico.fechar = function() {

	var dadosPedido, itemPedido, funcionario, etapa, dados;
	this.cronapi.screen.hideModal("modalServico");
}
