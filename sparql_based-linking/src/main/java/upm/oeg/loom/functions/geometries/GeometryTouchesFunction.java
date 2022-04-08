package upm.oeg.loom.functions.geometries;

import org.apache.jena.sparql.expr.NodeValue;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import upm.oeg.loom.enums.GeometryRelation;

/**
 * @author Wenqi Jiang
 */
public class GeometryTouchesFunction extends AbstractGeometryFunction {
    public GeometryTouchesFunction() {
        super(GeometryRelation.TOUCHES);
    }

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        try {
            Geometry g1 = reader.read(v1.asString());
            Geometry g2 = reader.read(v2.asString());
            return NodeValue.makeBoolean(g1.touches(g2));
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
            return NodeValue.FALSE;
        }
    }
}
