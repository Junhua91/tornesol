package com.junhua.tornesol.util.tree;

import java.util.ArrayList;
import java.util.List;


/**
 * 用于存储node的结构；可以扩展更多的属性，也可以有不同类型的node
 */
public class TreeNode implements ITreeNode {


    private int nodeType;
    private int nodeId;
    private String nodeName;
    private int parentId;
    private ITreeNode parent = null;
    private List<ITreeNode> children = new ArrayList<>();
    private List<ITreeNode> allChildren = new ArrayList<>();

    public TreeNode(int nodeType, int nodeId, String nodeName, int parentId) {
        this.nodeType = nodeType;
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.parentId = parentId;
    }

    @Override
    public int getNodeType() {
        return nodeType;
    }

    @Override
    public int getNodeId() {
        return nodeId;
    }

    @Override
    public String getNodeName() {
        return nodeName;
    }

    @Override
    public int getParentId() {
        return parentId;
    }

    @Override
    public List<ITreeNode> getChildren() {
        return children;
    }

    @Override
    public List<ITreeNode> getAllChildren() {
        if (allChildren.isEmpty()) {
            children.stream().forEach(child -> {
                allChildren.add(child);
                allChildren.addAll(child.getAllChildren());
            });
        }
        return allChildren;
    }

    @Override
    public void addChild(ITreeNode child) {
        children.add(child);
    }

    @Override
    public ITreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(ITreeNode parent) {
        this.parent = parent;
    }
}
