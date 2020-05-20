package skywolf46.BlockScript.Script.ScriptBlocks;

public class LinearScriptMap extends ScriptMap {
    private int lastPointer = 0;

    public void addBlock(AbstractScriptBlock asb) {
        ScriptPoint sp;
        (sp = getScriptPointIfExists(lastPointer, 0)).addNextPointer(new ScriptPoint(++lastPointer, 0));
        scriptBlock.put(sp, asb);
    }

}
