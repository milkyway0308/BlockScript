package skywolf46.BlockScript.Script.ScriptBlocks;

import skywolf46.BlockScript.Script.ScriptBlocks.Enum.ScriptIngredient;
import skywolf46.BlockScript.Script.ScriptRunningInfo;

import java.util.List;

public abstract class AbstractScriptBlock {
    public abstract void onScript(ScriptRunningInfo info, ScriptPoint point);

    public boolean destroyPointer() {
        return false;
    }

    public abstract AbstractScriptBlock parseFromIngredient(List<ScriptIngredient> ingr);

    public abstract List<ScriptIngredient> getIngredient();

}
