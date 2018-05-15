package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class DetalheSolicitacao {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// DetalheSolicitacao
	public static Var obterIdPedido() throws Exception {
		return new Callable<Var>() {

			private Var idPedido = Var.VAR_NULL;

			public Var call() throws Exception {
				idPedido = Var.VAR_NULL;
				return idPedido;
			}
		}.call();
	}

	/**
	 *
	 * @param pedido
	 * @return Var
	 */
	// Descreva esta função...
	public static Var ObterDetalhePedido(Var pedido) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return pedido;
			}
		}.call();
	}

}
