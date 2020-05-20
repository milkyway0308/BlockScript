package skywolf46.BlockScript.Script.ScriptBlocks.Extension;

import skywolf46.BlockScript.BlockScriptInitializer;
import skywolf46.BlockScript.Script.ScriptBlocks.AbstractScriptBlock;
import skywolf46.BlockScript.Script.ScriptBlocks.Enum.ScriptIngredient;
import skywolf46.BlockScript.Script.ScriptBlocks.Enum.ScriptIngredientType;
import skywolf46.BlockScript.Script.ScriptBlocks.ScriptPoint;
import skywolf46.BlockScript.Script.ScriptRunningInfo;

import java.util.Arrays;
import java.util.List;

public class RunAsyncBlock extends AbstractScriptBlock {
    @Override
    public void onScript(ScriptRunningInfo info, ScriptPoint point) {
        for (ScriptPoint sPoint : point.getNextPoint()) {
            AbstractScriptBlock asb = info.getMap().getScriptBlock(sPoint);
            // 새로운 브랜치로 분리
            if (asb != null) {
                BlockScriptInitializer.executeAsync(() -> asb.onScript(info.makeAsync(sPoint), sPoint));
            }
        }
    }

    @Override
    public AbstractScriptBlock parseFromIngredient(List<ScriptIngredient> ingr) {
        return new RunAsyncBlock();
    }

    @Override
    public List<ScriptIngredient> getIngredient() {
        return Arrays.asList(new ScriptIngredient(ScriptIngredientType.FIXED_STRING,"ASYNC ROUTER"));
    }


}
