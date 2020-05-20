package skywolf46.BlockScript.Script.ScriptBlocks.Enum;

public class ScriptIngredient {
    private String text;
    private ScriptIngredientType sit;

    public ScriptIngredient(ScriptIngredientType sit, String text) {
        this.sit = sit;
        this.text = text;
    }

    public ScriptIngredient(ScriptIngredientType sit) {
        this.sit = sit;
    }

    public String getText() {
        return text;
    }

    public ScriptIngredientType getType() {
        return sit;
    }
}
