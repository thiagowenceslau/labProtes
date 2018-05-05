package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CepCliente {

	public static final int TIMEOUT = 300;

	/**
	 */
	// Descreva esta função...
	public static void buscarCep() throws Exception {
		new Callable<Var>() {

			private Var url = Var.VAR_NULL;
			private Var retornoCep = Var.VAR_NULL;

			public Var call() throws Exception {
				url = Var.valueOf(Var.valueOf("https://viacep.com.br/ws/").toString()
						+ cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.ceP")).toString()
						+ Var.valueOf("/json").toString());
				retornoCep = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"),
						Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL);
				retornoCep = cronapi.json.Operations.toJson(retornoCep);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Cliente.active.endereco"),
						cronapi.json.Operations.getJsonOrMapField(retornoCep, Var.valueOf("logradouro")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Cliente.active.cidade"),
						cronapi.json.Operations.getJsonOrMapField(retornoCep, Var.valueOf("localidade")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Cliente.active.bairro"),
						cronapi.json.Operations.getJsonOrMapField(retornoCep, Var.valueOf("bairro")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Cliente.active.estado"),
						cronapi.json.Operations.getJsonOrMapField(retornoCep, Var.valueOf("uf")));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
