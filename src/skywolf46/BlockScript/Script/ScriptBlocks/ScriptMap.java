package skywolf46.BlockScript.Script.ScriptBlocks;

import java.io.IOException;
import java.io.ObjectOutputStream;
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


    public void serializeTo(ObjectOutputStream st) throws IOException {
        for(ScriptPoint sp : scriptBlock.keySet()){
            st.writeInt(sp.getX());
            st.writeInt(sp.getY());
            scriptBlock.get(sp).getNamespace().write(st);
        }
    }
}
