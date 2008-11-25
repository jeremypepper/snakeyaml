/*
 * See LICENSE file in distribution for copyright and licensing information.
 */
package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.error.Mark;

/**
 * @see PyYAML 3.06 for more information
 */
public abstract class Node {
    private String tag;
    private Object value;
    private int hash = -1;
    private Mark startMark;
    protected Mark endMark;

    public Node(final String tag, final Object value, final Mark startMark, final Mark endMark) {
        if (tag == null) {
            throw new NullPointerException("tag in a Node is required.");
        }
        this.tag = tag;
        if (value == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = value;
        this.startMark = startMark;
        this.endMark = endMark;
    }

    public String getTag() {
        return this.tag;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        if (hash == -1) {
            hash = 3;
            hash += (null == tag) ? 0 : 3 * tag.hashCode();
            hash += (null == value) ? 0 : 3 * value.hashCode();
        }
        return hash;
    }

    public boolean equals(final Object oth) {
        if (oth instanceof Node) {
            final Node nod = (Node) oth;
            return ((this.tag != null) ? this.tag.equals(nod.tag) : nod.tag == null)
                    && ((this.value != null) ? this.value.equals(nod.value) : nod.value == null);
        }
        return false;
    }

    public String toString() {
        return "<" + this.getClass().getName() + " (tag=" + getTag() + ", value=" + getValue()
                + ")>";
    }

    /**
     * For error reporting.
     * 
     * @see class variable 'id' in PyYAML
     * @return scalar, sequence, mapping
     */
    public abstract String getNodeId();

    public Mark getStartMark() {
        return startMark;
    }

    public Mark getEndMark() {
        return endMark;
    }
}
