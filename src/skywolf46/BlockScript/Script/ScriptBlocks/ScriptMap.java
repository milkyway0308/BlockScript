package skywolf46.BlockScript.Script.ScriptBlocks;

import java.util.HashMap;

public class ScriptMap {
    protected HashMap<ScriptPoint, AbstractScriptBlock> scriptBlock = new HashMap<>();

    private HashMap<ScriptPoint, ScriptPoint> point = new HashMap<>();

    public ScriptPoint getScriptPointIfExists(int x, int y) {
        ScriptPoint sPoint = new ScriptPoint(x, y);
        return point.computeIfAbsent(sPoint, a -> sPoint);
    }

    public AbstractScriptBlock getScriptBlock(ScriptPoint spoint) {
        return scriptBlock.get(spoint);
    }

}
