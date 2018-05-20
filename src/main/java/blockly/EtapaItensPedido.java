package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class EtapaItensPedido {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param dtPrevisao
	 * @param param_etapa
	 * @param funcionario
	 * @param idItemPedido
	 * @param data
	 * @param hrPrevisao
	 * @return Var
	 */
	// EtapaItensPedido
	public static Var adicionar(Var dtPrevisao, Var param_etapa, Var funcionario, Var idItemPedido, Var data,
			Var hrPrevisao) throws Exception {
		return new Callable<Var>() {

			// param
			private Var etapa = param_etapa;
			// end
			private Var consulta = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.EtapaItemPedido"),
						Var.valueOf(
								"select e from EtapaItemPedido e where e.etapa.id = :etapaId AND e.itemPedido.id = :itemPedidoId"),
						Var.valueOf("etapaId", etapa), Var.valueOf("itemPedidoId", idItemPedido));
				if (cronapi.database.Operations.hasElement(consulta).getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("error"),
							Var.valueOf("A etapa selecionada já está cadastrada para esse serviço"));
				} else {
					cronapi.database.Operations.insert(Var.valueOf("app.entity.EtapaItemPedido"),
							Var.valueOf("dataPrevisaoEntrega", data),
							Var.valueOf("situacao", Var.valueOf("aguardando")),
							Var.valueOf("etapa",
									cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Etapa"),
											Var.valueOf("id", etapa))),
							Var.valueOf("itemPedido",
									cronapi.database.Operations.newEntity(Var.valueOf("app.entity.ItemPedido"),
											Var.valueOf("id", idItemPedido))),
							Var.valueOf("funcionario", cronapi.database.Operations
									.newEntity(Var.valueOf("app.entity.Funcionario"), Var.valueOf("id", funcionario))));
					cronapi.database.Operations.execute(Var.valueOf("app.entity.ItemPedido"),
							Var.valueOf(
									"update ItemPedido set dataPrevisaoEntrega = :dataPrevisaoEntrega, horaPrevisaoEntrega = :horaPrevisaoEntrega, situacaoItemPedido = :situacaoItemPedido where id = :id"),
							Var.valueOf("dataPrevisaoEntrega", dtPrevisao),
							Var.valueOf("horaPrevisaoEntrega", hrPrevisao),
							Var.valueOf("situacaoItemPedido", Var.valueOf("aguardando")),
							Var.valueOf("id", idItemPedido));
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param idPedido
	 * @param dtPrevisao
	 */
	// Descreva esta função...
	public static void efetivar(Var idPedido, Var dtPrevisao) throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Pedido"),
						Var.valueOf(
								"update Pedido set dataPrevisao = :dataPrevisao, situacaoPedido = :situacaoPedido where id = :id"),
						Var.valueOf("dataPrevisao", dtPrevisao),
						Var.valueOf("situacaoPedido", Var.valueOf("efetivado")), Var.valueOf("id", idPedido));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var enviar() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.post"), Var.valueOf("Pedido"));
				return cronapi.database.Operations.query(Var.valueOf("app.entity.Pedido"),
						Var.valueOf("select p from Pedido p"));
			}
		}.call();
	}

	/**
	 *
	 * @param idPedido
	 * @return Var
	 */
	// Descreva esta função...
	public static Var recusarPedido(Var idPedido) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Pedido"),
						Var.valueOf("update Pedido set situacaoPedido = :situacaoPedido where id = :id"),
						Var.valueOf("situacaoPedido", Var.valueOf("recusado")), Var.valueOf("id", idPedido));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.post"), Var.valueOf("Pedido"));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
