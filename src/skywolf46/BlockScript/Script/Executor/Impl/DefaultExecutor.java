package skywolf46.BlockScript.Script.Executor.Impl;

import skywolf46.BlockScript.BlockScriptInitializer;
import skywolf46.BlockScript.Script.Executor.AbstractRunnableExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultExecutor extends AbstractRunnableExecutor {
    private ExecutorService tex = Executors.newSingleThreadExecutor();

    @Override
    public void sync(Runnable r) {
        tex.execute(r);
    }

    @Override
    public void shutdown() {
        tex.shutdown();
        BlockScriptInitializer.getThreadPool().shutdown();
    }

}
