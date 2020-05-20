package skywolf46.BlockScript;

import skywolf46.BlockScript.Web.WebSocket.BlockScriptSocket;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockScriptInitializer {
    private static ThreadPoolExecutor pex = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 360, TimeUnit.SECONDS, new SynchronousQueue<>());

    public static void initializeWeb() {
        new BlockScriptSocket().start();
    }

    public static ThreadPoolExecutor getThreadPool() {
        return pex;
    }

    public static void executeAsync(Runnable r) {
        pex.execute(r);
    }
}
