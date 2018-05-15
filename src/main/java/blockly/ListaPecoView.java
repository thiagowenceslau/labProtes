package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ListaPecoView {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param nome
	 * @param ordem
	 * @param ativo
	 * @return Var
	 */
	// ListaPecoView
	public static Var inserir(Var nome, Var ordem, Var ativo) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.ListaPreco"), Var.valueOf("ativo", ativo),
						Var.valueOf("ordem", ordem), Var.valueOf("nome", nome));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
