package skywolf46.BlockScript.Script.Data;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ScriptNameData {
    private int[] name = new int[5];

    public ScriptNameData(String name) {
        this.name = new int[]{
                (name + "__!").hashCode(),
                (name + "__@").hashCode(),
                (name + "__|").hashCode(),
                (name + "__~").hashCode(),
                (name + "__*").hashCode()
        };
    }

    public ScriptNameData(DataInputStream dis) throws IOException {
        for(int i = 0;i < 5;i++)
            name[i] = dis.readInt();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ScriptNameData && Arrays.equals(name, ((ScriptNameData) obj).name);
    }

    public void write(ObjectOutputStream st) throws IOException {
        for (int i : name)
            st.writeInt(i);
    }
}
