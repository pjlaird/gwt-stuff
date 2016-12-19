package ca.lucaboq.ajax;

import com.google.gwt.aria.client.SectionheadRole;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.xhr.client.XMLHttpRequest;

public class RestTester {
	public Request test() {
		RequestHooks hooks = new RequestHooks();

		Request sendRequest = null;
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "");
		try {
			hooks.preExecute();
			sendRequest = builder.sendRequest(null, new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					hooks.postExecute();
					hooks.onSuccess();
				}

				@Override
				public void onError(Request request, Throwable exception) {
					hooks.postExecute();
					hooks.onFailure();
				}
			});
		} catch (RequestException e) {
			hooks.postExecute();
			hooks.onFailure();
			return sendRequest;
		}
		return sendRequest;
	}

	private static class RequestHooks {
		public void preExecute() {
		};

		public void postExecute() {
		};

		public void onFailure() {
		};

		public void onSuccess() {
		};
	}
}
