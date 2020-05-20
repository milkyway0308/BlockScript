package skywolf46.BlockScript.Script.ScriptBlocks;

import skywolf46.BlockScript.Script.ScriptBlocks.Serializer.VariableSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScriptVariableInfo {
    private static HashMap<Class, ScriptVariableInfo> svar = new HashMap<>();

    private static HashMap<String, ScriptVariableInfo> registeredName = new HashMap<>();


    private List<String> alias = new ArrayList<>();

    private VariableSerializer serializer;

    public VariableSerializer getSerializer() {
        return serializer;
    }

    public void setSerializer(VariableSerializer s) {
        this.serializer = s;
    }

}
