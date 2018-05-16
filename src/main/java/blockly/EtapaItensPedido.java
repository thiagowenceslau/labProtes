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
	 * @param etapa
	 * @param funcionario
	 * @param idItemPedido
	 * @param data
	 * @param hrPrevisao
	 * @return Var
	 */
	// EtapaItensPedido
	public static Var adicionar(Var dtPrevisao, Var etapa, Var funcionario, Var idItemPedido, Var data, Var hrPrevisao)
			throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				System.out.println(idItemPedido.getObjectAsString());
				cronapi.database.Operations.insert(Var.valueOf("app.entity.EtapaItemPedido"),
						Var.valueOf("dataPrevisaoEntrega", data), Var.valueOf("situacao", Var.valueOf("aguardando")),
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
						Var.valueOf("dataPrevisaoEntrega", dtPrevisao), Var.valueOf("horaPrevisaoEntrega", hrPrevisao),
						Var.valueOf("situacaoItemPedido", Var.valueOf("aguardando")), Var.valueOf("id", idItemPedido));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
