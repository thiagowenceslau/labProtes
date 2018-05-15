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
	 * @param pedido
	 * @return Var
	 */
	// DetalheSolicitacao
	public static Var obterIdPedido(Var pedido) throws Exception {
		return new Callable<Var>() {

			private Var idPedido = Var.VAR_NULL;

			public Var call() throws Exception {
				idPedido = pedido;
				System.out.println(pedido.getObjectAsString());
				System.out.println(idPedido.getObjectAsString());
				return idPedido;
			}
		}.call();
	}

}
