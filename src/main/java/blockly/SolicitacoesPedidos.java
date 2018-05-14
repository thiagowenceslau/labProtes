package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class SolicitacoesPedidos {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Entidade
	 * @return Var
	 */
	// SolicitacoesPedidos
	public static Var calcularItens(Var Entidade) throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var idPedido = Var.VAR_NULL;
			private Var listaItens = Var.VAR_NULL;
			private Var contador = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.Pedido"),
						Var.valueOf("select p from Pedido p where p = :p"), Var.valueOf("p", Entidade));
				idPedido = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].id"));
				listaItens = cronapi.database.Operations.query(Var.valueOf("app.entity.ItemPedido"),
						Var.valueOf("select i from ItemPedido i where i.pedido.id = :pedidoId"),
						Var.valueOf("pedidoId", idPedido));
				contador = Var.valueOf(0);
				while (cronapi.database.Operations.hasElement(listaItens).getObjectAsBoolean()) {
					contador = cronapi.math.Operations.sum(contador, Var.valueOf(1));
					cronapi.database.Operations.next(listaItens);
				} // end while
				return contador;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarCondicao() throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var Entidade = Var.VAR_NULL;
			private Var idPedido = Var.VAR_NULL;
			private Var listaItens = Var.VAR_NULL;
			private Var contador = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("aguardando");
			}
		}.call();
	}

}
