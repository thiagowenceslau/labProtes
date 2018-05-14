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
				cronapi.util.Operations
						.callClientFunction(Var.valueOf("blockly.js.blockly.DetalheSolicitacao.obterId"));
				idPedido = cronapi.util.Operations.getValueFromSession(Var.valueOf("idPedido"));
				System.out.println(idPedido.getObjectAsString());
				return idPedido;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarPedido() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.VAR_NULL;
			}
		}.call();
	}

}
