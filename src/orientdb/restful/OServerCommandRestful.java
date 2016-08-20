package orientdb.restful;

import java.io.IOException;

import com.orientechnologies.orient.server.config.OServerCommandConfiguration;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.command.all.OServerCommandAbstractLogic;

public class OServerCommandRestful extends OServerCommandAbstractLogic {
	private static final String[] NAMES = { "GET|restful/*", "POST|restful/*", "PUT|restful/*", "PATCH|restful/*", "DELETE|restful/*" };
	
	public OServerCommandRestful(final OServerCommandConfiguration iConfiguration) {
		
	}
	
	@Override
  public String[] init(final OHttpRequest iRequest, final OHttpResponse iResponse) {
    final String[] parts = checkSyntax(iRequest.url, 3, "Syntax error: function/<database>/<name>[/param]*");
    iRequest.data.commandInfo = "Execute a function";
    return parts;
  }

  @Override
  protected void handleResult(final OHttpRequest iRequest, final OHttpResponse iResponse, final Object iResult)
      throws InterruptedException, IOException {
    iResponse.writeResult(iResult);
  }

  @Override
  public String[] getNames() {
    return NAMES;
  }

}
