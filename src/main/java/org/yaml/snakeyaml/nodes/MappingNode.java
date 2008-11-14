/*
 * See LICENSE file in distribution for copyright and licensing information.
 */
package org.yaml.snakeyaml.nodes;

import java.util.Map;

import org.yaml.snakeyaml.error.Mark;

/**
 * @see PyYAML 3.06 for more information
 */
public class MappingNode extends CollectionNode {
    public static final String id = "mapping";

    @SuppressWarnings("unchecked")
    public MappingNode(final String tag, final Map value, final Mark startMark, final Mark endMark,
            final boolean flowStyle) {
        super(tag, value, startMark, endMark, flowStyle);
    }

    @Override
    public String getNodeId() {
        return id;
    }
}
