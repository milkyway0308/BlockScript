package skywolf46.BlockScript.Script.ScriptBlocks;

import skywolf46.BlockScript.Script.Data.ScriptNameData;
import skywolf46.BlockScript.Script.ScriptBlocks.Enum.ScriptIngredient;
import skywolf46.BlockScript.Script.ScriptRunningInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

public abstract class AbstractScriptBlock {
    private ScriptNameData namespace = null;

    public AbstractScriptBlock(String name){
        this.namespace = new ScriptNameData(name);
    }

    public AbstractScriptBlock(ScriptNameData snd){
        this.namespace = snd;
    }

    public abstract void onScript(ScriptRunningInfo info, ScriptPoint point);

    public boolean destroyPointer() {
        return false;
    }

    public abstract AbstractScriptBlock parseFromIngredient(List<ScriptIngredient> ingr);

    public abstract List<ScriptIngredient> getIngredient();

    public abstract void serialize(DataOutputStream stream);

    public abstract void deserialize(DataInputStream dis);

    public ScriptNameData getNamespace() {
        return namespace;
    }
}
