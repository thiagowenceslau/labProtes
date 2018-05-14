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
	 * @param Dados
	 * @return Var
	 */
	// DetalheSolicitacao
	public static Var obterIdPedido(Var Dados) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.VAR_NULL;
			}
		}.call();
	}

}
