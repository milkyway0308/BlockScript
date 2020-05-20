package skywolf46.BlockScript.Script.Executor;

import skywolf46.BlockScript.BlockScriptInitializer;

public abstract class AbstractRunnableExecutor {
    public abstract void sync(Runnable r);

    public abstract void shutdown();

    public void async(Runnable r) {
        BlockScriptInitializer.getThreadPool().execute(r);
    }
}
