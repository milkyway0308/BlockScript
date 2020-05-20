package skywolf46.BlockScript.Script.ScriptBlocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ScriptPoint {
    private int x;
    private int y;
    private List<ScriptPoint> nextPoints = new ArrayList<>();
    private static ScriptPoint[] nextPointer = new ScriptPoint[0];

    public ScriptPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static ScriptPoint of(int x, int y) {
        return new ScriptPoint(x, y);
    }

    public ScriptPoint[] getNextPoint() {
        return nextPoints.toArray(nextPointer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void addNextPointer(ScriptPoint scriptPoint) {
        nextPoints.add(scriptPoint);
    }
}
