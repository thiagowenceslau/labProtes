package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class EfetivarSolicitacaoPedido {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// EfetivarSolicitacaoPedido
	public static Var InserirEtapaFuncionario() throws Exception {
		return new Callable<Var>() {

			private Var etapaComissao = Var.VAR_NULL;
			private Var etapa = Var.VAR_NULL;

			public Var call() throws Exception {
				etapaComissao = cronapi.json.Operations.getJsonOrMapField(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtEtapa")),
						Var.valueOf("etapa.id"));
				etapa = Var.VAR_NULL;
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						etapaComissao);
				System.out.println(etapaComissao.getObjectAsString());
				return Var.VAR_NULL;
			}
		}.call();
	}

}
