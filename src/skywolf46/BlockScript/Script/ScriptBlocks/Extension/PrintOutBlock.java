package skywolf46.BlockScript.Script.ScriptBlocks.Extension;

import skywolf46.BlockScript.Script.ScriptBlocks.AbstractScriptBlock;
import skywolf46.BlockScript.Script.ScriptBlocks.Enum.ScriptIngredient;
import skywolf46.BlockScript.Script.ScriptBlocks.Enum.ScriptIngredientType;
import skywolf46.BlockScript.Script.ScriptBlocks.ScriptPoint;
import skywolf46.BlockScript.Script.ScriptRunningInfo;

import java.util.Arrays;
import java.util.List;

public class PrintOutBlock extends AbstractScriptBlock {
    private String msg;

    public PrintOutBlock(String msg) {
        this.msg = msg;
    }

    @Override
    public void onScript(ScriptRunningInfo info, ScriptPoint point) {
        System.out.println(msg);
    }

    @Override
    public AbstractScriptBlock parseFromIngredient(List<ScriptIngredient> ingr) {
        return new PrintOutBlock(ingr.get(0).getText());
    }

    @Override
    public List<ScriptIngredient> getIngredient() {
        return Arrays.asList(
                new ScriptIngredient(ScriptIngredientType.FIXED_STRING, "Log \""),
                new ScriptIngredient(ScriptIngredientType.STRING),
                new ScriptIngredient(ScriptIngredientType.FIXED_STRING, "\"")
        );
    }
}
