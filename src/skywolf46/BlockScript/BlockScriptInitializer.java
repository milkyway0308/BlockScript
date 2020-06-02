package skywolf46.BlockScript;

import skywolf46.BlockScript.Script.Data.ScriptNameData;
import skywolf46.BlockScript.Script.ScriptBlocks.AbstractScriptBlock;
import skywolf46.BlockScript.Web.WebSocket.BlockScriptSocket;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockScriptInitializer {
    private static ThreadPoolExecutor pex = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 360, TimeUnit.SECONDS, new SynchronousQueue<>());
    private static HashMap<String, ScriptNameData> names = new HashMap<>();
    private static HashMap<ScriptNameData, AbstractScriptBlock> scDes = new HashMap<>();



    public void initializeScript(){
        File plugins = new File("plugins");
        if(!plugins.exists())
            plugins.mkdirs();
        if(plugins.isDirectory())
            for(File fl : plugins.listFiles()){
                if(fl.getName().endsWith(".jar")){

                }
            }
    }

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
