package skywolf46.BlockScript.Web.WebSocket;

import org.java_websocket.WebSocket;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class BlockScriptSocket extends WebSocketServer {
    public BlockScriptSocket() {
        super(new InetSocketAddress(8088));
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        webSocket.
        String[] sp = s.split("\\|");
        switch (sp[0]) {
            case "LoadStart": {


                webSocket.send("LoadEnd|" + sp[1]);
            }break;
            case "SaveStart":{

            }
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        webSocket.send("ERR|ClearScript");
    }

    @Override
    public void onStart() {

    }
}
