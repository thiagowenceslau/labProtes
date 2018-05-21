window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.PedidoNovo = window.blockly.js.PedidoNovo || {};

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.adicionar = function() {

	var item, comboTipo, datEntrega, idade, idPedido, paciente, sexo, tipoTrabalho, totalPedido;
	idPedido = this.cronapi.util
			.callServerBlockly('blockly.PedidoNovoMobile:criarPedidoCompleto');
	this.cronapi.screen.changeValueOfField("vars.idPedido", idPedido);
	totalPedido = this.cronapi.util.callServerBlockly(
			'blockly.PedidoNovoMobile:CalcularTotal', idPedido);
	this.cronapi.screen.changeValueOfField("vars.txtTotal", totalPedido);
	this.cronapi.screen.refreshDatasource("ItemPedido", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.finalizar = function() {

	var item, comboTipo, datEntrega, idade, idPedido, paciente, sexo, tipoTrabalho, totalPedido;
	paciente = this.cronapi.screen.getValueOfField("vars.txtPaciente");
	idade = this.cronapi.screen.getValueOfField("vars.txtIdade");
	datEntrega = this.cronapi.screen.getValueOfField("vars.dtEntrega");
	sexo = this.cronapi.screen.getValueOfField("vars.txtSexo");
	if (this.cronapi.logic.isNullOrEmpty(paciente)
			|| this.cronapi.logic.isNullOrEmpty(idade)
			|| this.cronapi.logic.isNullOrEmpty(sexo)
			&& this.cronapi.logic.isNullOrEmpty(datEntrega)) {
		this.cronapi.screen.notify('warning',
				'Preencha todos os campos obrigatórios!\n');
	} else {
		this.cronapi.util
				.callServerBlocklyNoReturn('blockly.PedidoNovoMobile:finalizarPedido');
		this.cronapi.screen.changeValueOfField("vars.idPedido", '0');
		this.cronapi.screen.hideComponent("crn-container-Odontograma");
		this.cronapi.screen.hideComponent("crn-list-item-Grupo");
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
		this.cronapi.screen.hideComponent("crn-list-item-btnAdd");
		this.cronapi.screen.hideComponent("crn-button-btnFinalizar");
		this.cronapi.screen.refreshDatasource("ItemPedido", 'true');
		this.cronapi.screen.notify('warning', 'Pedido realizado com sucesso!');
	}
}

/**
 * PedidoNovo
 */
window.blockly.js.PedidoNovo.Executar = function(comboTipo) {

	var item, comboTipo, datEntrega, idade, idPedido, paciente, sexo, tipoTrabalho, totalPedido;
	tipoTrabalho = this.cronapi.util.callServerBlockly(
			'blockly.PedidoNovoMobile:retornarNomeTipoTrabalho', comboTipo);
	if (tipoTrabalho == 'Contenção' || tipoTrabalho == 'Placa') {
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
	} else {
		this.cronapi.screen.showComponent("crn-container-Odontograma");
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-list-item-Cor");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
	}
	if (tipoTrabalho == 'Enceramento') {
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
	}
	if (tipoTrabalho == 'Contenção' || tipoTrabalho == 'Placa') {
		this.cronapi.screen.hideComponent("crn-container-Odontograma");
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
	}
	this.cronapi.screen.showComponent("crn-list-item-foto");
	this.cronapi.screen.showComponent("crn-list-item-obterfoto");
}

/**
 * PedidoNovo
 */
window.blockly.js.PedidoNovo.ExcluirFoto = function() {

	var item, comboTipo, datEntrega, idade, idPedido, paciente, sexo, tipoTrabalho, totalPedido;
	this.cronapi.screen.hideComponent("btnExcluir");
	this.cronapi.screen.changeValueOfField("vars.foto", '');
}

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.ObterFotoBiblioteca = function() {

	var item, comboTipo, datEntrega, idade, idPedido, paciente, sexo, tipoTrabalho, totalPedido;
	this.cronapi.cordova.camera
			.getPicture(
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.changeValueOfField("vars.foto",
										String('data:image/png;base64,')
												+ String(item));
						this.cronapi.screen.showComponent("txtFoto");
						this.cronapi.screen.showComponent("btnExcluir");
					}.bind(this),
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.notify(
										'error',
										'Ocorreu um erro ao obter a foto!  Por favor tente novamente ou contate a administração.\n');
					}.bind(this), '0', '0');
}

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.ObterFotoCamera = function() {

	var item, comboTipo, datEntrega, idade, idPedido, paciente, sexo, tipoTrabalho, totalPedido;
	this.cronapi.cordova.camera
			.getPicture(
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.changeValueOfField("vars.foto",
										String('data:image/png;base64,')
												+ String(item));
						this.cronapi.screen.showComponent("txtFoto");
						this.cronapi.screen.showComponent("btnExcluir");
					}.bind(this),
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.notify(
										'error',
										'Ocorreu um erro ao obter a foto!  Por favor tente novamente ou contate a administração.\n');
					}.bind(this), '0', '1');
}
