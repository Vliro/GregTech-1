package gregtech.api.worldgen.shape;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class LayeredGenerator extends EllipsoidGenerator {

    private int yRadius;

    public LayeredGenerator() {
    }

    @Override
    public void loadFromConfig(JsonObject object) {
        super.loadFromConfig(object);
        JsonElement element = object.get("layers");
        if (element != null) {
            yRadius = element.getAsInt() / 2;
        } else {
            yRadius = 3; // default number of layers
        }
    }

    @Override
    public int getYRadius() {
        return yRadius;
    }

    @Override
    public void generateBlock(int x, int y, int z, IBlockGeneratorAccess blockAccess) {
        blockAccess.generateBlock(x, y, z, false);
    }
}
