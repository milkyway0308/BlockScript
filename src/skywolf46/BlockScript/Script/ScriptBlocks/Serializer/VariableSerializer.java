package skywolf46.BlockScript.Script.ScriptBlocks.Serializer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface VariableSerializer<T> {
    T serialize(ObjectInputStream ois) throws Exception;

    void deserialize(ObjectOutputStream oos) throws Exception;
}
