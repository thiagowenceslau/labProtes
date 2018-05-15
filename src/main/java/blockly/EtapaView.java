package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class EtapaView {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param descricao
	 * @param ativo
	 * @return Var
	 */
	// EtapaView
	public static Var inserir(Var descricao, Var ativo) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Etapa"), Var.valueOf("ativo", ativo),
						Var.valueOf("descricao", descricao));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
