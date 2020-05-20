package skywolf46.BlockScript.Script;

import skywolf46.BlockScript.Script.ScriptBlocks.AbstractScriptBlock;
import skywolf46.BlockScript.Script.ScriptBlocks.ScriptMap;
import skywolf46.BlockScript.Script.ScriptBlocks.ScriptPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ScriptRunningInfo {
    private ConcurrentHashMap<String, Object> variable = new ConcurrentHashMap<>();

    private boolean isPlainScript = false;
    private boolean isAsync = false;
    private ScriptRunningInfo baseScript;
    private boolean isFinished = false;
    private ScriptPoint currentPoint;
    private AtomicBoolean scriptLock = new AtomicBoolean(false);
    private ScriptMap map;
    private List<ScriptPoint> handlingPointer = new ArrayList<>();
    private boolean autoDefine = false;

    public ScriptRunningInfo(ScriptMap sMap) {
        this.map = sMap;
    }


    public ScriptMap getMap() {
        return map;
    }

    public void nextRun() {
        if (scriptLock.get())
            return;
        scriptLock.set(true);
        int repSize = handlingPointer.size();
        List<Integer> reqDelete = new ArrayList<>();
        for (int i = 0; i < repSize; i++) {
            ScriptPoint scp = handlingPointer.get(i);
            ScriptPoint[] sp = scp.getNextPoint();
            if (sp.length == 0) {
                reqDelete.add(i);
            }
            for (int x = 0; x < sp.length; x++) {
                AbstractScriptBlock bl = map.getScriptBlock(sp[x]);
                bl.onScript(this, sp[x]);
                if (!bl.destroyPointer())
                    if (x == 0)
                        handlingPointer.set(i, sp[x]);
                    else
                        handlingPointer.add(sp[x]);
                // 브랜치 삭제가 이미 이루어짐; 이후 삭제 처리시 교체된 스크립트에서 문제 발생
//                else
//                    reqDelete.add(i);
            }
        }
        scriptLock.set(false);
    }

    public ScriptRunningInfo createScriptBranch(ScriptPoint nextPoint, boolean isAsync) {
        return clone(nextPoint, isAsync);
    }

    private ScriptRunningInfo clone(ScriptPoint nextPoint, boolean isAsync) {
        ScriptRunningInfo scr = new ScriptRunningInfo(map);
        scr.currentPoint = nextPoint;
        scr.variable = variable;
        scr.isAsync = isAsync;
        scr.isPlainScript = isPlainScript;
        scr.baseScript = baseScript;
        return scr;
    }

    public ScriptPoint getCurrentPoint() {
        return currentPoint;
    }

    public ScriptRunningInfo makeAsync(ScriptPoint starting) {
        return clone(starting, true);
    }


    public ScriptRunningInfo makeSync(ScriptPoint starting) {
        return clone(starting, false);
    }
}
